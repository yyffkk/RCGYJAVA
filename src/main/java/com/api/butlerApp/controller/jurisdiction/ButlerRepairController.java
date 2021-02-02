package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerRepairService;
import com.api.model.butlerApp.ButlerRepairSearch;
import com.api.vo.butlerApp.ButlerRepairVo;
import com.api.vo.butlerApp.ButlerVisitorVo;
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
 * 管家app 报事报修
 */
@RestController
@RequestMapping("butlerApp/user/repair")
public class ButlerRepairController {
    @Resource
    ButlerRepairService butlerRepairService;

    /**
     * 查询所有的报事报修信息(包含条件搜索)
     * @param butlerRepairSearch 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerRepairSearch butlerRepairSearch){
        PageHelper.startPage(butlerRepairSearch.getPageNum(),butlerRepairSearch.getSize());
        List<ButlerRepairVo> butlerRepairVos =butlerRepairService.list(butlerRepairSearch);
        PageInfo<ButlerRepairVo> pageInfo = new PageInfo<>(butlerRepairVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 根据报事报修id查询报修详情
     * @param repairId 报事报修id
     * @param id 用户id
     * @param roleId 用户所拥有的角色id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer repairId,Integer id,String roleId){
        return butlerRepairService.findById(repairId,id,roleId);
    }
}
