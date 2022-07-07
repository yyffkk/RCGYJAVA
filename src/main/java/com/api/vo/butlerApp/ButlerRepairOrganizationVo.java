package com.api.vo.butlerApp;

import java.util.List;

/**
 * 管家app 维修部组织 信息Vo 回显
 */
public class ButlerRepairOrganizationVo {
    /**
     * 子组织主键id
     */
    private Integer id;
    /**
     * 子组织姓名
     */
    private String name;
    /**
     * 子组织 人员信息
     */
    private List<ButlerRepairmanVo> repairmanVos;

    @Override
    public String toString() {
        return "ButlerRepairOrganizationVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", repairmanVos=" + repairmanVos +
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

    public List<ButlerRepairmanVo> getRepairmanVos() {
        return repairmanVos;
    }

    public void setRepairmanVos(List<ButlerRepairmanVo> repairmanVos) {
        this.repairmanVos = repairmanVos;
    }

    public ButlerRepairOrganizationVo() {
    }

    public ButlerRepairOrganizationVo(Integer id, String name, List<ButlerRepairmanVo> repairmanVos) {
        this.id = id;
        this.name = name;
        this.repairmanVos = repairmanVos;
    }
}
