package com.api.app.service.homePage.impl;

import com.api.app.dao.butler.AppActivityDao;
import com.api.app.dao.homePage.AppSearchDao;
import com.api.app.service.homePage.AppSearchService;
import com.api.model.app.AppActivityRegistration;
import com.api.util.UploadUtil;
import com.api.vo.app.AppActivityVo;
import com.api.vo.app.AppGambitVo;
import com.api.vo.app.AppSearchVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class AppSearchServiceImpl implements AppSearchService {
    @Resource
    AppSearchDao appSearchDao;
    @Resource
    AppActivityDao appActivityDao;
    private static Map<String,Object> map = null;

    @Override
    public Map<String, Object> search(String searchName, Integer id) {
        map = new HashMap<>();
        AppSearchVo appSearchVo = new AppSearchVo();
        //模糊查询社区活动信息
        List<AppActivityVo> appActivityVoList = appSearchDao.searchActivity(searchName);
        if (appActivityVoList != null && appActivityVoList.size()>0){
            for (AppActivityVo appActivityVo : appActivityVoList) {

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
        //填入社区活动搜索内容
        appSearchVo.setActivityVoList(appActivityVoList);

        //模糊查询帖子活动信息
        List<AppGambitVo> gambitVoList = appSearchDao.searchGambit(searchName);
        if (gambitVoList != null && gambitVoList.size()>0){
            for (AppGambitVo appGambitVo : gambitVoList) {
                //查询话题照片资源
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysGambit", appGambitVo.getId(), "gambitImg");
                appGambitVo.setImgUrl(imgByDate);
            }
        }
        //填入帖子活动搜索内容
        appSearchVo.setGambitVoList(gambitVoList);

        //模糊查询公告信息


        //模糊查询资讯信息


        map.put("message","请求成功");
        map.put("data",appSearchVo);
        map.put("status",true);
        return map;
    }
}
