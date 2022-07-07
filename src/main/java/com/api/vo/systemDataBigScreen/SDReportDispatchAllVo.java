package com.api.vo.systemDataBigScreen;

import java.util.List;

/**
 * 系统数据 报修工单所有信息
 */
public class SDReportDispatchAllVo {
    /**
     * 已处理数量
     */
    private Integer HandledNum;
    /**
     * 未处理数量
     */
    private Integer PendingNum;
    /**
     * 公区报修数量
     */
    private Integer PublicTypeNum;
    /**
     * 家庭报修数量
     */
    private Integer FamilyTypeNum;
    /**
     * 系统数据 报修工单信息集合
     */
    private List<SDReportDispatchVo> reportDispatchVoList;

    @Override
    public String toString() {
        return "SDReportDispatchAllVo{" +
                "HandledNum=" + HandledNum +
                ", PendingNum=" + PendingNum +
                ", PublicTypeNum=" + PublicTypeNum +
                ", FamilyTypeNum=" + FamilyTypeNum +
                ", reportDispatchVoList=" + reportDispatchVoList +
                '}';
    }

    public Integer getHandledNum() {
        return HandledNum;
    }

    public void setHandledNum(Integer handledNum) {
        HandledNum = handledNum;
    }

    public Integer getPendingNum() {
        return PendingNum;
    }

    public void setPendingNum(Integer pendingNum) {
        PendingNum = pendingNum;
    }

    public Integer getPublicTypeNum() {
        return PublicTypeNum;
    }

    public void setPublicTypeNum(Integer publicTypeNum) {
        PublicTypeNum = publicTypeNum;
    }

    public Integer getFamilyTypeNum() {
        return FamilyTypeNum;
    }

    public void setFamilyTypeNum(Integer familyTypeNum) {
        FamilyTypeNum = familyTypeNum;
    }

    public List<SDReportDispatchVo> getReportDispatchVoList() {
        return reportDispatchVoList;
    }

    public void setReportDispatchVoList(List<SDReportDispatchVo> reportDispatchVoList) {
        this.reportDispatchVoList = reportDispatchVoList;
    }

    public SDReportDispatchAllVo() {
    }

    public SDReportDispatchAllVo(Integer handledNum, Integer pendingNum, Integer publicTypeNum, Integer familyTypeNum, List<SDReportDispatchVo> reportDispatchVoList) {
        HandledNum = handledNum;
        PendingNum = pendingNum;
        PublicTypeNum = publicTypeNum;
        FamilyTypeNum = familyTypeNum;
        this.reportDispatchVoList = reportDispatchVoList;
    }
}
