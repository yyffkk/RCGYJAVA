package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerArticleOutService;
import com.api.model.butlerApp.ButlerArticleOutSearch;
import com.api.vo.butlerApp.ButlerArticleOutVo;
import com.api.vo.butlerApp.ButlerRepairVo;
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
 * 管家app 物品出门
 */
@RestController
@RequestMapping("butlerApp/user/articleOut")
public class ButlerArticleOutController {
    @Resource
    ButlerArticleOutService butlerArticleOutService;


    /**
     * 查询所有的物品出户信息(包含搜索条件)
     * @param articleOutSearch 管家app 物品出门 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerArticleOutSearch articleOutSearch){
        PageHelper.startPage(articleOutSearch.getPageNum(),articleOutSearch.getSize());
        List<ButlerArticleOutVo> butlerArticleOutVos =butlerArticleOutService.list(articleOutSearch);
        PageInfo<ButlerArticleOutVo> pageInfo = new PageInfo<>(butlerArticleOutVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据物品出户主键id查询出户详情
     * @param articleOutId 物品出户主键id
     * @param roleId 当前用户所拥有的角色id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer articleOutId,String roleId){
        return butlerArticleOutService.findById(articleOutId,roleId);
    }

    /**
     * 放行
     * @return
     */
    public Map<String,Object> release(){
        return null;
    }

    /**
     * 不放行
     * @return
     */
    public Map<String,Object> noRelease(){
        return null;
    }
}
