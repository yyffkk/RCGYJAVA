package com.api.manage.controller.jcook;

import com.api.manage.service.jcook.JcookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 京库克（第三方对接）
 */
@RestController
@RequestMapping("manage/jcook")
public class JcookController {
    @Resource
    JcookService jcookService;

    /**
     * 初始化商品数据（用户服务器部署时同步jcook商品数据，回滚到初始状态）
     * @param page 当前页数
     * @return map
     */
    @GetMapping("/updateJcookShop")
    public Map<String,Object> updateJcookShop(Integer page){
        return jcookService.updateJcookShop(page);
    }


}
