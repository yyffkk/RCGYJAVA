package com.api.app.controller.butler;

import com.api.app.service.butler.AppNewsService;
import com.api.model.app.SearchAppNews;
import com.api.vo.app.AppActivityVo;
import com.api.vo.app.AppNewsVo;
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
 * app 公共资讯
 */
@RestController
@RequestMapping("app/user/news")
public class AppNewsController {
    @Resource
    AppNewsService appNewsService;

    /**
     * 查询所有的资讯分类(【全部】是app页面默认显示的值)
     * @return map
     */
    @GetMapping("/categoryList")
    public Map<String,Object> categoryList(){
        return appNewsService.categoryList();
    }


    /**
     * 根据资讯分类主键id查询资讯信息
     * @param searchAppNews app 公共资讯 搜素条件
     * @return map
     */
    @GetMapping("/newsList")
    public Map<String,Object> newsList(SearchAppNews searchAppNews){
        PageHelper.startPage(searchAppNews.getPageNum(),searchAppNews.getSize());
        List<AppNewsVo> appNewsVoList = appNewsService.newsList(searchAppNews);
        PageInfo<AppNewsVo> pageInfo = new PageInfo<>(appNewsVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据资讯主键id 查询资讯信息详情
     * @param newsId 资讯主键id
     * @return map
     */
    @GetMapping("/findNewsByNewsId")
    public Map<String,Object> findNewsByNewsId(Integer newsId){
        return appNewsService.findNewsByNewsId(newsId);
    }


    /**
     * 查询热门资讯
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/findHotNews")
    public Map<String,Object> findHotNews(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<AppNewsVo> appNewsVoList = appNewsService.findHotNews();
        PageInfo<AppNewsVo> pageInfo = new PageInfo<>(appNewsVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 增加浏览量
     * @param newsId 资讯主键id
     * @return map
     */
    @GetMapping("/addViews")
    public Map<String,Object> addViews(Integer newsId){
        return appNewsService.addViews(newsId);
    }


    /**
     * 查询资讯轮播图
     * @return
     */
    @GetMapping("/findNewsRotation")
    public Map<String,Object> findNewsRotation(){
        return appNewsService.findNewsRotation();
    }
}
