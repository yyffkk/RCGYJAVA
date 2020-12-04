package com.aku.vo.butlerService;

import java.util.Date;

/**
 * 访客出入记录 Vo list
 */
public class VoUserVisitorsDetail {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 到访时间
     */
    private Date visitTime;
    /**
     * 离开时间
     */
    private Date departureTime;

    @Override
    public String toString() {
        return "VoUserVisitorsDetail{" +
                "id=" + id +
                ", visitTime=" + visitTime +
                ", departureTime=" + departureTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public VoUserVisitorsDetail() {
    }

    public VoUserVisitorsDetail(Integer id, Date visitTime, Date departureTime) {
        this.id = id;
        this.visitTime = visitTime;
        this.departureTime = departureTime;
    }
}
