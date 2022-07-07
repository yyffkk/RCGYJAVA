package com.api.model.basicArchives;

import java.util.List;

/**
 * 业主信息 和 亲属信息集合
 */
public class ResidentAndRelativesList {
    /**
     * 业主信息
     */
    private UserResident userResident;
    /**
     * 亲属信息集合
     */
    private List<UserResident> userRelatives;

    @Override
    public String toString() {
        return "ResidentAndRelatives{" +
                "userResident=" + userResident +
                ", userRelatives=" + userRelatives +
                '}';
    }

    public UserResident getUserResident() {
        return userResident;
    }

    public void setUserResident(UserResident userResident) {
        this.userResident = userResident;
    }

    public List<UserResident> getUserRelatives() {
        return userRelatives;
    }

    public void setUserRelatives(List<UserResident> userRelatives) {
        this.userRelatives = userRelatives;
    }

    public ResidentAndRelativesList() {
    }

    public ResidentAndRelativesList(UserResident userResident, List<UserResident> userRelatives) {
        this.userResident = userResident;
        this.userRelatives = userRelatives;
    }
}
