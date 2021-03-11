package com.api.model.alipay;

/**
 * 测试订单
 */
public class OrderTest {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
     */
    private String body;
    /**
     * 商品名称
     */
    private String subject;
    /**
     * 商户订单号(自动生成)
     */
    private String outTradeNo;
    /**
     * 交易超时时间
     */
    private String timeoutExpress;
    /**
     * 支付金额
     */
    private String totalAmount;

    @Override
    public String toString() {
        return "OrderTest{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", subject='" + subject + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", timeoutExpress='" + timeoutExpress + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTimeoutExpress() {
        return timeoutExpress;
    }

    public void setTimeoutExpress(String timeoutExpress) {
        this.timeoutExpress = timeoutExpress;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderTest() {
    }

    public OrderTest(Integer id, String body, String subject, String outTradeNo, String timeoutExpress, String totalAmount) {
        this.id = id;
        this.body = body;
        this.subject = subject;
        this.outTradeNo = outTradeNo;
        this.timeoutExpress = timeoutExpress;
        this.totalAmount = totalAmount;
    }
}
