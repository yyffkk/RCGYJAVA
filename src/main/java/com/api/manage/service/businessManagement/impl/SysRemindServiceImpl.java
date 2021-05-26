package com.api.manage.service.businessManagement.impl;

import com.api.manage.dao.businessManagement.SysRemindDao;
import com.api.manage.dao.remind.RemindDao;
import com.api.manage.service.businessManagement.SysRemindService;
import com.api.model.businessManagement.Remind;
import com.api.model.businessManagement.SearchRemind;
import com.api.model.businessManagement.SysUser;
import com.api.model.remind.SysMessage;
import com.api.model.remind.SysSending;
import com.api.util.JiguangUtil;
import com.api.vo.businessManagement.VoRemind;
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
public class SysRemindServiceImpl implements SysRemindService {
    private static Map<String,Object> map = null;
    @Resource
    SysRemindDao sysRemindDao;
    @Resource
    RemindDao remindDao;

    @Override
    public List<VoRemind> list(SearchRemind searchRemind) {
        return sysRemindDao.list(searchRemind);
    }

    @Override
    @Transactional
    public Map<String, Object> insert(Remind remind) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        try {
            SysMessage sysMessage = new SysMessage();
            //填入标题
            sysMessage.setTitle(remind.getTitle());
            //填入内容
            sysMessage.setContent(remind.getContent());
            //填入发送人id（系统发送为-1）
            sysMessage.setSender(sysUser.getId());
            //填入创建时间
            sysMessage.setGenerateDate(new Date());
            //填入发送时间
            sysMessage.setSendDate(new Date());
            //填入发送类型（1.系统广播，2.管理员消息）
            sysMessage.setType(2);
            //添加提醒 消息列表 并返回主键id
            int insert = remindDao.insertMessage(sysMessage);
            if (insert <= 0){
                throw new RuntimeException("提醒失败");
            }

            SysSending sysSending = new SysSending();
            //填入消息id
            sysSending.setMessageId(sysMessage.getId());
            //填入接收人id
            sysSending.setReceiverAccount(remind.getReceiverAccount());
            //填入发送状态（0.未发或不成功1.发送成功（未读），3.已读）[初始为1，查看为3]
            sysSending.setSendStatus(1);
            //填入发送日期
            sysSending.setSendDate(new Date());
            //添加消息接收列表
            int i = remindDao.insertSending(sysSending);
            if (i <= 0){
                throw new RuntimeException("提醒失败");
            }
            JiguangUtil.push(String.valueOf(remind.getReceiverAccount()),remind.getTitle());

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
        map.put("message","提醒成功");
        map.put("status",true);
        return map;
    }
}
