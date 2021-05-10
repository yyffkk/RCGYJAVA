package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerBacklogDao;
import com.api.butlerApp.dao.jurisdiction.ButlerRepairDao;
import com.api.butlerApp.service.jurisdiction.ButlerBacklogService;
import com.api.model.butlerApp.ButlerUserIdAndStatus;
import com.api.util.UploadUtil;
import com.api.vo.butlerApp.ButlerArticleOutVo;
import com.api.vo.butlerApp.ButlerBacklogVo;
import com.api.vo.butlerApp.ButlerRepairVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ButlerBacklogServiceImpl implements ButlerBacklogService {
    @Resource
    ButlerBacklogDao butlerBacklogDao;
    @Resource
    ButlerRepairDao butlerRepairDao;
    private static Map<String,Object> map = null;

    @Override
    public List<ButlerBacklogVo> list(String roleId, int id, Integer backlogStatus) {
        //1.派单人,2.接单人,3.放行,4.维修人,5.其他人
        int type = findJurisdictionByUserId(roleId);
        //填入用户主键id和事项状态
        ButlerUserIdAndStatus butlerUserIdAndStatus = new ButlerUserIdAndStatus();
        butlerUserIdAndStatus.setUserId(id);
        butlerUserIdAndStatus.setStatus(backlogStatus);
        //创建一个返回对象集合
        ArrayList<ButlerBacklogVo> butlerBacklogVos = new ArrayList<>();
        ButlerBacklogVo butlerBacklogVo= null;
        if (type == 1 || type == 5){
            //派单人的待派事项
            List<ButlerRepairVo> butlerRepairVos = butlerBacklogDao.backlogDispatchList(butlerUserIdAndStatus);
            //查询照片资源
            if (butlerRepairVos != null && butlerRepairVos.size()>0){
                for (ButlerRepairVo butlerRepairVo : butlerRepairVos) {
                    UploadUtil uploadUtil = new UploadUtil();
                    List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sys_report_repair", butlerRepairVo.getId(), "repairImg");
                    butlerRepairVo.setImgUrls(imgByDate);
                    butlerRepairVo.setType(type);

                    //创建一个对象集合(派单人，报事报修)
                    butlerBacklogVo = new ButlerBacklogVo<ButlerRepairVo>();
                    //填入dataList数据
                    butlerBacklogVo.setDataList(butlerRepairVo);
                    butlerBacklogVo.setType(1);
                    butlerBacklogVos.add(butlerBacklogVo);
                }
            }
        }
        if (type == 2 || type == 5){

            //接单人的待接单事项
            List<ButlerRepairVo> butlerRepairVos = butlerBacklogDao.backlogReceivingList(butlerUserIdAndStatus);
            //查询照片资源
            if (butlerRepairVos != null && butlerRepairVos.size()>0){
                for (ButlerRepairVo butlerRepairVo : butlerRepairVos) {
                    UploadUtil uploadUtil = new UploadUtil();
                    List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sys_report_repair", butlerRepairVo.getId(), "repairImg");
                    butlerRepairVo.setImgUrls(imgByDate);
                    butlerRepairVo.setType(type);

                    //创建一个对象集合(接单人，报事报修)
                    butlerBacklogVo = new ButlerBacklogVo<ButlerRepairVo>();
                    //填入dataList数据
                    butlerBacklogVo.setDataList(butlerRepairVo);
                    butlerBacklogVo.setType(1);
                    butlerBacklogVos.add(butlerBacklogVo);
                }
            }
        }
        if (type == 3 || type == 5){

            //放行人的待出户事项
            List<ButlerArticleOutVo> butlerArticleOutVos =butlerBacklogDao.backlogReleasedList(backlogStatus);
            if (butlerArticleOutVos != null && butlerArticleOutVos.size()>0){
                for (ButlerArticleOutVo butlerArticleOutVo : butlerArticleOutVos) {
                    //创建一个对象集合（放行，物品出门）
                    butlerBacklogVo = new ButlerBacklogVo<ButlerArticleOutVo>();
                    butlerBacklogVo.setDataList(butlerArticleOutVo);
                    butlerBacklogVo.setType(2);
                    butlerBacklogVos.add(butlerBacklogVo);
                }
            }
        }
//        if (type == 4 || type == 5){
//            //跟踪人的待执行事项
//            //。。。
//        }

        return butlerBacklogVos;
    }

    @Override
    public Map<String, Object> findItemNum(String roleId, int id) {
        map = new HashMap<>();
        //未处理事项
        int unProcessedNum = 0;
        //处理中事项
        int processingNum = 0;
        //已处理事项
        int processedNum = 0;
        //全部事项
        int allNum = 0;

        //1.派单人,2.接单人,3.放行,4.维修人,5.其他人
        int type = findJurisdictionByUserId(roleId);
        if (type == 1 || type == 5){
            //(派单人，报事报修)
            //查询派单人待处理事项
            int num1 = butlerBacklogDao.findUnProcessedNum1();
            //查询派单人处理中事项
            int num2 = butlerBacklogDao.findProcessingNum1();
            //查询派单人已处理事项
            int num3 = butlerBacklogDao.findProcessedNum1();
            unProcessedNum += num1;
            processingNum += num2;
            processedNum += num3;
            //派单人全部事项
            allNum += num1+num2+num3;
        }
        if (type == 2 || type == 5){
            //(接单人，报事报修)
            //查询接单人未处理事项
            int num1 = butlerBacklogDao.findUnProcessedNum2(id);
            //查询接单人处理中事项
            int num2 = butlerBacklogDao.findProcessingNum2(id);
            //查询接单人已处理事项
            int num3 = butlerBacklogDao.findProcessedNum2(id);
            unProcessedNum += num1;
            processingNum += num2;
            processedNum += num3;
            //接单人全部事项
            allNum += num1+num2+num3;
        }
        if (type == 3 || type == 5){
            //(放行人，物品出门)
            //查询放行人未处理事项
            int num1 = butlerBacklogDao.findUnProcessedNum3();
            //查询放行人处理中事项(物品出门没有处理中状态，数量为0)
            int num2 = 0;
            //查询放行人已处理事项
            int num3 = butlerBacklogDao.findProcessedNum3();
            unProcessedNum += num1;
            processingNum += num2;
            processedNum += num3;
            //放行人全部事项
            allNum += num1+num2+num3;
        }
        map.put("unProcessedNum",unProcessedNum);
        map.put("processingNum",processingNum);
        map.put("processedNum",processedNum);
        map.put("allNum",allNum);
        return map;
    }

    private int findJurisdictionByUserId(String roleIds) {
        String[] split = roleIds.split(",");
        if (split.length >0){
            for (String s : split) {
                int roleId = Integer.parseInt(s);
                //根据角色id查询权限id集合
                List<Integer> jurisdictionIds = butlerRepairDao.findJIdsByRoleId(roleId);
                if (jurisdictionIds != null && jurisdictionIds.size()>0){
                    //52.派单人,53.接单人,55.放行,59.维修人
                    if (jurisdictionIds.contains(52)){
                        return 1;
                    }else if (jurisdictionIds.contains(53)){
                        return 2;
                    }else if (jurisdictionIds.contains(55)){
                        return 3;
                    }else if(jurisdictionIds.contains(59)){
                        return 4;
                    }
                }
            }
        }
        return 5;
    }
}
