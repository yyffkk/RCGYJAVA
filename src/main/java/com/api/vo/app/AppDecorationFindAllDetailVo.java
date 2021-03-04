package com.api.vo.app;

import java.util.Date;

/**
 * app装修管理 查询全部详情信息 回显
 */
public class AppDecorationFindAllDetailVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 房屋姓名
     */
    private String roomName;
    /**
     * 装修公司
     */
    private String constructionUnit;
    /**
     * 装修负责人
     */
    private String director;
    /**
     * 装修负责人联系电话
     */
    private String directorTel;
    /**
     * 申报时间
     */
    private Date applicationDate;
    /**
     * 预计开始时间
     */
    private Date expectedBegin;
    /**
     * 预计结束时间
     */
    private Date expectedEnd;
    /**
     * 实际开始时间
     */
    private Date actualBegin;
    /**
     * 跟踪人姓名
     */
    private String trackerName;
    /**
     * 跟踪人联系电话
     */
    private String trackerTel;
    /**
     * 延长时间（单位为天）
     */
    private Integer extendTime;
    /**
     * 延长原因
     */
    private String extendReasons;
    /**
     * 延长预计结束时间
     */
    private Date extendDate;

    @Override
    public String toString() {
        return "AppDecorationFindAllDetailVo{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", constructionUnit='" + constructionUnit + '\'' +
                ", director='" + director + '\'' +
                ", directorTel='" + directorTel + '\'' +
                ", applicationDate=" + applicationDate +
                ", expectedBegin=" + expectedBegin +
                ", expectedEnd=" + expectedEnd +
                ", actualBegin=" + actualBegin +
                ", trackerName='" + trackerName + '\'' +
                ", trackerTel='" + trackerTel + '\'' +
                ", extendTime=" + extendTime +
                ", extendReasons='" + extendReasons + '\'' +
                ", extendDate=" + extendDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirectorTel() {
        return directorTel;
    }

    public void setDirectorTel(String directorTel) {
        this.directorTel = directorTel;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Date getExpectedBegin() {
        return expectedBegin;
    }

    public void setExpectedBegin(Date expectedBegin) {
        this.expectedBegin = expectedBegin;
    }

    public Date getExpectedEnd() {
        return expectedEnd;
    }

    public void setExpectedEnd(Date expectedEnd) {
        this.expectedEnd = expectedEnd;
    }

    public Date getActualBegin() {
        return actualBegin;
    }

    public void setActualBegin(Date actualBegin) {
        this.actualBegin = actualBegin;
    }

    public String getTrackerName() {
        return trackerName;
    }

    public void setTrackerName(String trackerName) {
        this.trackerName = trackerName;
    }

    public String getTrackerTel() {
        return trackerTel;
    }

    public void setTrackerTel(String trackerTel) {
        this.trackerTel = trackerTel;
    }

    public Integer getExtendTime() {
        return extendTime;
    }

    public void setExtendTime(Integer extendTime) {
        this.extendTime = extendTime;
    }

    public String getExtendReasons() {
        return extendReasons;
    }

    public void setExtendReasons(String extendReasons) {
        this.extendReasons = extendReasons;
    }

    public Date getExtendDate() {
        return extendDate;
    }

    public void setExtendDate(Date extendDate) {
        this.extendDate = extendDate;
    }

    public AppDecorationFindAllDetailVo() {
    }

    public AppDecorationFindAllDetailVo(Integer id, String roomName, String constructionUnit, String director, String directorTel, Date applicationDate, Date expectedBegin, Date expectedEnd, Date actualBegin, String trackerName, String trackerTel, Integer extendTime, String extendReasons, Date extendDate) {
        this.id = id;
        this.roomName = roomName;
        this.constructionUnit = constructionUnit;
        this.director = director;
        this.directorTel = directorTel;
        this.applicationDate = applicationDate;
        this.expectedBegin = expectedBegin;
        this.expectedEnd = expectedEnd;
        this.actualBegin = actualBegin;
        this.trackerName = trackerName;
        this.trackerTel = trackerTel;
        this.extendTime = extendTime;
        this.extendReasons = extendReasons;
        this.extendDate = extendDate;
    }
}
