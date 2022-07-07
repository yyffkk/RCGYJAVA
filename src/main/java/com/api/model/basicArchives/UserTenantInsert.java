package com.api.model.basicArchives;


import java.util.List;

/**
 * 租户添加信息
 */
public class UserTenantInsert {
    /**
     * 租户信息
     */
    private UserResident userResident;
    /**
     * 租户亲属信息集合
     */
    private List<UserResident> voRelativesList;
    /**
     * 租户房屋关联信息集合
     */
    private List<CpmResidentEstate> cpmResidentEstateList;
    /**
     * 租户车位关联信息集合
     */
    private List<CpmParkingSpace> cpmParkingSpaceList;

    @Override
    public String toString() {
        return "UserTenantInsert{" +
                "userResident=" + userResident +
                ", voRelativesList=" + voRelativesList +
                ", cpmResidentEstateList=" + cpmResidentEstateList +
                ", cpmParkingSpaceList=" + cpmParkingSpaceList +
                '}';
    }

    public UserResident getUserResident() {
        return userResident;
    }

    public void setUserResident(UserResident userResident) {
        this.userResident = userResident;
    }

    public List<UserResident> getVoRelativesList() {
        return voRelativesList;
    }

    public void setVoRelativesList(List<UserResident> voRelativesList) {
        this.voRelativesList = voRelativesList;
    }

    public List<CpmResidentEstate> getCpmResidentEstateList() {
        return cpmResidentEstateList;
    }

    public void setCpmResidentEstateList(List<CpmResidentEstate> cpmResidentEstateList) {
        this.cpmResidentEstateList = cpmResidentEstateList;
    }

    public List<CpmParkingSpace> getCpmParkingSpaceList() {
        return cpmParkingSpaceList;
    }

    public void setCpmParkingSpaceList(List<CpmParkingSpace> cpmParkingSpaceList) {
        this.cpmParkingSpaceList = cpmParkingSpaceList;
    }

    public UserTenantInsert() {
    }

    public UserTenantInsert(UserResident userResident, List<UserResident> voRelativesList, List<CpmResidentEstate> cpmResidentEstateList, List<CpmParkingSpace> cpmParkingSpaceList) {
        this.userResident = userResident;
        this.voRelativesList = voRelativesList;
        this.cpmResidentEstateList = cpmResidentEstateList;
        this.cpmParkingSpaceList = cpmParkingSpaceList;
    }
}
