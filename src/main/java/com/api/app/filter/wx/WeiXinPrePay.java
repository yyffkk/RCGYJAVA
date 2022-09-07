package com.api.app.filter.wx;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeiXinPrePay {

    /**
     * appId
     */
    private String appId;
    /**
     * 商户号
     */
    private String mchId;
    /**
     * 时间戳
     */
    private String timeStamp;
    /**
     *生成签名字符串
     */
    private String nonceStr;
    /**
     *预支付回话id
     */
    private String prepayId;
    /**
     * 签名类型
     */
    private String signType;
    /**
     * 支付签名
     */
    private String paySign;
}
