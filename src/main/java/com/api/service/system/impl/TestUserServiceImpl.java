package com.api.service.system.impl;

import com.api.dao.system.TestDao;
import com.api.model.system.TestUser;
import com.api.service.system.TestUserService;
import com.api.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TestUserServiceImpl implements TestUserService {
    private final Map<String, Object> map = new HashMap<>();

    @Resource
    TestDao testDao;

    @Resource
    private RedisUtil redisUtil;

    /**
     * 系统用户注册
     * @param testUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @Override
    public Map<String,Object> registerSysUser(TestUser testUser) {
        Map<String,Object> map = new HashMap<>();
        int integer = testDao.registerSysUser(testUser);
        if (integer >0){
            map.put("message","注册成功");
            map.put("status",true);
        }else {
            map.put("message","注册失败");
            map.put("status",false);
        }
        return map;
    }

    /**
     * 系统用户登录
     * @param testUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @Override
    public Map<String,Object> loginSysUser(TestUser testUser){
        Map<String,Object> map = new HashMap<>();
        TestUser testUser1 = testDao.loginSysUser(testUser);
        if (testUser1 != null){
            if (testUser1.getPwd().equals(testUser.getPwd())){
                map.put("message","登录成功");
                map.put("status",true);
            }else {
                map.put("message","登录失败，用户名或密码不正确");
                map.put("status",false);
            }
        }else {
            map.put("message","登录失败，用户名不存在");
            map.put("status",false);
        }
        return map;
    }
    /**
     * 系统用户短信登录
     * @param testUser 系统用户model
     * @param captcha 验证码
     * @return map {message 消息, status 状态}
     */
    @Override
    public Map<String, Object> loginSMSSysUser(TestUser testUser, String captcha) {
        // 此验证码和手机号均为前端传入
//        String MOBILE = testUser.getTel();

        // 校验验证码是否存在Redis中
        if (!redisUtil.exists(testUser.getTel())) {
            map.put("message","验证码已过期");
            map.put("status",false);
            return map;
        }

        // 获取Redis中的验证码
        String tempCaptcha = redisUtil.get(testUser.getTel());

        // 校验验证码
        if (!captcha.equals(tempCaptcha)) {
            map.put("message","验证码错误");
            map.put("status",false);
            return map;
        }

        // 删除Redis中的验证码
        redisUtil.delete(testUser.getTel());
        map.put("message","验证码正确");
        map.put("status",true);
        return map;
    }
    /**
     * 发送短信验证码
     * @param testUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @Override
    public Map<String, Object> sendMMSLogin(TestUser testUser) {
        // 验证码为后台随机生成
        String CAPTCHA = "666666";
        // 手机号为前端传入
//        final String MOBILE = testUser.getTel();

        //验证手机号格式
        Pattern p=Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m=p.matcher(testUser.getTel());
        boolean matches = m.matches();
        if (!matches){
            map.put("message","手机号格式有误");
            map.put("status",false);
            return map;
        }

        // 发送短信工具类
//        SmsSendUtil.send(CAPTCHA, MOBILE);

        // 将验证码存入Redis
        redisUtil.set(testUser.getTel(), CAPTCHA);
        // 设置验证码过期时间为2分钟
        redisUtil.expire(testUser.getTel(), 60*2);

        map.put("message","验证码发送成功");
        map.put("status",true);
        return map;
    }
}
