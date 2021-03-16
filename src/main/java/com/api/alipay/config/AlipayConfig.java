package com.api.alipay.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class AlipayConfig {
    // 1.商户appid（可以传随意固定值）
    public static String APPID = "2017...";

    //2.私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCCb0rjs7x/lfAi4dfemg3cscdgL+6HQGC31EFBiuPC0YfhZKSxvcoM4Yg9nSIXNr25s+u7jDd2Vo4aKoXoKzeqwn5I5HcbFjLf3v/+jBp/GqUqbSIrcNed3TgXfoeXGbr/zHLRCjpNRQLiHT7n41+kw8uDOIDlR5R6pH1TeJaM0aGGF0TEdvG+tY6lmfAFr3MUM9iJdcNECq0pg5lC2McucIMP14X+VsDABOkO5xX7oP+3/fy34PBPVxUs25AESlR3aNGBmfEtkMKHJRTB6OrN254aGgeCZHeto1GouKIFGwyNaVaixPE37XEwIF4VMvni58TjzL6RS4ztOa+89+bHAgMBAAECggEARE2havIBQNK0qJ+ZmpETt0FFhcIz55G31CwLbBYeRTPSMx6v+//F4c7suE8jvgJFggyM4m5/0LFswpkH/Fc9VGd7GBLDqGSMiZ1Ocu7NJUg/u6LgpNz3nExvBiaVPHQV78QRUBRKCZKc+umTunzf5fk+Bl49aVN9lmey1VYtiFmzDzy36C+5JmP/fkaRt2l6oyF5SI3dD32zF8ktACkk8ugPj+yXwaKD4XGng0twGo5qwZUZU8aK/1IQZ/FaMEV7Isaea1AN0wpcbs4TOOj86b0udVTGqS1Dini8OU3sXIcOYwvWflirfFcIJQnaT2XjwI4L7yQbyczcjX8h7hNQWQKBgQC6cX7JrZwmBl5/M2sJ+U5l6DcKWVSuafbz9tdEBo0eHbt4CQQYudDredRFU70O8MxL7NKO0Ok9gVj4Ei6z/afZXy0hS8Y5ardftS4Z5Dpnzl2OdB/z4MQIE99WAOZaOLsP3WI4K63uaGZDpLfQYmYShHl1fP77f7EL5cdgxJERpQKBgQCzGKAYh1K7vbttgeCaxJpiXIKf2Y++sV9sviAHvK+jZU3xX7JB1Gm+mQuYrTclSlJU5RPKgwyu+p81n48pm1NsPbQkQ7aDXYx9oMvAm6JmH+cl5V9tjhk2rgQN5qiTyqYRqanKRPBfVliHz3+A6T7JI9TG0W+YQJm7qjp6nSYS+wKBgD0/NXBZONeA9iABKyOOo4N0okgjCl91beu85gBxyn/fMot/IrpgqFICponTtWKoFeTHOnAyDrzmtexgRLlaFX6h9nhepRKNjQnCwg89WzZoo3E9kpWR+7PPm2lsSD/RLRpMFozvRGbyIs4L2Vp6SJ/CpwfCdRz3WJjY9gNC74kFAoGAZejhUJPQNBxmho2c7PRqlQXnHmaCMRRlJE+bkkt/9g4zJ+I4YNUpxtb3jk0iUAnWh5BCjr27feYGqlC8+gP0mGcUFn6hYGbfBq10w4jMBCirMxkuD/0Hw+GJVQ+nZVGu5eYRQ5Ou49ESV1VvTD9tBq9o6ClMwuofkHXxCMxbWfkCgYEAn9/kF9omOMPJXn21UxkcGaOMD4fFLWlMtYqMOX613NsTQNZVn9GbVBiTW9d9VwB9UDx/jtE8wG3mU9GM5J71fbJd5RmRf82g2c8Zyl6KpfzcwMiw0DbQrY3771f9qRSHKECbAmqe9VJSyZ3oYrKRz9r0Qh7ikHfreVw0fT2sVaY=";

    // 3.支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn/+kAfDzQ+y7jkY3ngiKl0W2HD40BlLSW18IQDxWJyStOkDXZQe4uJH9y2tmLkIrICMrexy1ekXtRGVG4vX2AmEQB6x9/SOHZGdUCn9BxsHWM+5afJbeZJCcQUkN9rC5u2tu2F81UQCnaFUIz0r/Hecmk1TAfktQ8AxSDc4/wHi4Pg/xU1pVOln5XvZ+WKwHu904f+TibweUOUyp4ahxfUPAahJ5QmVpZrEqV45rouyyMc+9seeL4PFLjAk/a9dxetKYdCzDX4JA/Jji0TX1CacAYllCEpgTddpbOf4HxCFnw8sl8BHe6DfZKrv7l2V3AaQtSvfTFkz6wDJM81mToQIDAQAB";

    // 4.服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参
    //数，必须外网可以正常访问【访问后端】
    public static String notify_url = "http://test.akuhotel.com:8804/IntelligentCommunity/alipay/notify_url";

    //5.页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义
    //参数，必须外网可以正常访问 商户可以自定义同步跳转地址【访问前端】
    public static String return_url = "http://test.akuhotel.com:8804/IntelligentCommunity/alipay/return_url.do";

    // 6.请求支付宝的网关地址
    public static String URL = "https://openapi.alipay.com/gateway.do";

    // 7.编码
    public static String CHARSET = "UTF-8";

    // 8.返回格式
    public static String FORMAT = "json";

    // 9.加密类型
    public static String SIGNTYPE = "RSA2";

}
