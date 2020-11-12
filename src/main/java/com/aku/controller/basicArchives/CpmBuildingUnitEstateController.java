package com.aku.controller.basicArchives;

import com.aku.model.basicArchives.CpmBuildingUnitEstate;
import com.aku.model.basicArchives.UserResident;
import com.aku.model.vo.VoCpmBuildingUnitEstate;
import com.aku.service.basicArchives.CpmBuildingUnitEstateService;
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

@RequestMapping("cpmBuildingUnitEstate")
@RestController
public class CpmBuildingUnitEstateController {
    //房产状态为4时，未售
    private static final int ESTATE_STATUS = 4;
    @Resource
    CpmBuildingUnitEstateService cpmBuildingUnitEstateService;
    @Resource
    UserResidentService userResidentService;

    /**
     * 查询楼栋单元房产信息（包含条件搜索）
     * @param voCpmBuildingUnitEstate 搜索条件
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(VoCpmBuildingUnitEstate voCpmBuildingUnitEstate,int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<VoCpmBuildingUnitEstate> voCpmBuildingUnitEstateList =cpmBuildingUnitEstateService.list(voCpmBuildingUnitEstate);
        PageInfo<VoCpmBuildingUnitEstate> pageInfo = new PageInfo<>(voCpmBuildingUnitEstateList);
        Map<String,Object> map = new HashMap<>();
        map.put("voCpmBuildingUnitEstateList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加楼栋单元房产信息
     * @param cpmBuildingUnitEstate 楼栋单元房产信息
     * @param userResident 关联业主
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(CpmBuildingUnitEstate cpmBuildingUnitEstate, UserResident userResident){
        //判断是否有业主需要关联
        if (cpmBuildingUnitEstate.getStatus() == ESTATE_STATUS){
            //不关联业主
            return cpmBuildingUnitEstateService.insert(cpmBuildingUnitEstate);
        } else {
            //关联业主
            return userResidentService.insert(userResident, cpmBuildingUnitEstate);
        }
    }


}
