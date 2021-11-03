package com.api.manage.controller.jcook;

import com.api.manage.service.jcook.JcookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 京库克
 */
@RestController
@RequestMapping("manage/jcook")
public class JcookController {
    @Resource
    JcookService jcookService;

    /**
     * 手动更新商品数据（用户服务器重启后同步jcook商品数据）
     * @return map
     */
    @GetMapping("/updateJcookShop")
    public Map<String,Object> updateJcookShop(){
        return jcookService.updateJcookShop();
    }


}
