package com.api.model.systemDataBigScreen;

import java.util.Date;

/**
 * 日活跃搜索条件
 */
public class DailyActivitySearch {
    /**
     * 起始时间
     */
    private Date beginDate;
    /**
     * 结束时间
     */
    private Date endDate;

    @Override
    public String toString() {
        return "DailyActivitySearch{" +
                "beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public DailyActivitySearch() {
    }

    public DailyActivitySearch(Date beginDate, Date endDate) {
        this.beginDate = beginDate;
        this.endDate = endDate;
    }
}
