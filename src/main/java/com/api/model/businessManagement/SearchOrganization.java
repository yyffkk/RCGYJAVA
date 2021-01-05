package com.api.model.businessManagement;

/**
 * 组织架构 搜索条件
 */
public class SearchOrganization {
    /**
     * 组织名称
     */
    private String name;
    /**
     * 状态（1.正常，2.停用）
     */
    private Integer status;

    @Override
    public String toString() {
        return "SearchOrganization{" +
                "name='" + name + '\'' +
                ", status=" + status +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public SearchOrganization() {
    }

    public SearchOrganization(String name, Integer status) {
        this.name = name;
        this.status = status;
    }
}
