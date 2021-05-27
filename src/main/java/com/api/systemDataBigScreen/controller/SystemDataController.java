package com.api.systemDataBigScreen.controller;

import com.api.butlerApp.service.jurisdiction.ButlerInspectionService;
import com.api.manage.service.butlerService.SysFacilitiesAppointmentService;
import com.api.model.butlerService.SearchFacilitiesAppointment;
import com.api.model.operationManagement.SysNewsManagement;
import com.api.model.systemDataBigScreen.DailyActivitySearch;
import com.api.model.systemDataBigScreen.DispatchListSearch;
import com.api.model.systemDataBigScreen.FirePushAlert;
import com.api.systemDataBigScreen.service.SystemDataService;
import com.api.vo.app.AppActivityVo;
import com.api.vo.butlerApp.ButlerBorrowVo;
import com.api.vo.butlerApp.ButlerTypeAndBorrowListVo;
import com.api.vo.butlerService.VoFacilitiesAppointment;
import com.api.vo.operationManagement.VoGreenTask;
import com.api.vo.systemDataBigScreen.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统数据（第三方对外接口）
 */
@RestController
@RequestMapping("/systemData")
public class SystemDataController {
    @Resource
    SystemDataService systemDataService;
    @Resource
    SysFacilitiesAppointmentService facilitiesAppointmentService;

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
     * 基础数据:(楼栋数、房屋总数、已入住房屋数,各楼栋入住数信息)
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
     * 查询日常缴费信息【物业费+日常费用】（今年应缴物业费总户数/总金额，已交物业费总户数/总金额，未交物业费总户数/总金额）
     * @return map
     */
    @GetMapping("/sysDailyPayment")
    public Map<String,Object> sysDailyPayment(){
        return systemDataService.sysDailyPayment();
    }

    /**
     * 查询所有的巡更人员（左上角）
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
     * 查询所有的巡更记录（左下角）
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
     * 查询所有的巡检路线（右上角显示）
     * @return map
     */
    @GetMapping("/findAllInspectionRoute")
    public Map<String,Object> findAllInspectionRoute(){
        return systemDataService.findAllInspectionRoute();
    }

    /**
     * 根据巡检路线主键id查询巡检执行计划信息（右下角显示）
     * @param routeId 巡检路线主键id
     * @return 巡检执行计划信息
     */
    @GetMapping("/findExecuteByRoute")
    public Map<String,Object> findExecuteByRoute(Integer routeId){
        return systemDataService.findExecuteByRoute(routeId);
    }


    /**
     * 根据执行计划主键id查询巡检点信息（右下角查看按钮）
     * @param executeId 执行计划主键id
     * @return map
     */
    @GetMapping("/findPointByExecuteId")
    public Map<String,Object> findPointByExecuteId(Integer executeId){
        return systemDataService.findPointByExecuteId(executeId);
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

//    /**
//     * 查询日常缴费信息（暂时不用）【物业费加日常费用】
//     * @return map
//     */
//    @GetMapping("/findDailyPayment")
//    public Map<String,Object> findDailyPayment(){
//        return systemDataService.findDailyPayment();
//    }

    /**
     * 查询访客信息(一周内数据)
     * @return map
     */
    @GetMapping("/findVisitorInfo")
    public Map<String,Object> findVisitorInfo(){
        return systemDataService.findVisitorInfo();
    }

    /**
     * 查询访客信息(12个月内的数据，不包含本月)
     * @return map
     */
    @GetMapping("/findVisitorInfoMonth")
    public Map<String,Object> findVisitorInfoMonth(){
        return systemDataService.findVisitorInfoMonth();
    }

    /**
     * 查询所有的设施预约信息（包含搜索条件）【与后台list 调用同一个service】
     * @param searchFacilitiesAppointment 设施预约管理 搜索条件
     * @return map
     */
    @GetMapping("/findFacilitiesAppointment")
    public Map<String,Object> list(SearchFacilitiesAppointment searchFacilitiesAppointment){
        PageHelper.startPage(searchFacilitiesAppointment.getPageNum(),searchFacilitiesAppointment.getSize());
        List<VoFacilitiesAppointment> voFacilitiesAppointmentList = facilitiesAppointmentService.list(searchFacilitiesAppointment);
        PageInfo<VoFacilitiesAppointment> pageInfo = new PageInfo<>(voFacilitiesAppointmentList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询app注册数
     * @return map
     */
    @GetMapping("/findRegCount")
    public Map<String,Object> findRegCount(){
        return systemDataService.findRegCount();
    }

    /**
     * 推送火灾通知
     * @param firePushAlert 火灾推送通知内容
     * @return map
     */
    @PostMapping("/firePushAlert")
    public Map<String,Object> firePushAlert(@RequestBody FirePushAlert firePushAlert){
        return systemDataService.pushAlert(firePushAlert);
    }


    /**
     * 查询所有的绿化管理情况
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/findGreenList")
    public Map<String,Object> findGreenTaskList(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<VoGreenTask> voGreenTaskList = systemDataService.findGreenTaskList();
        PageInfo<VoGreenTask> pageInfo = new PageInfo<>(voGreenTaskList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询物品出门事项统计
     * @return map
     */
    @GetMapping("/findArticleOutInfo")
    public Map<String,Object> findArticleOutInfo(){
        return systemDataService.findArticleOutInfo();
    }

    /**
     * 查询投票信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/findVoteInfo")
    public Map<String,Object> findVoteInfo(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<SDVoteInfoVo> sdVoteInfoVoList = systemDataService.findVoteInfo();
        PageInfo<SDVoteInfoVo> pageInfo = new PageInfo<>(sdVoteInfoVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询商场各分类下报名统计
     * @return map
     */
    @GetMapping("/findShopAppointmentNum")
    public Map<String,Object> findShopAppointmentNum(){
        return systemDataService.findShopAppointmentNum();
    }

    /***
     * 查询工单超量的用户（报事报修）
     * @param threshold 阀值
     * @return map
     */
    @GetMapping("/findExcessiveWorkOrderUserName")
    public Map<String,Object> findExcessiveWorkOrderUserName(Integer threshold){
        return systemDataService.findExcessiveWorkOrderUserName(threshold);
    }

    /***
     * 查询工单超量的用户（绿化任务）
     * @param threshold 阀值
     * @return map
     */
    @GetMapping("/findExcessiveGreenTaskUserName")
    public Map<String,Object> findExcessiveGreenTaskUserName(Integer threshold){
        return systemDataService.findExcessiveGreenTaskUserName(threshold);
    }


    /**
     * 第三方 添加资讯信息
     * @param sysNewsManagement 资讯信息
     * @return map
     */
    @PostMapping("/insertNews")
    public Map<String,Object> insertNews(@RequestBody SysNewsManagement sysNewsManagement){
        return systemDataService.insertNews(sysNewsManagement);
    }

    /***
     * 查询借还物品时间超出一周的用户及相关信息
     * @return map
     */
    @GetMapping("/findBorrowExceedWeek")
    public Map<String,Object> findBorrowExceedWeek(){
        return systemDataService.findBorrowExceedWeek();
    }

}
