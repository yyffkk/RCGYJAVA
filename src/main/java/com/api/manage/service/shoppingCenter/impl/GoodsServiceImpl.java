package com.api.manage.service.shoppingCenter.impl;

import com.api.manage.dao.shoppingCenter.GoodsDao;
import com.api.manage.service.shoppingCenter.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    GoodsDao goodsDao;

}
