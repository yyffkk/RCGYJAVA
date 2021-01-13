package com.api.app.service.personalData.impl;

import com.api.app.dao.personalData.PersonalDataDao;
import com.api.app.service.personalData.PersonalDataService;
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
            map.put("message","修改昵称成功");
            map.put("status",true);
        }else {
            map.put("message","修改昵称失败");
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
        map.put("message","修改头像信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> updateTel(UserResident userResident) {
        map = new HashMap<>();
        int update = personalDataDao.updateTel(userResident);
        if (update >0){
            map.put("message","修改手机号成功");
            map.put("status",true);
        }else {
            map.put("message","修改手机号失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> sendTelUpdateCode(UserResident userResident, String oldTel) {
        map = new HashMap<>();
        // 验证码为后台随机生成
        final String CAPTCHA = String.valueOf(new Random().nextInt(899999) + 100000);
        // 手机号为前端传入
        final String MOBILE = userResident.getTel();

        //验证手机号格式
        Pattern p=Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m=p.matcher(MOBILE);
        boolean matches = m.matches();
        if (!matches){
            map.put("message","手机号格式有误");
            map.put("status",false);
            return map;
        }

        //查询是否是该旧手机号
        if (!userResident.getTel().equals(oldTel)){
            map.put("message","旧手机号输入不正确");
            map.put("status",false);
            return map;
        }

        //填入手机号修改验证码
        userResident.setTelUpdateCode(CAPTCHA);
        //填入手机号修改验证码发送日期
        userResident.setTelUpdateCodeSendTime(new Date());
        //修改 手机号修改验证码 和 手机号修改验证码发送时间
        int update = personalDataDao.sendTelUpdateCode(userResident);
        if (update <=0){
            map.put("message","验证码发送失败");
            map.put("status",false);
        }

        // 发送短信工具类
//        SmsSendUtil.send(CAPTCHA, MOBILE);

        map.put("message","验证码发送成功");
        map.put("code",CAPTCHA);
        map.put("status",true);
        return map;
    }
}
