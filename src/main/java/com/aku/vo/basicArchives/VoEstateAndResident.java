package com.aku.vo.basicArchives;

import com.aku.model.basicArchives.CpmBuildingUnitEstate;
import com.aku.model.basicArchives.UserResident;

public class VoEstateAndResident {
    private CpmBuildingUnitEstate Estate;
    private UserResident Resident;

    @Override
    public String toString() {
        return "VoEstateAndResident{" +
                "Estate=" + Estate +
                ", Resident=" + Resident +
                '}';
    }

    public VoEstateAndResident() {
    }

    public CpmBuildingUnitEstate getEstate() {
        return Estate;
    }

    public void setEstate(CpmBuildingUnitEstate estate) {
        Estate = estate;
    }

    public UserResident getResident() {
        return Resident;
    }

    public void setResident(UserResident resident) {
        Resident = resident;
    }

    public VoEstateAndResident(CpmBuildingUnitEstate estate, UserResident resident) {
        Estate = estate;
        Resident = resident;
    }
}
