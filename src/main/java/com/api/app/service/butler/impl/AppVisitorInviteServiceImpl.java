package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppVisitorInviteDao;
import com.api.app.service.butler.AppVisitorInviteService;
import com.api.manage.dao.basicArchives.CpmBuildingUnitEstateDao;
import com.api.model.app.AppUserQRVisitorsInviteSubmit;
import com.api.model.app.AppUserVisitorsInvite;
import com.api.model.app.AppUserVisitorsInviteSubmit;
import com.api.model.app.AppUserVisitorsUrl;
import com.api.util.IdWorker;
import com.api.util.LiLinSignGetHmac;
import com.api.util.UploadUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

@Service
@Slf4j
public class AppVisitorInviteServiceImpl implements AppVisitorInviteService {
    @Resource
    AppVisitorInviteDao appVisitorInviteDao;
    @Resource
    CpmBuildingUnitEstateDao cpmBuildingUnitEstateDao;
    @Value("${res.visitShareTime}")
    private Integer VISIT_SHARE_TIME;    //访客邀请分享有效时长
    @Value("${res.visitorsUrl}")
    private String VISITORS_URL;    //新版访客邀请门禁访客照片转发http 地址
    @Value("${res.communityLocation}")
    private String COMMUNITY_LOCATION;  //信息服务系统照片存放地址
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
    private String SERVICE_LOCATION;    //立林对讲机系统测试服务器地址
    @Value("${lilin.api.faceMethod}")
    private String FACE_METHOD;     //添加设备人脸识别api方法

    private static Map<String,Object> map = null;

