package com.api.manage.service.chargeManagement.impl;

import com.api.manage.dao.chargeManagement.SysMeterReadingRecordDao;
import com.api.manage.service.chargeManagement.SysMeterReadingRecordService;
import com.api.model.chargeManagement.SearchMeterReadingRecord;
import com.api.model.chargeManagement.SysMeterReadingRecord;
import com.api.vo.chargeManagement.VoMeterReadingRecord;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
    public Boolean insertElectricQuantity(String electricQuantity) {
        SysMeterReadingRecord sysMeterReadingRecord = new SysMeterReadingRecord();

        Integer type = 2;//抄表类型，2.电量
        sysMeterReadingRecord.setType(type);//填入抄表类型，2.电量
        sysMeterReadingRecord.setUnit("度");//填入单位，'度'
        sysMeterReadingRecord.setEndDate(new Date());//填入抄表结束时间【当前时间】
        sysMeterReadingRecord.setBillStatus(1);//填入账单状态：1.未创建
        sysMeterReadingRecord.setCreateDate(new Date());//填入创建时间

        BigDecimal newData = new BigDecimal(electricQuantity);//抄表记录量（当前量）【新数据】


        //填入抄表记录量（当前量）
        if (newData.compareTo(BigDecimal.ZERO) == 0){
            //如果查出为0，怎么为异常数据，填入null
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
    public Boolean insertWaterQuantity(String waterQuantity) {
        SysMeterReadingRecord sysMeterReadingRecord = new SysMeterReadingRecord();

        Integer type = 1;//抄表类型，1.水量
        sysMeterReadingRecord.setType(type);//填入抄表类型，1.水量
        sysMeterReadingRecord.setUnit("毫升");//填入单位，'毫升'
        sysMeterReadingRecord.setEndDate(new Date());//填入抄表结束时间【当前时间】
        sysMeterReadingRecord.setBillStatus(1);//填入账单状态：1.未创建
        sysMeterReadingRecord.setCreateDate(new Date());//填入创建时间

        BigDecimal newData = new BigDecimal(waterQuantity);//抄表记录量（当前量）【新数据】


        //填入抄表记录量（当前量）
        if (newData.compareTo(BigDecimal.ZERO) == 0){
            //如果查出为0，怎么为异常数据，填入null
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
}
