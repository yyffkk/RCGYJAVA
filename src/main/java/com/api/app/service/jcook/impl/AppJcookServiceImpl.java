package com.api.app.service.jcook.impl;

import com.api.app.service.jcook.AppJcookService;
import com.api.mapper.jcook.JcookBrandMapper;
import com.api.mapper.jcook.JcookGoodsMapper;
import com.api.model.jcook.entity.JcookBrand;
import com.api.model.jcook.entity.JcookGoods;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AppJcookServiceImpl implements AppJcookService {
    private static Map<String,Object> map = null;
    @Resource
    JcookGoodsMapper jcookGoodsMapper;
    @Resource
    JcookBrandMapper jcookBrandMapper;


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
}
