package com.api.app.controller.butler;

import com.api.app.service.butler.AppGambitService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * app社区
 */
@RestController
@RequestMapping("/gambit")
public class AppGambitController {
    @Resource
    AppGambitService appGambitService;


    public Map<String,Object> list(){
        return null;
    }
}
