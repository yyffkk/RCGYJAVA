package com.api.service.butlerService.impl;

import com.api.dao.butlerService.BorrowDao;
import com.api.dao.remind.RemindDao;
import com.api.model.butlerService.BorrowRemind;
import com.api.model.butlerService.SearchBorrow;
import com.api.model.butlerService.SysArticleBorrow;
import com.api.model.remind.SysMessage;
import com.api.model.remind.SysSending;
import com.api.model.system.SysUser;
import com.api.service.butlerService.BorrowService;
import com.api.vo.butlerService.VoBorrow;
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
public class BorrowServiceImpl implements BorrowService {
    private static Map<String,Object> map = null;
    @Resource
    BorrowDao borrowDao;
    @Resource
    RemindDao remindDao;

    @Override
    public List<VoBorrow> list(SearchBorrow searchBorrow) {
        List<VoBorrow> list = borrowDao.list(searchBorrow);
        if (list != null && list.size()>0){
            for (VoBorrow voBorrow : list) {
                //计算出出借时长
                long hour = (new Date().getTime() - voBorrow.getBeginDate().getTime())/(60*60*1000);
                //传入出借时长
                voBorrow.setBorrowDate(hour);
            }
        }
        return list;
    }

    @Override
    @Transactional
    public Map<String, Object> remind(BorrowRemind borrowRemind) {
        map = new HashMap<>();
        SysMessage sysMessage = borrowRemind.getSysMessage();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
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
                throw new RuntimeException("添加消息列表失败");
            }

            SysSending sysSending = new SysSending();
            //填入消息id
            sysSending.setMessageId(sysMessage.getId());
            //根据借还管理主键id来查询借还信息
            SysArticleBorrow sysArticleBorrow = borrowDao.findById(borrowRemind.getBorrowId());
            //填入接收人id
            sysSending.setReceiverAccount(sysArticleBorrow.getCreateId());
            //填入发送状态（0.未发或不成功1.发送成功，3.已读）[初始为0，用户打开app为1，查看为3]
            sysSending.setSendStatus(0);
            //填入发送日期
            sysSending.setSendDate(new Date());
            //添加消息接收列表
            int i = remindDao.insertSending(sysSending);
            if (i <= 0){
                throw new RuntimeException("添加消息接收列表失败");
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
        map.put("message","添加消息列表成功");
        map.put("status",true);
        return map;
    }
}
