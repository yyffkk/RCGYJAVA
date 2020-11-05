package com.aku.model.system;

/**
 * 系统权限表
 */
public class SysJurisdiction {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限编码
     */
    private String code;
    /**
     * 上级权限ID
     */
    private Integer parentId;
    /**
     * 系统功能ID
     */
    private Integer actionId;
    /**
     * 菜单路径
     */
    private String url;
    /**
     * 连接类型
     */
    private Integer linkType;
    /**
     * 排序
     */
    private Integer sort;

    @Override
    public String toString() {
        return "SysJurisdiction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", parentId=" + parentId +
                ", actionId=" + actionId +
                ", url='" + url + '\'' +
                ", linkType=" + linkType +
                ", sort=" + sort +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLinkType() {
        return linkType;
    }

    public void setLinkType(Integer linkType) {
        this.linkType = linkType;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public SysJurisdiction() {
    }

    public SysJurisdiction(Integer id, String name, String code, Integer parentId, Integer actionId, String url, Integer linkType, Integer sort) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.parentId = parentId;
        this.actionId = actionId;
        this.url = url;
        this.linkType = linkType;
        this.sort = sort;
    }
}
