package com.api.app.controller.jcook;

import com.api.app.service.jcook.AppJcookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 京库克商城（第三方对接）App端
 */
@RestController
@RequestMapping("app/user/jcook")
public class AppJcookController {
    @Resource
    AppJcookService appJcookService;


    /**
     * 查询已上架的SKU总数
     * @return map
     */
    @GetMapping("/skuTotal")
    public Map<String,Object> skuTotal(){
        return appJcookService.skuTotal();
    }

    /**
     * 查询入驻品牌数
     * @return map
     */
    @GetMapping("/settledBrandsNum")
    public Map<String,Object> settledBrandsNum(){
        return appJcookService.settledBrandsNum();
    }

    /**
     * 查询今日上新产品件数
     * @return map
     */
    @GetMapping("/newProductsTodayNum")
    public Map<String,Object> newProductsTodayNum(){
        return appJcookService.newProductsTodayNum();
    }


}
