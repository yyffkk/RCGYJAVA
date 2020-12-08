package com.api.model.system;

public class TestParent {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "TestParent{" +
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

    public TestParent() {
    }

    public TestParent(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
