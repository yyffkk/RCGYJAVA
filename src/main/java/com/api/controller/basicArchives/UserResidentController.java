package com.api.controller.basicArchives;

import com.api.model.basicArchives.*;
import com.api.vo.basicArchives.VoFindAll;
import com.api.vo.basicArchives.VoIds;
import com.api.service.basicArchives.UserResidentService;
import com.api.vo.basicArchives.VoUserResident;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("userResident")
@RestController
public class UserResidentController {
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
    public Map<String,Object> insert(@RequestBody ResidentInsert residentInsert){
        return userResidentService.insert(residentInsert.getUserResident(),residentInsert.getVoRelativesList(),residentInsert.getCpmParkingSpaceIds(),residentInsert.getBuildingUnitEstateIds());
    }

    /**
     * 根据业主主键id查询业主信息（及其关联的房屋信息和车位信息）
     * @param id 业主主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return userResidentService.findById(id);
    }

    /**
     * 根据业主主键id 查询业主及其亲属信息
     * @return map
     */
    @GetMapping("/findRelativesById")
    public Map<String,Object> findRelativesById(Integer id){
        return userResidentService.findRelativesById(id);
    }

    /**
     * 根据业主主键id 查询业主及其房产信息
     * @return map
     */
    @GetMapping("/findEstateById")
    public Map<String,Object> findEstateById(Integer id){
        return userResidentService.findEstateById(id);
    }

    /**
     * 根据业主主键id 查询业主及其车位信息
     * @return map
     */
    @GetMapping("/findParkingSpaceById")
    public Map<String,Object> findParkingSpaceById(Integer id){
        return userResidentService.findParkingSpaceById(id);
    }



    /**
     * 修改业主亲属信息
     * @param residentAndRelatives 业主 和 亲属集合
     * @return map
     */
    @PostMapping("/updateRelatives")
    public Map<String,Object> updateRelatives(@RequestBody ResidentAndRelativesList residentAndRelatives){
        return userResidentService.updateRelatives(residentAndRelatives);
    }

    /**
     * 修改业主房产信息
     * @param residentAndEstateList 业主 和 房产集合
     * @return map
     */
    @PostMapping("/updateEstate")
    public Map<String,Object> updateEstate(@RequestBody ResidentAndEstateIds residentAndEstateList){
        return userResidentService.updateEstate(residentAndEstateList);
    }

    /**
     * 修改业主车位信息
     * @param residentAndParkingSpaceList 业主 和 车位信息集合
     * @return map
     */
    @PostMapping("/updateParkingSpace")
    public Map<String,Object> updateParkingSpace(@RequestBody ResidentAndParkingSpaceIds residentAndParkingSpaceList){
        return userResidentService.updateParkingSpace(residentAndParkingSpaceList);
    }



    /**
     * 删除业主信息
     * @param ids 业主主键id数组
     * @return map
     */
    @PostMapping("/delete")
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




}