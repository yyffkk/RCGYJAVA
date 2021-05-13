package com.api.systemDataBigScreen.service;

import com.api.model.systemDataBigScreen.DailyActivitySearch;
import com.api.model.systemDataBigScreen.DispatchListSearch;
import com.api.model.systemDataBigScreen.FirePushAlert;
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

    Map<String, Object> pushAlert(FirePushAlert firePushAlert);

    Map<String, Object> findRegCount();


    List<VoGreenTask> findGreenTaskList();

}
