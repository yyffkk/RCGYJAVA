package com.api.manage.service.jcook.impl;

import com.api.manage.service.jcook.JcookRotationService;
import com.api.mapper.jcook.JcookGoodsMapper;
import com.api.mapper.jcook.JcookRotationMapper;
import com.api.model.jcook.entity.JcookGoods;
import com.api.model.jcook.entity.JcookRotation;
import com.api.model.jcook.manageDto.ManageJcookRotationInsertDTO;
import com.api.model.jcook.manageDto.ManageJcookRotationUpdateDTO;
import com.api.util.PropertyUtils;
import com.api.util.UploadUtil;
import com.api.vo.jcook.appGoods.JcookRotationInfoVo;
import com.api.vo.resources.VoResourcesImg;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JcookRotationServiceImpl implements JcookRotationService {
    private static Map<String,Object> map = null;
    @Resource
    JcookRotationMapper jcookRotationMapper;
    @Resource
    JcookGoodsMapper jcookGoodsMapper;

    @Override
    public Map<String, Object> insert(ManageJcookRotationInsertDTO manageJcookRotationInsertDTO) {
        map = new HashMap<>();
        //根据skuId查询是否有该商品
        QueryWrapper<JcookGoods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sku_id",manageJcookRotationInsertDTO.getSkuId());
        JcookGoods jcookGoods = jcookGoodsMapper.selectOne(queryWrapper);
        if (jcookGoods == null){
            map.put("message","该商品不存在");
            map.put("status",false);
            return map;
        }

        JcookRotation jcookRotation = new JcookRotation();
        jcookRotation.setSkuId(manageJcookRotationInsertDTO.getSkuId());//填入初始sku编码

        int insert = jcookRotationMapper.insert(jcookRotation);
        if (insert >0){
            map.put("message","添加成功");
            map.put("status",true);
        }else {
            map.put("message","添加失败");
            map.put("status",false);
        }

        //添加轮播图照片
        UploadUtil uploadUtil = new UploadUtil();
        uploadUtil.saveUrlToDB(manageJcookRotationInsertDTO.getImgUrls(),"jcookRotation",jcookRotation.getId(),"jcookRotationImg","600",30,20);

        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> update(ManageJcookRotationUpdateDTO manageJcookRotationUpdateDTO) {
        map = new HashMap<>();
        try {
            JcookRotation jcookRotation = jcookRotationMapper.selectById(manageJcookRotationUpdateDTO.getId());
            if (jcookRotation == null){
                throw new RuntimeException("记录不存在或已被删除");
            }

            if (manageJcookRotationUpdateDTO.getSkuId() != null){
                jcookRotation.setSkuId(manageJcookRotationUpdateDTO.getSkuId());
                int update = jcookRotationMapper.updateById(jcookRotation);
                if (update <= 0){
                    throw new RuntimeException("修改失败");
                }
            }
            if (manageJcookRotationUpdateDTO.getImgUrls() != null && manageJcookRotationUpdateDTO.getImgUrls().length>0){
                UploadUtil uploadUtil = new UploadUtil();
                //先删除照片信息
                uploadUtil.delete("jcookRotation",manageJcookRotationUpdateDTO.getId(),"jcookRotationImg");
                //再添加照片信息
                uploadUtil.saveUrlToDB(manageJcookRotationUpdateDTO.getImgUrls(),"jcookRotation",manageJcookRotationUpdateDTO.getId(),"jcookRotationImg","600",30,20);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message",e.getMessage());
            map.put("status",false);
            return map;
        }
        map.put("message","修改成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(Integer rotationId) {
        map = new HashMap<>();
        int delete = jcookRotationMapper.deleteById(rotationId);
        if (delete >0){
            map.put("message","删除成功");
            map.put("status",true);
        }else {
            map.put("message","删除失败");
            map.put("status",false);
        }

        //删除轮播图照片
        UploadUtil uploadUtil = new UploadUtil();
        uploadUtil.delete("jcookRotation",rotationId,"jcookRotationImg");

        return map;
    }

    @Override
    public Map<String, Object> findRotationList() {
        map = new HashMap<>();
        QueryWrapper<JcookRotation> queryWrapper = new QueryWrapper<>();
        List<JcookRotation> jcookRotations = jcookRotationMapper.selectList(queryWrapper);
        ArrayList<JcookRotationInfoVo> jcookRotationInfoVoList = new ArrayList<>();
        if (jcookRotations != null && jcookRotations.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (JcookRotation jcookRotation : jcookRotations) {
                JcookRotationInfoVo jcookRotationInfoVo = new JcookRotationInfoVo();
                PropertyUtils.copyProperties(jcookRotation,jcookRotationInfoVo);

                //查询商品主键id
                QueryWrapper<JcookGoods> queryWrapper2 = new QueryWrapper<>();
                queryWrapper2.eq("sku_id",jcookRotationInfoVo.getSkuId());
                JcookGoods jcookGoods = jcookGoodsMapper.selectOne(queryWrapper2);
                if (jcookGoods != null){
                    jcookRotationInfoVo.setJcookGoodsId(jcookGoods.getId());
                }

                //查询轮播图照片信息
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("jcookRotation", jcookRotationInfoVo.getId(), "jcookRotationImg");
                jcookRotationInfoVo.setImgList(imgByDate);

                jcookRotationInfoVoList.add(jcookRotationInfoVo);
            }
        }

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",jcookRotationInfoVoList);
        return map;
    }
}
