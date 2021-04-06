package com.api.manage.controller;

import com.api.manage.shiro.ShiroExceptions;
import com.api.util.Base64Util;
import com.api.util.EmojiUtils;
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
        String s = "哈哈😄";
//        String s1 = Base64Util.encodeData(s);
//        String s2 = Base64Util.decodeData(s1);
//        System.out.println(s1);
//        System.out.println(s2);
        String content = EmojiUtils.filterEmoji(s, "*");
        System.out.println(content);
        IdWorker idWorker = new IdWorker(1, 1, 1);

        return idWorker.nextId();
    }
}
