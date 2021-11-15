package com.api.app.controller.jcook;

import com.api.app.service.jcook.AppJcookCollectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 京库克商城（第三方对接）App端收藏夹
 */
@RestController
@RequestMapping("app/user/jcookCollection")
public class AppJcookCollectionController {
    @Resource
    AppJcookCollectionService appJcookCollectionService;

    /**
     * 我的收藏夹
     * @return map
     */
    @GetMapping("/myCollection")
    public Map<String,Object> myCollection(Integer id){
        return appJcookCollectionService.myCollection(id);
    }
}
