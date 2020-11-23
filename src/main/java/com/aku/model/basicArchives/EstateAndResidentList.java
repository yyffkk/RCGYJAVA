package com.aku.model.basicArchives;


import java.util.List;

public class EstateAndResidentList {
    private CpmBuildingUnitEstate Estate;
    private List<UserResident> ResidentList;

    @Override
    public String toString() {
        return "EstateAndResident{" +
                "Estate=" + Estate +
                ", ResidentList=" + ResidentList +
                '}';
    }

    public CpmBuildingUnitEstate getEstate() {
        return Estate;
    }

    public void setEstate(CpmBuildingUnitEstate estate) {
        Estate = estate;
    }

    public List<UserResident> getResidentList() {
        return ResidentList;
    }

    public void setResidentList(List<UserResident> residentList) {
        ResidentList = residentList;
    }

    public EstateAndResidentList() {
    }

    public EstateAndResidentList(CpmBuildingUnitEstate estate, List<UserResident> residentList) {
        Estate = estate;
        ResidentList = residentList;
    }
}
