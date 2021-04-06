package com.api.vo.butlerApp;

/**
 * 报事报修评论信息 Vo 回显
 */
public class ButlerRepairCommentMesVo {
    /**
     * 工单主键id
     */
    private Integer id;
    /**
     * 评论人
     */
    private String name;
    /**
     * 评价（1-10）
     */
    private Integer level;

    @Override
    public String toString() {
        return "ButlerRepairCommentMesVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public ButlerRepairCommentMesVo() {
    }

    public ButlerRepairCommentMesVo(Integer id, String name, Integer level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }
}
