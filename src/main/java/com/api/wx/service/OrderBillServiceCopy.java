package com.api.wx.service;


import com.api.wx.entity.OrderBill;
import com.api.wx.mapper.OrderBillMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * @author leone
 * @since 2019-04-23
 **/
@Service
public class OrderBillServiceCopy {

    @Resource
    private OrderBillMapper orderBillMapper;

    /**
     * 保存订单流水
     * @param orderBill
     * @return
     */
    public int save(OrderBill orderBill) {
        return orderBillMapper.save(orderBill);
    }

}
