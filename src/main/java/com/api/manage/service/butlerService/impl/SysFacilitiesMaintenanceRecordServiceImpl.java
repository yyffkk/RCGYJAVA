package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysFacilitiesMaintenanceRecordDao;
import com.api.manage.service.butlerService.SysFacilitiesMaintenanceRecordService;
import com.api.model.butlerService.FacilitiesMaintenanceRecord;
import com.api.vo.butlerService.VoFacilitiesMaintenanceRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysFacilitiesMaintenanceRecordServiceImpl implements SysFacilitiesMaintenanceRecordService {
    private static Map<String,Object> map = null;
    @Resource
    SysFacilitiesMaintenanceRecordDao maintenanceRecordDao;


    @Override
    public Map<String, Object> list(Integer facilitiesManageId) {
        map = new HashMap<>();

        List<VoFacilitiesMaintenanceRecord> maintenanceRecordList = maintenanceRecordDao.list(facilitiesManageId);

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",maintenanceRecordList);

        return map;
    }

    @Override
    public Map<String, Object> insert(FacilitiesMaintenanceRecord maintenanceRecord) {
        map = new HashMap<>();

        int insert = maintenanceRecordDao.insert(maintenanceRecord);
        if (insert >0){
            map.put("message","添加成功");
            map.put("status",true);
        }else {
            map.put("message","添加失败");
            map.put("status",false);
        }

        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        try {
            for (int id : ids) {
                int delete = maintenanceRecordDao.delete(id);
                if (delete <= 0){
                    throw new RuntimeException("删除失败");
                }
            }
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
        map.put("message","删除成功");
        map.put("status",true);
        return map;
    }
}
