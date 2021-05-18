package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppElectronicCommerceDao;
import com.api.app.service.butler.AppElectronicCommerceService;
import com.api.vo.app.IdAndName;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppElectronicCommerceServiceImpl implements AppElectronicCommerceService {
    private static Map<String,Object> map = null;
    @Resource
    AppElectronicCommerceDao appElectronicCommerceDao;

    @Override
    public Map<String, Object> categoryList() {
        map = new HashMap<>();
        List<IdAndName> idAndNames = appElectronicCommerceDao.findAllCategory();
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",idAndNames);
        return map;
    }
}
