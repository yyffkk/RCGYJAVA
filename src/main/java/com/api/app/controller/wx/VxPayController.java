package com.api.app.controller.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.alipay.service.AlipayService;
import com.api.app.filter.wx.*;

import com.api.app.service.wx.WxPayServiceImpl;


import com.api.model.alipay.*;
import com.api.model.app.AppDailyPaymentOrder;
import com.api.model.app.AppGoodsAppointment;
import com.api.model.app.AppRepairOrder;
import com.api.wx.WxPayServiceCopy;
import com.wechat.pay.contrib.apache.httpclient.exception.ParseException;
import com.wechat.pay.contrib.apache.httpclient.exception.ValidationException;
import okhttp3.HttpUrl;
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
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;




@RestController
@RequestMapping("app/user/vx")

public class VxPayController {
    @Resource
    WxPayServiceImpl wxPayService;
    @Resource
    AlipayService alipayService;
    @Resource
    WxPayServiceCopy wxPayServiceCopy;
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

//        URL resource = this.getClass().getClassLoader().getResource("apiclient_key.pem");

//        String b = ""
//        String s = resource.toString();
//        String substring = s.substring(5);
//        String substring = s.substring(6);
        PrivateKey privateKey=getPrivateKey("");
//        PrivateKey privateKey=getPrivateKey("E:\\智慧社区\\盛邦滨江府\\甲方资料\\apiclient_key.pem");
        JSONObject json= JSONUtil.getRequestJsonObject(request);
        String outTradeNo = json.getString("out_trade_no");
        String description = json.getString("description");
        Integer totalAmount = json.getJSONObject("amount").getInteger("total");

