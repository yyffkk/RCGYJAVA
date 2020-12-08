package com.api.model.basicArchives;

import java.util.List;

/**
 * 装修信息 和 附属员工信息
 */
public class DecorationAndStaff {
    /**
     * 装修信息
     */
    private CpmDecoration cpmDecoration;
    /**
     * 装修员工信息（负责人附属员工）
     */
    private List<UserStaff> userStaffList;

    @Override
    public String toString() {
        return "DecorationAndStaff{" +
                "cpmDecoration=" + cpmDecoration +
                ", userStaffList=" + userStaffList +
                '}';
    }

    public CpmDecoration getCpmDecoration() {
        return cpmDecoration;
    }

    public void setCpmDecoration(CpmDecoration cpmDecoration) {
        this.cpmDecoration = cpmDecoration;
    }

    public List<UserStaff> getUserStaffList() {
        return userStaffList;
    }

    public void setUserStaffList(List<UserStaff> userStaffList) {
        this.userStaffList = userStaffList;
    }

    public DecorationAndStaff() {
    }

    public DecorationAndStaff(CpmDecoration cpmDecoration, List<UserStaff> userStaffList) {
        this.cpmDecoration = cpmDecoration;
        this.userStaffList = userStaffList;
    }
}
