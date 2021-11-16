package com.api.app.controller.jcook;

import com.api.app.service.jcook.AppJcookShoppingCartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 京库克商城（第三方对接）App端购物车
 */
@RestController
@RequestMapping("app/user/jcookShoppingCat")
public class AppJcookShoppingCartController {
    @Resource
    AppJcookShoppingCartService appJcookShoppingCartService;


    /**
     * 我的购物车
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/myShoppingCart")
    public Map<String,Object> myShoppingCart(Integer id){
        return appJcookShoppingCartService.myShoppingCart(id);
    }

}
