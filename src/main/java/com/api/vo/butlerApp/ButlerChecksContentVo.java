package com.api.vo.butlerApp;

/**
 * 管家app 检查内容回显信息
 */
public class ButlerChecksContentVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 检查内容名称
     */
    private String name;

    @Override
    public String toString() {
        return "ButlerChecksContentVo{" +
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

    public ButlerChecksContentVo() {
    }

    public ButlerChecksContentVo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
