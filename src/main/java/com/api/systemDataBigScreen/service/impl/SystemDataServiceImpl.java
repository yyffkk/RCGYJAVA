package com.api.systemDataBigScreen.service.impl;

import com.alibaba.fastjson.JSON;
import com.api.manage.dao.operationManagement.SysNewsCategoryManagementDao;
import com.api.manage.dao.operationManagement.SysNewsManagementDao;
import com.api.model.operationManagement.SysNewsManagement;
import com.api.model.systemDataBigScreen.*;
import com.api.systemDataBigScreen.dao.SystemDataDao;
import com.api.systemDataBigScreen.service.SystemDataService;
import com.api.util.IdWorker;
import com.api.util.UploadUtil;
import com.api.util.webSocket.WebSocketService;
import com.api.util.webSocket.WebSocketServiceApp;
import com.api.util.webSocket.WebSocketServiceButlerApp;
import com.api.vo.operationManagement.VoGreenTask;
import com.api.vo.resources.VoResourcesImg;
import com.api.vo.systemDataBigScreen.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class SystemDataServiceImpl implements SystemDataService {
    @Resource
    SystemDataDao systemDataDao;
    @Resource
    SysNewsManagementDao sysNewsManagementDao;
    @Resource
    SysNewsCategoryManagementDao sysNewsCategoryManagementDao;
    private static Map<String,Object> map = null;

    @Override
    public Map<String, Object> findNowAddNum(DispatchListSearch dispatchListSearch) {
        map = new HashMap<>();
        //当日新增报修单数量
        List<SDDispatchNumListVo> nowAddNums = systemDataDao.findNowAddNum(dispatchListSearch);
        map.put("data",nowAddNums);
        return map;
    }

    @Override
    public Map<String, Object> findNowSolveNum(DispatchListSearch dispatchListSearch) {
        map = new HashMap<>();
        //当日解决报修单数量
        List<SDDispatchNumListVo> nowSolveNums = systemDataDao.findNowSolveNum(dispatchListSearch);
        map.put("data",nowSolveNums);
        return map;
    }

    @Override
    public Map<String, Object> sysDispatchList() {
        map = new HashMap<>();
        //待分配报修单数量
        int noDistributionNum = systemDataDao.findNoDistributionNum();
        //处理中报修单数量
        int processingNum = systemDataDao.findProcessingNum();
        map.put("noDistributionNum",noDistributionNum);
        map.put("processingNum",processingNum);
        return map;
    }

    @Override
    public List<SDUserVisitorsVo> userVisitorsList() {
        return systemDataDao.userVisitorsList();
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
        //各楼栋入住数信息
        List<SDOccupancyRateVo> occupancyRateVoList = systemDataDao.findOccupancyRate();

        map.put("buildingNum",buildingNum);
        map.put("estateNum",estateNum);
        map.put("checkInEstateNum",checkInEstateNum);
        map.put("occupancyRateVoList",occupancyRateVoList);
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

    @Override
    public Map<String, Object> userResident() {
        map = new HashMap<>();
        //查询业主数量,1.业主
        int residentNum = systemDataDao.findResidentNum();
        //查询租户数量,3.租户
        int tenantNum = systemDataDao.findTenantNum();
        map.put("residentNum",residentNum);
        map.put("tenantNum",tenantNum);
        return map;
    }

    @Override
    public Map<String, Object> sysDailyPayment() {
        map = new HashMap<>();
        Date date = new Date();
        //查询今年应缴物业费总户数
        int thisYearPayableNum = systemDataDao.findThisYearPayableNum(date);
        //查询今年应缴物业费总金额
        BigDecimal thisYearPayablePrice = systemDataDao.findThisYearPayablePrice(date);
        //查询已缴物业费总户数[今年]
        int paidNum = systemDataDao.findPaidNum(date);
        //查询已缴物业费总金额[今年]
        BigDecimal paidPrice = systemDataDao.findPaidPrice(date);
        //查询未缴物业费总户数[今年]
        int unPaidNum = systemDataDao.findUnPaidNum(date);
        //查询未缴物业费总金额[今年]
        BigDecimal unPaidPrice = systemDataDao.findUnPaidPrice(date);
        //系统数据 日常缴费未缴费住户数量和年份和月份【查询日常缴费未缴费住户数量（最近6个月，每月信息数量）】
        List<SDCountAndDate> sixMonthUnPaidNum = systemDataDao.findSixMonthUnPaidNum();

        map.put("thisYearPayableNum",thisYearPayableNum);
        map.put("thisYearPayablePrice",thisYearPayablePrice);
        map.put("paidNum",paidNum);
        map.put("paidPrice",paidPrice);
        map.put("unPaidNum",unPaidNum);
        map.put("unPaidPrice",unPaidPrice);
        map.put("sixMonthUnPaidNum",sixMonthUnPaidNum);
        return map;
    }

    @Override
    public Map<String, Object> findDailyActivity(DailyActivitySearch dailyActivitySearch) {
        map = new HashMap<>();
        //根据搜索条件 查询日活跃
        List<SDDailyActivityVo> sdDailyActivityVos = systemDataDao.findDailyActivity(dailyActivitySearch);
        map.put("data",sdDailyActivityVos);
        return map;
    }

    @Override
    public Map<String, Object> findAllInspector() {
        map = new HashMap<>();
        //查询所有的巡更人员
        List<SDInspectionSysUserVo> inspectionSysUserVoList = systemDataDao.findAllInspector();
        if (inspectionSysUserVoList != null && inspectionSysUserVoList.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (SDInspectionSysUserVo sysUserVo : inspectionSysUserVoList) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysUser", sysUserVo.getId(), "headSculpture");
                sysUserVo.setImgList(imgByDate);
            }
        }
        map.put("data",inspectionSysUserVoList);
        return map;
    }

    @Override
    public Map<String, Object> findTodayExecute() {
        map = new HashMap<>();
        Date date = new Date();
        List<SDInspectionExecuteListVo> inspectionExecuteListVoList = systemDataDao.findTodayExecute(date);
        if (inspectionExecuteListVoList != null && inspectionExecuteListVoList.size()>0){
            for (SDInspectionExecuteListVo inspectionExecuteListVo : inspectionExecuteListVoList) {
                //判断实际开始时间是否为null
                if (inspectionExecuteListVo.getActualBeginDate() != null){
                    //判断实际结束时间是否为null
                    if (inspectionExecuteListVo.getActualEndDate() != null){
                        inspectionExecuteListVo.setStatus(2); //实际开始时间与实际结束时间都不为null，2.已巡检
                    }else {
                        inspectionExecuteListVo.setStatus(3); //实际开始时间不为null,实际结束时间为null，3.巡检中
                    }
                }else {
                    //判断实际结束时间是否为null
                    if (inspectionExecuteListVo.getActualEndDate() != null){
                        inspectionExecuteListVo.setStatus(4); //实际开始时间为null,实际结束时间不为null，4.未巡检
                    }else {
                        //实际开始时间与实际结束时间都为null，1.待巡检
                        inspectionExecuteListVo.setStatus(1);
                    }
                }
            }
        }
        map.put("data",inspectionExecuteListVoList);
        return map;
    }

    @Override
    public List<SDInspectionExecuteVo> findNowExecute() {
        Date date = new Date();
        List<SDInspectionExecuteVo> inspectionExecuteVoList = systemDataDao.findNowExecute(date);
        if (inspectionExecuteVoList != null && inspectionExecuteVoList.size()>0){
            for (SDInspectionExecuteVo inspectionExecuteVo : inspectionExecuteVoList) {
                //判断实际开始时间是否为null
                if (inspectionExecuteVo.getActualBeginDate() != null){
                    //判断实际结束时间是否为null
                    if (inspectionExecuteVo.getActualEndDate() != null){
                        inspectionExecuteVo.setStatus(2); //实际开始时间与实际结束时间都不为null，2.已巡检
                    }else {
                        inspectionExecuteVo.setStatus(3); //实际开始时间不为null,实际结束时间为null，3.巡检中
                    }
                }else {
                    //判断实际结束时间是否为null
                    if (inspectionExecuteVo.getActualEndDate() != null){
                        inspectionExecuteVo.setStatus(4); //实际开始时间为null,实际结束时间不为null，4.未巡检
                    }else {
                        //实际开始时间与实际结束时间都为null，1.待巡检
                        inspectionExecuteVo.setStatus(1);
                    }
                }

                List<SDInspectionExecutePointVo> executePointVos =null;
                //如果实际开始实际为null，查询执行计划的巡检点，反之，查询计划的巡检点
                if (inspectionExecuteVo.getActualBeginDate() != null){
                    //根据巡检执行计划主键id查询执行计划的巡检点（开始巡检后的巡检点信息）
                    executePointVos = systemDataDao.findExecutePointByExecuteId(inspectionExecuteVo.getId());
                }else {
                    //根据巡检执行计划主键id查询计划的巡检点（开始巡检前的巡检点信息）
                    executePointVos = systemDataDao.findPlanPointByExecuteId(inspectionExecuteVo.getId());
                }
                inspectionExecuteVo.setExecutePointVos(executePointVos);

                //巡检执行路线经纬度
                List<SDInspectionExecuteMapVo> executeMapVoList = systemDataDao.findAllLocation(inspectionExecuteVo.getId());
                inspectionExecuteVo.setExecuteMapVos(executeMapVoList);
            }
        }
        return inspectionExecuteVoList;
    }

    @Override
    public List<SDInspectionRecordVo> findAllInspectionRecord() {
        List<SDInspectionRecordVo> inspectionRecordVos = systemDataDao.findAllInspectionRecord();
//        if (inspectionRecordVos != null && inspectionRecordVos.size()>0){
//            for (SDInspectionRecordVo inspectionRecordVo : inspectionRecordVos) {
//                List<SDInspectionExecutePointVo> executePointVos =null;
//                //如果实际开始实际为null，查询执行计划的巡检点，反之，查询计划的巡检点
//                if (inspectionRecordVo.getActualBeginDate() != null){
//                    //根据巡检执行计划主键id查询执行计划的巡检点（开始巡检后的巡检点信息）
//                    executePointVos = systemDataDao.findExecutePointByExecuteId(inspectionRecordVo.getId());
//                }else {
//                    //根据巡检执行计划主键id查询计划的巡检点（开始巡检前的巡检点信息）
//                    executePointVos = systemDataDao.findPlanPointByExecuteId(inspectionRecordVo.getId());
//                }
//                inspectionRecordVo.setPointVoList(executePointVos);
//            }
//        }
        return inspectionRecordVos;
    }

    @Override
    public Map<String, Object> findAllInspectionRoute() {
        map = new HashMap<>();
        List<SDInspectionRouteVo> sdInspectionRouteVoList = systemDataDao.findAllInspectionRoute();
        map.put("data",sdInspectionRouteVoList);
        return map;
    }

    @Override
    public Map<String, Object> findExecuteByRoute(Integer routeId) {
        map = new HashMap<>();
        List<SDInspectionExecutePlanVo> sdInspectionExecutePlanVos = systemDataDao.findExecuteByRoute(routeId);
        map.put("data",sdInspectionExecutePlanVos);
        return map;
    }

    @Override
    public Map<String, Object> findPointByExecuteId(Integer executeId) {
        map = new HashMap<>();
//        List<SDInspectionExecutePointVo> sdInspectionExecutePointVos = null;
//
//        //根据执行计划主键id查询执行计划信息
//        SDInspectionExecuteListVo sdInspectionExecuteListVo = systemDataDao.findExecuteByExecuteId(executeId);
//        if (sdInspectionExecuteListVo == null){
//            map.put("data",null);
//            map.put("message","执行计划不存在");
//            map.put("status",false);
//            return map;
//        }else {
//            if (sdInspectionExecuteListVo.getActualBeginDate() != null){
//                //根据执行计划主键id查询巡检后的巡检点信息(巡检后的巡检点)
//                sdInspectionExecutePointVos = systemDataDao.findPointByExecuteIdAfter(executeId);
//            }else {
//                //根据执行计划主键id查询巡检前的巡检点信息(巡检前的巡检点)
//                sdInspectionExecutePointVos = systemDataDao.findPointByExecuteIdBefore(executeId);
//            }
//        }


        //查询所有的巡检点信息
        List<SDInspectionExecutePointAllVo> sdInspectionExecutePointAllVos = systemDataDao.findPointByExecuteIdAll();


        map.put("data",sdInspectionExecutePointAllVos);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public SDReportDispatchAllVo findReportDispatch() {
        SDReportDispatchAllVo sdReportDispatchAllVo = new SDReportDispatchAllVo();
        //查询所有的报修工单信息
        List<SDReportDispatchVo> reportDispatch = systemDataDao.findReportDispatch();
        if (reportDispatch != null && reportDispatch.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (SDReportDispatchVo dispatch : reportDispatch) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysReportRepair", dispatch.getId(), "repairImg");
                dispatch.setImgUrls(imgByDate);
            }
        }
        sdReportDispatchAllVo.setReportDispatchVoList(reportDispatch);
        //查询已处理数量
        int handledNum = systemDataDao.findHandledNum();
        sdReportDispatchAllVo.setHandledNum(handledNum);
        //查询未处理数量
        int pendingNum = systemDataDao.findPendingNum();
        sdReportDispatchAllVo.setPendingNum(pendingNum);
        //查询公区报修数量
        int publicTypeNum = systemDataDao.findPublicTypeNum();
        sdReportDispatchAllVo.setPublicTypeNum(publicTypeNum);
        //查询家庭报修数量
        int familyTypeNum = systemDataDao.findFamilyTypeNum();
        sdReportDispatchAllVo.setFamilyTypeNum(familyTypeNum);

        return sdReportDispatchAllVo;
    }

    @Override
    public Map<String, Object> findArticleBorrow() {
        map = new HashMap<>();
        SDArticleBorrowVo sdArticleBorrowVo = new SDArticleBorrowVo();
        //查询所有的物品数量
        int allArticle = systemDataDao.findAllArticle();
        //查询已借出的物品数量
        int borrowArticle = systemDataDao.findBorrowArticle();
        sdArticleBorrowVo.setBorrowArticle(borrowArticle);
        //查询已损坏的物品数量
        int breakDownArticle = systemDataDao.findBreakDownArticle();
        sdArticleBorrowVo.setBreakDownArticle(breakDownArticle);
        //查询丢失的物品数量
        int loseArticle = systemDataDao.findLoseArticle();
        sdArticleBorrowVo.setLoseArticle(loseArticle);
        int vacantArticle = allArticle - borrowArticle - breakDownArticle - loseArticle;
        sdArticleBorrowVo.setVacantArticle(vacantArticle);
        map.put("data",sdArticleBorrowVo);
        //查询空置的物品数量
        return map;
    }

    @Override
    public Map<String, Object> findActivity() {
        map = new HashMap<>();
        List<SDSysActivityVo> sdSysActivityVoList = systemDataDao.findActivity();
        map.put("data",sdSysActivityVoList);
        return map;
    }

    @Override
    public Map<String, Object> findDailyPayment() {
        map = new HashMap<>();
        //查询日常缴费未缴总费用
        int unpaidFees = systemDataDao.findAllUnpaidFees();
        //查询日常缴费已缴纳住户数量
//        int paidNum = systemDataDao.findDayPaidNum();
        //查询日常缴费未缴纳住户数量
//        int noPaidNum = systemDataDao.findNoPaidNum();
        //查询日常缴费未缴费住户数量（最近6个月，每月信息数量）

        //TODO 需要完善
        return map;
    }

    @Override
    public Map<String, Object> findVisitorInfo() {
        map = new HashMap<>();
        List<SDVisitorInfoVo> sdVisitorInfoVos = systemDataDao.findVisitorInfo();
        map.put("data",sdVisitorInfoVos);
        return map;
    }

    @Override
    public Map<String, Object> findVisitorInfoMonth() {
        map = new HashMap<>();
        List<SDVisitorInfoMonthVo> sdVisitorInfoMonthVos = systemDataDao.findVisitorInfoMonth();
        map.put("data",sdVisitorInfoMonthVos);
        return map;
    }

    @Override
    public Map<String, Object> pushAlert(FirePushAlert firePushAlert) {
        map = new HashMap<>();
        try {
            //添加记录进数据库
            int insert = systemDataDao.insertPushAlert(firePushAlert);
            if (insert <=0){
                throw new RuntimeException("添加记录失败");
            }


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sdf.format(firePushAlert.getTime());
//            String content = "于"+format+",小区内"+firePushAlert.getDeviceName()+"附近出现了火灾报警，请各位业主、租户保持镇静，不要慌乱，有序开始撤离！";

            WebSocketFirePushAlert webSocketFirePushAlert = new WebSocketFirePushAlert();
            webSocketFirePushAlert.setDeviceNo(firePushAlert.getDeviceNo());//填入设备号
            webSocketFirePushAlert.setAlarmNo(firePushAlert.getAlarmNo());//填入报警号
            webSocketFirePushAlert.setAlarmType(firePushAlert.getAlarmType());//填入数值报警，还是状态报警(C:数值报警，X:状态报警)
            webSocketFirePushAlert.setDeviceName(firePushAlert.getDeviceName());//填入设备名称
            webSocketFirePushAlert.setTime(format);//填入报警时间
            int deviceNo = Integer.parseInt(firePushAlert.getDeviceNo());
            int type = 0;
            if (deviceNo >= 3020 && deviceNo <= 3027){
                type = 1;//1.火灾报警（消防）
            }else {
                type = 2;//2.2.设备报警
            }
            webSocketFirePushAlert.setType(type);//填入报警类型：1.火灾报警（消防），2.设备报警，3.一键报警


            String content = JSON.toJSONString(webSocketFirePushAlert);
//            String content ="在"+webSocketFirePushAlert.getTime()+",设备号为"+webSocketFirePushAlert.getDeviceNo()+",设备名为"+webSocketFirePushAlert.getDeviceName()+"发送报警请求，报警号为：" +webSocketFirePushAlert.getAlarmNo();

            log.info("火灾报警："+content);
//            System.out.printf(content);
//             key:type value:1 火警
                //不使用第三方极光推送，改用websocket来实现推送
//            JiguangUtil.sendPushAll(content,"1");
//            JiguangUtil.sendButlerPushAll(content,"1");
            //web页面的websocket
            WebSocketService ws = new WebSocketService();
            ws.broadcast(content);
            if (type == 1){ //业主端只能看到火灾报警的消息，设备报警看不到
                //业主app的websocket
                WebSocketServiceApp wsApp = new WebSocketServiceApp();
                wsApp.broadcast(content);
            }
            //管家app的websocket
            WebSocketServiceButlerApp wsButlerApp = new WebSocketServiceButlerApp();
            wsButlerApp.broadcast(content);

        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","推送失败");
            map.put("status",false);
            return map;
        }
        map.put("message","推送成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> PlanPushAlert(PlanPushAlert planPushAlert) {
        map = new HashMap<>();
        try {
            //添加预案记录进数据库
            int insert = systemDataDao.insertPlanAlarm(planPushAlert);
            if (insert <=0){
                throw new RuntimeException("添加记录失败");
            }


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sdf.format(planPushAlert.getAlarmOccurrenceTime());
//            String content = "于"+format+",小区内"+firePushAlert.getDeviceName()+"附近出现了火灾报警，请各位业主、租户保持镇静，不要慌乱，有序开始撤离！";

            WebSocketFirePushAlert webSocketFirePushAlert = new WebSocketFirePushAlert();
            webSocketFirePushAlert.setDeviceName(planPushAlert.getDeviceName());//填入设备名称
            webSocketFirePushAlert.setTime(format);//填入报警发生时间
            webSocketFirePushAlert.setPlanContent(planPushAlert.getPlanContent());//填入预案内容
            webSocketFirePushAlert.setAlarmContent(planPushAlert.getAlarmContent());//填入报警内容
            webSocketFirePushAlert.setType(4);//填入报警类型：1.火灾报警（消防），2.设备报警，3.一键报警,4.预案报警


            String content = JSON.toJSONString(webSocketFirePushAlert);

//            String content ="在"+webSocketFirePushAlert.getTime()+",设备号为"+webSocketFirePushAlert.getDeviceNo()+",设备名为"+webSocketFirePushAlert.getDeviceName()+"发送报警请求，报警号为：" +webSocketFirePushAlert.getAlarmNo();


            log.info("预案报警："+content);
//            System.out.printf(content);
//             key:type value:1 火警
            //不使用第三方极光推送，改用websocket来实现推送
//            JiguangUtil.sendPushAll(content,"1");
//            JiguangUtil.sendButlerPushAll(content,"1");
            //web页面的websocket
            WebSocketService ws = new WebSocketService();
            ws.broadcast(content);

            //业主app的websocket
            WebSocketServiceApp wsApp = new WebSocketServiceApp();
            wsApp.broadcast(content);

            //管家app的websocket
            WebSocketServiceButlerApp wsButlerApp = new WebSocketServiceButlerApp();
            wsButlerApp.broadcast(content);

        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","推送失败");
            map.put("status",false);
            return map;
        }
        map.put("message","推送成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findRegCount() {
        map = new HashMap<>();
        int regCount = systemDataDao.findRegCount();
        map.put("data",regCount);
        return map;
    }

    @Override
    public List<VoGreenTask> findGreenTaskList() {
        return systemDataDao.findGreenTaskList();
    }

    @Override
    public Map<String, Object> findArticleOutInfo() {
        map = new HashMap<>();
        //查询待出户的数量
        int waitOutNum = systemDataDao.findWaitOutNum();
        map.put("waitOutNum",waitOutNum);
        //查询已出户的数量
        int goOutNum = systemDataDao.findGoOutNum();
        map.put("goOutNum",goOutNum);
        //查询已驳回的数量
        int rejectNum = systemDataDao.findRejectNum();
        map.put("rejectNum",rejectNum);
        return map;
    }

    @Override
    public List<SDVoteInfoVo> findVoteInfo() {
        List<SDVoteInfoVo> sdVoteInfoVoList = systemDataDao.findVoteInfo();
        if (sdVoteInfoVoList != null && sdVoteInfoVoList.size()>0){
            Date date = new Date();
            for (SDVoteInfoVo sdVoteInfoVo : sdVoteInfoVoList) {
                //查询时间是否处于投票时间
                if (date.getTime() < sdVoteInfoVo.getBeginDate().getTime()){
                    //状态为1.未开始
                    sdVoteInfoVo.setStatus(1);
                }else if (date.getTime() > sdVoteInfoVo.getEndDate().getTime()){
                    //状态为3.已结束
                    sdVoteInfoVo.setStatus(3);
                }else {
                    //状态为2.进行中
                    sdVoteInfoVo.setStatus(2);
                }
            }
        }
        return sdVoteInfoVoList;
    }

    @Override
    public Map<String, Object> findShopAppointmentNum() {
        map = new HashMap<>();
        List<SDShopAppointmentNumVo> sdShopAppointmentNumVoList = systemDataDao.findShopAppointmentNum();
        map.put("data",sdShopAppointmentNumVoList);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> insertNews(SysNewsManagement sysNewsManagement) {
        map = new HashMap<>();
        try {
            sysNewsManagement.setCode(String.valueOf(new IdWorker(1,1,1).nextId()));
            sysNewsManagement.setCreateId(-1);
            sysNewsManagement.setCreateDate(new Date());

            int insert = sysNewsManagementDao.insert(sysNewsManagement);
            if (insert <=0){
                throw new RuntimeException("添加失败");
            }
            //添加照片
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(sysNewsManagement.getImgUrls(),"sysNews",sysNewsManagement.getId(),"newsImg","600",20,30);

            //对资讯分类的资讯数量进行累加
            int update = sysNewsCategoryManagementDao.incNum(sysNewsManagement.getNewsCategoryId());
            if (update <= 0){
                throw new RuntimeException("累加失败");
            }


        } catch (Exception e) {
            //获取抛出的信息
            String message = e.getMessage();
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message",message);
            map.put("status",false);
            return map;
        }
        map.put("message","添加成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findExcessiveWorkOrderUserName(Integer threshold) {
        map = new HashMap<>();
        List<String> names = systemDataDao.findExcessiveWorkOrderUserName(threshold);

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",names);
        return map;
    }

    @Override
    public Map<String, Object> findExcessiveGreenTaskUserName(Integer threshold) {
        map = new HashMap<>();
        List<String> names = systemDataDao.findExcessiveGreenTaskUserName(threshold);

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",names);
        return map;
    }

    @Override
    public Map<String, Object> findBorrowExceedWeek() {
        map = new HashMap<>();
        Date date = new Date();

        //新建集合
        ArrayList<SDBorrowExceedWeek> sdBorrowExceedWeeks = new ArrayList<>();

        List<SDBorrowExceedWeek> sdBorrowExceedWeekList = systemDataDao.findBorrowExceedWeek(date);

        if (sdBorrowExceedWeekList != null && sdBorrowExceedWeekList.size()>0){
            for (SDBorrowExceedWeek sdBorrowExceedWeek : sdBorrowExceedWeekList) {
                long hour = (new Date().getTime() - sdBorrowExceedWeek.getBeginDate().getTime())/(60*60*1000);
                sdBorrowExceedWeek.setBorrowTime(hour);
                sdBorrowExceedWeeks.add(sdBorrowExceedWeek);//添加进集合
            }
        }

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sdBorrowExceedWeeks);

        return map;
    }

    @Override
    public Map<String, Object> findUnpaidUserInfo() {
        map = new HashMap<>();
        List<SDUnpaidUserInfoVo> sdUnpaidUserInfoVoList = systemDataDao.findUnpaidUserInfo();

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sdUnpaidUserInfoVoList);

        return map;
    }

    @Override
    public Map<String, Object> sysInspectionCheckItems() {
        map = new HashMap<>();
        List<SDSysInspectionCheckItemsVo> sdSysInspectionCheckItemsVos = systemDataDao.sysInspectionCheckItems();

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sdSysInspectionCheckItemsVos);
        return map;
    }

    @Override
    public Map<String, Object> sysInspectionExecute() {
        map = new HashMap<>();
        List<SDSysInspectionExecuteVo> sdSysInspectionExecuteVos = systemDataDao.sysInspectionExecute();

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sdSysInspectionExecuteVos);
        return map;
    }

    @Override
    public Map<String, Object> sysInspectionExecuteCheckItems() {
        map = new HashMap<>();
        List<SDSysInspectionExecuteCheckItemsVo> sdSysInspectionExecuteCheckItemsVos = systemDataDao.sysInspectionExecuteCheckItems();

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sdSysInspectionExecuteCheckItemsVos);
        return map;
    }

    @Override
    public Map<String, Object> sysInspectionExecuteMap() {
        map = new HashMap<>();
        List<SDSysInspectionExecuteMapVo> sdSysInspectionExecuteMapVos = systemDataDao.sysInspectionExecuteMap();

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sdSysInspectionExecuteMapVos);
        return map;
    }

    @Override
    public Map<String, Object> sysInspectionExecutePoint() {
        map = new HashMap<>();
        List<SDSysInspectionExecutePointVo> sdSysInspectionExecutePointVos = systemDataDao.sysInspectionExecutePoint();

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sdSysInspectionExecutePointVos);
        return map;
    }

    @Override
    public Map<String, Object> sysInspectionPlan() {
        map = new HashMap<>();
        List<SDSysInspectionPlanVo> sdSysInspectionPlanVos = systemDataDao.sysInspectionPlan();

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sdSysInspectionPlanVos);
        return map;
    }

    @Override
    public Map<String, Object> sysInspectionPoint() {
        map = new HashMap<>();
        List<SDSysInspectionPointVo> sdSysInspectionPointVos = systemDataDao.sysInspectionPoint();

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sdSysInspectionPointVos);
        return map;
    }

    @Override
    public Map<String, Object> sysInspectionPointRoute() {
        map = new HashMap<>();
        List<SDSysInspectionPointRouteVo> sdSysInspectionPointRouteVos = systemDataDao.sysInspectionPointRoute();

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sdSysInspectionPointRouteVos);
        return map;
    }

    @Override
    public Map<String, Object> sysInspectionRoute() {
        map = new HashMap<>();
        List<SDSysInspectionRouteVo> sdSysInspectionRouteVos = systemDataDao.sysInspectionRoute();

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sdSysInspectionRouteVos);
        return map;
    }

    @Override
    public Map<String, Object> userVisitorsNew() {
        map = new HashMap<>();
        List<SDUserVisitorsNewVo> sdUserVisitorsNewVos = systemDataDao.userVisitorsNew();

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sdUserVisitorsNewVos);
        return map;
    }

    @Override
    public Map<String, Object> sysMeterReadingRecord() {
        map = new HashMap<>();
        List<SDSysMeterReadingRecordVo> sdSysMeterReadingRecordVoList = systemDataDao.sysMeterReadingRecord();

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sdSysMeterReadingRecordVoList);
        return map;
    }

    @Override
    public Map<String, Object> sysMeterReadingShare() {
        map = new HashMap<>();
        List<SDSysMeterReadingShareVo> sdSysMeterReadingShareVoList = systemDataDao.sysMeterReadingShare();

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sdSysMeterReadingShareVoList);
        return map;
    }

    @Override
    public Map<String, Object> sysMeterReadingShareDetails() {
        map = new HashMap<>();
        List<SDSysMeterReadingShareDetailsVo> sdSysMeterReadingShareDetailsVoList = systemDataDao.sysMeterReadingShareDetails();

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sdSysMeterReadingShareDetailsVoList);
        return map;
    }

    @Override
    public List<SDTSActivityVo> findActivityTouchScreen() {
        List<SDTSActivityVo> activityTouchScreen = systemDataDao.findActivityTouchScreen();
        if (activityTouchScreen != null && activityTouchScreen.size()>0){
            for (SDTSActivityVo sdtsActivityVo : activityTouchScreen) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysActivityManagement", sdtsActivityVo.getId(), "activityImg");
                sdtsActivityVo.setImgUrls(imgByDate);
            }
        }
        return activityTouchScreen;
    }

    @Override
    public List<SDTSAnnouncementVo> sysAnnouncementTouchScreen() {
        List<SDTSAnnouncementVo> sdtsAnnouncementVos = systemDataDao.sysAnnouncementTouchScreen();
        if (sdtsAnnouncementVos != null && sdtsAnnouncementVos.size()>0){
            for (SDTSAnnouncementVo sdtsAnnouncementVo : sdtsAnnouncementVos) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysAnnouncementManagement", sdtsAnnouncementVo.getId(), "announcementImg");
                sdtsAnnouncementVo.setImgUrls(imgByDate);
            }
        }
        return sdtsAnnouncementVos;
    }

    @Override
    public Map<String, Object> sysNewCategoryTouchScreen() {
        map = new HashMap<>();
        List<SDTSNewsCategoryVo> SDTSNewsCategoryVoList = systemDataDao.sysNewCategoryTouchScreen();
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",SDTSNewsCategoryVoList);
        return map;
    }

    @Override
    public List<SDTSNewVo> sysNewTouchScreen(Integer newCategoryId) {
        List<SDTSNewVo> sdtsNewVoList = systemDataDao.sysNewTouchScreen(newCategoryId);
        if (sdtsNewVoList != null && sdtsNewVoList.size()>0){
            for (SDTSNewVo sdtsNewVo : sdtsNewVoList) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysNews", sdtsNewVo.getId(), "newsImg");
                sdtsNewVo.setImgUrls(imgByDate);
            }
        }
        return sdtsNewVoList;
    }

    @Override
    public Map<String, Object> sysNewLatestReleaseTouchScreen(Integer num) {
        map = new HashMap<>();
        List<SDTSNewVo> sdtsNewVoList = systemDataDao.sysNewLatestReleaseTouchScreen(num);
        if (sdtsNewVoList != null && sdtsNewVoList.size()>0){
            for (SDTSNewVo sdtsNewVo : sdtsNewVoList) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysNews", sdtsNewVo.getId(), "newsImg");
                sdtsNewVo.setImgUrls(imgByDate);
            }
        }
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sdtsNewVoList);
        return map;
    }

    @Override
    public Map<String, Object> searchTouchScreen(SearchTouchScreenSearch searchTouchScreenSearch) {
        map = new HashMap<>();
        SDTSSearchVo sdtsSearchVo = new SDTSSearchVo();
        //活动信息搜索
        List<SDTSActivityVo> sdtsActivityVoList = systemDataDao.searchActivity(searchTouchScreenSearch);
        if (sdtsActivityVoList != null && sdtsActivityVoList.size()>0){
            for (SDTSActivityVo sdtsActivityVo : sdtsActivityVoList) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysActivityManagement", sdtsActivityVo.getId(), "activityImg");
                sdtsActivityVo.setImgUrls(imgByDate);
            }
        }
        sdtsSearchVo.setSdtsActivityVoList(sdtsActivityVoList);

        //公告信息搜索
        List<SDTSAnnouncementVo> sdtsAnnouncementVoList = systemDataDao.searchAnnouncement(searchTouchScreenSearch);
        if (sdtsAnnouncementVoList != null && sdtsAnnouncementVoList.size()>0){
            for (SDTSAnnouncementVo sdtsAnnouncementVo : sdtsAnnouncementVoList) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysAnnouncementManagement", sdtsAnnouncementVo.getId(), "announcementImg");
                sdtsAnnouncementVo.setImgUrls(imgByDate);
            }
        }
        sdtsSearchVo.setSdtsAnnouncementVoList(sdtsAnnouncementVoList);

        //资讯信息搜索
        List<SDTSNewVo> sdtsNewVoList = systemDataDao.searchNews(searchTouchScreenSearch);
        if (sdtsNewVoList != null && sdtsNewVoList.size()>0){
            for (SDTSNewVo sdtsNewVo : sdtsNewVoList) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysNews", sdtsNewVo.getId(), "newsImg");
                sdtsNewVo.setImgUrls(imgByDate);
            }
        }
        sdtsSearchVo.setSdtsNewVoList(sdtsNewVoList);

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sdtsSearchVo);
        return map;
    }

}
