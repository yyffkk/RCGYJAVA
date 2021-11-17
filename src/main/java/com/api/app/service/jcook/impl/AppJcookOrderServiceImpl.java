package com.api.app.service.jcook.impl;

import com.api.app.service.jcook.AppJcookOrderService;
import com.api.mapper.jcook.JcookOrderListMapper;
import com.api.mapper.jcook.JcookOrderMapper;
import com.api.model.jcook.dto.JcookOrderSearch;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class AppJcookOrderServiceImpl implements AppJcookOrderService {
    private static Map<String,Object> map = null;
    @Resource
    JcookOrderMapper jcookOrderMapper;
    @Resource
    JcookOrderListMapper jcookOrderListMapper;

    @Override
    public Map<String, Object> myOrder(JcookOrderSearch jcookOrderSearch) {
        map = new HashMap<>();


        return null;
    }
}
