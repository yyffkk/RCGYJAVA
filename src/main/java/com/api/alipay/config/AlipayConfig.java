package com.api.alipay.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class AlipayConfig {
    // 1.商户appid（可以不传）
    public static String APPID = "2017...";

    //2.私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY ="MIIEwAIBADANBg.....";

    // 3.支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn/+kAfDzQ+y7jkY3ngiKl0W2HD40BlLSW18IQDxWJyStOkDXZQe4uJH9y2tmLkIrICMrexy1ekXtRGVG4vX2AmEQB6x9/SOHZGdUCn9BxsHWM+5afJbeZJCcQUkN9rC5u2tu2F81UQCnaFUIz0r/Hecmk1TAfktQ8AxSDc4/wHi4Pg/xU1pVOln5XvZ+WKwHu904f+TibweUOUyp4ahxfUPAahJ5QmVpZrEqV45rouyyMc+9seeL4PFLjAk/a9dxetKYdCzDX4JA/Jji0TX1CacAYllCEpgTddpbOf4HxCFnw8sl8BHe6DfZKrv7l2V3AaQtSvfTFkz6wDJM81mToQIDAQAB";

    // 4.服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参
    //数，必须外网可以正常访问
    public static String notify_url = "http://www.xxx.com/alipay/notify_url";

    //5.页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义
    //参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "http://www.xxx.com/alipay/return_url.do";

    // 6.请求支付宝的网关地址
    public static String URL = "https://openapi.alipay.com/gateway.do";

    // 7.编码
    public static String CHARSET = "UTF-8";

    // 8.返回格式
    public static String FORMAT = "json";

    // 9.加密类型
    public static String SIGNTYPE = "RSA2";

}
