package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysFacilitiesManageService;
import com.api.model.butlerService.FacilitiesManage;
import com.api.model.butlerService.SearchFacilitiesManage;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoFacilitiesCategory;
import com.api.vo.butlerService.VoFacilitiesManage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
public class SysFacilitiesManageController {
    @Resource
    SysFacilitiesManageService sysFacilitiesManageService;

    /**
     * 查询所有的设施信息（包含搜索条件）
     * @param searchFacilitiesManage 设施管理 搜索条件
     * @return map
     */
    @GetMapping("/list")
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
     * 添加设施信息
     * @param facilitiesManage 设施管理信息model
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody FacilitiesManage facilitiesManage){
        return sysFacilitiesManageService.insert(facilitiesManage);
    }

    /**
     * 修改设施信息
     * @param facilitiesManage 设施管理信息model
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody FacilitiesManage facilitiesManage){
        return sysFacilitiesManageService.update(facilitiesManage);
    }

    /**
     * 根据设施主键id查询设施详情
     * @param id 设施主键id
     * @return 设施
     */
    @GetMapping("/findDetailById")
    public Map<String,Object> findDetailById(Integer id){
        return sysFacilitiesManageService.findDetailById(id);
    }

    /**
     * 批量删除设施信息
     * @param ids 批量删除设施主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysFacilitiesManageService.delete(ids.getIds());
    }

    /**
     * 开启设施
     * @param id 设施主键ID
     * @return map
     */
    @GetMapping("/isEnable")
    public Map<String,Object> isEnable(Integer id){
        return sysFacilitiesManageService.isEnable(id);
    }

}
