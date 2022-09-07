package com.api.app.controller.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.app.filter.wx.*;

import com.api.app.service.wx.WxPayServiceImpl;



import com.wechat.pay.contrib.apache.httpclient.exception.ParseException;
import com.wechat.pay.contrib.apache.httpclient.exception.ValidationException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.example.api.utils.result.Result;
import org.jdom2.JDOMException;

import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;




@RestController
@RequestMapping("/vx")

public class VxPayController {
    @Resource
    WxPayServiceImpl wxPayService;

    /**
     * 微信支付
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/pay")
    public Result<JSONObject> pay(HttpServletRequest request) throws Exception {
        String url="v3/pay/transactions/app";
        String mchId= ConfigManager.getInstance().getConfigItem("MCH_ID");
        String serialNo="1629188361_20220727_cert";
        PrivateKey privateKey=getPrivateKey("E:\\智慧社区\\盛邦滨江府\\甲方资料\\apiclient_key.pem");
        JSONObject json= JSONUtil.getRequestJsonObject(request);
        String outTradeNo = json.getString("out_trade_no");
        String description = json.getString("description");
        Integer totalAmount = json.getJSONObject("amount").getInteger("total");
        String prepayId = wxPayService.placeAnOrder(outTradeNo, totalAmount, description, privateKey);
        JSONObject jsonObjectOfPay = wxPayService.wxMpUp(prepayId, privateKey);
        return Result.success(jsonObjectOfPay,"成功");
    }


    @GetMapping("/find")
    public String find(String outTradeNo) throws IOException {
        String postURL = "https://api.mch.weixin.qq.com/v3/pay/transactions/out-trade-no/"+outTradeNo;
        PostMethod postMethod = null;
        postMethod = new PostMethod(postURL);
        postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        //参数设置，需要注意的就是里边不能传NULL，要传空字符串
        NameValuePair[] data = {
                new NameValuePair("mchid",ConfigManager.getInstance().getConfigItem("MCH_ID")),
                new NameValuePair("out_trade_no", outTradeNo)
        };


        postMethod.setRequestBody(data);
        org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();
        int response = httpClient.executeMethod(postMethod); // 执行POST方法
        String result = postMethod.getResponseBodyAsString();
        return result;
    }





    public static PrivateKey getPrivateKey(String filename) throws IOException {

        String content = new String(Files.readAllBytes(Paths.get(filename)), "utf-8");
        try {
            String privateKey = content.replace("-----BEGIN PRIVATE KEY-----", "")
                    .replace("-----END PRIVATE KEY-----", "")
                    .replaceAll("\\s+", "");

            KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePrivate(
                    new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("当前Java环境不支持RSA", e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("无效的密钥格式");
        }
    }









    @PostMapping("/notify")

    public Result<JSONObject> notify(HttpServletRequest request) throws IOException, JDOMException, GeneralSecurityException, ValidationException, ParseException {
        String serialNo = request.getHeader("Wechatpay-Serial");// 商户序列号

        String nonceStr = request.getHeader("Wechatpay-Nonce");// 随机字符串

        String timestamp = request.getHeader("Wechatpay-Timestamp"); // 时间戳

        long anotherTimestamp = Long.parseLong(timestamp);

        String wechatpaySignature = request.getHeader("Wechatpay-Signature"); // 签名

        String xjlMchId= ConfigManager.getInstance().getConfigItem("MCH_ID");

        String xjlSerialNo="2085562750E921915C3FCAA59B10B0F2BCA2E6F6";

//        String v3keyPath=null;
//
//        String xjlV3keyPath=null;

        String requestBody = getRequestBody(request);

        String body="";

        PrivateKey privateKey=getPrivateKey("E:\\智慧社区\\盛邦滨江府\\甲方资料\\apiclient_key.pem");

        String v3Key="kaidalai135246xiaomifengzhihuish";
        //拿到签名
        String sign = sign("GET", "/v3/certificates",anotherTimestamp,nonceStr ,body, privateKey);
        String token = token(xjlMchId, nonceStr, anotherTimestamp, xjlSerialNo, sign);
        HttpGet httpPost = new HttpGet("https://api.mch.weixin.qq.com/v3/certificates");
        //设置头
        httpPost.setHeader("Authorization", "WECHATPAY2-SHA256-RSA2048" + " " + token);
        httpPost.setHeader("Accept", "*/*");
        httpPost.setHeader("User-Agent", "*/*");
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //完成签名并执行请求
        CloseableHttpResponse resp = httpClient.execute(httpPost);
        JSONObject map = JSON.parseObject(EntityUtils.toString(resp.getEntity()));
        JSONArray data = map.getJSONArray("data");
        String serial_no = data.getJSONObject(0).getString("serial_no");
        JSONObject encrypt_certificate = data.getJSONObject(0).getJSONObject("encrypt_certificate");
        String associatedData = encrypt_certificate.getString("associated_data");
        String nonce = encrypt_certificate.getString("nonce");
        String ciphertext = encrypt_certificate.getString("ciphertext");
        //拿到请求头里的resource部分
//        JSONObject resources = JSONObject.parseObject(requestBody).getJSONObject("resource");
//        String associatedData = resources.getString("associated_data");
//        String nonce = resources.getString("nonce");
//        String ciphertext = resources.getString("ciphertext");
        String publicKey = decryptResponseBody(v3Key, associatedData, nonce, ciphertext);
        final CertificateFactory cf = CertificateFactory.getInstance("X509");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(publicKey.getBytes(StandardCharsets.UTF_8));
        Map  CERTIFICATE_MAP=new HashMap();
        Certificate certificate = null;
        try {
            certificate =  cf.generateCertificate(inputStream);

        } catch (CertificateException e) {
            e.printStackTrace();
        }
        CERTIFICATE_MAP.put(serialNo, certificate);

