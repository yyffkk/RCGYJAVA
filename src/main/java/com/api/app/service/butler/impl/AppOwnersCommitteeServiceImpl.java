package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppOwnersCommitteeDao;
import com.api.app.service.butler.AppOwnersCommitteeService;
import com.api.util.UploadUtil;
import com.api.vo.butlerService.VoOwnersCommittee;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppOwnersCommitteeServiceImpl implements AppOwnersCommitteeService {
    @Resource
    AppOwnersCommitteeDao appOwnersCommitteeDao;

    @Override
    public List<VoOwnersCommittee> findAll() {
        List<VoOwnersCommittee> all = appOwnersCommitteeDao.findAll();
        if (all != null && all.size()>0){
            for (VoOwnersCommittee voOwnersCommittee : all) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysOwnersCommittee", voOwnersCommittee.getId(), "ownersCommitteeImg");
                //填入照片资源集合
                voOwnersCommittee.setImgUrls(imgByDate);
            }
        }
        return all;
    }
}
