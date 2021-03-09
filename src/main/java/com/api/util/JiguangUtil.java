package com.api.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 极光推送 Util工具类
 */
@Component
public class JiguangUtil {
    private static final Logger log = LoggerFactory.getLogger(JiguangUtil.class);

    private static String masterSecret;
    @Value("${jg.masterSecret}")
    public void setMasterSecret(String masterSecret){
        this.masterSecret = masterSecret;
    }

    private static String appKey;
    @Value("${jg.appKey}")
    public void setAppKey(String appKey){
        this.appKey = appKey;
    }

    private static String butlerMasterSecret;
    @Value("${jg.butlerMasterSecret}")
    public void setButlerMasterSecret(String butlerMasterSecret) {
        this.butlerMasterSecret = butlerMasterSecret;
    }



    private static String butlerAppKey;
    @Value("${jg.butlerAppKey}")
    public void setButlerAppKey(String butlerAppKey) {
        this.butlerAppKey = butlerAppKey;
    }



//    private static final String ALERT = "推送信息";
//    /**
//     * 极光推送
//     */
//    public void jiguangPush(){
//        String alias = "123456";//声明别名
//        log.info("对别名" + alias + "的用户推送信息");
//        PushResult result = push(String.valueOf(alias),ALERT);
//        if(result != null && result.isResultOK()){
//            log.info("针对别名" + alias + "的信息推送成功！");
//        }else{
//            log.info("针对别名" + alias + "的信息推送失败！");
//        }
//    }

    /**
     * 生成极光推送对象PushPayload（采用java SDK）
     * @param alias 别名
     * @param alert 消息
     * @return PushPayload
     */
    public static PushPayload buildPushObject_android_ios_alias_alert(String alias,String alert){
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .addExtra("type", "infomation")
                                .setAlert(alert)
                                .build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .addExtra("type", "infomation")
                                .setAlert(alert)
                                .build())
                        .build())
                .setOptions(Options.newBuilder()
                        .setApnsProduction(false)//true-推送生产环境 false-推送开发环境（测试使用参数）
                        .setTimeToLive(90)//消息在JPush服务器的失效时间（测试使用参数）
                        .build())
                .build();
    }
    /**
     * app 极光推送方法(采用java SDK)
     * @param alias 别名
     * @param alert 消息
     * @return PushResult
     */
    public static PushResult push(String alias,String alert){
        ClientConfig clientConfig = ClientConfig.getInstance();
        JPushClient jpushClient = new JPushClient(masterSecret, appKey, null, clientConfig);
        PushPayload payload = buildPushObject_android_ios_alias_alert(alias,alert);
        try {
            return jpushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            log.error("Connection error. Should retry later. ", e);
            return null;
        } catch (APIRequestException e) {
            log.error("Error response from JPush server. Should review and fix it. ", e);
            log.info("HTTP Status: " + e.getStatus());
            log.info("Error Code: " + e.getErrorCode());
            log.info("Error Message: " + e.getErrorMessage());
            log.info("Msg ID: " + e.getMsgId());
            return null;
        }
    }

    /**
     * 管家app 极光推送方法(采用java SDK)
     * @param alias 别名
     * @param alert 消息
     * @return PushResult
     */
    public static PushResult butlerPush(String alias,String alert){
        ClientConfig clientConfig = ClientConfig.getInstance();
        JPushClient jpushClient = new JPushClient(butlerMasterSecret, butlerAppKey, null, clientConfig);
        PushPayload payload = buildPushObject_android_ios_alias_alert(alias,alert);
        try {
            return jpushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            log.error("Connection error. Should retry later. ", e);
            return null;
        } catch (APIRequestException e) {
            log.error("Error response from JPush server. Should review and fix it. ", e);
            log.info("HTTP Status: " + e.getStatus());
            log.info("Error Code: " + e.getErrorCode());
            log.info("Error Message: " + e.getErrorMessage());
            log.info("Msg ID: " + e.getMsgId());
            return null;
        }
    }
}
