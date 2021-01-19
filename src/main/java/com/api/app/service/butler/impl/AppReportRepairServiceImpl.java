package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppReportRepairDao;
import com.api.app.service.butler.AppReportRepairService;
import com.api.util.UploadUtil;
import com.api.vo.app.AppReportRepairVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppReportRepairServiceImpl implements AppReportRepairService {
    @Resource
    AppReportRepairDao appReportRepairDao;

    @Override
    public List<AppReportRepairVo> list(Integer id) {
        List<AppReportRepairVo> list = appReportRepairDao.list(id);
        if (list != null && list.size() >0){
            for (AppReportRepairVo appReportRepairVo : list) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sys_report_repair", appReportRepairVo.getId(), "repairImg");
                appReportRepairVo.setImgUrls(imgByDate);
            }
        }
        return list;
    }
}
