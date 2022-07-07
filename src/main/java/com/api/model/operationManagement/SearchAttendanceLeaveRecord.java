package com.api.model.operationManagement;

/**
 * 请假/加班记录搜索条件
 */
public class SearchAttendanceLeaveRecord {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 状态：1.待审核，2.审核通过，3.审核驳回
     */
    private Integer status;
    /**
     * 类型：1.请假，2.加班
     */
    private Integer type;
    /**
     * 申请人手机号
     */
    private String createTel;

    @Override
    public String toString() {
        return "SearchAttendanceLeaveRecord{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", status=" + status +
                ", type=" + type +
                ", createTel='" + createTel + '\'' +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCreateTel() {
        return createTel;
    }

    public void setCreateTel(String createTel) {
        this.createTel = createTel;
    }

    public SearchAttendanceLeaveRecord() {
    }

    public SearchAttendanceLeaveRecord(int pageNum, int size, Integer status, Integer type, String createTel) {
        this.pageNum = pageNum;
        this.size = size;
        this.status = status;
        this.type = type;
        this.createTel = createTel;
    }
}
