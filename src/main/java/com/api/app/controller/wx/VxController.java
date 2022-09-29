package com.api.app.controller.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.manage.dao.basicArchives.AuditManagementDao;
import com.api.manage.dao.basicArchives.UserResidentDao;
import com.api.manage.dao.butlerService.LeaseDao;
import com.api.model.alipay.SysLeaseOrder;
import com.api.model.basicArchives.CpmBuildingUnitEstate;
import com.api.model.basicArchives.CpmResidentEstate;
import com.api.model.basicArchives.UserResident;
import com.api.model.butlerService.SysLease;
import com.api.vo.butlerService.VoFBILease;
import com.api.wx3.AesUtil;
import com.api.app.filter.wx.ConfigManager;
import com.api.wx.WxPayServiceCopy;
import com.api.wx2.WXPayNewService;
import com.api.wx3.PaidService;
import com.api.wx3.PayConstants;
import com.api.wx3.V3PayService;
import com.wechat.pay.contrib.apache.httpclient.exception.ParseException;
import com.wechat.pay.contrib.apache.httpclient.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.example.api.utils.result.Result;
import org.jdom2.JDOMException;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.api.wx3.PaidService.decryptToString;

@RestController
@RequestMapping("/app/vx")
@Slf4j
public class VxController {
    @Resource
    WxPayServiceCopy wxPayServiceCopy;
    @Resource
    private WXPayNewService wxPayNewService;
    @Resource
    V3PayService v3PayService;
    @Resource
    PaidService paidService;
    @Resource
    LeaseDao leaseDao;
    @Resource
    UserResidentDao userResidentDao;
    @Resource
    AuditManagementDao auditManagementDao;
    @PostMapping("/notify2")
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

//        PrivateKey privateKey=getPrivateKey("E:\\智慧社区\\盛邦滨江府\\甲方资料\\apiclient_key.pem");

        URL resource = this.getClass().getClassLoader().getResource("apiclient_key.pem");
        String s = resource.toString();
//        String substring = s.substring(5);
        String substring = s.substring(6);
        PrivateKey privateKey=getPrivateKey(substring);

        String v3Key="kaidalai135246xiaomifengzhihuish";
        //拿到签名
        String sign = sign("GET", "/v3/certificates", anotherTimestamp, nonceStr, body, privateKey);
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
        Map CERTIFICATE_MAP=new HashMap();
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



    @RequestMapping(value = "/notify", method = {RequestMethod.GET, RequestMethod.POST})
    public void appNotify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        wxPayServiceCopy.notify(request, response);
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








