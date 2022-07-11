package com.api.manage.controller.businessManagement;

import com.api.manage.service.businessManagement.SysDataBaseService;
import com.api.model.businessManagement.SearchDataBase;
import com.api.model.businessManagement.SysDataBase;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.businessManagement.VoDataBase;
import com.api.vo.businessManagement.VoSalary;
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
 * 数据库管理
 */
@RestController
@RequestMapping("manage/dataBase")
public class SysDataBaseController {
    @Resource
    SysDataBaseService sysDataBaseService;

    /**
     * 查询所有的数据库信息
     * @param searchDataBase 数据库搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0101"},logical = Logical.AND)
    public Map<String,Object> list(SearchDataBase searchDataBase){
        PageHelper.startPage(searchDataBase.getPageNum(),searchDataBase.getSize());
        List<VoDataBase> voDataBaseList = sysDataBaseService.list(searchDataBase);
        PageInfo<VoDataBase> pageInfo = new PageInfo<>(voDataBaseList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加数据库信息
     * @param sysDataBase 数据库model信息
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0104"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody SysDataBase sysDataBase){
        return sysDataBaseService.insert(sysDataBase);
    }

    /**
     * 修改数据库信息
     * @param sysDataBase 数据库model信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysDataBase sysDataBase){
        return sysDataBaseService.update(sysDataBase);
    }

    /**
     * 批量删除数据库信息
     * @param ids 数据库信息主键id
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysDataBaseService.delete(ids.getIds());
    }


}
