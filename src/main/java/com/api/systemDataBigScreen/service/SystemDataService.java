package com.api.systemDataBigScreen.service;

import com.api.model.systemDataBigScreen.DailyActivitySearch;
import com.api.model.systemDataBigScreen.DispatchListSearch;
import com.api.vo.systemDataBigScreen.SDSysAdviceVo;
import com.api.vo.systemDataBigScreen.SDSysAnnouncementVo;
import com.api.vo.systemDataBigScreen.SDUserVisitorsVo;

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

}
