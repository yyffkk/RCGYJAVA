package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysGreenTaskDao;
import com.api.manage.service.operationManagement.SysGreenTaskService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.SearchGreenTask;
import com.api.model.operationManagement.SysGreenTask;
import com.api.vo.operationManagement.VoGreenTask;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysGreenTaskServiceImpl implements SysGreenTaskService {
    private static Map<String,Object> map = null;
    @Resource
    SysGreenTaskDao sysGreenTaskDao;

    @Override
    public List<VoGreenTask> list(SearchGreenTask searchGreenTask) {
        List<VoGreenTask> list = sysGreenTaskDao.list(searchGreenTask);
        if (list != null && list.size()>0){
            for (VoGreenTask voGreenTask : list) {
                if (voGreenTask.getStatus() ==1 && new Date().getTime() > voGreenTask.getEndDate().getTime()){
                    voGreenTask.setStatus(3); //3.未完成
                }
            }
        }
        return list;
    }

    @Override
    public Map<String, Object> insert(SysGreenTask sysGreenTask) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysGreenTask.setCreateId(sysUser.getId());
        sysGreenTask.setCreateDate(new Date());
        sysGreenTask.setStatus(1);//填入默认状态 1.待处理

        int insert = sysGreenTaskDao.insert(sysGreenTask);
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
        map = new HashMap<>();

        try {
            for (int id : ids) {
                int delete = sysGreenTaskDao.delete(id);
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
