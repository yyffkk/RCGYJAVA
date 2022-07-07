package com.api.manage.service.system.impl;

import com.api.manage.dao.system.SysSettingsDao;
import com.api.manage.service.system.SysSettingsService;
import com.api.model.system.SysSettings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysSettingsServiceImpl implements SysSettingsService {
    private static Map<String,Object> map = null;
    @Resource
    SysSettingsDao sysSettingsDao;

    @Override
    public Map<String, Object> list() {
        map = new HashMap<>();
        List<SysSettings> sysSettingsList = sysSettingsDao.list();

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sysSettingsList);

        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> isEnable(Integer id) {
        map = new HashMap<>();
        String message = "";
        try {
            Integer onOff = sysSettingsDao.findOnOffById(id);

            if (onOff == null){
                throw new RuntimeException("输入主键有误");
            }


            if (onOff == 1){ //1.开启

                //关闭
                int update = sysSettingsDao.disEnable(id);
                if (update <= 0){
                    throw new RuntimeException("关闭失败");
                }
                message = "关闭成功";
            }else {//2.关闭

                //开启
                int update =  sysSettingsDao.enable(id);
                if (update <= 0){
                    throw new RuntimeException("开启失败");
                }
                message = "开启成功";
            }
        } catch (Exception e) {
            //获取抛出的信息
            String message2 = e.getMessage();
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message",message2);
            map.put("status",false);
            return map;
        }
        map.put("message",message);
        map.put("status",true);
        return map;
    }
}
