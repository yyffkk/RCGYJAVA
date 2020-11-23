package com.aku.controller.basicArchives;

import com.aku.model.basicArchives.*;
import com.aku.service.basicArchives.UserTenantService;
import com.aku.vo.basicArchives.VoUserTenant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 租户controller
 */
@RequestMapping("tenant")
@RestController
public class UserTenantController {
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
    public Map<String,Object> insert(UserTenantInsert userTenantInsert){
        return userTenantService.insert(userTenantInsert);
    }

    /**
     * 根据id查询租客信息
     * @param id 租客ID
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return userTenantService.findById(id);
    }

    /**
     * 修改租客和亲属信息
     * @param residentAndRelativesList 租户信息 和 亲属信息集合
     * @return map
     */
    @PostMapping("/updateRelatives")
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
    public Map<String,Object> updateParkingSpace(@RequestBody List<CpmParkingSpace> cpmParkingSpaceList,@RequestBody Integer tenantId){
        return userTenantService.updateParkingSpace(cpmParkingSpaceList,tenantId);
    }




}
