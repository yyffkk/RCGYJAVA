package com.api.model.app;

/**
 * 家政服务主键id 和 用户主键id
 */
public class UserIdAndHousekeepingServiceId {
    /**
     * 家政服务主键id
     */
    private Integer housekeepingServiceId;
    /**
     * 用户主键id
     */
    private Integer id;

    @Override
    public String toString() {
        return "UserIdAndHousekeepingServiceId{" +
                "housekeepingServiceId=" + housekeepingServiceId +
                ", id=" + id +
                '}';
    }

    public Integer getHousekeepingServiceId() {
        return housekeepingServiceId;
    }

    public void setHousekeepingServiceId(Integer housekeepingServiceId) {
        this.housekeepingServiceId = housekeepingServiceId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserIdAndHousekeepingServiceId() {
    }

    public UserIdAndHousekeepingServiceId(Integer housekeepingServiceId, Integer id) {
        this.housekeepingServiceId = housekeepingServiceId;
        this.id = id;
    }
}
