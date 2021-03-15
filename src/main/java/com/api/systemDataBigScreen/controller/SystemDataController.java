package com.api.systemDataBigScreen.controller;

import com.api.model.systemDataBigScreen.DailyActivitySearch;
import com.api.systemDataBigScreen.service.SystemDataService;
import com.api.vo.app.AppActivityVo;
import com.api.vo.systemDataBigScreen.SDSysAdviceVo;
import com.api.vo.systemDataBigScreen.SDSysAnnouncementVo;
import com.api.vo.systemDataBigScreen.SDUserVisitorsVo;
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
 * 系统数据
 */
@RestController
@RequestMapping("/systemData")
public class SystemDataController {
    @Resource
    SystemDataService systemDataService;

    /**
     * 查询派工单报修信息集合（每日新增/解决报修单的数量、当前待分配/处理中报修单数量）
     * @return map
     */
    @GetMapping("/sysDispatchList")
    public Map<String,Object> sysDispatchList(){
        return systemDataService.sysDispatchList();
    }

    /**
     * 查询访客记录信息集合（预计到访时间、实际到访时间、访客姓名、手机号、邀请人姓名、房间号【楼栋号-单元号-房产号】）
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/userVisitorsList")
    public Map<String,Object> userVisitorsList(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<SDUserVisitorsVo> sdUserVisitorsVos =systemDataService.userVisitorsList();
        PageInfo<SDUserVisitorsVo> pageInfo = new PageInfo<>(sdUserVisitorsVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 查询投诉表扬信息集合（创建时间、类型、内容）
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/sysAdviceList")
    public Map<String,Object> sysAdviceList(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<SDSysAdviceVo> sdSysAdviceVos =systemDataService.sysAdviceList();
        PageInfo<SDSysAdviceVo> pageInfo = new PageInfo<>(sdSysAdviceVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询公共资讯信息集合（发布时间、标题、内容）
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/sysAnnouncementList")
    public Map<String,Object> sysAnnouncementList(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<SDSysAnnouncementVo> sdSysAnnouncementVos =systemDataService.sysAnnouncementList();
        PageInfo<SDSysAnnouncementVo> pageInfo = new PageInfo<>(sdSysAnnouncementVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询日活跃（搜索条件，范围搜索）
     * @param dailyActivitySearch 日活跃搜索条件
     * @return map
     */
    @GetMapping("/findDailyActivity")
    public Map<String,Object> findDailyActivity(DailyActivitySearch dailyActivitySearch){
        return systemDataService.findDailyActivity(dailyActivitySearch);
    }

    /**
     * 基础数据:(楼栋数、房屋总数、已入住房屋数)
     * @return map
     */
    @GetMapping("/sysEstate")
    public Map<String,Object> sysEstate(){
        return systemDataService.sysEstate();
    }

    /**
     * 基础数据:(车位总数、已售车位数、已租车位数)
     * @return map
     */
    @GetMapping("/sysParkingSpace")
    public Map<String,Object> sysParkingSpace(){
        return systemDataService.sysParkingSpace();
    }

    /**
     * 基础数据:(登记车辆总数)
     * @return map
     */
    @GetMapping("/sysCar")
    public Map<String,Object> sysCar(){
        return systemDataService.sysCar();
    }

    /**
     * 查询住户信息（业主数量、租户数量）
     * @return map
     */
    @GetMapping("/userResident")
    public Map<String,Object> userResident(){
        return systemDataService.userResident();
    }

    /**
     * 查询日常缴费信息（今年应缴物业费总户数/总金额，已交物业费总户数/总金额，未交物业费总户数/总金额）
     * @return map
     */
    @GetMapping("/sysDailyPayment")
    public Map<String,Object> sysDailyPayment(){
        return systemDataService.sysDailyPayment();
    }


}
