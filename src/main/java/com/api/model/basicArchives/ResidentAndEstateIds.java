package com.api.model.basicArchives;

import java.util.Arrays;

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
    private int[] estateIds;

    @Override
    public String toString() {
        return "ResidentAndEstateIds{" +
                "userResident=" + userResident +
                ", estateIds=" + Arrays.toString(estateIds) +
                '}';
    }

    public UserResident getUserResident() {
        return userResident;
    }

    public void setUserResident(UserResident userResident) {
        this.userResident = userResident;
    }

    public int[] getEstateIds() {
        return estateIds;
    }

    public void setEstateIds(int[] estateIds) {
        this.estateIds = estateIds;
    }

    public ResidentAndEstateIds() {
    }

    public ResidentAndEstateIds(UserResident userResident, int[] estateIds) {
        this.userResident = userResident;
        this.estateIds = estateIds;
    }
}
