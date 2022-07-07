package com.api.model.basicArchives;


import java.util.List;

/**
 * 楼栋单元房产信息 和 关联业主信息集合
 */
public class EstateAndResidentList {
    /**
     * 楼栋单元房产信息
     */
    private CpmBuildingUnitEstate Estate;
    /**
     * 关联业主信息集合
     */
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
