package com.api.systemDataBigScreen.controller;

import com.api.model.systemDataBigScreen.LilinAccessControlRecordTemplate;
import com.api.systemDataBigScreen.service.LilinDataPushService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 立林数据推送
 */
@RestController
@RequestMapping("/lilinPush")
public class LilinDataPushController {
    @Resource
    LilinDataPushService lilinDataPushService;

    /**
     * 推送门禁记录报告
     * @param accessControlRecordTemplate 立林门禁记录请求模版
     * @return map
     */
    @PostMapping("/pushAccessControlRecord")
    public Map<String,Object> pushAccessControlRecord(@RequestBody LilinAccessControlRecordTemplate accessControlRecordTemplate){
        return lilinDataPushService.pushAccessControlRecord(accessControlRecordTemplate);
    }
}
