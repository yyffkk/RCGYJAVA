package com.api.wx2;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import com.ijpay.core.IJPayHttpResponse;
import com.ijpay.core.enums.RequestMethod;
import com.ijpay.core.kit.AesUtil;
import com.ijpay.core.kit.HttpKit;
import com.ijpay.core.kit.PayKit;
import com.ijpay.core.kit.WxPayKit;
import com.ijpay.core.utils.DateTimeZoneUtil;
import com.ijpay.wxpay.WxPayApi;
import com.ijpay.wxpay.enums.WxApiType;
import com.ijpay.wxpay.enums.WxDomain;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * @author 夕四
 **/
@RequiredArgsConstructor
@Slf4j
@Service
public class WXPayNewServiceImpl implements WXPayNewService {

    @Override
    public Map doUnifiedOrder(String outTradeNo,Integer totalAmount) throws Exception {
        //先写死1， 1就是1分钱，100=1元
        Integer price = totalAmount;
        //商户订单号(随机字符串),这个回调的时候会给回
        String orderSn = outTradeNo;
//        //微信用户openId
//        String openid = iWxPayParamVO.getOpenId();
        //这个是微信小程序的appid
        String appid = "wxd7bdef0d4849ddb8";
        //商户号ID
        String mchId = "1629188361";
        //设置下支付的超时时间

        Map<String, Object> data = requestWxPayParam(mchId,orderSn,  price, appid);
        log.info("统一下单参数 {}", JSONUtil.toJsonStr(data));
        //这个是证书文件，先写死，后续调整成读取证书文件的服务器存放地址
        URL resource = this.getClass().getClassLoader().getResource("apiclient_key.pem");
        String s = resource.toString();
        String substring = s.substring(5);
//        String substring = s.substring(6);
        String privateKeyPath = substring;
        //请求下单
        IJPayHttpResponse response = WxPayApi.v3(
                RequestMethod.POST,
                WxDomain.CHINA.toString(),
                WxApiType.APP_PAY.toString(),
                // 商户号
                mchId,
                // 获取证书序列号
                getSerialNumber(),
                "2085562750E921915C3FCAA59B10B0F2BCA2E6F6",
                // 私钥
                privateKeyPath,
                // 请求参数
                JSONUtil.toJsonStr(data)
        );
        log.info("统一下单响应 {}", response);
        //这个就是小程序唤醒微信支付必要的那6个参数了
        Map<String, String> map =new HashMap<>();
        if (response.getStatus() == 200) {
            //这个是证书文件，先写死，后续调整成读取证书文件的服务器存放地址
            // 根据证书序列号查询对应的证书来验证签名结果
//            String platformCertPath = "D:\\MyTools\\WXWork\\WxPayFile\\cert.pem";
            URL resource2 = this.getClass().getClassLoader().getResource("apiclient_cert.pem");
            String s2 = resource2.toString();
            String substring2 = s2.substring(5);
//            String substring2 = s2.substring(6);
            String platformCertPath =substring2;
            //平台证书
            boolean verifySignature = WxPayKit.verifySignature(response, platformCertPath);
            log.info("verifySignature: {}", verifySignature);
            if (verifySignature) {
                String body = response.getBody();
                JSONObject jsonObject = JSONUtil.parseObj(body);
                String prepayId = jsonObject.getStr("prepay_id");
                // 私钥
                map = WxPayKit.appCreateSign(appid, prepayId,mchId,privateKeyPath);
                log.info("唤起支付参数:{}", map);
            }
        }
        //todo 微信预支付的订单新入库，为了业务查询记录

        return map;
    }

