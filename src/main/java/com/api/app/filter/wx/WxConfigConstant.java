package com.api.app.filter.wx;

public class WxConfigConstant {
    /**
     * APP_ID
     */
    public static final String APP_ID = "wxf30c210487f84321d";

    /**
     * APP_SECRET
     */
    public static final String APP_SECRET = "bee1813225a6c0caef88ab21b222226c9";


    //===================================以下为微信支付部分================================================
    /**
     * 直连商户号,由微信支付生成并下发
     */
    public static final String MCH_ID = "15262958571";

    /**
     * 密钥key
     */
    public static final String KEY = "51a57db9e0a4f1dd2a5113dc05424066b";

    /**
     * 证书序列号
     */
    public static String CERTNO = "4EC503193104E12B14A8E25D1FCDB224C0934DFBC0";

    /**
     * 微信支付回调通知地址
     */
    public static final String NOTIFY_URL = "/api/wxPay/wxPayNotify";

    /**
     * 退款回调
     */
    public static String REFUND_NOTIFY_URL = "/api/wxPay/refundNotify";

}
