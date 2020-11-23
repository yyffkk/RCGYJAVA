package com.aku.model.basicArchives;

import java.util.List;

/**
 * 业主信息 和 房产信息集合
 */
public class ResidentAndEstateIds {
    /**
     * 业主信息
     */
    private UserResident userResident;
    /**
     * 房产信息集合
     */
    private List<Integer> estateIds;

    @Override
    public String toString() {
        return "ResidentAndEstateList{" +
                "userResident=" + userResident +
                ", estateIds=" + estateIds +
                '}';
    }

    public UserResident getUserResident() {
        return userResident;
    }

    public void setUserResident(UserResident userResident) {
        this.userResident = userResident;
    }

    public List<Integer> getEstateIds() {
        return estateIds;
    }

    public void setEstateIds(List<Integer> estateIds) {
        this.estateIds = estateIds;
    }

    public ResidentAndEstateIds() {
    }

    public ResidentAndEstateIds(UserResident userResident, List<Integer> estateIds) {
        this.userResident = userResident;
        this.estateIds = estateIds;
    }
}
