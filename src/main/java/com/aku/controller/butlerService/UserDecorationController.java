package com.aku.controller.butlerService;

import com.aku.model.butlerService.SearchUserDecoration;
import com.aku.service.butlerService.UserDecorationService;
import com.aku.vo.butlerService.VoUserArticleOut;
import com.aku.vo.butlerService.VoUserDecoration;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userDecoration")
public class UserDecorationController {
    @Resource
    UserDecorationService userDecorationService;

    /**
     * 查询装修信息（包含条件搜索）
     * @param searchUserDecoration 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchUserDecoration searchUserDecoration){
        PageHelper.startPage(searchUserDecoration.getPageNum(),searchUserDecoration.getSize());
        List<VoUserDecoration> voUserDecorationList =userDecorationService.list(searchUserDecoration);
        PageInfo<VoUserDecoration> pageInfo = new PageInfo<>(voUserDecorationList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }
}
