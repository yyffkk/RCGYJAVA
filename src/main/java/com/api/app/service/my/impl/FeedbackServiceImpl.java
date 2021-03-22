package com.api.app.service.my.impl;

import com.api.app.dao.my.FeedbackDao;
import com.api.app.service.my.FeedbackService;
import com.api.manage.dao.butlerService.SysProhibitedKeywordsDao;
import com.api.model.butlerService.SearchProhibitedKeywords;
import com.api.model.butlerService.SysAdvice;
import com.api.util.UploadUtil;
import com.api.vo.butlerService.VoProhibitedKeywords;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    FeedbackDao feedbackDao;
    private static Map<String,Object> map = null;
    @Resource
    SysProhibitedKeywordsDao sysProhibitedKeywordsDao;

    @Override
    @Transactional
    public Map<String, Object> submit(SysAdvice sysAdvice) {
        map = new HashMap<>();
        try {
            //替换违禁关键字
            String content = replaceProhibitedKeywords(sysAdvice.getContent());
            sysAdvice.setContent(content);
            //添加建议
            int insert = feedbackDao.insertAdvice(sysAdvice);
            //上传文件到数据库
            if (insert<=0){
                throw new RuntimeException("提交意见失败");
            }

            UploadUtil uploadUtil = new UploadUtil();
            //上传文件到数据库
            uploadUtil.saveUrlToDB(sysAdvice.getFileUrls(),"sysAdvice",sysAdvice.getId(),"adviceImg","600",30,20);
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

        map.put("message","提交意见成功");
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
