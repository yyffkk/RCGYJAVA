package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysGambitThemeDao;
import com.api.model.butlerService.SearchGambitTheme;
import com.api.manage.service.butlerService.SysGambitThemeService;
import com.api.model.system.SysFunctionSwitch;
import com.api.util.UploadUtil;
import com.api.vo.butlerService.VoGambitTheme;
import com.api.vo.butlerService.VoGambitThemeComment;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysGambitThemeServiceImpl implements SysGambitThemeService {
    private static Map<String,Object> map = null;
    @Resource
    SysGambitThemeDao sysGambitThemeDao;

    @Override
    public List<VoGambitTheme> list(SearchGambitTheme searchGambitTheme) {
        //查询所有的主题明细信息（包含条件搜索）
        List<VoGambitTheme> voGambitThemeList = sysGambitThemeDao.list(searchGambitTheme);
        if (voGambitThemeList != null && voGambitThemeList.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            //遍历主题明细信息
            for (VoGambitTheme voGambitTheme : voGambitThemeList) {
//                //查询点赞人数
//                int count = sysGambitThemeDao.countLikeNum(voGambitTheme.getId());
//                //传入点赞人数
//                voGambitTheme.setLikeNum(count);
                //查询评论人数
                int count2 = sysGambitThemeDao.countCommentNum(voGambitTheme.getId());
                //传入评论人数
                voGambitTheme.setCommentNum(count2);

                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysGambitTheme", voGambitTheme.getId(), "gambitThemeImg");
                voGambitTheme.setImgList(imgByDate);
            }
        }
        return voGambitThemeList;
    }

    @Override
    @Transactional
    public Map<String, Object> falseDelete(int[] ids) {
        map = new HashMap<>();
        try {
            if (ids.length>0){
                for (int id : ids) {
                    int update = sysGambitThemeDao.falseDelete(id);
                    if (update <= 0){
                        throw new RuntimeException("批量删除主题明细失败");
                    }
                }
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
        map.put("message","批量删除主题明细成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> recovery(int[] ids) {
        map = new HashMap<>();
        try {
            if (ids.length>0){
                for (int id : ids) {
                    int update = sysGambitThemeDao.recovery(id);
                    if (update <= 0){
                        throw new RuntimeException("批量恢复主题明细失败");
                    }
                }
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
        map.put("message","批量恢复主题明细成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> enableTheme() {
        map = new HashMap<>();
        //查询社区动态功能是否开启
        Integer id = 2;//2.社区动态功能
        String msg = "";//消息
        SysFunctionSwitch sysFunctionSwitch = sysGambitThemeDao.findSwitchById(id);
        if (sysFunctionSwitch.getStatus() == 2){//2.已关闭
            sysFunctionSwitch.setStatus(1);//1.已开启
            msg = "开启社区动态功能";
        }else if (sysFunctionSwitch.getStatus() == 1){
            sysFunctionSwitch.setStatus(2);//2.已关闭
            msg = "关闭社区动态功能";
        }else {
            map.put("message","状态有误");
            map.put("status",false);
            return map;
        }

        int update = sysGambitThemeDao.updateSwitchById(sysFunctionSwitch);
        if (update > 0){
            map.put("message",msg+"成功");
            map.put("status",true);
        }else {
            map.put("message",msg+"失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> enableComment() {
        map = new HashMap<>();
        //查询社区评论功能是否开启
        Integer id = 1;//1.社区评论功能
        String msg = "";//消息
        SysFunctionSwitch sysFunctionSwitch = sysGambitThemeDao.findSwitchById(id);
        if (sysFunctionSwitch.getStatus() == 2){//2.已关闭
            sysFunctionSwitch.setStatus(1);//1.已开启
            msg = "开启社区评论功能";
        }else if (sysFunctionSwitch.getStatus() == 1){
            sysFunctionSwitch.setStatus(2);//2.已关闭
            msg = "关闭社区评论功能";
        }else {
            map.put("message","状态有误");
            map.put("status",false);
            return map;
        }

        int update = sysGambitThemeDao.updateSwitchById(sysFunctionSwitch);
        if (update > 0){
            map.put("message",msg+"成功");
            map.put("status",true);
        }else {
            map.put("message",msg+"失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> findCommentByThemeId(Integer themeId) {
        map = new HashMap<>();

        List<VoGambitThemeComment> gambitThemeCommentList = sysGambitThemeDao.findCommentByThemeId(themeId);

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",gambitThemeCommentList);

        return map;
    }
}
