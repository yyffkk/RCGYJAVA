package com.aku.model.basicArchives;

import com.aku.vo.basicArchives.VoRelatives;

import java.util.Arrays;
import java.util.List;

/**
 * 业主的添加信息
 */
public class ResidentInsert {
    /**
     * 业主信息
     */
    private UserResident userResident;
    /**
     * 亲属信息集合
     */
    private List<VoRelatives> voRelativesList;
    /**
     * 关联房产主键id集合
     */
    private int[] buildingUnitEstateIds;
    /**
     * 关联车位主键id集合
     */
    private int[] cpmParkingSpaceIds;

    @Override
    public String toString() {
        return "ResidentInsert{" +
                "userResident=" + userResident +
                ", voRelativesList=" + voRelativesList +
                ", buildingUnitEstateIds=" + Arrays.toString(buildingUnitEstateIds) +
                ", cpmParkingSpaceIds=" + Arrays.toString(cpmParkingSpaceIds) +
                '}';
    }

    public UserResident getUserResident() {
        return userResident;
    }

    public void setUserResident(UserResident userResident) {
        this.userResident = userResident;
    }

    public List<VoRelatives> getVoRelativesList() {
        return voRelativesList;
    }

    public void setVoRelativesList(List<VoRelatives> voRelativesList) {
        this.voRelativesList = voRelativesList;
    }

    public int[] getBuildingUnitEstateIds() {
        return buildingUnitEstateIds;
    }

    public void setBuildingUnitEstateIds(int[] buildingUnitEstateIds) {
        this.buildingUnitEstateIds = buildingUnitEstateIds;
    }

    public int[] getCpmParkingSpaceIds() {
        return cpmParkingSpaceIds;
    }

    public void setCpmParkingSpaceIds(int[] cpmParkingSpaceIds) {
        this.cpmParkingSpaceIds = cpmParkingSpaceIds;
    }

    public ResidentInsert() {
    }

    public ResidentInsert(UserResident userResident, List<VoRelatives> voRelativesList, int[] buildingUnitEstateIds, int[] cpmParkingSpaceIds) {
        this.userResident = userResident;
        this.voRelativesList = voRelativesList;
        this.buildingUnitEstateIds = buildingUnitEstateIds;
        this.cpmParkingSpaceIds = cpmParkingSpaceIds;
    }
}
