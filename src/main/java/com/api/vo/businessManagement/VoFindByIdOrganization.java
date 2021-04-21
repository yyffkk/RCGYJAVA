package com.api.vo.businessManagement;

/**
 * 组织架构Vo findById 回显
 */
public class VoFindByIdOrganization {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 上级ID无上级则为0
     */
    private Integer parentId;
    /**
     * 组织名称
     */
    private String name;
    /**
     * 主负责人id
     */
    private Integer leadingId;
    /**
     * 主负责人真实姓名
     */
    private String actualName;
    /**
     * 手机号
     */
    private String leadingTel;
    /**
     * 分类（1.公司，2.部门，3.工作组）
     */
    private Integer categoryId;
    /**
     * 显示排序
     */
    private Integer sort;
    /**
     * 备注
     */
    private String remake;

    @Override
    public String toString() {
        return "VoFindByIdOrganization{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", leadingId=" + leadingId +
                ", actualName='" + actualName + '\'' +
                ", leadingTel='" + leadingTel + '\'' +
                ", categoryId=" + categoryId +
                ", sort=" + sort +
                ", remake='" + remake + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLeadingId() {
        return leadingId;
    }

    public void setLeadingId(Integer leadingId) {
        this.leadingId = leadingId;
    }

    public String getActualName() {
        return actualName;
    }

    public void setActualName(String actualName) {
        this.actualName = actualName;
    }

    public String getLeadingTel() {
        return leadingTel;
    }

    public void setLeadingTel(String leadingTel) {
        this.leadingTel = leadingTel;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public VoFindByIdOrganization() {
    }

    public VoFindByIdOrganization(Integer id, Integer parentId, String name, Integer leadingId, String actualName, String leadingTel, Integer categoryId, Integer sort, String remake) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.leadingId = leadingId;
        this.actualName = actualName;
        this.leadingTel = leadingTel;
        this.categoryId = categoryId;
        this.sort = sort;
        this.remake = remake;
    }
}
