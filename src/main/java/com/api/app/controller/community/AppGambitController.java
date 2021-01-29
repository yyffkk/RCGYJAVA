package com.api.app.controller.community;

import com.api.app.service.community.AppGambitService;
import com.api.model.app.AppGambitTheme;
import com.api.model.app.AppGambitThemeComment;
import com.api.vo.app.AppGambitThemeVo;
import com.api.vo.app.AppGambitVo;
import com.api.vo.app.AppMyTidingsVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    public Map<String,Object> GambitThemeDetail(Integer themeId,Integer id){
        return appGambitService.GambitThemeDetail(themeId,id);
    }


    /**
     * app用户点赞/取消点赞
     * @param themeId 主题主键id
     * @param id 用户id
     * @return map
     */
    @GetMapping("/likes")
    public Map<String,Object> likes(Integer themeId,Integer id){
        return appGambitService.likes(themeId,id);
    }


    /**
     * 假删除主题信息（只能删除自己的）
     * @param themeId 主题信息主键id
     * @param id 用户id
     * @return map
     */
    @GetMapping("/falseDelete")
    public Map<String,Object> falseDelete(Integer themeId,Integer id){
        return appGambitService.falseDelete(themeId,id);
    }


    /**
     * 评论
     * @param appGambitThemeComment 话题主题评论信息
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/comment")
    public Map<String,Object> comment(@RequestBody AppGambitThemeComment appGambitThemeComment, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //填入评论人
        appGambitThemeComment.setCreateId(id);
        return appGambitService.comment(appGambitThemeComment);
    }


    /**
     * 写帖子（添加主题信息）
     * @param appGambitTheme app主题信息
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/writePost")
    public Map<String,Object> writePost(@RequestBody AppGambitTheme appGambitTheme,HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //填入发布人
        appGambitTheme.setCreateId(id);
        return appGambitService.writePost(appGambitTheme);
    }

    /**
     * 查询当前话题下的的所有主题信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param id 用户id
     * @param gambitId 话题主键id
     * @return map
     */
    @GetMapping("/listByGambitId")
    public Map<String,Object> listByGambitId(int pageNum,int size,Integer id,int gambitId){
        PageHelper.startPage(pageNum,size);
        List<AppGambitThemeVo> appGambitThemeVos =appGambitService.listByGambitId(id,gambitId);
        PageInfo<AppGambitThemeVo> pageInfo = new PageInfo<>(appGambitThemeVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }






}
