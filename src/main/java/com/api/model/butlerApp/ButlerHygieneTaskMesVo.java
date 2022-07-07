package com.api.model.butlerApp;

/**
 * 管家app 卫生任务消息信息
 */
public class ButlerHygieneTaskMesVo {
    /**
     * 卫生任务主键id
     */
    private Integer id;
    /**
     * 卫生人员名称
     */
    private String name;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 卫生区域名称
     */
    private String areaName;

    @Override
    public String toString() {
        return "ButlerHygieneTaskMesVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", areaName='" + areaName + '\'' +
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

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public ButlerHygieneTaskMesVo() {
    }

    public ButlerHygieneTaskMesVo(Integer id, String name, String tel, String areaName) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.areaName = areaName;
    }
}
