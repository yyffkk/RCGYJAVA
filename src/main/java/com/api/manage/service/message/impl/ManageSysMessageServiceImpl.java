package com.api.manage.service.message.impl;

import com.api.manage.dao.message.ManageSysMessageDao;
import com.api.manage.service.message.ManageSysMessageService;
import com.api.model.businessManagement.SysUser;
import com.api.model.message.ManageSysMessage;
import com.api.model.message.SearchManageSysMessage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManageSysMessageServiceImpl implements ManageSysMessageService {
    private static Map<String,Object> map = null;
    @Resource
    ManageSysMessageDao manageSysMessageDao;

    @Override
    public List<ManageSysMessage> list(SearchManageSysMessage searchManageSysMessage) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        searchManageSysMessage.setReceiverAccountId(sysUser.getId());

        return manageSysMessageDao.list(searchManageSysMessage);
    }

    @Override
    public Map<String, Object> read(Integer manageSysMessageId) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        ManageSysMessage manageSysMessage = new ManageSysMessage();
        manageSysMessage.setId(manageSysMessageId);//填入后台消息列表主键id
        manageSysMessage.setSendStatus(3);//填入3.已读
        manageSysMessage.setReceiverAccountId(sysUser.getId());//添入接受人id

        int update = manageSysMessageDao.read(manageSysMessage);
        if (update >0){
            map.put("message","操作成功");
            map.put("status",true);
        }else {
            map.put("message","操作失败");
            map.put("status",false);
        }

        return map;
    }

    @Override
    public Map<String, Object> allRead() {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        ManageSysMessage manageSysMessage = new ManageSysMessage();
        manageSysMessage.setSendStatus(3);//填入3.已读
        manageSysMessage.setReceiverAccountId(sysUser.getId());//添入接受人id

        int update = manageSysMessageDao.allRead(manageSysMessage);
        if (update >0){
            map.put("message","操作成功");
            map.put("status",true);
        }else {
            map.put("message","操作失败");
            map.put("status",false);
        }

        return map;
    }
}
