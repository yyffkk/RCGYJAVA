package com.api.manage.service.chargeManagement.impl;

import com.api.manage.dao.chargeManagement.SysDailyPaymentDao;
import com.api.manage.dao.remind.RemindDao;
import com.api.model.chargeManagement.*;
import com.api.model.remind.SysMessage;
import com.api.model.remind.SysSending;
import com.api.model.businessManagement.SysUser;
import com.api.manage.service.chargeManagement.SysDailyPaymentService;
import com.api.vo.chargeManagement.VoDailyPayment;
import com.api.vo.chargeManagement.VoFindByIdDailyPayment;
import com.api.vo.chargeManagement.VoPayResident;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
            //填入发送状态（0.未发或不成功1.发送成功（未读），3.已读）[初始为0，用户打开app为1，查看为3]
            sysSending.setSendStatus(1);
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

    @Override
    @Transactional
    public Map<String, Object> insertOrder(DailyPaymentPayInfo dailyPaymentPayInfo) {
        map = new HashMap<>();
        DailyPaymentOrder dailyPaymentOrder = dailyPaymentPayInfo.getDailyPaymentOrder();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            //判断支付金额是否超出待缴金额
            VoFindByIdDailyPayment byId = sysDailyPaymentDao.findById(dailyPaymentPayInfo.getDailyPaymentId());
            if (dailyPaymentOrder.getPayPrice().compareTo(byId.getPaymentPrice())  == 1 ){
                throw new RuntimeException("支付超出待缴金额，请重新支付,待缴金额为："+byId.getPaymentPrice());
            }


            //填入创建人
            dailyPaymentOrder.setCreateId(sysUser.getId());
            //填入创建时间
            dailyPaymentOrder.setCreateDate(new Date());
            //添加缴费订单信息
            int i = sysDailyPaymentDao.insertOrder(dailyPaymentOrder);
            if (i<=0){
               throw new RuntimeException("添加缴费订单信息失败");
            }

            //添加缴费订单清单信息（缴费信息 与 缴费订单信息 关联表）
            DailyPaymentOrderList dailyPaymentOrderList = new DailyPaymentOrderList();
            dailyPaymentOrderList.setDailyPaymentId(dailyPaymentPayInfo.getDailyPaymentId());
            dailyPaymentOrderList.setDailyPaymentOrderId(dailyPaymentOrder.getId());
            int orderList = sysDailyPaymentDao.insertOrderList(dailyPaymentOrderList);
            if (orderList <= 0){
                throw new RuntimeException("添加缴费订单清单信息失败");
            }



            //获取状态更新信息
            UpdateDailyPayment updateDailyPayment = new UpdateDailyPayment();
            //填入剩余待缴金额（待缴金额 - 支付金额）
            updateDailyPayment.setRemainingPaymentPrice(byId.getPaymentPrice().subtract(dailyPaymentOrder.getPayPrice()));
            //填入支付金额
            updateDailyPayment.setPayPrice(dailyPaymentOrder.getPayPrice());
            //填入日常缴费信息主键id
            updateDailyPayment.setDailyPaymentId(dailyPaymentPayInfo.getDailyPaymentId());
            //添加缴费订单信息后，修改缴费信息的已缴金额和待缴金额，并修改状态
            int update = sysDailyPaymentDao.updatePaidPriceAndPaymentPrice(updateDailyPayment);
            if (update <= 0){
                throw new RuntimeException("修改缴费信息失败");
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
        map.put("message","缴费成功");
        map.put("status",true);
        //如果为1，则打印该订单信息
        if (dailyPaymentOrder.getIsPrinting() == 1){
            System.out.println("打印该订单成功");
            map.put("message","缴费并打印成功");
        }
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(DailyPayment dailyPayment) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            //添加创建人id
            dailyPayment.setCreateId(sysUser.getId());
            //添加创建人时间
            dailyPayment.setCreateDate(new Date());
            //填入已缴金额
            dailyPayment.setPaidPrice(BigDecimal.ZERO);
            //填入费用金额(单价*用量)
            dailyPayment.setCostPrice(dailyPayment.getUnitPrice().multiply(BigDecimal.valueOf(dailyPayment.getNum())));
            //填入应收总计(费用金额)
            dailyPayment.setTotalPrice(dailyPayment.getCostPrice());
            //填入待缴金额
            dailyPayment.setPaymentPrice(dailyPayment.getCostPrice());
            //填入状态(1.未缴纳)
            dailyPayment.setStatus(1);
            //填入是否删除，0.删除 1.非删
            dailyPayment.setIsDelete(1);
            //添加日常缴费信息,并返回主键id
            int insert = sysDailyPaymentDao.insert(dailyPayment);
            if (insert <= 0){
                throw new RuntimeException("添加日常缴费信息失败");
            }

            //获取订单信息
            DailyPaymentOrder dailyPaymentOrder = dailyPayment.getDailyPaymentOrder();
            if (dailyPaymentOrder != null){
                //如果待缴金额小于支付金额，则抛出 超出待缴金额异常
                if (dailyPayment.getPaymentPrice().compareTo(dailyPaymentOrder.getPayPrice()) == -1 ){
                    throw new RuntimeException("支付超出待缴金额，请重新支付,待缴金额为："+dailyPayment.getPaymentPrice());
                }

                //填入创建人
                dailyPaymentOrder.setCreateId(sysUser.getId());
                //填入创建时间
                dailyPaymentOrder.setCreateDate(new Date());
                //添加缴费订单信息
                int i = sysDailyPaymentDao.insertOrder(dailyPaymentOrder);
                if (i<=0){
                    throw new RuntimeException("添加缴费订单信息失败");
                }

                //添加缴费订单清单信息（缴费信息 与 缴费订单信息 关联表）
                DailyPaymentOrderList dailyPaymentOrderList = new DailyPaymentOrderList();
                dailyPaymentOrderList.setDailyPaymentId(dailyPayment.getId());
                dailyPaymentOrderList.setDailyPaymentOrderId(dailyPaymentOrder.getId());
                int orderList = sysDailyPaymentDao.insertOrderList(dailyPaymentOrderList);
                if (orderList <= 0){
                    throw new RuntimeException("添加缴费订单清单信息失败");
                }


                //获取状态更新信息
                UpdateDailyPayment updateDailyPayment = new UpdateDailyPayment();
                //填入剩余待缴金额（待缴金额 - 支付金额）
                updateDailyPayment.setRemainingPaymentPrice(dailyPayment.getPaymentPrice().subtract(dailyPaymentOrder.getPayPrice()));
                //填入支付金额
                updateDailyPayment.setPayPrice(dailyPaymentOrder.getPayPrice());
                //填入日常缴费信息主键id
                updateDailyPayment.setDailyPaymentId(dailyPayment.getId());
                //添加缴费订单信息后，修改缴费信息的已缴金额和待缴金额，并修改状态
                int update = sysDailyPaymentDao.updatePaidPriceAndPaymentPrice(updateDailyPayment);
                if (update <= 0){
                    throw new RuntimeException("修改缴费信息失败");
                }

                //如果为1，则打印该订单信息
                if (dailyPayment.getDailyPaymentOrder().getIsPrinting() == 1){
                    System.out.println("打印该订单成功");
                    map.put("message","缴费并打印成功");
                }
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
        map.put("message","操作成功");
        map.put("status",true);
        return map;
    }

    @Override
    public VoPayResident findResidentByEstateId(Integer id) {
        //根据房产id查询待缴费人信息
        return sysDailyPaymentDao.findResidentByEstateId(id);
    }
}
