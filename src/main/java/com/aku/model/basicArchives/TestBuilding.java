package com.aku.model.basicArchives;

public class TestBuilding {
    private String id;
    private String number;
    private String name;

    @Override
    public String toString() {
        return "TestBuilding{" +
                "id='" + id + '\'' +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestBuilding() {
    }

    public TestBuilding(String id, String number, String name) {
        this.id = id;
        this.number = number;
        this.name = name;
    }
}
