package com.api.manage.service.jcook.impl;

import com.api.manage.dao.jcook.JcookBigInfoMapper;
import com.api.manage.dao.jcook.JcookCategoryMapper;
import com.api.manage.dao.jcook.JcookGoodsMapper;
import com.api.manage.service.jcook.JcookService;
import com.api.model.jcook.entity.JcookCategory;
import com.api.model.jcook.entity.JcookGoods;
import com.api.util.PropertyUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.api.JcookSDK;
import org.example.api.model.*;
import org.example.api.utils.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JcookServiceImpl implements JcookService {
    private static Map<String,Object> map = null;
    @Resource
    JcookCategoryMapper jcookCategoryMapper;
    @Resource
    JcookGoodsMapper jcookGoodsMapper;
    @Value("${jcook.app_key}")
    private String JCOOK_APP_KEY;    //jcook appKey
    @Value("${jcook.app_secret}")
    private String JCOOK_APP_SECRET;    //jcook appSecret
    @Value("${jcook.channel_id}")
    private Integer JCOOK_CHANNEL_ID;    //jcook channelId


    @Override
    public Map<String, Object> updateJcookShop() {
        map = new HashMap<>();

        //获取商品列表
        SkuListRequest skuListRequest = new SkuListRequest();
        skuListRequest.setPage(1);
        skuListRequest.setPageSize(1);
        JcookSDK jcookSDK = new JcookSDK(JCOOK_APP_KEY, JCOOK_APP_SECRET, JCOOK_CHANNEL_ID);
        Result<SkuListResponse> skuListResponse = jcookSDK.skuList(skuListRequest);
        System.out.println(skuListResponse);
        List<SkuListInfoResponse> entries = skuListResponse.getData().getEntries();
        ArrayList<Integer> ids = new ArrayList<>();
        if (entries != null && entries.size()>0) {
            for (SkuListInfoResponse entry : entries) {
                ids.add(entry.getSkuId());
            }
        }
        //获取商品详情
        SkuDetailRequest skuDetailRequest = new SkuDetailRequest();
        skuDetailRequest.setSkuIdSet(ids);
        Result<List<SkuDetailResponse>> skuDetailResponseList = jcookSDK.skuDetail(skuDetailRequest);
        List<SkuDetailResponse> data = skuDetailResponseList.getData();
        System.out.println(skuDetailResponseList);
        if (data != null && data.size()>0){
            //取数据进数据库
            for (SkuDetailResponse datum : data) {
                //获取skuBase 基础信息
                SkuDetailBaseResponse skuDetailBase = datum.getSkuDetailBase();
                //先判断数据库内是否有一级分类，如果没有就添加，有就略过
                QueryWrapper<JcookCategory> queryWrapper1 = new QueryWrapper<>();
                queryWrapper1.eq("name",skuDetailBase.getCategoryFirstName());
                queryWrapper1.eq("parent_id",0);
                JcookCategory jcookCategory = jcookCategoryMapper.selectOne(queryWrapper1);
                if (jcookCategory == null){
                    //添加一级分类
                    jcookCategory = new JcookCategory();
                    jcookCategory.setName(skuDetailBase.getCategoryFirstName());
                    jcookCategory.setParentId(0);//默认为0顶层
                    jcookCategory.setIsShow(1);//默认1.显示
                    jcookCategoryMapper.insert(jcookCategory);
                }

                //再判断数据库内是否有二级分类，如果没有就添加，有就略过
                QueryWrapper<JcookCategory> queryWrapper2 = new QueryWrapper<>();
                queryWrapper2.eq("name",skuDetailBase.getCategorySecondName());
                queryWrapper2.eq("parent_id",jcookCategory.getId());
                JcookCategory jcookCategory2 = jcookCategoryMapper.selectOne(queryWrapper1);
                if (jcookCategory2 == null){
                    //添加一级分类
                    jcookCategory2 = new JcookCategory();
                    jcookCategory2.setName(skuDetailBase.getCategoryFirstName());
                    jcookCategory2.setParentId(jcookCategory.getId());//默认为0顶层
                    jcookCategory2.setIsShow(1);//默认1.显示
                    jcookCategoryMapper.insert(jcookCategory2);
                }

                //然后判断数据库内是否有三级分类，如果没有就添加，有就略过
                QueryWrapper<JcookCategory> queryWrapper3 = new QueryWrapper<>();
                queryWrapper3.eq("name",skuDetailBase.getCategoryThirdName());
                queryWrapper3.eq("parent_id",jcookCategory2.getId());
                JcookCategory jcookCategory3 = jcookCategoryMapper.selectOne(queryWrapper3);
                if (jcookCategory3 == null){
                    //添加一级分类
                    jcookCategory3 = new JcookCategory();
                    jcookCategory3.setName(skuDetailBase.getCategoryFirstName());
                    jcookCategory3.setParentId(jcookCategory2.getId());//默认为0顶层
                    jcookCategory3.setIsShow(1);//默认1.显示
                    jcookCategoryMapper.insert(jcookCategory3);
                }

                //最后添加商品
                JcookGoods jcookGoods = new JcookGoods();
                //TODO 数据有误
                PropertyUtils.copyProperties(jcookGoods,skuDetailBase);
                jcookGoods.setCategoryFirstId(jcookCategory.getId());
                jcookGoods.setCategorySecondId(jcookCategory2.getId());
                jcookGoods.setCategoryThirdId(jcookCategory3.getId());
                jcookGoodsMapper.insert(jcookGoods);
            }
        }

        map.put("message","更新成功");
        map.put("status",true);
        return map;
    }
}
