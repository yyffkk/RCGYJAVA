package com.api.manage.controller;

import com.api.manage.shiro.ShiroExceptions;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("manage/test")
public class TestController extends ShiroExceptions {
    @RequiresPermissions(value = {"0201"})
    @GetMapping("/test")
    public String test(){
        return "lala";
    }
}
