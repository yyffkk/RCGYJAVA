package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerRepairDao;
import com.api.butlerApp.service.jurisdiction.ButlerRepairService;
import com.api.model.butlerApp.ButlerRepairSearch;
import com.api.util.UploadUtil;
import com.api.vo.butlerApp.ButlerRepairVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ButlerRepairServiceImpl implements ButlerRepairService {
    @Resource
    ButlerRepairDao butlerRepairDao;

    @Override
    public List<ButlerRepairVo> list(ButlerRepairSearch butlerRepairSearch) {
        //查询用户所属权限,type:1.派单人 2.维修人 3.其他角色
        int type = findJurisdictionByUserId(butlerRepairSearch.getRoleId());
        List<ButlerRepairVo> butlerRepairVos = new ArrayList<>();
        switch (type){
            case 1:
                //派单人界面
                butlerRepairVos = butlerRepairDao.list1(butlerRepairSearch);
                break;
            case 2:
                //接单人界面
                butlerRepairVos = butlerRepairDao.list2(butlerRepairSearch);
                break;
            case 3:
                //其他人界面
                butlerRepairVos = butlerRepairDao.list3(butlerRepairSearch);
                break;
            default:
                //系统错误
                break;
        }
        if (butlerRepairVos != null && butlerRepairVos.size()>0){
            for (ButlerRepairVo butlerRepairVo : butlerRepairVos) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sys_report_repair", butlerRepairVo.getId(), "repairImg");
                butlerRepairVo.setImgUrls(imgByDate);
                butlerRepairVo.setType(type);
            }
        }


        return butlerRepairVos;
    }

    private int findJurisdictionByUserId(String roleIds) {
        String[] split = roleIds.split(",");
        if (split.length >0){
            for (String s : split) {
                int roleId = Integer.parseInt(s);
                //根据角色id查询权限id集合
                List<Integer> jurisdictionIds = butlerRepairDao.findJIdsByRoleId(roleId);
                if (jurisdictionIds != null && jurisdictionIds.size()>0){
                    //52.派单
                    if (jurisdictionIds.contains(52)){
                        return 1;
                    }
                    //53.接单
                    if (jurisdictionIds.contains(53)){
                        return 2;
                    }
                }
            }
        }
        return 3;
    }
}
