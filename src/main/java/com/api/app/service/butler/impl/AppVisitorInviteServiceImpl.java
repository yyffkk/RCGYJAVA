package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppVisitorInviteDao;
import com.api.app.service.butler.AppVisitorInviteService;
import com.api.model.app.AppUserVisitorsInvite;
import com.api.model.app.AppUserVisitorsInviteSubmit;
import com.api.model.app.AppUserVisitorsUrl;
import com.api.util.IdWorker;
import com.api.util.UploadUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AppVisitorInviteServiceImpl implements AppVisitorInviteService {
    @Resource
    AppVisitorInviteDao appVisitorInviteDao;
    @Value("${res.visitShareTime}")
    private Integer visitShareTime;
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
            calendar.add(Calendar.HOUR,visitShareTime);
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

            //判断是否有照片？？？？？========== ？？？？？？？？
            //将图片发送给大华？？？？？========== ？？？？？？？？
            //判断返回是否成功,决定是否回滚操作？？？？？？？==========？？？？？？？

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
}
