package com.api.manage.service.butlerService.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerRepairEngineeringDao;
import com.api.manage.dao.butlerService.SysRepairEngineeringDao;
import com.api.manage.service.butlerService.SysRepairEngineeringService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.ButlerRepairEngineering;
import com.api.model.butlerApp.ButlerReportRepairEngineeringProcessRecord;
import com.api.model.butlerService.SearchRepairEngineering;
import com.api.util.IdWorker;
import com.api.util.UploadUtil;
import com.api.vo.butlerService.*;
import com.api.vo.resources.VoResourcesImg;
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
public class SysRepairEngineeringServiceImpl implements SysRepairEngineeringService {
    private static Map<String,Object> map = null;
    @Resource
    SysRepairEngineeringDao sysRepairEngineeringDao;
    @Resource
    ButlerRepairEngineeringDao butlerRepairEngineeringDao;

    @Override
    public List<VoRepairEngineering> list(SearchRepairEngineering searchRepairEngineering) {
        return sysRepairEngineeringDao.list(searchRepairEngineering);
    }

    @Override
    public Map<String, Object> findById(Integer repairEngineeringId) {
        map = new HashMap<>();
        VoRepairEngineeringDetail voRepairEngineeringDetail = new VoRepairEngineeringDetail();

        //根据工程维修主键Id查询工程维修信息
        VoRepairEngineeringFBI voRepairEngineeringFBI = sysRepairEngineeringDao.findById(repairEngineeringId);
        UploadUtil uploadUtil = new UploadUtil();
        if (voRepairEngineeringFBI != null){
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysReportRepairEngineering", repairEngineeringId, "engineeringMaintenanceImg");
            voRepairEngineeringFBI.setEngineeringMaintenanceImgList(imgByDate);
            voRepairEngineeringDetail.setVoRepairEngineeringFBI(voRepairEngineeringFBI);
        }

        //根据工程维修主键id查询维修日志信息
        List<VoRepairEngineeringReport> voRepairEngineeringReportList = sysRepairEngineeringDao.findReportByRepairEngineeringId(repairEngineeringId);
        if (voRepairEngineeringReportList != null && voRepairEngineeringReportList.size()>0){
            for (VoRepairEngineeringReport voRepairEngineeringReport : voRepairEngineeringReportList) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysReportRepairEngineeringReport", voRepairEngineeringReport.getId(), "workReportImg");
                voRepairEngineeringReport.setWorkReportImgList(imgByDate);
            }
            voRepairEngineeringDetail.setVoRepairEngineeringReportList(voRepairEngineeringReportList);
        }

        //根据工程维修主键id查询处理进程记录
        List<VoRepairEngineeringProcessRecord> voRepairEngineeringProcessRecordList = sysRepairEngineeringDao.findRecordByRepairEngineeringId(repairEngineeringId);
        if (voRepairEngineeringProcessRecordList != null && voRepairEngineeringProcessRecordList.size()>0){
            voRepairEngineeringDetail.setVoRepairEngineeringProcessRecordList(voRepairEngineeringProcessRecordList);
        }

        //根据工程维修主键id查询验收结果
        List<VoRepairEngineeringMaintenanceResults> repairEngineeringMaintenanceResultsList = sysRepairEngineeringDao.findResultsByRepairEngineeringId(repairEngineeringId);
        if ( repairEngineeringMaintenanceResultsList != null && repairEngineeringMaintenanceResultsList.size()>0){
            for (VoRepairEngineeringMaintenanceResults maintenanceResults : repairEngineeringMaintenanceResultsList) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysReportEngineeringMaintenanceResults", maintenanceResults.getId(), "completeMaintenanceImg");
                maintenanceResults.setMaintenanceImgLists(imgByDate);

                List<VoResourcesImg> imgByDate1 = uploadUtil.findImgByDate("sysReportEngineeringMaintenanceResults", maintenanceResults.getId(), "acceptanceImg");
                maintenanceResults.setAcceptanceImgLists(imgByDate1);
            }
            voRepairEngineeringDetail.setVoRepairEngineeringMaintenanceResultsList(repairEngineeringMaintenanceResultsList);
        }

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",voRepairEngineeringDetail);

        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(ButlerRepairEngineering butlerRepairEngineering) {
        map = new HashMap<>();

        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            butlerRepairEngineering.setCreateId(sysUser.getId());
            butlerRepairEngineering.setCreateDate(new Date());
            butlerRepairEngineering.setCode(String.valueOf(new IdWorker(1,1,1).nextId()));
            butlerRepairEngineering.setStatus(1);//填入状态1.待派单（维修公司）

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
}
