package com.api.manage.controller;

import com.api.manage.shiro.ShiroExceptions;
import com.api.util.IdWorker;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("manage/test")
public class TestController extends ShiroExceptions {
//    @RequiresPermissions(value = {"0201"})
    @GetMapping("/test")
    public Long test(){
        IdWorker idWorker = new IdWorker(1, 1, 1);

        return idWorker.nextId();
    }
}
