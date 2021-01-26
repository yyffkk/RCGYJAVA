package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppQuestionnaireDao;
import com.api.app.service.butler.AppQuestionnaireService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AppQuestionnaireServiceImpl implements AppQuestionnaireService {
    @Resource
    AppQuestionnaireDao appQuestionnaireDao;
}
