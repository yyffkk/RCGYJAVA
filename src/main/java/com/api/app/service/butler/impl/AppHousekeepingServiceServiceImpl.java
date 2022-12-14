package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppHousekeepingServiceDao;
import com.api.app.service.butler.AppHousekeepingServiceService;
import com.api.common.GetSysUserIds;
import com.api.manage.dao.message.ManageSysMessageDao;
import com.api.model.app.AppHousekeepingService;
import com.api.model.app.AppHousekeepingServiceProcessRecord;
import com.api.model.app.SearchAppHousekeepingService;
import com.api.model.app.UserIdAndHousekeepingServiceId;
import com.api.model.message.ManageSysMessage;
import com.api.util.UploadUtil;
import com.api.vo.app.AppHousekeepingServiceVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class AppHousekeepingServiceServiceImpl implements AppHousekeepingServiceService {
    private static Map<String,Object> map = null;
    @Resource
    AppHousekeepingServiceDao appHousekeepingServiceDao;
    @Resource
    ManageSysMessageDao manageSysMessageDao;


    @Override
    @Transactional
    public Map<String, Object> submitHousekeeping(AppHousekeepingService appHousekeepingService, String name) {
        map = new HashMap<>();

        try {
            appHousekeepingService.setStatus(1);//状态：默认填1.待派单
            //添加家政服务信息
            int insert = appHousekeepingServiceDao.submitHousekeeping(appHousekeepingService);
            if (insert <= 0){
                throw new RuntimeException("提交失败");
            }

            //添加家政服务处理进程记录
            AppHousekeepingServiceProcessRecord processRecord = new AppHousekeepingServiceProcessRecord();
            processRecord.setHousekeepingServiceId(appHousekeepingService.getId());
            processRecord.setOperationDate(new Date());
            processRecord.setOperationType(1);//1.提交家政
            processRecord.setOperator(appHousekeepingService.getCreateId());
            processRecord.setOperatorType(1);//1.住户
            String content = "";
            if (appHousekeepingService.getType() == 1){
                content = "室内清洁";
            }else if (appHousekeepingService.getType() == 2){
                content = "洗涤护理";
            }else {
                content = "其他服务";
            }
            processRecord.setOperatorContent("申请服务-"+content);
            int insert2 = appHousekeepingServiceDao.insertHousekeepingProcessRecord(processRecord);
            if (insert2 <= 0){
                throw new RuntimeException("提交服务进程失败");
            }

            GetSysUserIds getSysUserIds = new GetSysUserIds();
            HashSet<Integer> userIds = getSysUserIds.FindSysUserIdsByJurisdictionId(52);//52.报事报修派单
            for (Integer userId : userIds) {
                //添加后台消息列表
                ManageSysMessage manageSysMessage = new ManageSysMessage();
                manageSysMessage.setContent("有住户 "+name+" 发起新的家政服务，请及时查看并进行派单分配");
                manageSysMessage.setType(5);//5.家政服务
                manageSysMessage.setRelationId(appHousekeepingService.getId());//填入家政服务主键id
                manageSysMessage.setReceiverAccountId(userId);//填入接收人
                manageSysMessage.setSenderId(appHousekeepingService.getCreateId());//填入发送人id
                manageSysMessage.setSenderType(2);//2.业主
                manageSysMessage.setSendStatus(1);//1.发送成功（未读）
                manageSysMessage.setSendDate(new Date());
                int insert4 = manageSysMessageDao.insert(manageSysMessage);
                if (insert4 <= 0){
                    throw new RuntimeException("后台消息列表发送失败");
                }
            }

            //上传家政服务提交照片
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(appHousekeepingService.getSubmitImgUrls(),"sysHouseKeepingService",appHousekeepingService.getId(),"submitImg","600",30,20);

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
    public List<AppHousekeepingServiceVo> list(SearchAppHousekeepingService searchAppHousekeepingService) {
        List<AppHousekeepingServiceVo> list = appHousekeepingServiceDao.list(searchAppHousekeepingService);
        if (list != null && list.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (AppHousekeepingServiceVo appHousekeepingServiceVo : list) {
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
        return list;
    }

    @Override
    public Map<String, Object> findHousekeepingProcessRecord(Integer housekeepingServiceId) {
        map = new HashMap<>();
        List<AppHousekeepingServiceProcessRecord> processRecords = appHousekeepingServiceDao.findHousekeepingProcessRecord(housekeepingServiceId);

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",processRecords);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> cancel(UserIdAndHousekeepingServiceId userIdAndHousekeepingServiceId) {
        map = new HashMap<>();
        try {
            AppHousekeepingService appHousekeepingService = appHousekeepingServiceDao.findHousekeepingServiceById(userIdAndHousekeepingServiceId.getHousekeepingServiceId());
            if (!(appHousekeepingService.getStatus() == 1 || appHousekeepingService.getStatus() == 2)){
                throw new RuntimeException("当前状态不可取消服务");
            }

            int update = appHousekeepingServiceDao.cancel(userIdAndHousekeepingServiceId);
            if (update <= 0){
                throw new RuntimeException("取消失败");
            }

            //添加家政服务处理进程记录
            AppHousekeepingServiceProcessRecord processRecord = new AppHousekeepingServiceProcessRecord();
            processRecord.setHousekeepingServiceId(userIdAndHousekeepingServiceId.getHousekeepingServiceId());
            processRecord.setOperationDate(new Date());
            processRecord.setOperationType(9);//9.取消
            processRecord.setOperator(userIdAndHousekeepingServiceId.getId());
            processRecord.setOperatorType(1);//1.住户

            processRecord.setOperatorContent("住户已取消");
            int insert2 = appHousekeepingServiceDao.insertHousekeepingProcessRecord(processRecord);
            if (insert2 <= 0){
                throw new RuntimeException("提交服务进程失败");
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
        map.put("message","取消成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> evaluation(AppHousekeepingService appHousekeepingService, Integer id) {
        map = new HashMap<>();


        try {
            AppHousekeepingService byId = appHousekeepingServiceDao.findHousekeepingServiceById(appHousekeepingService.getId());
            if (byId.getStatus() != 5){
                throw new RuntimeException("当前状态不可评价");
            }

            appHousekeepingService.setEvaluationTime(new Date());//填入评价时间
            appHousekeepingService.setStatus(6);//填入状态，6.已完成（已评价）
            int update = appHousekeepingServiceDao.evaluation(appHousekeepingService);
            if (update <= 0){
                throw new RuntimeException("评价失败");
            }

            //添加家政服务处理进程记录
            AppHousekeepingServiceProcessRecord processRecord = new AppHousekeepingServiceProcessRecord();
            processRecord.setHousekeepingServiceId(appHousekeepingService.getId());
            processRecord.setOperationDate(new Date());
            processRecord.setOperationType(6);//6.评价
            processRecord.setOperator(id);
            processRecord.setOperatorType(1);//1.住户

            processRecord.setOperatorContent("住户已评价");
            int insert2 = appHousekeepingServiceDao.insertHousekeepingProcessRecord(processRecord);
            if (insert2 <= 0){
                throw new RuntimeException("提交服务进程失败");
            }

            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(appHousekeepingService.getEvaluationImgUrls(),"sysHouseKeepingService",appHousekeepingService.getId(),"evaluationImg","600",30,20);
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
        map.put("message","评价成功");
        map.put("status",true);
        return map;
    }
}
