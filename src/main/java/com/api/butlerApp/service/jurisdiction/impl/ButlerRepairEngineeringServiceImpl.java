package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerRepairDao;
import com.api.butlerApp.dao.jurisdiction.ButlerRepairEngineeringDao;
import com.api.butlerApp.service.jurisdiction.ButlerRepairEngineeringService;
import com.api.model.businessManagement.SysOrganization;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.*;
import com.api.util.IdWorker;
import com.api.util.UploadUtil;
import com.api.vo.butlerApp.ButlerRepairEngineeringFBIVo;
import com.api.vo.butlerApp.ButlerRepairEngineeringVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ButlerRepairEngineeringServiceImpl implements ButlerRepairEngineeringService {
    @Resource
    ButlerRepairEngineeringDao butlerRepairEngineeringDao;
    @Resource
    ButlerRepairDao butlerRepairDao;
    private static Map<String,Object> map = null;

    @Override
    public List<ButlerRepairEngineeringVo> list(ButlerRepairEngineeringSearch butlerRepairEngineeringSearch, int type) {
        List<ButlerRepairEngineeringVo> list = new ArrayList<>();
        switch (type){
            case 1:
                //工程派单-维修公司
                list = butlerRepairEngineeringDao.list1(butlerRepairEngineeringSearch);
                break;
            case 2:
                //工程派单-维修人员
                list = butlerRepairEngineeringDao.list2(butlerRepairEngineeringSearch);
                break;
            case 3:
                //工程接单-维修人员
                list = butlerRepairEngineeringDao.list3(butlerRepairEngineeringSearch);
                break;
            case 4:
                //无任何权限
                break;
            default:
                //系统错误
                break;
        }

        if (list != null && list.size() > 0){
            UploadUtil uploadUtil = new UploadUtil();
            for (ButlerRepairEngineeringVo butlerRepairEngineeringVo : list) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysReportRepairEngineering", butlerRepairEngineeringVo.getId(), "engineeringMaintenanceImg");
                butlerRepairEngineeringVo.setImgUrls(imgByDate);
            }
        }
        return list;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(ButlerRepairEngineering butlerRepairEngineering) {
        map = new HashMap<>();

        try {
            butlerRepairEngineering.setCode(String.valueOf(new IdWorker(1,1,1).nextId()));

            int insert = butlerRepairEngineeringDao.insert(butlerRepairEngineering);
            if (insert <= 0){
                throw new RuntimeException("添加失败");
            }

            //添加处理进程记录
            ButlerReportRepairEngineeringProcessRecord engineeringProcessRecord = new ButlerReportRepairEngineeringProcessRecord();
            engineeringProcessRecord.setRepairEngineeringId(butlerRepairEngineering.getId());//填入工程维修主键id
            engineeringProcessRecord.setOperationDate(new Date());//填入操作时间(数据创建时间)
            engineeringProcessRecord.setOperationType(1);//填入操作类型，1.提交工程维修
            engineeringProcessRecord.setOperator(butlerRepairEngineering.getCreateId());//操作人（取自住户表或物业表）
            engineeringProcessRecord.setOperatorType(3);//填入操作人类型，3.操作人（物业）
            engineeringProcessRecord.setOperatorContent("等待物业分配");//填入操作内容


            //添加工程维修报修进程处理进程记录
            int insert2 = butlerRepairEngineeringDao.insertProcessRecord(engineeringProcessRecord);
            if (insert2 <= 0){
                throw new RuntimeException("添加处理进程记录失败");
            }

            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(butlerRepairEngineering.getFileUrls(),"sysReportRepairEngineering",butlerRepairEngineering.getId(),"engineeringMaintenanceImg","600",30,20);
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
        map.put("message","添加成功");
        map.put("status",true);
        return map;
    }

    @Override
    public int findJurisdictionByUserId(String roleIds) {
        String[] split = roleIds.split(",");
        if (split.length >0){
            for (String s : split) {
                int roleId = Integer.parseInt(s);
                //根据角色id查询权限id集合
                List<Integer> jurisdictionIds = butlerRepairDao.findJIdsByRoleId(roleId);
                if (jurisdictionIds != null && jurisdictionIds.size()>0){
                    //69.工程派单-维修公司
                    if (jurisdictionIds.contains(69)){
                        return 1;
                    }
                    //70.工程派单-维修人员
                    if (jurisdictionIds.contains(70)){
                        return 2;
                    }
                    //71.工程接单-维修人员
                    if (jurisdictionIds.contains(71)){
                        return 3;
                    }
                }
            }
        }
        return 4;
    }

    @Override
    public Map<String, Object> findById(Integer repairEngineeringId) {
        map = new HashMap<>();

        ButlerRepairEngineeringFBIVo engineeringFBIVo = butlerRepairEngineeringDao.findById(repairEngineeringId);
        if (engineeringFBIVo != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysReportRepairEngineering", repairEngineeringId, "engineeringMaintenanceImg");
            engineeringFBIVo.setImgUrls(imgByDate);
        }

        map.put("message","请求成功");
        map.put("data",engineeringFBIVo);
        map.put("status",true);

        return map;
    }

    @Override
    public Map<String, Object> findProcessRecordById(Integer repairEngineeringId) {
        map = new HashMap<>();

        List<ButlerReportRepairEngineeringProcessRecord> repairEngineeringProcessRecordList = butlerRepairEngineeringDao.findProcessRecordById(repairEngineeringId);

        map.put("message","请求成功");
        map.put("data",repairEngineeringProcessRecordList);
        map.put("status",true);

        return map;
    }

    @Override
    public Map<String, Object> findRepairOrganization() {
        map = new HashMap<>();

        List<SysOrganization> sysOrganizationList = butlerRepairEngineeringDao.findRepairOrganization();

        map.put("message","请求成功");
        map.put("data",sysOrganizationList);
        map.put("status",true);

        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> maintenanceCompanySendSingle(ButlerRepairEngineering butlerRepairEngineering, int type) {
        map = new HashMap<>();

        try {
            ButlerRepairEngineeringFBIVo byId = butlerRepairEngineeringDao.findById(butlerRepairEngineering.getId());
            if (byId.getStatus() != 1){
                throw new RuntimeException("当前状态不可进行该操作");
            }

            if (type != 1){
                map.put("message","派单(维修公司)权限不足");
                map.put("status",false);
                return map;
            }

            butlerRepairEngineering.setStatus(2);//填入状态，2.待派单（维修人员）

            int update = butlerRepairEngineeringDao.maintenanceCompanySendSingle(butlerRepairEngineering);
            if (update <= 0){
                throw new RuntimeException("派单失败");
            }

            //添加处理进程记录
            ButlerReportRepairEngineeringProcessRecord engineeringProcessRecord = new ButlerReportRepairEngineeringProcessRecord();
            engineeringProcessRecord.setRepairEngineeringId(butlerRepairEngineering.getId());//填入工程维修主键id
            engineeringProcessRecord.setOperationDate(new Date());//填入操作时间(数据创建时间)
            engineeringProcessRecord.setOperationType(2);//填入操作类型，2.派单（维修公司）
            engineeringProcessRecord.setOperator(butlerRepairEngineering.getMaintenanceCompanySendSingle());//操作人（维修公司派单人id）
            engineeringProcessRecord.setOperatorType(3);//填入操作人类型，3.操作人（物业）
            engineeringProcessRecord.setOperatorContent("维修公司正在派单");//填入操作内容


            //添加工程维修报修进程处理进程记录
            int insert2 = butlerRepairEngineeringDao.insertProcessRecord(engineeringProcessRecord);
            if (insert2 <= 0){
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
        map.put("message","派单成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findSysUserByOrganizationId(Integer repairOrganizationId) {
        map = new HashMap<>();

        List<SysUser> sysUserList = butlerRepairEngineeringDao.findSysUserByOrganizationId(repairOrganizationId);

        map.put("message","请求成功");
        map.put("data",sysUserList);
        map.put("status",true);

        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> maintenancePersonnelSendSingle(ButlerRepairEngineering butlerRepairEngineering, int type) {
        map = new HashMap<>();

        try {

            ButlerRepairEngineeringFBIVo byId2 = butlerRepairEngineeringDao.findById(butlerRepairEngineering.getId());
            if (byId2.getStatus() != 2){
                throw new RuntimeException("当前状态不可进行该操作");
            }

            if (type != 2){
                throw new RuntimeException("派单(维修人员)权限不足");
            }

            butlerRepairEngineering.setStatus(3);//填入状态，3.待接单（维修人员）

            int update = butlerRepairEngineeringDao.maintenancePersonnelSendSingle(butlerRepairEngineering);
            if (update <= 0){
                throw new RuntimeException("派单失败");
            }

            //添加处理进程记录
            ButlerReportRepairEngineeringProcessRecord engineeringProcessRecord = new ButlerReportRepairEngineeringProcessRecord();
            engineeringProcessRecord.setRepairEngineeringId(butlerRepairEngineering.getId());//填入工程维修主键id
            engineeringProcessRecord.setOperationDate(new Date());//填入操作时间(数据创建时间)
            engineeringProcessRecord.setOperationType(3);//填入操作类型，3.派单（维修人员）
            engineeringProcessRecord.setOperator(butlerRepairEngineering.getMaintenancePersonnelSendSingle());//操作人（维修人员派单人id）
            engineeringProcessRecord.setOperatorType(3);//填入操作人类型，3.操作人（物业）
            //查询维修人信息
            SysUser byId = butlerRepairDao.findSysUserById(butlerRepairEngineering.getMaintenanceStaff());
            engineeringProcessRecord.setOperatorContent("分派给 "+byId.getActualName()+" 师傅");//填入操作内容


            //添加工程维修报修进程处理进程记录
            int insert2 = butlerRepairEngineeringDao.insertProcessRecord(engineeringProcessRecord);
            if (insert2 <= 0){
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
        map.put("message","派单成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> maintenanceStaffPickSingle(ButlerRepairEngineering butlerRepairEngineering, int type) {
        map = new HashMap<>();

        try {
            ButlerRepairEngineeringFBIVo byId2 = butlerRepairEngineeringDao.findById(butlerRepairEngineering.getId());
            if (byId2.getStatus() != 3){
                throw new RuntimeException("当前状态不可进行该操作");
            }

            if (type != 3){
                throw new RuntimeException("接单(维修人员)权限不足");
            }

            butlerRepairEngineering.setStatus(4);//填入状态，4.处理中

            int update = butlerRepairEngineeringDao.maintenanceStaffPickSingle(butlerRepairEngineering);
            if (update <= 0){
                throw new RuntimeException("接单失败");
            }

            //添加处理进程记录
            ButlerReportRepairEngineeringProcessRecord engineeringProcessRecord = new ButlerReportRepairEngineeringProcessRecord();
            engineeringProcessRecord.setRepairEngineeringId(butlerRepairEngineering.getId());//填入工程维修主键id
            engineeringProcessRecord.setOperationDate(new Date());//填入操作时间(数据创建时间)
            engineeringProcessRecord.setOperationType(4);//填入操作类型，4.接单（维修人员）
            engineeringProcessRecord.setOperator(butlerRepairEngineering.getMaintenanceStaff());//操作人（维修人员派单人id）
            engineeringProcessRecord.setOperatorType(3);//填入操作人类型，3.操作人（物业）
            //查询维修人信息
            SysUser byId = butlerRepairDao.findSysUserById(butlerRepairEngineering.getMaintenanceStaff());
            engineeringProcessRecord.setOperatorContent(byId.getActualName()+" 师傅正在处理");//填入操作内容

            //添加工程维修报修进程处理进程记录
            int insert2 = butlerRepairEngineeringDao.insertProcessRecord(engineeringProcessRecord);
            if (insert2 <= 0){
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
        map.put("message","接单成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> submitReport(ButlerRepairEngineeringReport butlerRepairEngineeringReport, int type) {
        map = new HashMap<>();


        try {
            ButlerRepairEngineeringFBIVo byId2 = butlerRepairEngineeringDao.findById(butlerRepairEngineeringReport.getRepairEngineeringId());
            if (byId2.getStatus() != 4 && byId2.getStatus() != 6){//4.处理中，6.验收失败
                throw new RuntimeException("当前状态不可进行该操作");
            }

            if (type != 3){
                throw new RuntimeException("接单(维修人员)权限不足");
            }

            //提交工作汇报
            int insert = butlerRepairEngineeringDao.submitReport(butlerRepairEngineeringReport);
            if (insert <= 0){
                throw new RuntimeException("提交失败");
            }

            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(butlerRepairEngineeringReport.getWorkReportImgUrls(),"sysReportRepairEngineeringReport",butlerRepairEngineeringReport.getId(),"workReportImg","600",30,20);

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
    public Map<String, Object> completeMaintenance(ButlerRepairEngineeringMaintenanceResults butlerRepairEngineeringMaintenanceResults, int type) {
        map = new HashMap<>();


        try {
            ButlerRepairEngineeringFBIVo byId2 = butlerRepairEngineeringDao.findById(butlerRepairEngineeringMaintenanceResults.getRepairEngineeringId());
            if (byId2.getStatus() != 4 && byId2.getStatus() != 6){//4.处理中，6.验收失败
                throw new RuntimeException("当前状态不可进行该操作");
            }

            if (type != 3){
                throw new RuntimeException("接单(维修人员)权限不足");
            }

            //完成维修
            int insert = butlerRepairEngineeringDao.completeMaintenance(butlerRepairEngineeringMaintenanceResults);
            if (insert <= 0){
                throw new RuntimeException("提交失败");
            }

            //添加处理进程记录
            ButlerReportRepairEngineeringProcessRecord engineeringProcessRecord = new ButlerReportRepairEngineeringProcessRecord();
            engineeringProcessRecord.setRepairEngineeringId(butlerRepairEngineeringMaintenanceResults.getRepairEngineeringId());//填入工程维修主键id
            engineeringProcessRecord.setOperationDate(new Date());//填入操作时间(数据创建时间)
            engineeringProcessRecord.setOperationType(5);//填入操作类型，5.处理完成
            engineeringProcessRecord.setOperator(butlerRepairEngineeringMaintenanceResults.getCreateId());//操作人（维修人员接单人id）
            engineeringProcessRecord.setOperatorType(3);//填入操作人类型，3.操作人（物业）
            engineeringProcessRecord.setOperatorContent("等待物业验收");//填入操作内容

            //添加工程维修报修进程处理进程记录
            int insert2 = butlerRepairEngineeringDao.insertProcessRecord(engineeringProcessRecord);
            if (insert2 <= 0){
                throw new RuntimeException("添加处理进程记录失败");
            }

            ButlerRepairEngineering butlerRepairEngineering = new ButlerRepairEngineering();
            butlerRepairEngineering.setId(butlerRepairEngineeringMaintenanceResults.getRepairEngineeringId());//填入工程维修主键id
            butlerRepairEngineering.setStatus(5);//填入5.已处理（待验收）

            //修改工程维修状态
            int update = butlerRepairEngineeringDao.updateStatusById(butlerRepairEngineering);
            if (update <= 0){
                throw new RuntimeException("修改工程维修状态失败");
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
        map.put("message","提交成功");
        map.put("status",true);
        return map;
    }
}
