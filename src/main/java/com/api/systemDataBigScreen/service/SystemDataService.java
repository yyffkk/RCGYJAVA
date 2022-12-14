package com.api.systemDataBigScreen.service;

import com.api.model.operationManagement.SysNewsManagement;
import com.api.model.systemDataBigScreen.*;
import com.api.vo.operationManagement.VoGreenTask;
import com.api.vo.systemDataBigScreen.*;

import java.util.List;
import java.util.Map;

public interface SystemDataService {
    Map<String, Object> findNowAddNum(DispatchListSearch dispatchListSearch);

    Map<String, Object> findNowSolveNum(DispatchListSearch dispatchListSearch);

    Map<String, Object> sysDispatchList();

    List<SDUserVisitorsVo> userVisitorsList();

    List<SDSysAdviceVo> sysAdviceList();

    List<SDSysAnnouncementVo> sysAnnouncementList();

    Map<String, Object> sysEstate();

    Map<String, Object> sysParkingSpace();

    Map<String, Object> sysCar();

    Map<String, Object> userResident();

    Map<String, Object> sysDailyPayment();

    Map<String, Object> findDailyActivity(DailyActivitySearch dailyActivitySearch);

    Map<String, Object> findAllInspector();

    Map<String, Object> findTodayExecute();

    List<SDInspectionExecuteVo> findNowExecute();

    List<SDInspectionRecordVo> findAllInspectionRecord();

    Map<String, Object> findAllInspectionRoute();

    Map<String, Object> findExecuteByRoute(Integer routeId);

    Map<String, Object> findPointByExecuteId(Integer executeId);

    SDReportDispatchAllVo findReportDispatch();

    Map<String, Object> findArticleBorrow();

    Map<String, Object> findActivity();

    Map<String, Object> findDailyPayment();

    Map<String, Object> findVisitorInfo();

    Map<String, Object> findVisitorInfoMonth();

    Map<String, Object> pushAlert(FirePushAlert firePushAlert);

    Map<String, Object> PlanPushAlert(PlanPushAlert planPushAlert);

    Map<String, Object> findRegCount();

    List<VoGreenTask> findGreenTaskList();

    Map<String, Object> findArticleOutInfo();

    List<SDVoteInfoVo> findVoteInfo();

    Map<String, Object> findShopAppointmentNum();

    Map<String, Object> insertNews(SysNewsManagement sysNewsManagement);

    Map<String, Object> findExcessiveWorkOrderUserName(Integer threshold);

    Map<String, Object> findExcessiveGreenTaskUserName(Integer threshold);

    Map<String, Object> findBorrowExceedWeek();

    Map<String, Object> findUnpaidUserInfo();

    Map<String, Object> sysInspectionCheckItems();

    Map<String, Object> sysInspectionExecute();

    Map<String, Object> sysInspectionExecuteCheckItems();

    Map<String, Object> sysInspectionExecuteMap();

    Map<String, Object> sysInspectionExecutePoint();

    Map<String, Object> sysInspectionPlan();

    Map<String, Object> sysInspectionPoint();

    Map<String, Object> sysInspectionPointRoute();

    Map<String, Object> sysInspectionRoute();

    Map<String, Object> userVisitorsNew();

    Map<String, Object> sysMeterReadingRecord();

    Map<String, Object> sysMeterReadingShare();

    Map<String, Object> sysMeterReadingShareDetails();

    List<SDTSActivityVo> findActivityTouchScreen();

    List<SDTSAnnouncementVo> sysAnnouncementTouchScreen();

    Map<String, Object> sysNewCategoryTouchScreen();

    List<SDTSNewVo> sysNewTouchScreen(Integer newCategoryId);

    Map<String, Object> sysNewLatestReleaseTouchScreen(Integer num);

    Map<String, Object> searchTouchScreen(SearchTouchScreenSearch searchTouchScreenSearch);

}
