package com.api.manage.controller.butlerService;


import com.api.model.butlerService.SearchUserArticleOut;
import com.api.model.resources.ResourcesImg;
import com.api.manage.service.butlerService.UserArticleOutService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoUserArticleOut;
import com.api.vo.resources.VoResourcesImg;
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
 * 物品出门
 */
@RestController
@RequestMapping("manage/userArticleOut")
public class UserArticleOutController   {
    private static Map<String,Object> map = null;

    @Resource
    UserArticleOutService userArticleOutService;

    /**
     * 查询所有物品出门信息（包含条件搜索）
     * @param searchUserArticleOut 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301"},logical = Logical.AND)
    public Map<String, Object> list(SearchUserArticleOut searchUserArticleOut){
        PageHelper.startPage(searchUserArticleOut.getPageNum(),searchUserArticleOut.getSize());
        List<VoUserArticleOut> voUserArticleOutList =userArticleOutService.list(searchUserArticleOut);
        PageInfo<VoUserArticleOut> pageInfo = new PageInfo<>(voUserArticleOutList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 批量删除物品出门信息
     * @param ids 物品出门主键id数组
     * @return map
     */
    @PostMapping("/delete")
    @RequiresPermissions(value = {"0304"},logical = Logical.AND)
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return userArticleOutService.delete(ids.getIds());
    }

    /**
     * 驳回申请
     * @param id 物品出门主键id
     * @return map
     */
    @GetMapping("/applicationRejection")
    @RequiresPermissions(value = {"0314"},logical = Logical.AND)
    public Map<String,Object> applicationRejection(Integer id){
        return userArticleOutService.applicationRejection(id);
    }


    /**
     * 查询今日预计家庭物品出户数量
     * @return map
     */
    @GetMapping("/countArticleOutNow")
    public Map<String,Object> countArticleOutNow(){
        return userArticleOutService.countArticleOutNow();
    }

    /**
     * 查询未执行的家庭物品出户数量
     * @return map
     */
    @GetMapping("/countPerformed")
    public Map<String,Object> countPerformed(){
        return userArticleOutService.countPerformed();
    }

}
