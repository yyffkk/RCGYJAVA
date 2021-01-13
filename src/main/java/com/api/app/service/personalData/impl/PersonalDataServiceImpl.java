package com.api.app.service.personalData.impl;

import com.api.app.dao.personalData.PersonalDataDao;
import com.api.app.service.personalData.PersonalDataService;
import com.api.model.basicArchives.UserResident;
import com.api.util.UploadUtil;
import com.api.vo.app.PersonalDataVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
            map.put("message","修改昵称成功");
            map.put("status",true);
        }else {
            map.put("message","修改昵称失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> updateHeadPortrait(Integer id, String[] fileUrls) {
        map = new HashMap<>();
        try {
            UploadUtil uploadUtil = new UploadUtil();
            //先删除头像信息
            uploadUtil.delete("userResident",id,"headSculpture");
            //在添加头像信息
            uploadUtil.saveUrlToDB(fileUrls,"userResident",id,"headSculpture","600",30,20);
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
        map.put("message","修改头像信息成功");
        map.put("status",true);
        return map;
    }
}
