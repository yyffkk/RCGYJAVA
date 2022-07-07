package com.api.app.controller.butler;

import com.api.app.service.butler.AppCommunityIntroductionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * app社区介绍
 */
@RestController
@RequestMapping("app/user/communityIntroduction")
public class AppCommunityIntroductionController {
    @Resource
    AppCommunityIntroductionService appCommunityIntroductionService;

    /**
     * 查询开启的社区介绍模版
     * @return map
     */
    @GetMapping("/findEnable")
    public Map<String,Object> findEnable(){
        return appCommunityIntroductionService.findEnable();
    }
}
