package com.api.vo.butlerService;

import java.util.List;

/**
 * 报事报修工程维修 vo 详情
 */
public class VoRepairEngineeringDetail {
    /**
     * 报事报修工程维修 vo findById 回显
     */
    private VoRepairEngineeringFBI voRepairEngineeringFBI;
    /**
     * 报事报修工程维修 维修日志【工作汇报】 Vo 回显
     */
    private List<VoRepairEngineeringReport> voRepairEngineeringReportList;
    /**
     * 报事报修工程维修 Vo 处理进程记录
     */
    private List<VoRepairEngineeringProcessRecord> voRepairEngineeringProcessRecordList;
    /**
     * 报事报修工程维修 Vo 完成结果及验收结果
     */
    private List<VoRepairEngineeringMaintenanceResults> voRepairEngineeringMaintenanceResultsList;

    @Override
    public String toString() {
        return "VoRepairEngineeringDetail{" +
                "voRepairEngineeringFBI=" + voRepairEngineeringFBI +
                ", voRepairEngineeringReportList=" + voRepairEngineeringReportList +
                ", voRepairEngineeringProcessRecordList=" + voRepairEngineeringProcessRecordList +
                ", voRepairEngineeringMaintenanceResultsList=" + voRepairEngineeringMaintenanceResultsList +
                '}';
    }

    public VoRepairEngineeringFBI getVoRepairEngineeringFBI() {
        return voRepairEngineeringFBI;
    }

    public void setVoRepairEngineeringFBI(VoRepairEngineeringFBI voRepairEngineeringFBI) {
        this.voRepairEngineeringFBI = voRepairEngineeringFBI;
    }

    public List<VoRepairEngineeringReport> getVoRepairEngineeringReportList() {
        return voRepairEngineeringReportList;
    }

    public void setVoRepairEngineeringReportList(List<VoRepairEngineeringReport> voRepairEngineeringReportList) {
        this.voRepairEngineeringReportList = voRepairEngineeringReportList;
    }

    public List<VoRepairEngineeringProcessRecord> getVoRepairEngineeringProcessRecordList() {
        return voRepairEngineeringProcessRecordList;
    }

    public void setVoRepairEngineeringProcessRecordList(List<VoRepairEngineeringProcessRecord> voRepairEngineeringProcessRecordList) {
        this.voRepairEngineeringProcessRecordList = voRepairEngineeringProcessRecordList;
    }

    public List<VoRepairEngineeringMaintenanceResults> getVoRepairEngineeringMaintenanceResultsList() {
        return voRepairEngineeringMaintenanceResultsList;
    }

    public void setVoRepairEngineeringMaintenanceResultsList(List<VoRepairEngineeringMaintenanceResults> voRepairEngineeringMaintenanceResultsList) {
        this.voRepairEngineeringMaintenanceResultsList = voRepairEngineeringMaintenanceResultsList;
    }

    public VoRepairEngineeringDetail() {
    }

    public VoRepairEngineeringDetail(VoRepairEngineeringFBI voRepairEngineeringFBI, List<VoRepairEngineeringReport> voRepairEngineeringReportList, List<VoRepairEngineeringProcessRecord> voRepairEngineeringProcessRecordList, List<VoRepairEngineeringMaintenanceResults> voRepairEngineeringMaintenanceResultsList) {
        this.voRepairEngineeringFBI = voRepairEngineeringFBI;
        this.voRepairEngineeringReportList = voRepairEngineeringReportList;
        this.voRepairEngineeringProcessRecordList = voRepairEngineeringProcessRecordList;
        this.voRepairEngineeringMaintenanceResultsList = voRepairEngineeringMaintenanceResultsList;
    }
}
