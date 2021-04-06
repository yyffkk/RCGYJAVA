package com.api.vo.butlerApp;

/**
 * 报事报修消息信息
 */
public class ButlerRepairMessageVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 报修人
     */
    private String name;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 服务类型（1.公区维修（户外报修），2.家庭维修）
     */
    private Integer type;

    @Override
    public String toString() {
        return "ButlerRepairMessageVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", type=" + type +
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public ButlerRepairMessageVo() {
    }

    public ButlerRepairMessageVo(Integer id, String name, String tel, Integer type) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.type = type;
    }
}
