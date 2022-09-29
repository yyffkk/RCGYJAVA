package com.api.wx3;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
import com.wechat.pay.contrib.apache.httpclient.auth.Verifier;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Credentials;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Validator;
import com.wechat.pay.contrib.apache.httpclient.cert.CertificatesManager;
import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;
@Service
public class PaidService {
    private CloseableHttpClient httpClient;

    private CertificatesManager certificatesManager;

    private Verifier verifier;

    /**
     * App下单
     * @param total
     * @param description
     * @return
     * @throws Exception
     */
    public JSONObject requestwxChatPay(String orderSn,int total,String description) throws Exception {
        PrivateKey merchantPrivateKey = PemUtil.loadPrivateKey(new ByteArrayInputStream(PayConstants.privateKey.getBytes("utf-8")));
        // 获取证书管理器实例
        certificatesManager = CertificatesManager.getInstance();
        // 向证书管理器增加需要自动更新平台证书的商户信息
        certificatesManager.putMerchant(PayConstants.MCH_ID, new WechatPay2Credentials(PayConstants.MCH_ID,
                        new PrivateKeySigner(PayConstants.MCH_SERIAL_NO, merchantPrivateKey)),
                PayConstants.API_3KEY.getBytes(StandardCharsets.UTF_8));
        // 从证书管理器中获取verifier
        verifier = certificatesManager.getVerifier(PayConstants.MCH_ID);
        httpClient = WechatPayHttpClientBuilder.create()
                .withMerchant(PayConstants.MCH_ID, PayConstants.MCH_SERIAL_NO, merchantPrivateKey)
                .withValidator(new WechatPay2Validator(certificatesManager.getVerifier(PayConstants.MCH_ID)))
                .build();

        HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/v3/pay/transactions/app");
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader("Content-type","application/json; charset=utf-8");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        //组合请求参数JSON格式
        ObjectNode rootNode = objectMapper.createObjectNode();
        rootNode.put("mchid", PayConstants.MCH_ID)
                .put("appid", PayConstants.APP_ID)
                .put("notify_url", PayConstants.NOTIFY_URL)
                .put("description", description)
                .put("out_trade_no", orderSn);
        rootNode.putObject("amount")
                .put("total", total)
                .put("currency","CNY");
        try {
            objectMapper.writeValue(bos, rootNode);
            httpPost.setEntity(new StringEntity(bos.toString("UTF-8"), "UTF-8"));
            //获取预支付ID
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String bodyAsString = EntityUtils.toString(response.getEntity());
            //微信成功响应
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode==200){
                //时间戳
                String timestamp = System.currentTimeMillis()/1000+"";
                //随机字符串
                String nonce = RandomUtil.randomString(32);
                StringBuilder builder = new StringBuilder();
                // Appid
                builder.append(PayConstants.APP_ID).append("\n");
                // 时间戳
                builder.append(timestamp).append("\n");
                // 随机字符串
                builder.append(nonce).append("\n");
                JsonNode jsonNode = objectMapper.readTree(bodyAsString);
                // 预支付会话ID
                builder.append(jsonNode.get("prepay_id").textValue()).append("\n");
                //获取签名
                String sign = this.sign(builder.toString().getBytes("utf-8"), merchantPrivateKey);
                JSONObject jsonMap = new JSONObject();
                jsonMap.put("nonceStr", nonce);
                jsonMap.put("timeStamp", timestamp);
                jsonMap.put("prepayId", jsonNode.get("prepay_id").textValue());
                jsonMap.put("sign", sign);
                jsonMap.put("package", PayConstants.PACKAGE);
                jsonMap.put("appId", PayConstants.APP_ID);
                jsonMap.put("partnerId", PayConstants.MCH_ID);
//                return jsonMap.toJSONString();//响应签名数据，前端拿着响应数据调起微信SDK
                return jsonMap;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * App下单
     * @param total
     * @param description
     * @return
     * @throws Exception
     */
    public JSONObject requestDailyPayment(String orderSn,int total,String description) throws Exception {
        PrivateKey merchantPrivateKey = PemUtil.loadPrivateKey(new ByteArrayInputStream(PayConstants.privateKey.getBytes("utf-8")));
        // 获取证书管理器实例
        certificatesManager = CertificatesManager.getInstance();
        // 向证书管理器增加需要自动更新平台证书的商户信息
        certificatesManager.putMerchant(PayConstants.MCH_ID, new WechatPay2Credentials(PayConstants.MCH_ID,
                        new PrivateKeySigner(PayConstants.MCH_SERIAL_NO, merchantPrivateKey)),
                PayConstants.API_3KEY.getBytes(StandardCharsets.UTF_8));
        // 从证书管理器中获取verifier
        verifier = certificatesManager.getVerifier(PayConstants.MCH_ID);
        httpClient = WechatPayHttpClientBuilder.create()
                .withMerchant(PayConstants.MCH_ID, PayConstants.MCH_SERIAL_NO, merchantPrivateKey)
                .withValidator(new WechatPay2Validator(certificatesManager.getVerifier(PayConstants.MCH_ID)))
                .build();

        HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/v3/pay/transactions/app");
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader("Content-type","application/json; charset=utf-8");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        //组合请求参数JSON格式
        ObjectNode rootNode = objectMapper.createObjectNode();
        rootNode.put("mchid", PayConstants.MCH_ID)
                .put("appid", PayConstants.APP_ID)
                .put("notify_url", PayConstants.NOTIFY_URL_DAILY_PAYMENT)
                .put("description", description)
                .put("out_trade_no", orderSn);
        rootNode.putObject("amount")
                .put("total", total)
                .put("currency","CNY");
        try {
            objectMapper.writeValue(bos, rootNode);
            httpPost.setEntity(new StringEntity(bos.toString("UTF-8"), "UTF-8"));
            //获取预支付ID
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String bodyAsString = EntityUtils.toString(response.getEntity());
            //微信成功响应
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode==200){
                //时间戳
                String timestamp = System.currentTimeMillis()/1000+"";
                //随机字符串
                String nonce = RandomUtil.randomString(32);
                StringBuilder builder = new StringBuilder();
                // Appid
                builder.append(PayConstants.APP_ID).append("\n");
                // 时间戳
                builder.append(timestamp).append("\n");
                // 随机字符串
                builder.append(nonce).append("\n");
                JsonNode jsonNode = objectMapper.readTree(bodyAsString);
                // 预支付会话ID
                builder.append(jsonNode.get("prepay_id").textValue()).append("\n");
                //获取签名
                String sign = this.sign(builder.toString().getBytes("utf-8"), merchantPrivateKey);
                JSONObject jsonMap = new JSONObject();
                jsonMap.put("nonceStr", nonce);
                jsonMap.put("timeStamp", timestamp);
                jsonMap.put("prepayId", jsonNode.get("prepay_id").textValue());
                jsonMap.put("sign", sign);
                jsonMap.put("package", PayConstants.PACKAGE);
                jsonMap.put("appId", PayConstants.APP_ID);
                jsonMap.put("partnerId", PayConstants.MCH_ID);
//                return jsonMap.toJSONString();//响应签名数据，前端拿着响应数据调起微信SDK
                return jsonMap;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * App下单
     * @param total
     * @param description
     * @return
     * @throws Exception
     */
    public JSONObject requestShopping(String orderSn,int total,String description) throws Exception {
        PrivateKey merchantPrivateKey = PemUtil.loadPrivateKey(new ByteArrayInputStream(PayConstants.privateKey.getBytes("utf-8")));
        // 获取证书管理器实例
        certificatesManager = CertificatesManager.getInstance();
        // 向证书管理器增加需要自动更新平台证书的商户信息
        certificatesManager.putMerchant(PayConstants.MCH_ID, new WechatPay2Credentials(PayConstants.MCH_ID,
                        new PrivateKeySigner(PayConstants.MCH_SERIAL_NO, merchantPrivateKey)),
                PayConstants.API_3KEY.getBytes(StandardCharsets.UTF_8));
        // 从证书管理器中获取verifier
        verifier = certificatesManager.getVerifier(PayConstants.MCH_ID);
        httpClient = WechatPayHttpClientBuilder.create()
                .withMerchant(PayConstants.MCH_ID, PayConstants.MCH_SERIAL_NO, merchantPrivateKey)
                .withValidator(new WechatPay2Validator(certificatesManager.getVerifier(PayConstants.MCH_ID)))
                .build();

        HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/v3/pay/transactions/app");
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader("Content-type","application/json; charset=utf-8");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        //组合请求参数JSON格式
        ObjectNode rootNode = objectMapper.createObjectNode();
        rootNode.put("mchid", PayConstants.MCH_ID)
                .put("appid", PayConstants.APP_ID)
                .put("notify_url", PayConstants.NOTIFY_URL_SHOPPING)
                .put("description", description)
                .put("out_trade_no", orderSn);
        rootNode.putObject("amount")
                .put("total", total)
                .put("currency","CNY");
        try {
            objectMapper.writeValue(bos, rootNode);
            httpPost.setEntity(new StringEntity(bos.toString("UTF-8"), "UTF-8"));
            //获取预支付ID
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String bodyAsString = EntityUtils.toString(response.getEntity());
            //微信成功响应
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode==200){
                //时间戳
                String timestamp = System.currentTimeMillis()/1000+"";
                //随机字符串
                String nonce = RandomUtil.randomString(32);
                StringBuilder builder = new StringBuilder();
                // Appid
                builder.append(PayConstants.APP_ID).append("\n");
                // 时间戳
                builder.append(timestamp).append("\n");
                // 随机字符串
                builder.append(nonce).append("\n");
                JsonNode jsonNode = objectMapper.readTree(bodyAsString);
                // 预支付会话ID
                builder.append(jsonNode.get("prepay_id").textValue()).append("\n");
                //获取签名
                String sign = this.sign(builder.toString().getBytes("utf-8"), merchantPrivateKey);
                JSONObject jsonMap = new JSONObject();
                jsonMap.put("nonceStr", nonce);
                jsonMap.put("timeStamp", timestamp);
                jsonMap.put("prepayId", jsonNode.get("prepay_id").textValue());
                jsonMap.put("sign", sign);
                jsonMap.put("package", PayConstants.PACKAGE);
                jsonMap.put("appId", PayConstants.APP_ID);
                jsonMap.put("partnerId", PayConstants.MCH_ID);
//                return jsonMap.toJSONString();//响应签名数据，前端拿着响应数据调起微信SDK
                return jsonMap;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * App下单
     * @param total
     * @param description
     * @return
     * @throws Exception
     */
    public JSONObject requestReportRepair(String orderSn,int total,String description) throws Exception {
        PrivateKey merchantPrivateKey = PemUtil.loadPrivateKey(new ByteArrayInputStream(PayConstants.privateKey.getBytes("utf-8")));
        // 获取证书管理器实例
        certificatesManager = CertificatesManager.getInstance();
        // 向证书管理器增加需要自动更新平台证书的商户信息
        certificatesManager.putMerchant(PayConstants.MCH_ID, new WechatPay2Credentials(PayConstants.MCH_ID,
                        new PrivateKeySigner(PayConstants.MCH_SERIAL_NO, merchantPrivateKey)),
                PayConstants.API_3KEY.getBytes(StandardCharsets.UTF_8));
        // 从证书管理器中获取verifier
        verifier = certificatesManager.getVerifier(PayConstants.MCH_ID);
        httpClient = WechatPayHttpClientBuilder.create()
                .withMerchant(PayConstants.MCH_ID, PayConstants.MCH_SERIAL_NO, merchantPrivateKey)
                .withValidator(new WechatPay2Validator(certificatesManager.getVerifier(PayConstants.MCH_ID)))
                .build();

        HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/v3/pay/transactions/app");
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader("Content-type","application/json; charset=utf-8");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        //组合请求参数JSON格式
        ObjectNode rootNode = objectMapper.createObjectNode();
        rootNode.put("mchid", PayConstants.MCH_ID)
                .put("appid", PayConstants.APP_ID)
                .put("notify_url", PayConstants.NOTIFY_URL_REPORT_REPAIR)
                .put("description", description)
                .put("out_trade_no", orderSn);
        rootNode.putObject("amount")
                .put("total", total)
                .put("currency","CNY");
        try {
            objectMapper.writeValue(bos, rootNode);
            httpPost.setEntity(new StringEntity(bos.toString("UTF-8"), "UTF-8"));
            //获取预支付ID
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String bodyAsString = EntityUtils.toString(response.getEntity());
            //微信成功响应
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode==200){
                //时间戳
                String timestamp = System.currentTimeMillis()/1000+"";
                //随机字符串
                String nonce = RandomUtil.randomString(32);
                StringBuilder builder = new StringBuilder();
                // Appid
                builder.append(PayConstants.APP_ID).append("\n");
                // 时间戳
                builder.append(timestamp).append("\n");
                // 随机字符串
                builder.append(nonce).append("\n");
                JsonNode jsonNode = objectMapper.readTree(bodyAsString);
                // 预支付会话ID
                builder.append(jsonNode.get("prepay_id").textValue()).append("\n");
                //获取签名
                String sign = this.sign(builder.toString().getBytes("utf-8"), merchantPrivateKey);
                JSONObject jsonMap = new JSONObject();
                jsonMap.put("nonceStr", nonce);
                jsonMap.put("timeStamp", timestamp);
                jsonMap.put("prepayId", jsonNode.get("prepay_id").textValue());
                jsonMap.put("sign", sign);
                jsonMap.put("package", PayConstants.PACKAGE);
                jsonMap.put("appId", PayConstants.APP_ID);
                jsonMap.put("partnerId", PayConstants.MCH_ID);
//                return jsonMap.toJSONString();//响应签名数据，前端拿着响应数据调起微信SDK
                return jsonMap;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * App下单
     * @param total
     * @param description
     * @return
     * @throws Exception
     */
    public JSONObject requestLeaseRentOrder(String orderSn,int total,String description) throws Exception {
        PrivateKey merchantPrivateKey = PemUtil.loadPrivateKey(new ByteArrayInputStream(PayConstants.privateKey.getBytes("utf-8")));
        // 获取证书管理器实例
        certificatesManager = CertificatesManager.getInstance();
        // 向证书管理器增加需要自动更新平台证书的商户信息
        certificatesManager.putMerchant(PayConstants.MCH_ID, new WechatPay2Credentials(PayConstants.MCH_ID,
                        new PrivateKeySigner(PayConstants.MCH_SERIAL_NO, merchantPrivateKey)),
                PayConstants.API_3KEY.getBytes(StandardCharsets.UTF_8));
        // 从证书管理器中获取verifier
        verifier = certificatesManager.getVerifier(PayConstants.MCH_ID);
        httpClient = WechatPayHttpClientBuilder.create()
                .withMerchant(PayConstants.MCH_ID, PayConstants.MCH_SERIAL_NO, merchantPrivateKey)
                .withValidator(new WechatPay2Validator(certificatesManager.getVerifier(PayConstants.MCH_ID)))
                .build();

        HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/v3/pay/transactions/app");
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader("Content-type","application/json; charset=utf-8");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        //组合请求参数JSON格式
        ObjectNode rootNode = objectMapper.createObjectNode();
        rootNode.put("mchid", PayConstants.MCH_ID)
                .put("appid", PayConstants.APP_ID)
                .put("notify_url", PayConstants.NOTIFY_URL_LEASE_RENT_ORDER)
                .put("description", description)
                .put("out_trade_no", orderSn);
        rootNode.putObject("amount")
                .put("total", total)
                .put("currency","CNY");
        try {
            objectMapper.writeValue(bos, rootNode);
            httpPost.setEntity(new StringEntity(bos.toString("UTF-8"), "UTF-8"));
            //获取预支付ID
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String bodyAsString = EntityUtils.toString(response.getEntity());
            //微信成功响应
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode==200){
                //时间戳
                String timestamp = System.currentTimeMillis()/1000+"";
                //随机字符串
                String nonce = RandomUtil.randomString(32);
                StringBuilder builder = new StringBuilder();
                // Appid
                builder.append(PayConstants.APP_ID).append("\n");
                // 时间戳
                builder.append(timestamp).append("\n");
                // 随机字符串
                builder.append(nonce).append("\n");
                JsonNode jsonNode = objectMapper.readTree(bodyAsString);
                // 预支付会话ID
                builder.append(jsonNode.get("prepay_id").textValue()).append("\n");
                //获取签名
                String sign = this.sign(builder.toString().getBytes("utf-8"), merchantPrivateKey);
                JSONObject jsonMap = new JSONObject();
                jsonMap.put("nonceStr", nonce);
                jsonMap.put("timeStamp", timestamp);
                jsonMap.put("prepayId", jsonNode.get("prepay_id").textValue());
                jsonMap.put("sign", sign);
                jsonMap.put("package", PayConstants.PACKAGE);
                jsonMap.put("appId", PayConstants.APP_ID);
                jsonMap.put("partnerId", PayConstants.MCH_ID);
//                return jsonMap.toJSONString();//响应签名数据，前端拿着响应数据调起微信SDK
                return jsonMap;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * App下单
     * @param total
     * @param description
     * @return
     * @throws Exception
     */
    public JSONObject requestLeaseRentBillOrder(String orderSn,int total,String description) throws Exception {
        PrivateKey merchantPrivateKey = PemUtil.loadPrivateKey(new ByteArrayInputStream(PayConstants.privateKey.getBytes("utf-8")));
        // 获取证书管理器实例
        certificatesManager = CertificatesManager.getInstance();
        // 向证书管理器增加需要自动更新平台证书的商户信息
        certificatesManager.putMerchant(PayConstants.MCH_ID, new WechatPay2Credentials(PayConstants.MCH_ID,
                        new PrivateKeySigner(PayConstants.MCH_SERIAL_NO, merchantPrivateKey)),
                PayConstants.API_3KEY.getBytes(StandardCharsets.UTF_8));
        // 从证书管理器中获取verifier
        verifier = certificatesManager.getVerifier(PayConstants.MCH_ID);
        httpClient = WechatPayHttpClientBuilder.create()
                .withMerchant(PayConstants.MCH_ID, PayConstants.MCH_SERIAL_NO, merchantPrivateKey)
                .withValidator(new WechatPay2Validator(certificatesManager.getVerifier(PayConstants.MCH_ID)))
                .build();

        HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/v3/pay/transactions/app");
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader("Content-type","application/json; charset=utf-8");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        //组合请求参数JSON格式
        ObjectNode rootNode = objectMapper.createObjectNode();
        rootNode.put("mchid", PayConstants.MCH_ID)
                .put("appid", PayConstants.APP_ID)
                .put("notify_url", PayConstants.NOTIFY_URL_LEASE_RENT_BILL_ORDER)
                .put("description", description)
                .put("out_trade_no", orderSn);
        rootNode.putObject("amount")
                .put("total", total)
                .put("currency","CNY");
        try {
            objectMapper.writeValue(bos, rootNode);
            httpPost.setEntity(new StringEntity(bos.toString("UTF-8"), "UTF-8"));
            //获取预支付ID
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String bodyAsString = EntityUtils.toString(response.getEntity());
            //微信成功响应
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode==200){
                //时间戳
                String timestamp = System.currentTimeMillis()/1000+"";
                //随机字符串
                String nonce = RandomUtil.randomString(32);
                StringBuilder builder = new StringBuilder();
                // Appid
                builder.append(PayConstants.APP_ID).append("\n");
                // 时间戳
                builder.append(timestamp).append("\n");
                // 随机字符串
                builder.append(nonce).append("\n");
                JsonNode jsonNode = objectMapper.readTree(bodyAsString);
                // 预支付会话ID
                builder.append(jsonNode.get("prepay_id").textValue()).append("\n");
                //获取签名
                String sign = this.sign(builder.toString().getBytes("utf-8"), merchantPrivateKey);
                JSONObject jsonMap = new JSONObject();
                jsonMap.put("nonceStr", nonce);
                jsonMap.put("timeStamp", timestamp);
                jsonMap.put("prepayId", jsonNode.get("prepay_id").textValue());
                jsonMap.put("sign", sign);
                jsonMap.put("package", PayConstants.PACKAGE);
                jsonMap.put("appId", PayConstants.APP_ID);
                jsonMap.put("partnerId", PayConstants.MCH_ID);
//                return jsonMap.toJSONString();//响应签名数据，前端拿着响应数据调起微信SDK
                return jsonMap;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * App下单
     * @param total
     * @param description
     * @return
     * @throws Exception
     */
    public JSONObject requestAdvancePaymentOrder(String orderSn,int total,String description) throws Exception {
        PrivateKey merchantPrivateKey = PemUtil.loadPrivateKey(new ByteArrayInputStream(PayConstants.privateKey.getBytes("utf-8")));
        // 获取证书管理器实例
        certificatesManager = CertificatesManager.getInstance();
        // 向证书管理器增加需要自动更新平台证书的商户信息
        certificatesManager.putMerchant(PayConstants.MCH_ID, new WechatPay2Credentials(PayConstants.MCH_ID,
                        new PrivateKeySigner(PayConstants.MCH_SERIAL_NO, merchantPrivateKey)),
                PayConstants.API_3KEY.getBytes(StandardCharsets.UTF_8));
        // 从证书管理器中获取verifier
        verifier = certificatesManager.getVerifier(PayConstants.MCH_ID);
        httpClient = WechatPayHttpClientBuilder.create()
                .withMerchant(PayConstants.MCH_ID, PayConstants.MCH_SERIAL_NO, merchantPrivateKey)
                .withValidator(new WechatPay2Validator(certificatesManager.getVerifier(PayConstants.MCH_ID)))
                .build();

        HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/v3/pay/transactions/app");
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader("Content-type","application/json; charset=utf-8");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        //组合请求参数JSON格式
        ObjectNode rootNode = objectMapper.createObjectNode();
        rootNode.put("mchid", PayConstants.MCH_ID)
                .put("appid", PayConstants.APP_ID)
                .put("notify_url", PayConstants.NOTIFY_URL_ADVANCE_PAYMENT_ORDER)
                .put("description", description)
                .put("out_trade_no", orderSn);
        rootNode.putObject("amount")
                .put("total", total)
                .put("currency","CNY");
        try {
            objectMapper.writeValue(bos, rootNode);
            httpPost.setEntity(new StringEntity(bos.toString("UTF-8"), "UTF-8"));
            //获取预支付ID
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String bodyAsString = EntityUtils.toString(response.getEntity());
            //微信成功响应
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode==200){
                //时间戳
                String timestamp = System.currentTimeMillis()/1000+"";
                //随机字符串
                String nonce = RandomUtil.randomString(32);
                StringBuilder builder = new StringBuilder();
                // Appid
                builder.append(PayConstants.APP_ID).append("\n");
                // 时间戳
                builder.append(timestamp).append("\n");
                // 随机字符串
                builder.append(nonce).append("\n");
                JsonNode jsonNode = objectMapper.readTree(bodyAsString);
                // 预支付会话ID
                builder.append(jsonNode.get("prepay_id").textValue()).append("\n");
                //获取签名
                String sign = this.sign(builder.toString().getBytes("utf-8"), merchantPrivateKey);
                JSONObject jsonMap = new JSONObject();
                jsonMap.put("nonceStr", nonce);
                jsonMap.put("timeStamp", timestamp);
                jsonMap.put("prepayId", jsonNode.get("prepay_id").textValue());
                jsonMap.put("sign", sign);
                jsonMap.put("package", PayConstants.PACKAGE);
                jsonMap.put("appId", PayConstants.APP_ID);
                jsonMap.put("partnerId", PayConstants.MCH_ID);
//                return jsonMap.toJSONString();//响应签名数据，前端拿着响应数据调起微信SDK
                return jsonMap;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * App下单
     * @param total
     * @param description
     * @return
     * @throws Exception
     */
    public JSONObject requestHousekeepingServiceOrder(String orderSn,int total,String description) throws Exception {
        PrivateKey merchantPrivateKey = PemUtil.loadPrivateKey(new ByteArrayInputStream(PayConstants.privateKey.getBytes("utf-8")));
        // 获取证书管理器实例
        certificatesManager = CertificatesManager.getInstance();
        // 向证书管理器增加需要自动更新平台证书的商户信息
        certificatesManager.putMerchant(PayConstants.MCH_ID, new WechatPay2Credentials(PayConstants.MCH_ID,
                        new PrivateKeySigner(PayConstants.MCH_SERIAL_NO, merchantPrivateKey)),
                PayConstants.API_3KEY.getBytes(StandardCharsets.UTF_8));
        // 从证书管理器中获取verifier
        verifier = certificatesManager.getVerifier(PayConstants.MCH_ID);
        httpClient = WechatPayHttpClientBuilder.create()
                .withMerchant(PayConstants.MCH_ID, PayConstants.MCH_SERIAL_NO, merchantPrivateKey)
                .withValidator(new WechatPay2Validator(certificatesManager.getVerifier(PayConstants.MCH_ID)))
                .build();

        HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/v3/pay/transactions/app");
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader("Content-type","application/json; charset=utf-8");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        //组合请求参数JSON格式
        ObjectNode rootNode = objectMapper.createObjectNode();
        rootNode.put("mchid", PayConstants.MCH_ID)
                .put("appid", PayConstants.APP_ID)
                .put("notify_url", PayConstants.NOTIFY_URL_HOUSEKEEPING_SERVICE_ORDER)
                .put("description", description)
                .put("out_trade_no", orderSn);
        rootNode.putObject("amount")
                .put("total", total)
                .put("currency","CNY");
        try {
            objectMapper.writeValue(bos, rootNode);
            httpPost.setEntity(new StringEntity(bos.toString("UTF-8"), "UTF-8"));
            //获取预支付ID
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String bodyAsString = EntityUtils.toString(response.getEntity());
            //微信成功响应
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode==200){
                //时间戳
                String timestamp = System.currentTimeMillis()/1000+"";
                //随机字符串
                String nonce = RandomUtil.randomString(32);
                StringBuilder builder = new StringBuilder();
                // Appid
                builder.append(PayConstants.APP_ID).append("\n");
                // 时间戳
                builder.append(timestamp).append("\n");
                // 随机字符串
                builder.append(nonce).append("\n");
                JsonNode jsonNode = objectMapper.readTree(bodyAsString);
                // 预支付会话ID
                builder.append(jsonNode.get("prepay_id").textValue()).append("\n");
                //获取签名
                String sign = this.sign(builder.toString().getBytes("utf-8"), merchantPrivateKey);
                JSONObject jsonMap = new JSONObject();
                jsonMap.put("nonceStr", nonce);
                jsonMap.put("timeStamp", timestamp);
                jsonMap.put("prepayId", jsonNode.get("prepay_id").textValue());
                jsonMap.put("sign", sign);
                jsonMap.put("package", PayConstants.PACKAGE);
                jsonMap.put("appId", PayConstants.APP_ID);
                jsonMap.put("partnerId", PayConstants.MCH_ID);
//                return jsonMap.toJSONString();//响应签名数据，前端拿着响应数据调起微信SDK
                return jsonMap;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * App下单
     * @param total
     * @param description
     * @return
     * @throws Exception
     */
    public JSONObject requestMeterReadingShareDetailsOrder(String orderSn,int total,String description) throws Exception {
        PrivateKey merchantPrivateKey = PemUtil.loadPrivateKey(new ByteArrayInputStream(PayConstants.privateKey.getBytes("utf-8")));
        // 获取证书管理器实例
        certificatesManager = CertificatesManager.getInstance();
        // 向证书管理器增加需要自动更新平台证书的商户信息
        certificatesManager.putMerchant(PayConstants.MCH_ID, new WechatPay2Credentials(PayConstants.MCH_ID,
                        new PrivateKeySigner(PayConstants.MCH_SERIAL_NO, merchantPrivateKey)),
                PayConstants.API_3KEY.getBytes(StandardCharsets.UTF_8));
        // 从证书管理器中获取verifier
        verifier = certificatesManager.getVerifier(PayConstants.MCH_ID);
        httpClient = WechatPayHttpClientBuilder.create()
                .withMerchant(PayConstants.MCH_ID, PayConstants.MCH_SERIAL_NO, merchantPrivateKey)
                .withValidator(new WechatPay2Validator(certificatesManager.getVerifier(PayConstants.MCH_ID)))
                .build();

        HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/v3/pay/transactions/app");
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader("Content-type","application/json; charset=utf-8");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        //组合请求参数JSON格式
        ObjectNode rootNode = objectMapper.createObjectNode();
        rootNode.put("mchid", PayConstants.MCH_ID)
                .put("appid", PayConstants.APP_ID)
                .put("notify_url", PayConstants.NOTIFY_URL_METER_READING_SHARE_DETAIL_ORDER)
                .put("description", description)
                .put("out_trade_no", orderSn);
        rootNode.putObject("amount")
                .put("total", total)
                .put("currency","CNY");
        try {
            objectMapper.writeValue(bos, rootNode);
            httpPost.setEntity(new StringEntity(bos.toString("UTF-8"), "UTF-8"));
            //获取预支付ID
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String bodyAsString = EntityUtils.toString(response.getEntity());
            //微信成功响应
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode==200){
                //时间戳
                String timestamp = System.currentTimeMillis()/1000+"";
                //随机字符串
                String nonce = RandomUtil.randomString(32);
                StringBuilder builder = new StringBuilder();
                // Appid
                builder.append(PayConstants.APP_ID).append("\n");
                // 时间戳
                builder.append(timestamp).append("\n");
                // 随机字符串
                builder.append(nonce).append("\n");
                JsonNode jsonNode = objectMapper.readTree(bodyAsString);
                // 预支付会话ID
                builder.append(jsonNode.get("prepay_id").textValue()).append("\n");
                //获取签名
                String sign = this.sign(builder.toString().getBytes("utf-8"), merchantPrivateKey);
                JSONObject jsonMap = new JSONObject();
                jsonMap.put("nonceStr", nonce);
                jsonMap.put("timeStamp", timestamp);
                jsonMap.put("prepayId", jsonNode.get("prepay_id").textValue());
                jsonMap.put("sign", sign);
                jsonMap.put("package", PayConstants.PACKAGE);
                jsonMap.put("appId", PayConstants.APP_ID);
                jsonMap.put("partnerId", PayConstants.MCH_ID);
//                return jsonMap.toJSONString();//响应签名数据，前端拿着响应数据调起微信SDK
                return jsonMap;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }









    /**
     * 计算签名
     * @param message
     * @param yourPrivateKey
     * @return
     */
    private String sign(byte[] message, PrivateKey yourPrivateKey)  {
        try{
            Signature sign = Signature.getInstance("SHA256withRSA");
            sign.initSign(yourPrivateKey);
            sign.update(message);
            return Base64.getEncoder().encodeToString(sign.sign());
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return "";
    }
    /**
     * 回调验证签名
     * @param serial
     * @param message
     * @param signatrue
     * @return
     */
    public static boolean signVerify(String serial,String message,String signatrue){
        CertificatesManager certificatesManager = null;

        Verifier verifier = null;
        try {
            PrivateKey merchantPrivateKey = PemUtil.loadPrivateKey(new ByteArrayInputStream(PayConstants.privateKey.getBytes("utf-8")));
            // 获取证书管理器实例
            certificatesManager = CertificatesManager.getInstance();
            // 向证书管理器增加需要自动更新平台证书的商户信息
            certificatesManager.putMerchant(PayConstants.MCH_ID, new WechatPay2Credentials(PayConstants.MCH_ID,
                            new PrivateKeySigner(PayConstants.MCH_SERIAL_NO, merchantPrivateKey)),
                    PayConstants.API_3KEY.getBytes(StandardCharsets.UTF_8));

            return verifier.verify(serial,message.getBytes("utf-8"),signatrue);
        }catch (Exception e){

        }
        return false;
    }
    /**
     * 回调通知解密
     * @param
     * @return
     */
    public static JSONObject decryptToString(String requestBody) throws GeneralSecurityException, IOException {
        //拿到请求头里的resource部分
        JSONObject resources = JSONObject.parseObject(requestBody).getJSONObject("resource");
        System.out.println("resource:"+resources);
        //用32位的v3密钥做个构造
        AesUtil aesUtil = new AesUtil(PayConstants.API_3KEY.getBytes(StandardCharsets.UTF_8));
        //取出resource下 associated_data nonce参数，再；配上v3key 用作解密ciphertext
        byte[] associatedDataByte=resources.getString("associated_data").getBytes(StandardCharsets.UTF_8);
        byte[] nonceByte = resources.getString("nonce").getBytes(StandardCharsets.UTF_8);
        String ciphertext = resources.getString("ciphertext");
        //解密
        String res = aesUtil.decryptToString(associatedDataByte,nonceByte,ciphertext);
        JSONObject jsonObject = JSONObject.parseObject(res);
        System.err.println("回调结果:"+jsonObject);
        return jsonObject;
    }

}
