package com.api.app.controller.community;

import com.api.app.service.community.AppGambitService;
import com.api.vo.app.AppGambitThemeVo;
import com.api.vo.app.AppGambitVo;
import com.api.vo.app.AppMyTidingsVo;
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
 * app社区
 */
@RestController
@RequestMapping("app/user/gambit")
public class AppGambitController {
    @Resource
    AppGambitService appGambitService;


    /**
     * 查询最新的所有主题信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param id 用户id
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size,Integer id){
        PageHelper.startPage(pageNum,size);
        List<AppGambitThemeVo> appGambitThemeVos =appGambitService.list(id);
        PageInfo<AppGambitThemeVo> pageInfo = new PageInfo<>(appGambitThemeVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询所有的话题
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/listGambit")
    public Map<String,Object> listGambit(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<AppGambitVo> appGambitVos =appGambitService.listGambit();
        PageInfo<AppGambitVo> pageInfo = new PageInfo<>(appGambitVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 我的动态
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param id 用户id
     * @return map
     */
    @GetMapping("/myTidings")
    public Map<String,Object> myTidings(int pageNum,int size,Integer id){
        PageHelper.startPage(pageNum,size);
        List<AppMyTidingsVo> appMyTidingsVos =appGambitService.myTidings(id);
        PageInfo<AppMyTidingsVo> pageInfo = new PageInfo<>(appMyTidingsVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询动态主题详情
     * @param themeId 话题主题主键id
     * @return map
     */
    @GetMapping("/GambitThemeDetail")
    public Map<String,Object> GambitThemeDetail(Integer themeId){
        return appGambitService.GambitThemeDetail(themeId);
    }

}
