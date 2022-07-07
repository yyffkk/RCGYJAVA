package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppConvenientTelephoneDao;
import com.api.app.service.butler.AppConvenientTelephoneService;
import com.api.model.butlerService.SearchConveniencePhone;
import com.api.model.butlerService.SysConveniencePhone;
import com.api.vo.app.AppConvenientTelephoneVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppConvenientTelephoneServiceImpl implements AppConvenientTelephoneService {
    @Resource
    AppConvenientTelephoneDao appConvenientTelephoneDao;
    private static Map<String,Object> map = null;


    @Override
    public List<AppConvenientTelephoneVo> list(SearchConveniencePhone searchConveniencePhone) {
        //查询所有正常的便民电话信息
        return appConvenientTelephoneDao.list(searchConveniencePhone);
    }
}
