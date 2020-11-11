package com.aku.controller.basicArchives;

import com.aku.model.basicArchives.CpmBuilding;
import com.aku.model.basicArchives.UserResident;
import com.aku.service.basicArchives.CpmBuildingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("cpmBuilding")
@RestController
public class CpmBuildingController {

    @Resource
    CpmBuildingService cpmBuildingService;


    /**
     * 查询楼栋信息（包含条件搜索）
     * @param cpmBuilding 搜索条件
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    public Map<String,Object> list(CpmBuilding cpmBuilding,int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<CpmBuilding> cpmBuildingList =cpmBuildingService.list(cpmBuilding);
        PageInfo<CpmBuilding> pageInfo = new PageInfo<>(cpmBuildingList);
        Map<String,Object> map = new HashMap<>();
        map.put("cpmBuildingList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

}
