package com.api.manage.controller;

import com.api.util.GetIpUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("manage/test2")
public class TestController2 {
    @GetMapping("/test2")
    public Boolean test2(HttpServletRequest request) {
        String ip2 = GetIpUtil.getIp2(request);
        System.out.println(ip2);
        return false;
    }
}
