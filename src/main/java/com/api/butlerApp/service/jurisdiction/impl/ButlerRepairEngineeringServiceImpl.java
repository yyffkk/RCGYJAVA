package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerRepairEngineeringDao;
import com.api.butlerApp.service.jurisdiction.ButlerRepairEngineeringService;
import com.api.model.butlerApp.ButlerRepairEngineering;
import com.api.model.butlerApp.ButlerRepairEngineeringSearch;
import com.api.util.IdWorker;
import com.api.util.UploadUtil;
import com.api.vo.butlerApp.ButlerRepairVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ButlerRepairEngineeringServiceImpl implements ButlerRepairEngineeringService {
    @Resource
    ButlerRepairEngineeringDao butlerRepairEngineeringDao;
    private static Map<String,Object> map = null;

    @Override
    public List<ButlerRepairVo> list(ButlerRepairEngineeringSearch butlerRepairEngineeringSearch) {
        List<ButlerRepairVo> list = butlerRepairEngineeringDao.list(butlerRepairEngineeringSearch);
        if (list != null && list.size() > 0){
            UploadUtil uploadUtil = new UploadUtil();
            for (ButlerRepairVo butlerRepairVo : list) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysReportRepairEngineering", butlerRepairVo.getId(), "engineeringMaintenanceImg");
                butlerRepairVo.setImgUrls(imgByDate);
            }
        }
        return list;
    }

    @Override
    public Map<String, Object> insert(ButlerRepairEngineering butlerRepairEngineering) {
        map = new HashMap<>();

        try {
            butlerRepairEngineering.setCode(String.valueOf(new IdWorker(1,1,1).nextId()));

            int insert = butlerRepairEngineeringDao.insert(butlerRepairEngineering);
            if (insert <= 0){
                throw new RuntimeException("添加失败");
            }

            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(butlerRepairEngineering.getFileUrls(),"sysReportRepairEngineering",butlerRepairEngineering.getId(),"engineeringMaintenanceImg","600",30,20);
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
        map.put("message","添加成功");
        map.put("status",true);
        return map;
    }
}
