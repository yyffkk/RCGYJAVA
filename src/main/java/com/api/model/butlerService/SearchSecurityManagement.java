package com.api.model.butlerService;

import java.util.Date;

/**
 * 安全管理搜索条件
 */
public class SearchSecurityManagement {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 事件名称
     */
    private String name;
    /**
     * 事件类型（1.消防演习，2.纠纷处理，3.小区火警，4.其他）
     */
    private Integer type;
    /**
     * 登记人（创建人）
     */
    private Integer createId;
    /**
     * 发生时间开始
     */
    private Date happenDateStart;
    /**
     * 发生时间结束
     */
    private Date happenDateEnd;

    @Override
    public String toString() {
        return "SearchSecurityManagement{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", createId=" + createId +
                ", happenDateStart=" + happenDateStart +
                ", happenDateEnd=" + happenDateEnd +
                '}';
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getHappenDateStart() {
        return happenDateStart;
    }

    public void setHappenDateStart(Date happenDateStart) {
        this.happenDateStart = happenDateStart;
    }

    public Date getHappenDateEnd() {
        return happenDateEnd;
    }

    public void setHappenDateEnd(Date happenDateEnd) {
        this.happenDateEnd = happenDateEnd;
    }

    public SearchSecurityManagement() {
    }

    public SearchSecurityManagement(int pageNum, int size, String name, Integer type, Integer createId, Date happenDateStart, Date happenDateEnd) {
        this.pageNum = pageNum;
        this.size = size;
        this.name = name;
        this.type = type;
        this.createId = createId;
        this.happenDateStart = happenDateStart;
        this.happenDateEnd = happenDateEnd;
    }
}
