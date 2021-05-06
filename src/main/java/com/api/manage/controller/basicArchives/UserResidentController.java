package com.api.manage.controller.basicArchives;

import com.api.manage.shiro.ShiroExceptions;
import com.api.model.basicArchives.*;
import com.api.vo.basicArchives.*;
import com.api.manage.service.basicArchives.UserResidentService;
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
 * 业主管理
 */
@RequestMapping("manage/userResident")
@RestController
public class UserResidentController extends ShiroExceptions {
    @Resource
    UserResidentService userResidentService;

    /**
     * 查询业主信息（包含搜索条件）
     * @param userResident 搜索条件
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0201","02"},logical = Logical.AND)
    public Map<String,Object> list(UserResident userResident,Integer pageNum,Integer size){
        PageHelper.startPage(pageNum,size);
        List<VoUserResident> voUserResidentList = userResidentService.list(userResident);
        PageInfo<VoUserResident> pageInfo = new PageInfo<>(voUserResidentList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }
    /**
     * 添加业主信息
     * @param residentInsert 业主的添加信息
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0203","02"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody ResidentInsert residentInsert){
        return userResidentService.insert(residentInsert.getUserResident(),residentInsert.getVoRelativesList(),residentInsert.getCpmParkingSpaceIds(),residentInsert.getBuildingUnitEstateIds());
    }

    /**
     * 根据业主主键id查询业主信息（及其关联的房屋信息和车位信息）
     * @param id 业主主键id
     * @return map
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0202","02"},logical = Logical.AND)
    public Map<String,Object> findById(Integer id){
        return userResidentService.findById(id);
    }

    /**
     * 根据业主主键id查询业主信息（无关联的房屋信息和车位信息）
     * @param id 业主主键id
     * @return map
     */
    @GetMapping("/findByIdOne")
    @RequiresPermissions(value = {"0202","02"},logical = Logical.AND)
    public Map<String,Object> findByIdOne(Integer id){
        return userResidentService.findByIdOne(id);
    }

    /**
     * 根据业主(租户)主键id 查询业主(租户)及其亲属信息
     * @return map
     */
    @GetMapping("/findRelativesById")
    @RequiresPermissions(value = {"0202","02"},logical = Logical.AND)
    public Map<String,Object> findRelativesById(Integer id){
        return userResidentService.findRelativesById(id);
    }

    /**
     * 根据业主(租户)主键id 查询业主(租户)及其房产信息
     * @return map
     */
    @GetMapping("/findEstateById")
    @RequiresPermissions(value = {"0202","02"},logical = Logical.AND)
    public Map<String,Object> findEstateById(Integer id){
        return userResidentService.findEstateById(id);
    }

    /**
     * 根据业主(租户)主键id 查询业主(租户)及其车位信息
     * @return map
     */
    @GetMapping("/findParkingSpaceById")
    @RequiresPermissions(value = {"0202","02"},logical = Logical.AND)
    public Map<String,Object> findParkingSpaceById(Integer id){
        return userResidentService.findParkingSpaceById(id);
    }



    /**
     * 修改业主亲属信息
     * @param residentAndRelatives 业主 和 亲属集合
     * @return map
     */
    @PostMapping("/updateRelatives")
    @RequiresPermissions(value = {"0205","02"},logical = Logical.AND)
    public Map<String,Object> updateRelatives(@RequestBody ResidentAndRelativesList residentAndRelatives){
        return userResidentService.updateRelatives(residentAndRelatives);
    }

    /**
     * 修改业主房产信息
     * @param residentAndEstateList 业主 和 房产集合
     * @return map
     */
    @PostMapping("/updateEstate")
    @RequiresPermissions(value = {"0205","02"},logical = Logical.AND)
    public Map<String,Object> updateEstate(@RequestBody ResidentAndEstateIds residentAndEstateList){
        return userResidentService.updateEstate(residentAndEstateList);
    }

    /**
     * 修改业主车位信息
     * @param residentAndParkingSpaceList 业主 和 车位信息集合
     * @return map
     */
    @PostMapping("/updateParkingSpace")
    @RequiresPermissions(value = {"0205","02"},logical = Logical.AND)
    public Map<String,Object> updateParkingSpace(@RequestBody ResidentAndParkingSpaceIds residentAndParkingSpaceList){
        return userResidentService.updateParkingSpace(residentAndParkingSpaceList);
    }



    /**
     * 删除业主信息
     * @param ids 业主主键id数组
     * @return map
     */
    @PostMapping("/delete")
    @RequiresPermissions(value = {"0204","02"},logical = Logical.AND)
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return userResidentService.delete(ids.getIds());
    }

    /**
     * 查询所有业主的id和name
     * @return VoFindAll
     */
    @GetMapping("/findResidentAll")
    public List<VoFindAll> findResidentAll(){
        return userResidentService.findResidentAll();
    }

    /**
     * 查询所有住户的id和name
     * @return VoFindAll
     */
    @GetMapping("/findAll")
    public List<VoFindAll> findAll(){
        return userResidentService.findAll();
    }


    /**
     * 根据名字模糊查询查询住户的id和name
     */
    @GetMapping("/findAllBySearch")
    public Map<String,Object> findNameBySearch(SearchFindName searchFindName){
        PageHelper.startPage(searchFindName.getPageNum(),searchFindName.getSize());
        List<VoFindAll> voFindAllList = userResidentService.findNameBySearch(searchFindName);
        PageInfo<VoFindAll> pageInfo = new PageInfo<>(voFindAllList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据名字模糊查询查询业主的id和name及房产相关信息
     */
    @GetMapping("/findResidentNameBySearch")
    public Map<String,Object> findResidentNameBySearch(SearchFindName searchFindName){
        PageHelper.startPage(searchFindName.getPageNum(),searchFindName.getSize());
        List<VoFindResidentByName> voFindResidentByNameList = userResidentService.findResidentNameBySearch(searchFindName);
        PageInfo<VoFindResidentByName> pageInfo = new PageInfo<>(voFindResidentByNameList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据名字模糊查询查询住户信息及房产相关信息
     */
    @GetMapping("/findResidentInfoBySearch")
    public Map<String,Object> findResidentInfoBySearch(SearchFindName searchFindName){
        PageHelper.startPage(searchFindName.getPageNum(),searchFindName.getSize());
        List<VoFindResidentInfo> voFindResidentByNameList = userResidentService.findResidentInfoBySearch(searchFindName);
        PageInfo<VoFindResidentInfo> pageInfo = new PageInfo<>(voFindResidentByNameList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


}
