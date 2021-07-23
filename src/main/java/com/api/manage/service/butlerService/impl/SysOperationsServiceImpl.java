package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysOperationsDao;
import com.api.manage.service.butlerService.SysOperationsService;
import com.api.model.butlerService.SearchOperations;
import com.api.model.butlerService.SysOperations;
import com.api.vo.butlerService.VoOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysOperationsServiceImpl implements SysOperationsService {
    private static Map<String,Object> map = null;
    @Resource
    SysOperationsDao sysOperationsDao;

    @Override
    public List<VoOperations> list(SearchOperations searchOperations) {
        return sysOperationsDao.list(searchOperations);
    }

    @Override
    public Map<String, Object> insert(SysOperations sysOperations) {
        map = new HashMap<>();

        int insert = sysOperationsDao.insert(sysOperations);
        if (insert > 0){
            map.put("message","添加成功");
            map.put("status",true);
        }else {
            map.put("message","添加失败");
            map.put("status",false);
        }

        return map;
    }
}
