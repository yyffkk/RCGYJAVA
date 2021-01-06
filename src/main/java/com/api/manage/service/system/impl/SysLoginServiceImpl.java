package com.api.manage.service.system.impl;

import com.api.manage.dao.system.SysLoginDao;
import com.api.model.system.SysUser;
import com.api.manage.service.system.SysLoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SysLoginServiceImpl implements SysLoginService {
    @Resource
    SysLoginDao sysUserDao;

    //验证码过期时间
    private final long EXPIRATION_TIME = 3*60*1000;

    /**
     * 系统用户注册
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @Override
    public Map<String,Object> registerSysUser(SysUser sysUser) {
        Map<String,Object> map = new HashMap<>();
        //初始化非删
        sysUser.setIsDelete(1);
        //初始化状态
        sysUser.setStatus(1);
        //初始化创建时间
        sysUser.setCreateDate(new Date());
        //判断注册参数是否可用
        boolean registerParam = isRegisterParam(sysUser);
        if (registerParam){
            int integer = sysUserDao.registerSysUser(sysUser);
            if (integer >0){
                map.put("message","注册成功");
                map.put("status",true);
            }else {
                map.put("message","注册失败");
                map.put("status",false);
            }
        }else {
            map.put("message","输入参数有误");
            map.put("status",false);
        }
        return map;
    }

    /**
     * 系统用户登录
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @Override
    public Map<String,Object> loginSysUser(SysUser sysUser){
        Map<String,Object> map = new HashMap<>();
        //将用户封装成token
        AuthenticationToken token = new UsernamePasswordToken(sysUser.getUserName(), sysUser.getPwd());
        //获取当前的Subject
        Subject subject = SecurityUtils.getSubject();
        try {
            //登录并存入该用户信息
            subject.login(token);

            //认证成功
            map.put("token",subject.getSession().getId());
            map.put("message","登录成功");
            map.put("status",true);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            //认证失败
            map.put("message","登录失败，用户名或密码不正确");
            map.put("status",false);
        }
        return map;
    }
    /**
     * 系统用户短信登录(此验证码和手机号均为前端传入)
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @Override
    public Map<String, Object> loginSMSSysUser(SysUser sysUser) {
        Map<String, Object> map = new HashMap<>();

        //根据手机号查询用户信息
        SysUser sysUser1 = sysUserDao.findByTel(sysUser.getTel());
        if (sysUser1 == null){
            //如果没有此手机号，则返回无此手机号
            map.put("message","无此手机号");
            map.put("status",false);
            return map;
        }

        if (sysUser1.getCodeSendDate() == null){
            map.put("message","验证码已过期");
            map.put("status",false);
            return map;
        }

        //给验证码 发送时间减去过期时间（防止一个验证码多次登录）
        Date date = new Date(sysUser1.getCodeSendDate().getTime() - EXPIRATION_TIME);
        sysUser.setCodeSendDate(date);
        //修改验证码发送时间
        sysUserDao.updateCodeDateByTel(sysUser);


        //校验验证码是否过期(判断相差时间是否超过3分钟)
        long time = new Date().getTime() - sysUser1.getCodeSendDate().getTime();
        if (time > EXPIRATION_TIME){
            map.put("message","验证码已过期");
            map.put("status",false);
            return map;
        }
        //校验验证码
        if (!sysUser.getCode().equals(sysUser1.getCode())) {
            map.put("message","验证码错误");
            map.put("status",false);
            return map;
        }

        //登录
        //将用户封装成token
        AuthenticationToken token = new UsernamePasswordToken(sysUser1.getUserName(), sysUser1.getPwd());
        //获取当前的Subject
        Subject subject = SecurityUtils.getSubject();
        //登录并存入该用户信息
        subject.login(token);


        map.put("token",subject.getSession().getId());
        map.put("message","验证码正确");
        map.put("status",true);
        return map;
    }
    /**
     * 发送短信验证码
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @Override
    public Map<String, Object> sendMMSLogin(SysUser sysUser) {
        Map<String, Object> map = new HashMap<>();
        // 验证码为后台随机生成
        final String CAPTCHA = String.valueOf(new Random().nextInt(899999) + 100000);
        // 手机号为前端传入
        final String MOBILE = sysUser.getTel();

        //验证手机号格式
        Pattern p=Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m=p.matcher(MOBILE);
        boolean matches = m.matches();
        if (!matches){
            map.put("message","手机号格式有误");
            map.put("status",false);
            return map;
        }
        //根据手机号查询用户信息
        SysUser sysUser1 = sysUserDao.findByTel(sysUser.getTel());
        if (sysUser1 == null){
            //如果没有此手机号，则返回无此手机号
            map.put("message","无此手机号");
            map.put("status",false);
            return map;
        }



        //填入验证码
        sysUser.setCode(CAPTCHA);
        //填入验证码发送时间
        sysUser.setCodeSendDate(new Date());
        //将验证码和验证码发送时间存入数据库
        int update = sysUserDao.updateCodeByTel(sysUser);
        if (update <= 0){
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

    /**
     * 根据userName查找用户信息
     * @param userName 系统用户名称
     * @return sysUser 系统用户model
     */
    @Override
    public SysUser findByUserName(String userName) {
        return sysUserDao.findByUserName(userName);
    }
    /**
     * 系统用户登出
     * @return map {message 消息, status 状态}
     */
    @Override
    public Map<String, Object> logout() {
        Map<String, Object> map = new HashMap<>();
        try {
            //获得当前的Subject
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            map.put("message","登出成功");
            map.put("status",true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","登出失败");
            map.put("status",false);
        }
        return map;
    }

    /**
     * 判断注册参数是否可用
     * @param sysUser 系统用户model
     */
    private boolean isRegisterParam(SysUser sysUser) {
        boolean b = true;
        if (sysUser.getUserName() == null || sysUser.getPwd() == null || sysUser.getActualName() ==null
        || sysUser.getTel() == null || sysUser.getSex() == null || sysUser.getUserCode() == null
        || sysUser.getIdCard() == null || sysUser.getOrganizationId() == null || sysUser.getPositionId() == null
        || sysUser.getRoleId() == null || sysUser.getStatus() == null || sysUser.getCreateId() == null){
            b=false;
        }
        return b;
    }
}
