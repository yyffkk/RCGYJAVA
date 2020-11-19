package com.aku.model.basicArchives;

public class UserResidentRelatives {
    private Integer id;
    private Integer residentId;
    private Integer relativesId;
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
