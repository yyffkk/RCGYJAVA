package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppActivityDao;
import com.api.app.service.butler.AppActivityService;
import com.api.model.app.AppActivityRegistration;
import com.api.util.UploadUtil;
import com.api.vo.app.AppActivityDetailVo;
import com.api.vo.app.AppActivityRegistrationVo;
import com.api.vo.app.AppActivityVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class AppActivityServiceImpl implements AppActivityService {
    @Resource
    AppActivityDao appActivityDao;
    private static Map<String,Object> map = null;

    @Override
    public List<AppActivityVo> list(Integer id) {
        List<AppActivityVo> list = appActivityDao.list();
        if (list != null && list.size()>0){
            for (AppActivityVo appActivityVo : list) {

                //查询是否报过名与填入状态信息
                AppActivityRegistration appActivityRegistration = new AppActivityRegistration();
                appActivityRegistration.setActivityId(appActivityVo.getId());
                appActivityRegistration.setResidentId(id);
                List<AppActivityRegistration> registrationList = appActivityDao.findRegistrationByIds(appActivityRegistration);
                if (registrationList != null && registrationList.size()>0){
                    //已报名
                    appActivityVo.setStatus(4);
                }else {
                    Date date = new Date();
                    if (date.getTime() < appActivityVo.getRegistrationStartTime().getTime()){
                        //状态为1.未开始
                        appActivityVo.setStatus(1);
                    }else if (date.getTime() > appActivityVo.getRegistrationEndTime().getTime()){
                        //状态为3.已结束
                        appActivityVo.setStatus(3);
                    }else {
                        //状态为2.进行中
                        appActivityVo.setStatus(2);
                    }
                }

                //填入社区活动照片资源
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysActivityManagement", appActivityVo.getId(), "activityImg");
                appActivityVo.setImgUrls(imgByDate);
                //根据社区活动主键id查询相关报名人信息
                List<Integer> ids = appActivityDao.findResidentIdById(appActivityVo.getId());
                if (ids != null && ids.size()>0){
                    List<VoResourcesImg> imgList = new ArrayList<>();
                    //最多只取3个头像
                    int i = 3;
                    for (Integer id2 : ids) {
                        i = i-1;
                        List<VoResourcesImg> imgByDate1 = uploadUtil.findImgByDate("userResident", id2, "headSculpture");
                        if (imgByDate1 != null && imgByDate1.size()>0){
                            imgList.add(imgByDate1.get(0));
                        }
                        if (i == 0){
                            break;
                        }
                    }
                    appActivityVo.setHeadImgURls(imgList);
                }

            }
        }
        return list;
    }

    @Override
    public Map<String, Object> findById(Integer activityId) {
        map = new HashMap<>();
        AppActivityDetailVo activityDetailVo = appActivityDao.findById(activityId);
        if (activityDetailVo != null){
            //填入社区活动照片资源
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysActivityManagement", activityDetailVo.getId(), "activityImg");
            activityDetailVo.setImgUrls(imgByDate);

            //根据社区活动主键id查询相关报名人信息
            List<Integer> ids = appActivityDao.findResidentIdById(activityDetailVo.getId());
            if (ids != null && ids.size()>0){
                List<VoResourcesImg> imgList = new ArrayList<>();
                //最多只取3个头像
                int i = 3;
                for (Integer id2 : ids) {
                    i = i-1;
                    List<VoResourcesImg> imgByDate1 = uploadUtil.findImgByDate("userResident", id2, "headSculpture");
                    if (imgByDate1 != null && imgByDate1.size()>0){
                        imgList.add(imgByDate1.get(0));
                    }
                    if (i == 0){
                        break;
                    }
                }
                activityDetailVo.setHeadImgURls(imgList);
            }

            //查询报名人数
            int num = appActivityDao.countRegistrationNum(activityDetailVo.getId());
            activityDetailVo.setCountRegistration(num);
        }

        map.put("message","请求成功");
        map.put("data",activityDetailVo);
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> signUp(Integer id, Integer activityId) {
        map = new HashMap<>();
        try {
            if (id == 0){
                throw new RuntimeException("游客不可报名，请先登录");
            }
            //查询时间是否处于参与时间
            AppActivityDetailVo activityDetailVo = appActivityDao.findById(activityId);
            Date date = new Date();
            if (date.getTime() < activityDetailVo.getRegistrationStartTime().getTime()){
                //未开始
                throw new RuntimeException("活动未开始");
            }else if (date.getTime() > activityDetailVo.getRegistrationEndTime().getTime()){
                //已结束
                throw new RuntimeException("活动已结束");
            }

            //查询用户是否报名过
            AppActivityRegistration appActivityRegistration = new AppActivityRegistration();
            appActivityRegistration.setActivityId(activityId);
            appActivityRegistration.setResidentId(id);
            List<AppActivityRegistration> registrationList = appActivityDao.findRegistrationByIds(appActivityRegistration);
            if (registrationList != null && registrationList.size()>0){
                //已报名
                throw new RuntimeException("用户已报名");
            }

            //用户报名
            appActivityRegistration.setRegistrationDate(new Date());
            int insert = appActivityDao.insertRegistration(appActivityRegistration);
            if (insert <= 0){
                throw new RuntimeException("报名失败");
            }

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

        map.put("message","报名成功");
        map.put("status",true);
        return map;
    }

    @Override
    public List<AppActivityRegistrationVo> participantsList(Integer activityId) {
        List<AppActivityRegistrationVo> registrationVoList = appActivityDao.participantsList(activityId);
        if (registrationVoList != null && registrationVoList.size()>0){
            for (AppActivityRegistrationVo registrationVo : registrationVoList) {
                //查询用户头像信息
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate1 = uploadUtil.findImgByDate("userResident", registrationVo.getId(), "headSculpture");
                registrationVo.setImgUrl(imgByDate1);

                //隐藏用户手机号中间部分信息
                registrationVo.setTel(registrationVo.getTel().replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2"));
            }
        }
        return registrationVoList;
    }
}
