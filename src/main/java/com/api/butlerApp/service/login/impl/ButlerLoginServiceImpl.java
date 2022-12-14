package com.api.butlerApp.service.login.impl;

import com.aliyuncs.exceptions.ClientException;
import com.api.butlerApp.dao.login.ButlerLoginDao;
import com.api.butlerApp.service.login.ButlerLoginService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.ButlerLoginToken;
import com.api.model.butlerApp.ButlerUserCode;
import com.api.util.IdWorker;
import com.api.util.SmsSendUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ButlerLoginServiceImpl implements ButlerLoginService {
    @Resource
    ButlerLoginDao butlerLoginDao;

    //验证码过期时间（3分钟）
    private final long EXPIRATION_TIME = 3*60*1000;
    private static Map<String,Object> map = null;

    @Override
    public Map<String, Object> sendMMSLogin(ButlerUserCode userCode) {
        map = new HashMap<>();
        // 验证码为后台随机生成
        final String CAPTCHA = String.valueOf(new Random().nextInt(899999) + 100000);
        // 手机号为前端传入
        final String MOBILE = userCode.getTel();

        //验证手机号格式
        Pattern p=Pattern.compile("^1[3456789]\\d{9}$");
        Matcher m=p.matcher(MOBILE);
        boolean matches = m.matches();
        if (!matches){
            map.put("message","手机号格式有误");
            map.put("status",false);
            return map;
        }

        //根据手机号查询物业用户信息
        SysUser sysUserByTel = butlerLoginDao.findSysUserByTel(MOBILE);
        if (sysUserByTel == null){
            map.put("message","该用户不存在");
            map.put("status",false);
            return map;
        }
        if (sysUserByTel.getIsDelete() == 0){
            map.put("message","该用户已被删除");
            map.put("status",false);
            return map;
        }

        if (sysUserByTel.getStatus() == 3 || sysUserByTel.getStatus() == 4){
            map.put("message","该用户已被停用");
            map.put("status",false);
            return map;
        }else if (sysUserByTel.getStatus() == 2){
            map.put("message","该用户已被禁止登录");
            map.put("status",false);
            return map;
        }

        //根据手机号查询用户验证码
        ButlerUserCode userCode1 = butlerLoginDao.findUserCodeByTel(userCode.getTel());

        //填入验证码
        userCode.setCode(CAPTCHA);
        //填入验证码发送时间
        userCode.setCodeSendDate(new Date());
        int send = 0;
        if (userCode1 != null){
            //填入已存在的手机验证码信息id
            userCode.setId(userCode1.getId());
            //如果有相关手机验证码信息，修改验证码和验证码发送时间
            send = butlerLoginDao.updateUserCode(userCode);
        }else {
            //如果没有相关手机验证码信息，将验证码和验证码发送时间存入数据库
            send = butlerLoginDao.insertUserCode(userCode);
        }

        if (send <= 0){
            map.put("message","验证码发送失败");
            map.put("status",false);
            return map;
        }

        //如果不等于默认登录账号，则发送验证码
        if (!"13738611465".equals(MOBILE)){
            // 发送短信工具类
            try {
                SmsSendUtil.sendSms(CAPTCHA, MOBILE);
            } catch (ClientException e) {
//            e.printStackTrace();
                map.put("message","验证码发送失败");
                map.put("status",false);
                return map;
            }
        }

//        map.put("code",CAPTCHA);
        map.put("message","验证码发送成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> loginSMSUser(ButlerUserCode butlerUserCode) {
        map = new HashMap<>();
        try {
            if (!(butlerUserCode.getTel().equals("13738611465") && butlerUserCode.getCode().equals("888888"))&&!(butlerUserCode.getTel().equals("17377550883") && butlerUserCode.getCode().equals("888888"))) {
                //根据手机号查询手机验证码信息
                ButlerUserCode userCodeByTel = butlerLoginDao.findUserCodeByTel(butlerUserCode.getTel());
                if (userCodeByTel == null){
                    map.put("message","验证码已失效");
                    map.put("status",false);
                    return map;
                }


                //校验验证码是否过期(判断相差时间是否超过3分钟)
                long time = new Date().getTime() - userCodeByTel.getCodeSendDate().getTime();
                if (time > EXPIRATION_TIME){
                    map.put("message","验证码已过期");
                    map.put("status",false);
                    return map;
                }
                //校验验证码
                if (!userCodeByTel.getCode().equals(butlerUserCode.getCode())) {
                    map.put("message","验证码错误");
                    map.put("status",false);
                    return map;
                }
            }

            //登录成功后，删除手机验证码信息（防止一个验证码多次登录）
            butlerLoginDao.deleteUserCodeByTel(butlerUserCode.getTel());


            //根据手机号查询管家用户信息
            SysUser sysUser = butlerLoginDao.findSysUserByTel(butlerUserCode.getTel());


            if (sysUser != null){
                //先根据用户id删除登录token信息【单token登录】（只能一个手机登录，另一个手机登录，会弹掉已登录的手机用户）
                butlerLoginDao.deleteULTByUserId(sysUser.getId());


                //登录
                IdWorker idWorker = new IdWorker(1,1,1);
                long l = idWorker.nextId();

                ButlerLoginToken butlerLoginToken = new ButlerLoginToken();
                //填入登录token值
                butlerLoginToken.setButlerLoginSession(l);
                //填入管家用户id
                butlerLoginToken.setSysUserId(sysUser.getId());
                //填入用户登录信息
                butlerLoginToken.setButlerLoginDate(new Date());
                //添加app用户登录login_token进数据库
                int insert = butlerLoginDao.insertLoginToken(butlerLoginToken);
                if (insert <= 0){
                    throw new RuntimeException("登录失败");
                }
                map.put("token",l);
                //choose为1，登录成功后 app界面
//                map.put("choose",1);
                map.put("message","登录成功，欢迎使用");
            }else {
                //注册
                //choose为2，注册界面
//                map.put("choose",2);
//                map.put("message","登录成功,请填写信息");
                throw new RuntimeException("登录失败");
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
        map.put("status",true);
        return map;
    }

    @Override
    public ButlerLoginToken findBLTByTokenId(Long tokenId) {
        return butlerLoginDao.findBLTByTokenId(tokenId);
    }

    @Override
    public SysUser findSysUserById(Integer sysUserId) {
        return butlerLoginDao.findSysUserById(sysUserId);
    }

    @Override
    public int updateBLTById(ButlerLoginToken butlerLoginToken) {
        return butlerLoginDao.updateBLTById(butlerLoginToken);
    }
}