    @Override
    public void callBack(HttpServletRequest request, HttpServletResponse response) {
        log.info("收到微信支付回调");
        Map<String, String> map = new HashMap<>(12);
        try {
            String timestamp = request.getHeader("Wechatpay-Timestamp");
            String nonce = request.getHeader("Wechatpay-Nonce");
            String serialNo = request.getHeader("Wechatpay-Serial");
            String signature = request.getHeader("Wechatpay-Signature");

            log.info("timestamp:{} nonce:{} serialNo:{} signature:{}", timestamp, nonce, serialNo, signature);
            String result = HttpKit.readData(request);
            log.info("支付通知密文 {}", result);
            // 根据证书序列号查询对应的证书来验证签名结果
//            String platformCertPath = "D:\\MyTools\\WXWork\\WxPayFile\\cert.pem";
            URL resource2 = this.getClass().getClassLoader().getResource("apiclient_cert.pem");
            String s2 = resource2.toString();
            String substring2 = s2.substring(5);
            String platformCertPath =substring2;
            //这个商户号对应的那个V3秘钥
            String mckKey="kaidalai135246xiaomifengzhihuish";
            //需要通过证书序列号查找对应的证书，verifyNotify 中有验证证书的序列号
            String plainText = WxPayKit.verifyNotify(serialNo, result, signature, nonce, timestamp,mckKey, platformCertPath);
            log.info("支付通知明文 {}", plainText);
            //这个就是具体的业务情况
            savePayPlainText(plainText);
            //回复微信
            if (StrUtil.isNotEmpty(plainText)) {
                response.setStatus(200);
                map.put("code", "SUCCESS");
                map.put("message", "SUCCESS");
            } else {
                response.setStatus(500);
                map.put("code", "ERROR");
                map.put("message", "签名错误");
            }
            response.setHeader("Content-type", ContentType.JSON.toString());
            response.getOutputStream().write(JSONUtil.toJsonStr(map).getBytes(StandardCharsets.UTF_8));
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String createPlatformCert() {
        //商户号ID
        String mchId = "6382395623";
        //这个商户号对应的那个V3秘钥
        String mckKey="cjajsrtasdqw21523asdf1";
        // 获取平台证书列表
        try {
            //这个是证书文件，先写死，后续调整成读取证书文件的服务器存放地址
            String privateKeyPath = "D:\\MyTools\\WXWork\\WxPayFile\\apiclient_key.pem";
            IJPayHttpResponse response = WxPayApi.v3(
                    RequestMethod.GET,
                    WxDomain.CHINA.toString(),
                    WxApiType.GET_CERTIFICATES.toString(),
                    mchId,
                    getSerialNumber(),
                    null,
                    privateKeyPath,
                    ""
            );

            String timestamp = response.getHeader("Wechatpay-Timestamp");
            String nonceStr = response.getHeader("Wechatpay-Nonce");
            String serialNumber = response.getHeader("Wechatpay-Serial");
            String signature = response.getHeader("Wechatpay-Signature");

            String body = response.getBody();
            int status = response.getStatus();

            log.info("serialNumber: {}", serialNumber);
            log.info("status: {}", status);
            log.info("body: {}", body);
            int isOk = 200;
            // 根据证书序列号查询对应的证书来验证签名结果
            String platformCertPath = "D:\\MyTools\\WXWork\\WxPayFile\\cert.pem";
            if (status == isOk) {
                JSONObject jsonObject = JSONUtil.parseObj(body);
                JSONArray dataArray = jsonObject.getJSONArray("data");
                // 默认认为只有一个平台证书
                JSONObject encryptObject = dataArray.getJSONObject(0);
                JSONObject encryptCertificate = encryptObject.getJSONObject("encrypt_certificate");
                String associatedData = encryptCertificate.getStr("associated_data");
                String cipherText = encryptCertificate.getStr("ciphertext");
                String nonce = encryptCertificate.getStr("nonce");
                String serialNo = encryptObject.getStr("serial_no");
                //生成第四个证书文件
                final String platSerialNo = savePlatformCert(associatedData,mckKey, nonce, cipherText, platformCertPath);
                log.info("平台证书序列号: {} serialNo: {}", platSerialNo, serialNo);
            }
            // 根据证书序列号查询对应的证书来验证签名结果
            boolean verifySignature = WxPayKit.verifySignature(response, platformCertPath);
            log.info("verifySignature:{}" + verifySignature);
            return body;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String savePlatformCert(String associatedData, String apiKey3, String nonce, String cipherText, String certPath) {
        try {
            AesUtil aesUtil = new AesUtil(apiKey3.getBytes(StandardCharsets.UTF_8));
            // 平台证书密文解密
            // encrypt_certificate 中的  associated_data nonce  ciphertext
            String publicKey = aesUtil.decryptToString(
                    associatedData.getBytes(StandardCharsets.UTF_8),
                    nonce.getBytes(StandardCharsets.UTF_8),
                    cipherText
            );
            log.info("获取证书key：{},保存路径platformCert:{}", publicKey, certPath);
            //将生成的证书写入指定路径，文件名为：cert.pem
            FileOutputStream fos = new FileOutputStream(certPath);
            fos.write(publicKey.getBytes());
            fos.close();

            // 获取平台证书序列号
            X509Certificate certificate = PayKit.getCertificate(new ByteArrayInputStream(publicKey.getBytes()));
            return certificate.getSerialNumber().toString(16).toUpperCase();
        } catch (Exception e) {
            log.error("写入证书错误:{}", e);
            return e.getMessage();
        }
    }

    /**
     * 保存订单的支付通知明文
     *
     * @param plainText
     */
    private void savePayPlainText(String plainText) {
        JSONObject jsonObject = JSONUtil.parseObj(plainText);
        //这个就是发起订单时的那个订单号
        String outTradeNo = jsonObject.getStr("out_trade_no");
        //todo 把微信支付回调的明文消息存进数据库，方便后续校验查看

        //todo 把微信支付后需要处理的具体业务处理了
    }

    /**
     * 直连支付组装参数
     *
     * @return
     */
    private Map<String, Object> requestWxPayParam(String mchId,String orderSn,  Integer price,String appid) {
        Map<String, Object> data = new HashMap<String, Object>();
        Map<String, String> user = new HashMap<>();
//        user.put("openid", openid);
        Map<String, Object> fee = new HashMap<>();
        fee.put("total", price);
        //APPID
        data.put("appid", appid);
        //商户ID
        data.put("mchid", mchId);
        //生成的随机字符串
        data.put("description", "商品");
        data.put("out_trade_no", orderSn);
        //支付金额，单位分,1是1分钱
        data.put("amount", fee);

        //通知地址，用户支付成功之后，微信访问的接口
        data.put("notify_url", "https://148j82s509.51mypc.cn/app/vx/notify");

        return data;
    }

    /**
     * 获取证书序列号
     *
     * @return
     */
    private String getSerialNumber() throws IOException {
        //这个是证书文件，先写死，后续调整成读取证书文件的服务器存放地址
//        String certPath = "D:\\MyTools\\WXWork\\WxPayFile\\apiclient_cert.pem";
        URL resource = this.getClass().getClassLoader().getResource("apiclient_cert.pem");
        String s = resource.toString();
        String substring = s.substring(5);
        String certPath =substring;
        log.info("path:{}", certPath);
        // 获取证书序列号
        X509Certificate certificate = PayKit.getCertificate(FileUtil.getInputStream(certPath));
        String serialNo = certificate.getSerialNumber().toString(16).toUpperCase();
        log.info("获取证书序列号：{},", serialNo);
        return serialNo;
    }

    /**
     * 获取随机字符串 Nonce Str
     *
     * @return String 随机字符串
     */
    public String generateNonceStr() {
        StringBuffer stringBuffer = new StringBuffer();
        int prefix = RandomUtil.randomInt(10000, 99999);
        int suffix = RandomUtil.randomInt(10000, 99999);
        Long time = System.currentTimeMillis();
        return stringBuffer.append(prefix).append(time).append(suffix).toString();
    }
}
