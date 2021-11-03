package com.api.manage.service.jcook.impl;

import com.api.manage.dao.jcook.JcookDao;
import com.api.manage.service.jcook.JcookService;
import org.example.api.JcookSDK;
import org.example.api.model.SkuListRequest;
import org.example.api.model.SkuListResponse;
import org.example.api.utils.result.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class JcookServiceImpl implements JcookService {
    @Resource
    JcookDao jcookDao;

    @Override
    public Map<String, Object> updateJcookShop() {

        SkuListRequest skuListRequest = new SkuListRequest();
        skuListRequest.setPage(1);
        skuListRequest.setPageSize(10);
        JcookSDK jcookSDK = new JcookSDK("b7964889cedfdf429bfc7fae0001ff46", "7b8ef75532ca0d664c7f9fe3c174eed9", 1010256);
        Result<SkuListResponse> skuListResponse = jcookSDK.skuList(skuListRequest);
        System.out.println(skuListResponse);

        return null;
    }
}
