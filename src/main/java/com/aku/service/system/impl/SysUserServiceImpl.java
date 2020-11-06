package com.aku.service.system.impl;

import com.aku.dao.system.SysUserDao;
import com.aku.model.system.SysUser;
import com.aku.service.system.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserDao sysUserDao;


    /**
     * 系统用户注册
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @Override
    public Map<String,Object> registerSysUser(SysUser sysUser) {
        Map<String,Object> map = new HashMap<String,Object>();
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
        SysUser sysUser1 = sysUserDao.loginSysUser(sysUser);
        if (sysUser1 != null){
            if (sysUser1.getPwd().equals(sysUser.getPwd())){
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
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @Override
    public Map<String, Object> loginSMSSysUser(SysUser sysUser) {
//        redisTemplate.
        return null;
    }
    /**
     * 发送短信验证码
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @Override
    public Map<String, Object> sendMMSLogin(SysUser sysUser) {

        return null;
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
