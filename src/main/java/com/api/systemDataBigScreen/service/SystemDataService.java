package com.api.systemDataBigScreen.service;

import com.api.vo.systemDataBigScreen.SDSysAdviceVo;
import com.api.vo.systemDataBigScreen.SDSysAnnouncementVo;

import java.util.List;
import java.util.Map;

public interface SystemDataService {
    Map<String, Object> sysDispatchList();

    List<SDSysAdviceVo> sysAdviceList();

    List<SDSysAnnouncementVo> sysAnnouncementList();

    Map<String, Object> sysEstate();

    Map<String, Object> sysParkingSpace();

    Map<String, Object> sysCar();


}
