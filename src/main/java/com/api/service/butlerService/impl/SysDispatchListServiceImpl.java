package com.api.service.butlerService.impl;

import com.api.dao.butlerService.SysDispatchListDao;
import com.api.model.butlerService.CancelWorkOrder;
import com.api.model.butlerService.RevisitWorkOrder;
import com.api.model.butlerService.SearchDispatchList;
import com.api.model.system.SysUser;
import com.api.service.butlerService.SysDispatchListService;
import com.api.vo.butlerService.VoDispatchList;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysDispatchListServiceImpl implements SysDispatchListService {
    private static Map<String,Object> map = null;
    @Resource
    SysDispatchListDao sysDispatchListDao;

    @Override
    public List<VoDispatchList> list(SearchDispatchList searchDispatchList) {
        List<VoDispatchList> list = null;
        if (searchDispatchList.getType() != null){
            if (searchDispatchList.getType() == 1){
                list = sysDispatchListDao.list(searchDispatchList);
            }else {
                //其他情况未做，为空
            }
        }else {
            list = sysDispatchListDao.list(searchDispatchList);
        }

        return list;
    }

    @Override
    public Map<String, Object> falseDelete(Integer id) {
        map = new HashMap<>();
        int update = sysDispatchListDao.falseDelete(id);
        if (update > 0){
            map.put("message","工单删除成功");
            map.put("status",true);
        }else {
            map.put("message","工单删除失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> cancel(CancelWorkOrder cancelWorkOrder) {
        map = new HashMap<>();
        int update = sysDispatchListDao.cancel(cancelWorkOrder);
        if (update > 0){
            map.put("message","工单作废成功");
            map.put("status",true);
        }else {
            map.put("message","工单作废失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> revisit(RevisitWorkOrder revisitWorkOrder) {
        map = new HashMap<>();
        revisitWorkOrder.setRevisitDate(new Date());
        int update = sysDispatchListDao.revisit(revisitWorkOrder);
        if (update > 0){
            map.put("message","添加回访信息成功");
            map.put("status",true);
        }else {
            map.put("message","添加回访信息失败");
            map.put("status",false);
        }
        return map;
    }
}
