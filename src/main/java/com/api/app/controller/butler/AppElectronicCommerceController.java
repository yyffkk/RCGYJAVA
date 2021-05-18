package com.api.app.controller.butler;

import com.api.app.service.butler.AppElectronicCommerceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * app电子商务信息
 */
@RestController
@RequestMapping("app/user/electronicCommerce")
public class AppElectronicCommerceController {
    @Resource
    AppElectronicCommerceService appElectronicCommerceService;


    /**
     * 查询所有的电子商务分类(【全部】是app页面默认显示的值)
     * @return map
     */
    @GetMapping("/categoryList")
    public Map<String,Object> categoryList(){
        return appElectronicCommerceService.categoryList();
    }



}
