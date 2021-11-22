package com.api.app.service.jcook.impl;

import com.api.app.service.jcook.AppJcookOrderService;
import com.api.mapper.jcook.JcookOrderListMapper;
import com.api.mapper.jcook.JcookOrderMapper;
import com.api.model.jcook.appDto.JcookOrderSearch;
import com.api.model.jcook.entity.JcookOrder;
import com.api.model.jcook.entity.JcookOrderList;
import com.api.util.PropertyUtils;
import com.api.vo.jcook.appOrder.MyOrderListVo;
import com.api.vo.jcook.appOrder.MyOrderVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AppJcookOrderServiceImpl implements AppJcookOrderService {
    private static Map<String,Object> map = null;
    @Resource
    JcookOrderMapper jcookOrderMapper;
    @Resource
    JcookOrderListMapper jcookOrderListMapper;

    @Override
    public List<MyOrderVo> myOrder(JcookOrderSearch jcookOrderSearch) {
        QueryWrapper<JcookOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("create_id",jcookOrderSearch.getId());
        queryWrapper.eq( jcookOrderSearch.getTradeStatus() != null,"trade_status",jcookOrderSearch.getTradeStatus());
        queryWrapper.like(StringUtils.isNotBlank(jcookOrderSearch.getOrderCode()),"code",jcookOrderSearch.getOrderCode());
        List<JcookOrder> jcookOrderList = jcookOrderMapper.selectList(queryWrapper);
        ArrayList<MyOrderVo> myOrderVoList = new ArrayList<>();
        //查询订单信息
        if (jcookOrderList != null && jcookOrderList.size()>0){
            for (JcookOrder jcookOrder : jcookOrderList) {
                //DO转VO
                MyOrderVo myOrderVo = new MyOrderVo();
                PropertyUtils.copyProperties(jcookOrder,myOrderVo);

                //查询订单详情
                QueryWrapper<JcookOrderList> queryWrapper2 = new QueryWrapper<>();
                queryWrapper2.eq("jcook_order_id",jcookOrder.getId());
                List<JcookOrderList> jcookOrderListList = jcookOrderListMapper.selectList(queryWrapper2);
                ArrayList<MyOrderListVo> myOrderListVoList = new ArrayList<>();
                if (jcookOrderListList != null && jcookOrderListList.size()>0){
                    for (JcookOrderList orderList : jcookOrderListList) {
                        //DO转VO
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
}
