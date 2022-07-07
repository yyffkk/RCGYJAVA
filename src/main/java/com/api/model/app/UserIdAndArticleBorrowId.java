package com.api.model.app;

/**
 * 用户id 和 物品借还主键id
 */
public class UserIdAndArticleBorrowId {
    /**
     * 用户id
     */
    private Integer Id;
    /**
     * 物品借还主键id
     */
    private Integer articleBorrowId;

    @Override
    public String toString() {
        return "UserIdAndArticleBorrowId{" +
                "Id=" + Id +
                ", articleBorrowId=" + articleBorrowId +
                '}';
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getArticleBorrowId() {
        return articleBorrowId;
    }

    public void setArticleBorrowId(Integer articleBorrowId) {
        this.articleBorrowId = articleBorrowId;
    }

    public UserIdAndArticleBorrowId() {
    }

    public UserIdAndArticleBorrowId(Integer id, Integer articleBorrowId) {
        Id = id;
        this.articleBorrowId = articleBorrowId;
    }
}
