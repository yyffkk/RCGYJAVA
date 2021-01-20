package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppArticleOutDao;
import com.api.app.service.butler.AppArticleOutService;
import com.api.model.app.AppArticleOut;
import com.api.util.UploadUtil;
import com.api.vo.app.AppMovingCompanyVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppArticleOutServiceImpl implements AppArticleOutService {
    @Resource
    AppArticleOutDao appArticleOutDao;
    private static Map<String,Object> map = null;

    @Override
    @Transactional
    public Map<String, Object> submit(AppArticleOut appArticleOut) {
        map = new HashMap<>();
        try {
            //填入状态，初始为1.待出门
            appArticleOut.setStatus(1);
            //填入申请时间
            appArticleOut.setApplicantDate(new Date());
            int insert = appArticleOutDao.submit(appArticleOut);
            if (insert <= 0){
                throw new RuntimeException("提交失败");
            }
            //上传照片资源到数据库
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(appArticleOut.getImgUrls(),"userArticleOut",appArticleOut.getId(),"goodsImg","600",30,20);
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

    @Override
    public Map<String, Object> getMovingCompanyTel() {
        map = new HashMap<>();
        List<AppMovingCompanyVo> appMovingCompanyVoList = appArticleOutDao.getMovingCompanyTel();
        map.put("appMovingCompanyVoList",appMovingCompanyVoList);
        return map;
    }
}
