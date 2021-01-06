package com.api.model.businessManagement;

/**
 * 人员管理 搜索条件
 */
public class SearchUser {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 组织id
     */
    private Integer organizationId;
    /**
     * 员工名称(昵称)
     */
    private String nickName;
    /**
     * 状态
     */
    private Integer status;

    @Override
    public String toString() {
        return "SearchUser{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", organizationId=" + organizationId +
                ", nickName='" + nickName + '\'' +
                ", status=" + status +
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

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public SearchUser() {
    }

    public SearchUser(int pageNum, int size, Integer organizationId, String nickName, Integer status) {
        this.pageNum = pageNum;
        this.size = size;
        this.organizationId = organizationId;
        this.nickName = nickName;
        this.status = status;
    }
}
