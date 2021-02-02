package com.api.model.butlerApp;

/**
 * 管家app 报事报修搜索条件
 */
public class ButlerRepairSearch {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 当前用户 角色ID，用'，'隔开，格式为(1,2)
     */
    private String roleId;
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 状态（1.待分配，2.已分配未接单，3.已分配处理中，4.已处理，5.已确认已完成，6.已关闭，7.已作废，8.已取消）
     */
    private Integer repairStatus;

    @Override
    public String toString() {
        return "ButlerRepairSearch{" +
                "id=" + id +
                ", roleId='" + roleId + '\'' +
                ", pageNum=" + pageNum +
                ", size=" + size +
                ", repairStatus=" + repairStatus +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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

    public Integer getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(Integer repairStatus) {
        this.repairStatus = repairStatus;
    }

    public ButlerRepairSearch() {
    }

    public ButlerRepairSearch(Integer id, String roleId, int pageNum, int size, Integer repairStatus) {
        this.id = id;
        this.roleId = roleId;
        this.pageNum = pageNum;
        this.size = size;
        this.repairStatus = repairStatus;
    }
}
