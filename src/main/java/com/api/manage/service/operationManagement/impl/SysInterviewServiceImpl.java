package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysInterviewDao;
import com.api.manage.service.operationManagement.SysInterviewService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.Interview;
import com.api.model.operationManagement.SearchInterview;
import com.api.vo.operationManagement.VoInterview;
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
public class SysInterviewServiceImpl implements SysInterviewService {
    private static Map<String,Object> map = null;
    @Resource
    SysInterviewDao sysInterviewDao;

    @Override
    public List<VoInterview> list(SearchInterview searchInterview) {
        return sysInterviewDao.list(searchInterview);
    }

    @Override
    public Map<String, Object> insert(Interview interview) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        interview.setCreateId(sysUser.getId());
        interview.setCreateDate(new Date());
        interview.setStatus(1);//1.待访谈
        interview.setIsDelete(1);//1.非删

        int insert = sysInterviewDao.insert(interview);
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
            map = new HashMap<>();
            for (int id : ids) {
                int update = sysInterviewDao.delete(id);
                if (update <=0){
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
