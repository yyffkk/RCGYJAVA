package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppReportRepairDao;
import com.api.app.service.butler.AppReportRepairService;
import com.api.manage.dao.butlerService.SysDispatchListDao;
import com.api.manage.dao.butlerService.SysProcessRecordDao;
import com.api.manage.dao.butlerService.SysReportRepairDao;
import com.api.model.app.AppRepairEvaluate;
import com.api.model.app.UserIdAndRepairId;
import com.api.model.butlerService.DispatchList;
import com.api.model.butlerService.ProcessRecord;
import com.api.model.butlerService.ReportRepair;
import com.api.util.UploadUtil;
import com.api.vo.app.AppDispatchListVo;
import com.api.vo.app.AppMaintenanceResultVo;
import com.api.vo.app.AppProcessRecordVo;
import com.api.vo.app.AppReportRepairVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class AppReportRepairServiceImpl implements AppReportRepairService {
    @Resource
    AppReportRepairDao appReportRepairDao;
    @Resource
    SysDispatchListDao sysDispatchListDao;
    @Resource
    SysReportRepairDao sysReportRepairDao;
    @Resource
    SysProcessRecordDao sysProcessRecordDao;
    private static Map<String,Object> map = null;

    @Override
    public List<AppReportRepairVo> list(Integer id) {
        List<AppReportRepairVo> list = appReportRepairDao.list(id);
        if (list != null && list.size() >0){
            for (AppReportRepairVo appReportRepairVo : list) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysReportRepair", appReportRepairVo.getId(), "repairImg");
                appReportRepairVo.setImgUrls(imgByDate);
            }
        }
        return list;
    }

    @Override
    public Map<String, Object> findById(UserIdAndRepairId userIdAndRepairId) {
        map = new HashMap<>();
        //根据用户id和报事报修主键id查询app报事报修Vo
        AppReportRepairVo appReportRepairVo = appReportRepairDao.findRepairByIds(userIdAndRepairId);
        if (appReportRepairVo == null){
            map.put("message","此订单不存在或被删除");
            map.put("status",false);
            return map;
        }
        UploadUtil uploadUtil = new UploadUtil();
        List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysReportRepair", appReportRepairVo.getId(), "repairImg");
        appReportRepairVo.setImgUrls(imgByDate);
        map.put("appReportRepairVo",appReportRepairVo);

        //根据用户id和报事报修主键id查询app维修信息
        AppDispatchListVo appDispatchListVo = appReportRepairDao.findDispatchListByIds(userIdAndRepairId);
        map.put("appDispatchListVo",appDispatchListVo);

        //根据用户id和报事报修主键id查询app进程处理集合
        List<AppProcessRecordVo>  appProcessRecordVoList = appReportRepairDao.findProcessRecordByIds(userIdAndRepairId);
        map.put("appProcessRecordVo",appProcessRecordVoList);

        //根据 用户id和报事报修主键id 查询维修结果信息
        AppMaintenanceResultVo appMaintenanceResultVo = appReportRepairDao.findHandleCompleteByIds(userIdAndRepairId);
        if (appMaintenanceResultVo != null){
            UploadUtil uploadUtil1 = new UploadUtil();
            List<VoResourcesImg> imgByDate1 = uploadUtil1.findImgByDate("sysHandleCompleteDetail", appMaintenanceResultVo.getId(), "maintenanceResultImg");
            appMaintenanceResultVo.setImgUrls(imgByDate1);
        }
        map.put("appMaintenanceResultVo",appMaintenanceResultVo);

        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(ReportRepair reportRepair, Integer id, String tel) {
        map = new HashMap<>();
        try {
            //生成单号
            String code = UUID.randomUUID().toString().replaceAll("-", "");
            //先创建报修工单
            DispatchList dispatchList = new DispatchList();
            //填入工单号（UUid随机生成）
            dispatchList.setCode(code);
            //填入工单类型（取自工单类型管理）
            dispatchList.setWorkOrderType(1);
            //填入状态（1.待分配，2.已分配未接单，3.已分配处理中，4.已处理，5.已确认已完成，6.已关闭，7.已作废）
            dispatchList.setStatus(1);
            //填入创建人
            dispatchList.setCreateId(id);
            //填入创建时间
            dispatchList.setCreateDate(new Date());
            //填入 是否删除，0删除，1非删（用户端删除）
            dispatchList.setUserDelete(1);
            //填入 是否删除，0删除，1非删（系统端删除）
            dispatchList.setSysDelete(1);
            //添加工单信息
            int insert = sysDispatchListDao.insert(dispatchList);
            if (insert <= 0){
                throw new RuntimeException("添加工单信息失败");
            }
            //添加报事报修信息
            //填入创建人
            reportRepair.setCreateId(-1);
            //填入创建时间
            reportRepair.setCreateDate(new Date());
            //填入单号
            reportRepair.setCode(code);
            //填入派工单id(工单主键id)
            reportRepair.setDispatchListId(dispatchList.getId());
            //填入报修人id
            reportRepair.setRepairman(id);
            //填入报修人联系方式
            reportRepair.setTel(tel);
            //填入报修时间（下单时间）
            reportRepair.setRepairDate(new Date());
            //填入报修来源，2.app提交
            reportRepair.setFroms(2);
            //添加报事报修信息
            int insert2 = sysReportRepairDao.insert(reportRepair);
            if (insert2 <= 0){
                throw new RuntimeException("添加报事报修信息失败");
            }
            //将上传路径传入数据库
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(reportRepair.getFileUrls(),"sysReportRepair",reportRepair.getId(),"repairImg","600",30,20);

            //添加处理进程记录
            ProcessRecord processRecord = new ProcessRecord();
            //填入派工单id
            processRecord.setDispatchListId(dispatchList.getId());
            //填入操作时间（数据创建时间）
            processRecord.setOperationDate(new Date());
            //填入操作类型（1.提交报修，2.派单，3.开始处理，4.处理完成，5.确认，6.回访，7.回退，8.作废，9.取消）
            processRecord.setOperationType(1);
            //填入操作人（取自住户表或物业表）
            processRecord.setOperator(id);
            //填入操作人类型（1.住户，2.管家（物业）,3.操作人（物业））
            processRecord.setOperatorType(1);
            //填入操作内容
            processRecord.setOperatorContent("您的工单正在等待分配");
            int insert3 = sysProcessRecordDao.insert(processRecord);
            if (insert3 <= 0){
                throw new RuntimeException("添加处理进程记录失败");
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
        map.put("message","添加工单信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> falseDelete(int[] ids, Integer id) {
        map = new HashMap<>();
        try {
            UserIdAndRepairId userIdAndRepairId = new UserIdAndRepairId();
            userIdAndRepairId.setId(id);
            for (int repairId : ids) {
                userIdAndRepairId.setRepairId(repairId);
                //假删除报事报修信息，将工单表的 用户端删除字段 改为 0.删除
                int update = appReportRepairDao.falseDelete(userIdAndRepairId);
                if (update <= 0){
                    throw new RuntimeException("删除失败");
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
        map.put("message","删除成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> cancel(UserIdAndRepairId userIdAndRepairId, String name) {
        map = new HashMap<>();
        AppReportRepairVo repairByIds = appReportRepairDao.findRepairByIds(userIdAndRepairId);
        if (repairByIds == null){
            map.put("message","此订单不存在或被删除");
            map.put("status",false);
            return map;
        }
        //状态（1.待分配，2.已分配未接单，3.已分配处理中，4.已处理，5.已确认已完成，6.已关闭，7.已作废，8.已取消）
        if (repairByIds.getStatus() >= 2){
            if (repairByIds.getStatus() >=4){
                map.put("message","订单已结束，无法取消订单");
                map.put("status",false);
                return map;
            }
            map.put("message","订单正在处理中，当前无法处理订单");
            map.put("status",false);
            return map;
        }

        try {
            int update = appReportRepairDao.cancel(userIdAndRepairId);
            if (update <= 0){
                throw new RuntimeException("取消订单失败");
            }

            //根据用户id和报事报修主键id 查询派工单id
            int dispatchListId = appReportRepairDao.findDispatchListIdByIds(userIdAndRepairId);
            //添加处理进程记录
            ProcessRecord processRecord = new ProcessRecord();
            //填入派工单id
            processRecord.setDispatchListId(dispatchListId);
            //填入操作时间（数据创建时间）
            processRecord.setOperationDate(new Date());
            //填入操作类型（1.提交报修，2.派单，3.开始处理，4.处理完成，5.确认，6.回访，7.回退，8.作废，9.取消）
            processRecord.setOperationType(9);
            //填入操作人（取自住户表或物业表）
            processRecord.setOperator(userIdAndRepairId.getId());
            //填入操作人类型（1.住户，2.管家（物业）,3.操作人（物业））
            processRecord.setOperatorType(1);
            //填入操作内容
            processRecord.setOperatorContent(name+"取消了订单");
            int insert3 = sysProcessRecordDao.insert(processRecord);
            if (insert3 <= 0){
                throw new RuntimeException("添加处理进程记录失败");
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
        map.put("message","取消订单成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> completeOrder(UserIdAndRepairId userIdAndRepairId, String name) {
        map = new HashMap<>();
        try {
            //用户确认完成订单，改变报修单状态为 5.已确认已完成
            int update = appReportRepairDao.completeOrder(userIdAndRepairId);
            if (update <= 0){
                throw new RuntimeException("确认订单失败");
            }
            //根据用户id和报事报修主键id 查询派工单id
            int dispatchListId = appReportRepairDao.findDispatchListIdByIds(userIdAndRepairId);
            //添加处理进程记录
            ProcessRecord processRecord = new ProcessRecord();
            //填入派工单id
            processRecord.setDispatchListId(dispatchListId);
            //填入操作时间（数据创建时间）
            processRecord.setOperationDate(new Date());
            //填入操作类型（1.提交报修，2.派单，3.开始处理，4.处理完成，5.确认，6.回访，7.回退，8.作废，9.取消）
            processRecord.setOperationType(5);
            //填入操作人（取自住户表或物业表）
            processRecord.setOperator(userIdAndRepairId.getId());
            //填入操作人类型（1.住户，2.管家（物业）,3.操作人（物业））
            processRecord.setOperatorType(1);
            //填入操作内容
            processRecord.setOperatorContent(name+"确认了订单");
            int insert3 = sysProcessRecordDao.insert(processRecord);
            if (insert3 <= 0){
                throw new RuntimeException("添加处理进程记录失败");
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
        map.put("message","确认订单成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> evaluate(AppRepairEvaluate appRepairEvaluate) {
        map = new HashMap<>();
        //填入评价时间
        appRepairEvaluate.setEvaluationDate(new Date());
        //用户评价
        int update = appReportRepairDao.evaluate(appRepairEvaluate);
        if (update > 0){
            map.put("message","评价成功");
            map.put("status",true);
        }else {
            map.put("message","评价失败");
            map.put("status",false);
        }
        return map;
    }
}
