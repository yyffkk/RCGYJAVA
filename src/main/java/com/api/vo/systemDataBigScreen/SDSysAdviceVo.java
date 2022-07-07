package com.api.vo.systemDataBigScreen;

import java.util.Date;

/**
 * 系统数据 投诉建议Vo list 回显
 */
public class SDSysAdviceVo {
    /**
     * 类型(1.咨询，2.建议，3.投诉，4.表扬)
     */
    private Integer type;
    /**
     * 状态（3.已反馈）
     */
    private Integer status;
    /**
     * 咨询建议内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "SDSysAdviceVo{" +
                "type=" + type +
                ", status=" + status +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public SDSysAdviceVo() {
    }

    public SDSysAdviceVo(Integer type, Integer status, String content, Date createDate) {
        this.type = type;
        this.status = status;
        this.content = content;
        this.createDate = createDate;
    }
}
