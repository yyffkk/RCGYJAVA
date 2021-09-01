package com.api.manage.service.chargeManagement.impl;

import com.api.manage.dao.basicArchives.CpmBuildingUnitEstateDao;
import com.api.manage.dao.chargeManagement.SysMeterReadingRecordDao;
import com.api.manage.service.chargeManagement.SysMeterReadingRecordService;
import com.api.model.basicArchives.CpmBuildingUnitEstate;
import com.api.model.businessManagement.SysUser;
import com.api.model.chargeManagement.*;
import com.api.vo.chargeManagement.VoMeterReadingRecord;
import com.api.vo.chargeManagement.VoMeterReadingShareBill;
import com.api.vo.chargeManagement.VoMeterReadingShareBillDetails;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class SysMeterReadingRecordServiceImpl implements SysMeterReadingRecordService {
    private static Map<String,Object> map = null;
    @Value("${meterReading.serviceLocation}")
    private String METER_READING_SERVICE_LOCATION;    //抄表系统服务器地址
    @Value("${meterReading.equipNo}")
    private String METER_READING_EQUIP_NO;    //设备号（水电量）
    @Value("${meterReading.ycpNoE}")
    private String METER_READING_YCP_NO_E;    //电量测点号（equip_ycp_state获取当前设备模拟量测点的状态）
    @Value("${meterReading.ycpNoW}")
    private String METER_READING_YCP_NO_W;    //水量测点号（equip_ycp_state获取当前设备模拟量测点的状态）

    @Resource
    SysMeterReadingRecordDao meterReadingRecordDao;
    @Resource
    CpmBuildingUnitEstateDao cpmBuildingUnitEstateDao;

    @Override
    public Map<String,Object> getElectricQuantity(String authorization) {
        //获取电量
        try {
            //getElectricQuantity 获取电量
            String json = "{\"equip_no\":"+METER_READING_EQUIP_NO+",\"ycp_no\":"+METER_READING_YCP_NO_E+"}";
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(30000, TimeUnit.MILLISECONDS)
                    .readTimeout(30000, TimeUnit.MILLISECONDS)
                    .build();
            MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
            RequestBody requestBody = FormBody.create(mediaType, json);
            Request request = new Request.Builder()
                    .url(METER_READING_SERVICE_LOCATION+"/api/real/equip_ycp_state")
                    .post(requestBody)
                    .addHeader("Authorization",authorization)
                    .addHeader("Referer",METER_READING_SERVICE_LOCATION)
                    .build();
            Response execute = client.newCall(request).execute();
            if (execute.isSuccessful()) {
                ResponseBody body = execute.body();
                if (body != null) {
                    //获取返回值
                    String result = body.string();
                    log.info("返回值:"+result);
                    JSONObject jsonObject = new JSONObject(result);
                    JSONObject httpData = (JSONObject) jsonObject.get("HttpData");
                    String code = String.valueOf(httpData.get("code"));

                    //=====判断返回是否成功
                    if ("200".equals(code)){
                        JSONObject data = (JSONObject) httpData.get("data");
                        String electricQuantity = String.valueOf(data.get("m_YCValue"));
                        log.info("获取当前总电量为："+electricQuantity+"度");
                        map.put("message","请求成功");
                        map.put("status",true);
                        map.put("data",electricQuantity);
                    }else {
                        log.info("返回失败");
                        throw new RuntimeException(String.valueOf(httpData.get("message")));
                    }
                }else {
                    log.info("返回内容不存在");
                    throw new RuntimeException("返回内容不存在");
                }
            }else {
                log.info("请求失败");
                throw new RuntimeException("请求失败");
            }
        } catch (Exception e) {
            //获取抛出的信息
            String message = e.getMessage();
            log.info("错误信息：" + message);
            e.printStackTrace();
            map.put("message",message);
            map.put("status",false);
            map.put("data","");
            return map;
        }
        return map;
    }



    @Override
    public Map<String,Object> getWaterQuantity(String authorization) {
        //获取电量
        try {
            //getElectricQuantity 获取电量
            String json = "{\"equip_no\":"+METER_READING_EQUIP_NO+",\"ycp_no\":"+METER_READING_YCP_NO_W+"}";
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(30000, TimeUnit.MILLISECONDS)
                    .readTimeout(30000, TimeUnit.MILLISECONDS)
                    .build();
            MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
            RequestBody requestBody = FormBody.create(mediaType, json);
            Request request = new Request.Builder()
                    .url(METER_READING_SERVICE_LOCATION+"/api/real/equip_ycp_state")
                    .post(requestBody)
                    .addHeader("Authorization",authorization)
                    .addHeader("Referer",METER_READING_SERVICE_LOCATION)
                    .build();
            Response execute = client.newCall(request).execute();
            if (execute.isSuccessful()) {
                ResponseBody body = execute.body();
                if (body != null) {
                    //获取返回值
                    String result = body.string();
                    log.info("返回值:"+result);
                    JSONObject jsonObject = new JSONObject(result);
                    JSONObject httpData = (JSONObject) jsonObject.get("HttpData");
                    String code = String.valueOf(httpData.get("code"));

                    //=====判断返回是否成功
                    if ("200".equals(code)){
                        JSONObject data = (JSONObject) httpData.get("data");
                        String electricQuantity = String.valueOf(data.get("m_YCValue"));
                        log.info("获取当前总水量为："+electricQuantity+"毫升");
                        map.put("message","请求成功");
                        map.put("status",true);
                        map.put("data",electricQuantity);
                    }else {
                        log.info("返回失败");
                        throw new RuntimeException(String.valueOf(httpData.get("message")));
                    }
                }else {
                    log.info("返回内容不存在");
                    throw new RuntimeException("返回内容不存在");
                }
            }else {
                log.info("请求失败");
                throw new RuntimeException("请求失败");
            }
        } catch (Exception e) {
            //获取抛出的信息
            String message = e.getMessage();
            log.info("错误信息：" + message);
            e.printStackTrace();
            map.put("message",message);
            map.put("status",false);
            map.put("data","");
            return map;
        }
        return map;
    }

    @Override
    public Map<String,Object> getKey() {
        map = new HashMap<>();
        try {
            //getkey 获取密钥
            String json = "{\"username\":\"nnrcgy\",\"userpwd\":\"rcgy.123\",\"code\" :\"BBA57BFB-53AC-4C39-B736-735EA11D2E51\"}";
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(30000, TimeUnit.MILLISECONDS)
                    .readTimeout(30000, TimeUnit.MILLISECONDS)
                    .build();
            MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
            RequestBody requestBody = FormBody.create(mediaType, json);
            Request request = new Request.Builder()
                    .url(METER_READING_SERVICE_LOCATION+"/api/server/getkey")
                    .post(requestBody)
                    .build();
            Response execute = client.newCall(request).execute();
            if (execute.isSuccessful()) {
                ResponseBody body = execute.body();
                if (body != null) {
                    //获取返回值
                    String result = body.string();
                    log.info("返回值:"+result);
                    JSONObject jsonObject = new JSONObject(result);
                    JSONObject httpData = (JSONObject) jsonObject.get("HttpData");
                    String code = String.valueOf(httpData.get("code"));

                    //=====判断返回是否成功
                    if ("200".equals(code)){
                        JSONObject data = (JSONObject) httpData.get("data");
                        String appKey = String.valueOf(data.get("appkey"));
                        String infoKey = String.valueOf(data.get("infokey"));
                        String authorization = appKey + "-" + infoKey; //拼接密钥 【authorization = appKey-infoKey】
                        log.info("获取key成功密钥，密钥为："+authorization);
                        map.put("message","请求成功");
                        map.put("status",true);
                        map.put("data",authorization);
                    }else {
                        log.info("返回失败");
                        throw new RuntimeException(String.valueOf(httpData.get("message")));
                    }
                }else {
                    log.info("返回内容不存在");
                    throw new RuntimeException("返回内容不存在");
                }
            }else {
                log.info("请求失败");
                throw new RuntimeException("请求失败");
            }
        } catch (Exception e) {
            //获取抛出的信息
            String message = e.getMessage();
            log.info("错误信息：" + message);
            e.printStackTrace();
            map.put("message",message);
            map.put("status",false);
            map.put("data","");
            return map;
        }
        return map;
    }

    @Override
    public Boolean insertElectricQuantity(BigDecimal electricQuantity) {
        SysMeterReadingRecord sysMeterReadingRecord = new SysMeterReadingRecord();

        Integer type = 2;//抄表类型，2.电量
        sysMeterReadingRecord.setType(type);//填入抄表类型，2.电量
        sysMeterReadingRecord.setUnit("度");//填入单位，'度'
        sysMeterReadingRecord.setEndDate(new Date());//填入抄表结束时间【当前时间】
        sysMeterReadingRecord.setBillStatus(1);//填入账单状态：1.未创建
        sysMeterReadingRecord.setCreateDate(new Date());//填入创建时间

        BigDecimal newData = electricQuantity;//抄表记录量（当前量）【新数据】


        //填入抄表记录量（当前量）
        if (newData.compareTo(BigDecimal.ZERO) == 0){
            //如果查出为0，那么为异常数据，填入null
            sysMeterReadingRecord.setRecordingQuantity(null);
            sysMeterReadingRecord.setDataStatus(2);//填入数据状态：2.异常
        }else {
            //不为0，则为正常数据，正常填入数据
            sysMeterReadingRecord.setRecordingQuantity(newData);//**填入抄表记录量（当前量）
            sysMeterReadingRecord.setDataStatus(1);//**填入数据状态：1.正常
        }



        //查询最新的抄表记录数据
        SysMeterReadingRecord sysMeterReadingRecord1 = meterReadingRecordDao.findNewData(type);
        if (sysMeterReadingRecord1 != null){
            BigDecimal oldData = sysMeterReadingRecord1.getRecordingQuantity();//抄表记录量（当前量）【旧数据】
            if (oldData == null || oldData.compareTo(BigDecimal.ZERO) == 0){
                //如果旧数据为0则旧数据为异常数据，抄表用量为null
                sysMeterReadingRecord.setConsumption(null);
                sysMeterReadingRecord.setDataStatus(2);//填入数据状态：2.异常
            }else {
                //抄表用量（该区间用量）[数据正常时，新数据减旧数据]
                sysMeterReadingRecord.setConsumption(newData.subtract(oldData));//**填入抄表用量（该区间用量）
            }

            //如果存在最新的抄表记录，则抄表开始时间 等于 旧数据的抄表结束时间
            sysMeterReadingRecord.setStartDate(sysMeterReadingRecord1.getEndDate());//**填入抄表结束时间
        }else {
            //如果不存在最新的抄表记录，则为异常数据，抄表用量为null
            sysMeterReadingRecord.setConsumption(null);
            //如果不存在最新的抄表记录，则为异常数据，抄表开始时间为null
            sysMeterReadingRecord.setStartDate(null);
        }



        //添加抄表记录
        int insert = meterReadingRecordDao.insertMeterReadingRecord(sysMeterReadingRecord);
        if (insert >0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean insertWaterQuantity(BigDecimal waterQuantity) {
        SysMeterReadingRecord sysMeterReadingRecord = new SysMeterReadingRecord();

        Integer type = 1;//抄表类型，1.水量
        sysMeterReadingRecord.setType(type);//填入抄表类型，1.水量
        sysMeterReadingRecord.setUnit("升");//填入单位，'升'
        sysMeterReadingRecord.setEndDate(new Date());//填入抄表结束时间【当前时间】
        sysMeterReadingRecord.setBillStatus(1);//填入账单状态：1.未创建
        sysMeterReadingRecord.setCreateDate(new Date());//填入创建时间

        BigDecimal newData = waterQuantity;//抄表记录量（当前量）【新数据】


        //填入抄表记录量（当前量）
        if (newData.compareTo(BigDecimal.ZERO) == 0){
            //如果查出为0，那么为异常数据，填入null
            sysMeterReadingRecord.setRecordingQuantity(null);
            sysMeterReadingRecord.setDataStatus(2);//填入数据状态：2.异常
        }else {
            //不为0，则为正常数据，正常填入数据
            sysMeterReadingRecord.setRecordingQuantity(newData);//**填入抄表记录量（当前量）
            sysMeterReadingRecord.setDataStatus(1);//**填入数据状态：1.正常
        }



        //查询最新的抄表记录数据
        SysMeterReadingRecord sysMeterReadingRecord1 = meterReadingRecordDao.findNewData(type);
        if (sysMeterReadingRecord1 != null){
            BigDecimal oldData = sysMeterReadingRecord1.getRecordingQuantity();//抄表记录量（当前量）【旧数据】
            if (oldData == null || oldData.compareTo(BigDecimal.ZERO) == 0){
                //如果旧数据为0则旧数据为异常数据，抄表用量为null
                sysMeterReadingRecord.setConsumption(null);
                sysMeterReadingRecord.setDataStatus(2);//填入数据状态：2.异常
            }else {
                //抄表用量（该区间用量）[数据正常时，新数据减旧数据]
                sysMeterReadingRecord.setConsumption(newData.subtract(oldData));//**填入抄表用量（该区间用量）
            }

            //如果存在最新的抄表记录，则抄表开始时间 等于 旧数据的抄表结束时间
            sysMeterReadingRecord.setStartDate(sysMeterReadingRecord1.getEndDate());//**填入抄表结束时间
        }else {
            //如果不存在最新的抄表记录，则为异常数据，抄表用量为null
            sysMeterReadingRecord.setConsumption(null);
            //如果不存在最新的抄表记录，则为异常数据，抄表开始时间为null
            sysMeterReadingRecord.setStartDate(null);
        }

        //添加抄表记录
        int insert = meterReadingRecordDao.insertMeterReadingRecord(sysMeterReadingRecord);
        if (insert >0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<VoMeterReadingRecord> list(SearchMeterReadingRecord searchMeterReadingRecord) {
        return meterReadingRecordDao.list(searchMeterReadingRecord);
    }

    @Override
    public Map<String, Object> updateRemakes(SysMeterReadingRecord sysMeterReadingRecord) {
        map = new HashMap<>();
        int update = meterReadingRecordDao.updateRemakes(sysMeterReadingRecord);
        if (update >0){
            map.put("message","更新成功");
            map.put("status",true);
        }else {
            map.put("message","更新失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String,Object> updateElectricData(String electricQuantity) {
        map = new HashMap<>();

        SysMeterReadingData sysMeterReadingData = new SysMeterReadingData();
        sysMeterReadingData.setType(2);//填入抄表类型,2.电量
        sysMeterReadingData.setQuantity(new BigDecimal(electricQuantity));//填入当前总量
        sysMeterReadingData.setUpdateDate(new Date());//填入更新时间

        //更新抄表数据（更新电量）
        int update = meterReadingRecordDao.updateMeterReadingData(sysMeterReadingData);
        if (update >0){
            map.put("message","更新成功");
            map.put("status",true);
        }else {
            map.put("message","更新失败");
            map.put("status",false);
        }
        return map;

    }

    @Override
    public Map<String, Object> updateWaterData(String waterQuantity) {
        map = new HashMap<>();

        SysMeterReadingData sysMeterReadingData = new SysMeterReadingData();
        sysMeterReadingData.setType(1);//填入抄表类型,1.水量
        sysMeterReadingData.setQuantity(new BigDecimal(waterQuantity));//填入当前总量
        sysMeterReadingData.setUpdateDate(new Date());//填入更新时间

        //更新抄表数据（更新水量）
        int update = meterReadingRecordDao.updateMeterReadingData(sysMeterReadingData);
        if (update >0){
            map.put("message","更新成功");
            map.put("status",true);
        }else {
            map.put("message","更新失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public SysMeterReadingData findMeterReadingDataByType(int type) {
        return meterReadingRecordDao.findMeterReadingDataByType(type);
    }

    @Override
    @Transactional
    public Map<String, Object> createShareBill(SysMeterReadingShareBill sysMeterReadingShareBill) {
        map = new HashMap<>();
        BigDecimal areaTotals = null;

        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            //根据抄表记录主键Id查询抄表记录
            VoMeterReadingRecord voMeterReadingRecord = meterReadingRecordDao.findMeterReadingRecordById(sysMeterReadingShareBill.getMeterReadingRecordId());

            //查询所有的入住的房产ids
            List<Integer> ids = meterReadingRecordDao.findAllCheckInEstateId(new Date());

            areaTotals = BigDecimal.ZERO;
            if (ids != null && ids.size()>0){
                //计算出所有入住房产面积的总和
                areaTotals = meterReadingRecordDao.countCheckInEstateAllArea(ids);
            }

            sysMeterReadingShareBill.setMeterReadingRecordId(voMeterReadingRecord.getId());//填入抄表记录表主键id
            sysMeterReadingShareBill.setMonths(voMeterReadingRecord.getMonths());//填入月份
            sysMeterReadingShareBill.setTotals(voMeterReadingRecord.getConsumption());//填入总用量
            sysMeterReadingShareBill.setType(voMeterReadingRecord.getType());//填入抄表类型：1.水费，2.电费
            sysMeterReadingShareBill.setUnit(voMeterReadingRecord.getUnit());//填入单位


            //添加抄表分摊表信息
            //计算费用金额
            BigDecimal cost = sysMeterReadingShareBill.getTotals().multiply(sysMeterReadingShareBill.getUnitPrice());
            sysMeterReadingShareBill.setCost(cost);//填入费用金额（总用量*单价）
            sysMeterReadingShareBill.setHouseholdArea(areaTotals);//填入住户面积
            //计算住户总费用
            BigDecimal householdCost = sysMeterReadingShareBill.getHouseholdConsumption().multiply(sysMeterReadingShareBill.getUnitPrice());
            sysMeterReadingShareBill.setHouseholdCost(householdCost);//填入住户总费用
            //计算公摊单价
            BigDecimal shareUnitPrice = sysMeterReadingShareBill.getTotals().subtract(householdCost).divide(areaTotals,2, BigDecimal.ROUND_HALF_UP);
            sysMeterReadingShareBill.setShareUnitPrice(shareUnitPrice);
            if (sysMeterReadingShareBill.getType() == 1){
                sysMeterReadingShareBill.setChargeUnit("元/立方米");
            }else if (sysMeterReadingShareBill.getType() == 2){
                sysMeterReadingShareBill.setChargeUnit("元/度");
            }else {
                sysMeterReadingShareBill.setChargeUnit("其他");
            }
            //计算住户公摊总费用
            BigDecimal householdShareCost = shareUnitPrice.multiply(areaTotals);
            sysMeterReadingShareBill.setHouseholdShareCost(householdShareCost);//填入住户公摊总费用


            //计算额外费用（费用金额-住户公摊总费用-住户总费用）【富航所承担的公摊费用】
            BigDecimal subtract = cost.subtract(householdShareCost).subtract(householdCost);
            sysMeterReadingShareBill.setAdditionalCosts(subtract);//填入额外费用（费用金额-住户公摊总费用-住户总费用）【富航所承担的公摊费用】

            sysMeterReadingShareBill.setCreateId(sysUser.getId());//填入创建人
            sysMeterReadingShareBill.setCreateDate(new Date());//填入创建时间

            //添加抄表公摊账单
            int insert = meterReadingRecordDao.insertMeterReadingShareBill(sysMeterReadingShareBill);
            if (insert <= 0){
                throw new RuntimeException("生成分摊账单失败");
            }

            SysMeterReadingRecord sysMeterReadingRecord = new SysMeterReadingRecord();
            sysMeterReadingRecord.setBillStatus(2);//填入账单状态，2.已创建
            sysMeterReadingRecord.setId(sysMeterReadingShareBill.getMeterReadingRecordId());//填入抄表记录主键id

            //修改抄表记录账单状态
            int update = meterReadingRecordDao.updateMeterReadingRecordBillStatus(sysMeterReadingRecord);
            if (update <= 0){
                throw new RuntimeException("修改抄表记录账单状态失败");
            }

            //添加抄表公摊明细
            if (ids != null && ids.size() >0){
                for (Integer id : ids) {
                    SysMeterReadingShareBillDetails shareBillDetails = new SysMeterReadingShareBillDetails();
                    shareBillDetails.setShareBillId(sysMeterReadingShareBill.getId());//填入公摊账单主键id
                    shareBillDetails.setEstateId(id);//填入房产主键id
                    //根据房产主键id查询房产信息
                    CpmBuildingUnitEstate cpmBuildingUnitEstate = cpmBuildingUnitEstateDao.findById(id);
                    shareBillDetails.setHouseArea(cpmBuildingUnitEstate.getIndoorArea());//填入房产面积
                    //计算应缴金额
                    BigDecimal amountPayable = shareUnitPrice.multiply(cpmBuildingUnitEstate.getIndoorArea());
                    shareBillDetails.setAmountPayable(amountPayable);//填入应缴金额
                    shareBillDetails.setPaidAmount(BigDecimal.ZERO);//填入实缴纳金额
                    shareBillDetails.setRemainingUnpaidAmount(amountPayable);//填入剩余未缴金额
                    shareBillDetails.setStatus(1);//填入缴纳状态，1.未缴纳
                    shareBillDetails.setRate(sysMeterReadingShareBill.getRate());//填入费率
                    shareBillDetails.setPaymentPeriod(sysMeterReadingShareBill.getEffectiveTimeEnd());//填入缴费期限
                    shareBillDetails.setCreateId(sysUser.getId());//填入创建人
                    shareBillDetails.setCreateDate(new Date());//填入创建时间

                    //添加抄表公摊明细
                    int insert2 = meterReadingRecordDao.insertMeterReadingShareBillDetails(shareBillDetails);
                    if (insert2 <=0){
                        throw new RuntimeException("添加抄表公摊明细失败");
                    }
                }
            }


        } catch (RuntimeException e) {
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
        map.put("message","生成分摊账单成功");
        map.put("status",true);
        return map;
    }

    @Override
    public List<VoMeterReadingShareBillDetails> findShareBillDetailsListByShareId(SearchShareBillDetails searchShareBillDetails) {
        List<VoMeterReadingShareBillDetails> detailsListByShareId = meterReadingRecordDao.findShareBillDetailsListByShareId(searchShareBillDetails);
        if (detailsListByShareId != null){
            for (VoMeterReadingShareBillDetails shareBillDetails : detailsListByShareId) {
                //逾期天数初始值0
                int expectedDays = 0;
                //滞纳金初始值0
                BigDecimal lateFee = BigDecimal.ZERO;

                if (shareBillDetails.getPaymentTime() != null){
                    //已缴费，判断缴费时间是否大于缴费期限
                    if (shareBillDetails.getPaymentTime().getTime() > shareBillDetails.getPaymentPeriod().getTime()){
                        double d = (shareBillDetails.getPaymentTime().getTime() - shareBillDetails.getPaymentPeriod().getTime()) / 1000.0 / 60.0 / 60.0 / 24.0;
                        //如果缴费时间大于缴费期限，有滞纳金，有逾期天数
                        expectedDays = (int) Math.round(d);
                        //计算滞纳金
                        //(计算公式【应缴金额*（1+费率/100），每日累乘】)
                        BigDecimal totalPrice = shareBillDetails.getAmountPayable();
                        for (int i = 0; i < expectedDays; i++) {
                            //需要先转化成double，不然int类型之间的计算结果会被默认转换成int
                            double rate = shareBillDetails.getRate().doubleValue();
                            //计算出总缴费金额
                            totalPrice = totalPrice.multiply(new BigDecimal(1 + rate / 100));
                        }
                        //滞纳金 = 总缴费金额 - 应缴金额
                        lateFee = totalPrice.subtract(shareBillDetails.getAmountPayable());
                    }else {
                        //缴费时间小于缴费期限，滞纳金为0，逾期天数为0
                    }
                }else {
                    //未缴费，产生滞纳金
                    if (new Date().getTime() > shareBillDetails.getPaymentPeriod().getTime()){
                        double d = (new Date().getTime() - shareBillDetails.getPaymentPeriod().getTime()) / 1000.0 / 60.0 / 60.0 / 24.0;
                        //当前时间大于缴费期限，有滞纳金，有逾期天数
                        expectedDays = (int) Math.round(d);
                        //计算滞纳金
                        //(计算公式【应缴金额*（1+费率/100），每日累乘】)
                        BigDecimal totalPrice = shareBillDetails.getAmountPayable();
                        for (int i = 0; i < expectedDays; i++) {
                            //需要先转化成double，不然int类型之间的计算结果会被默认转换成int
                            double rate = shareBillDetails.getRate().doubleValue();
                            //计算出总缴费金额
                            totalPrice = totalPrice.multiply(new BigDecimal(1 + rate / 100));
                        }
                        //滞纳金 = 总缴费金额 - 应缴金额
                        lateFee = totalPrice.subtract(shareBillDetails.getAmountPayable());
                    }else {
                        //当前时间小于缴费期限，滞纳金为0，逾期天数为0
                    }
                }
                shareBillDetails.setExpectedDays(expectedDays);//填入逾期天数
                shareBillDetails.setLateFee(lateFee);//填入滞纳金
            }
        }
        return detailsListByShareId;
    }

    @Override
    public List<VoMeterReadingShareBill> shareBillList(SearchShareBill searchShareBill) {
        List<VoMeterReadingShareBill> shareBillList = meterReadingRecordDao.shareBillList(searchShareBill);
        if (shareBillList != null && shareBillList.size()>0){
            for (VoMeterReadingShareBill shareBill : shareBillList) {
                //根据公摊账单主键id查询总实收金额
                BigDecimal paidAmount = meterReadingRecordDao.sumShareDetailsPaidAmount(shareBill.getId());
                if (paidAmount == null){
                    shareBill.setPaidAmount(BigDecimal.ZERO);//填入实收金额
                }else {
                    shareBill.setPaidAmount(paidAmount);//填入实收金额
                }
                //根据公摊账单主键id查询总剩余未缴费用
                BigDecimal unpaidExpenses = meterReadingRecordDao.sumShareDetailsRemainingUnpaidAmount(shareBill.getId());
                if (unpaidExpenses == null){
                    shareBill.setUnpaidExpenses(BigDecimal.ZERO);//填入剩余未缴费用
                }else {
                    shareBill.setUnpaidExpenses(unpaidExpenses);//填入剩余未缴费用
                }
                //根据公摊账单主键id统计是否所有缴纳完成的缴纳状态（1.已完成，2.未完成）
                int count = meterReadingRecordDao.countShareDetailsStatus(shareBill.getId());
                if (count >0){
                    shareBill.setStatus(2);//2.未完成
                }else if (count == 0){
                    shareBill.setStatus(1);//1.已完成
                }else {
                    shareBill.setStatus(-1);//-1.数据有误
                }
            }
        }
        return shareBillList;
    }
}
