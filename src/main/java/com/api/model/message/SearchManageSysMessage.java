package com.api.model.message;

/**
 * 后台消息列表 搜索条件
 */
public class SearchManageSysMessage {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 发送人类型：1.管家，2.业主
     */
    private Integer senderType;
    /**
     * 消息类型（1.报事报修，2.装修，3.绿化任务，4.卫生任务,5.家政服务,6.建议咨询，7.订单）
     */
    private Integer type;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 接收人
     */
    private Integer receiverAccountId;

    @Override
    public String toString() {
        return "SearchManageSysMessage{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", senderType=" + senderType +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", receiverAccountId=" + receiverAccountId +
                '}';
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Integer getSenderType() {
        return senderType;
    }

    public void setSenderType(Integer senderType) {
        this.senderType = senderType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(Integer receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }

    public SearchManageSysMessage() {
    }

    public SearchManageSysMessage(int pageNum, int size, Integer senderType, Integer type, String content, Integer receiverAccountId) {
        this.pageNum = pageNum;
        this.size = size;
        this.senderType = senderType;
        this.type = type;
        this.content = content;
        this.receiverAccountId = receiverAccountId;
    }
}
