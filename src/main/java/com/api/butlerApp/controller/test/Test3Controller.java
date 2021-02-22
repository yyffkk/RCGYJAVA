package com.api.butlerApp.controller.test;

import com.api.util.JiguangUtil;
import com.api.util.UploadUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test3")
public class Test3Controller {

    @GetMapping("/test2")
    public void test(){
        System.out.println("test");
//        UploadUtil uploadUtil = new UploadUtil();
//        uploadUtil.shear("/img/headSculpture/1.jpg");
        JiguangUtil.push("1","消息测试");
    }
}
