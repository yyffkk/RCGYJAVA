package com.api.app.service.jcook.impl;

import com.api.app.service.jcook.AppJcookShoppingCartService;
import com.api.mapper.jcook.JcookAddressMapper;
import com.api.mapper.jcook.JcookCityMapper;
import com.api.mapper.jcook.JcookGoodsMapper;
import com.api.mapper.jcook.JcookShoppingCartMapper;
import com.api.model.jcook.dto.*;
import com.api.model.jcook.entity.JcookAddress;
import com.api.model.jcook.entity.JcookCity;
import com.api.model.jcook.entity.JcookGoods;
import com.api.model.jcook.entity.JcookShoppingCart;
import com.api.util.PropertyUtils;
import com.api.vo.jcook.appAddress.DefaultAddressVo;
import com.api.vo.jcook.appShoppingCart.MyShoppingCartVo;
import com.api.vo.jcook.appShoppingCart.SettlementShoppingCartVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.api.JcookSDK;
import org.example.api.model.LogisticsFeeRequest;
import org.example.api.model.LogisticsFeeResponse;
import org.example.api.model.LogisticsFeeSkuInfoRequest;
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
public class AppJcookShoppingCartServiceImpl implements AppJcookShoppingCartService {
    private static StringBuilder stringBuilder = null;
    private static Map<String,Object> map = null;
    @Resource
    JcookShoppingCartMapper jcookShoppingCartMapper;
    @Resource
    JcookGoodsMapper jcookGoodsMapper;
    @Resource
    JcookAddressMapper jcookAddressMapper;
    @Resource
    JcookCityMapper jcookCityMapper;
    @Value("${jcook.app_key}")
    private String JCOOK_APP_KEY;    //jcook appKey
    @Value("${jcook.app_secret}")
    private String JCOOK_APP_SECRET;    //jcook appSecret
    @Value("${jcook.channel_id}")
    private Integer JCOOK_CHANNEL_ID;    //jcook channelId

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

    @Override
    public Map<String, Object> settlement(SettlementShoppingCartDTO settlementShoppingCartDTO) {
        map = new HashMap<>();
        SettlementShoppingCartVo settlementShoppingCartVo = new SettlementShoppingCartVo();

        //创建获取运费request
        LogisticsFeeRequest logisticsFeeRequest = new LogisticsFeeRequest();
        //创建运费request-skuInfoList
        ArrayList<LogisticsFeeSkuInfoRequest> logisticsFeeSkuInfoRequestArrayList = new ArrayList<>();
        //订单费用
        BigDecimal orderFee = BigDecimal.ZERO;

        //获取订单商品信息
         ArrayList<MyShoppingCartVo> myShoppingCartVoList = new ArrayList<>();
        List<SettlementGoodsDTO> settlementGoodsDTOList = settlementShoppingCartDTO.getSettlementGoodsDTOList();
        if (settlementGoodsDTOList != null && settlementGoodsDTOList.size()>0){
            for (SettlementGoodsDTO settlementGoodsDTO : settlementGoodsDTOList) {
                JcookGoods jcookGoods = jcookGoodsMapper.selectById(settlementGoodsDTO.getJcookGoodsId());
                MyShoppingCartVo myShoppingCartVo = new MyShoppingCartVo();
                PropertyUtils.copyProperties(jcookGoods,myShoppingCartVo);//填入商品信息
                myShoppingCartVo.setNum(settlementGoodsDTO.getNum());//填入购买数量
                myShoppingCartVoList.add(myShoppingCartVo);

                //创建获取运费request
                LogisticsFeeSkuInfoRequest logisticsFeeSkuInfoRequest = new LogisticsFeeSkuInfoRequest();
                logisticsFeeSkuInfoRequest.setQuantity(settlementGoodsDTO.getNum());//获取购买数量
                logisticsFeeSkuInfoRequest.setSkuId(jcookGoods.getSkuId());//填入sku编码
                logisticsFeeSkuInfoRequest.setSkuPrice(jcookGoods.getSupplyPrice());//填入供货价
                logisticsFeeSkuInfoRequestArrayList.add(logisticsFeeSkuInfoRequest);
                logisticsFeeRequest.setLogisticsFeeSkuInfoRequestList(logisticsFeeSkuInfoRequestArrayList);
                //计算订单费用,对订单费用进行累加
                orderFee = orderFee.add(jcookGoods.getSupplyPrice().multiply(BigDecimal.valueOf(settlementGoodsDTO.getNum())));
            }
        }else {
            map.put("message","未选中结算商品");
            map.put("data",null);
            map.put("status",false);
            return map;
        }
        settlementShoppingCartVo.setMyShoppingCartVoList(myShoppingCartVoList);

        //获取默认地址
        QueryWrapper<JcookAddress> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("resident_id",settlementShoppingCartDTO.getResidentId());//填入用户主键id
        queryWrapper.eq("is_default",1);//1.是默认地址
        JcookAddress jcookAddress = jcookAddressMapper.selectOne(queryWrapper);

        //获取运费
        Double fee = 0.0;
        if (jcookAddress != null){
            //获取默认地址
            DefaultAddressVo defaultAddressVo = new DefaultAddressVo();
            //DO 转 VO
            PropertyUtils.copyProperties(jcookAddress,defaultAddressVo);
            StringBuilder locationName = findCityAddressDetails(true, jcookAddress.getLocation());
            defaultAddressVo.setLocationName(locationName.toString());//填入所在地区名称
            settlementShoppingCartVo.setDefaultAddressVo(defaultAddressVo);

            //计算运费
            logisticsFeeRequest.setAddress(locationName.toString());//填入地址
            logisticsFeeRequest.setOrderFee(orderFee);//填入订单费用
            JcookSDK jcookSDK = new JcookSDK(JCOOK_APP_KEY, JCOOK_APP_SECRET, JCOOK_CHANNEL_ID);
            Result<LogisticsFeeResponse> result = jcookSDK.logisticsFee(logisticsFeeRequest);
            if (result.getCode() != 200){
                map.put("message",result.getMsg());
                map.put("data",null);
                map.put("status",false);
                return map;
            }
            fee = Double.valueOf(result.getData().getFee());
        }
        settlementShoppingCartVo.setFee(fee);

        map.put("message","请求成功");
        map.put("data",settlementShoppingCartVo);
        map.put("status",true);
        return map;
    }

    /**
     * 查询城市地址
     * @param isCreate 是否需要创建了StringBuild对象
     * @param cityAddress 城市地址主键Id
     * @return 城市地址StringBuild对象
     */
    private StringBuilder findCityAddressDetails(boolean isCreate,Integer cityAddress) {
        if (isCreate){
            //创建StringBuild对象
            stringBuilder = new StringBuilder();
        }
        JcookCity jcookCity = jcookCityMapper.selectById(cityAddress);
        if (jcookCity.getParentId() != 0){
            findCityAddressDetails(false,jcookCity.getParentId());//后续循环不需要创建StringBuild对象
            stringBuilder.append(jcookCity.getName()).append(" ");//拼接公司省县市地址
        }

        return stringBuilder;
    }
}
