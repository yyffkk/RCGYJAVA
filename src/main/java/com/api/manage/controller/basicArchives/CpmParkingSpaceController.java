package com.api.manage.controller.basicArchives;


import com.api.model.basicArchives.CpmParkingSpace;
import com.api.model.basicArchives.SearchCpmParkingSpace;
import com.api.manage.service.basicArchives.CpmParkingSpaceService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.basicArchives.VoParkingSpace;
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
 * 车位管理
 */
@RequestMapping("manage/cpmParkingSpace")
@RestController
public class CpmParkingSpaceController   {
    @Resource
    CpmParkingSpaceService cpmParkingSpaceService;

    /**
     * 查询车位信息（包含条件搜索）
     * @param searchCpmParkingSpace 车位信息搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0201"},logical = Logical.AND)
    public Map<String,Object> list(SearchCpmParkingSpace searchCpmParkingSpace){
        PageHelper.startPage(searchCpmParkingSpace.getPageNum(),searchCpmParkingSpace.getSize());
        List<VoParkingSpace> voParkingSpaceList =cpmParkingSpaceService.list(searchCpmParkingSpace);
        PageInfo<VoParkingSpace> pageInfo = new PageInfo<>(voParkingSpaceList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加车位信息
     * @param cpmParkingSpace 车位信息
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0203"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody CpmParkingSpace cpmParkingSpace){
        return cpmParkingSpaceService.insert(cpmParkingSpace);
    }

    /**
     * 根据车位主键ID查询车位信息
     * @param id 车位主键id
     * @return 车位信息
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0202"},logical = Logical.AND)
    public Map<String,Object> findById(Integer id){
        return cpmParkingSpaceService.findById(id);
    }

    /**
     * 修改车位信息
     * @param cpmParkingSpace 车位信息
     * @return map
     */
    @PostMapping("/update")
    @RequiresPermissions(value = {"0205"},logical = Logical.AND)
    public Map<String,Object> update(@RequestBody CpmParkingSpace cpmParkingSpace){
        return cpmParkingSpaceService.update(cpmParkingSpace);
    }

    /**
     * 删除车位信息
     * @param ids 车位主键id数组
     * @return map
     */
    @PostMapping("/delete")
    @RequiresPermissions(value = {"0204"},logical = Logical.AND)
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return cpmParkingSpaceService.delete(ids.getIds());
    }

}
