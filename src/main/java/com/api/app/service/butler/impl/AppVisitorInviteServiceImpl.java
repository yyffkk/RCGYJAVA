package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppVisitorInviteDao;
import com.api.app.service.butler.AppVisitorInviteService;
import com.api.manage.dao.basicArchives.CpmBuildingUnitEstateDao;
import com.api.model.app.AppUserQRVisitorsInviteSubmit;
import com.api.model.app.AppUserVisitorsInvite;
import com.api.model.app.AppUserVisitorsInviteSubmit;
import com.api.model.app.AppUserVisitorsUrl;
import com.api.util.IdWorker;
import com.api.util.UploadUtil;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AppVisitorInviteServiceImpl implements AppVisitorInviteService {
    @Resource
    AppVisitorInviteDao appVisitorInviteDao;
    @Resource
    CpmBuildingUnitEstateDao cpmBuildingUnitEstateDao;
    @Value("${res.visitShareTime}")
    private Integer VISIT_SHARE_TIME;
    @Value("${res.visitorsUrl}")
    private String VISITORS_URL;
    @Value("${res.communityUrl}")
    private String COMMUNITY_URL;
    @Value("${lilin.districtNumber}")
    private String DISTRICT_NUMBER;
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
            if (new Date().getTime() > visitorsInviteSubmit.getVisitDateStart().getTime()){//如果当前时间大于到访时间开始，则提示预计到访时间不可小于当前时间
                throw new RuntimeException("预计到访时间不可小于当前时间");
            }
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(visitorsInviteSubmit.getImgList(),"userVisitorsNew",visitorsInviteSubmit.getId(),"selfie","600",30,20);
            //修改新版访客信息
            int update = appVisitorInviteDao.updateUserVisitorsNew(visitorsInviteSubmit);
            if (update <= 0){
                throw new RuntimeException("修改新版访客信息失败");
            }

            //根据拜访房产id查询设备号
            String deviceNumber = cpmBuildingUnitEstateDao.findDeviceNumberByEstateId(visitorsInviteSubmit.getEstateId());

            //判断是否成功发送给大华
            Boolean status = isUpload(visitorsInviteSubmit.getImgList(), deviceNumber);
            if (!status){
                throw new RuntimeException("照片发送失败");
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
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> QRSubmit(AppUserQRVisitorsInviteSubmit qrVisitorsInviteSubmit) {
        map = new HashMap<>();
        try {
            if (new Date().getTime() > qrVisitorsInviteSubmit.getVisitDateStart().getTime()){//如果当前时间大于到访时间开始，则提示预计到访时间不可小于当前时间
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

            //根据拜访房产id查询设备号
            String deviceNumber = cpmBuildingUnitEstateDao.findDeviceNumberByEstateId(qrVisitorsInviteSubmit.getEstateId());

            //判断是否成功发送给大华
            Boolean status = isUpload(qrVisitorsInviteSubmit.getImgList(),deviceNumber);
            if (!status){
                throw new RuntimeException("照片发送失败");
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


    private Boolean isUpload(String[] imgList, String deviceNumber) {
        //=====判断是否有照片
        if (imgList.length <= 0){
            return false;
        }

        //=====将图片发送给大华
        //取第一张照片
        String imgUrl = imgList[0];

        try {
            //传入真实路径（没有文件服务器的情况，用项目目录下的static）
            // 获取项目同级目录，传入static中
            String realPath = new File(ResourceUtils.getURL("classpath:").getPath()).getParentFile().getParentFile().getParent()+"/static";
            File file = new File(realPath+imgUrl);
            InputStream inputStream = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile(file.getName(), inputStream);

            //TODO 接入第三方接口
            OkHttpClient httpClient = new OkHttpClient();
            MultipartBody multipartBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("jpeg", multipartFile.getOriginalFilename(),
                            RequestBody.create(MediaType.parse("multipart/form-data;charset=utf-8"),
                                    multipartFile.getBytes()))
                    .addFormDataPart("code","单元码")
                    .addFormDataPart("ts", String.valueOf(new Date()))
                    .addFormDataPart("te", String.valueOf(new Date()))
                    .build();

            Request request = new Request.Builder()
                    .url(VISITORS_URL)
                    .post(multipartBody)
                    .build();

            Response response = httpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                if (body != null) {
                    //获取返回值
                    String result = body.string();
                    //=====判断返回是否成功
                    if ("true".equals(result)){
                        return true;
                    }else {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
