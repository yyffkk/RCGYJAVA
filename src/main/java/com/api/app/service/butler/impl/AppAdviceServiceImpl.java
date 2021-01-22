package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppAdviceDao;
import com.api.app.service.butler.AppAdviceService;
import com.api.manage.dao.butlerService.SysProhibitedKeywordsDao;
import com.api.manage.dao.butlerService.UserAdviceDao;
import com.api.model.app.SearchAppAdvice;
import com.api.model.app.UserIdAndAdviceId;
import com.api.model.butlerService.SearchProhibitedKeywords;
import com.api.model.butlerService.SysAdvice;
import com.api.model.butlerService.SysAdviceDetail;
import com.api.util.UploadUtil;
import com.api.vo.app.AppAdviceContentVo;
import com.api.vo.app.AppAdviceDetailVo;
import com.api.vo.app.AppAdviceVo;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoFindByIdAdvice;
import com.api.vo.butlerService.VoProhibitedKeywords;
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
public class AppAdviceServiceImpl implements AppAdviceService {
    @Resource
    AppAdviceDao appAdviceDao;
    @Resource
    SysProhibitedKeywordsDao sysProhibitedKeywordsDao;
    private static Map<String,Object> map = null;

    @Override
    public List<AppAdviceVo> list(SearchAppAdvice searchAppAdvice) {
        List<AppAdviceVo> list = appAdviceDao.list(searchAppAdvice);
        if (list != null && list.size()>0){
            for (AppAdviceVo appAdviceVo : list) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = null;
                if (appAdviceVo.getType() >= 3){
                    //投诉/表扬
                    imgByDate = uploadUtil.findImgByDate("sysAdvice", appAdviceVo.getId(), "complaintPraiseImg");
                }else {
                    //咨询/建议
                    imgByDate = uploadUtil.findImgByDate("sysAdvice", appAdviceVo.getId(), "adviceImg");
                }
                appAdviceVo.setImgUrls(imgByDate);
            }
        }
        return list;
    }

    @Override
    public Map<String, Object> insert(SysAdvice sysAdvice) {
        map = new HashMap<>();

        //替换违禁关键字
        String content = replaceProhibitedKeywords(sysAdvice.getContent());
        sysAdvice.setContent(content);
        //填入状态（1.未反馈，2.反馈中，3.已反馈）
        sysAdvice.setStatus(1);
        //填入默认点击数 0
        sysAdvice.setHits(0);
        //填入发布时间
        sysAdvice.setCreateDate(new Date());
        //填入发布人类型 1.住户
        sysAdvice.setCreateUserType(1);
        //填入是否删除 1.非删 0.删除
        sysAdvice.setIsDelete(1);
        //填入是否删除 1.非删 0.删除 【用户端】
        sysAdvice.setUserDelete(1);

        //添加建议咨询/投诉表扬 信息
        int insert = appAdviceDao.insert(sysAdvice);
        if (insert >0){
            map.put("message","提交成功");
            map.put("status",true);
        }else {
            map.put("message","提交失败");
            map.put("status",false);
        }

        //上传照片资源路径到数据库
        UploadUtil uploadUtil = new UploadUtil();
        uploadUtil.saveUrlToDB(sysAdvice.getFileUrls(),"sysAdvice",sysAdvice.getId(),"adviceImg","600",30,20);
        return map;
    }

    @Override
    public Map<String, Object> findAdviceDetailByAdviceId(UserIdAndAdviceId userIdAndAdviceId) {
        map = new HashMap<>();
        List<AppAdviceContentVo> appAdviceContentVos = appAdviceDao.findAdviceDetailByAdviceId(userIdAndAdviceId.getAdviceId());
        //根据咨询建议主键id查询咨询建议信息
        AppAdviceVo appAdviceVo = appAdviceDao.findAdviceByAdviceId(userIdAndAdviceId.getAdviceId());
        if (appAdviceVo == null){
            map.put("message","该咨询建议不存在或已被删除");
            map.put("status",false);
            return map;
        }
        //填入咨询建议照片资源集合
        UploadUtil uploadUtil = new UploadUtil();
        List<VoResourcesImg> imgByDate = null;
        if (appAdviceVo.getType() >= 3){
            //投诉/表扬
            imgByDate = uploadUtil.findImgByDate("sysAdvice", userIdAndAdviceId.getAdviceId(), "complaintPraiseImg");
        }else {
            //咨询/建议
            imgByDate = uploadUtil.findImgByDate("sysAdvice", userIdAndAdviceId.getAdviceId(), "adviceImg");
        }
        appAdviceVo.setImgUrls(imgByDate);

        AppAdviceDetailVo appAdviceDetailVo = new AppAdviceDetailVo();
        appAdviceDetailVo.setAppAdviceContentVos(appAdviceContentVos);
        appAdviceDetailVo.setAppAdviceVo(appAdviceVo);
        map.put("appAdviceDetailVo",appAdviceDetailVo);
        map.put("message","查询成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> reQuestion(SysAdviceDetail sysAdviceDetail) {
        map = new HashMap<>();
        //填入是否删除 默认为1.非删
        sysAdviceDetail.setIsDelete(1);
        //填入创建时间
        sysAdviceDetail.setCreateDate(new Date());
        //填入创建人类型,1.住户
        sysAdviceDetail.setCreateUserType(1);
        //添加用户反馈回复信息
        int insert = appAdviceDao.reQuestion(sysAdviceDetail);
        if (insert >0){
            map.put("message","提问成功");
            map.put("status",true);
        }else {
            map.put("message","提问失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> evaluate(SysAdvice sysAdvice) {
        map = new HashMap<>();
        //添加评价分数
        int update = appAdviceDao.evaluate(sysAdvice);
        if (update >0){
            map.put("message","打分成功");
            map.put("status",true);
        }else {
            map.put("message","打分失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> falseDelete(int[] ids, Integer id) {
        map = new HashMap<>();
        try {
            UserIdAndAdviceId userIdAndAdviceId = new UserIdAndAdviceId();
            userIdAndAdviceId.setId(id);
            for (int adviceId : ids) {
                userIdAndAdviceId.setAdviceId(adviceId);
                int update = appAdviceDao.falseDelete(userIdAndAdviceId);
                if (update <= 0){
                    throw new RuntimeException("删除失败");
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
        map.put("message","删除成功");
        map.put("status",true);
        return map;
    }

    //替换违禁关键字[目前空格无法解决]（后续优化成DFA算法）
    public String replaceProhibitedKeywords(String content){
        List<VoProhibitedKeywords> list = sysProhibitedKeywordsDao.list(new SearchProhibitedKeywords());
        if (list != null){
            for (VoProhibitedKeywords voProhibitedKeywords : list) {
                //替换违禁关键字
                if (content.contains(voProhibitedKeywords.getKeywords())){
                    content.replace(voProhibitedKeywords.getKeywords(), voProhibitedKeywords.getReplaces());
                }
            }
        }
        return content;
    }
}
