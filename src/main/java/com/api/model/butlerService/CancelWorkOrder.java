package com.api.model.butlerService;

/**
 * 作废工单
 */
public class CancelWorkOrder {
    /**
     * 工单主键id
     */
    private Integer id;
    /**
     * 作废原因
     */
    private String content;

    @Override
    public String toString() {
        return "CancelWorkOrder{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CancelWorkOrder() {
    }

    public CancelWorkOrder(Integer id, String content) {
        this.id = id;
        this.content = content;
    }
}
