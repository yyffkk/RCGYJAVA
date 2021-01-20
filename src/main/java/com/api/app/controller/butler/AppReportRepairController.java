package com.api.app.controller.butler;

import com.api.app.service.butler.AppReportRepairService;
import com.api.model.app.UserIdAndRepairId;
import com.api.model.butlerService.ReportRepair;
import com.api.vo.app.AppConvenientTelephoneVo;
import com.api.vo.app.AppReportRepairVo;
import com.api.vo.basicArchives.VoIds;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    /**
     * app根据用户id和报事报修主键id查询报事报修详情
     * @param userIdAndRepairId 用户id和报事报修主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(UserIdAndRepairId userIdAndRepairId){
        return appReportRepairService.findById(userIdAndRepairId);
    }

    /**
     * app提交报事报修信息
     * @param reportRepair  报事报修model insert
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody ReportRepair reportRepair, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //从request获取用户联系方式
        String tel = request.getParameter("tel");
        return appReportRepairService.insert(reportRepair,id,tel);
    }

    /**
     * 批量删除报事报修信息（业主端）
     * @param ids 报事报修主键id数组
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/falseDelete")
    public Map<String,Object> falseDelete(@RequestBody VoIds ids,HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        return appReportRepairService.falseDelete(ids.getIds(),id);
    }

    /**
     * 取消订单
     * @param userIdAndRepairId 用户id和报事报修主键id
     * @return map
     */
    @GetMapping("/cancel")
    public Map<String,Object> cancel(UserIdAndRepairId userIdAndRepairId,String name){
        return appReportRepairService.cancel(userIdAndRepairId,name);
    }



}
