package com.api.butlerApp.service.personalData.impl;

import com.api.butlerApp.dao.login.ButlerLoginDao;
import com.api.butlerApp.dao.personalData.ButlerPersonalDataDao;
import com.api.butlerApp.service.personalData.ButlerPersonalDataService;
import com.api.model.app.UpdateTel;
import com.api.model.basicArchives.UserResident;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.ButlerUpdateTel;
import com.api.util.UploadUtil;
import com.api.vo.butlerApp.ButlerPersonalDataVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ButlerPersonalDataServiceImpl implements ButlerPersonalDataService {
    private static Map<String,Object> map = null;
    @Resource
    ButlerPersonalDataDao butlerPersonalDataDao;
    @Resource
    ButlerLoginDao butlerLoginDao;

    //验证码过期时间
    private final long EXPIRATION_TIME = 3*60*1000;

    @Override
    public ButlerPersonalDataVo findById(Integer id) {
        ButlerPersonalDataVo byId = butlerPersonalDataDao.findById(id);
        if (byId != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysUser", byId.getId(), "headSculpture");
            byId.setImgUrls(imgByDate);
        }
        return byId;
    }

    @Override
    public Map<String, Object> updateNickName(SysUser sysUser) {
        map = new HashMap<>();
        //修改用户昵称
        int update = butlerPersonalDataDao.updateNickName(sysUser);
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
    public Map<String, Object> updateHeadPortrait(Integer id, String[] fileUrls) {
        map = new HashMap<>();
        try {
            UploadUtil uploadUtil = new UploadUtil();
            //先删除头像信息
            uploadUtil.delete("sysUser",id,"headSculpture");
            //在添加头像信息
            uploadUtil.saveUrlToDB(fileUrls,"sysUser",id,"headSculpture","600",30,20);
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
    public Map<String, Object> sendTelUpdateCode(ButlerUpdateTel butlerUpdateTel) {
        map = new HashMap<>();
        // 验证码为后台随机生成
        final String CAPTCHA = String.valueOf(new Random().nextInt(899999) + 100000);
        // 手机号为前端传入
        final String MOBILE = butlerUpdateTel.getNewTel();

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
        ButlerUpdateTel butlerUpdateTel1 = butlerPersonalDataDao.findTelUpdateCodeByTel(butlerUpdateTel.getNewTel());


        //填入验证码
        butlerUpdateTel.setCode(CAPTCHA);
        //填入验证码发送时间
        butlerUpdateTel.setCodeSendDate(new Date());
        int send = 0;
        if (butlerUpdateTel1 != null){
            //填入已存在的手机验证码信息id
            butlerUpdateTel.setId(butlerUpdateTel1.getId());
            //如果有相关手机验证码信息，修改验证码和验证码发送时间
            send = butlerPersonalDataDao.updateTelUpdateCode(butlerUpdateTel);
        }else {
            //如果没有相关手机验证码信息，将验证码和验证码发送时间存入数据库
            send = butlerPersonalDataDao.insertTelUpdateCode(butlerUpdateTel);
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
    public Map<String, Object> updateTel(ButlerUpdateTel butlerUpdateTel, String oldTel) {
        map = new HashMap<>();

        //根据新手机号查询手机验证码信息
        ButlerUpdateTel telUpdateByTel = butlerPersonalDataDao.findUserTelUpdateByTel(butlerUpdateTel.getNewTel());
        if (telUpdateByTel == null){
            map.put("message","验证码已失效");
            map.put("status",false);
            return map;
        }

        //删除手机验证码信息（防止一个验证码多次登录）
        butlerPersonalDataDao.deleteUserTelUpdateByTel(butlerUpdateTel.getNewTel());

        //验证手机号格式
        Pattern p=Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m=p.matcher(butlerUpdateTel.getNewTel());
        boolean matches = m.matches();
        if (!matches){
            map.put("message","新手机号格式有误");
            map.put("status",false);
            return map;
        }


        //判断是否是该旧手机号
        if (!butlerUpdateTel.getOldTel().equals(oldTel)){
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
        if (!telUpdateByTel.getCode().equals(butlerUpdateTel.getCode())) {
            map.put("message","验证码错误");
            map.put("status",false);
            return map;
        }

        //根据新手机号查询住户信息
        SysUser sysUser = butlerLoginDao.findSysUserByTel(butlerUpdateTel.getNewTel());

        if (sysUser != null){
            map.put("message","此手机号已被注册");
            map.put("status",false);
            return map;
        }

        //修改手机号信息
        int update = butlerPersonalDataDao.updateTel(butlerUpdateTel);
        if (update >0){
            map.put("message","手机号修改成功");
            map.put("status",true);
        }else {
            map.put("message","手机号修改失败");
            map.put("status",false);
        }
        return map;
    }
}