        String prepayId = wxPayService.placeAnOrder(outTradeNo, totalAmount, description, privateKey);
        JSONObject jsonObjectOfPay = wxPayService.wxMpUp(prepayId, privateKey);
//        String s1 = jsonObjectOfPay.toString();
        return Result.success(jsonObjectOfPay,"成功");

//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("data",1);
//        jsonObject.put("resource",resource);
//        return Result.success(jsonObject,"成功");
    }





    /**
     * app-保证金支付 房屋租赁完成订单微信支付(生成 APP 支付订单信息)
     * @param sysLeaseOrder app 房屋租赁保证金订单model
     * @param response response
     * @param request request
     * @return map
     */
    @PostMapping("/leaseVxPay")
    public Map<String,Object> leaseAlipay(@RequestBody SysLeaseOrder sysLeaseOrder, HttpServletResponse response, HttpServletRequest request) {
        Map map = new HashMap<>();
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            String name = request.getParameter("name"); //从request获取用户姓名
            String tel = request.getParameter("tel"); //从request获取用户联系电话
            Integer id = Integer.valueOf(request.getParameter("id"));//从request获取用户id
//            String name = "黄鑫"; //从request获取用户姓名
//            String tel = "15994582647"; //从request获取用户联系电话
//            Integer id = 0;//从request获取用户id
            sysLeaseOrder.setName(name); //填写付款人姓名
            sysLeaseOrder.setTel(tel); //填写付款人手机号
            return alipayService.leaseAlipay(sysLeaseOrder, id);
        }catch (Exception e) {
            //获取抛出的信息
            String message = e.getMessage();
            e.printStackTrace();
            map.put("message",message);
            return map;
        }
    }

    /**
     * app 日常缴费微信支付(生成 APP 支付订单信息)
     * @param appDailyPaymentOrder app生活缴纳 支付订单信息
     * @param response response
     * @param request request
     * @return map
     */
    @PostMapping( "/dailyPaymentVxPay")
    public Map<String,Object> dailyPaymentAlipay(@RequestBody AppDailyPaymentOrder appDailyPaymentOrder, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name"); //从request获取用户姓名
        String tel = request.getParameter("tel"); //从request获取用户联系电话
        appDailyPaymentOrder.setName(name); //填写付款人姓名
        appDailyPaymentOrder.setTel(tel); //填写付款人手机号
        return alipayService.dailyPaymentAlipay(appDailyPaymentOrder);
    }


    /**
     * app 商城购物完成订单微信支付(生成 APP 支付订单信息)
     * @param appGoodsAppointment app 商品预约信息
     * @param response response
     * @param request request
     * @return map
     */
    @PostMapping( "/shoppingVxPay")
    public Map<String,Object> shoppingAlipay(@RequestBody AppGoodsAppointment appGoodsAppointment, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name"); //从request获取用户姓名
        String tel = request.getParameter("tel"); //从request获取用户联系电话
        Integer id = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        Integer type = Integer.valueOf(request.getParameter("type"));//从request获取用户type
        appGoodsAppointment.setUserName(name); //填写付款人姓名
        appGoodsAppointment.setUserTel(tel); //填写付款人手机号
        return alipayService.shoppingAlipay(appGoodsAppointment,type,id);
    }


    /**
     * app 报事报修完成订单微信支付(生成 APP 支付订单信息)
     * @param appRepairOrder app 报事报修订单
     * @param response response
     * @param request request
     * @return map
     */
    @PostMapping( "/reportRepairVxPay")
    public Map<String,Object> reportRepairAlipay(@RequestBody AppRepairOrder appRepairOrder, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name"); //从request获取用户姓名
        String tel = request.getParameter("tel"); //从request获取用户联系电话
        appRepairOrder.setName(name); //填写付款人姓名
        appRepairOrder.setTel(tel); //填写付款人手机号
        return alipayService.reportRepairAlipay(appRepairOrder);
    }

    /**
     * app 房屋租赁-剩余需结清租金支付 完成订单微信支付(生成 APP 支付订单信息)
     * @param sysLeaseRentOrder app 房屋租赁剩余需结清租金订单model
     * @param response response
     * @param request request
     * @return map
     */
    @PostMapping("/leaseRentOrderVxPay")
    public Map<String,Object> leaseRentOrderAlipay(@RequestBody SysLeaseRentOrder sysLeaseRentOrder, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name"); //从request获取用户姓名
        String tel = request.getParameter("tel"); //从request获取用户联系电话
        Integer id = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        sysLeaseRentOrder.setName(name); //填写付款人姓名
        sysLeaseRentOrder.setTel(tel); //填写付款人手机号
        return alipayService.leaseRentOrderAlipay(sysLeaseRentOrder,id);
    }


    /**
     * app 房屋租赁-租金账单支付 完成订单微信支付(生成 APP 支付订单信息)
     * @param sysLeaseRentBillOrder app 房屋租赁租金账单订单model
     * @param response response
     * @param request request
     * @return map
     */
    @PostMapping("/leaseRentBillOrderVxPay")
    public Map<String,Object> leaseRentBillOrderAlipay(@RequestBody SysLeaseRentBillOrder sysLeaseRentBillOrder, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name"); //从request获取用户姓名
        String tel = request.getParameter("tel"); //从request获取用户联系电话
        Integer id = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        sysLeaseRentBillOrder.setName(name); //填写付款人姓名
        sysLeaseRentBillOrder.setTel(tel); //填写付款人手机号
        return alipayService.leaseRentBillOrderAlipay(sysLeaseRentBillOrder,id);
    }



    /**
     * app 生活缴费-预充值支付 完成订单微信支付(生成 APP 支付订单信息)
     * @param sysAdvancePaymentOrder app 生活缴费-预充值支付订单model
     * @param response response
     * @param request request
     * @return map
     */
    @PostMapping(value = "/advancePaymentOrderVxPay")
    public Map<String,Object> advancePaymentOrderAlipay(@RequestBody SysAdvancePaymentOrder sysAdvancePaymentOrder, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name"); //从request获取用户姓名
        String tel = request.getParameter("tel"); //从request获取用户联系电话
        Integer id = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        sysAdvancePaymentOrder.setName(name); //填写付款人姓名
        sysAdvancePaymentOrder.setTel(tel); //填写付款人手机号
        return alipayService.advancePaymentOrderAlipay(sysAdvancePaymentOrder,id);
    }

    /**
     * app 家政服务-服务费用支付 完成订单微信支付(生成 APP 支付订单信息)
     * @param sysHousekeepingServiceOrder app 家政服务-服务费用支付订单model
     * @param response response
     * @param request request
     * @return map
     */
    @PostMapping(value = "/housekeepingServiceOrderVxPay")
    public Map<String,Object> housekeepingServiceOrderAlipay(@RequestBody SysHousekeepingServiceOrder sysHousekeepingServiceOrder, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name"); //从request获取用户姓名
        String tel = request.getParameter("tel"); //从request获取用户联系电话
        Integer id = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        sysHousekeepingServiceOrder.setName(name); //填写付款人姓名
        sysHousekeepingServiceOrder.setTel(tel); //填写付款人手机号
        return alipayService.housekeepingServiceOrderAlipay(sysHousekeepingServiceOrder,id);
    }


    /**
     * app 抄表记录管理-抄表分摊详情费用支付 完成订单微信支付(生成 APP 支付订单信息)
     * @param shareDetailsOrder app 抄表记录管理-抄表分摊详情费用支付订单model
     * @param response response
     * @param request request
     * @return map
     */
    @PostMapping(value = "/meterReadingShareDetailsOrderVxPay")
    public Map<String,Object> meterReadingShareDetailsOrderAlipay(@RequestBody SysMeterReadingShareDetailsOrder shareDetailsOrder, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name"); //从request获取用户姓名
        String tel = request.getParameter("tel"); //从request获取用户联系电话
        Integer id = Integer.valueOf(request.getParameter("id"));//从request获取用户id
        shareDetailsOrder.setName(name); //填写付款人姓名
        shareDetailsOrder.setTel(tel); //填写付款人手机号
        return alipayService.meterReadingShareDetailsOrderAlipay(shareDetailsOrder,id);
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

//        String content = new String(Files.readAllBytes(Paths.get(filename)), "utf-8");
        try {
            String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDGEmFAMMKqT4EBpAxU/XYqx7YN7zkZDWWAKa63uhD/wn45OoYzyhQI06jRfUKo7vsuwX7uzUKVp9K2+T0D4B0pR/cVQi1wzJOpufHCgFW2HLDWE4HwM1fXwGlsN8t/kemtddmHIrQ1uO4Q+PgeAjpFFC5aMwr1KiLaW8SRZF0L62dk25bndhsWKjvPOFMiqHmNtx1h9iUHDUdjremFb3by65QQeF2GPGS4O+/q4PcIgvvolgTSTdnfpiWmkNDJ4ibUfB9h8Plg8vfJKfn+9wWK8qjwpfS1lxNPQFa0jAY0EKewAiywz6retWw12H9RY29SU2oJtPuRiWK0LGMoMtf9AgMBAAECggEBALCGoPW8f0GaKbd0pSj52960rqQsmA6jydo3S+eihJPsmuIWLpTpfIGBYeuSX15/3o0FFkNt2/HU6A76gk555oNsB+GCYU0uhku11KksBzeOymuAZ0XT/G3kphA0icDgIgreBUhSvZlDf6jQuxDDm3sFSWpKI3HsY7OIJeAOOn7rcsUscdOpzHL6Sf0ytVPFZ5GSFQMNFA3o80PA/5CK/vz7fjiDwH+/0pJOmz0l2rsv2dLX2tJQvhSwnxpt7BVMdnQpihkVivHGsU1D5Y9l8BTCXVgK1y6DXF4mmXw0Lg/yzbXJHOwaakGnLsiKXIXiA7mnZ5yMAC9G80Ea3COVywECgYEA94jBCDJeFjMaotp2c56oXBDJcO5LwEoPy60anr2SRgS//c/4DchuMHzIMdcpflddjJA/EDdZfG3tZc3XoSlY+Lf+5viE7L9slODKztO2r92MBS70d6a/Ps09vdgPoyr/3QnP7/0ZohiDl/PM54dqm3uLQ8o58ZpuVoJW3/aeY+UCgYEAzNiQ1OeI2oJTY45rvuDEWh4b5M/NxtVWZk3AVZvQFFGHpm8OoWyqrKGxUzi0PwH0635pVs8mFWZL7h4Fs5e7g9/UOJNcHN5RdjXf8fczkuMAqk2Pwrk90VhyWMCn0iJXvFcz8YCpRz1npmVZcnro5srYsaTVe4WtrEKaTU6+kjkCgYAbYiOIlpnV9t1Rer1z2O9jD/BY7+OtaAQLUiEJwor19/yNRX55d9zIvGUhLl5Gvb95l1OCpbzeiQKkKntaNsrC6Qfn4UJDNoH6jkuhScaB+g5NXH5q5iVt+yKDZ+2C7XTUrQs1z1gQmImmO7BFRLPEc4xaeXqjgaQHKfAWYp/vCQKBgBS2tXaB7ynBUfNYPHbxvYkrUEDD7pfzjKgNpqxBdDoJwIDI7B7QoTWRqB+1NSzF4uFJSBeaHMy/KmBqssLlTfXY1VnfNMpKhMxCSGHsUE/DGpcd/rJ/DswzeGSXHqE2Dc8itkLucq+cevWte+0Clrh3vI/CDkBOVTB9D6NPmh+pAoGBANUIm2zsu8Zd7H/3+68u5yujzW/66X3HYLFo/WQhCwTT8wTVL1jSQL6MsixNpvUhA+4Te/LQqMtAHuf7MRH73N4qrMSvtQSk70BeIdWmelNuShwAa2umJBsmMacZvUfyn3vBfCYB3t/HzQHECWDmzVe6vv9JkHMs4BmbniiLkdrL";

            KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePrivate(
                    new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("当前Java环境不支持RSA", e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("无效的密钥格式");
        }
    }







    /**
     * 微信支付
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/pays")
    public Result<Map<String, Object>> pays(HttpServletRequest request) throws Exception {

        JSONObject json= JSONUtil.getRequestJsonObject(request);
        String outTradeNo = json.getString("out_trade_no");
        String description = json.getString("description");
        Integer totalAmount = json.getJSONObject("amount").getInteger("total");

        Map<String, Object> stringObjectMap = wxPayServiceCopy.appPays(outTradeNo, totalAmount);
        return Result.success(stringObjectMap,"成功");

//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("data",1);
//        jsonObject.put("resource",resource);
//        return Result.success(jsonObject,"成功");
    }












//    String sign(byte[] message,PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
//        Signature sign = Signature.getInstance("SHA256withRSA");
//        sign.initSign(privateKey);
//        sign.update(message);
//
//        return Base64.getEncoder().encodeToString(sign.sign());
//    }


//
//    String token(String mchId, String nonceStr, long timestamp, String serialNo, String signature) {
//        return "mchid=\"" + mchId + "\","
//                + "nonce_str=\"" + nonceStr + "\","
//                + "timestamp=\"" + timestamp + "\","
//                + "serial_no=\"" + serialNo + "\","
//                + "signature=\"" + signature + "\"";
//    }











    String buildMessageData(String method, String url, long timestamp, String nonceStr, String body) {

        return method + "\n"
                + url + "\n"
                + timestamp + "\n"
                + nonceStr + "\n"
                + body + "\n";
    }





















}
