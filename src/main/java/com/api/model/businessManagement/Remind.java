package com.api.model.businessManagement;

/**
 * 提醒通知model信息
 */
public class Remind {
    /**
     * 主键Id
     */
    private Integer id;
    /**
     * 提醒标题
     */
    private String title;
    /**
     * 提醒内容
     */
    private String content;
    /**
     * 提醒用户id
     */
    private Integer receiverAccount;

    @Override
    public String toString() {
        return "Remind{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", receiverAccount=" + receiverAccount +
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

    public Integer getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(Integer receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public Remind() {
    }

    public Remind(Integer id, String title, String content, Integer receiverAccount) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.receiverAccount = receiverAccount;
    }
}
