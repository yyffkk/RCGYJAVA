package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppNewsDao;
import com.api.app.service.butler.AppNewsService;
import com.api.model.app.SearchAppNews;
import com.api.util.UploadUtil;
import com.api.vo.app.AppNewsRotationVo;
import com.api.vo.app.AppNewsVo;
import com.api.vo.app.AppNewsVoFBI;
import com.api.vo.app.IdAndName;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppNewsServiceImpl implements AppNewsService {
    private static Map<String,Object> map = null;
    @Resource
    AppNewsDao appNewsDao;

    @Override
    public Map<String, Object> categoryList() {
        map = new HashMap<>();
        List<IdAndName> idAndNames = appNewsDao.findAllCategory();
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",idAndNames);
        return map;
    }

    @Override
    public List<AppNewsVo> newsList(SearchAppNews searchAppNews) {
        map = new HashMap<>();
        List<AppNewsVo> appNewsVoList = appNewsDao.newsList(searchAppNews);
        if (appNewsVoList != null && appNewsVoList.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (AppNewsVo appNewsVo : appNewsVoList) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysNews", appNewsVo.getId(), "newsImg");
                appNewsVo.setImgList(imgByDate);
            }
        }
        return appNewsVoList;
    }

    @Override
    public Map<String, Object> findNewsByNewsId(Integer newsId) {
        map = new HashMap<>();
        AppNewsVoFBI appNewsVoFBI = appNewsDao.findNewsByNewsId(newsId);
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",appNewsVoFBI);
        return map;
    }

    @Override
    public Map<String, Object> findNewsRotation() {
        map = new HashMap<>();

        List<AppNewsRotationVo> appNewsRotationVoList = appNewsDao.findNewsRotation();
        if (appNewsRotationVoList != null && appNewsRotationVoList.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (AppNewsRotationVo appNewsRotationVo : appNewsRotationVoList) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysNews", appNewsRotationVo.getNewsId(), "newsImg");
                appNewsRotationVo.setVoResourcesImgList(imgByDate);
            }
        }

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",appNewsRotationVoList);
        return map;
    }
}
