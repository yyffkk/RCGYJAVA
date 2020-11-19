package com.aku.controller.basicArchives;

import com.aku.model.basicArchives.UserResident;
import com.aku.vo.basicArchives.VoRelatives;
import com.aku.vo.basicArchives.VoUpdateResident;
import com.aku.service.basicArchives.UserResidentService;
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
        System.out.println(pageNum);
        System.out.println(size);
        PageHelper.startPage(pageNum,size);
        List<UserResident> userResidentList = userResidentService.list(userResident);
        PageInfo<UserResident> pageInfo = new PageInfo<>(userResidentList);
        Map<String,Object> map = new HashMap<>();
        map.put("userResidentList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     *
     * @param userResident 业主信息
     * @param cpmParkingSpaceId 关联车位主键id
     * @return map
     */
    /**
     * 添加业主信息
     * @param userResident 业主信息
     * @param voRelativesList 亲属信息集合
     * @param buildingUnitEstateIds 关联房产主键id集合
     * @param cpmParkingSpaceIds 关联车位主键id集合
     * @return
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody UserResident userResident, @RequestBody List<VoRelatives> voRelativesList,@RequestBody List<Integer> buildingUnitEstateIds, @RequestBody List<Integer> cpmParkingSpaceIds){
        return userResidentService.insert(userResident,voRelativesList,cpmParkingSpaceIds,buildingUnitEstateIds);
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
     * 修改业主信息
     * @param voUpdateResident 修改业主信息Vo，关联亲属
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody VoUpdateResident voUpdateResident){
        return userResidentService.update(voUpdateResident);
    }

    /**
     * 删除业主信息
     * @param id 业主主键id
     * @return map
     */
    @GetMapping("/delete")
    public Map<String,Object> delete(int id){
        return userResidentService.delete(id);
    }



}
