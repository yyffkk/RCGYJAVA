package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppHousekeepingServiceDao;
import com.api.app.service.butler.AppHousekeepingServiceService;
import com.api.model.app.AppHousekeepingService;
import com.api.util.UploadUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class AppHousekeepingServiceServiceImpl implements AppHousekeepingServiceService {
    private static Map<String,Object> map = null;
    @Resource
    AppHousekeepingServiceDao appHousekeepingServiceDao;


    @Override
    @Transactional
    public Map<String, Object> submitHousekeeping(AppHousekeepingService appHousekeepingService) {
        map = new HashMap<>();

        try {
            appHousekeepingService.setStatus(1);//状态：默认填1.待派单
            int insert = appHousekeepingServiceDao.submitHousekeeping(appHousekeepingService);
            if (insert <= 0){
                throw new RuntimeException("提交失败");
            }
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(appHousekeepingService.getSubmitImgUrls(),"sysHouseKeepingService",appHousekeepingService.getId(),"submitImg","600",30,20);

        } catch (Exception e) {
            //获取抛出的信息
            String message = e.getMessage();
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message",message);
            map.put("status",false);
            return map;
        }
        map.put("message","提交成功");
        map.put("status",true);
        return map;
    }
}