    /**
     * 微信支付的回调接收接口
     * @param request
     *
     */
    @RequestMapping(value = "/payNotify2", method = {org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
    public JSONObject callBack(HttpServletRequest request) throws IOException, GeneralSecurityException {
        String requestBody = v3PayService.getRequestBody(request);
        Map<String, X509Certificate>certificateMap = null;
        if(v3PayService.verifiedSign(request,requestBody,certificateMap)==true){
            JSONObject jsonObject = decryptToString(requestBody);
            return jsonObject;
        }
        return  null;
    }


    /**
     * 生成v3证书
     *
     */
    @RequestMapping("/createPlatformCert")
    @ResponseBody
    public String createPlatformCert() throws IOException {
        return wxPayNewService.createPlatformCert();
    }




    /**
     * 微信支付的回调接收接口
     * @param request
     *
     */
    @RequestMapping(value = "/payNotify", method = {org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
    public String callBack2(HttpServletRequest request) throws IOException, GeneralSecurityException {
        String requestBody = v3PayService.getRequestBody(request);
        Map<String, X509Certificate>certificateMap = null;
        if(v3PayService.verifiedSign(request,requestBody,certificateMap)==true){
            JSONObject jsonObject = decryptToString(requestBody);

            //验签通过
            //获取需要保存的数据
            String appId=jsonObject.getString("appid");//支付宝分配给开发者的应用Id
            String outTradeNo = jsonObject.getString("out_trade_no");//获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
            String buyerPayAmount=jsonObject.getJSONObject("amount").getString("payer_total");//付款金额:用户在交易中支付的金额
            String tradeStatus = jsonObject.getString("trade_state");// 获取交易状态
            // 验证通知后执行自己项目需要的业务操作
            // 一般需要判断支付状态是否为TRADE_SUCCESS
            // 更严谨一些还可以判断 1.appid 2.sellerId 3.out_trade_no 4.total_amount 等是否正确，正确之后再进行相关业务操作。
            //根据out_trade_no【商户系统的唯一订单号】查询信息 total_amount【订单金额】
            SysLeaseOrder sysLeaseOrder = leaseDao.findSysLeaseOrderByCode(outTradeNo);
            //判断1.out_trade_no,2.total_amount,3.APPID 是否正确一致
            BigDecimal payPrice = sysLeaseOrder.getPayPrice();
            BigDecimal price = payPrice.multiply(new BigDecimal(100));
            int prices=price.intValue();
            String priceData = String.valueOf(prices);
            if(sysLeaseOrder!=null && buyerPayAmount.equals(priceData) && PayConstants.APP_ID.equals(appId)){
                switch (tradeStatus) // 判断交易结果
                {
                    case "SUCCESS": // 交易支付成功
                        sysLeaseOrder.setStatus(2);
                        break;
                    case "CLOSED": // 未付款交易超时关闭或支付完成后全额退款
                        sysLeaseOrder.setStatus(1);
                        break;
                    case "NOTPAY": // 交易创建并等待买家付款
                        sysLeaseOrder.setStatus(0);
                        break;
                    default:
                        break;
                }
                //更新表的状态
                int returnResult = leaseDao.updateLeaseOrderStatusByCode(sysLeaseOrder);
                if(tradeStatus.equals("SUCCESS")) {    //只处理支付成功的订单: 修改交易表状态,支付成功
                    if(returnResult>0){
                        log.info("===========异步调用成功");
                        //根据租赁主键id更新租赁信息状态
                        SysLease sysLease = new SysLease();
                        sysLease.setId(sysLeaseOrder.getSysLeaseId());
                        sysLease.setStatus(6);//6.已完成
                        //修改状态
                        int update = leaseDao.updateStatusById(sysLease);
                        if (update <= 0){
                            log.info("===========更新租赁信息的状态失败");
                            return "fail";
                        }
                        //修改保证金缴纳时间
                        sysLease.setMarginPayDate(new Date());
                        int update4 = leaseDao.updateMarginPayDateById(sysLease);
                        if (update4 <= 0){
                            log.info("===========更新租赁信息的保证金缴纳时间失败");
                            return "fail";
                        }

                        try {
                            //根据租赁管理主键id查询租赁信息
                            VoFBILease byId = leaseDao.findById(sysLeaseOrder.getSysLeaseId());

                            //更新上一份租赁信息的状态
                            if (byId.getLeaseParentId() > 0){//正整数：续签
                                SysLease sysLease2 = new SysLease();
                                sysLease2.setId(byId.getLeaseParentId());
                                sysLease2.setStatus(21);//21.已续签
                                //修改状态
                                int update2 = leaseDao.updateStatusById(sysLease2);
                                if (update2 <= 0){
                                    log.info("===========更新上一份租赁信息的状态失败");
                                    return "fail";
                                }
                            }else if (byId.getLeaseParentId() < 0){//负正数：变更
                                SysLease sysLease3 = new SysLease();
                                sysLease3.setId(Math.abs(byId.getLeaseParentId()));
                                sysLease3.setStatus(31);//31.已变更
                                //修改状态
                                int update3 = leaseDao.updateStatusById(sysLease3);
                                if (update3 <= 0){
                                    log.info("===========更新上一份租赁信息的状态失败");
                                    return "fail";
                                }
                            }//0：新合同


                            //关联房屋信息
                            //添加住户房产关联表 TODO 住户房产关联表增加一个字段，【type用户类型】
                            CpmResidentEstate cpmResidentEstate = new CpmResidentEstate();
                            cpmResidentEstate.setBuildingUnitEstateId(byId.getEstateId()); //填入房产id
                            //根据用户手机号查询用户主键id
                            UserResident userResidentByTel = userResidentDao.findByTel(byId.getTel());
                            cpmResidentEstate.setResidentId(userResidentByTel.getId()); //填入住户id
                            cpmResidentEstate.setEffectiveTimeStart(byId.getLeaseDateStart()); //填入有效时间开始（只限租客）
                            cpmResidentEstate.setEffectiveTimeEnd(byId.getLeaseDateEnd()); //填入有效时间结束（只限租客）
                            cpmResidentEstate.setSysLeaseId(byId.getId());//填入租赁主键id（只限租客）
                            int insert = auditManagementDao.insertResidentEstate(cpmResidentEstate);
                            if (insert <=0){
                                throw new RuntimeException("===========添加住户房产关联失败");
                            }

                            //更新房产的状态信息
                            CpmBuildingUnitEstate cpmBuildingUnitEstate = new CpmBuildingUnitEstate();
                            cpmBuildingUnitEstate.setId(byId.getEstateId()); //填入房产id
                            //租客，5.已租
                            cpmBuildingUnitEstate.setStatus(5);
                            int update2 = auditManagementDao.updateEstateStatus(cpmBuildingUnitEstate);
                            if (update2 <= 0){
                                throw new RuntimeException("===========房产状态更新失败");
                            }

                            //修改住户类型信息 TODO 用户表减少一个字段，【type用户类型】
                            UserResident userResident = new UserResident();
                            userResident.setId(userResidentByTel.getId());//填入用户主键id
                            userResident.setType(3); //填入住户类型,3.租户
                            int update3 = auditManagementDao.updateResidentTypeById(userResident);
                            if (update3 <=0){
                                throw new RuntimeException("===========住户信息修改失败");
                            }
                        } catch (Exception e) {
                            //获取抛出的信息
                            String message = e.getMessage();
                            e.printStackTrace();
                            //设置手动回滚
                            TransactionAspectSupport.currentTransactionStatus()
                                    .setRollbackOnly();
                            log.info(message);
                            return "fail";
                        }

                        // 成功要返回success，不然支付宝会不断发送通知。
                        return "success";
                    }else{
                        log.info("===========更新表的状态失败");
                        return "fail";
                    }
                }else{
                    log.info("===========不是支付成功的订单");
                    return "fail";
                }
            }else{
                log.info("==================微信官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）,不一致！返回fail");
                return"fail";
            }
        }else {
            // 验签失败  笔者在这里是输出log，可以根据需要做一些其他操作
            log.info("=========验签不通过！");

            // 失败要返回fail，不然支付宝会不断发送通知。
            return "fail";
        }
    }



}
