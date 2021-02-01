package com.api.app.service.community.impl;

import com.api.app.dao.community.AppGambitDao;
import com.api.app.service.community.AppGambitService;
import com.api.model.app.*;
import com.api.vo.app.IdAndName;
import com.api.util.UploadUtil;
import com.api.vo.app.AppGambitThemeCommentVo;
import com.api.vo.app.AppGambitThemeVo;
import com.api.vo.app.AppGambitVo;
import com.api.vo.app.AppMyTidingsVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
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
                //查询该用户是否点赞
                UserIdAndThemeId userIdAndThemeId = new UserIdAndThemeId();
                userIdAndThemeId.setThemeId(appGambitThemeVo.getId());
                userIdAndThemeId.setId(id);

                AppGambitThemeLike themeLikeByIds = appGambitDao.findThemeLikeByIds(userIdAndThemeId);
                if (themeLikeByIds != null){
                    //1.已点赞
                    appGambitThemeVo.setIsLike(1);
                }else {
                    //0.未点赞
                    appGambitThemeVo.setIsLike(0);
                }

                UploadUtil uploadUtil = new UploadUtil();
                //查询主题照片
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysGambitTheme", appGambitThemeVo.getId(), "gambitThemeImg");
                appGambitThemeVo.setImgUrls(imgByDate);

                //查询主题发布人头像
                List<VoResourcesImg> imgByDate1 = uploadUtil.findImgByDate("userResident", appGambitThemeVo.getCreateId(), "headSculpture");
                appGambitThemeVo.setHeadSculptureImgUrl(imgByDate1);

                //根据主题主键id查询点赞人信息
                List<IdAndName> idAndNames = appGambitDao.findLikeNames(appGambitThemeVo.getId());
                appGambitThemeVo.setLikeNames(idAndNames);

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
//                int sumLikeNum = appGambitDao.sumLikeNum(appGambitVo.getId());
                //查询评论数
