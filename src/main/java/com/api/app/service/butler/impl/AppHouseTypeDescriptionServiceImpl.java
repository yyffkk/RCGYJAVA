package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppHouseTypeDescriptionDao;
import com.api.app.service.butler.AppHouseTypeDescriptionService;
import com.api.util.UploadUtil;
import com.api.vo.app.AppHouseTypeDescriptionVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppHouseTypeDescriptionServiceImpl implements AppHouseTypeDescriptionService {
    @Resource
    AppHouseTypeDescriptionDao appHouseTypeDescriptionDao;

    @Override
    public List<AppHouseTypeDescriptionVo> list() {
        List<AppHouseTypeDescriptionVo> list = appHouseTypeDescriptionDao.list();
        if (list != null && list.size()>0){
            for (AppHouseTypeDescriptionVo appHouseTypeDescriptionVo : list) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysHouseTypeDescription", appHouseTypeDescriptionVo.getId(), "HouseTypeImg");
                appHouseTypeDescriptionVo.setImgUrls(imgByDate);
            }
        }
        return list;
    }
}
