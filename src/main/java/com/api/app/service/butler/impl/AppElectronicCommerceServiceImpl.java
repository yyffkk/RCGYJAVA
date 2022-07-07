package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppElectronicCommerceDao;
import com.api.app.service.butler.AppElectronicCommerceService;
import com.api.model.app.AppElectronicCommerceVo;
import com.api.model.app.AppElectronicCommerceVoFBI;
import com.api.model.app.SearchAppElectronicCommerce;
import com.api.util.UploadUtil;
import com.api.vo.app.AppNewsVo;
import com.api.vo.app.AppNewsVoFBI;
import com.api.vo.app.IdAndName;
import com.api.vo.resources.VoResourcesImg;
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

    @Override
    public List<AppElectronicCommerceVo> electronicCommerceList(SearchAppElectronicCommerce searchAppElectronicCommerce) {
        map = new HashMap<>();
        List<AppElectronicCommerceVo> appElectronicCommerceVoList = appElectronicCommerceDao.electronicCommerceList(searchAppElectronicCommerce);
        if (appElectronicCommerceVoList != null && appElectronicCommerceVoList.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (AppElectronicCommerceVo appElectronicCommerceVo : appElectronicCommerceVoList) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysElectronicCommerce", appElectronicCommerceVo.getId(), "electronicCommerceImg");
                appElectronicCommerceVo.setImgList(imgByDate);
            }
        }
        return appElectronicCommerceVoList;
    }

    @Override
    public Map<String, Object> findElectronicCommerceById(Integer electronicCommerceId) {
        map = new HashMap<>();
        AppElectronicCommerceVoFBI appElectronicCommerceVoFBI = appElectronicCommerceDao.findElectronicCommerceById(electronicCommerceId);
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",appElectronicCommerceVoFBI);
        return map;
    }
}
