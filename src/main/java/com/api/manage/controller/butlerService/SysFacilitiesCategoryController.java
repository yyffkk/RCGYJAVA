package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysFacilitiesCategoryService;

import com.api.model.butlerService.FacilitiesCategory;
import com.api.model.butlerService.SearchFacilitiesCategory;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoFacilitiesCategory;
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
 * 设施分类管理
 */
@RestController
@RequestMapping("manage/facilitiesCategory")
public class SysFacilitiesCategoryController   {
    @Resource
    SysFacilitiesCategoryService facilitiesCategoryService;

    /**
     * 查询所有的设施/设备分类（包含搜索条件）
     * @param facilitiesCategory 设施/设备分类搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301"},logical = Logical.AND)
    public Map<String,Object> list(SearchFacilitiesCategory facilitiesCategory){
        PageHelper.startPage(facilitiesCategory.getPageNum(),facilitiesCategory.getSize());
        List<VoFacilitiesCategory> voFacilitiesCategoryList = facilitiesCategoryService.list(facilitiesCategory);
        PageInfo<VoFacilitiesCategory> pageInfo = new PageInfo<>(voFacilitiesCategoryList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加设施/设备分类信息
     * @param facilitiesCategory 设施/设备分类管理model
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0303"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody FacilitiesCategory facilitiesCategory){
        return facilitiesCategoryService.insert(facilitiesCategory);
    }

    /**
     * 根据设施/设备分类主键id查询设施分类信息
     * @param id 设施/设备分类主键id
     * @return map
     */
    @GetMapping("/findDetailById")
    @RequiresPermissions(value = {"0302"},logical = Logical.AND)
    public Map<String,Object> findDetailById(Integer id){
        return facilitiesCategoryService.findDetailById(id);
    }

    /**
     * 根据设施分类/设备主键Id修改设施分类信息(不允许修改设施分类类型)
     * @param facilitiesCategory 设施/设备分类管理model
     * @return map
     */
    @PostMapping("/update")
    @RequiresPermissions(value = {"0305"},logical = Logical.AND)
    public Map<String,Object> update(@RequestBody FacilitiesCategory facilitiesCategory){
        return facilitiesCategoryService.update(facilitiesCategory);
    }


    /**
     * 批量删除设施/设备分类
     * @return map
     */
    @PostMapping("/delete")
    @RequiresPermissions(value = {"0304"},logical = Logical.AND)
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return facilitiesCategoryService.delete(ids.getIds());
    }

}
