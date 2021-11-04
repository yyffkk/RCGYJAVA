package com.api.manage.service.jcook.impl;

import com.api.manage.dao.jcook.*;
import com.api.manage.service.jcook.JcookService;
import com.api.model.jcook.entity.*;
import com.api.util.PropertyUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.api.JcookSDK;
import org.example.api.model.*;
import org.example.api.utils.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
    @Resource
    JcookImageMapper jcookImageMapper;
    @Resource
    JcookBigInfoMapper jcookBigInfoMapper;
    @Resource
    JcookSpecificationMapper jcookSpecificationMapper;
    @Resource
    JcookSpecificationAttributeMapper jcookSpecificationAttributeMapper;
    @Resource
    JcookExtAttrMapper jcookExtAttrMapper;

    @Value("${jcook.app_key}")
    private String JCOOK_APP_KEY;    //jcook appKey
    @Value("${jcook.app_secret}")
    private String JCOOK_APP_SECRET;    //jcook appSecret
    @Value("${jcook.channel_id}")
    private Integer JCOOK_CHANNEL_ID;    //jcook channelId


    @Override
    public Map<String, Object> updateJcookShop() {
        map = new HashMap<>();

        boolean flag = true;
        int page = 1;
        while (flag){
            System.out.println("当前页面是:-------  "+page+" -------");
            //获取商品列表
            SkuListRequest skuListRequest = new SkuListRequest();
            skuListRequest.setPage(page);
            skuListRequest.setPageSize(20);
            JcookSDK jcookSDK = new JcookSDK(JCOOK_APP_KEY, JCOOK_APP_SECRET, JCOOK_CHANNEL_ID);
            Result<SkuListResponse> skuListResponse = jcookSDK.skuList(skuListRequest);
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
            System.out.println(skuDetailResponseList.getMsg());
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
                    JcookCategory jcookCategory2 = jcookCategoryMapper.selectOne(queryWrapper2);
                    if (jcookCategory2 == null){
                        //添加一级分类
                        jcookCategory2 = new JcookCategory();
                        jcookCategory2.setName(skuDetailBase.getCategorySecondName());
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
                        jcookCategory3.setName(skuDetailBase.getCategoryThirdName());
                        jcookCategory3.setParentId(jcookCategory2.getId());//默认为0顶层
                        jcookCategory3.setIsShow(1);//默认1.显示
                        jcookCategoryMapper.insert(jcookCategory3);
                    }

                    //最后添加商品
                    JcookGoods jcookGoods = new JcookGoods();
                    //添加商品信息
                    jcookGoods.setSkuId(skuDetailBase.getSkuId());//填入sku编码
                    jcookGoods.setSkuName(skuDetailBase.getSkuName());//填入商品名称
                    jcookGoods.setShopName(skuDetailBase.getShopName());//填入店铺名称
                    jcookGoods.setVendorName(skuDetailBase.getVendorName());//填入供应商名称
                    jcookGoods.setBrandName(skuDetailBase.getBrandName());//填入品牌名称
                    jcookGoods.setCategoryFirstId(jcookCategory.getId());//填入一级分类主键id
                    jcookGoods.setCategorySecondId(jcookCategory2.getId());//填入二级分类主键id
                    jcookGoods.setCategoryThirdId(jcookCategory3.getId());//填入三级分类主键id
                    jcookGoods.setMainPhoto(skuDetailBase.getMainPhoto());//填入主图url
                    if (skuDetailBase.getStatus()){
                        jcookGoods.setStatus(1);//1.上架-jcook商品状态
                    }else {
                        jcookGoods.setStatus(0);//0.下架-jcook商品状态
                    }
                    jcookGoods.setShopStatus(0);//0.下架-小蜜蜂商品状态
                    jcookGoods.setSupplyPrice(new BigDecimal(skuDetailBase.getSupplyPrice()));//填入供货价
                    jcookGoods.setGuidePrice(new BigDecimal(skuDetailBase.getGuidePrice()));//填入指导价
                    jcookGoods.setModel(skuDetailBase.getModel());//填入型号
                    jcookGoods.setTax(skuDetailBase.getTax());//填入税率
                    if (skuDetailBase.getYn()){
                        jcookGoods.setYn(1);//填入1.有效
                    }else {
                        jcookGoods.setYn(0);//填入0.无效
                    }
                    jcookGoods.setUnit(skuDetailBase.getUnit());//填入商品单位
                    jcookGoods.setUpdatedAt(skuDetailBase.getUpdatedAt());//填入更新时间
                    jcookGoods.setColor(skuDetailBase.getColor());//填入颜色
                    jcookGoods.setWarranty(skuDetailBase.getWarranty());//填入质保
                    jcookGoods.setShelfLife(skuDetailBase.getShelfLife());//填入质保天数
                    jcookGoods.setDelivery(skuDetailBase.getDelivery());//填入发货地址
                    jcookGoods.setPlaceOfProduction(skuDetailBase.getPlaceOfProduction());//填入产地
                    jcookGoods.setKind(skuDetailBase.getKind());//填入商品类别，0=未知 1=自营 2=其他
                    jcookGoods.setLength(skuDetailBase.getLength());//填入长（毫米）
                    jcookGoods.setWidth(skuDetailBase.getWidth());//填入宽（毫米）
                    jcookGoods.setHeight(skuDetailBase.getHeight());//填入高（毫米）
                    jcookGoods.setWeight(skuDetailBase.getWeight());//填入重量（千克）
                    jcookGoodsMapper.insert(jcookGoods);

                    //添加image列表
                    List<SkuDetailsImagesResponse> images = datum.getImages();
                    if (images != null && images.size() > 0){
                        for (SkuDetailsImagesResponse image : images) {
                            JcookImage jcookImage = new JcookImage();
                            jcookImage.setJcookGoodsId(jcookGoods.getId());//填入jcook商品主键id
                            jcookImage.setUrl(image.getUrl());//填入图片路由地址
                            if (image.getIsPrimer()){
                                jcookImage.setIsPrimer(1);//1.是主图
                            }else {
                                jcookImage.setIsPrimer(0);//0.不是主图
                            }
                            jcookImage.setOrderSort(image.getOrderSort());//填入图片排序
                            jcookImageMapper.insert(jcookImage);
                        }
                    }

                    //添加bigInfo大图信息
                    SkuDetailBigInfoResponse bigInfo = datum.getBigInfo();
                    if (bigInfo != null){
                        JcookBigInfo jcookBigInfo = new JcookBigInfo();
                        jcookBigInfo.setJcookGoodsId(jcookGoods.getId());//填入jcook商品主键id
                        jcookBigInfo.setPcWdis(bigInfo.getPcWdis());//填入pc端商品介绍（使用该字段）
                        jcookBigInfo.setPcJsContent(bigInfo.getPcJsContent());//填入pc js 内容（可能为空）
                        jcookBigInfo.setPcCssContent(bigInfo.getPcCssContent());//填入pc css 样式（可能为空）
                        jcookBigInfo.setPcHtmlContent(bigInfo.getPcHtmlContent());//填入pc html 内容（可能为空）
                        jcookBigInfoMapper.insert(jcookBigInfo);
                    }

                    //添加specification 规格参数
                    List<SkuDetailSpecificationResponse> specification = datum.getSpecification();
                    if (specification != null && specification.size()>0){
                        for (SkuDetailSpecificationResponse skuDetailSpecificationResponse : specification) {
                            JcookSpecification jcookSpecification = new JcookSpecification();
                            jcookSpecification.setJcookGoodsId(jcookGoods.getId());//填入jcook商品主键id
                            jcookSpecification.setGroupName(skuDetailSpecificationResponse.getGroupName());//填入组名
                            //添加jcook主体规格参数组
                            jcookSpecificationMapper.insert(jcookSpecification);

                            List<SkuDetailSpecificationAttributeResponse> attribute = skuDetailSpecificationResponse.getAttribute();
                            if (attribute != null && attribute.size()>0){
                                for (SkuDetailSpecificationAttributeResponse skuDetailSpecificationAttributeResponse : attribute) {
                                    JcookSpecificationAttribute jcookSpecificationAttribute = new JcookSpecificationAttribute();
                                    jcookSpecificationAttribute.setJcookSpecificationId(jcookSpecification.getId());//填入规格参数主体主键id
                                    jcookSpecificationAttribute.setName(skuDetailSpecificationAttributeResponse.getName());//填入键
                                    jcookSpecificationAttribute.setValue(skuDetailSpecificationAttributeResponse.getValue());//填入值
                                    //添加jcook主体规格参数详情
                                    jcookSpecificationAttributeMapper.insert(jcookSpecificationAttribute);
                                }
                            }
                        }
                    }

                    //添加attribute 列表
                    List<SkuDetailExtAttrResponse> extAttr = datum.getExtAttr();
                    if (extAttr != null && extAttr.size()>0){
                        for (SkuDetailExtAttrResponse skuDetailExtAttrResponse : extAttr) {
                            JcookExtAttr jcookExtAttr = new JcookExtAttr();
                            jcookExtAttr.setJcookGoodsId(jcookGoods.getId());//填入jcook商品主键id
                            jcookExtAttr.setName(skuDetailExtAttrResponse.getName());//填入键
                            jcookExtAttr.setValue(skuDetailExtAttrResponse.getValue());//填入值
                            jcookExtAttrMapper.insert(jcookExtAttr);
                        }
                    }


                }
            }else {
                //跳出循环
                flag = false;
            }
            //进入下一页数据
            page += 1;
        }


        map.put("message","更新成功");
        map.put("status",true);
        return map;
    }
}
