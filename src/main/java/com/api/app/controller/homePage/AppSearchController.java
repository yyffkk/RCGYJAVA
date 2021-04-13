package com.api.app.controller.homePage;

import com.api.app.service.homePage.AppSearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 首页全局搜索
 */
@RestController
@RequestMapping("app/user/search")
public class AppSearchController {
    @Resource
    AppSearchService appSearchService;

    /**
     * 全局搜索
     * @param searchName 模糊查询条件
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/search")
    public Map<String,Object> search(String searchName,Integer id){
        return appSearchService.search(searchName,id);
    }
}
