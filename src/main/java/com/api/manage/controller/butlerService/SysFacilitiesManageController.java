package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysFacilitiesManageService;

import com.api.model.butlerService.FacilitiesManage;
import com.api.model.butlerService.SearchFacilitiesManage;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoFacilitiesCategory;
import com.api.vo.butlerService.VoFacilitiesManage;
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
 * 设施管理
 */
@RestController
@RequestMapping("manage/facilitiesManage")
public class SysFacilitiesManageController   {
    @Resource
    SysFacilitiesManageService sysFacilitiesManageService;

    /**
     * 查询所有的设施/设备信息（包含搜索条件）
     * @param searchFacilitiesManage 设施/设备管理 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301"},logical = Logical.AND)
    public Map<String,Object> list(SearchFacilitiesManage searchFacilitiesManage){
        PageHelper.startPage(searchFacilitiesManage.getPageNum(),searchFacilitiesManage.getSize());
        List<VoFacilitiesManage> voFacilitiesManageList = sysFacilitiesManageService.list(searchFacilitiesManage);
        PageInfo<VoFacilitiesManage> pageInfo = new PageInfo<>(voFacilitiesManageList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 添加设施/设备信息
     * @param facilitiesManage 设施/设备管理信息model
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0303"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody FacilitiesManage facilitiesManage){
        return sysFacilitiesManageService.insert(facilitiesManage);
    }

    /**
     * 修改设施/设备信息
     * @param facilitiesManage 设施/设备管理信息model
     * @return map
     */
    @PostMapping("/update")
    @RequiresPermissions(value = {"0305"},logical = Logical.AND)
    public Map<String,Object> update(@RequestBody FacilitiesManage facilitiesManage){
        return sysFacilitiesManageService.update(facilitiesManage);
    }

    /**
     * 根据设施/设备主键id查询设施/设备详情
     * @param id 设施/设备主键id
     * @return map
     */
    @GetMapping("/findDetailById")
    @RequiresPermissions(value = {"0302"},logical = Logical.AND)
    public Map<String,Object> findDetailById(Integer id){
        return sysFacilitiesManageService.findDetailById(id);
    }

    /**
     * 批量删除设施/设备信息
     * @param ids 批量删除设施/设备主键id数组
     * @return map
     */
    @PostMapping("/delete")
    @RequiresPermissions(value = {"0304"},logical = Logical.AND)
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysFacilitiesManageService.delete(ids.getIds());
    }

    /**
     * 开启设施/设备
     * @param id 设施主键ID
     * @return map
     */
    @GetMapping("/isEnable")
    public Map<String,Object> isEnable(Integer id){
        return sysFacilitiesManageService.isEnable(id);
    }

}
