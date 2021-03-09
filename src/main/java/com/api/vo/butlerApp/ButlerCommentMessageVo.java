package com.api.vo.butlerApp;

/**
 * 管家app 评论消息Vo 回显
 */
public class ButlerCommentMessageVo {
    /**
     * 消息主键id
     */
    private Integer id;
    /**
     * 消息类型（1.报事报修）
     */
    private Integer type;
    /**
     * 关联的主键id（工单表主键id）
     */
    private Integer relationId;

    @Override
    public String toString() {
        return "ButlerCommentMessageVo{" +
                "id=" + id +
                ", type=" + type +
                ", relationId=" + relationId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public ButlerCommentMessageVo() {
    }

    public ButlerCommentMessageVo(Integer id, Integer type, Integer relationId) {
        this.id = id;
        this.type = type;
        this.relationId = relationId;
    }
}
