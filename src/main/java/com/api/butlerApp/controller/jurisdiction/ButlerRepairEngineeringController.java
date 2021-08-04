package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerRepairEngineeringService;
import com.api.model.butlerApp.ButlerRepairEngineering;
import com.api.model.butlerApp.ButlerRepairEngineeringSearch;
import com.api.vo.butlerApp.ButlerRepairEngineeringVo;
import com.api.vo.butlerApp.ButlerRepairVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管家app 报事报修工程维修
 */
@RestController
@RequestMapping("butlerApp/user/repairEngineering")
public class ButlerRepairEngineeringController {
    @Resource
    ButlerRepairEngineeringService butlerRepairEngineeringService;

    /**
     * 查询所有的报事报修工程维修信息（包含条件搜索）
     * @param butlerRepairEngineeringSearch 管家app 报事报修-工程维修 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerRepairEngineeringSearch butlerRepairEngineeringSearch){
        //查询用户所属权限,type:1.工程派单-维修公司 2.工程派单-维修人员 3.工程接单-维修人员，4.不具备任何权限
        int type = butlerRepairEngineeringService.findJurisdictionByUserId(butlerRepairEngineeringSearch.getRoleId());
        //分页查询信息
        PageHelper.startPage(butlerRepairEngineeringSearch.getPageNum(),butlerRepairEngineeringSearch.getSize());
        List<ButlerRepairEngineeringVo> butlerRepairEngineeringVoList =butlerRepairEngineeringService.list(butlerRepairEngineeringSearch,type);
        PageInfo<ButlerRepairEngineeringVo> pageInfo = new PageInfo<>(butlerRepairEngineeringVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加报事报修工程维修
     * @param butlerRepairEngineering 管家app 报事报修工程维修model
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody ButlerRepairEngineering butlerRepairEngineering, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        butlerRepairEngineering.setCreateId(id);
        butlerRepairEngineering.setCreateDate(new Date());
        return butlerRepairEngineeringService.insert(butlerRepairEngineering);
    }


}
