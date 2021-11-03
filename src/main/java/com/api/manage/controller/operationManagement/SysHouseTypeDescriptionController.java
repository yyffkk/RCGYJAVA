package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysHouseTypeDescriptionService;
import com.api.model.operationManagement.SearchHouseTypeDescription;
import com.api.model.operationManagement.SysHouseTypeDescription;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.SysHouseTypeDescriptionListVo;
import com.api.vo.operationManagement.VoKeyBorrow;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 户型说明管理
 */
@RestController
@RequestMapping("manage/houseTypeDescription")
public class SysHouseTypeDescriptionController {
    @Resource
    SysHouseTypeDescriptionService sysHouseTypeDescriptionService;


    /**
     * 查询所有的户型说明
     * @param searchHouseTypeDescription 户型说明搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0501"},logical = Logical.AND)
    public Map<String,Object> list(SearchHouseTypeDescription searchHouseTypeDescription){
        PageHelper.startPage(searchHouseTypeDescription.getPageNum(),searchHouseTypeDescription.getSize());
        List<SysHouseTypeDescriptionListVo> sysHouseTypeDescriptionListVoList = sysHouseTypeDescriptionService.list(searchHouseTypeDescription);
        PageInfo<SysHouseTypeDescriptionListVo> pageInfo = new PageInfo<>(sysHouseTypeDescriptionListVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据户型说明主键id查询户型说明信息
     * @param id 户型说明主键id
     * @return 户型说明信息
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0502"},logical = Logical.AND)
    public Map<String,Object> findById(Integer id){
        return sysHouseTypeDescriptionService.findById(id);
    }

    /**
     * 添加户型说明
     * @param sysHouseTypeDescription 户型说明model
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0503"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody SysHouseTypeDescription sysHouseTypeDescription){
        return sysHouseTypeDescriptionService.insert(sysHouseTypeDescription);
    }

    /**
     * 修改户型说明
     * @param sysHouseTypeDescription 户型说明model
     * @return map
     */
    @PostMapping("/update")
    @RequiresPermissions(value = {"0505"},logical = Logical.AND)
    public Map<String,Object> update(@RequestBody SysHouseTypeDescription sysHouseTypeDescription){
        return sysHouseTypeDescriptionService.update(sysHouseTypeDescription);
    }

    /**
     * 批量删除户型说明
     * @param ids 户型说明主键id数组
     * @return map
     */
    @PostMapping("/delete")
    @RequiresPermissions(value = {"0504"},logical = Logical.AND)
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysHouseTypeDescriptionService.delete(ids.getIds());
    }

    /**
     * 发布
     * @param id 户型说明主键id
     * @return map
     */
    @GetMapping("/release")
    public Map<String,Object> release(Integer id){
        return sysHouseTypeDescriptionService.release(id);
    }

}
