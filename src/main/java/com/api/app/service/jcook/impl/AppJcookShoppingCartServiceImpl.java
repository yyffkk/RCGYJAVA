package com.api.app.service.jcook.impl;

import com.api.app.service.jcook.AppJcookShoppingCartService;
import com.api.mapper.jcook.JcookAddressMapper;
import com.api.mapper.jcook.JcookCityMapper;
import com.api.mapper.jcook.JcookGoodsMapper;
import com.api.mapper.jcook.JcookShoppingCartMapper;
import com.api.model.jcook.appDto.*;
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
import org.example.api.model.*;
import org.example.api.utils.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
                PropertyUtils.copyProperties(jcookGoods,myShoppingCartVo);//??????????????????
                myShoppingCartVo.setNum(jcookShoppingCart.getNum());//??????????????????
                myShoppingCartVoList.add(myShoppingCartVo);
            }
        }
        map.put("message","????????????");
        map.put("data",myShoppingCartVoList);
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> insertShoppingCart(InsertShoppingCartDTO insertShoppingCartDTO) {
        map = new HashMap<>();
        //?????????????????????????????????
        QueryWrapper<JcookShoppingCart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("jcook_goods_id",insertShoppingCartDTO.getJcookGoodsId());
        queryWrapper.eq("resident_id",insertShoppingCartDTO.getResidentId());
        JcookShoppingCart jcookShoppingCart = jcookShoppingCartMapper.selectOne(queryWrapper);
        int operation = 0;
        if (jcookShoppingCart != null){
            if (jcookShoppingCart.getNum() >= 10){
                map.put("message","???????????????????????????10???????????????????????????");
                map.put("status",false);
                return map;
            }
            //????????????????????? ?????????????????? ??????
            jcookShoppingCart.setNum(jcookShoppingCart.getNum()+1);//????????????????????????
            operation = jcookShoppingCartMapper.updateById(jcookShoppingCart);
        }else {
            //????????????????????????
            JcookShoppingCart jcookShoppingCart2 = new JcookShoppingCart();
            jcookShoppingCart2.setResidentId(insertShoppingCartDTO.getResidentId());//??????????????????id
            jcookShoppingCart2.setJcookGoodsId(insertShoppingCartDTO.getJcookGoodsId());//??????????????????id
            jcookShoppingCart2.setNum(1);//??????????????????
            operation = jcookShoppingCartMapper.insert(jcookShoppingCart2);
        }
        if (operation > 0){
            map.put("message","?????????????????????");
            map.put("status",true);
        }else {
            map.put("message","?????????????????????");
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
        jcookShoppingCart.setNum(updateShoppingCartNumDTO.getNum());//??????????????????
        int update = jcookShoppingCartMapper.update(jcookShoppingCart, queryWrapper);
        if (update > 0){
            map.put("message","????????????");
            map.put("status",true);
        }else {
            map.put("message","????????????");
            map.put("status",false);
        }

        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> deleteShoppingCart(DeleteShoppingCartDTO deleteShoppingCartDTO) {
        map = new HashMap<>();
        try {
            int[] jcookGoodsIds = deleteShoppingCartDTO.getJcookGoodsIds();
            for (int jcookGoodsId : jcookGoodsIds) {
                QueryWrapper<JcookShoppingCart> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("jcook_goods_id",jcookGoodsId);
                queryWrapper.eq("resident_id",deleteShoppingCartDTO.getResidentId());
                int delete = jcookShoppingCartMapper.delete(queryWrapper);
                if (delete <= 0){
                    throw new RuntimeException("????????????");
                }
            }
        } catch (Exception e) {
            //?????????????????????
            String message = e.getMessage();
            e.printStackTrace();
            //??????????????????
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message",message);
            map.put("status",false);
            return map;
        }
        map.put("message","????????????");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> settlement(SettlementShoppingCartDTO settlementShoppingCartDTO) {
        map = new HashMap<>();
        JcookSDK jcookSDK = new JcookSDK(JCOOK_APP_KEY, JCOOK_APP_SECRET, JCOOK_CHANNEL_ID);
        SettlementShoppingCartVo settlementShoppingCartVo = new SettlementShoppingCartVo();

        //??????????????????request
        LogisticsFeeRequest logisticsFeeRequest = new LogisticsFeeRequest();
        //????????????request-skuInfoList
        ArrayList<LogisticsFeeSkuInfoRequest> logisticsFeeSkuInfoRequestArrayList = new ArrayList<>();
        //????????????
        BigDecimal orderFee = BigDecimal.ZERO;

        //??????????????????
        JcookAddress jcookAddress = null;
        if (settlementShoppingCartDTO.getAddressId() == null){
            //??????????????????id???null????????????????????????
            //??????????????????
            QueryWrapper<JcookAddress> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("resident_id",settlementShoppingCartDTO.getResidentId());//??????????????????id
            queryWrapper.eq("is_default",1);//1.???????????????
            jcookAddress = jcookAddressMapper.selectOne(queryWrapper);
        }else {
            //??????????????????id??????????????????
            jcookAddress = jcookAddressMapper.selectById(settlementShoppingCartDTO.getAddressId());
        }

        //????????????????????????
         ArrayList<MyShoppingCartVo> myShoppingCartVoList = new ArrayList<>();
        List<SettlementGoodsDTO> settlementGoodsDTOList = settlementShoppingCartDTO.getSettlementGoodsDTOList();
        if (settlementGoodsDTOList != null && settlementGoodsDTOList.size()>0){
            for (SettlementGoodsDTO settlementGoodsDTO : settlementGoodsDTOList) {
                JcookGoods jcookGoods = jcookGoodsMapper.selectById(settlementGoodsDTO.getJcookGoodsId());
                MyShoppingCartVo myShoppingCartVo = new MyShoppingCartVo();
                PropertyUtils.copyProperties(jcookGoods,myShoppingCartVo);//??????????????????
                myShoppingCartVo.setNum(settlementGoodsDTO.getNum());//??????????????????
                myShoppingCartVoList.add(myShoppingCartVo);

                //??????????????????request
                LogisticsFeeSkuInfoRequest logisticsFeeSkuInfoRequest = new LogisticsFeeSkuInfoRequest();
                logisticsFeeSkuInfoRequest.setQuantity(settlementGoodsDTO.getNum());//??????????????????
                logisticsFeeSkuInfoRequest.setSkuId(jcookGoods.getSkuId());//??????sku??????
                logisticsFeeSkuInfoRequest.setSkuPrice(jcookGoods.getSupplyPrice());//???????????????
                logisticsFeeSkuInfoRequestArrayList.add(logisticsFeeSkuInfoRequest);
                logisticsFeeRequest.setLogisticsFeeSkuInfoRequestList(logisticsFeeSkuInfoRequestArrayList);
                //??????????????????,???????????????????????????
                orderFee = orderFee.add(jcookGoods.getSupplyPrice().multiply(BigDecimal.valueOf(settlementGoodsDTO.getNum())));

                //?????????????????????
                if (jcookAddress != null){//???????????????????????????
                    StringBuilder location = findCityAddressDetails(true, jcookAddress.getLocation());

                    //???????????????????????? ??????????????????(1.?????????0.??????)
                    StockDetailSkuQuantityRequest stockDetailSkuQuantityRequest = new StockDetailSkuQuantityRequest();
                    stockDetailSkuQuantityRequest.setSkuId(jcookGoods.getSkuId());//??????????????????
                    stockDetailSkuQuantityRequest.setQuantity(settlementGoodsDTO.getNum());//??????????????????
                    ArrayList<StockDetailSkuQuantityRequest> stockDetailSkuQuantityRequestList = new ArrayList<>();
                    stockDetailSkuQuantityRequestList.add(stockDetailSkuQuantityRequest);

                    StockDetailRequest stockDetailRequest = new StockDetailRequest();
                    stockDetailRequest.setAddress(location.toString()+" "+jcookAddress.getAddressDetail());//????????????
                    stockDetailRequest.setSkuList(stockDetailSkuQuantityRequestList);//??????list??????
                    Result<List<StockDetailResponse>> stockDetail = jcookSDK.stockDetail(stockDetailRequest);
                    Integer stockState = stockDetail.getData().get(0).getStockState();
                    myShoppingCartVo.setStockStatus(stockState);//??????????????????,0.?????????1.??????
                }else {
                    //????????????????????????,????????????
                    myShoppingCartVo.setStockStatus(0);//0.??????
                }
            }
        }else {
            map.put("message","?????????????????????");
            map.put("data",null);
            map.put("status",false);
            return map;
        }
        settlementShoppingCartVo.setMyShoppingCartVoList(myShoppingCartVoList);

        //????????????
        Double fee = 0.0;
        if (jcookAddress != null){
            //??????????????????
            DefaultAddressVo defaultAddressVo = new DefaultAddressVo();
            //DO ??? VO
            PropertyUtils.copyProperties(jcookAddress,defaultAddressVo);
            StringBuilder locationName = findCityAddressDetails(true, jcookAddress.getLocation());
            defaultAddressVo.setLocationName(locationName.toString());//????????????????????????
            settlementShoppingCartVo.setDefaultAddressVo(defaultAddressVo);

            //????????????
            logisticsFeeRequest.setAddress(locationName.toString());//????????????
            logisticsFeeRequest.setOrderFee(orderFee);//??????????????????
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

        map.put("message","????????????");
        map.put("data",settlementShoppingCartVo);
        map.put("status",true);
        return map;
    }

    /**
     * ??????????????????
     * @param isCreate ?????????????????????StringBuild??????
     * @param cityAddress ??????????????????Id
     * @return ????????????StringBuild??????
     */
    private StringBuilder findCityAddressDetails(boolean isCreate,Integer cityAddress) {
        if (isCreate){
            //??????StringBuild??????
            stringBuilder = new StringBuilder();
        }
        JcookCity jcookCity = jcookCityMapper.selectById(cityAddress);
        if (jcookCity.getParentId() != 0){
            findCityAddressDetails(false,jcookCity.getParentId());//???????????????????????????StringBuild??????
            stringBuilder.append(jcookCity.getName()).append(" ");//???????????????????????????
        }

        return stringBuilder;
    }
}
