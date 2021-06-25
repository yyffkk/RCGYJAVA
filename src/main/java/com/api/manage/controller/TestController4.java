package com.api.manage.controller;

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
import java.util.concurrent.TimeUnit;

/**
 * 在线印章生成测试
 */
@RestController
@Slf4j
@RequestMapping("manage/test4")
public class TestController4 {
    @Value("${res.dispatchCodeDatUrl}")
    private String DISPATCH_CODE_DAT_URL;
    @GetMapping("/test4")
    public String test4(HttpServletRequest request) throws Exception  {
        FileEveryDaySerialNumber serial = new FileEveryDaySerialNumber(3, DISPATCH_CODE_DAT_URL);
        return serial.getSerialNumber();
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