        boolean flag =responseSignVerify(wechatpaySignature, timestamp, nonceStr, requestBody, serialNo,CERTIFICATE_MAP);
        //验签成功
        if (flag) {


            JSONObject resources = JSONObject.parseObject(requestBody).getJSONObject("resource");
            //用32位的v3密钥做个构造
            AesUtil aesUtil = new AesUtil(v3Key.getBytes(StandardCharsets.UTF_8));
            //取出resource下 associated_data nonce参数，再；配上v3key 用作解密ciphertext
            byte[] associatedDataByte =resources.getString("associated_data").getBytes(StandardCharsets.UTF_8);
            byte[] nonceByte =resources.getString("nonce").getBytes(StandardCharsets.UTF_8);
            String ciphertextSecond = resources.getString("ciphertext");
            //解密
            String res = aesUtil.decryptToString(associatedDataByte, nonceByte, ciphertextSecond);
            JSONObject jsonObject = JSONObject.parseObject(res);
//            System.err.println("回调结果:" + jsonObject);
            return Result.success(jsonObject,"成功");
        }
       return null;




    }









    String sign(String method, String canonicalUrl, long timestamp, String nonceStr, String body, PrivateKey privateKey) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException {
        String signatureStr = Stream.of(method, canonicalUrl, String.valueOf(timestamp), nonceStr, body)
                .collect(Collectors.joining("\n", "", "\n"));
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(privateKey);
        sign.update(signatureStr.getBytes(StandardCharsets.UTF_8));
        return Base64Utils.encodeToString(sign.sign());
    }

    String token(String mchId, String nonceStr, long timestamp, String serialNo, String signature) {
        final String TOKEN_PATTERN = "mchid=\"%s\",nonce_str=\"%s\",timestamp=\"%d\",serial_no=\"%s\",signature=\"%s\"";
        // 生成token
        return String.format(TOKEN_PATTERN, mchId, nonceStr, timestamp, serialNo, signature);
    }



    /**
     * 获取微信请求头
     *
     * @param request
     * @return
     * @throws IOException
     */
    public  String getRequestBody(HttpServletRequest request) throws IOException {
        ServletInputStream stream = null;
        BufferedReader reader = null;
        StringBuffer sb = new StringBuffer();
        try {
            stream = request.getInputStream();
            // 获取响应
            reader = new BufferedReader(new InputStreamReader(stream));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            throw new IOException("读取返回支付接口数据流出现异常！");
        } finally {
            reader.close();
        }
        return sb.toString();
    }

    public  String decryptResponseBody(String apiV3Key, String associatedData, String nonce, String ciphertext) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            SecretKeySpec key = new SecretKeySpec(apiV3Key.getBytes(StandardCharsets.UTF_8), "AES");
            GCMParameterSpec spec = new GCMParameterSpec(128, nonce.getBytes(StandardCharsets.UTF_8));
            cipher.init(Cipher.DECRYPT_MODE, key, spec);
            cipher.updateAAD(associatedData.getBytes(StandardCharsets.UTF_8));
            byte[] bytes;
            try {
                bytes = cipher.doFinal(Base64Utils.decodeFromString(ciphertext));

            } catch (GeneralSecurityException e) {
                throw new IllegalArgumentException(e);
            }
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new IllegalStateException(e);
        } catch (InvalidKeyException | InvalidAlgorithmParameterException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static boolean  responseSignVerify( String wechatpaySignature, String wechatpayTimestamp, String wechatpayNonce, String body,String serialNo,Map CERTIFICATE_MAP) {
        FileInputStream fileInputStream = null;
        try {
            //获取签名
            String signatureStr = buildMessage(wechatpayTimestamp, wechatpayNonce, body);
            Signature signer = Signature.getInstance("SHA256withRSA");
//            if (CERTIFICATE_MAP.isEmpty() || !CERTIFICATE_MAP.containsKey(serialNo)) {
//                //获取证书
//                certificates(xjlMchId,xjlSerialNo,v3keyPath,v3Key);
//            }
            signer.initVerify((Certificate) CERTIFICATE_MAP.get(serialNo));
            signer.update(signatureStr.getBytes(StandardCharsets.UTF_8));
            boolean verify = signer.verify(Base64.getDecoder().decode(wechatpaySignature));
            return signer.verify(java.util.Base64.getDecoder().decode(wechatpaySignature));
        } catch (Exception e ) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    /**
     * 回调验签-构建签名数据
     * @param
     * @return
     */
    public static String buildMessage(String wechatpayTimestamp, String wechatpayNonce, String body) {
        return Stream.of(wechatpayTimestamp, wechatpayNonce, body)
                .collect(Collectors.joining("\n", "", "\n"));
    }






}
