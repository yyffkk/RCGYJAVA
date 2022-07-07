package com.api.vo.butlerApp;

import java.util.Date;

/**
 * 管家端系统消息Vo 回显
 */
public class ButlerSysMessageVo {
    /**
     * 消息主键id
     */
    private Integer id;
    /**
     * 消息类型（1.报事报修，2.装修,3.绿化任务，4.卫生任务）
     */
    private Integer type;
    /**
     * 关联的主键id（报事报修id,装修id,绿化任务id,卫生任务id）
     */
    private Integer relationId;
    /**
     * 发送时间
     */
    private Date sendDate;

    @Override
    public String toString() {
        return "ButlerSysMessageVo{" +
                "id=" + id +
                ", type=" + type +
                ", relationId=" + relationId +
                ", sendDate=" + sendDate +
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

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public ButlerSysMessageVo() {
    }

    public ButlerSysMessageVo(Integer id, Integer type, Integer relationId, Date sendDate) {
        this.id = id;
        this.type = type;
        this.relationId = relationId;
        this.sendDate = sendDate;
    }
}
