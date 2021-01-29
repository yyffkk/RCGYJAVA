package com.api.vo.app;

/**
 * 用户id 和 用户名称
 */
public class IdAndName {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户名称
     */
    private String name;

    @Override
    public String toString() {
        return "IdAndName{" +
                "id=" + id +
                ", name='" + name + '\'' +
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

    public IdAndName() {
    }

    public IdAndName(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
