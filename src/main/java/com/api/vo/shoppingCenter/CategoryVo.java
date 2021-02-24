package com.api.vo.shoppingCenter;

/**
 * 分类管理Vo list 回显
 */
public class CategoryVo {
    /**
     * 分类主键id
     */
    private Integer id;
    /**
     * 层级全路径::分割id
     */
    private String idPath;
    /**
     * 分类名称
     */
    private String name;

    @Override
    public String toString() {
        return "CategoryVo{" +
                "id=" + id +
                ", idPath='" + idPath + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdPath() {
        return idPath;
    }

    public void setIdPath(String idPath) {
        this.idPath = idPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryVo() {
    }

    public CategoryVo(Integer id, String idPath, String name) {
        this.id = id;
        this.idPath = idPath;
        this.name = name;
    }
}
