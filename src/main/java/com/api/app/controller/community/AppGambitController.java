package com.api.app.controller.community;

import com.api.app.service.community.AppGambitService;
import com.api.vo.app.AppGambitThemeVo;
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
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<AppGambitThemeVo> appGambitThemeVos =appGambitService.list();
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
    @GetMapping("/listTheme")
    public Map<String,Object> listTheme(int pageNum,int size){

        return null;
    }


}
