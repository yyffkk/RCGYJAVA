package com.aku.controller.butlerService;

import com.aku.model.butlerService.SearchProhibitedKeywords;
import com.aku.service.butlerService.SysProhibitedKeywordsService;
import com.aku.vo.butlerService.VoConveniencePhone;
import com.aku.vo.butlerService.VoProhibitedKeywords;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 违禁关键字表
 */
@RestController
@RequestMapping("prohibitedKeywords")
public class SysProhibitedKeywordsController {
    @Resource
    SysProhibitedKeywordsService sysProhibitedKeywordsService;

    /**
     * 显示所有的违禁关键字信息 （包含条件搜索）
     * @param searchProhibitedKeywords 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchProhibitedKeywords searchProhibitedKeywords){
        PageHelper.startPage(searchProhibitedKeywords.getPageNum(),searchProhibitedKeywords.getSize());
        List<VoProhibitedKeywords> voProhibitedKeywordsList = sysProhibitedKeywordsService.list(searchProhibitedKeywords);
        PageInfo<VoProhibitedKeywords> pageInfo = new PageInfo<>(voProhibitedKeywordsList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }




}
