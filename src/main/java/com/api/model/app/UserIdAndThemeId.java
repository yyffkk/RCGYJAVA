package com.api.model.app;

/**
 * 用户id 与 主题主键id
 */
public class UserIdAndThemeId {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 主题主键id
     */
    private Integer themeId;

    @Override
    public String toString() {
        return "UserIdAndThemeId{" +
                "id=" + id +
                ", themeId=" + themeId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

    public UserIdAndThemeId() {
    }

    public UserIdAndThemeId(Integer id, Integer themeId) {
        this.id = id;
        this.themeId = themeId;
    }
}
