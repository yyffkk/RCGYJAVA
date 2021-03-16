package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerBacklogDao;
import com.api.butlerApp.dao.jurisdiction.ButlerRepairDao;
import com.api.butlerApp.service.jurisdiction.ButlerBacklogService;
import com.api.util.UploadUtil;
import com.api.vo.butlerApp.ButlerArticleOutVo;
import com.api.vo.butlerApp.ButlerBacklogVo;
import com.api.vo.butlerApp.ButlerRepairVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ButlerBacklogServiceImpl implements ButlerBacklogService {
    @Resource
    ButlerBacklogDao butlerBacklogDao;
    @Resource
    ButlerRepairDao butlerRepairDao;

    @Override
    public List<ButlerBacklogVo> list(String roleId, int id) {
        //1.派单人,2.接单人,3.放行,4.维修人,5.其他人
        int type = findJurisdictionByUserId(roleId);
        //创建一个返回对象集合
        ArrayList<ButlerBacklogVo> butlerBacklogVos = new ArrayList<>();
        ButlerBacklogVo butlerBacklogVo= null;
        if (type == 1 || type == 5){
            //创建一个对象集合
            butlerBacklogVo = new ButlerBacklogVo<ButlerRepairVo>();
            //派单人的待派事项
            List<ButlerRepairVo> butlerRepairVos = butlerBacklogDao.backlogDispatchList(id);
            //查询照片资源
            if (butlerRepairVos != null && butlerRepairVos.size()>0){
                for (ButlerRepairVo butlerRepairVo : butlerRepairVos) {
                    UploadUtil uploadUtil = new UploadUtil();
                    List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sys_report_repair", butlerRepairVo.getId(), "repairImg");
                    butlerRepairVo.setImgUrls(imgByDate);
                    butlerRepairVo.setType(type);
                }
            }

            butlerBacklogVo.setDataList(butlerRepairVos);
            butlerBacklogVo.setType(1);
            butlerBacklogVos.add(butlerBacklogVo);
        }
        if (type == 2 || type == 5){
            //创建一个对象集合
            butlerBacklogVo = new ButlerBacklogVo<ButlerRepairVo>();
            //接单人的待接单事项
            List<ButlerRepairVo> butlerRepairVos = butlerBacklogDao.backlogReceivingList(id);
            //查询照片资源
            if (butlerRepairVos != null && butlerRepairVos.size()>0){
                for (ButlerRepairVo butlerRepairVo : butlerRepairVos) {
                    UploadUtil uploadUtil = new UploadUtil();
                    List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sys_report_repair", butlerRepairVo.getId(), "repairImg");
                    butlerRepairVo.setImgUrls(imgByDate);
                    butlerRepairVo.setType(type);
                }
            }

            butlerBacklogVo.setDataList(butlerRepairVos);
            butlerBacklogVo.setType(1);
            butlerBacklogVos.add(butlerBacklogVo);
        }
        if (type == 3 || type == 5){
            //创建一个对象集合
            butlerBacklogVo = new ButlerBacklogVo<ButlerArticleOutVo>();
            //放行人的待出户事项
            List<ButlerArticleOutVo> butlerArticleOutVos =butlerBacklogDao.backlogReleasedList();
            butlerBacklogVo.setDataList(butlerArticleOutVos);
            butlerBacklogVo.setType(2);
            butlerBacklogVos.add(butlerBacklogVo);
        }
//        if (type == 4 || type == 5){
//            //跟踪人的待执行事项
//            //。。。
//        }

        return butlerBacklogVos;
    }

    private int findJurisdictionByUserId(String roleIds) {
        String[] split = roleIds.split(",");
//        if (split.length >0){
//            for (String s : split) {
//                int roleId = Integer.parseInt(s);
//                //根据角色id查询权限id集合
//                List<Integer> jurisdictionIds = butlerRepairDao.findJIdsByRoleId(roleId);
//                if (jurisdictionIds != null && jurisdictionIds.size()>0){
//                    //52.派单人,53.接单人,55.放行,59.维修人
//                    if (jurisdictionIds.contains(52)){
//                        return 1;
//                    }else if (jurisdictionIds.contains(53)){
//                        return 2;
//                    }else if (jurisdictionIds.contains(55)){
//                        return 3;
//                    }else if(jurisdictionIds.contains(59)){
//                        return 4;
//                    }
//                }
//            }
//        }
        return 5;
    }
}
