package com.api.app.service.login.impl;

import com.api.app.dao.login.AppLoginDao;
import com.api.app.service.login.AppLoginService;
import com.api.model.app.UserCode;
import com.api.model.app.UserLoginToken;
import com.api.model.basicArchives.UserResident;
import com.api.util.IdWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AppLoginServiceImpl implements AppLoginService {
    private static Map<String,Object> map = null;
    @Resource
    AppLoginDao appLoginDao;


    //验证码过期时间
    private final long EXPIRATION_TIME = 3*60*1000;

    @Override
    public Map<String, Object> sendMMSLogin(UserCode userCode) {
        map = new HashMap<>();
        // 验证码为后台随机生成
        final String CAPTCHA = String.valueOf(new Random().nextInt(899999) + 100000);
        // 手机号为前端传入
        final String MOBILE = userCode.getTel();

        //验证手机号格式
        Pattern p=Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m=p.matcher(MOBILE);
        boolean matches = m.matches();
        if (!matches){
            map.put("message","手机号格式有误");
            map.put("status",false);
            return map;
        }

        //根据手机号查询用户验证码
        UserCode userCode1 = appLoginDao.findUserCodeByTel(userCode.getTel());

        //填入验证码
        userCode.setCode(CAPTCHA);
        //填入验证码发送时间
        userCode.setCodeSendDate(new Date());
        int send = 0;
        if (userCode1 != null){
            //填入已存在的手机验证码信息id
            userCode.setId(userCode1.getId());
            //如果有相关手机验证码信息，修改验证码和验证码发送时间
            send = appLoginDao.updateUserCode(userCode);
        }else {
            //如果没有相关手机验证码信息，将验证码和验证码发送时间存入数据库
            send = appLoginDao.insertUserCode(userCode);
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
    public Map<String, Object> loginSMSUser(UserCode userCode) {
        map = new HashMap<>();
        //根据手机号查询手机验证码信息
        UserCode userCodeByTel = appLoginDao.findUserCodeByTel(userCode.getTel());
        if (userCodeByTel == null){
            map.put("message","验证码已过期");
            map.put("status",false);
            return map;
        }

        //删除手机验证码信息（防止一个验证码多次登录）
        appLoginDao.deleteUserCodeByTel(userCode.getTel());


        //校验验证码是否过期(判断相差时间是否超过3分钟)
        long time = new Date().getTime() - userCodeByTel.getCodeSendDate().getTime();
        if (time > EXPIRATION_TIME){
            map.put("message","验证码已过期");
            map.put("status",false);
            return map;
        }
        //校验验证码
        if (!userCode.getCode().equals(userCodeByTel.getCode())) {
            map.put("message","验证码错误");
            map.put("status",false);
            return map;
        }


        //根据手机号查询住户信息
        UserResident userResident = appLoginDao.findUserResidentByTel(userCode.getTel());


        if (userResident != null){
            //登录
            IdWorker idWorker = new IdWorker(1,1,1);
            long l = idWorker.nextId();


            UserLoginToken userLoginToken = new UserLoginToken();
            //填入登录token值
            userLoginToken.setUserLoginSession(l);
            //填入住户id
            userLoginToken.setResidentId(userResident.getId());
            //添加进数据库
            int insert = appLoginDao.insertLoginToken(userLoginToken);
            if (insert <= 0){
                throw new RuntimeException("登录失败");
            }
            map.put("token",l);
            //choose为1，登录成功后 app界面
            map.put("choose",1);
            map.put("message","登录成功，欢迎使用");
        }else {
            //注册
            //choose为2，注册界面
            map.put("choose",2);
            map.put("message","登录成功,请填写信息");
        }
        map.put("status",true);
        return map;
    }
}
