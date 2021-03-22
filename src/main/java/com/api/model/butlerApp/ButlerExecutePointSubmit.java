package com.api.model.butlerApp;

import java.util.Arrays;
import java.util.List;

/**
 * 管家app 执行巡检点提交信息
 */
public class ButlerExecutePointSubmit {
    /**
     * 巡检执行点主键id
     */
    private Integer executePointId;
    /**
     * 巡检执行检查项集合
     */
    private List<ButlerExecuteCheck> executeCheckList;
    /**
     * 巡检人自拍照
     */
    private String[] inspectionFaceImg;
    /**
     * 巡检现场照
     */
    private String[] inspectionSpaceImg;

    @Override
    public String toString() {
        return "ButlerExecutePointSubmit{" +
                "executePointId=" + executePointId +
                ", executeCheckList=" + executeCheckList +
                ", inspectionFaceImg=" + Arrays.toString(inspectionFaceImg) +
                ", inspectionSpaceImg=" + Arrays.toString(inspectionSpaceImg) +
                '}';
    }

    public Integer getExecutePointId() {
        return executePointId;
    }

    public void setExecutePointId(Integer executePointId) {
        this.executePointId = executePointId;
    }

    public List<ButlerExecuteCheck> getExecuteCheckList() {
        return executeCheckList;
    }

    public void setExecuteCheckList(List<ButlerExecuteCheck> executeCheckList) {
        this.executeCheckList = executeCheckList;
    }

    public String[] getInspectionFaceImg() {
        return inspectionFaceImg;
    }

    public void setInspectionFaceImg(String[] inspectionFaceImg) {
        this.inspectionFaceImg = inspectionFaceImg;
    }

    public String[] getInspectionSpaceImg() {
        return inspectionSpaceImg;
    }

    public void setInspectionSpaceImg(String[] inspectionSpaceImg) {
        this.inspectionSpaceImg = inspectionSpaceImg;
    }

    public ButlerExecutePointSubmit() {
    }

    public ButlerExecutePointSubmit(Integer executePointId, List<ButlerExecuteCheck> executeCheckList, String[] inspectionFaceImg, String[] inspectionSpaceImg) {
        this.executePointId = executePointId;
        this.executeCheckList = executeCheckList;
        this.inspectionFaceImg = inspectionFaceImg;
        this.inspectionSpaceImg = inspectionSpaceImg;
    }
}
