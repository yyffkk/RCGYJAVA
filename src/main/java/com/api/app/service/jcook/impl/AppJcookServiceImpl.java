package com.api.app.service.jcook.impl;

import com.api.app.service.jcook.AppJcookService;
import com.api.mapper.jcook.JcookBrandMapper;
import com.api.mapper.jcook.JcookCategoryMapper;
import com.api.mapper.jcook.JcookGoodsMapper;
import com.api.model.jcook.dto.RecommendGoodsSearch;
import com.api.model.jcook.entity.JcookBrand;
import com.api.model.jcook.entity.JcookCategory;
import com.api.model.jcook.entity.JcookGoods;
import com.api.util.PropertyUtils;
import com.api.vo.jcook.MaxPopularityVo;
import com.api.vo.jcook.OneCategoryVo;
import com.api.vo.jcook.RecommendGoodsListVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class AppJcookServiceImpl implements AppJcookService {
    private static Map<String,Object> map = null;
    @Resource
    JcookGoodsMapper jcookGoodsMapper;
    @Resource
    JcookBrandMapper jcookBrandMapper;
    @Resource
    JcookCategoryMapper jcookCategoryMapper;


    @Override
    public Map<String, Object> skuTotal() {
        map = new HashMap<>();

        QueryWrapper<JcookGoods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status",1);//1.jcook商品上架
        queryWrapper.eq("shop_status",1);//1.小蜜蜂商品上架
        Integer skuTotal = jcookGoodsMapper.selectCount(queryWrapper);

        map.put("message","请求成功");
        map.put("data",skuTotal);
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> settledBrandsNum() {
        map = new HashMap<>();

        QueryWrapper<JcookBrand> queryWrapper = new QueryWrapper<>();
        Integer settledBrandsNum = jcookBrandMapper.selectCount(queryWrapper);

        map.put("message","请求成功");
        map.put("data",settledBrandsNum);
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> newProductsTodayNum() {
        map = new HashMap<>();
        Date date = new Date();
        //获取当天起始时间和结束时间
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);//当天零点
        LocalDateTime today_end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);//当天零点
        Date dateStart = Date.from(today_start.atZone(ZoneId.systemDefault()).toInstant());//转Date
        Date dateEnd = Date.from(today_end.atZone(ZoneId.systemDefault()).toInstant());//转Date


        QueryWrapper<JcookGoods> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("updated_at",dateStart);
        queryWrapper.le("updated_at",dateEnd);
        Integer newProductsTodayNum = jcookGoodsMapper.selectCount(queryWrapper);

        map.put("message","请求成功");
        map.put("data",newProductsTodayNum);
        map.put("status",true);
        return map;
    }

    @Override
    public List<OneCategoryVo> findAllOneCategory() {
        map = new HashMap<>();
        map.put("parent_id",0);
        List<JcookCategory> jcookCategories = jcookCategoryMapper.selectByMap(map);
        ArrayList<OneCategoryVo> oneCategoryVoList = new ArrayList<>();
        if (jcookCategories != null && jcookCategories.size()>0){
            for (JcookCategory jcookCategory : jcookCategories) {
                OneCategoryVo oneCategoryVo = new OneCategoryVo();
                PropertyUtils.copyProperties(jcookCategory,oneCategoryVo);
                oneCategoryVoList.add(oneCategoryVo);
            }
        }
        return oneCategoryVoList;
    }

    @Override
    public Map<String, Object> findMaxPopularity(int num) {
        map = new HashMap<>();
        QueryWrapper<JcookGoods> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("views_num");
        queryWrapper.last("limit "+num);
        List<JcookGoods> jcookGoods = jcookGoodsMapper.selectList(queryWrapper);
        ArrayList<MaxPopularityVo> maxPopularityVoList = new ArrayList<>();
        if (jcookGoods != null && jcookGoods.size()>0){
            for (JcookGoods jcookGood : jcookGoods) {
                MaxPopularityVo maxPopularityVo = new MaxPopularityVo();
                PropertyUtils.copyProperties(jcookGood,maxPopularityVo);
                maxPopularityVoList.add(maxPopularityVo);
            }
        }

        map.put("message","请求成功");
        map.put("data",maxPopularityVoList);
        map.put("status",true);
        return map;
    }

    @Override
    public List<RecommendGoodsListVo> findRecommendGoodsList(RecommendGoodsSearch recommendGoodsSearch) {
        QueryWrapper<JcookGoods> queryWrapper = new QueryWrapper<>();
        //搜索条件
        //价格排序(1.desc[降序]，2.asc[升序])
        if (recommendGoodsSearch.getOrderByPrice() == 1){//1.降序
            queryWrapper.orderByDesc("sell_price");
        }else if (recommendGoodsSearch.getOrderByPrice() == 2){//2.升序
            queryWrapper.orderByAsc("sell_price");
        }
        //品牌主键id
        queryWrapper.eq(recommendGoodsSearch.getBrandId() != null,"brand_id",recommendGoodsSearch.getBrandId());
        //最小价格～最大价格，闭区间
        queryWrapper.ge(recommendGoodsSearch.getMaxPrice() != null,"sell_price",recommendGoodsSearch.getMinPrice());
        queryWrapper.le(recommendGoodsSearch.getMinPrice() != null,"sell_price",recommendGoodsSearch.getMaxPrice());
        //关键字搜索
        queryWrapper.like(StringUtils.isNotBlank(recommendGoodsSearch.getKeyword()),"sku_name",recommendGoodsSearch.getKeyword());
        List<JcookGoods> jcookGoods = jcookGoodsMapper.selectList(queryWrapper);
        ArrayList<RecommendGoodsListVo> recommendGoodsListVoList = new ArrayList<>();
        if (jcookGoods != null && jcookGoods.size()>0){
            for (JcookGoods jcookGood : jcookGoods) {
                RecommendGoodsListVo recommendGoodsListVo = new RecommendGoodsListVo();
                PropertyUtils.copyProperties(jcookGood,recommendGoodsListVo);
                recommendGoodsListVoList.add(recommendGoodsListVo);
            }
        }

        return recommendGoodsListVoList;
    }


}
