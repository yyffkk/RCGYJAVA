package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerHygieneDao;
import com.api.butlerApp.service.jurisdiction.ButlerHygieneService;
import com.api.model.butlerApp.ButlerHygieneSearch;
import com.api.model.operationManagement.SysHygieneTask;
import com.api.vo.butlerApp.ButlerHygieneVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ButlerHygieneServiceImpl implements ButlerHygieneService {
    private static Map<String,Object> map = null;
    @Resource
    ButlerHygieneDao butlerHygieneDao;

    @Override
    public List<ButlerHygieneVo> list(ButlerHygieneSearch butlerHygieneSearch) {
        return butlerHygieneDao.list(butlerHygieneSearch);
    }

    @Override
    public Map<String, Object> complete(SysHygieneTask sysHygieneTask) {
        map = new HashMap<>();


        sysHygieneTask.setStatus(2);//2.已完成
        sysHygieneTask.setComplete(new Date());//填入完成时间

        int update = butlerHygieneDao.complete(sysHygieneTask);
        if (update >0){
            map.put("message","完成成功");
            map.put("status",true);
        }else {
            map.put("message","完成失败");
            map.put("status",false);
        }

        return map;
    }
}
