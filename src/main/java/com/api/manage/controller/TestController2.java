package com.api.manage.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@RestController
@RequestMapping("manage/test2")
public class TestController2 {
    @PostMapping("/test2")
    public Boolean test2(@RequestBody MultipartFile jpeg, String code, Date ts, Date te) {
        System.out.println(jpeg);
        System.out.println(code);
        System.out.println(ts);
        System.out.println(te);
        return false;
    }
}
