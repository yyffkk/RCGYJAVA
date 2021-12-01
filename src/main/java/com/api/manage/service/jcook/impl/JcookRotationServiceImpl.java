package com.api.manage.service.jcook.impl;

import com.api.manage.service.jcook.JcookRotationService;
import com.api.mapper.jcook.JcookRotationMapper;
import com.api.model.jcook.entity.JcookRotation;
import com.api.model.jcook.manageDto.ManageJcookRotationUpdateDTO;
import com.api.util.UploadUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Service
public class JcookRotationServiceImpl implements JcookRotationService {
    private static Map<String,Object> map = null;
    @Resource
    JcookRotationMapper jcookRotationMapper;

    @Override
    public Map<String, Object> insert() {
        map = new HashMap<>();
        JcookRotation jcookRotation = new JcookRotation();
        jcookRotation.setSkuId(new BigInteger("0"));//初始sku编码为0

        int insert = jcookRotationMapper.insert(jcookRotation);
        if (insert >0){
            map.put("message","添加成功");
            map.put("status",true);
        }else {
            map.put("message","添加失败");
            map.put("status",false);
        }
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
}
