package com.api.manage.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.api.util.IdWorker;
import com.api.util.Seal.SealCircle;
import com.api.util.Seal.SealFont;
import com.api.util.Seal.SealUtils;
import com.api.util.createCode.FileEveryDaySerialNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * 在线印章生成测试
 */
@RestController
@Slf4j
@RequestMapping("manage/test4")
public class TestController4 {
    @Value("${alipay.aliPayAppId}")
    private String ALIPAY_APP_ID;
    @Value("${alipay.rsaPrivatKey}")
    private String RSA_PRIVAT_KEY;
    @Value("${alipay.rsaAlipayPublicKey}")
    private String RSA_ALIPAY_PUBLIC_KEY;
    @Value("${alipay.aliPayGateway}")
    private String ALIPAY_GATEWAY;
    @Value("${alipay.signType}")
    private String SIGN_TYPE;
    @Value("${alipay.alipayFormat}")
    private String ALIPAY_FORMAT;
    @Value("${alipay.alipayCharset}")
    private String ALIPAY_CHARSET;

    @GetMapping("/test4")
    public String test4(String code,BigDecimal payPrice) throws Exception  {
        String out_request_no= String.valueOf(new IdWorker(1,1,1).nextId());//随机数  不是全额退款，部分退款必须使用该参数

        AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, ALIPAY_APP_ID, RSA_PRIVAT_KEY, ALIPAY_FORMAT, ALIPAY_CHARSET, RSA_ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent("{" +
                "\"out_trade_no\":\"" + code + "\"," +
                "\"trade_no\":" + null + "," +
                "\"refund_amount\":\"" + payPrice + "\"," +

                "\"out_request_no\":\"" + out_request_no+ "\"," +
                "\"refund_reason\":\"正常退款\"" +
                " }");
        AlipayTradeRefundResponse response;
        response = alipayClient.execute(request);
        if (response.isSuccess()) {
            log.info("支付宝退款成功");
        } else {
            log.info("支付宝退款失败");
        }
        return "";
    }



//
////    public static void main(String[] args) throws Exception {
////        OfficialSeal_1();
////    }
//
//    public static void OfficialSeal_1() throws Exception {
//        SealUtils.builder()
//                .size(200)
//                .borderCircle(SealCircle.builder().line(4).width(95).height(95).build())
//                .mainFont(SealFont.builder().text("中国四大天王股份有限公司").family("隶书").size(22).space(22.0).margin(4).build())
//                .centerFont(SealFont.builder().text("★").size(60).build())
//                .titleFont(SealFont.builder().text("电子签章").size(16).space(8.0).margin(54).build())
//                .build()
//                .draw("/Users/AKU001/seal/公章2.png");
//    }
//
//    public static void OfficialSeal_2() throws Exception {
//        SealUtils.builder()
//                .size(300)
//                .borderCircle(SealCircle.builder().line(5).width(140).height(140).build())
//                .mainFont(SealFont.builder().text("中国四大天王股份有限公司").size(35).space(35.0).margin(10).build())
//                .centerFont(SealFont.builder().text("★").size(100).build())
//                .titleFont(SealFont.builder().text("电子签章").size(22).space(10.0).margin(68).build())
//                .build()
//                .draw("/Users/AKU001/seal/公章2.png");
//    }
//
//    public static void OfficialSeal_3() throws Exception {
//        SealUtils.builder()
//                .size(300)
//                .borderCircle(SealCircle.builder().line(3).width(144).height(100).build())
//                .borderInnerCircle(SealCircle.builder().line(1).width(140).height(96).build())
//                .mainFont(SealFont.builder().text("中国四大天王股份有限公司").size(25).space(12.0).margin(10).build())
//                .centerFont(SealFont.builder().text("NO.5201314").size(20).build())
//                .titleFont(SealFont.builder().text("电子合同专用章").size(20).space(9.0).margin(64).build())
//                .build()
//                .draw("/Users/AKU001/seal/公章3.png");
//    }
//
//    public static void PrivateSeal_1() throws Exception {
//        SealUtils.builder()
//                .size(300)
//                .borderSquare(16)
//                .mainFont(SealFont.builder().text("刘德").size(120).build())
//                .build()
//                .draw("/Users/AKU001/seal/私章1.png");
//    }
//
//    public static void PrivateSeal_2() throws Exception {
//        SealUtils.builder()
//                .size(300)
//                .borderSquare(16)
//                .mainFont(SealFont.builder().text("刘德华印").size(120).build())
//                .build()
//                .draw("/Users/AKU001/seal/私章2.png");
//    }

}
