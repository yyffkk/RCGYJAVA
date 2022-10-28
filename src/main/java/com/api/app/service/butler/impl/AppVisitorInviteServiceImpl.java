package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppVisitorInviteDao;
import com.api.app.service.butler.AppVisitorInviteService;
import com.api.manage.dao.basicArchives.CpmBuildingUnitEstateDao;
import com.api.manage.dao.butlerService.SysDoorQRCodeDao;
import com.api.model.app.*;
import com.api.qrCode.QRCodeServiceImpl;
import com.api.qrCode.ResidentInformation;
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
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AppVisitorInviteServiceImpl implements AppVisitorInviteService {
    @Resource
    AppVisitorInviteDao appVisitorInviteDao;
    @Resource
    SysDoorQRCodeDao sysDoorQRCodeDao;
    @Resource
    CpmBuildingUnitEstateDao cpmBuildingUnitEstateDao;
    @Resource
    QRCodeServiceImpl qrCodeService;
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
    @Value("${lilin.api.addQrCodeMethod}")
    private String ADD_QRCODE_METHOD;     //添加设备二维码api方法

    private static Map<String,Object> map = null;


    @Override
    public List<AppUserVisitorsInvite> list(SearchAppVisitorInvite searchAppVisitorInvite) {
        return appVisitorInviteDao.list(searchAppVisitorInvite);
    }

    @Override
    @Transactional
    public Map<String, Object> share(AppUserVisitorsInvite visitorsInvite) {
        map = new HashMap<>();
        String code = "";
        try {
            visitorsInvite.setStatus(1);//1.分享中
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
    public Map<String, Object> againShare(Integer visitorsInviteId) {
        map = new HashMap<>();
        String code = "";
        AppUserVisitorsInvite appUserVisitorsInvite = appVisitorInviteDao.findById(visitorsInviteId);
        if (appUserVisitorsInvite == null){
            map.put("code",code);
            map.put("message","该访客邀请记录不存在");
            map.put("status",false);
            return map;
        }

        if (appUserVisitorsInvite.getStatus() == 2){
            map.put("code",code);
            map.put("message","该访客邀请记录已被提交，请重新生成分享");
            map.put("status",false);
            return map;
        }

        AppUserVisitorsUrl visitorsUrl = new AppUserVisitorsUrl();
        visitorsUrl.setUserVisitorsNewId(visitorsInviteId); //填写新版的访客主键id
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
        if (effectiveDate == null){
            map.put("message","该连接不存在");
            map.put("status",false);
            return map;
        }

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
        String data = null;//返回二维码字符串
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
            //数据库存入自拍照片
            uploadUtil.saveUrlToDB(visitorsInviteSubmit.getImgList(),"userVisitorsNew",visitorsInviteSubmit.getId(),"selfie","600",30,20);
            //数据库存入访客邀请身份证正面照片
            uploadUtil.saveUrlToDB(visitorsInviteSubmit.getIdCardFrontImgList(),"userVisitorsNew",visitorsInviteSubmit.getId(),"idCardFrontImg","600",30,20);
            //数据库存入访客邀请身份证背面照片
            uploadUtil.saveUrlToDB(visitorsInviteSubmit.getIdCardBackImgList(),"userVisitorsNew",visitorsInviteSubmit.getId(),"idCardBackImg","600",30,20);

            //修改新版访客信息
            visitorsInviteSubmit.setStatus(2);//2.已提交
            int update = appVisitorInviteDao.updateUserVisitorsNew(visitorsInviteSubmit);
            if (update <= 0){
                throw new RuntimeException("修改新版访客信息失败");
            }


            try {
//                //根据拜访房产id查询设备号
//                String deviceNumber = cpmBuildingUnitEstateDao.findDeviceNumberByEstateId(visitorsInviteSubmit.getEstateId());
//
//                //连接立林对讲机系统（人脸识别）
////                connectLiLinFace(visitorsInviteSubmit.getImgList(), deviceNumber, visitorsInviteSubmit.getTel(),visitorsInviteSubmit.getVisitDateStart(),visitorsInviteSubmit.getVisitDateEnd());
//
//                //连接立林对讲机系统-添加设备二维码
////                connectLiLinAddQrCode(deviceNumber, visitorsInviteSubmit.getTel(),visitorsInviteSubmit.getVisitDateStart(),visitorsInviteSubmit.getVisitDateEnd());
                String roomNumber = sysDoorQRCodeDao.findRoomNumber(visitorsInviteSubmit.getEstateId());
                int length = roomNumber.length();
                String substring = roomNumber.substring(0, 1);
                String s = "0" + roomNumber.substring(4,5);
                String substring1 = roomNumber.substring(9);
                ResidentInformation residentInformation=new ResidentInformation();
                residentInformation.setBuildingNo(substring);
                residentInformation.setBuildingUnitNo(s);
                residentInformation.setRoomNo(substring1);
                data = qrCodeService.findRemark2(residentInformation);
            } catch (Exception e) {
                //获取抛出的信息
                String message = e.getMessage();
                throw new RuntimeException("设备连接失败，原因："+message);
            }

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
        map.put("data",data);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> QRSubmit(AppUserQRVisitorsInviteSubmit qrVisitorsInviteSubmit) {
        map = new HashMap<>();
        String data = null;//返回二维码字符串
        try {
            if (new Date().getTime() - 24*60*60*1000 > qrVisitorsInviteSubmit.getVisitDateStart().getTime()){//如果当前时间大于到访时间开始，则提示预计到访时间不可小于当前时间
                throw new RuntimeException("预计到访时间不可小于当前时间");
            }
            qrVisitorsInviteSubmit.setCreateId(-1); //扫门口二维码填写，创建人默认为-1
            qrVisitorsInviteSubmit.setCreateDate(new Date()); //填写创建时间
            //添加新版访客信息
            qrVisitorsInviteSubmit.setStatus(2);//2.已提交
            int insert = appVisitorInviteDao.insertQRUserVisitorsNew(qrVisitorsInviteSubmit);
            if (insert <= 0){
                throw new RuntimeException("添加新版访客信息失败");
            }

            //将照片保存进数据库
            UploadUtil uploadUtil = new UploadUtil();
            //数据库存入自拍照片
            uploadUtil.saveUrlToDB(qrVisitorsInviteSubmit.getImgList(),"userVisitorsNew",qrVisitorsInviteSubmit.getId(),"selfie","600",30,20);
            //数据库存入访客邀请身份证正面照片
            uploadUtil.saveUrlToDB(qrVisitorsInviteSubmit.getIdCardFrontImgList(),"userVisitorsNew",qrVisitorsInviteSubmit.getId(),"idCardFrontImg","600",30,20);
            //数据库存入访客邀请身份证背面照片
            uploadUtil.saveUrlToDB(qrVisitorsInviteSubmit.getIdCardBackImgList(),"userVisitorsNew",qrVisitorsInviteSubmit.getId(),"idCardBackImg","600",30,20);

            try {
//                //根据拜访房产id查询设备号
//                String deviceNumber = cpmBuildingUnitEstateDao.findDeviceNumberByEstateId(qrVisitorsInviteSubmit.getEstateId());
//
//                //连接立林对讲机系统（人脸识别）
////                connectLiLinFace(qrVisitorsInviteSubmit.getImgList(), deviceNumber, qrVisitorsInviteSubmit.getTel(),qrVisitorsInviteSubmit.getVisitDateStart(),qrVisitorsInviteSubmit.getVisitDateEnd());
//
//                //连接立林对讲机系统-添加设备二维码
//                connectLiLinAddQrCode(deviceNumber, qrVisitorsInviteSubmit.getTel(),qrVisitorsInviteSubmit.getVisitDateStart(),qrVisitorsInviteSubmit.getVisitDateEnd());


                String roomNumber = sysDoorQRCodeDao.findRoomNumber(qrVisitorsInviteSubmit.getEstateId());
                int length = roomNumber.length();
                String substring = roomNumber.substring(0, 1);
                String s = "0" + roomNumber.substring(4,5);
                String substring1 = roomNumber.substring(9);
                ResidentInformation residentInformation=new ResidentInformation();
                residentInformation.setBuildingNo(substring);
                residentInformation.setBuildingUnitNo(s);
                residentInformation.setRoomNo(substring1);
                data = qrCodeService.findRemark2(residentInformation);
            } catch (Exception e) {
                //获取抛出的信息
                String message = e.getMessage();
                throw new RuntimeException("设备连接失败，原因："+message);
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
//        //上传给房屋门禁设备
//        Boolean status = isUploadFace(imgList, deviceNumber, tel,visitDateStart,visitDateEnd);
//        if (!status){
//            throw new RuntimeException("连接房屋门禁失败");
//        }
//
//        log.info("连接房屋门禁成功");

        //判断是否成功发送给大华
        //拼接入口设备号（3个入口）
//        String entranceNumber1 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10001");
//        String entranceNumber2 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10002");
        String entranceNumber3 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10003");

//        //上传给入口1设备
//        Boolean status1 = isUploadFace(imgList, entranceNumber1, tel,visitDateStart,visitDateEnd);
//        if (!status1){
//            throw new RuntimeException("连接入口1失败");
//        }
//        log.info("连接入口1成功");
//
//        //上传给入口2设备
//        Boolean status2 = isUploadFace(imgList, entranceNumber2, tel,visitDateStart,visitDateEnd);
//        if (!status2){
//            throw new RuntimeException("连接入口2失败");
//        }
//        log.info("连接入口2成功");

        //上传给入口3设备
        Boolean status3 = isUploadFace(imgList, entranceNumber3, tel,visitDateStart,visitDateEnd);
        if (!status3){
            throw new RuntimeException("连接入口3失败");
        }
        log.info("连接入口3成功");

//        //查询第2个字符，代表楼栋号
//        int buildingNo = Integer.parseInt(String.valueOf(deviceNumber.charAt(1)));
//        //查询第4个字符，代表单元号
//        int unitNo = Integer.parseInt(String.valueOf(deviceNumber.charAt(3)));
//
//        //判断是否有第4个入口
//        if (buildingNo == 4){
//            //如果4栋，则只有3个入口
//        }else {
//            //添加第4个入口
//            String entranceNumber4 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10004");
//
//            //上传给入口4设备
//            Boolean status4 = isUploadFace(imgList, entranceNumber4, tel,visitDateStart,visitDateEnd);
//            if (!status4){
//                throw new RuntimeException("连接入口4失败");
//            }
//
//            log.info("连接入口4成功");
//        }
//
//        //判断是否有第5个入口
//        if (buildingNo == 2 && unitNo == 2){
//            //如果是2栋2单元，则添加第5个入口
//            String entranceNumber5 = deviceNumber.replaceAll("([\\w\\W]*)([\\w\\W]{4})", "$10005");
//
//            //上传给入口4设备
//            Boolean status5 = isUploadFace(imgList, entranceNumber5, tel,visitDateStart,visitDateEnd);
//            if (!status5){
//                throw new RuntimeException("连接入口5失败");
//            }
//
//            log.info("连接入口5成功");
//        }


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

            //拼接出图片的完整http路径 //本地测需要改照片路径
            String phoneUrl = COMMUNITY_LOCATION + imgUrl;
//            String phoneUrl = "http://39.103.177.88:8804/static/img/h5/visit/fafdc87cceb04edf8c2b8895212a49d6.jpeg";
            //拼接出设备序列号（20位数字）：小区号（12位）+设备号（8位）
            String deviceSn = NEIGH_NO + deviceNumber;
            log.info("正在连接的设备序列号为:"+deviceSn);
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

            log.info("json字符串："+json);

//            OkHttpClient client = new OkHttpClient();
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(30000, TimeUnit.MILLISECONDS)
                    .readTimeout(30000, TimeUnit.MILLISECONDS)
                    .build();
            MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
            RequestBody requestBody = FormBody.create(mediaType, json);
            Request request = new Request.Builder()
                    .url(SERVICE_LOCATION+"third/an/"+FACE_METHOD)
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
                    .connectTimeout(30000, TimeUnit.MILLISECONDS)
                    .readTimeout(30000, TimeUnit.MILLISECONDS)
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
