package com.aku.model.basicArchives;

import java.util.List;

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
    private List<Integer> cpmParkingSpaceIds;

    @Override
    public String toString() {
        return "ResidentAndParkingSpaceList{" +
                "userResident=" + userResident +
                ", cpmParkingSpaceIds=" + cpmParkingSpaceIds +
                '}';
    }

    public UserResident getUserResident() {
        return userResident;
    }

    public void setUserResident(UserResident userResident) {
        this.userResident = userResident;
    }

    public List<Integer> getCpmParkingSpaceIds() {
        return cpmParkingSpaceIds;
    }

    public void setCpmParkingSpaceIds(List<Integer> cpmParkingSpaceIds) {
        this.cpmParkingSpaceIds = cpmParkingSpaceIds;
    }

    public ResidentAndParkingSpaceIds() {
    }

    public ResidentAndParkingSpaceIds(UserResident userResident, List<Integer> cpmParkingSpaceIds) {
        this.userResident = userResident;
        this.cpmParkingSpaceIds = cpmParkingSpaceIds;
    }
}
