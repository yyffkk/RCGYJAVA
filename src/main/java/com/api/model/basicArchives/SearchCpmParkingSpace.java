package com.api.model.basicArchives;

/**
 * 车位信息搜索条件
 */
public class SearchCpmParkingSpace {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 车位编号
     */
    private String code;
    /**
     * 车位状态
     */
    private Integer status;
    /**
     * 业主名称
     */
    private String residentName;
    /**
     * 使用人名称
     */
    private String userName;

    @Override
    public String toString() {
        return "SearchCpmParkingSpace{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", residentName='" + residentName + '\'' +
                ", userName='" + userName + '\'' +
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

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public SearchCpmParkingSpace() {
    }

    public SearchCpmParkingSpace(int pageNum, int size, String code, Integer status, String residentName, String userName) {
        this.pageNum = pageNum;
        this.size = size;
        this.code = code;
        this.status = status;
        this.residentName = residentName;
        this.userName = userName;
    }
}
