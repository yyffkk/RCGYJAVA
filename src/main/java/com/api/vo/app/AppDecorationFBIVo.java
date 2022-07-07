package com.api.vo.app;

import java.util.Date;

/**
 * app装修管理Vo findById 回显
 */
public class AppDecorationFBIVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 房屋名称
     */
    private String roomName;
    /**
     * 装修单号
     */
    private String code;
    /**
     * 申请人id
     */
    private Integer residentId;
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
     * 状态(-1.申请中，-2.申请不通过，-3.申请通过，1.未开始（已付押金），2.装修中，3.完工检查申请中，4.完工检查不通过，5.完工检查通过，6.申请退款中，7.装修结束（已退押金），8.已作废)
     */
    private Integer status;
    /**
     * 实际开始时间
     */
    private Date actualBegin;
    /**
     * 预计开始时间
     */
    private Date expectedBegin;
    /**
     * 预计结束时间
     */
    private Date expectedEnd;
    /**
     * 延长预计结束时间(用来判断是否有延长记录)
     */
    private Date extendDate;
    /**
     * 申请退款时间（用来判断是否有退款申请）
     */
    private Date applicationRefundDate;

    @Override
    public String toString() {
        return "AppDecorationFBIVo{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", code='" + code + '\'' +
                ", residentId=" + residentId +
                ", constructionUnit='" + constructionUnit + '\'' +
                ", director='" + director + '\'' +
                ", directorTel='" + directorTel + '\'' +
                ", status=" + status +
                ", actualBegin=" + actualBegin +
                ", expectedBegin=" + expectedBegin +
                ", expectedEnd=" + expectedEnd +
                ", extendDate=" + extendDate +
                ", applicationRefundDate=" + applicationRefundDate +
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getActualBegin() {
        return actualBegin;
    }

    public void setActualBegin(Date actualBegin) {
        this.actualBegin = actualBegin;
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

    public Date getExtendDate() {
        return extendDate;
    }

    public void setExtendDate(Date extendDate) {
        this.extendDate = extendDate;
    }

    public Date getApplicationRefundDate() {
        return applicationRefundDate;
    }

    public void setApplicationRefundDate(Date applicationRefundDate) {
        this.applicationRefundDate = applicationRefundDate;
    }

    public AppDecorationFBIVo() {
    }

    public AppDecorationFBIVo(Integer id, String roomName, String code, Integer residentId, String constructionUnit, String director, String directorTel, Integer status, Date actualBegin, Date expectedBegin, Date expectedEnd, Date extendDate, Date applicationRefundDate) {
        this.id = id;
        this.roomName = roomName;
        this.code = code;
        this.residentId = residentId;
        this.constructionUnit = constructionUnit;
        this.director = director;
        this.directorTel = directorTel;
        this.status = status;
        this.actualBegin = actualBegin;
        this.expectedBegin = expectedBegin;
        this.expectedEnd = expectedEnd;
        this.extendDate = extendDate;
        this.applicationRefundDate = applicationRefundDate;
    }
}
