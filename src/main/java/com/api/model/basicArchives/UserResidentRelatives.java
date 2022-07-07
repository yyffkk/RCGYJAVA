package com.api.model.basicArchives;

/**
 * 住户亲属关联表信息model
 */
public class UserResidentRelatives {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 业主id(租客id)
     */
    private Integer residentId;
    /**
     * 亲属id
     */
    private Integer relativesId;
    /**
     * 亲属的身份
     */
    private Integer identity;

    @Override
    public String toString() {
        return "UserResidentRelatives{" +
                "id=" + id +
                ", residentId=" + residentId +
                ", relativesId=" + relativesId +
                ", identity=" + identity +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    public Integer getRelativesId() {
        return relativesId;
    }

    public void setRelativesId(Integer relativesId) {
        this.relativesId = relativesId;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public UserResidentRelatives() {
    }

    public UserResidentRelatives(Integer id, Integer residentId, Integer relativesId, Integer identity) {
        this.id = id;
        this.residentId = residentId;
        this.relativesId = relativesId;
        this.identity = identity;
    }
}
