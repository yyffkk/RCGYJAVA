package com.api.app.service.personalData.impl;

import com.api.app.dao.personalData.PersonalDataDao;
import com.api.app.service.personalData.PersonalDataService;
import com.api.model.basicArchives.UserResident;
import com.api.util.UploadUtil;
import com.api.vo.app.PersonalDataVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonalDataServiceImpl implements PersonalDataService {
    private static Map<String,Object> map = null;
    @Resource
    PersonalDataDao personalDataDao;

    @Override
    public PersonalDataVo findById(Integer id) {
        PersonalDataVo byId = personalDataDao.findById(id);
        if (byId != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("userResident", byId.getId(), "headSculpture");
            byId.setImgUrls(imgByDate);
        }
        return byId;
    }

    @Override
    public Map<String, Object> updateNickName(UserResident userResident) {
        map = new HashMap<>();
        //修改用户昵称
        int update = personalDataDao.updateNickName(userResident);
        if (update >0){
            map.put("message","修改成功");
            map.put("status",true);
        }else {
            map.put("message","修改失败");
            map.put("status",false);
        }
        return map;
    }
}
