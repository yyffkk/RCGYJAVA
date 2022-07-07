package com.api.vo.chargeManagement;

/**
 * 待缴费人信息
 */
public class VoPayResident {
    /**
     * 待缴费人主键id
     */
    private Integer id;
    /**
     * 待缴费人姓名
     */
    private String name;

    @Override
    public String toString() {
        return "VoPayResident{" +
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

    public VoPayResident() {
    }

    public VoPayResident(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
