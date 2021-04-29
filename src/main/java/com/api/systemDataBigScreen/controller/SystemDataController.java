package com.api.systemDataBigScreen.controller;

import com.api.model.systemDataBigScreen.DailyActivitySearch;
import com.api.model.systemDataBigScreen.DispatchListSearch;
import com.api.systemDataBigScreen.service.SystemDataService;
import com.api.vo.app.AppActivityVo;
import com.api.vo.butlerApp.ButlerBorrowVo;
import com.api.vo.butlerApp.ButlerTypeAndBorrowListVo;
import com.api.vo.systemDataBigScreen.*;
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
     * 查询每日新增的报修单数量
     * @param dispatchListSearch 报修单搜索条件
     * @return map
     */
    @GetMapping("/findNowAddNum")
    public Map<String,Object> findNowAddNum(DispatchListSearch dispatchListSearch){
        return systemDataService.findNowAddNum(dispatchListSearch);
    }

    /**
     * 查询每日解决的报修单数量
     * @param dispatchListSearch 报修单搜索条件
     * @return map
     */
    @GetMapping("/findNowSolveNum")
    public Map<String,Object> findNowSolveNum(DispatchListSearch dispatchListSearch){
        return systemDataService.findNowSolveNum(dispatchListSearch);
    }

    /**
     * 查询派工单报修信息集合（当前待分配/处理中报修单数量）
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
     * 查询公告信息集合（发布时间、标题、内容）
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

    /**
     * 查询所有的巡更人员
     * @return map
     */
    @GetMapping("/findAllInspector")
    public Map<String,Object> findAllInspector(){
        return systemDataService.findAllInspector();
    }

    /**
     * 查询今日巡更执行计划
     * @return map
     */
    @GetMapping("/findTodayExecute")
    public Map<String,Object> findTodayExecute(){
        return systemDataService.findTodayExecute();
    }

    /**
     * 查询今日当前巡更执行计划（含分页）
     * @return map
     */
    @GetMapping("/findNowExecute")
    public Map<String,Object> findNowExecute(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<SDInspectionExecuteVo> executeVos = systemDataService.findNowExecute();
        PageInfo<SDInspectionExecuteVo> pageInfo = new PageInfo<>(executeVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询所有的巡更记录（含分页）
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/findAllInspectionRecord")
    public Map<String,Object> findAllInspectionRecord(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<SDInspectionRecordVo> inspectionRecordVos = systemDataService.findAllInspectionRecord();
        PageInfo<SDInspectionRecordVo> pageInfo = new PageInfo<>(inspectionRecordVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询报修工单信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/findReportDispatch")
    public Map<String,Object> findReportDispatch(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        SDReportDispatchAllVo sdReportDispatchAllVo = systemDataService.findReportDispatch();
        PageInfo<SDReportDispatchVo> pageInfo = new PageInfo<>(sdReportDispatchAllVo.getReportDispatchVoList());
        Map<String,Object> map = new HashMap<>();
        //已处理数量
        map.put("handledNum",sdReportDispatchAllVo.getHandledNum());
        //未处理数量
        map.put("pendingNum",sdReportDispatchAllVo.getPendingNum());
        //公区报修数量
        map.put("publicTypeNum",sdReportDispatchAllVo.getPublicTypeNum());
        //家庭报修数量
        map.put("familyTypeNum",sdReportDispatchAllVo.getFamilyTypeNum());
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询物品借还信息
     * @return map
     */
    @GetMapping("/findArticleBorrow")
    public Map<String,Object> findArticleBorrow(){
        return systemDataService.findArticleBorrow();
    }

    /**
     * 查询社区活动信息
     * @return map
     */
    @GetMapping("/findActivity")
    public Map<String,Object> findActivity(){
        return systemDataService.findActivity();
    }


//    public Map<String,Object> find



}
