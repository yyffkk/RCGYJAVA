package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppAdviceDao;
import com.api.app.service.butler.AppAdviceService;
import com.api.model.app.SearchAppAdvice;
import com.api.util.UploadUtil;
import com.api.vo.app.AppAdviceVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppAdviceServiceImpl implements AppAdviceService {
    @Resource
    AppAdviceDao appAdviceDao;

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
}
