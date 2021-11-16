package com.api.app.service.jcook.impl;

import com.api.app.service.jcook.AppJcookShoppingCartService;
import com.api.mapper.jcook.JcookGoodsMapper;
import com.api.mapper.jcook.JcookShoppingCartMapper;
import com.api.model.jcook.dto.DeleteShoppingCartDTO;
import com.api.model.jcook.dto.InsertShoppingCartDTO;
import com.api.model.jcook.dto.UpdateShoppingCartNumDTO;
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

    @Override
    public Map<String, Object> insertShoppingCart(InsertShoppingCartDTO insertShoppingCartDTO) {
        map = new HashMap<>();
        //查询购物车是否有该商品
        QueryWrapper<JcookShoppingCart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("jcook_goods_id",insertShoppingCartDTO.getJcookGoodsId());
        queryWrapper.eq("resident_id",insertShoppingCartDTO.getResidentId());
        JcookShoppingCart jcookShoppingCart = jcookShoppingCartMapper.selectOne(queryWrapper);
        int operation = 0;
        if (jcookShoppingCart != null){
            //对已有商品进行 购买数量加一 操作
            jcookShoppingCart.setNum(jcookShoppingCart.getNum()+1);//进行购买数量加一
            operation = jcookShoppingCartMapper.updateById(jcookShoppingCart);
        }else {
            //添加商品到购物车
            JcookShoppingCart jcookShoppingCart2 = new JcookShoppingCart();
            jcookShoppingCart2.setResidentId(insertShoppingCartDTO.getResidentId());//填入用户主键id
            jcookShoppingCart2.setJcookGoodsId(insertShoppingCartDTO.getJcookGoodsId());//填入商品主键id
            jcookShoppingCart2.setNum(1);//填入购买数量
            operation = jcookShoppingCartMapper.insert(jcookShoppingCart2);
        }
        if (operation > 0){
            map.put("message","加入购物车成功");
            map.put("status",true);
        }else {
            map.put("message","加入购物车失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> updateShoppingCartNum(UpdateShoppingCartNumDTO updateShoppingCartNumDTO) {
        map = new HashMap<>();
        QueryWrapper<JcookShoppingCart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("jcook_goods_id", updateShoppingCartNumDTO.getJcookGoodsId());
        queryWrapper.eq("resident_id",updateShoppingCartNumDTO.getResidentId());
        JcookShoppingCart jcookShoppingCart = new JcookShoppingCart();
        jcookShoppingCart.setNum(updateShoppingCartNumDTO.getNum());//填入商品数量
        int update = jcookShoppingCartMapper.update(jcookShoppingCart, queryWrapper);
        if (update > 0){
            map.put("message","修改成功");
            map.put("status",true);
        }else {
            map.put("message","修改失败");
            map.put("status",false);
        }

        return map;
    }

    @Override
    public Map<String, Object> deleteShoppingCart(DeleteShoppingCartDTO deleteShoppingCartDTO) {
        map = new HashMap<>();
        QueryWrapper<JcookShoppingCart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("jcook_goods_id", deleteShoppingCartDTO.getJcookGoodsId());
        queryWrapper.eq("resident_id",deleteShoppingCartDTO.getResidentId());
        int delete = jcookShoppingCartMapper.delete(queryWrapper);
        if (delete > 0){
            map.put("message","删除成功");
            map.put("status",true);
        }else {
            map.put("message","删除失败");
            map.put("status",false);
        }

        return map;
    }
}
