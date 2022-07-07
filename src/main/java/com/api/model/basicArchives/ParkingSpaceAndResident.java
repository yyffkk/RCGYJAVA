package com.api.model.basicArchives;

/**
 * 车位信息 和业主信息
 */
public class ParkingSpaceAndResident {
    /**
     * 车位信息
     */
    private CpmParkingSpace cpmParkingSpace;
    /**
     * 业主信息
     */
    private UserResident userResident;

    @Override
    public String toString() {
        return "ParkingSpaceAndResident{" +
                "cpmParkingSpace=" + cpmParkingSpace +
                ", userResident=" + userResident +
                '}';
    }

    public CpmParkingSpace getCpmParkingSpace() {
        return cpmParkingSpace;
    }

    public void setCpmParkingSpace(CpmParkingSpace cpmParkingSpace) {
        this.cpmParkingSpace = cpmParkingSpace;
    }

    public UserResident getUserResident() {
        return userResident;
    }

    public void setUserResident(UserResident userResident) {
        this.userResident = userResident;
    }

    public ParkingSpaceAndResident() {
    }

    public ParkingSpaceAndResident(CpmParkingSpace cpmParkingSpace, UserResident userResident) {
        this.cpmParkingSpace = cpmParkingSpace;
        this.userResident = userResident;
    }
}
