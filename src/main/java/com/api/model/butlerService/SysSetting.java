package com.api.model.butlerService;

/**
 * @author king
 * @since 2022/08/23/10:28 上午
 * 系统设置
 */
public class SysSetting {

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 功能标识（OWNERS:业委会）
     */
    private String action;
    /**
     * 手机号
     */
    private String tel;

    @Override
    public String toString() {
        return "SysSetting{" +
                "id=" + id +
                ", action='" + action + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public SysSetting() {
    }

    public SysSetting(Integer id, String action, String tel) {
        this.id = id;
        this.action = action;
        this.tel = tel;
    }
}
