package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppHousekeepingServiceDao;
import com.api.app.service.butler.AppHousekeepingServiceService;
import com.api.model.app.AppHousekeepingService;
import com.api.model.app.AppHousekeepingServiceProcessRecord;
import com.api.model.app.SearchAppHousekeepingService;
import com.api.model.app.UserIdAndHousekeepingServiceId;
import com.api.util.UploadUtil;
import com.api.vo.app.AppHousekeepingServiceVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppHousekeepingServiceServiceImpl implements AppHousekeepingServiceService {
    private static Map<String,Object> map = null;
    @Resource
    AppHousekeepingServiceDao appHousekeepingServiceDao;


    @Override
    @Transactional
    public Map<String, Object> submitHousekeeping(AppHousekeepingService appHousekeepingService) {
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
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysHouseKeepingService", appHousekeepingServiceVo.getId(), "submitImg");
                appHousekeepingServiceVo.setSubmitImgList(imgByDate);
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
}
