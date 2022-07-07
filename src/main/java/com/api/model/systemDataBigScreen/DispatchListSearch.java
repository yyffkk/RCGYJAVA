package com.api.model.systemDataBigScreen;

import java.util.Date;

/**
 * 报修单搜索条件
 */
public class DispatchListSearch {
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
        return "DispatchListSearch{" +
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

    public DispatchListSearch() {
    }

    public DispatchListSearch(Date beginDate, Date endDate) {
        this.beginDate = beginDate;
        this.endDate = endDate;
    }
}
