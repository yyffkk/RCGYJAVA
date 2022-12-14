package com.api.app.service.jcook.impl;

import com.api.app.service.jcook.AppJcookOrderService;
import com.api.mapper.jcook.JcookOrderListMapper;
import com.api.mapper.jcook.JcookOrderMapper;
import com.api.model.jcook.appDto.AppDeleteDTO;
import com.api.model.jcook.appDto.AppJcookCancelOrderDTO;
import com.api.model.jcook.appDto.AppJcookConfirmDTO;
import com.api.model.jcook.appDto.JcookOrderSearch;
import com.api.model.jcook.entity.JcookOrder;
import com.api.model.jcook.entity.JcookOrderList;
import com.api.util.PropertyUtils;
import com.api.vo.jcook.appOrder.MyOrderListVo;
import com.api.vo.jcook.appOrder.MyOrderVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.example.api.JcookSDK;
import org.example.api.model.*;
import org.example.api.utils.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppJcookOrderServiceImpl implements AppJcookOrderService {
    private static Map<String,Object> map = null;
    @Resource
    JcookOrderMapper jcookOrderMapper;
    @Resource
    JcookOrderListMapper jcookOrderListMapper;
    @Value("${jcook.app_key}")
    private String JCOOK_APP_KEY;    //jcook appKey
    @Value("${jcook.app_secret}")
    private String JCOOK_APP_SECRET;    //jcook appSecret
    @Value("${jcook.channel_id}")
    private Integer JCOOK_CHANNEL_ID;    //jcook channelId

    @Override
    public List<MyOrderVo> myOrder(JcookOrderSearch jcookOrderSearch) {
        QueryWrapper<JcookOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("create_id",jcookOrderSearch.getId());
        queryWrapper.eq( jcookOrderSearch.getTradeStatus() != null,"trade_status",jcookOrderSearch.getTradeStatus());
        queryWrapper.like(StringUtils.isNotBlank(jcookOrderSearch.getOrderCode()),"code",jcookOrderSearch.getOrderCode());
        queryWrapper.orderByDesc("create_date");
        queryWrapper.eq("app_delete",1);//?????????????????????????????????
        queryWrapper.ne("trade_status",10);//10.????????????
        queryWrapper.ne("trade_status",11);//11.????????????
        List<JcookOrder> jcookOrderList = jcookOrderMapper.selectList(queryWrapper);
        ArrayList<MyOrderVo> myOrderVoList = new ArrayList<>();
        //??????????????????
        if (jcookOrderList != null && jcookOrderList.size()>0){
            for (JcookOrder jcookOrder : jcookOrderList) {
                //DO???VO
                MyOrderVo myOrderVo = new MyOrderVo();
                PropertyUtils.copyProperties(jcookOrder,myOrderVo);

                //??????????????????
                QueryWrapper<JcookOrderList> queryWrapper2 = new QueryWrapper<>();
                queryWrapper2.eq("jcook_order_id",jcookOrder.getId());
                List<JcookOrderList> jcookOrderListList = jcookOrderListMapper.selectList(queryWrapper2);
                ArrayList<MyOrderListVo> myOrderListVoList = new ArrayList<>();
                if (jcookOrderListList != null && jcookOrderListList.size()>0){
                    for (JcookOrderList orderList : jcookOrderListList) {
                        //DO???VO
                        MyOrderListVo myOrderListVo = new MyOrderListVo();
                        PropertyUtils.copyProperties(orderList,myOrderListVo);
                        myOrderListVoList.add(myOrderListVo);
                    }
                }
                myOrderVo.setMyOrderListVoList(myOrderListVoList);
                myOrderVoList.add(myOrderVo);
            }
        }

        return myOrderVoList;
    }

    @Override
    public Map<String, Object> cancel(AppJcookCancelOrderDTO appJcookCancelOrderDTO) {
        map = new HashMap<>();
        JcookOrder jcookOrder = jcookOrderMapper.selectById(appJcookCancelOrderDTO.getOrderId());
        if (jcookOrder != null){
            //????????????????????????????????????
            if (jcookOrder.getTradeStatus() == 0){//0.????????????????????????????????????????????????
                //????????????????????????????????????
                jcookOrder.setTradeStatus(9);//??????????????????
                int update = jcookOrderMapper.updateById(jcookOrder);
                if (update >0){
                    map.put("message","????????????");
                    map.put("status",true);
                }else {
                    map.put("message","????????????");
                    map.put("status",false);
                }
                return map;
            }
            //????????????????????????jcook??????????????????
            JcookSDK jcookSDK = new JcookSDK(JCOOK_APP_KEY, JCOOK_APP_SECRET, JCOOK_CHANNEL_ID);
            OrderCancelRequest orderCancelRequest = new OrderCancelRequest();
            orderCancelRequest.setOrderId(new BigInteger(jcookOrder.getJcookCode()));
            orderCancelRequest.setCancelReasonCode(appJcookCancelOrderDTO.getCancelReasonCode());//????????????
            Result<OrderCancelResponse> result = jcookSDK.orderCancel(orderCancelRequest);
            if (result.getCode() != 200){
                map.put("message",result.getMsg());
                map.put("status",false);
                return map;
            }
        }else {
            map.put("message","???????????????");
            map.put("status",false);
            return map;
        }

        map.put("message","????????????");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> appDelete(AppDeleteDTO appDelete) {
        map = new HashMap<>();

        JcookOrder jcookOrder = jcookOrderMapper.selectById(appDelete.getOrderId());

        if (jcookOrder != null && jcookOrder.getCreateId() == appDelete.getId()){
            jcookOrder.setAppDelete(0);//0.???????????????
            //??????????????????????????????
            int update = jcookOrderMapper.updateById(jcookOrder);
            if (update >0){
                map.put("message","????????????");
                map.put("status",true);
            }else {
                map.put("message","????????????");
                map.put("status",false);
            }
        }else {
            map.put("message","???????????????");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> findLogistics(Integer orderId) {
        map = new HashMap<>();

        JcookOrder jcookOrder = jcookOrderMapper.selectById(orderId);

        if (jcookOrder != null){
            JcookSDK jcookSDK = new JcookSDK(JCOOK_APP_KEY, JCOOK_APP_SECRET, JCOOK_CHANNEL_ID);
            LogisticsTraceRequest logisticsTraceRequest = new LogisticsTraceRequest();
            logisticsTraceRequest.setOrderId(new BigInteger(jcookOrder.getJcookCode()));//??????jcook????????????
            Result<List<LogisticsTraceResponse>> result = jcookSDK.logisticsTrace(logisticsTraceRequest);
            if (result.getCode() != 200){
                map.put("message",result.getMsg());
                map.put("data",null);
                map.put("status",false);
            }else {
                map.put("message","????????????");
                map.put("data",result.getData());
                map.put("status",true);
            }
        }else {
            map.put("message","???????????????");
            map.put("data",null);
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> confirm(AppJcookConfirmDTO appJcookConfirmDTO) {
        map = new HashMap<>();
        JcookOrder jcookOrder = jcookOrderMapper.selectById(appJcookConfirmDTO.getOrderId());

        if (jcookOrder != null && jcookOrder.getCreateId() == appJcookConfirmDTO.getId()){
            //????????????
            JcookSDK jcookSDK = new JcookSDK(JCOOK_APP_KEY, JCOOK_APP_SECRET, JCOOK_CHANNEL_ID);
            OrderConfirmRequest orderConfirmRequest = new OrderConfirmRequest();
            orderConfirmRequest.setOrderId(new BigInteger(jcookOrder.getJcookCode()));
            orderConfirmRequest.setClientIp("127.0.0.1");
            orderConfirmRequest.setClientPort("3306");
            Result<String> result = jcookSDK.orderConfirm(orderConfirmRequest);
            if (result.getCode() != 200){
                map.put("message",result.getMsg());
                map.put("status",false);
                return map;
            }
        }else {
            map.put("message","???????????????");
            map.put("status",false);
            return map;
        }

        map.put("message","??????????????????");
        map.put("status",true);
        return map;
    }
}
