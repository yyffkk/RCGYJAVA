package com.api.model.butlerApp;

/**
 * 管家app 申请记录搜索条件
 */
public class ButlerRecordSearch {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 审核状态：1.待审核，2.审核通过，3.审核驳回，4.归还待审核，5.归还审核驳回，6.已归还（归还审核通过）
     */
    private Integer recordStatus;
    /**
     * 用户主键id
     */
    private Integer id;

    @Override
    public String toString() {
        return "ButlerRecordSearch{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", recordStatus=" + recordStatus +
                ", id=" + id +
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

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ButlerRecordSearch() {
    }

    public ButlerRecordSearch(int pageNum, int size, Integer recordStatus, Integer id) {
        this.pageNum = pageNum;
        this.size = size;
        this.recordStatus = recordStatus;
        this.id = id;
    }
}
