package com.api.model.app;

/**
 * 用户id 和 咨询建议主键id
 */
public class UserIdAndAdviceId {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 咨询建议主键id
     */
    private Integer adviceId;

    @Override
    public String toString() {
        return "UserIdAndAdviceId{" +
                "id=" + id +
                ", adviceId=" + adviceId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(Integer adviceId) {
        this.adviceId = adviceId;
    }

    public UserIdAndAdviceId() {
    }

    public UserIdAndAdviceId(Integer id, Integer adviceId) {
        this.id = id;
        this.adviceId = adviceId;
    }
}
