package com.api.app.service.jcook.impl;

import com.api.app.service.jcook.AppJcookShoppingCartService;
import com.api.mapper.jcook.JcookGoodsMapper;
import com.api.mapper.jcook.JcookShoppingCartMapper;
import com.api.model.jcook.entity.JcookGoods;
import com.api.model.jcook.entity.JcookShoppingCart;
import com.api.util.PropertyUtils;
import com.api.vo.jcook.appShoppingCart.MyShoppingCartVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppJcookShoppingCartServiceImpl implements AppJcookShoppingCartService {
    private static Map<String,Object> map = null;
    @Resource
    JcookShoppingCartMapper jcookShoppingCartMapper;
    @Resource
    JcookGoodsMapper jcookGoodsMapper;


    @Override
    public Map<String, Object> myShoppingCart(Integer id) {
        map = new HashMap<>();

        QueryWrapper<JcookShoppingCart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("resident_id",id);
        List<JcookShoppingCart> jcookShoppingCartList = jcookShoppingCartMapper.selectList(queryWrapper);
        ArrayList<MyShoppingCartVo> myShoppingCartVoList = new ArrayList<>();
        if (jcookShoppingCartList != null && jcookShoppingCartList.size()>0){
            for (JcookShoppingCart jcookShoppingCart : jcookShoppingCartList) {
                JcookGoods jcookGoods = jcookGoodsMapper.selectById(jcookShoppingCart.getJcookGoodsId());
                MyShoppingCartVo myShoppingCartVo = new MyShoppingCartVo();
                PropertyUtils.copyProperties(jcookGoods,myShoppingCartVo);//填入商品信息
                myShoppingCartVo.setNum(jcookShoppingCart.getNum());//填入购买数量
                myShoppingCartVoList.add(myShoppingCartVo);
            }
        }
        map.put("message","请求成功");
        map.put("data",myShoppingCartVoList);
        map.put("status",true);
        return map;
    }
}
