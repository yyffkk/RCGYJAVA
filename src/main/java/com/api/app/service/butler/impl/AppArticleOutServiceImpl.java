package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppArticleOutDao;
import com.api.app.service.butler.AppArticleOutService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AppArticleOutServiceImpl implements AppArticleOutService {
    @Resource
    AppArticleOutDao appArticleOutDao;
}
