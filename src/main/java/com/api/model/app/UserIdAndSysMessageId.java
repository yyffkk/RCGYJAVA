package com.api.model.app;

/**
 * 用户主键id 和 消息列表主键id
 */
public class UserIdAndSysMessageId {
    /**
     * 用户主键id
     */
    private Integer id;
    /**
     * 消息列表主键id
     */
    private Integer sysMessageId;

    @Override
    public String toString() {
        return "UserIdAndSysMessageId{" +
                "id=" + id +
                ", sysMessageId=" + sysMessageId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSysMessageId() {
        return sysMessageId;
    }

    public void setSysMessageId(Integer sysMessageId) {
        this.sysMessageId = sysMessageId;
    }

    public UserIdAndSysMessageId() {
    }

    public UserIdAndSysMessageId(Integer id, Integer sysMessageId) {
        this.id = id;
        this.sysMessageId = sysMessageId;
    }
}
