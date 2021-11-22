package com.api.manage.service.jcook.impl;

import com.api.manage.service.jcook.JcookGoodsService;
import com.api.mapper.jcook.JcookBrandMapper;
import com.api.mapper.jcook.JcookCategoryMapper;
import com.api.mapper.jcook.JcookGoodsMapper;
import com.api.mapper.jcook.JcookShopMapper;
import com.api.model.jcook.entity.JcookBrand;
import com.api.model.jcook.entity.JcookCategory;
import com.api.model.jcook.entity.JcookGoods;
import com.api.model.jcook.entity.JcookShop;
import com.api.model.jcook.manageDto.ManageJcookGoodsSearch;
import com.api.util.PropertyUtils;
import com.api.vo.jcook.manageGoods.ManageJcookGoodsVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class JcookGoodsServiceImpl implements JcookGoodsService {
    @Resource
    JcookGoodsMapper jcookGoodsMapper;
    @Resource
    JcookShopMapper jcookShopMapper;
    @Resource
    JcookBrandMapper jcookBrandMapper;
    @Resource
    JcookCategoryMapper jcookCategoryMapper;

    @Override
    public List<ManageJcookGoodsVo> list(ManageJcookGoodsSearch manageJcookGoodsSearch) {
        QueryWrapper<JcookGoods> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(manageJcookGoodsSearch.getSkuId() != null,"sku_id",manageJcookGoodsSearch.getSkuId());
        queryWrapper.like(StringUtils.isNotBlank(manageJcookGoodsSearch.getSkuName()),"sku_name",manageJcookGoodsSearch.getSkuName());
        queryWrapper.like(StringUtils.isNotBlank(manageJcookGoodsSearch.getVendorName()),"vendor_name",manageJcookGoodsSearch.getVendorName());
        queryWrapper.eq(manageJcookGoodsSearch.getStatus() != null,"status",manageJcookGoodsSearch.getStatus());
        queryWrapper.eq(manageJcookGoodsSearch.getShopStatus()!= null,"shop_status",manageJcookGoodsSearch.getShopStatus());

        List<JcookGoods> jcookGoods = jcookGoodsMapper.selectList(queryWrapper);
        ArrayList<ManageJcookGoodsVo> manageJcookGoodsVoList = new ArrayList<>();
        if (jcookGoods != null && jcookGoods.size()>0){
            for (JcookGoods jcookGood : jcookGoods) {
                ManageJcookGoodsVo manageJcookGoodsVo = new ManageJcookGoodsVo();
                PropertyUtils.copyProperties(jcookGood,manageJcookGoodsVo);

                JcookBrand jcookBrand = jcookBrandMapper.selectById(jcookGood.getBrandId());
                manageJcookGoodsVo.setBrandName(jcookBrand.getBrandName());//填入品牌名称

                JcookShop jcookShop = jcookShopMapper.selectById(jcookGood.getShopId());
                manageJcookGoodsVo.setShopName(jcookShop.getShopName());//填入商铺名称

                JcookCategory jcookCategoryFirst = jcookCategoryMapper.selectById(jcookGood.getCategoryFirstId());
                manageJcookGoodsVo.setCategoryFirstName(jcookCategoryFirst.getName());//填入一级分类名称

                JcookCategory jcookCategorySecond = jcookCategoryMapper.selectById(jcookGood.getCategorySecondId());
                manageJcookGoodsVo.setCategorySecondName(jcookCategorySecond.getName());//填入二级分类名称

                JcookCategory jcookCategoryThird = jcookCategoryMapper.selectById(jcookGood.getCategoryThirdId());
                manageJcookGoodsVo.setCategoryThirdName(jcookCategoryThird.getName());//填入三级分类名称

                manageJcookGoodsVoList.add(manageJcookGoodsVo);
            }
        }
        return manageJcookGoodsVoList;
    }
}
