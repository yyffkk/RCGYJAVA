package com.api.manage.controller.butlerService;


import com.api.model.butlerService.SearchConveniencePhone;
import com.api.model.butlerService.SysConveniencePhone;
import com.api.model.butlerService.SysConveniencePhoneReminder;
import com.api.manage.service.butlerService.SysConveniencePhoneService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoConveniencePhone;
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
 * 便民电话表
 */
@RestController
@RequestMapping("manage/conveniencePhone")
public class SysConveniencePhoneController   {
    @Resource
    SysConveniencePhoneService sysConveniencePhoneService;


    /**
     * 查询便民电话信息（包含条件搜索）
     * @param searchConveniencePhone 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301","03"},logical = Logical.AND)
    public Map<String,Object> list(SearchConveniencePhone searchConveniencePhone){
        PageHelper.startPage(searchConveniencePhone.getPageNum(),searchConveniencePhone.getSize());
        List<VoConveniencePhone> voConveniencePhoneList = sysConveniencePhoneService.list(searchConveniencePhone);
        PageInfo<VoConveniencePhone> pageInfo = new PageInfo<>(voConveniencePhoneList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加便民电话信息
     * @param sysConveniencePhone 便民电话信息
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0303","03"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody SysConveniencePhone sysConveniencePhone){
        return sysConveniencePhoneService.insert(sysConveniencePhone);
    }

    /**
     * 根据便民电话主键id查询便民电话信息
     * @param id 便民电话主键id
     * @return 便民电话信息
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0302","03"},logical = Logical.AND)
    public Map<String,Object> findById(Integer id){
        return sysConveniencePhoneService.findById(id);
    }

    /**
     * 更新便民电话信息
     * @param sysConveniencePhone 新便民电话信息
     * @return map
     */
    @PostMapping("/update")
    @RequiresPermissions(value = {"0305","03"},logical = Logical.AND)
    public Map<String,Object> update(@RequestBody SysConveniencePhone sysConveniencePhone){
        return sysConveniencePhoneService.update(sysConveniencePhone);
    }


    /**
     * 更新定时检查信息
     * @param sysConveniencePhoneReminder 定时检查信息
     * @return map
     */
    @PostMapping("/updateReminder")
    @RequiresPermissions(value = {"0305","03"},logical = Logical.AND)
    public Map<String,Object> updateReminder(@RequestBody SysConveniencePhoneReminder sysConveniencePhoneReminder){
        return sysConveniencePhoneService.updateReminder(sysConveniencePhoneReminder);
    }

    /**
     * 批量删除便民电话
     * @param ids 主键id数组
     * @return map
     */
    @PostMapping("/delete")
    @RequiresPermissions(value = {"0304","03"},logical = Logical.AND)
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysConveniencePhoneService.delete(ids.getIds());
    }
}
