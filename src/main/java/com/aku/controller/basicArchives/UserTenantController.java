package com.aku.controller.basicArchives;

import com.aku.model.basicArchives.UserResident;
import com.aku.service.basicArchives.UserTenantService;
import com.aku.vo.basicArchives.VoRelatives;
import com.aku.vo.basicArchives.VoUpdateTenant;
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
        map.put("cpmBuildingList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加租户信息
     * @param userResident  租户信息
     * @param voRelativesList  亲属信息集合
     * @param buildingUnitEstateIds 房产集合
     * @return
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody UserResident userResident, @RequestBody List<VoRelatives> voRelativesList, @RequestBody List<Integer> buildingUnitEstateIds){
        return userTenantService.insert(userResident,voRelativesList,buildingUnitEstateIds);
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
     * 修改租客信息
     * @param voUpdateTenant 修改租户信息Vo，关联租房屋
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody VoUpdateTenant voUpdateTenant){
        return userTenantService.update(voUpdateTenant);
    }
}
