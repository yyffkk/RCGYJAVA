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
import java.util.List;

@Service
public class ManageSysMessageServiceImpl implements ManageSysMessageService {
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
}
