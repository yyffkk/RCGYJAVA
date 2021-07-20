package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysHousekeepingServiceDao;
import com.api.manage.service.butlerService.SysHousekeepingServiceService;
import com.api.model.butlerService.SearchHousekeepingService;
import com.api.util.UploadUtil;
import com.api.vo.app.AppHousekeepingServiceVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysHousekeepingServiceServiceImpl implements SysHousekeepingServiceService {
    @Resource
    SysHousekeepingServiceDao sysHousekeepingServiceDao;

    @Override
    public List<AppHousekeepingServiceVo> list(SearchHousekeepingService searchHousekeepingService) {
        List<AppHousekeepingServiceVo> list = sysHousekeepingServiceDao.list(searchHousekeepingService);
        if (list != null && list.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (AppHousekeepingServiceVo appHousekeepingServiceVo : list) {
                //填入提交照片资源信息
                List<VoResourcesImg> submitImg = uploadUtil.findImgByDate("sysHouseKeepingService", appHousekeepingServiceVo.getId(), "submitImg");
                appHousekeepingServiceVo.setSubmitImgList(submitImg);

                //填入评价照片资源信息
                List<VoResourcesImg> evaluationImg = uploadUtil.findImgByDate("sysHouseKeepingService", appHousekeepingServiceVo.getId(), "evaluationImg");
                appHousekeepingServiceVo.setEvaluationImgList(evaluationImg);

                //填入处理完成照片资源信息
                List<VoResourcesImg> handlerImg = uploadUtil.findImgByDate("sysHouseKeepingService", appHousekeepingServiceVo.getId(), "handlerImg");
                appHousekeepingServiceVo.setHandlerImgList(handlerImg);

            }
        }
        return list;
    }
}
