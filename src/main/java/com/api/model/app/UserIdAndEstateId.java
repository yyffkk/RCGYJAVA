package com.api.model.app;

/**
 * 用户id和房产id
 */
public class UserIdAndEstateId {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 房产id
     */
    private Integer estateId;

    @Override
    public String toString() {
        return "UserIdAndEstateId{" +
                "id=" + id +
                ", estateId=" + estateId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public UserIdAndEstateId() {
    }

    public UserIdAndEstateId(Integer id, Integer estateId) {
        this.id = id;
        this.estateId = estateId;
    }
}
