package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysRepairEngineeringDao;
import com.api.manage.service.butlerService.SysRepairEngineeringService;
import com.api.model.butlerService.SearchRepairEngineering;
import com.api.util.UploadUtil;
import com.api.vo.butlerService.*;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysRepairEngineeringServiceImpl implements SysRepairEngineeringService {
    private static Map<String,Object> map = null;
    @Resource
    SysRepairEngineeringDao sysRepairEngineeringDao;

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
}
