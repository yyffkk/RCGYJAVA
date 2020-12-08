package com.api.model.butlerService;

import java.util.Date;

/**
 * 访客出入记录
 */
public class UserVisitorsDetail {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 访客申请id
     */
    private Integer visitorsId;
    /**
     * 到访时间
     */
    private Date visitTime;
    /**
     * 离开时间
     */
    private Date departureTime;
    /**
     * 到访审核人（物业表）-1为系统
     */
    private Integer visitReviewId;
    /**
     * 到访审核时间
     */
    private Date visitReviewDate;
    /**
     * 离开审核人（物业表）-1为系统
     */
    private Integer departureReviewId;
    /**
     * 离开审核时间
     */
    private Date departureReviewDate;

    @Override
    public String toString() {
        return "UserVisitorsDetail{" +
                "id=" + id +
                ", visitorsId=" + visitorsId +
                ", visitTime=" + visitTime +
                ", departureTime=" + departureTime +
                ", visitReviewId=" + visitReviewId +
                ", visitReviewDate=" + visitReviewDate +
                ", departureReviewId=" + departureReviewId +
                ", departureReviewDate=" + departureReviewDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVisitorsId() {
        return visitorsId;
    }

    public void setVisitorsId(Integer visitorsId) {
        this.visitorsId = visitorsId;
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

    public Integer getVisitReviewId() {
        return visitReviewId;
    }

    public void setVisitReviewId(Integer visitReviewId) {
        this.visitReviewId = visitReviewId;
    }

    public Date getVisitReviewDate() {
        return visitReviewDate;
    }

    public void setVisitReviewDate(Date visitReviewDate) {
        this.visitReviewDate = visitReviewDate;
    }

    public Integer getDepartureReviewId() {
        return departureReviewId;
    }

    public void setDepartureReviewId(Integer departureReviewId) {
        this.departureReviewId = departureReviewId;
    }

    public Date getDepartureReviewDate() {
        return departureReviewDate;
    }

    public void setDepartureReviewDate(Date departureReviewDate) {
        this.departureReviewDate = departureReviewDate;
    }

    public UserVisitorsDetail() {
    }

    public UserVisitorsDetail(Integer id, Integer visitorsId, Date visitTime, Date departureTime, Integer visitReviewId, Date visitReviewDate, Integer departureReviewId, Date departureReviewDate) {
        this.id = id;
        this.visitorsId = visitorsId;
        this.visitTime = visitTime;
        this.departureTime = departureTime;
        this.visitReviewId = visitReviewId;
        this.visitReviewDate = visitReviewDate;
        this.departureReviewId = departureReviewId;
        this.departureReviewDate = departureReviewDate;
    }
}
