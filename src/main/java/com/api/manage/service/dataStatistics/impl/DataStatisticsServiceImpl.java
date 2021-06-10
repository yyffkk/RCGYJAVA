package com.api.manage.service.dataStatistics.impl;

import com.api.manage.dao.dataStatistics.DataStatisticsDao;
import com.api.manage.service.dataStatistics.DataStatisticsService;
import com.api.vo.dataStatistics.DSEnvironmentalHealthVo;
import com.api.vo.dataStatistics.DSInspectionRecord;
import com.api.vo.dataStatistics.DSLastMonthPayCostDetailVo;
import com.api.vo.dataStatistics.DSPaymentStatisticsVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataStatisticsServiceImpl implements DataStatisticsService {
    @Resource
    DataStatisticsDao dataStatisticsDao;
    private static Map<String,Object> map = null;

    @Override
    public Map<String, Object> findLastMonthPayCostDetail() {
        map = new HashMap<>();
        //查询上月账单已缴金额
        BigDecimal lastMonthPayPrice = dataStatisticsDao.findLastMonthPayPrice();
        //查询上月账单未缴金额
        BigDecimal lastMonthUnpaidPrice = dataStatisticsDao.findLastMonthUnpaidPrice();
        //查询上月账单应缴金额
        BigDecimal lastMonthShouldPayPrice = dataStatisticsDao.findLastMonthShouldPayPrice();
        //查询上月账单未缴户数
        BigDecimal lastMonthUnpaidHouseholds = dataStatisticsDao.findLastMonthUnpaidHouseholds();
        DSLastMonthPayCostDetailVo lastMonthPayCostDetailVo = new DSLastMonthPayCostDetailVo();
        lastMonthPayCostDetailVo.setLastMonthPayPrice(lastMonthPayPrice);
        lastMonthPayCostDetailVo.setLastMonthUnpaidPrice(lastMonthUnpaidPrice);
        lastMonthPayCostDetailVo.setLastMonthShouldPayPrice(lastMonthShouldPayPrice);
        lastMonthPayCostDetailVo.setLastMonthUnpaidHouseholds(lastMonthUnpaidHouseholds);

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",lastMonthPayCostDetailVo);
        return map;
    }

    @Override
    public Map<String, Object> findPaymentStatistics() {
        map = new HashMap<>();
        List<DSPaymentStatisticsVo> paymentStatisticsVos = dataStatisticsDao.findPaymentStatistics();
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",paymentStatisticsVos);
        return map;
    }

    @Override
    public Map<String, Object> findTodayEnvironmentalHealth() {
        map = new HashMap<>();
        DSEnvironmentalHealthVo environmentalHealthVo = new DSEnvironmentalHealthVo();
        //查询绿化任务总任务数
        Integer greenTaskTotal = dataStatisticsDao.findGreenTaskTotal();
        //查询绿化任务待完成任务数
        Integer greenTaskPending = dataStatisticsDao.findGreenTaskPending();
        //查询绿化任务已完成任务数
        Integer greenTaskCompleted = dataStatisticsDao.findGreenTaskCompleted();
        //查询绿化任务未完成任务数
        Integer greenTaskUnFinished = dataStatisticsDao.findGreenTaskUnFinished();

        //查询卫生任务总任务数
        Integer hygieneTaskTotal = dataStatisticsDao.findHygieneTaskTotal();
        //查询卫生任务待完成任务数
        Integer hygieneTaskPending = dataStatisticsDao.findHygieneTaskPending();
        //查询卫生任务已完成任务数
        Integer hygieneTaskCompleted = dataStatisticsDao.findHygieneTaskCompleted();
        //查询卫生任务未完成任务数
        Integer hygieneTaskUnFinished = dataStatisticsDao.findHygieneTaskUnFinished();

        environmentalHealthVo.setGreenTaskTotal(greenTaskTotal);
        environmentalHealthVo.setGreenTaskPending(greenTaskPending);
        environmentalHealthVo.setGreenTaskCompleted(greenTaskCompleted);
        environmentalHealthVo.setGreenTaskUnFinished(greenTaskUnFinished);

        environmentalHealthVo.setHygieneTaskTotal(hygieneTaskTotal);
        environmentalHealthVo.setHygieneTaskPending(hygieneTaskPending);
        environmentalHealthVo.setHygieneTaskCompleted(hygieneTaskCompleted);
        environmentalHealthVo.setHygieneTaskUnFinished(hygieneTaskUnFinished);


        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",environmentalHealthVo);
        return map;
    }

    @Override
    public Map<String, Object> findTodayInspectionRecord() {
        map = new HashMap<>();
        List<DSInspectionRecord> list = dataStatisticsDao.findTodayInspectionRecord();
        if (list != null && list.size()>0){
            for (DSInspectionRecord dsInspectionRecord : list) {
                //判断实际开始时间是否为null
                if (dsInspectionRecord.getActualBeginDate() != null){
                    //判断实际结束时间是否为null
                    if (dsInspectionRecord.getActualEndDate() != null){
                        dsInspectionRecord.setStatus(2); //实际开始时间与实际结束时间都不为null，2.已巡检
                        //查询巡检执行点总数
                        Integer totalNum = dataStatisticsDao.findExecutePointTotalNum(dsInspectionRecord.getId());
                        //查询已完成的巡检执行点数量
                        Integer unfinishedNum = dataStatisticsDao.findUnfinishedExecutePointNum(dsInspectionRecord.getId());
                        if (unfinishedNum == 0){
                            //如果已完成的巡检执行点数量为0，则巡更进度为100
                            dsInspectionRecord.setProgress(100);
                        }else {
                            //如果已完成的巡检执行点数量不为0，则 已完成的巡检执行点数量/巡检执行点总数*100
                            dsInspectionRecord.setProgress(Math.round(unfinishedNum/totalNum*100));
                        }
                    }else {
                        dsInspectionRecord.setStatus(3); //实际开始时间不为null,实际结束时间为null，3.巡检中
                        //查询巡检执行点总数
                        Integer totalNum = dataStatisticsDao.findExecutePointTotalNum(dsInspectionRecord.getId());
                        //查询已完成的巡检执行点数量
                        Integer unfinishedNum = dataStatisticsDao.findUnfinishedExecutePointNum(dsInspectionRecord.getId());
                        if (unfinishedNum == 0){
                            //如果已完成的巡检执行点数量为0，则巡更进度为100
                            dsInspectionRecord.setProgress(100);
                        }else {
                            //如果已完成的巡检执行点数量不为0，则 已完成的巡检执行点数量/巡检执行点总数*100
                            dsInspectionRecord.setProgress(Math.round(unfinishedNum/totalNum*100));
                        }
                    }
                }else {
                    //判断实际结束时间是否为null
                    if (dsInspectionRecord.getActualEndDate() != null){
                        dsInspectionRecord.setStatus(4); //实际开始时间为null,实际结束时间不为null，4.未巡检
                        dsInspectionRecord.setProgress(0);//未巡检，巡更进度默认是0
                    }else {
                        //实际开始时间与实际结束时间都为null，1.待巡检
                        dsInspectionRecord.setStatus(1);
                        dsInspectionRecord.setProgress(0);//待巡检，巡更进度默认是0
                    }
                }
            }
        }

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",list);
        return map;
    }
}
