package com.api.service.chargeManagement.impl;

import com.api.dao.chargeManagement.SysDailyPaymentDao;
import com.api.dao.remind.RemindDao;
import com.api.model.chargeManagement.DailyPaymentPush;
import com.api.model.remind.SysMessage;
import com.api.model.remind.SysSending;
import com.api.model.chargeManagement.SearchDailyPayment;
import com.api.model.system.SysUser;
import com.api.service.chargeManagement.SysDailyPaymentService;
import com.api.vo.chargeManagement.VoDailyPayment;
import com.api.vo.chargeManagement.VoFindByIdDailyPayment;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysDailyPaymentServiceImpl implements SysDailyPaymentService {
    private static Map<String,Object> map = null;
    @Resource
    SysDailyPaymentDao sysDailyPaymentDao;
    @Resource
    RemindDao remindDao;

    @Override
    public List<VoDailyPayment> list(SearchDailyPayment searchDailyPayment) {
        //初始化数组参数，长度为3，值都为null
        String[] split = {null,null,null};
        if (searchDailyPayment.getRoomName()!=null){
            //用'-'截取字符串 获取数组
            String[] split2 = searchDailyPayment.getRoomName().replace(" ", "").split("-");
            //如果数组长度超过3，超出部分不要
            for (int i =0;i<split2.length;i++) {
                //防止下标越界异常
                if (i<3){
                    split[i] = split2[i];
                }
            }
            //添加楼栋模糊查询信息,StringUtils.isNotBlank()【null，''】为true【' ','a',' a '】为false
            if (StringUtils.isNotBlank(split[0])){
                searchDailyPayment.setEstateNo(Integer.valueOf(split[0]));
            }
            //添加单元模糊查询信息
            if (StringUtils.isNotBlank(split[1])) {
                searchDailyPayment.setUnitNo(Integer.valueOf(split[1]));
            }
            //添加房产模糊查询信息
            if (StringUtils.isNotBlank(split[2])) {
                searchDailyPayment.setRoomNumber(split[2]);
            }
        }
        List<VoDailyPayment> list = sysDailyPaymentDao.list(searchDailyPayment);
        if (list != null && list.size()>0){
            //处理显示的roomName信息
            for (VoDailyPayment voDailyPayment : list) {
                voDailyPayment.setRoomName(voDailyPayment.getEstateNo()+"-"+voDailyPayment.getUnitNo()+"-"+voDailyPayment.getRoomNumber());
            }
        }
        return list;
    }

    @Override
    public VoFindByIdDailyPayment findById(Integer id) {
        return sysDailyPaymentDao.findById(id);
    }

    @Override
    public Map<String, Object> push(DailyPaymentPush dailyPaymentPush) {
        SysMessage sysMessage = dailyPaymentPush.getSysMessage();
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            //填入标题
            sysMessage.setTitle("日常缴纳推送提醒");
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
                throw new RuntimeException("推送失败");
            }

            SysSending sysSending = new SysSending();
            //填入消息id
            sysSending.setMessageId(sysMessage.getId());
            //填入接收人id
            sysSending.setReceiverAccount(dailyPaymentPush.getReceiverAccountId());
            //填入发送状态（0.未发或不成功1.发送成功，3.已读）[初始为0，用户打开app为1，查看为3]
            sysSending.setSendStatus(0);
            //填入发送日期
            sysSending.setSendDate(new Date());
            //添加消息接收列表
            int i = remindDao.insertSending(sysSending);
            if (i <= 0){
                throw new RuntimeException("推送失败");
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
        map.put("message","推送成功");
        map.put("status",true);
        return map;
    }
}
