package com.api.app.service.personalData.impl;

import com.api.app.dao.login.AppLoginDao;
import com.api.app.dao.personalData.PersonalDataDao;
import com.api.app.service.personalData.PersonalDataService;
import com.api.model.app.PersonalData;
import com.api.model.app.UpdateTel;
import com.api.model.app.UserCode;
import com.api.model.basicArchives.UserResident;
import com.api.util.UploadUtil;
import com.api.vo.app.PersonalDataVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PersonalDataServiceImpl implements PersonalDataService {
    private static Map<String,Object> map = null;
    @Resource
    PersonalDataDao personalDataDao;
    @Resource
    AppLoginDao appLoginDao;
    //验证码过期时间
    private final long EXPIRATION_TIME = 3*60*1000;


    @Override
    public PersonalDataVo findById(Integer id) {
        PersonalDataVo byId = personalDataDao.findById(id);
        if (byId != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("userResident", byId.getId(), "headSculpture");
            byId.setImgUrls(imgByDate);
        }
        return byId;
    }

    @Override
    public Map<String, Object> updateNickName(UserResident userResident) {
        map = new HashMap<>();
        //修改用户昵称
        int update = personalDataDao.updateNickName(userResident);
        if (update >0){
            map.put("message","昵称修改成功");
            map.put("status",true);
        }else {
            map.put("message","昵称修改失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> updateHeadPortrait(Integer id, String[] fileUrls) {
        map = new HashMap<>();
        try {
            UploadUtil uploadUtil = new UploadUtil();
            //先删除头像信息
            uploadUtil.delete("userResident",id,"headSculpture");
            //在添加头像信息
            uploadUtil.saveUrlToDB(fileUrls,"userResident",id,"headSculpture","600",30,20);
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
        map.put("message","头像信息修改成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> sendTelUpdateCode(UpdateTel updateTel) {
        map = new HashMap<>();
        // 验证码为后台随机生成
        final String CAPTCHA = String.valueOf(new Random().nextInt(899999) + 100000);
        // 手机号为前端传入
        final String MOBILE = updateTel.getNewTel();

        //验证手机号格式
        Pattern p=Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m=p.matcher(MOBILE);
        boolean matches = m.matches();
        if (!matches){
            map.put("message","手机号格式有误");
            map.put("status",false);
            return map;
        }

        //根据新手机号查询用户手机号修改验证码
        UpdateTel updateTel1 = personalDataDao.findTelUpdateCodeByTel(updateTel.getNewTel());


        //填入验证码
        updateTel.setCode(CAPTCHA);
        //填入验证码发送时间
        updateTel.setCodeSendDate(new Date());
        int send = 0;
        if (updateTel1 != null){
            //填入已存在的手机验证码信息id
            updateTel.setId(updateTel1.getId());
            //如果有相关手机验证码信息，修改验证码和验证码发送时间
            send = personalDataDao.updateTelUpdateCode(updateTel);
        }else {
            //如果没有相关手机验证码信息，将验证码和验证码发送时间存入数据库
            send = personalDataDao.insertTelUpdateCode(updateTel);
        }

        if (send <= 0){
            map.put("message","验证码发送失败");
            map.put("status",false);
            return map;
        }

        // 发送短信工具类
//        SmsSendUtil.send(CAPTCHA, MOBILE);
        map.put("code",CAPTCHA);
        map.put("message","验证码发送成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> updateTel(UpdateTel updateTel,String oldTel) {
        map = new HashMap<>();

        //根据新手机号查询手机验证码信息
        UpdateTel telUpdateByTel = personalDataDao.findUserTelUpdateByTel(updateTel.getNewTel());
        if (telUpdateByTel == null){
            map.put("message","验证码已失效");
            map.put("status",false);
            return map;
        }

        //删除手机验证码信息（防止一个验证码多次登录）
        personalDataDao.deleteUserTelUpdateByTel(updateTel.getNewTel());

        //验证手机号格式
        Pattern p=Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m=p.matcher(updateTel.getNewTel());
        boolean matches = m.matches();
        if (!matches){
            map.put("message","新手机号格式有误");
            map.put("status",false);
            return map;
        }


        //判断是否是该旧手机号
        if (!updateTel.getOldTel().equals(oldTel)){
            map.put("message","旧手机号输入不正确");
            map.put("status",false);
            return map;
        }


        //校验验证码是否过期(判断相差时间是否超过3分钟)
        long time = new Date().getTime() - telUpdateByTel.getCodeSendDate().getTime();
        if (time > EXPIRATION_TIME){
            map.put("message","验证码已过期");
            map.put("status",false);
            return map;
        }
        //校验验证码
        if (!telUpdateByTel.getCode().equals(updateTel.getCode())) {
            map.put("message","验证码错误");
            map.put("status",false);
            return map;
        }

        //根据新手机号查询住户信息
        UserResident userResident = appLoginDao.findUserResidentByTel(updateTel.getNewTel());

        if (userResident != null){
            map.put("message","此手机号已被注册");
            map.put("status",false);
            return map;
        }

        //修改手机号信息
        int update = personalDataDao.updateTel(updateTel);
        if (update >0){
            map.put("message","手机号修改成功");
            map.put("status",true);
        }else {
            map.put("message","手机号修改失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> updateSex(PersonalData personalData) {
        map = new HashMap<>();
        //修改性别信息
        int update = personalDataDao.updateSex(personalData);
        if (update >0){
            map.put("message","性别修改成功");
            map.put("status",true);
        }else {
            map.put("message","性别修改失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> updateBirthday(PersonalData personalData) {
        map = new HashMap<>();
        int update = personalDataDao.updateBirthday(personalData);
        if (update >0){
            map.put("message","出生日期修改成功");
            map.put("status",true);
        }else {
            map.put("message","出生日期修改失败");
            map.put("status",false);
        }
        return map;
    }
}
