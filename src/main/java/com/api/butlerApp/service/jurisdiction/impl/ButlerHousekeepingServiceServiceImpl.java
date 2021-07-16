package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerHousekeepingServiceDao;
import com.api.butlerApp.dao.jurisdiction.ButlerRepairDao;
import com.api.butlerApp.service.jurisdiction.ButlerHousekeepingServiceService;
import com.api.model.butlerApp.ButlerHousekeepingServiceSearch;
import com.api.util.UploadUtil;
import com.api.vo.app.AppHousekeepingServiceVo;
import com.api.vo.butlerApp.ButlerRepairVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ButlerHousekeepingServiceServiceImpl implements ButlerHousekeepingServiceService {
    private static Map<String,Object> map = null;
    @Resource
    ButlerHousekeepingServiceDao butlerHousekeepingServiceDao;
    @Resource
    ButlerRepairDao butlerRepairDao;

    @Override
    public List<AppHousekeepingServiceVo> list(ButlerHousekeepingServiceSearch butlerHousekeepingServiceSearch) {
        //查询用户所属权限,type:1.派单人 2.维修人 3.其他角色
        int type = findJurisdictionByUserId(butlerHousekeepingServiceSearch.getRoleId());
        List<AppHousekeepingServiceVo> housekeepingServiceVoList = new ArrayList<>();
        switch (type){
            case 1:
                //派单人界面
                housekeepingServiceVoList = butlerHousekeepingServiceDao.list1(butlerHousekeepingServiceSearch);
                break;
            case 2:
                //接单人界面
                housekeepingServiceVoList = butlerHousekeepingServiceDao.list2(butlerHousekeepingServiceSearch);
                break;
            default:
                //系统错误
                break;
        }

        if (housekeepingServiceVoList != null && housekeepingServiceVoList.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (AppHousekeepingServiceVo appHousekeepingServiceVo : housekeepingServiceVoList) {
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
        return housekeepingServiceVoList;
    }

    private int findJurisdictionByUserId(String roleIds) {
        String[] split = roleIds.split(",");
        if (split.length >0){
            for (String s : split) {
                int roleId = Integer.parseInt(s);
                //根据角色id查询权限id集合//TODO 数据库返回n个，代码返回就10个
                List<Integer> jurisdictionIds = butlerRepairDao.findJIdsByRoleId(roleId);
                if (jurisdictionIds != null && jurisdictionIds.size()>0){
//                    if (jurisdictionIds.contains(67)&&jurisdictionIds.contains(68)){
//                        return 3;
//                    }

                    //52.派单（当派单权限和接单权限都存在时，当作派单权限处理）
                    if (jurisdictionIds.contains(67)){
                        return 1;
                    }
                    //53.接单
                    if (jurisdictionIds.contains(68)){
                        return 2;
                    }
                }
            }
        }
        return 3;
    }
}
