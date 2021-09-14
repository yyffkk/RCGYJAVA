package com.api.manage.controller.businessManagement;

import com.api.manage.service.businessManagement.SysRemindService;

import com.api.model.businessManagement.Remind;
import com.api.model.businessManagement.SearchRemind;
import com.api.vo.businessManagement.VoRemind;
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
 * 提醒通知管理【sys_message,sys_sending】
 */
@RequestMapping("manage/remind")
@RestController
public class SysRemindController   {
    @Resource
    SysRemindService sysRemindService;

    /**
     * 查询所有的提醒通知记录
     * @param searchRemind 提醒通知搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0101"},logical = Logical.AND)
    public Map<String,Object> list(SearchRemind searchRemind){
        PageHelper.startPage(searchRemind.getPageNum(),searchRemind.getSize());
        List<VoRemind> voRemindList = sysRemindService.list(searchRemind);
        PageInfo<VoRemind> pageInfo = new PageInfo<>(voRemindList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加提醒通知
     * @param remind 提醒通知model信息
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0104"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody Remind remind){
        return sysRemindService.insert(remind);
    }
}
