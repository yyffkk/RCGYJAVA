package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.basicArchives.CpmBuildingUnitEstateDao;
import com.api.manage.dao.butlerService.SysDoorQRCodeDao;
import com.api.manage.service.butlerService.SysDoorQRCodeService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.GetHtmlCode;
import com.api.model.butlerService.SearchDoorQRCode;
import com.api.model.butlerService.SysDoorQRCode;
import com.api.qrCode.QRCodeServiceImpl;
import com.api.qrCode.ResidentInformation;
import com.api.util.LiLinSignGetHmac;
import com.api.vo.butlerService.VoDoorQRCode;
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
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class SysDoorQRCodeServiceImpl implements SysDoorQRCodeService {
    private static Map<String,Object> map = null;

    @Resource
    CpmBuildingUnitEstateDao cpmBuildingUnitEstateDao;
    @Resource
    SysDoorQRCodeDao sysDoorQRCodeDao;
    @Resource
    QRCodeServiceImpl qrCodeService;
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

            //根据房产主键id和手机号查询是否存在门禁二维码关联信息
            int count = sysDoorQRCodeDao.countQRCodeByEstateIdAndTel(sysDoorQRCode);
            if (count >0){
                throw new RuntimeException("已存在该门禁二维码关联信息");
            }

            //根据拜访房产id查询设备号
            String deviceNumber = cpmBuildingUnitEstateDao.findDeviceNumberByEstateId(sysDoorQRCode.getEstateId());

//            //连接立林对讲机系统-添加设备二维码
//            connectLiLinAddQrCode(deviceNumber, sysDoorQRCode.getTel(),sysDoorQRCode.getStartTime(),sysDoorQRCode.getEndTime());

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
    @Transactional
    public Map<String, Object> getQrCode(Date startTime, Date endTime, String tel) {
        map = new HashMap<>();
        String data = null;//返回二维码字符串
        try {
            //连接立林对讲机系统-获取设备二维码
            data = "qgEkVcd2+ZLg7YpxSdiGjmDMawx1g5Pmbn8PyhRspadb7oGn";
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

    @Override
    @Transactional
    public Map<String, Object> removeQrCode(SysDoorQRCode sysDoorQRCode) {
        map = new HashMap<>();
        try {
            //根据拜访房产id查询设备号
            String deviceNumber = cpmBuildingUnitEstateDao.findDeviceNumberByEstateId(sysDoorQRCode.getEstateId());

            //连接立林对讲机系统-添加设备二维码
            connectLiLinRemoveQrCode(deviceNumber, sysDoorQRCode.getTel());

            //添加设备二维码进数据库
            sysDoorQRCodeDao.removeQrCode(sysDoorQRCode);
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
        map.put("message","删除成功");
        map.put("status",true);
        return map;
    }

    @Override
    public List<VoDoorQRCode> list(SearchDoorQRCode searchDoorQRCode) {
        return sysDoorQRCodeDao.list(searchDoorQRCode);
    }

    @Override
    @Transactional
    public Map<String, Object> getVisitorsQrCode(Date startTime, Date endTime, String visitorsTel) {
        map = new HashMap<>();
        String data = null;//返回二维码字符串
        try {
            //连接立林对讲机系统-获取设备二维码
            data = connectLiLinGetQrCode(visitorsTel, startTime, endTime);
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



    @Override
    @Transactional
    public Map<String, Object> getHtmlCode( Date startTime, Date endTime, String tel) {
        map = new HashMap<>();
        String data = null;//返回二维码字符串
        try {
            GetHtmlCode getHtmlCode = new GetHtmlCode();
            getHtmlCode.setStartTime(startTime);
            getHtmlCode.setEndTime(endTime);
            getHtmlCode.setTel(tel);
            //检查是否有预约信息
            int check = sysDoorQRCodeDao.checkAppointment(getHtmlCode);
            if (check <= 0){
                throw new RuntimeException("未查询到相关预约");
            }
            int estateId = sysDoorQRCodeDao.findEstateId(getHtmlCode);
            String roomNumber = sysDoorQRCodeDao.findRoomNumber(estateId);
            int length = roomNumber.length();
            String substring = roomNumber.substring(0, 1);
            String s = "0" + roomNumber.substring(4,5);
            String substring1 = roomNumber.substring(9);
            ResidentInformation residentInformation=new ResidentInformation();
            residentInformation.setBuildingNo(substring);
            residentInformation.setBuildingUnitNo(s);
            residentInformation.setRoomNo(substring1);




            //连接立林对讲机系统-获取设备二维码
//            data = "qgEkVcd2+ZLg7YpxSdiGjmDMawx1g5Pmbn8PyhRspadb7oGn";
           data = qrCodeService.findRemark2(residentInformation);
//            data= "iot:X1C0iEKQxdV8M82THlhnOw==";
//            data ="iot:Oj8U5sSn51T3Sf0OlFyAAVWDJgqybYwLFb5iJfC3Y8FxqvsC9/9AaykYE6PapHGuJD0LQTWhjP8sFAIyaFqcv9ildRf5JjJ/";
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

    private void connectLiLinRemoveQrCode(String deviceNumber, String tel) {
//        //第三方删除设备二维码
//        Boolean status = removeLiLinQrCode(deviceNumber, tel);
//        if (!status){
//            throw new RuntimeException("删除房屋门禁设备二维码失败");
//        }
//
//        log.info("删除房屋门禁设备二维码成功");

        //判断是否成功发送给大华
        //拼接入口设备号（4个入口）
        String entranceNumber1 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10001");
        String entranceNumber2 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10002");
        String entranceNumber3 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10003");

        //删除入口1设备二维码
        Boolean status1 = removeLiLinQrCode(entranceNumber1, tel);
        if (!status1){
            throw new RuntimeException("删除入口1设备二维码失败");
        }

        log.info("删除入口1设备二维码成功");

        //删除入口2设备二维码
        Boolean status2 = removeLiLinQrCode(entranceNumber2, tel);
        if (!status2){
            throw new RuntimeException("删除入口2设备二维码失败");
        }

        log.info("删除入口2设备二维码成功");

        //删除入口3设备二维码
        Boolean status3 = removeLiLinQrCode(entranceNumber3, tel);
        if (!status3){
            throw new RuntimeException("删除入口3设备二维码失败");
        }

        log.info("删除入口3设备二维码成功");

        //查询第2个字符，代表楼栋号
        int buildingNo = Integer.parseInt(String.valueOf(deviceNumber.charAt(1)));
        //查询第4个字符，代表单元号
        int unitNo = Integer.parseInt(String.valueOf(deviceNumber.charAt(3)));

        //判断是否有第4个入口
        if (buildingNo == 4){
            //如果4栋，则只有3个入口
        }else {
            String entranceNumber4 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10004");


            //删除入口4设备二维码
            Boolean status4 = removeLiLinQrCode(entranceNumber4, tel);
            if (!status4){
                throw new RuntimeException("删除入口4设备二维码失败");
            }

            log.info("删除入口4设备二维码成功");
        }

        //判断是否有第5个入口
        if (buildingNo == 2 && unitNo == 2){
            //如果是2栋2单元，则删除第5个入口
            String entranceNumber5 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10005");

            //删除入口5设备二维码
            Boolean status4 = removeLiLinQrCode(entranceNumber5, tel);
            if (!status4){
                throw new RuntimeException("删除入口5设备二维码失败");
            }

            log.info("删除入口5设备二维码成功");
        }




    }

    private Boolean removeLiLinQrCode(String deviceNumber, String tel) {
        try {
            //第三方账号
            String phoneNumber = tel;

            //api接口方法
            String method = REMOVE_QRCODE_METHOD;
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
                    "\",\"phoneNumber\":"+phoneNumber+
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
        //第三方添加设备二维码
//        Boolean status = addLiLinQrCode(deviceNumber, tel,startTime,endTime);
//        if (!status){
//            throw new RuntimeException("添加房屋门禁设备二维码失败");
//        }
//
//        log.info("添加房屋门禁设备二维码成功");

        //拼接入口设备号（3个入口）
        String entranceNumber1 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10001");
        String entranceNumber2 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10002");
        String entranceNumber3 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10003");


        //添加入口1设备二维码
        Boolean status1 = addLiLinQrCode(entranceNumber1, tel,startTime,endTime);
        if (!status1){
            throw new RuntimeException("添加入口1设备二维码失败");
        }
        log.info("添加入口1设备二维码成功");

        //添加入口2设备二维码
        Boolean status2 = addLiLinQrCode(entranceNumber2, tel,startTime,endTime);
        if (!status2){
            throw new RuntimeException("添加入口2设备二维码失败");
        }
        log.info("添加入口2设备二维码成功");

        //添加入口3设备二维码
        Boolean status3 = addLiLinQrCode(entranceNumber3, tel,startTime,endTime);
        if (!status3){
            throw new RuntimeException("添加入口3设备二维码失败");
        }
        log.info("添加入口3设备二维码成功");

        //查询第2个字符，代表楼栋号
        int buildingNo = Integer.parseInt(String.valueOf(deviceNumber.charAt(1)));
        //查询第4个字符，代表单元号
        int unitNo = Integer.parseInt(String.valueOf(deviceNumber.charAt(3)));

        //判断是否有第4个入口
        if (buildingNo == 4){
            //如果4栋，则只有3个入口
        }else {
            //添加第4个入口
            String entranceNumber4 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10004");

            //添加入口4设备二维码
            Boolean status4 = addLiLinQrCode(entranceNumber4, tel,startTime,endTime);
            if (!status4){
                throw new RuntimeException("添加入口4设备二维码失败");
            }

            log.info("添加入口4设备二维码成功");
        }

        //判断是否有第5个入口
        if (buildingNo == 2 && unitNo == 2){
            //如果是2栋2单元，则添加第5个入口
            String entranceNumber5 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10005");

            //添加入口5设备二维码
            Boolean status4 = addLiLinQrCode(entranceNumber5, tel,startTime,endTime);
            if (!status4){
                throw new RuntimeException("添加入口5设备二维码失败");
            }

            log.info("添加入口5设备二维码成功");
        }

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
                    //获取返回值
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
