package com.api.wx3;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.api.app.controller.wx.VxPayController.getPrivateKey;

@Service
@Slf4j
public class V3PayService {

    /**
     * 获取请求报文
     * @param request
     * @return
     * @throws IOException
     */
    public static String getRequestBody(HttpServletRequest request) throws IOException {
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

    /**
     * 验签
     * @param request request请求
     * @param body 微信返回请求体
     * @return true,false
     */
    public boolean verifiedSign(HttpServletRequest request,String body,Map<String,X509Certificate>certificateMap){
        try{
            //微信返回的证书序列号
            String serialNo = request.getHeader("Wechatpay-Serial");
            //微信返回的随机字符串
            String nonceStr = request.getHeader("Wechatpay-Nonce");
            //微信返回的时间戳
            String timestamp = request.getHeader("Wechatpay-Timestamp");
            //微信返回的签名
            String wechatSign = request.getHeader("Wechatpay-Signature");
            //组装签名字符串
            String signStr = Stream.of(timestamp, nonceStr, body)
                    .collect(Collectors.joining("\n", "", "\n"));
            //判断证书序列号是否相同
            if(certificateMap==null||certificateMap.isEmpty() || !certificateMap.containsKey(serialNo)){
                //刷新证书
                certificateMap=refreshCertificate();
            }
            X509Certificate certificate = certificateMap.get(serialNo);
            //获取失败 验证失败
            if (certificate == null){
                return false;
            }
            //SHA256withRSA签名
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(certificate);
            signature.update(signStr.getBytes());
            //返回验签结果
            return signature.verify(Base64Utils.decodeFromString(wechatSign));
        }catch (Exception ex){
            log.error("验签报错：",ex);
        }
        return false;
    }


    /**
     * 证书更新
     * @return
     */
    public static Map<String,X509Certificate> refreshCertificate(){
        try {
            String url = "https://api.mch.weixin.qq.com/v3/certificates";
            //设置参数
            CloseableHttpClient httpClient = HttpClients.createDefault();
            //创建实例方法
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("Content-Type", "application/json;charset=UTF-8");
            httpGet.addHeader("Accept", "application/json");
            httpGet.addHeader("Authorization", getToken("GET",url,""));
            HttpResponse response = httpClient.execute(httpGet);
            String result = "";
            if(response.getStatusLine().getStatusCode() == 200){
                result = EntityUtils.toString(response.getEntity(),"UTF-8");
            }
            JSONObject jsonObject = JSONObject.parseObject(result);
            List<CertificateVO> certificateList = JSON.parseArray(jsonObject.getString("data"),CertificateVO.class);
            //JSONObject jsonObject = PayRequestUtils.wechatHttpGet(StaticParameter.wechatCertificatesUrl,"", JSONObject.class);
            Date newestTime = null;
            CertificateVO newestCertificate = null;
            for (CertificateVO certificate:certificateList) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                if (newestTime == null){
                    newestCertificate = certificate;
                    newestTime = formatter.parse(certificate.getEffective_time());
                }else{
                    Date effectiveTime = formatter.parse(certificate.getEffective_time());
                    //证书启用时间大于最新时间
                    if(effectiveTime.getTime() > newestTime.getTime()){
                        //更换证书
                        newestCertificate = certificate;
                    }
                }
            }
            CertificateVO.EncryptCertificate encryptCertificate = newestCertificate.getEncrypt_certificate();
            String publicKey = decryptResponseBody(encryptCertificate.getAssociated_data(),encryptCertificate.getNonce(),encryptCertificate.getCiphertext());
            CertificateFactory cf = CertificateFactory.getInstance("X509");
            //获取证书
            ByteArrayInputStream inputStream = new ByteArrayInputStream(publicKey.getBytes("UTF-8"));
            X509Certificate certificate = (X509Certificate) cf.generateCertificate(inputStream);
            //保存平台证书及序列号
            Map<String, X509Certificate> certificateMap = new ConcurrentHashMap<>();
            // 清理HashMap
            certificateMap.clear();
            // 放入证书
            certificateMap.put(newestCertificate.getSerial_no(), certificate);
            return certificateMap;
        }catch (Exception e){
            log.error("微信平台证书更新报错：",e);
        }
        return null;
    }


    /**
     * 签名串
     * @param method 请求方式post | get
     * @param url app 统一下单API
     * @param body 请求内容
     */
    public static String getToken(String method, String url,String body){
        //时间戳
        Long timestamp = System.currentTimeMillis()/1000;
        //随机串
        String nonceStr = UUID.randomUUID().toString().replace("-","");
        //签名值
        String signature = getSign(method,url,body,timestamp,nonceStr);
        final String TOKEN_PATTERN = "WECHATPAY2-SHA256-RSA2048 mchid=\"%s\",nonce_str=\"%s\",timestamp=\"%d\",serial_no=\"%s\",signature=\"%s\"";
        // 生成token
        return String.format(TOKEN_PATTERN,
                PayConstants.MCH_ID,
                nonceStr, timestamp, PayConstants.MCH_SERIAL_NO, signature);
    }


    /**
     * 用微信V3密钥解密响应体.
     *
     * @param associatedData  response.body.data[i].encrypt_certificate.associated_data
     * @param nonce          response.body.data[i].encrypt_certificate.nonce
     * @param ciphertext     response.body.data[i].encrypt_certificate.ciphertext
     * @return the string
     * @throws GeneralSecurityException the general security exception
     */
    public static String decryptResponseBody(String associatedData, String nonce, String ciphertext) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

            SecretKeySpec key = new SecretKeySpec(PayConstants.API_3KEY.getBytes(StandardCharsets.UTF_8), "AES");
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


    /**
     * 对签名串进行SHA256 with RSA签名，并进行Base64编码得到签名值
     * @param method 请求方法  GET  POST PUT DELETE 等
     * @param canonicalUrl 请求地址
     * @param body 请求体 GET 为 "" POST 为JSON
     * @param timestamp 时间戳
     * @param nonceStr 随机串
     */
    public static String getSign(String method, String canonicalUrl, String body, long timestamp, String nonceStr){


        try{
            URL url = new URL(canonicalUrl);
            String signUrl;
            if ("GET".equals(method)&&url.getQuery()!=null) {
                signUrl = url.getPath() + "?" + url.getQuery();
            }else{
                signUrl = url.getPath();
            }
            //有序切割
            String signatureStr = Stream.of(method, signUrl, String.valueOf(timestamp), nonceStr, body)
                    .collect(Collectors.joining("\n", "", "\n"));
            Signature sign = Signature.getInstance("SHA256withRSA");
            sign.initSign(getPrivateKey(""));
            sign.update(signatureStr.getBytes("UTF-8"));
            return Base64Utils.encodeToString(sign.sign());
        }catch(Exception ex){
            log.error("签名值出错：",ex);
        }
        return null;
    }




}



