package com.api.app.controller.butler;

import com.api.app.service.butler.AppArticleOutService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * app物品出门
 */
@RestController
@RequestMapping("app/articleOut")
public class AppArticleOutController {
    @Resource
    AppArticleOutService appArticleOutService;



    public Map<String,Object> submit(){
        return null;
    }
}
