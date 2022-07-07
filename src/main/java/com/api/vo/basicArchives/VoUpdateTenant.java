package com.api.vo.basicArchives;

import com.api.model.basicArchives.CpmResidentEstate;
import com.api.model.basicArchives.UserResident;

import java.util.Arrays;
import java.util.List;

/**
 * 修改租户信息Vo，关联租房屋
 */
public class VoUpdateTenant {
    /**
     * 租户数据
     */
    UserResident userResident;
    /**
     * 删除租房id集合
     */
    int[] deleteEstateId;
    /**
     * 添加的租房数据集合
     */
    List<CpmResidentEstate> insertEstate;
    /**
     * 修改的租房数据集合
     */
    List<CpmResidentEstate> updateEstate;

    @Override
    public String toString() {
        return "VoUpdateTenant{" +
                "userResident=" + userResident +
                ", deleteEstateId=" + Arrays.toString(deleteEstateId) +
                ", insertEstate=" + insertEstate +
                ", updateEstate=" + updateEstate +
                '}';
    }

    public UserResident getUserResident() {
        return userResident;
    }

    public void setUserResident(UserResident userResident) {
        this.userResident = userResident;
    }

    public int[] getDeleteEstateId() {
        return deleteEstateId;
    }

    public void setDeleteEstateId(int[] deleteEstateId) {
        this.deleteEstateId = deleteEstateId;
    }

    public List<CpmResidentEstate> getInsertEstate() {
        return insertEstate;
    }

    public void setInsertEstate(List<CpmResidentEstate> insertEstate) {
        this.insertEstate = insertEstate;
    }

    public List<CpmResidentEstate> getUpdateEstate() {
        return updateEstate;
    }

    public void setUpdateEstate(List<CpmResidentEstate> updateEstate) {
        this.updateEstate = updateEstate;
    }

    public VoUpdateTenant() {
    }

    public VoUpdateTenant(UserResident userResident, int[] deleteEstateId, List<CpmResidentEstate> insertEstate, List<CpmResidentEstate> updateEstate) {
        this.userResident = userResident;
        this.deleteEstateId = deleteEstateId;
        this.insertEstate = insertEstate;
        this.updateEstate = updateEstate;
    }
}
