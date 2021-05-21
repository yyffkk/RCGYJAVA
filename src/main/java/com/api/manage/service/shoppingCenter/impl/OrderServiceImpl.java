package com.api.manage.service.shoppingCenter.impl;

import com.api.manage.dao.shoppingCenter.OrderDao;
import com.api.manage.service.shoppingCenter.OrderService;
import com.api.model.shoppingCenter.OrderSearch;
import com.api.vo.shoppingCenter.GoodsVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderDao orderDao;

    @Override
    public List<GoodsVo> list(OrderSearch orderSearch) {
        return orderDao.list(orderSearch);
    }
}
