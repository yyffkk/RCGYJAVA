package com.api.butlerApp.service.jurisdiction.impl;

import com.api.app.dao.butler.AppHousekeepingServiceDao;
import com.api.butlerApp.dao.jurisdiction.ButlerHousekeepingServiceDao;
import com.api.butlerApp.dao.jurisdiction.ButlerRepairDao;
import com.api.butlerApp.dao.message.ButlerAppMessageDao;
import com.api.butlerApp.service.jurisdiction.ButlerHousekeepingServiceService;
import com.api.model.app.AppHousekeepingService;
import com.api.model.app.AppHousekeepingServiceProcessRecord;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.ButlerAppSysMessage;
import com.api.model.butlerApp.ButlerHousekeepingServiceSearch;
import com.api.util.JiguangUtil;
import com.api.util.UploadUtil;
import com.api.vo.app.AppHousekeepingServiceVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ButlerHousekeepingServiceServiceImpl implements ButlerHousekeepingServiceService {
    private static Map<String,Object> map = null;
    @Resource
    ButlerHousekeepingServiceDao butlerHousekeepingServiceDao;
    @Resource
    ButlerRepairDao butlerRepairDao;
    @Resource
    AppHousekeepingServiceDao appHousekeepingServiceDao;
    @Resource
    ButlerAppMessageDao butlerAppMessageDao;

    @Override
    public List<AppHousekeepingServiceVo> list(ButlerHousekeepingServiceSearch butlerHousekeepingServiceSearch, int type) {
        List<AppHousekeepingServiceVo> housekeepingServiceVoList = new ArrayList<>();
        switch (type){
            case 1:
                //派单人界面
                housekeepingServiceVoList = butlerHousekeepingServiceDao.list1(butlerHousekeepingServiceSearch);
                break;
            case 2:
                //接单人界面
                housekeepingServiceVoList = butlerHousekeepingServiceDao.list2(butlerHousekeepingServiceSearch);
                break;
            default:
                //系统错误
                break;
        }

        if (housekeepingServiceVoList != null && housekeepingServiceVoList.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (AppHousekeepingServiceVo appHousekeepingServiceVo : housekeepingServiceVoList) {
                //填入提交照片资源信息
                List<VoResourcesImg> submitImg = uploadUtil.findImgByDate("sysHouseKeepingService", appHousekeepingServiceVo.getId(), "submitImg");
                appHousekeepingServiceVo.setSubmitImgList(submitImg);

                //填入评价照片资源信息
                List<VoResourcesImg> evaluationImg = uploadUtil.findImgByDate("sysHouseKeepingService", appHousekeepingServiceVo.getId(), "evaluationImg");
                appHousekeepingServiceVo.setEvaluationImgList(evaluationImg);

                //填入处理完成照片资源信息
                List<VoResourcesImg> handlerImg = uploadUtil.findImgByDate("sysHouseKeepingService", appHousekeepingServiceVo.getId(), "handlerImg");
                appHousekeepingServiceVo.setHandlerImgList(handlerImg);

            }
        }
        return housekeepingServiceVoList;
    }


    @Override
    public Map<String, Object> findPickUpSinglePersonnel(int organizationId) {
        map = new HashMap<>();
        List<SysUser> sysUser = butlerHousekeepingServiceDao.findPickUpSinglePersonnel(organizationId);
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sysUser);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> sendSingle(AppHousekeepingService appHousekeepingService, String roleId) {
        map = new HashMap<>();
        try {
            int type = findJurisdictionByUserId(roleId);
            if (type != 1){
                throw new RuntimeException("派单权限不足");
            }

            AppHousekeepingService housekeepingServiceById = appHousekeepingServiceDao.findHousekeepingServiceById(appHousekeepingService.getId());
            if (housekeepingServiceById.getStatus() != 1){
                throw new RuntimeException("当前状态不可派单");
            }

            appHousekeepingService.setStatus(2);//2.已派单
            int update = butlerHousekeepingServiceDao.sendSingle(appHousekeepingService);
            if (update <= 0){
                throw new RuntimeException("派单失败");
            }

            //添加家政服务处理进程记录
            AppHousekeepingServiceProcessRecord processRecord = new AppHousekeepingServiceProcessRecord();
            processRecord.setHousekeepingServiceId(appHousekeepingService.getId());
            processRecord.setOperationDate(new Date());
            processRecord.setOperationType(2);//2.派单
            processRecord.setOperator(appHousekeepingService.getAssigner());
            processRecord.setOperatorType(3);//3.操作人（物业）

            //查询被指派人信息
            SysUser sysUser  = appHousekeepingServiceDao.findUserInfoById(appHousekeepingService.getHandler());

            processRecord.setOperatorContent("分派给"+sysUser.getActualName()+"师傅");
            int insert2 = appHousekeepingServiceDao.insertHousekeepingProcessRecord(processRecord);
            if (insert2 <= 0){
                throw new RuntimeException("提交服务进程失败");
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
        map.put("message","派单成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> orderReceiving(AppHousekeepingService appHousekeepingService, Integer id) {
        map = new HashMap<>();
        try {
            AppHousekeepingService housekeepingServiceById = appHousekeepingServiceDao.findHousekeepingServiceById(appHousekeepingService.getId());
            if (housekeepingServiceById.getHandler() != id){
                throw new RuntimeException("接单失败,接单人有误");
            }

            if (housekeepingServiceById.getStatus() != 2){//2.已派单（待接单）
                throw new RuntimeException("当前状态不可接单");
            }

            appHousekeepingService.setStatus(3);//3.处理中
            int update = appHousekeepingServiceDao.orderReceiving(appHousekeepingService);
            if (update <= 0){
                throw new RuntimeException("接单失败");
            }

            //添加家政服务处理进程记录
            AppHousekeepingServiceProcessRecord processRecord = new AppHousekeepingServiceProcessRecord();
            processRecord.setHousekeepingServiceId(housekeepingServiceById.getId());
            processRecord.setOperationDate(new Date());
            processRecord.setOperationType(3);//3.开始处理
            processRecord.setOperator(housekeepingServiceById.getHandler());
            processRecord.setOperatorType(3);//3.操作人（物业）

            //查询被指派人信息
            SysUser sysUser  = appHousekeepingServiceDao.findUserInfoById(housekeepingServiceById.getHandler());

            processRecord.setOperatorContent(sysUser.getActualName()+"师傅已接单处理中");
            int insert2 = appHousekeepingServiceDao.insertHousekeepingProcessRecord(processRecord);
            if (insert2 <= 0){
                throw new RuntimeException("提交服务进程失败");
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
        map.put("message","接单成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> submitReport(AppHousekeepingService appHousekeepingService, Integer id) {
        map = new HashMap<>();

        try {
            AppHousekeepingService housekeepingServiceById = appHousekeepingServiceDao.findHousekeepingServiceById(appHousekeepingService.getId());
            if (housekeepingServiceById.getHandler() != id){
                throw new RuntimeException("操作失败,操作人有误");
            }

            if (housekeepingServiceById.getStatus() != 3){//3.处理中
                throw new RuntimeException("当前状态不可进行该操作");
            }

            if (!(appHousekeepingService.getMaterialFee().add(appHousekeepingService.getServiceFee()).compareTo(appHousekeepingService.getPayFee()) == 0)){
                throw new RuntimeException("总计费用计算有误");
            }

            appHousekeepingService.setStatus(4);//填入4.待支付
            appHousekeepingService.setHandlingTime(new Date());//填入处理时间

            int update = appHousekeepingServiceDao.submitReport(appHousekeepingService);
            if (update <= 0){
                throw new RuntimeException("提交失败");
            }

            //添加家政服务处理进程记录
            AppHousekeepingServiceProcessRecord processRecord = new AppHousekeepingServiceProcessRecord();
            processRecord.setHousekeepingServiceId(appHousekeepingService.getId());
            processRecord.setOperationDate(new Date());
            processRecord.setOperationType(4);//4.处理完成
            processRecord.setOperator(id);
            processRecord.setOperatorType(3);//3.操作人（物业）

            //查询被指派人信息
            SysUser sysUser  = appHousekeepingServiceDao.findUserInfoById(housekeepingServiceById.getHandler());

            processRecord.setOperatorContent(sysUser.getActualName()+"师傅已提交工作汇报");
            int insert2 = appHousekeepingServiceDao.insertHousekeepingProcessRecord(processRecord);
            if (insert2 <= 0){
                throw new RuntimeException("提交服务进程失败");
            }

            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(appHousekeepingService.getHandlerImgUrls(),"sysHouseKeepingService", appHousekeepingService.getId(), "handlerImg","600",30,20);

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
        map.put("message","提交成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> urgedWorkers(Integer housekeepingServiceId,Integer id) {
        map = new HashMap<>();

        try {
            AppHousekeepingService byId = appHousekeepingServiceDao.findHousekeepingServiceById(housekeepingServiceId);
            if (byId == null){
                throw new RuntimeException("该单子不存在");
            }

            if (byId.getStatus() != 2){
                throw new RuntimeException("当前状态不可催促人员");
            }

            ButlerAppSysMessage butlerAppSysMessage = new ButlerAppSysMessage();
            butlerAppSysMessage.setType(5);//5.家政服务主键id接单提醒
            butlerAppSysMessage.setRelationId(byId.getId());//新版家政服务主键id
            butlerAppSysMessage.setReceiverAccount(byId.getHandler());//填写接收人id
            butlerAppSysMessage.setSendStatus(1);//1.发送成功(未读)
            butlerAppSysMessage.setSendDate(new Date());//填写发送时间
            //添加管家app系统消息
            int insert3 = butlerAppMessageDao.insertSysMessage(butlerAppSysMessage);
            if (insert3 <= 0){
                throw new RuntimeException("添加系统消息失败");
            }


            JiguangUtil.butlerPush(String.valueOf(byId.getHandler()),"家政服务接单提醒");
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
        map.put("message","发送成功");
        map.put("status",true);
        return map;
    }

    @Override
    public int findJurisdictionByUserId(String roleIds) {
        String[] split = roleIds.split(",");
        if (split.length >0){
            for (String s : split) {
                int roleId = Integer.parseInt(s);
                //根据角色id查询权限id集合//TODO 数据库返回n个，代码返回就10个
                List<Integer> jurisdictionIds = butlerRepairDao.findJIdsByRoleId(roleId);
                if (jurisdictionIds != null && jurisdictionIds.size()>0){
//                    if (jurisdictionIds.contains(67)&&jurisdictionIds.contains(68)){
//                        return 3;
//                    }

                    //52.派单（当派单权限和接单权限都存在时，当作派单权限处理）
                    if (jurisdictionIds.contains(67)){
                        return 1;
                    }
                    //53.接单
                    if (jurisdictionIds.contains(68)){
                        return 2;
                    }
                }
            }
        }
        return 3;
    }
}
