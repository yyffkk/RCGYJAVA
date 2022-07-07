package com.api.vo.butlerApp;

import java.util.List;

/**
 * 管家app用户详情
 */
public class ButlerUserDetailVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 权限信息(52.派单(派单人)，53.接单（维修人），55.放行（保安），57.操作权限（借还管理）)
     */
    private List<Integer> jurisdiction;

    @Override
    public String toString() {
        return "ButlerUserDetailVo{" +
                "id=" + id +
                ", roleId='" + roleId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", jurisdiction=" + jurisdiction +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<Integer> getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(List<Integer> jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public ButlerUserDetailVo() {
    }

    public ButlerUserDetailVo(Integer id, String roleId, String nickName, List<Integer> jurisdiction) {
        this.id = id;
        this.roleId = roleId;
        this.nickName = nickName;
        this.jurisdiction = jurisdiction;
    }
}
