package com.api.app.controller.butler;

import com.api.app.service.butler.AppGeographyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * app 地理信息
 */
@RestController
@RequestMapping("app/user/geography")
public class AppGeographyController {
    @Resource
    AppGeographyService appGeographyService;

    /**
     * 查询地理信息
     * @return map
     */
    @GetMapping("/findGeographyInfo")
    public Map<String,Object> findGeographyInfo(){
        return appGeographyService.findGeographyInfo();
    }

}
