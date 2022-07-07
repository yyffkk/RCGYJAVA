package com.api.vo.app;

public class AppSysMessageVo {
    /**
     * 消息列表主键id
     */
    private Integer id;
    /**
     * 标题
     */
    private String Title;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 状态（1.未读，3.已读）
     */
    private Integer status;

    @Override
    public String toString() {
        return "AppSysMessageVo{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public AppSysMessageVo() {
    }

    public AppSysMessageVo(Integer id, String title, String content, Integer status) {
        this.id = id;
        Title = title;
        this.content = content;
        this.status = status;
    }
}
