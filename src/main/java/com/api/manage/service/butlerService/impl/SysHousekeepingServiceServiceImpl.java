package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysHousekeepingServiceDao;
import com.api.manage.service.butlerService.SysHousekeepingServiceService;
import com.api.model.butlerService.SearchHousekeepingService;
import com.api.util.UploadUtil;
import com.api.vo.app.AppHousekeepingServiceVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysHousekeepingServiceServiceImpl implements SysHousekeepingServiceService {
    private static Map<String,Object> map = null;
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

    @Override
    public Map<String, Object> invalid(Integer housekeepingServiceId) {
        map = new HashMap<>();
        int update = sysHousekeepingServiceDao.invalid(housekeepingServiceId);
        if (update >0){
            map.put("message","作废成功");
            map.put("status",true);
        }else {
            map.put("message","作废失败");
            map.put("status",false);
        }

        return map;
    }
}
