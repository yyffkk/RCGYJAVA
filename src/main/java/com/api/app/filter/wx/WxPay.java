package com.api.app.filter.wx;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxPay {
    /**
     * appid
     */
    private String appId;
    /**
     * 商户号
     */
    private String partnerId;
    /**
     * 预支付交易会话ID
     */
    private String prepayId;
    /**
     * 订单详情扩展字符串
     */
    private String packages;
    /**
     *随机字符串
     */
    private String nonceStr;
    /**
     *时间戳
     */
    private String timeStamp;
    /**
     * 签名
     */
    private String sign;
}

