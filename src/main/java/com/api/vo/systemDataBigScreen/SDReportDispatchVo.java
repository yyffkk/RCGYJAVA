package com.api.vo.systemDataBigScreen;

import java.util.Date;

/**
 * 系统数据 报修工单信息
 */
public class SDReportDispatchVo {
    /**
     * 工单主键id
     */
    private Integer id;
    /**
     * 工单编号
     */
    private String code;
    /**
     * 工单状态状态（1.待处理，2.已处理）
     */
    private Integer status;
    /**
     * 处理/上报时间
     */
    private Date dateTime;

    @Override
    public String toString() {
        return "SDReportDispatchVo{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", dateTime=" + dateTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public SDReportDispatchVo() {
    }

    public SDReportDispatchVo(Integer id, String code, Integer status, Date dateTime) {
        this.id = id;
        this.code = code;
        this.status = status;
        this.dateTime = dateTime;
    }
}
