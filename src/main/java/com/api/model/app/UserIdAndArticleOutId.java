package com.api.model.app;

/**
 * 用户主键id 和 物品出户主键id
 */
public class UserIdAndArticleOutId {
    /**
     * 用户主键id
     */
    private Integer userId;
    /**
     * 物品出户主键id
     */
    private Integer articleOutId;

    @Override
    public String toString() {
        return "UserIdAndArticleOutId{" +
                "userId=" + userId +
                ", articleOutId=" + articleOutId +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArticleOutId() {
        return articleOutId;
    }

    public void setArticleOutId(Integer articleOutId) {
        this.articleOutId = articleOutId;
    }

    public UserIdAndArticleOutId() {
    }

    public UserIdAndArticleOutId(Integer userId, Integer articleOutId) {
        this.userId = userId;
        this.articleOutId = articleOutId;
    }
}
