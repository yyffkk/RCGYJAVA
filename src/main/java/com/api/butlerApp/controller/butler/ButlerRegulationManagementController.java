package com.api.butlerApp.controller.butler;

import com.api.butlerApp.service.butler.ButlerRegulationManagementService;
import com.api.vo.butlerApp.ButlerAnnouncementVo;
import com.api.vo.butlerApp.ButlerRegulationManagementVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管家app 规程管理
 */
@RestController
@RequestMapping("butlerApp/user/regulationManage")
public class ButlerRegulationManagementController {
    @Resource
    ButlerRegulationManagementService butlerRegulationManagementService;


    /**
     * 查询所有的规程管理信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<ButlerRegulationManagementVo> butlerRegulationManagementVoList =butlerRegulationManagementService.list();
        PageInfo<ButlerRegulationManagementVo> pageInfo = new PageInfo<>(butlerRegulationManagementVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }
}
