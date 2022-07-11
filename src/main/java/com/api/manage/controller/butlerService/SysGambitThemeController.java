package com.api.manage.controller.butlerService;


import com.api.model.butlerService.SearchGambitTheme;
import com.api.manage.service.butlerService.SysGambitThemeService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoGambitTheme;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主题明细管理
 */
@RestController
@RequestMapping("manage/gambitTheme")
public class SysGambitThemeController   {
    @Resource
    SysGambitThemeService sysGambitThemeService;

    /**
     * 查询所有的主题明细信息 （包含条件搜索）
     * @param searchGambitTheme 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301"},logical = Logical.AND)
    public Map<String,Object> list(SearchGambitTheme searchGambitTheme){
        PageHelper.startPage(searchGambitTheme.getPageNum(),searchGambitTheme.getSize());
        List<VoGambitTheme> voGambitThemeList = sysGambitThemeService.list(searchGambitTheme);
        PageInfo<VoGambitTheme> pageInfo = new PageInfo<>(voGambitThemeList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 批量删除主题明细信息
     * @param ids 主题明细主键id数组
     * @return map
     */
    @PostMapping("/falseDelete")
    @RequiresPermissions(value = {"0305"},logical = Logical.AND)
    public Map<String,Object> falseDelete(@RequestBody VoIds ids){
        return sysGambitThemeService.falseDelete(ids.getIds());
    }

    /**
     * 批量恢复主题明细信息
     * @param ids 主题明细主键id数组
     * @return map
     */
    @PostMapping("/recovery")
    @RequiresPermissions(value = {"0305"},logical = Logical.AND)
    public Map<String,Object> recovery(@RequestBody VoIds ids){
        return sysGambitThemeService.recovery(ids.getIds());
    }


    /**
     * 开启/停止用户动态发布功能
     * @return map
     */
    @GetMapping("/enableTheme")
    public Map<String,Object> enableTheme(){
        return sysGambitThemeService.enableTheme();
    }

    /**
     * 开启/停止用户评论功能
     * @return map
     */
    @GetMapping("/enableComment")
    public Map<String,Object> enableComment(){
        return sysGambitThemeService.enableComment();
    }

    /**
     * 根据主题明细主键id查询评论列表
     * @param themeId 主题明细主键id
     * @return map
     */
    @GetMapping("/findCommentByThemeId")
    public Map<String,Object> findCommentByThemeId(Integer themeId){
        return sysGambitThemeService.findCommentByThemeId(themeId);
    }

    /**
     * 根据主题评论主键id删除主题评论
     * @param commentId 主题评论主键id
     * @return map
     */
    @GetMapping("/deleteCommentByCommentId")
    public Map<String,Object> deleteCommentByCommentId(Integer commentId){
        return sysGambitThemeService.deleteCommentByCommentId(commentId);
    }
}
