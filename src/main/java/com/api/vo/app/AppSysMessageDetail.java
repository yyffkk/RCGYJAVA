package com.api.vo.app;

/**
 * 系统通知详情
 */
public class AppSysMessageDetail {
    /**
     * 消息列表主键id
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;

    @Override
    public String toString() {
        return "AppSysMessageDetail{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AppSysMessageDetail() {
    }

    public AppSysMessageDetail(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
