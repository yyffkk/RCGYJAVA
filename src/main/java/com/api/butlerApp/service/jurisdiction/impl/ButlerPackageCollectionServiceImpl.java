package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerPackageCollectionDao;
import com.api.butlerApp.service.jurisdiction.ButlerPackageCollectionService;
import com.api.manage.dao.remind.RemindDao;
import com.api.model.remind.SysMessage;
import com.api.model.remind.SysSending;
import com.api.util.JiguangUtil;
import com.api.vo.operationManagement.VoPackageCollection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ButlerPackageCollectionServiceImpl implements ButlerPackageCollectionService {
    private static Map<String,Object> map = null;
    @Resource
    ButlerPackageCollectionDao butlerPackageCollectionDao;
    @Resource
    RemindDao remindDao;

    @Override
    public List<VoPackageCollection> list(Integer collectionStatus) {
        return butlerPackageCollectionDao.list(collectionStatus);
    }

    @Override
    @Transactional
    public Map<String, Object> remind(Integer packageCollectionId, Integer id) {
        map = new HashMap<>();

        try {
            VoPackageCollection voPackageCollection = butlerPackageCollectionDao.findById(packageCollectionId);
            Integer residentId = butlerPackageCollectionDao.findResidentIdByTel(voPackageCollection.getAddresseeTel());
            if (residentId == null){
                throw new RuntimeException("手机人手机号未注册,或已注销");
            }
            SysMessage sysMessage = new SysMessage();
            //填入标题
            sysMessage.setTitle("包裹领取提醒");
            //填入发送人id（系统发送为-1）
            sysMessage.setSender(id);
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
            sysSending.setReceiverAccount(residentId);
            //填入发送状态（0.未发或不成功1.发送成功（未读），3.已读）[初始为1，查看为3]
            sysSending.setSendStatus(1);
            //填入发送日期
            sysSending.setSendDate(new Date());
            //添加消息接收列表
            int i = remindDao.insertSending(sysSending);
            if (i <= 0){
                throw new RuntimeException("推送失败");
            }
            JiguangUtil.push(String.valueOf(residentId),"包裹领取提醒");
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
        map.put("message","提醒成功");
        map.put("status",true);
        return map;
    }
}
