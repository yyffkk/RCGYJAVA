package com.api.vo.dataStatistics;

import java.util.Date;

/**
 * 待处理信息 Vo 回显
 */
public class DSPendingVo {
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 部门名称
     */
    private String organizationName;
    /**
     * 发起时间
     */
    private Date createDate;
    /**
     * 1.钥匙管理，2.房屋审核，3.考勤管理（早退），4.报警
     */
    private Integer type;

    @Override
    public String toString() {
        return "DSPendingVo{" +
                "userName='" + userName + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", createDate=" + createDate +
                ", type=" + type +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public DSPendingVo() {
    }

    public DSPendingVo(String userName, String organizationName, Date createDate, Integer type) {
        this.userName = userName;
        this.organizationName = organizationName;
        this.createDate = createDate;
        this.type = type;
    }
}
