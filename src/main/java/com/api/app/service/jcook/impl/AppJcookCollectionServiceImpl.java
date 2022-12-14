package com.api.app.service.jcook.impl;

import com.api.app.service.jcook.AppJcookCollectionService;
import com.api.mapper.jcook.JcookCollectionMapper;
import com.api.mapper.jcook.JcookGoodsMapper;
import com.api.model.jcook.appDto.CollectionDTO;
import com.api.model.jcook.entity.JcookCollection;
import com.api.model.jcook.entity.JcookGoods;
import com.api.util.PropertyUtils;
import com.api.vo.jcook.appCollection.MyCollectionVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppJcookCollectionServiceImpl implements AppJcookCollectionService {
    private static Map<String,Object> map = null;
    @Resource
    JcookCollectionMapper jcookCollectionMapper;
    @Resource
    JcookGoodsMapper jcookGoodsMapper;

    @Override
    public Map<String, Object> myCollection(Integer id) {
        map = new HashMap<>();
        QueryWrapper<JcookCollection> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("resident_id",id);
        List<JcookCollection> jcookCollections = jcookCollectionMapper.selectList(queryWrapper);
        ArrayList<MyCollectionVo> myCollectionVos = new ArrayList<>();
        if (jcookCollections != null && jcookCollections.size()>0){
            for (JcookCollection jcookCollection : jcookCollections) {
                JcookGoods jcookGoods = jcookGoodsMapper.selectById(jcookCollection.getJcookGoodsId());
                MyCollectionVo myCollectionVo = new MyCollectionVo();
                PropertyUtils.copyProperties(jcookGoods,myCollectionVo);
                myCollectionVos.add(myCollectionVo);
            }
        }

        map.put("message","请求成功");
        map.put("data",myCollectionVos);
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> collection(CollectionDTO collectionDTO) {
        map = new HashMap<>();
        //查询商品是否收藏
        QueryWrapper<JcookCollection> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("jcook_goods_id",collectionDTO.getJcookGoodsId());
        queryWrapper.eq("resident_id",collectionDTO.getId());
        JcookCollection jcookCollection2 = jcookCollectionMapper.selectOne(queryWrapper);
        String msg = "";
        int operation = 0;
        if (jcookCollection2 != null){
            //取消收藏
            operation = jcookCollectionMapper.deleteById(jcookCollection2.getId());
            msg = "取消收藏";
        }else {
            //添加收藏
            JcookCollection jcookCollection = new JcookCollection();
            jcookCollection.setJcookGoodsId(collectionDTO.getJcookGoodsId());//填入商品主键id
            jcookCollection.setResidentId(collectionDTO.getId());//填入用户主键id
            operation = jcookCollectionMapper.insert(jcookCollection);
            msg = "添加收藏";
        }
        if (operation > 0){
            map.put("message",msg+"成功");
            map.put("status",true);
        }else {
            map.put("message",msg+"失败");
            map.put("status",false);
        }

        return map;
    }
}
