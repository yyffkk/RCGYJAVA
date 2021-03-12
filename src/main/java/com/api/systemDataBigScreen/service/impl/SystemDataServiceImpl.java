package com.api.systemDataBigScreen.service.impl;

import com.api.systemDataBigScreen.dao.SystemDataDao;
import com.api.systemDataBigScreen.service.SystemDataService;
import com.api.vo.systemDataBigScreen.SDSysAdviceVo;
import com.api.vo.systemDataBigScreen.SDSysAnnouncementVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SystemDataServiceImpl implements SystemDataService {
    @Resource
    SystemDataDao systemDataDao;
    private static Map<String,Object> map = null;

    @Override
    public Map<String, Object> sysDispatchList() {
        map = new HashMap<>();
        Date date = new Date();
        //当日新增报修单数量
        int nowAddNum = systemDataDao.findNowAddNum(date);
        //当日解决报修单数量
        int nowSolveNum = systemDataDao.findNowSolveNum(date);
        //待分配报修单数量
        int noDistributionNum = systemDataDao.findNoDistributionNum();
        //处理中报修单数量
        int processingNum = systemDataDao.findProcessingNum();
        map.put("nowAddNum",nowAddNum);
        map.put("nowSolveNum",nowSolveNum);
        map.put("noDistributionNum",noDistributionNum);
        map.put("processingNum",processingNum);
        return map;
    }

    @Override
    public List<SDSysAdviceVo> sysAdviceList() {
        return systemDataDao.sysAdviceList();
    }

    @Override
    public List<SDSysAnnouncementVo> sysAnnouncementList() {
        return systemDataDao.sysAnnouncementList();
    }

    @Override
    public Map<String, Object> sysEstate() {
        map = new HashMap<>();
        //楼栋数
        int buildingNum = systemDataDao.findBuildingNum();
        //房屋总数
        int estateNum = systemDataDao.findEstateNum();
        //已入住房屋数
        int checkInEstateNum = systemDataDao.findCheckInEstateNum();
        map.put("buildingNum",buildingNum);
        map.put("estateNum",estateNum);
        map.put("checkInEstateNum",checkInEstateNum);
        return map;
    }

    @Override
    public Map<String, Object> sysParkingSpace() {
        map = new HashMap<>();
        //车位总数
        int parkingNum = systemDataDao.findParkingNum();
        //已售车位数,1.已售
        int soldParkingNum = systemDataDao.findSoldParkingParkingNum();
        //已租车位数,2.已出租
        int rentedParkingNum = systemDataDao.findRentedParkingNum();
        map.put("parkingNum",parkingNum);
        map.put("soldParkingNum",soldParkingNum);
        map.put("rentedParkingNum",rentedParkingNum);
        return map;
    }

    @Override
    public Map<String, Object> sysCar() {
        map = new HashMap<>();
        //登记车辆总数
        int carNum = systemDataDao.findUserCar();
        map.put("carNum",carNum);
        return map;
    }

}
