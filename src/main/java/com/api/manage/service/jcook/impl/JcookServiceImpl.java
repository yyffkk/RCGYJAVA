package com.api.manage.service.jcook.impl;

import com.api.manage.dao.jcook.JcookDao;
import com.api.manage.service.jcook.JcookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class JcookServiceImpl implements JcookService {
    @Resource
    JcookDao jcookDao;

    @Override
    public Map<String, Object> updateJcookShop() {
        return null;
    }
}
