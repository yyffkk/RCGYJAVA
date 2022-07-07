package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppPackageCollectionDao;
import com.api.app.service.butler.AppPackageCollectionService;
import com.api.model.app.SearchAppPackageCollection;
import com.api.vo.app.AppConfirmCollection;
import com.api.vo.operationManagement.VoPackageCollection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppPackageCollectionServiceImpl implements AppPackageCollectionService {
    private static Map<String,Object> map = null;
    @Resource
    AppPackageCollectionDao appPackageCollectionDao;

    @Override
    public List<VoPackageCollection> list(SearchAppPackageCollection searchAppPackageCollection) {
        return appPackageCollectionDao.list(searchAppPackageCollection);
    }

    @Override
    public Map<String, Object> confirmCollection(AppConfirmCollection appConfirmCollection) {
        map = new HashMap<>();
        String addresseeTel = appPackageCollectionDao.findAddresseeTelByPackageId(appConfirmCollection.getPackageCollectionId());
        if (appConfirmCollection.getTel().equals(addresseeTel)){
            appConfirmCollection.setReceiveDate(new Date());
            //确认领取包裹
            int update = appPackageCollectionDao.confirmCollection(appConfirmCollection);
            if (update >0){
                map.put("message","操作成功");
                map.put("status",true);
            }else {
                map.put("message","操作失败");
                map.put("status",false);
            }
        }else {
            map.put("message","这不是您的包裹");
            map.put("status",false);
        }
        return map;
    }
}
