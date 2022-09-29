package com.api.app.service.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.api.app.filter.wx.ConfigManager;

import com.api.app.filter.wx.PayCommonUtil;

import okhttp3.HttpUrl;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;


import org.springframework.stereotype.Service;


import java.io.IOException;

import java.security.PrivateKey;

import java.security.Signature;
import java.util.*;




@Service
public class WxPayServiceImpl {
    private static  String wxnotify = "https://star.kaidalai.cn/app/vx/notify";

//    private static  String wxnotify = "https://148j82s509.51mypc.cn/api/app/user/vx/notify";

    /**
     * app下单
     * @param outTradeNo
     * @param totalAmount
     * @param description
     * @return
     * @throws IOException
     */
    public String placeAnOrder(String outTradeNo, int totalAmount, String description, PrivateKey privateKey) throws Exception {
        Long time = (System.currentTimeMillis() / 1000);
        JSONObject json = new JSONObject(new LinkedHashMap<>());
        json.put("appid", ConfigManager.getInstance().getConfigItem("WXAppID"));  //应用appid
        json.put("mchid", ConfigManager.getInstance().getConfigItem("MCH_ID")/*PayCommonUtil.MCH_ID*/);  //商户号
        //parameterMap.put("device_info", "WEB");
        json.put("description",description);
        json.put("out_trade_no",outTradeNo);
        json.put("notify_url","https://148j82s509.51mypc.cn/app/vx/payNotify");
        JSONObject jsonOfAmount = new JSONObject();
        jsonOfAmount.put("total",totalAmount);
        json.put("amount",jsonOfAmount);


        String jsonString = json.toJSONString();

        String post = getToken("POST", HttpUrl.parse("https://api.mch.weixin.qq.com/v3/pay/transactions/app"),ConfigManager.getInstance().getConfigItem("MCH_ID"), "2085562750E921915C3FCAA59B10B0F2BCA2E6F6", privateKey, jsonString);
        PostMethod postMethod = null;
        postMethod = new PostMethod("https://api.mch.weixin.qq.com/v3/pay/transactions/app");
        postMethod.setRequestHeader("Content-Type", "application/json");
        postMethod.setRequestHeader("Authorization","WECHATPAY2-SHA256-RSA2048 " + post);
        postMethod.setRequestHeader("Accept","application/json");
        postMethod.setRequestHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");



        StringRequestEntity entity = new StringRequestEntity(jsonString,"application/json","UTF-8");
        postMethod.setRequestEntity(entity);
        org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();
        int response = httpClient.executeMethod(postMethod); // 执行POST方法
        String result = postMethod.getResponseBodyAsString();
        JSONObject jsonObject= JSON.parseObject(result);
        String prepayId = jsonObject.getString("prepay_id");
        return prepayId;
    }






    /**
     * 生成组装请求头
     *
     * @param method     请求方式
     * @param url        请求地址
     * @param mercId     商户ID
     * @param serialNo   证书序列号
     * @param privateKey 私钥
     * @param body       请求体
     * @return 组装请求的数据
     * @throws Exception
     */
    static String getToken(String method, HttpUrl url, String mercId, String serialNo, PrivateKey privateKey, String body) throws Exception {
        String nonceStr = UUID.randomUUID().toString().replace("-", "");
        long timestamp = System.currentTimeMillis() / 1000;
        String message = buildMessage(method, url, timestamp, nonceStr, body);
        String signature = sign(message.getBytes("UTF-8"), privateKey);
        return "mchid=\"" + mercId + "\","
                + "nonce_str=\"" + nonceStr + "\","
                + "timestamp=\"" + timestamp + "\","
                + "serial_no=\"" + serialNo + "\","
                + "signature=\"" + signature + "\"";
    }

    /**
     * 组装签名加载
     *
     * @param method    请求方式
     * @param url       请求地址
     * @param timestamp 请求时间
     * @param nonceStr  请求随机字符串
     * @param body      请求体
     * @return 组装的字符串
     */
    static String buildMessage(String method, HttpUrl url, long timestamp, String nonceStr, String body) {
        String canonicalUrl = url.encodedPath();
        if (url.encodedQuery() != null) {
            canonicalUrl += "?" + url.encodedQuery();
        }
        return method + "\n"
                + canonicalUrl + "\n"
                + timestamp + "\n"
                + nonceStr + "\n"
                + body + "\n";
    }

    /**
     * 微信调起支付参数
     * 返回参数如有不理解 请访问微信官方文档
     * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_1_4.shtml
     *
     * @param prepayId   微信下单返回的prepay_id
     * @param privateKey 私钥
     * @return 当前调起支付所需的参数
     * @throws Exception
     */
    public JSONObject wxMpUp(String prepayId,  PrivateKey privateKey) throws Exception {
        String time = System.currentTimeMillis() / 1000 + "";
//        String nonceStr = UUID.randomUUID().toString().replace("-", "");
        String nonceStr =PayCommonUtil.getRandomString(32);
        String packageStr = "prepay_id=" + prepayId;
        ArrayList<String> list = new ArrayList<>();
        list.add(ConfigManager.getInstance().getConfigItem("WXAppID"));
        list.add(time);
        list.add(nonceStr);
        list.add(packageStr);
        //加载签名
        String packageSign = sign(buildSignMessage(list).getBytes(), privateKey);
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject.put("appid", ConfigManager.getInstance().getConfigItem("WXAppID"));
        jsonObject.put("partnerid",ConfigManager.getInstance().getConfigItem("MCH_ID"));
        jsonObject.put("prepayid", prepayId);
        jsonObject.put("package","Sign=WXPay");
        jsonObject.put("nonceStr", nonceStr);
        jsonObject.put("timeStamp", time);
        jsonObject.put("sign", packageSign);
        return jsonObject;
    }

    /**
     * 构造签名串
     *
     * @param signMessage 待签名的参数
     * @return 构造后带待签名串
     */
    static String buildSignMessage(ArrayList<String> signMessage) {
        if (signMessage == null || signMessage.size() <= 0) {
            return null;
        }
        StringBuilder sbf = new StringBuilder();
        for (String str : signMessage) {
            sbf.append(str).append("\n");
        }
        return sbf.toString();
    }


   static String sign(byte[] message, PrivateKey privateKey) throws Exception {
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(privateKey);
        sign.update(message);
        return Base64.getEncoder().encodeToString(sign.sign());
    }







}
