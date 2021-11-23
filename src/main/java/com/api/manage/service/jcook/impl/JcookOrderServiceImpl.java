package com.api.manage.service.jcook.impl;

import com.api.manage.dao.basicArchives.UserResidentDao;
import com.api.manage.service.jcook.JcookOrderService;
import com.api.mapper.jcook.JcookOrderMapper;
import com.api.model.basicArchives.UserResident;
import com.api.model.jcook.entity.JcookOrder;
import com.api.model.jcook.manageDto.ManageJcookCancelOrderDTO;
import com.api.model.jcook.manageDto.ManageJcookOrderSearch;
import com.api.util.PropertyUtils;
import com.api.vo.jcook.manageOrder.ManageJcookOrderVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.example.api.JcookSDK;
import org.example.api.model.OrderCancelRequest;
import org.example.api.model.OrderCancelResponse;
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
public class JcookOrderServiceImpl implements JcookOrderService {
    private static Map<String,Object> map = new HashMap<>();
    @Resource
    JcookOrderMapper jcookOrderMapper;
    @Resource
    UserResidentDao userResidentDao;
    @Value("${jcook.app_key}")
    private String JCOOK_APP_KEY;    //jcook appKey
    @Value("${jcook.app_secret}")
    private String JCOOK_APP_SECRET;    //jcook appSecret
    @Value("${jcook.channel_id}")
    private Integer JCOOK_CHANNEL_ID;    //jcook channelId

    @Override
    public List<ManageJcookOrderVo> list(ManageJcookOrderSearch manageJcookOrderSearch) {
        QueryWrapper<JcookOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(manageJcookOrderSearch.getCode()),"code",manageJcookOrderSearch.getCode());
        queryWrapper.like(StringUtils.isNotBlank(manageJcookOrderSearch.getJcookCode()),"jcook_code",manageJcookOrderSearch.getJcookCode());
        queryWrapper.eq(manageJcookOrderSearch.getTradeStatus() != null,"trade_no",manageJcookOrderSearch.getTradeStatus());

        List<JcookOrder> jcookOrderList = jcookOrderMapper.selectList(queryWrapper);
        ArrayList<ManageJcookOrderVo> manageJcookOrderVoList = new ArrayList<>();
        if (jcookOrderList != null && jcookOrderList.size()>0){
            for (JcookOrder jcookOrder : jcookOrderList) {
                ManageJcookOrderVo manageJcookOrderVo = new ManageJcookOrderVo();
                PropertyUtils.copyProperties(jcookOrder,manageJcookOrderVo);
                UserResident byId = userResidentDao.findById(jcookOrder.getCreateId());
                manageJcookOrderVo.setCreateName(byId.getName());//填入创建人
                manageJcookOrderVoList.add(manageJcookOrderVo);
            }
        }

        return manageJcookOrderVoList;
    }

    @Override
    public Map<String, Object> cancel(ManageJcookCancelOrderDTO manageJcookCancelOrderDTO) {
        map = new HashMap<>();
        JcookOrder jcookOrder = jcookOrderMapper.selectById(manageJcookCancelOrderDTO.getOrderId());
        if (jcookOrder != null){
            JcookSDK jcookSDK = new JcookSDK(JCOOK_APP_KEY, JCOOK_APP_SECRET, JCOOK_CHANNEL_ID);
            OrderCancelRequest orderCancelRequest = new OrderCancelRequest();
            orderCancelRequest.setOrderId(new BigInteger(jcookOrder.getJcookCode()));
            orderCancelRequest.setCancelReasonCode(manageJcookCancelOrderDTO.getCancelReasonCode());//取消原因
            Result<OrderCancelResponse> result = jcookSDK.orderCancel(orderCancelRequest);
            if (result.getCode() != 200){
                map.put("message",result.getMsg());
                map.put("status",false);
                return map;
            }
        }else {
            map.put("message","订单不存在");
            map.put("status",false);
            return map;
        }

        map.put("message","取消成功");
        map.put("status",true);
        return map;
    }
}
