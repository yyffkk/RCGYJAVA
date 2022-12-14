package com.api.manage.controller.basicArchives;


import com.api.model.basicArchives.*;
import com.api.manage.service.basicArchives.UserTenantService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.basicArchives.VoUserTenant;
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
 * 租户controller
 */
@RequestMapping("manage/tenant")
@RestController
public class UserTenantController   {
    @Resource
    UserTenantService userTenantService;


    /**
     * 查询所有租户信息（包含条件搜索）
     * @param userTenant 搜索条件（租户名称，租户手机号）
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0201"},logical = Logical.AND)
    public Map<String,Object> list(UserResident userTenant, int pageNum, int size){
        PageHelper.startPage(pageNum,size);
        List<VoUserTenant> voUserTenantLists = userTenantService.list(userTenant);
        PageInfo<VoUserTenant> pageInfo = new PageInfo<>(voUserTenantLists);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加租户信息
     * @param userTenantInsert  租户添加信息(租户信息,租户亲属信息集合,业主房屋关联信息集合)
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0203"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody UserTenantInsert userTenantInsert){
        return userTenantService.insert(userTenantInsert);
    }

    /**
     * 根据id查询租客信息(详情页面)
     * @param id 租客ID
     * @return map
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0202"},logical = Logical.AND)
    public Map<String,Object> findById(Integer id){
        return userTenantService.findById(id);
    }

    /**
     * 修改租客和亲属信息
     * @param residentAndRelativesList 租户信息 和 亲属信息集合
     * @return map
     */
    @PostMapping("/updateRelatives")
    @RequiresPermissions(value = {"0205"},logical = Logical.AND)
    public Map<String,Object> updateRelatives(@RequestBody ResidentAndRelativesList residentAndRelativesList){
        return userTenantService.updateRelatives(residentAndRelativesList);
    }

    /**
     * 修改租客租房信息
     * @param cpmResidentEstateList 租户房产关联信息集合
     * @param tenantId 租户id
     * @return map
     */
    @PostMapping("/updateEstate")
    @RequiresPermissions(value = {"0205"},logical = Logical.AND)
    public Map<String,Object> updateEstate(@RequestBody List<CpmResidentEstate> cpmResidentEstateList,@RequestBody Integer tenantId){
        return userTenantService.updateEstate(cpmResidentEstateList,tenantId);
    }

    /**
     * 修改租户车位信息
     * @param cpmParkingSpaceList 车位信息集合
     * @param tenantId 租户id
     * @return map
     */
    @PostMapping("/updateParkingSpace")
    @RequiresPermissions(value = {"0205"},logical = Logical.AND)
    public Map<String,Object> updateParkingSpace(@RequestBody List<CpmParkingSpace> cpmParkingSpaceList,@RequestBody Integer tenantId){
        return userTenantService.updateParkingSpace(cpmParkingSpaceList,tenantId);
    }

    /**
     * 删除租户信息
     * @param ids 租户主键id数组
     * @return map
     */
    @PostMapping("/delete")
    @RequiresPermissions(value = {"0204"},logical = Logical.AND)
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return userTenantService.delete(ids.getIds());
    }




}
