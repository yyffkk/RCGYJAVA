package com.api.app.controller.butler;

import com.api.app.service.butler.AppReportRepairService;
import com.api.vo.app.AppConvenientTelephoneVo;
import com.api.vo.app.AppReportRepairVo;
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
 * app报事报修
 */
@RestController
@RequestMapping("app/user/reportRepair")
public class AppReportRepairController {
    @Resource
    AppReportRepairService appReportRepairService;

    /**
     * app查询当前用户的报事报修信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size,Integer id){
        PageHelper.startPage(pageNum,size);
        List<AppReportRepairVo> appReportRepairVoList =appReportRepairService.list(id);
        PageInfo<AppReportRepairVo> pageInfo = new PageInfo<>(appReportRepairVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

//    public
}
