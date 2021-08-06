package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerGreenDao;
import com.api.butlerApp.dao.jurisdiction.ButlerRepairDao;
import com.api.butlerApp.service.jurisdiction.ButlerGreenService;
import com.api.manage.dao.message.ManageSysMessageDao;
import com.api.model.businessManagement.SysOrganization;
import com.api.model.butlerApp.ButlerGreenSearch;
import com.api.model.message.ManageSysMessage;
import com.api.model.operationManagement.SysGreenTask;
import com.api.vo.butlerApp.ButlerGreenVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ButlerGreenServiceImpl implements ButlerGreenService {
    private static Map<String,Object> map = null;
    @Resource
    ButlerGreenDao butlerGreenDao;
    @Resource
    ManageSysMessageDao manageSysMessageDao;
    @Resource
    ButlerRepairDao butlerRepairDao;

    @Override
    public List<ButlerGreenVo> list(ButlerGreenSearch butlerGreenSearch, int type) {
        List<ButlerGreenVo> list = new ArrayList<>();
        switch (type){
            case 1:
                //接单人界面
                list = butlerGreenDao.list(butlerGreenSearch);
                break;
            case 2:
                //检查人界面
                list = butlerGreenDao.list2(butlerGreenSearch);
                break;
            case 3:
                //其他人界面
                break;
            default:
                //系统错误
                break;
        }
        return list;
    }

    @Override
    @Transactional
    public Map<String, Object> complete(SysGreenTask sysGreenTask, String name, Integer organizationId, int type) {
        map = new HashMap<>();


        try {
            if (type != 1){
                throw new RuntimeException("当前用户无接单权限，不可完成任务");
            }

            sysGreenTask.setStatus(2);//2.已完成
            sysGreenTask.setComplete(new Date());//填入完成时间

            int update = butlerGreenDao.complete(sysGreenTask);
            if (update <= 0){
                throw new RuntimeException("完成失败");
            }

            //根据绿化任务主键id查询绿化任务信息
            SysGreenTask sysGreenTask1 = butlerGreenDao.findTaskById(sysGreenTask.getId());

            //根据组织id查询组织信息
            SysOrganization sysOrganization = manageSysMessageDao.findOrganizationByOrganizationId(organizationId);

            //添加后台消息列表
            ManageSysMessage manageSysMessage = new ManageSysMessage();
            manageSysMessage.setContent(sysOrganization.getName()+" "+name+" 完成了绿化任务，请确认");
            manageSysMessage.setType(3);//3.绿化任务
            manageSysMessage.setRelationId(sysGreenTask1.getId());//填入绿化任务主键id
            manageSysMessage.setReceiverAccountId(sysGreenTask1.getCreateId());//填入接收人
            manageSysMessage.setSenderId(sysGreenTask.getDirector());//填入发送人id
            manageSysMessage.setSenderType(1);//1.管家
            manageSysMessage.setSendStatus(1);//1.发送成功（未读）
            manageSysMessage.setSendDate(new Date());
            int insert4 = manageSysMessageDao.insert(manageSysMessage);
            if (insert4 <= 0){
                throw new RuntimeException("后台消息列表发送失败");
            }
        } catch (RuntimeException e) {
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

    @Override
    public int findJurisdictionByUserId(String roleIds) {
        String[] split = roleIds.split(",");
        if (split.length >0){
            for (String s : split) {
                int roleId = Integer.parseInt(s);
                //根据角色id查询权限id集合
                List<Integer> jurisdictionIds = butlerRepairDao.findJIdsByRoleId(roleId);
                if (jurisdictionIds != null && jurisdictionIds.size()>0){
                    //73.接单
                    if (jurisdictionIds.contains(73)){
                        return 1;
                    }
                    //74.检查
                    if (jurisdictionIds.contains(74)){
                        return 2;
                    }
                }
            }
        }
        return 3;
    }
}
