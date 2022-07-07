package com.api.model.app;

/**
 * 用户id 与 话题id
 */
public class UserIdAndGambitId {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 话题id
     */
    private Integer gambitId;

    @Override
    public String toString() {
        return "UserIdAndGambitId{" +
                "id=" + id +
                ", gambitId=" + gambitId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGambitId() {
        return gambitId;
    }

    public void setGambitId(Integer gambitId) {
        this.gambitId = gambitId;
    }

    public UserIdAndGambitId() {
    }

    public UserIdAndGambitId(Integer id, Integer gambitId) {
        this.id = id;
        this.gambitId = gambitId;
    }
}
