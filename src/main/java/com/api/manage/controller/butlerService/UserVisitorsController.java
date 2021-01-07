package com.api.manage.controller.butlerService;

import com.api.manage.shiro.ShiroExceptions;
import com.api.model.butlerService.SearchUserVisitors;
import com.api.model.butlerService.UserVisitors;
import com.api.manage.service.butlerService.UserVisitorsService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoFindByIdVisitors;
import com.api.vo.butlerService.VoUserVisitors;
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
 * 访客管理表
 */
@RestController
@RequestMapping("manage/visitors")
public class UserVisitorsController extends ShiroExceptions {
    @Resource
    UserVisitorsService userVisitorsService;

    /**
     * 查询所有的访客管理信息 （包含条件搜索）
     * @param searchUserVisitors 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301","03"},logical = Logical.AND)
    public Map<String,Object> list(SearchUserVisitors searchUserVisitors){
        PageHelper.startPage(searchUserVisitors.getPageNum(),searchUserVisitors.getSize());
        List<VoUserVisitors> voUserVisitorsList =userVisitorsService.list(searchUserVisitors);
        PageInfo<VoUserVisitors> pageInfo = new PageInfo<>(voUserVisitorsList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据访客管理主键id查询访客管理信息
     * @param id 访客管理主键id
     * @return 访客管理信息
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0302","03"},logical = Logical.AND)
    public VoFindByIdVisitors findById(Integer id){
        return userVisitorsService.findById(id);
    }

    /**
     * 更新访客管理信息
     * @return map
     */
    @PostMapping("/update")
    @RequiresPermissions(value = {"0305","03"},logical = Logical.AND)
    public Map<String,Object> update(@RequestBody UserVisitors visitors){
        return userVisitorsService.update(visitors);
    }

    /**
     * 批量作废访客信息
     * @param ids 访客信息主键id数组
     * @return map
     */
    @PostMapping("/cancel")
    @RequiresPermissions(value = {"0308","03"},logical = Logical.AND)
    public Map<String,Object> cancel(@RequestBody VoIds ids){
        return userVisitorsService.cancel(ids.getIds());
    }

    /**
     * 批量删除访客信息
     * @param ids 访客信息主键id数组
     * @return map
     */
    @PostMapping("/delete")
    @RequiresPermissions(value = {"0304","03"},logical = Logical.AND)
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return userVisitorsService.delete(ids.getIds());
    }

    /**
     * 根据访客管理信息主键id查询访客出入记录
     * @param id 访客管理信息主键id
     * @return 访客出入记录
     */
    @GetMapping("listDetail")
    @RequiresPermissions(value = {"0302","03"},logical = Logical.AND)
    public Map<String,Object> listDetail(Integer id){
        return userVisitorsService.listDetail(id);
    }

    /**
     * 查询今日家庭申报访客通行数量
     * @return map
     */
    @GetMapping("/countVisitorsNew")
    @RequiresPermissions(value = {"0301","03"},logical = Logical.AND)
    public Map<String,Object> countVisitorsNew(){
        return userVisitorsService.countVisitorsNew();
    }
}
