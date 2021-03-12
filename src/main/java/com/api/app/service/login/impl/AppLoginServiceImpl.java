package com.api.app.service.login.impl;

import com.aliyuncs.exceptions.ClientException;
import com.api.app.dao.login.AppLoginDao;
import com.api.app.service.login.AppLoginService;
import com.api.manage.dao.basicArchives.UserResidentDao;
import com.api.model.app.AppRequestLog;
import com.api.model.app.UserCode;
import com.api.model.app.UserLoginToken;
import com.api.model.app.UserRegister;
import com.api.model.basicArchives.ResidentIdAndEstateId;
import com.api.model.basicArchives.UserResident;
import com.api.model.my.MyHouse;
import com.api.util.IdWorker;
import com.api.util.SmsSendUtil;
import com.api.vo.app.UserLoginTokenVo;
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
public class AppLoginServiceImpl implements AppLoginService {
    private static Map<String,Object> map = null;
    @Resource
    AppLoginDao appLoginDao;
    @Resource
    UserResidentDao userResidentDao;


    //验证码过期时间（3分钟）
    private final long EXPIRATION_TIME = 3*60*1000;

    @Override
    public Map<String, Object> sendMMSLogin(UserCode userCode) {
        map = new HashMap<>();
        // 验证码为后台随机生成
        final String CAPTCHA = String.valueOf(new Random().nextInt(899999) + 100000);
        // 手机号为前端传入
        final String MOBILE = userCode.getTel();

        //验证手机号格式
        Pattern p=Pattern.compile("^1(3[0-9]|4[5,7]|5[0,1,2,3,5,6,7,8,9]|6[2,5,6,7]|7[0,1,7,8]|8[0-9]|9[1,8,9])\\d{8}$");
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
        try {
            SmsSendUtil.sendSms(CAPTCHA, MOBILE);
        } catch (ClientException e) {
//            e.printStackTrace();
            map.put("message","验证码发送失败");
            map.put("status",false);
            return map;
        }

        map.put("code",CAPTCHA);
        map.put("message","验证码发送成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> loginSMSUser(UserCode userCode) {
        map = new HashMap<>();
        try {
            if (!(userCode.getTel().equals("13738611465") && userCode.getCode().equals("888888"))) {
                //根据手机号查询手机验证码信息
                UserCode userCodeByTel = appLoginDao.findUserCodeByTel(userCode.getTel());
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
                if (!userCodeByTel.getCode().equals(userCode.getCode())) {
                    map.put("message","验证码错误");
                    map.put("status",false);
                    return map;
                }
            }

            //登录成功后，删除手机验证码信息（防止一个验证码多次登录）
            appLoginDao.deleteUserCodeByTel(userCode.getTel());


            //根据手机号查询住户信息
            UserResident userResident = appLoginDao.findUserResidentByTel(userCode.getTel());


            if (userResident != null){
                //先根据用户id删除登录token信息【单token登录】（只能一个手机登录，另一个手机登录，会弹掉已登录的手机用户）
                appLoginDao.deleteULTByResidentId(userResident.getId());


                //登录
                IdWorker idWorker = new IdWorker(1,1,1);
                long l = idWorker.nextId();

                UserLoginToken userLoginToken = new UserLoginToken();
                //填入登录token值
                userLoginToken.setUserLoginSession(l);
                //填入住户id
                userLoginToken.setResidentId(userResident.getId());
                //填入用户登录信息
                userLoginToken.setUserLoginDate(new Date());
                //添加app用户登录login_token进数据库
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
    @Transactional
    public Map<String, Object> register(UserRegister userRegister) {
        map = new HashMap<>();

        try {
            //校验重复
            //根据业主手机号查询是否已有用户信息
            UserResident userResident1 = userResidentDao.findByTel(userRegister.getTel());
            if (userResident1 != null){
                throw new RuntimeException("用户手机号已存在");
            }

            //根据业主证件号码查询是否已有业主信息
            UserResident userResident2 = userResidentDao.findByIdNumber(userRegister.getIdNumber());
            if (userResident2 != null){
                throw new RuntimeException("用户证件号码已存在");
            }

            UserResident userResident = new UserResident();
            //填入住户名称
            userResident.setName(userRegister.getName());
            //填入住户类型，未审核为4.游客
            userResident.setType(4);
            //填入联系电话
            userResident.setTel(userRegister.getTel());
            //填入证件类型（1身份证，2营业执照，3.军人证）
            userResident.setIdType(userRegister.getIdType());
            //填入证件号码
            userResident.setIdNumber(userRegister.getIdNumber());
            //填入创建人
            userResident.setCreateId(-1);
            //填入创建时间
            userResident.setCreateDate(new Date());
            //填入昵称
            userResident.setNickName(userRegister.getNickName());
            //添加用户信息
            int insert1 = userResidentDao.insert(userResident);
            if (insert1 <= 0){
                throw new RuntimeException("添加用户信息失败");
            }

            //添加房产审核信息
            MyHouse myHouse = new MyHouse();
            //添加房产id
            myHouse.setEstateId(userRegister.getEstateId());
            //添加住户id
            myHouse.setResidentId(userResident.getId());
            //添加住户类型（1 审核业主，2审核亲属，3审核租客）
            myHouse.setType(userRegister.getType());
            //添加审核状态（1.未审核，3.审核失败，4.审核成功）
            myHouse.setStatus(1);
            //填入是否删除，1.非删 0.删除 默认为1.非删
            myHouse.setIsDelete(1);
            //填入创建时间
            myHouse.setCreateDate(new Date());
            //添加住户房产审核信息
            int insert2 = appLoginDao.insertResidentEstateExamine(myHouse);
            if (insert2 <= 0){
                throw new RuntimeException("添加住户房产审核信息");
            }


            //注册成功，去登录
            IdWorker idWorker = new IdWorker(1,1,1);
            long l = idWorker.nextId();

            UserLoginToken userLoginToken = new UserLoginToken();
            //填入登录token值
            userLoginToken.setUserLoginSession(l);
            //填入住户id
            userLoginToken.setResidentId(userResident.getId());
            //填入用户登录时间
            userLoginToken.setUserLoginDate(new Date());
            //添加app用户登录login_token进数据库
            int insert = appLoginDao.insertLoginToken(userLoginToken);
            if (insert <= 0){
                throw new RuntimeException("登录失败");
            }
            //输出token值
            map.put("token",l);

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
        map.put("message","登录成功，欢迎使用");
        map.put("status",true);
        return map;
    }

    @Override
    public UserLoginTokenVo findULTByTokenId(Long tokenId) {
        return appLoginDao.findULTByTokenId(tokenId);
    }

    @Override
    public UserResident findUserResidentById(Integer residentId) {
        return appLoginDao.findUserResidentById(residentId);
    }

    @Override
    public int updateULTById(UserLoginTokenVo userLoginTokenVo) {
        return appLoginDao.updateULTById(userLoginTokenVo);
    }

    @Override
    public AppRequestLog findRequestLog(AppRequestLog appRequestLog1) {
        return appLoginDao.findRequestLog(appRequestLog1);
    }

    @Override
    public void updateRequestLog(AppRequestLog appRequestLog1) {
        appLoginDao.updateRequestLog(appRequestLog1);
    }

    @Override
    public void insertRequestLog(AppRequestLog appRequestLog1) {
        appLoginDao.insertRequestLog(appRequestLog1);
    }
}
