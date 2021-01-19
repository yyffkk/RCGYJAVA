package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppReportRepairDao;
import com.api.app.service.butler.AppReportRepairService;
import com.api.model.app.UserIdAndRepairId;
import com.api.util.UploadUtil;
import com.api.vo.app.AppDispatchListVo;
import com.api.vo.app.AppProcessRecordVo;
import com.api.vo.app.AppReportRepairVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppReportRepairServiceImpl implements AppReportRepairService {
    @Resource
    AppReportRepairDao appReportRepairDao;
    private static Map<String,Object> map = null;

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

    @Override
    public Map<String, Object> findById(UserIdAndRepairId userIdAndRepairId) {
        map = new HashMap<>();
        //根据用户id和报事报修主键id查询app报事报修Vo
        AppReportRepairVo appReportRepairVo = appReportRepairDao.findRepairByIds(userIdAndRepairId);
        if (appReportRepairVo == null){
            map.put("message","此订单不存在或被删除");
            map.put("status",false);
            return map;
        }
        UploadUtil uploadUtil = new UploadUtil();
        List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sys_report_repair", appReportRepairVo.getId(), "repairImg");
        appReportRepairVo.setImgUrls(imgByDate);
        map.put("appReportRepairVo",appReportRepairVo);

        //根据用户id和报事报修主键id查询app维修信息
        AppDispatchListVo appDispatchListVo = appReportRepairDao.findDispatchListByIds(userIdAndRepairId);
        map.put("appDispatchListVo",appDispatchListVo);

        //根据用户id和报事报修主键id查询app进程处理集合
        List<AppProcessRecordVo>  appProcessRecordVoList = appReportRepairDao.findProcessRecordByIds(userIdAndRepairId);
        map.put("appProcessRecordVo",appProcessRecordVoList);

        return map;
    }
}
