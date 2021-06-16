package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.basicArchives.CpmBuildingUnitEstateDao;
import com.api.manage.dao.butlerService.SysDoorQRCodeDao;
import com.api.manage.service.butlerService.SysDoorQRCodeService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.SysDoorQRCode;
import com.api.util.LiLinSignGetHmac;
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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class SysDoorQRCodeServiceImpl implements SysDoorQRCodeService {
    private static Map<String,Object> map = null;

    @Resource
    CpmBuildingUnitEstateDao cpmBuildingUnitEstateDao;
    @Resource
    SysDoorQRCodeDao sysDoorQRCodeDao;
    @Value("${lilin.version}")
    private String VERSION;    //第三方密钥
    @Value("${lilin.signatureVersion}")
    private String SIGNATURE_VERSION;   //签名算法版本
    @Value("${lilin.neighNo}")
    private String NEIGH_NO;    //小区号
    @Value("${lilin.clientId}")
    private String CLIENT_ID;   //第三方唯一标示
    @Value("${lilin.clientSecret}")
    private String CLIENT_SECRET;   //第三方密钥
    @Value("${lilin.serviceLocation}")
    private String SERVICE_LOCATION;    //立林对讲机系统服务器地址
    @Value("${lilin.api.addQrCodeMethod}")
    private String ADD_QRCODE_METHOD;     //添加设备二维码api方法
    @Value("${lilin.api.getQrCodeMethod}")
    private String GET_QRCODE_METHOD;     //获取二维码信息api方法
    @Value("${lilin.api.removeQrCodeMethod}")
    private String REMOVE_QRCODE_METHOD;     //删除设备二维码api方法


    @Override
    @Transactional
    public Map<String, Object> addQrCode(SysDoorQRCode sysDoorQRCode) {
        map = new HashMap<>();
        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            sysDoorQRCode.setCreateId(sysUser.getId());
            sysDoorQRCode.setCreateDate(new Date());

            //根据拜访房产id查询设备号
            String deviceNumber = cpmBuildingUnitEstateDao.findDeviceNumberByEstateId(sysDoorQRCode.getEstateId());

            //连接立林对讲机系统-添加设备二维码
            connectLiLinAddQrCode(deviceNumber, sysDoorQRCode.getTel(),sysDoorQRCode.getStartTime(),sysDoorQRCode.getEndTime());

            //添加设备二维码进数据库
            sysDoorQRCodeDao.addQrCode(sysDoorQRCode);
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
    public Map<String, Object> getQrCode(Date startTime, Date endTime, String tel) {
        map = new HashMap<>();
        String data = null;//返回二维码字符串
        try {

            //连接立林对讲机系统-获取设备二维码
            data = connectLiLinGetQrCode(tel, startTime, endTime);
        } catch (Exception e) {
            //获取抛出的信息
            String message = e.getMessage();
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message",message);
            map.put("status",false);
            map.put("data",null);
            return map;
        }
        map.put("message","查询成功");
        map.put("status",true);
        map.put("data",data);
        return map;
    }

    private String connectLiLinGetQrCode(String tel, Date startTime, Date endTime) {
        //判断是否成功发送给大华
        //第三方获取设备二维码
        String data = GetLiLinQrCode(tel,startTime,endTime);

        log.info("获取设备二维码成功");

        return data;
    }

    private String GetLiLinQrCode(String tel, Date startTime, Date endTime) {
        try {
            //第三方账号
            String phoneNumber = tel;

            //api接口方法
            String method = GET_QRCODE_METHOD;
            //请求的时间戳
            String timestamp = String.valueOf(new Date().getTime());
            //唯一随机数
            String nonce = UUID.randomUUID().toString();


            log.info("正在查询的设备二维码手机号为:"+tel);
            //梯控权限类型
            Integer floorType = 2;

            //封装data
            String data = "{\"neighNo\":\""+NEIGH_NO+
                    "\",\"phoneNumber\":"+phoneNumber+",\"startTime\":"+startTime.getTime()+",\"endTime\":"+endTime.getTime()+
                    ",\"floorType\":"+floorType+"}";

            //获取签名结果串
            String signature = getSignature(method,timestamp,nonce,data);



            String json = "{\"version\":\""+VERSION+"\",\"clientId\":\""+CLIENT_ID+"\",\"timestamp\":\""+timestamp+
                    "\",\"nonce\":\""+nonce+"\",\"method\":\""+method+"\",\"signature\":\""+signature+"\",\"signatureVersion\":\""+SIGNATURE_VERSION+
                    "\",\"data\":"+data+"}";

            log.info("json字符串："+json);

//            OkHttpClient client = new OkHttpClient();
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(10000, TimeUnit.MILLISECONDS)
                    .readTimeout(10000, TimeUnit.MILLISECONDS)
                    .build();
            MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
            RequestBody requestBody = FormBody.create(mediaType, json);
            Request request = new Request.Builder()
                    .url(SERVICE_LOCATION+"third/an/"+method)
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
                    String result1 = String.valueOf(jsonObject.get("result"));
                    //=====判断返回是否成功
                    if ("1".equals(result1)){
                        JSONObject jsonObject2 = new JSONObject(String.valueOf(jsonObject.get("data")));
                        log.info("返回成功,开门二维码字符串为："+jsonObject2.get("qrCode"));
                        return String.valueOf(jsonObject2.get("qrCode"));
                    }else {
                        log.info("返回失败");
                        throw new RuntimeException(String.valueOf(jsonObject.get("message")));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    private void connectLiLinAddQrCode(String deviceNumber, String tel, Date startTime, Date endTime) {
        //判断是否成功发送给大华
        //拼接入口设备号（4个入口）
//        String entranceNumber1 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10001");
//        String entranceNumber2 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10002");
//        String entranceNumber3 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10003");
//        String entranceNumber4 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10004");


        //第三方添加设备二维码
        Boolean status = addLiLinQrCode(deviceNumber, tel,startTime,endTime);
        if (!status){
            throw new RuntimeException("添加房屋门禁设备二维码失败");
        }

        log.info("添加房屋门禁设备二维码成功");

//        //添加入口1设备二维码
//        Boolean status1 = addLiLinQrCode(deviceNumber1, tel,startTime,endTime);
//        if (!status1){
//            throw new RuntimeException("添加入口1设备二维码失败");
//        }
//
//        log.info("添加入口1设备二维码成功");
//
//        //添加入口2设备二维码
//        Boolean status2 = addLiLinQrCode(deviceNumber2, tel,startTime,endTime);
//        if (!status2){
//            throw new RuntimeException("添加入口2设备二维码失败");
//        }
//
//        log.info("添加入口2设备二维码成功");
//
//        //添加入口3设备二维码
//        Boolean status3 = addLiLinQrCode(deviceNumber3, tel,startTime,endTime);
//        if (!status3){
//            throw new RuntimeException("添加入口3设备二维码失败");
//        }
//
//        log.info("添加入口3设备二维码成功");
//
//        //添加入口4设备二维码
//        Boolean status4 = addLiLinQrCode(deviceNumber4, tel,startTime,endTime);
//        if (!status4){
//            throw new RuntimeException("添加入口4设备二维码失败");
//        }
//
//        log.info("添加入口4设备二维码成功");
    }

    private Boolean addLiLinQrCode(String deviceNumber, String tel, Date startTime, Date endTime) {
        try {
            //第三方账号
            String phoneNumber = tel;

            //api接口方法
            String method = ADD_QRCODE_METHOD;
            //请求的时间戳
            String timestamp = String.valueOf(new Date().getTime());
            //唯一随机数
            String nonce = UUID.randomUUID().toString();

            //拼接出设备序列号（20位数字）：小区号（12位）+设备号（8位）
            String deviceSn = NEIGH_NO + deviceNumber;
            log.info("正在连接的设备序列号为:"+deviceSn);
            //梯控权限类型
            Integer floorType = 2;

            //封装data
            String data = "{\"neighNo\":\""+NEIGH_NO+"\",\"deviceSn\":\""+deviceSn+
                    "\",\"phoneNumber\":"+phoneNumber+",\"startTime\":"+startTime.getTime()+",\"endTime\":"+endTime.getTime()+
                    ",\"floorType\":"+floorType+"}";

            //获取签名结果串
            String signature = getSignature(method,timestamp,nonce,data);



            String json = "{\"version\":\""+VERSION+"\",\"clientId\":\""+CLIENT_ID+"\",\"timestamp\":\""+timestamp+
                    "\",\"nonce\":\""+nonce+"\",\"method\":\""+method+"\",\"signature\":\""+signature+"\",\"signatureVersion\":\""+SIGNATURE_VERSION+
                    "\",\"data\":"+data+"}";

            log.info("json字符串："+json);

//            OkHttpClient client = new OkHttpClient();
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(10000, TimeUnit.MILLISECONDS)
                    .readTimeout(10000, TimeUnit.MILLISECONDS)
                    .build();
            MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
            RequestBody requestBody = FormBody.create(mediaType, json);
            Request request = new Request.Builder()
                    .url(SERVICE_LOCATION+"third/an/"+method)
                    .post(requestBody)
                    .build();
            Response execute = client.newCall(request).execute();
            if (execute.isSuccessful()) {
                ResponseBody body = execute.body();
                if (body != null) {
                    //获取返回值//TODO 4004 设备不存在 或者 亲！物业不在线
                    String result = body.string();
                    log.info("返回值:"+result);
                    JSONObject jsonObject = new JSONObject(result);
                    String result1 = String.valueOf(jsonObject.get("result"));
                    //=====判断返回是否成功
                    if ("1".equals(result1)){
                        log.info("返回成功");
                        return true;
                    }else {
                        log.info("返回失败");
                        throw new RuntimeException(String.valueOf(jsonObject.get("message")));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return false;
    }

    private String getSignature(String method, String timestamp, String nonce, String data) {
        //公共参数签名
        String signature = "clientId="+CLIENT_ID+"&method="+method+"&timestamp="+timestamp+"&nonce="+nonce;
        if (data != null){
            signature = signature + "&data="+data;
        }
        log.info("公共参数签名："+signature);
        //签名模版工具类签名
        try {
            signature = LiLinSignGetHmac.genHMAC(signature, CLIENT_SECRET);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("签名异常");
        }
        log.info("签名模版工具类签名后签名："+signature);
        return signature;
    }
}