//                int sumCommentNum = appGambitDao.sumCommentNum(appGambitVo.getId());
//                appGambitVo.setActivityNum(sumLikeNum+sumCommentNum);
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
    public Map<String, Object> GambitThemeDetail(Integer themeId, Integer id) {
        map = new HashMap<>();
        AppGambitThemeVo appGambitThemeVo = appGambitDao.GambitThemeDetail(themeId);

        //查询该用户是否点赞
        UserIdAndThemeId userIdAndThemeId = new UserIdAndThemeId();
        userIdAndThemeId.setThemeId(appGambitThemeVo.getId());
        userIdAndThemeId.setId(id);

        AppGambitThemeLike themeLikeByIds = appGambitDao.findThemeLikeByIds(userIdAndThemeId);
        if (themeLikeByIds != null){
            //1.已点赞
            appGambitThemeVo.setIsLike(1);
        }else {
            //0.未点赞
            appGambitThemeVo.setIsLike(0);
        }

        UploadUtil uploadUtil = new UploadUtil();
        //查询主题照片
        List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysGambitTheme", appGambitThemeVo.getId(), "gambitThemeImg");
        appGambitThemeVo.setImgUrls(imgByDate);

        //查询主题发布人头像
        List<VoResourcesImg> imgByDate1 = uploadUtil.findImgByDate("userResident", appGambitThemeVo.getCreateId(), "headSculpture");
        appGambitThemeVo.setHeadSculptureImgUrl(imgByDate1);

        //根据主题主键id查询点赞人信息
        List<IdAndName> idAndNames = appGambitDao.findLikeNames(appGambitThemeVo.getId());
        appGambitThemeVo.setLikeNames(idAndNames);

        //根据主题主键id查询主题评论信息
        List<AppGambitThemeCommentVo> gambitThemeCommentVos = appGambitDao.findCommentByThemeId(appGambitThemeVo.getId());
        appGambitThemeVo.setGambitThemeCommentVoList(gambitThemeCommentVos);

        map.put("message","请求成功");
        map.put("data",appGambitThemeVo);
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> likes(Integer themeId, Integer id) {
        map = new HashMap<>();
        //操作
        String operation = "";
        try {
            //查询是否已点赞过该主题
            UserIdAndThemeId userIdAndThemeId = new UserIdAndThemeId();
            userIdAndThemeId.setId(id);
            userIdAndThemeId.setThemeId(themeId);
            AppGambitThemeLike appGambitThemeLike2 = appGambitDao.findThemeLikeByIds(userIdAndThemeId);
            if (appGambitThemeLike2 != null){
                //取消点赞
                //删除点赞信息
                int delete = appGambitDao.deleteThemeLike(appGambitThemeLike2.getId());
                if (delete <= 0){
                    throw new RuntimeException("删除点赞信息失败");
                }
                //该主题的点赞数量-1
                int update = appGambitDao.decrLikesByTheme(themeId);
                if (update <= 0){
                    throw new RuntimeException("减少点赞数量失败");
                }
                operation = "取消点赞";
                //0.取消点赞
                map.put("operation",0);
            }else {
                //点赞
                //添加点赞信息
                //根据主题主键id 查询 话题id
                Integer gambitId = appGambitDao.findGambitIdByThemeId(themeId);
                //添加点赞人信息
                AppGambitThemeLike appGambitThemeLike = new AppGambitThemeLike();
                appGambitThemeLike.setGambitId(gambitId);
                appGambitThemeLike.setGambitThemeId(themeId);
                appGambitThemeLike.setCreateId(id);
                appGambitThemeLike.setCreateDate(new Date());
                int insert = appGambitDao.insertThemeLike(appGambitThemeLike);
                if (insert <= 0){
                    throw new RuntimeException("添加点赞信息失败");
                }

                //该主题的点赞数量+1
                int update = appGambitDao.incrLikesByTheme(themeId);
                if (update <= 0){
                    throw new RuntimeException("添加点赞数量失败");
                }
                operation = "点赞";
                //1.点赞
                map.put("operation",1);
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

        map.put("message",operation+"操作成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> falseDelete(Integer themeId, Integer id) {
        map = new HashMap<>();
        UserIdAndThemeId userIdAndThemeId = new UserIdAndThemeId();
        userIdAndThemeId.setThemeId(themeId);
        userIdAndThemeId.setId(id);
        int update = appGambitDao.falseDelete(userIdAndThemeId);
        if (update >0 ){
            map.put("message","删除成功");
            map.put("status",true);
        }else {
            map.put("message","删除失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> comment(AppGambitThemeComment appGambitThemeComment) {
        map = new HashMap<>();
        //根据主题主键id 查询 话题id
        Integer gambitId = appGambitDao.findGambitIdByThemeId(appGambitThemeComment.getGambitThemeId());
        appGambitThemeComment.setGambitId(gambitId);
        //填入评论时间
        appGambitThemeComment.setCreateDate(new Date());
        //填入是否删除,默认为1.非删
        appGambitThemeComment.setIsDelete(1);
        int insert = appGambitDao.comment(appGambitThemeComment);
        if (insert >0){
            map.put("message","评论成功");
            map.put("status",true);
        }else {
            map.put("message","评论失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> writePost(AppGambitTheme appGambitTheme) {
        map = new HashMap<>();
        try {
            //填入点赞数量（默认为0）
            appGambitTheme.setLikes(0);
            //填入发布时间
            appGambitTheme.setCreateDate(new Date());
            //填入是否删除（默认为 1.非删）
            appGambitTheme.setIsDelete(1);
            int insert = appGambitDao.writePost(appGambitTheme);
            if (insert <= 0){
                throw new RuntimeException("发布失败");
            }
            //将照片传入数据库
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(appGambitTheme.getImgUrls(),"sysGambitTheme",appGambitTheme.getId(),"gambitThemeImg","600",30,20);
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
        map.put("message","发布成功");
        map.put("status",true);
        return map;
    }

    @Override
    public List<AppGambitThemeVo> listByGambitId(Integer id, int gambitId) {
        UserIdAndGambitId userIdAndGambitId = new UserIdAndGambitId();
        userIdAndGambitId.setGambitId(gambitId);
        userIdAndGambitId.setId(id);
        //查询 话题 下的主题信息
        List<AppGambitThemeVo> list = appGambitDao.listByGambitId(userIdAndGambitId);
        if (list != null && list.size()>0){
            for (AppGambitThemeVo appGambitThemeVo : list) {
                //查询该用户是否点赞
                UserIdAndThemeId userIdAndThemeId = new UserIdAndThemeId();
                userIdAndThemeId.setThemeId(appGambitThemeVo.getId());
                userIdAndThemeId.setId(id);

                AppGambitThemeLike themeLikeByIds = appGambitDao.findThemeLikeByIds(userIdAndThemeId);
                if (themeLikeByIds != null){
                    //1.已点赞
                    appGambitThemeVo.setIsLike(1);
                }else {
                    //0.未点赞
                    appGambitThemeVo.setIsLike(0);
                }

                UploadUtil uploadUtil = new UploadUtil();
                //查询主题照片
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysGambitTheme", appGambitThemeVo.getId(), "gambitThemeImg");
                appGambitThemeVo.setImgUrls(imgByDate);

                //查询主题发布人头像
                List<VoResourcesImg> imgByDate1 = uploadUtil.findImgByDate("userResident", appGambitThemeVo.getCreateId(), "headSculpture");
                appGambitThemeVo.setHeadSculptureImgUrl(imgByDate1);

                //根据主题主键id查询点赞人信息
                List<IdAndName> idAndNames = appGambitDao.findLikeNames(appGambitThemeVo.getId());
                appGambitThemeVo.setLikeNames(idAndNames);

                //根据主题主键id查询主题评论信息
                List<AppGambitThemeCommentVo> gambitThemeCommentVos = appGambitDao.findCommentByThemeId(appGambitThemeVo.getId());
                appGambitThemeVo.setGambitThemeCommentVoList(gambitThemeCommentVos);
            }
        }
        return list;
    }

    @Override
    public Map<String, Object> findActivityGambit() {
        map = new HashMap<>();
        List<IdAndName> idAndNames = appGambitDao.findActivityGambit();
        map.put("message","请求成功");
        map.put("data",idAndNames);
        map.put("status",true);
        return map;
    }
}
