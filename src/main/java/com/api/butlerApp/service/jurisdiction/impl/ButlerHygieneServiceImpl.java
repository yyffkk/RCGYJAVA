package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerHygieneDao;
import com.api.butlerApp.service.jurisdiction.ButlerHygieneService;
import com.api.manage.dao.message.ManageSysMessageDao;
import com.api.model.businessManagement.SysOrganization;
import com.api.model.butlerApp.ButlerHygieneSearch;
import com.api.model.message.ManageSysMessage;
import com.api.model.operationManagement.SysHygieneTask;
import com.api.vo.butlerApp.ButlerHygieneVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
    @Resource
    ManageSysMessageDao manageSysMessageDao;

    @Override
    public List<ButlerHygieneVo> list(ButlerHygieneSearch butlerHygieneSearch) {
        return butlerHygieneDao.list(butlerHygieneSearch);
    }

    @Override
    public Map<String, Object> complete(SysHygieneTask sysHygieneTask, String name, Integer organizationId) {
        map = new HashMap<>();


        try {
            sysHygieneTask.setStatus(2);//2.已完成
            sysHygieneTask.setComplete(new Date());//填入完成时间

            int update = butlerHygieneDao.complete(sysHygieneTask);
            if (update <= 0){
                throw new RuntimeException("完成失败");
            }

            //根据卫生任务主键id查询卫生任务信息
            SysHygieneTask sysHygieneTask1 = butlerHygieneDao.findTaskById(sysHygieneTask.getId());

            //根据组织id查询组织信息
            SysOrganization sysOrganization = manageSysMessageDao.findOrganizationByOrganizationId(organizationId);

            //添加后台消息列表
            ManageSysMessage manageSysMessage = new ManageSysMessage();
            manageSysMessage.setContent(sysOrganization.getName()+" "+name+" 完成了卫生任务，请确认");
            manageSysMessage.setType(4);//4.卫生任务
            manageSysMessage.setRelationId(sysHygieneTask1.getId());//填入卫生任务主键id
            manageSysMessage.setReceiverAccountId(sysHygieneTask1.getCreateId());//填入接收人
            manageSysMessage.setSenderId(sysHygieneTask.getDirector());//填入发送人id
            manageSysMessage.setSenderType(1);//1.管家
            manageSysMessage.setSendStatus(1);//1.发送成功（未读）
            manageSysMessage.setSendDate(new Date());
            int insert4 = manageSysMessageDao.insert(manageSysMessage);
            if (insert4 <= 0){
                throw new RuntimeException("后台消息列表发送失败");
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

        map.put("message","完成成功");
        map.put("status",true);
        return map;
    }
}
