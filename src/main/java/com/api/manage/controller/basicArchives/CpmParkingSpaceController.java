package com.api.manage.controller.basicArchives;

import com.api.manage.shiro.ShiroExceptions;
import com.api.model.basicArchives.CpmParkingSpace;
import com.api.vo.basicArchives.VoCpmParkingSpace;
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

@RequestMapping("manage/cpmParkingSpace")
@RestController
public class CpmParkingSpaceController extends ShiroExceptions {
    @Resource
    CpmParkingSpaceService cpmParkingSpaceService;

    /**
     * 查询车位信息（包含条件搜索）
     * @param voCpmParkingSpace 搜索条件
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0201","02"},logical = Logical.AND)
    public Map<String,Object> list(VoCpmParkingSpace voCpmParkingSpace, int pageNum, int size){
        PageHelper.startPage(pageNum,size);
        List<VoParkingSpace> voParkingSpaceList =cpmParkingSpaceService.list(voCpmParkingSpace);
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
    @RequiresPermissions(value = {"0203","02"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody CpmParkingSpace cpmParkingSpace){
        return cpmParkingSpaceService.insert(cpmParkingSpace);
    }

    /**
     * 根据车位主键ID查询车位信息
     * @param id 车位主键id
     * @return 车位信息
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0202","02"},logical = Logical.AND)
    public CpmParkingSpace findById(Integer id){
        return cpmParkingSpaceService.findById(id);
    }

    /**
     * 修改车位信息
     * @param cpmParkingSpace 车位信息
     * @return map
     */
    @PostMapping("/update")
    @RequiresPermissions(value = {"0205","02"},logical = Logical.AND)
    public Map<String,Object> update(@RequestBody CpmParkingSpace cpmParkingSpace){
        return cpmParkingSpaceService.update(cpmParkingSpace);
    }

    /**
     * 删除车位信息
     * @param ids 车位主键id数组
     * @return map
     */
    @PostMapping("/delete")
    @RequiresPermissions(value = {"0204","02"},logical = Logical.AND)
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return cpmParkingSpaceService.delete(ids.getIds());
    }

}
