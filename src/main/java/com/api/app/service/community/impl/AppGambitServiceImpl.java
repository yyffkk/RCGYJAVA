package com.api.app.service.community.impl;

import com.api.app.dao.community.AppGambitDao;
import com.api.app.service.community.AppGambitService;
import com.api.util.UploadUtil;
import com.api.vo.app.AppGambitThemeCommentVo;
import com.api.vo.app.AppGambitThemeVo;
import com.api.vo.app.AppGambitVo;
import com.api.vo.app.AppMyTidingsVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppGambitServiceImpl implements AppGambitService {
    @Resource
    AppGambitDao appGambitDao;
    private static Map<String,Object> map = null;

    @Override
    public List<AppGambitThemeVo> list(Integer id) {
        List<AppGambitThemeVo> list = appGambitDao.list(id);
        if (list != null && list.size()>0){
            for (AppGambitThemeVo appGambitThemeVo : list) {
                UploadUtil uploadUtil = new UploadUtil();
                //查询主题照片
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysGambitTheme", appGambitThemeVo.getId(), "gambitThemeImg");
                appGambitThemeVo.setImgUrls(imgByDate);

                //查询主题发布人头像
                List<VoResourcesImg> imgByDate1 = uploadUtil.findImgByDate("userResident", appGambitThemeVo.getCreateId(), "headSculpture");
                appGambitThemeVo.setHeadSculptureImgUrl(imgByDate1);

                //根据主题主键id查询主题评论信息
                List<AppGambitThemeCommentVo> gambitThemeCommentVos = appGambitDao.findCommentByThemeId(appGambitThemeVo.getId());
                appGambitThemeVo.setGambitThemeCommentVoList(gambitThemeCommentVos);
            }
        }
        return list;
    }

    @Override
    public List<AppGambitVo> listGambit() {
        List<AppGambitVo> appGambitVos = appGambitDao.listGambit();
        if (appGambitVos != null && appGambitVos.size()>0){
            for (AppGambitVo appGambitVo : appGambitVos) {
                //查询话题照片资源
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysGambit", appGambitVo.getId(), "gambitImg");
                appGambitVo.setImgUrl(imgByDate);
                //查询热度（活跃度）【点赞数+评论数】
                //查询点赞数
                int sumLikeNum = appGambitDao.sumLikeNum(appGambitVo.getId());
                //查询评论数
                int sumCommentNum = appGambitDao.sumCommentNum(appGambitVo.getId());
                appGambitVo.setActivityNum(sumLikeNum+sumCommentNum);
            }
        }
        return appGambitVos;
    }

    @Override
    public List<AppMyTidingsVo> myTidings(Integer id) {
        List<AppMyTidingsVo> appMyTidingsVos = appGambitDao.myTidings(id);
        if (appMyTidingsVos != null && appMyTidingsVos.size()>0){
            for (AppMyTidingsVo appMyTidingsVo : appMyTidingsVos) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysGambitTheme", appMyTidingsVo.getId(), "gambitThemeImg");
                appMyTidingsVo.setImgUrl(imgByDate);
            }
        }
        return appMyTidingsVos;
    }

    @Override
    public Map<String, Object> GambitThemeDetail(Integer themeId) {
        map = new HashMap<>();

        return map;
    }
}
