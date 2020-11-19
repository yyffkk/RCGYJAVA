package com.aku.vo.basicArchives;

import com.aku.model.basicArchives.UserResident;

import java.util.Arrays;
import java.util.List;

/**
 * 修改业主信息Vo，关联亲属
 */
public class VoUpdateResident {
    /**
     * 业主数据
     */
    UserResident userResident;
    /**
     * 删除亲属id集合
     */
    int[] deleteRelativesId;
    /**
     * 添加的亲属数据集合
     */
    List<VoRelatives> insertRelatives;
    /**
     * 修改的亲属数据集合
     */
    List<VoRelatives> updateRelatives;

    @Override
    public String toString() {
        return "VoUpdateResident{" +
                "userResident=" + userResident +
                ", deleteRelativesId=" + Arrays.toString(deleteRelativesId) +
                ", insertRelatives=" + insertRelatives +
                ", updateRelatives=" + updateRelatives +
                '}';
    }

    public UserResident getUserResident() {
        return userResident;
    }

    public void setUserResident(UserResident userResident) {
        this.userResident = userResident;
    }

    public int[] getDeleteRelativesId() {
        return deleteRelativesId;
    }

    public void setDeleteRelativesId(int[] deleteRelativesId) {
        this.deleteRelativesId = deleteRelativesId;
    }

    public List<VoRelatives> getInsertRelatives() {
        return insertRelatives;
    }

    public void setInsertRelatives(List<VoRelatives> insertRelatives) {
        this.insertRelatives = insertRelatives;
    }

    public List<VoRelatives> getUpdateRelatives() {
        return updateRelatives;
    }

    public void setUpdateRelatives(List<VoRelatives> updateRelatives) {
        this.updateRelatives = updateRelatives;
    }

    public VoUpdateResident() {
    }

    public VoUpdateResident(UserResident userResident, int[] deleteRelativesId, List<VoRelatives> insertRelatives, List<VoRelatives> updateRelatives) {
        this.userResident = userResident;
        this.deleteRelativesId = deleteRelativesId;
        this.insertRelatives = insertRelatives;
        this.updateRelatives = updateRelatives;
    }
}
