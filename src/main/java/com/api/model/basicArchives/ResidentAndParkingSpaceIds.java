package com.api.model.basicArchives;

import java.util.Arrays;

/**
 * 业主信息 和 车位信息集合
 */
public class ResidentAndParkingSpaceIds {
    /**
     * 业主信息
     */
    private UserResident userResident;
    /**
     * 车位信息集合
     */
    private int[] cpmParkingSpaceIds;

    @Override
    public String toString() {
        return "ResidentAndParkingSpaceIds{" +
                "userResident=" + userResident +
                ", cpmParkingSpaceIds=" + Arrays.toString(cpmParkingSpaceIds) +
                '}';
    }

    public UserResident getUserResident() {
        return userResident;
    }

    public void setUserResident(UserResident userResident) {
        this.userResident = userResident;
    }

    public int[] getCpmParkingSpaceIds() {
        return cpmParkingSpaceIds;
    }

    public void setCpmParkingSpaceIds(int[] cpmParkingSpaceIds) {
        this.cpmParkingSpaceIds = cpmParkingSpaceIds;
    }

    public ResidentAndParkingSpaceIds() {
    }

    public ResidentAndParkingSpaceIds(UserResident userResident, int[] cpmParkingSpaceIds) {
        this.userResident = userResident;
        this.cpmParkingSpaceIds = cpmParkingSpaceIds;
    }
}
