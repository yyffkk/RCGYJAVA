package com.api.manage.service.operationManagement.impl;

import com.api.butlerApp.dao.message.ButlerAppMessageDao;
import com.api.manage.dao.operationManagement.SysHygieneTaskDao;
import com.api.manage.service.operationManagement.SysHygieneTaskService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.ButlerAppSysMessage;
import com.api.model.operationManagement.SysHygieneTask;
import com.api.model.operationManagement.SearchHygieneTask;
import com.api.util.JiguangUtil;
import com.api.vo.operationManagement.VoFBIHygieneTask;
import com.api.vo.operationManagement.VoGreenTask;
import com.api.vo.operationManagement.VoHygieneTask;
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
public class SysHygieneTaskServiceImpl implements SysHygieneTaskService {
    private static Map<String,Object> map = null;
    @Resource
    SysHygieneTaskDao sysHygieneTaskDao;
    @Resource
    ButlerAppMessageDao butlerAppMessageDao;

    @Override
    public List<VoHygieneTask> list(SearchHygieneTask searchHygieneTask) {
        List<VoHygieneTask> list = sysHygieneTaskDao.list(searchHygieneTask);
        if (list != null && list.size()>0){
            for (VoHygieneTask voHygieneTask : list) {
                if (voHygieneTask.getStatus() ==1 && new Date().getTime() > voHygieneTask.getEndDate().getTime()){
                    voHygieneTask.setStatus(3); //3.未完成
                }
            }
        }
        return list;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(SysHygieneTask sysHygieneTask) {
        map = new HashMap<>();
        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            sysHygieneTask.setCreateId(sysUser.getId());
            sysHygieneTask.setCreateDate(new Date());
            sysHygieneTask.setStatus(1); //填写默认状态 1.待处理

            int insert = sysHygieneTaskDao.insert(sysHygieneTask);
            if (insert <= 0){
                throw new RuntimeException("添加失败");
            }

            ButlerAppSysMessage butlerAppSysMessage = new ButlerAppSysMessage();
            butlerAppSysMessage.setType(4);//4.卫生任务
            butlerAppSysMessage.setRelationId(sysHygieneTask.getId());
            butlerAppSysMessage.setReceiverAccount(sysHygieneTask.getDirector());
            butlerAppSysMessage.setSendStatus(1);//1.发送成功（未读）
            butlerAppSysMessage.setSendDate(new Date());
            //添加系统消息
            int insert3 = butlerAppMessageDao.insertSysMessage(butlerAppSysMessage);
            if (insert3 <= 0){
                throw new RuntimeException("添加系统消息失败");
            }
            JiguangUtil.butlerPush(String.valueOf(sysHygieneTask.getDirector()), "你有一条新的卫生任务，请立即查看");
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
        map.put("message","添加成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findById(Integer id) {
        map = new HashMap<>();
        VoFBIHygieneTask voFBIHygieneTask = sysHygieneTaskDao.findById(id);
        map.put("message","消息");
        map.put("status",true);
        map.put("data",voFBIHygieneTask);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        try {
            map = new HashMap<>();
            for (int id : ids) {
                int delete = sysHygieneTaskDao.delete(id);
                if (delete <=0){
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
