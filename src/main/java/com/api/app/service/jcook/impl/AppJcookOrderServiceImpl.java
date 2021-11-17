package com.api.app.service.jcook.impl;

import com.api.app.service.jcook.AppJcookOrderService;
import com.api.mapper.jcook.JcookOrderListMapper;
import com.api.mapper.jcook.JcookOrderMapper;
import com.api.model.jcook.dto.CreateOrderDTO;
import com.api.model.jcook.entity.JcookOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class AppJcookOrderServiceImpl implements AppJcookOrderService {
    @Resource
    JcookOrderMapper jcookOrderMapper;
    @Resource
    JcookOrderListMapper jcookOrderListMapper;
}