    @Override
    @Transactional
    public Map<String, Object> share(AppUserVisitorsInvite visitorsInvite) {
        map = new HashMap<>();
        String code = "";
        try {
            //添加新版访客信息
            int insert = appVisitorInviteDao.insertUserVisitorsNew(visitorsInvite);
            if (insert <= 0){
                throw new RuntimeException("添加新版访客信息失败");
            }
            AppUserVisitorsUrl visitorsUrl = new AppUserVisitorsUrl();
            visitorsUrl.setUserVisitorsNewId(visitorsInvite.getId()); //填写新版的访客主键id
            //雪花算法生成分享连接编号
            code = String.valueOf(new IdWorker(1,1,1).nextId());
            visitorsUrl.setCode(code); //填写分享连接编号
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.HOUR,VISIT_SHARE_TIME);
            Date time = calendar.getTime();
            visitorsUrl.setEffectiveDate(time); //填写有效截止时间
            visitorsUrl.setIsUse(0); //填写是否使用，默认0.未使用
            //添加分享连接信息
            int insert2 = appVisitorInviteDao.insertUserVisitorsUrl(visitorsUrl);
            if (insert2 <= 0){
                throw new RuntimeException("添加分享连接信息失败");
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
        map.put("code",code);
        map.put("message","分享成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findByUrlCode(String code) {
        map = new HashMap<>();
        //查询分享连接的有效截止时间
        Date effectiveDate = appVisitorInviteDao.findEffectiveDateByCode(code);
        if (new Date().getTime() > effectiveDate.getTime()){ //如果当前时间超出有效截止时间，则提示该连接已失效
            map.put("message","该连接已失效");
            map.put("status",false);
            return map;
        }
        //根据分享连接编号查询访客信息
        AppUserVisitorsInvite visitorsInvite = appVisitorInviteDao.findByUrlCode(code);
        map.put("data",visitorsInvite);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> submit(AppUserVisitorsInviteSubmit visitorsInviteSubmit) {
        map = new HashMap<>();
        try {
            //根据分享连接编号查询新版访客邀请主键id
            Integer visitId = appVisitorInviteDao.findVisitIdByCode(visitorsInviteSubmit.getCode());
            if (visitId == null || !(visitId.equals(visitorsInviteSubmit.getId()))){
                throw new RuntimeException("分享连接编号与访客邀请主键id不匹配");
            }
            //根据分享连接编号查询该连接是否已被使用
            int isUse = appVisitorInviteDao.findIsUseByCode(visitorsInviteSubmit.getCode());
            if (isUse == 1){
                throw new RuntimeException("该连接已被使用");
            }
            //查询分享连接的有效截止时间
            Date effectiveDate = appVisitorInviteDao.findEffectiveDateByCode(visitorsInviteSubmit.getCode());
            if (effectiveDate == null){//如果有效截止时间查询为null，则提示该连接不存在
                throw new RuntimeException("该连接不存在");
            }
            if (new Date().getTime() > effectiveDate.getTime()){ //如果当前时间超出有效截止时间，则提示该连接已失效
                throw new RuntimeException("该连接已失效");
            }
            if (new Date().getTime() - 24*60*60*1000 > visitorsInviteSubmit.getVisitDateStart().getTime()){//如果当前时间大于到访时间开始，则提示预计到访时间不可小于当前时间
                throw new RuntimeException("预计到访时间不可小于当前时间");
            }
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(visitorsInviteSubmit.getImgList(),"userVisitorsNew",visitorsInviteSubmit.getId(),"selfie","600",30,20);
            //修改新版访客信息
            int update = appVisitorInviteDao.updateUserVisitorsNew(visitorsInviteSubmit);
            if (update <= 0){
                throw new RuntimeException("修改新版访客信息失败");
            }

//            //根据拜访房产id查询设备号
//            String deviceNumber = cpmBuildingUnitEstateDao.findDeviceNumberByEstateId(visitorsInviteSubmit.getEstateId());
//
//            //连接立林对讲机系统 //TODO 先不接立林对讲系统
//            connectLiLinFace(visitorsInviteSubmit.getImgList(), deviceNumber, visitorsInviteSubmit.getTel(),visitorsInviteSubmit.getVisitDateStart(),visitorsInviteSubmit.getVisitDateEnd());

            //根据分享连接编号将该连接修改为1.已使用
            appVisitorInviteDao.updateIsUseByCode(visitorsInviteSubmit.getCode());
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
        map.put("message","提交成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> QRSubmit(AppUserQRVisitorsInviteSubmit qrVisitorsInviteSubmit) {
        map = new HashMap<>();
        try {
            if (new Date().getTime() - 24*60*60*1000 > qrVisitorsInviteSubmit.getVisitDateStart().getTime()){//如果当前时间大于到访时间开始，则提示预计到访时间不可小于当前时间
                throw new RuntimeException("预计到访时间不可小于当前时间");
            }
            qrVisitorsInviteSubmit.setCreateId(-1); //扫门口二维码填写，创建人默认为-1
            qrVisitorsInviteSubmit.setCreateDate(new Date()); //填写创建时间
            //添加新版访客信息
            int insert = appVisitorInviteDao.insertQRUserVisitorsNew(qrVisitorsInviteSubmit);
            if (insert <= 0){
                throw new RuntimeException("添加新版访客信息失败");
            }

            //将照片保存进数据库
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(qrVisitorsInviteSubmit.getImgList(),"userVisitorsNew",qrVisitorsInviteSubmit.getId(),"selfie","600",30,20);
//
////            根据拜访房产id查询设备号
//            String deviceNumber = cpmBuildingUnitEstateDao.findDeviceNumberByEstateId(qrVisitorsInviteSubmit.getEstateId());
//
////            连接立林对讲机系统 //TODO 先不接立林对讲系统
//            connectLiLinFace(qrVisitorsInviteSubmit.getImgList(), deviceNumber, qrVisitorsInviteSubmit.getTel(),qrVisitorsInviteSubmit.getVisitDateStart(),qrVisitorsInviteSubmit.getVisitDateEnd());


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
        map.put("message","提交成功");
        map.put("status",true);
        return map;
    }


    /**
     * 连接立林对讲机系统
     * @param imgList 照片路径数组
     * @param deviceNumber 设备号
     * @param tel 访客手机号
     * @param visitDateStart 拜访开始时间
     * @param visitDateEnd 拜访结束时间
     */
    private void connectLiLinFace(String[] imgList, String deviceNumber, String tel, Date visitDateStart, Date visitDateEnd) {
        //判断是否成功发送给大华
        //拼接入口设备号（4个入口）
//        String entranceNumber1 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10001");
//        String entranceNumber2 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10002");
//        String entranceNumber3 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10003");
//        String entranceNumber4 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10004");



        //上传给房屋门禁设备
        Boolean status = isUploadFace(imgList, deviceNumber, tel,visitDateStart,visitDateEnd);
        if (!status){
            throw new RuntimeException("连接房屋门禁失败");
        }

        log.info("连接房屋门禁成功");

//        //上传给入口1设备
//        Boolean status1 = isUploadFace(imgList, entranceNumber1, tel,visitDateStart,visitDateEnd);
//        if (!status1){
//            throw new RuntimeException("连接入口1失败");
//        }
//
//        log.info("连接入口1成功");
//
//        //上传给入口2设备
//        Boolean status2 = isUploadFace(imgList, entranceNumber2, tel,visitDateStart,visitDateEnd);
//        if (!status2){
//            throw new RuntimeException("连接入口2失败");
//        }
//
//        log.info("连接入口2成功");
//
//        //上传给入口3设备
//        Boolean status3 = isUploadFace(imgList, entranceNumber3, tel,visitDateStart,visitDateEnd);
//        if (!status3){
//            throw new RuntimeException("连接入口3失败");
//        }
//
//        log.info("连接入口3成功");
//
//        //上传给入口4设备
//        Boolean status4 = isUploadFace(imgList, entranceNumber4, tel,visitDateStart,visitDateEnd);
//        if (!status4){
//            throw new RuntimeException("连接入口4失败");
//        }
//
//        log.info("连接入口4成功");
    }


    /**
     * 上传给设备
     * @param imgList 照片路径数组
     * @param deviceNumber 设备号
     * @param tel 访客手机号
     * @param visitDateStart 拜访开始时间
     * @param visitDateEnd 拜访结束时间
     * @return boolean
     */
    private Boolean isUploadFace(String[] imgList, String deviceNumber, String tel, Date visitDateStart, Date visitDateEnd) {
        //=====判断是否有照片
        if (imgList.length <= 0){
            return false;
        }

        //=====将图片发送给大华
        //取第一张照片
        String imgUrl = imgList[0];

        try {
            //第三方账号
            String phoneNumber = tel;

            //api接口方法
            String method = FACE_METHOD;
            //请求的时间戳
            String timestamp = String.valueOf(new Date().getTime());
            //唯一随机数
            String nonce = UUID.randomUUID().toString();

            //拼接出图片的完整http路径 //TODO 本地测需要改照片路径
//            String phoneUrl = COMMUNITY_LOCATION + imgUrl;
            String phoneUrl = "http://39.103.177.88:8804/static/img/h5/visit/fafdc87cceb04edf8c2b8895212a49d6.jpeg";
            //拼接出设备序列号（20位数字）：小区号（12位）+设备号（8位）
            String deviceSn = NEIGH_NO + deviceNumber;

            //梯控权限类型
            Integer floorType = 2;

            //封装data
            String data = "{\"neighNo\":\""+NEIGH_NO+"\",\"deviceSn\":\""+deviceSn+
                    "\",\"phoneNumber\":"+phoneNumber+",\"startTime\":"+visitDateStart.getTime()+",\"endTime\":"+visitDateEnd.getTime()+
                    ",\"photoUrl\":\""+phoneUrl+"\",\"floorType\":"+floorType+"}";

            //获取签名结果串
            String signature = getSignature(method,timestamp,nonce,data);



            String json = "{\"version\":\""+VERSION+"\",\"clientId\":\""+CLIENT_ID+"\",\"timestamp\":\""+timestamp+
                    "\",\"nonce\":\""+nonce+"\",\"method\":\""+method+"\",\"signature\":\""+signature+"\",\"signatureVersion\":\""+SIGNATURE_VERSION+
                    "\",\"data\":"+data+"}";

            log.info(json);

            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
            RequestBody requestBody = FormBody.create(mediaType, json);
            Request request = new Request.Builder()
                    .url("http://rd.iot.leelen.com/third/an/addFaceRecognize")
                    .post(requestBody)
                    .build();
            Response execute = client.newCall(request).execute();
            if (execute.isSuccessful()) {
                ResponseBody body = execute.body();
                if (body != null) {
                    //获取返回值//TODO 4004 设备不存在 或者 亲！物业不在线
                    String result = body.string();
                    log.info(result);
                    JSONObject jsonObject = new JSONObject(result);
                    String result1 = String.valueOf(jsonObject.get("result"));
                    //=====判断返回是否成功
                    if ("1".equals(result1)){
                        return true;
                    }else {
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
        log.info(signature);
        //签名模版工具类签名
        try {
            signature = LiLinSignGetHmac.genHMAC(signature, CLIENT_SECRET);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("签名异常");
        }
        log.info(signature);
        return signature;
    }
}
