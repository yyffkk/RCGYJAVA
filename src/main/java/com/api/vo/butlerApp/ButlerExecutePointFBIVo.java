package com.api.vo.butlerApp;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 管家app 巡检执行点Vo findById 回显
 */
public class ButlerExecutePointFBIVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 巡检执行情况主键id
     */
    private Integer executeId;
    /**
     * 巡检点编号
     */
    private String code;
    /**
     * 巡检点名称
     */
    private String name;
    /**
     * 巡检模式（1.巡检模式）【就一个模式】
     */
    private Integer type;
    /**
     * 巡检点完成时间
     */
    private Date completeDate;
    /**
     * 巡检执行点检查项集合
     */
    private List<ButlerExecuteCheckFBIVo> checkFBIVoList;
    /**
     * 巡更人员自拍人脸
     */
    private List<VoResourcesImg> faceImg;
    /**
     * 巡更人员拍摄现场
     */
    private List<VoResourcesImg> spaceImg;

    @Override
    public String toString() {
        return "ButlerExecutePointFBIVo{" +
                "id=" + id +
                ", executeId=" + executeId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", completeDate=" + completeDate +
                ", checkFBIVoList=" + checkFBIVoList +
                ", faceImg=" + faceImg +
                ", spaceImg=" + spaceImg +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExecuteId() {
        return executeId;
    }

    public void setExecuteId(Integer executeId) {
        this.executeId = executeId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public List<ButlerExecuteCheckFBIVo> getCheckFBIVoList() {
        return checkFBIVoList;
    }

    public void setCheckFBIVoList(List<ButlerExecuteCheckFBIVo> checkFBIVoList) {
        this.checkFBIVoList = checkFBIVoList;
    }

    public List<VoResourcesImg> getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(List<VoResourcesImg> faceImg) {
        this.faceImg = faceImg;
    }

    public List<VoResourcesImg> getSpaceImg() {
        return spaceImg;
    }

    public void setSpaceImg(List<VoResourcesImg> spaceImg) {
        this.spaceImg = spaceImg;
    }

    public ButlerExecutePointFBIVo() {
    }

    public ButlerExecutePointFBIVo(Integer id, Integer executeId, String code, String name, Integer type, Date completeDate, List<ButlerExecuteCheckFBIVo> checkFBIVoList, List<VoResourcesImg> faceImg, List<VoResourcesImg> spaceImg) {
        this.id = id;
        this.executeId = executeId;
        this.code = code;
        this.name = name;
        this.type = type;
        this.completeDate = completeDate;
        this.checkFBIVoList = checkFBIVoList;
        this.faceImg = faceImg;
        this.spaceImg = spaceImg;
    }
}
