package com.aku.controller.basicArchives;

import com.aku.model.basicArchives.CpmBuildingUnitEstate;
import com.aku.model.basicArchives.UserResident;
import com.aku.service.basicArchives.UserResidentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Map<String,Object> list(UserResident userResident,int pageNum,int size){
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
     * 添加住户信息
     * @param userResident 业主信息
     * @param cpmBuildingUnitEstate 楼栋单元房产信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(UserResident userResident, CpmBuildingUnitEstate cpmBuildingUnitEstate){
        return userResidentService.insert(userResident,cpmBuildingUnitEstate);
    }

}
