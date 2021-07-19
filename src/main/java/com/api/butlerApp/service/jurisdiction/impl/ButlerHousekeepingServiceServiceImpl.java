package com.api.butlerApp.service.jurisdiction.impl;

import com.api.app.dao.butler.AppHousekeepingServiceDao;
import com.api.butlerApp.dao.jurisdiction.ButlerHousekeepingServiceDao;
import com.api.butlerApp.dao.jurisdiction.ButlerRepairDao;
import com.api.butlerApp.service.jurisdiction.ButlerHousekeepingServiceService;
import com.api.model.app.AppHousekeepingService;
import com.api.model.app.AppHousekeepingServiceProcessRecord;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.ButlerHousekeepingServiceSearch;
import com.api.util.UploadUtil;
import com.api.vo.app.AppHousekeepingServiceVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ButlerHousekeepingServiceServiceImpl implements ButlerHousekeepingServiceService {
    private static Map<String,Object> map = null;
    @Resource
    ButlerHousekeepingServiceDao butlerHousekeepingServiceDao;
    @Resource
    ButlerRepairDao butlerRepairDao;
    @Resource
    AppHousekeepingServiceDao appHousekeepingServiceDao;

    @Override
    public List<AppHousekeepingServiceVo> list(ButlerHousekeepingServiceSearch butlerHousekeepingServiceSearch, int type) {
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


    @Override
    public Map<String, Object> findPickUpSinglePersonnel(int organizationId) {
        map = new HashMap<>();
        List<SysUser> sysUser = butlerHousekeepingServiceDao.findPickUpSinglePersonnel(organizationId);
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sysUser);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> sendSingle(AppHousekeepingService appHousekeepingService, String roleId) {
        map = new HashMap<>();
        try {
            int type = findJurisdictionByUserId(roleId);
            if (type != 1){
                throw new RuntimeException("派单权限不足");
            }

            AppHousekeepingService housekeepingServiceById = appHousekeepingServiceDao.findHousekeepingServiceById(appHousekeepingService.getId());
            if (housekeepingServiceById.getStatus() != 1){
                throw new RuntimeException("当前状态不可派单");
            }

            appHousekeepingService.setStatus(2);//2.已派单
            int update = butlerHousekeepingServiceDao.sendSingle(appHousekeepingService);
            if (update <= 0){
                throw new RuntimeException("派单失败");
            }

            //添加家政服务处理进程记录
            AppHousekeepingServiceProcessRecord processRecord = new AppHousekeepingServiceProcessRecord();
            processRecord.setHousekeepingServiceId(appHousekeepingService.getId());
            processRecord.setOperationDate(new Date());
            processRecord.setOperationType(2);//2.派单
            processRecord.setOperator(appHousekeepingService.getAssigner());
            processRecord.setOperatorType(3);//3.操作人（物业）

            //查询被指派人信息
            SysUser sysUser  = appHousekeepingServiceDao.findUserInfoById(appHousekeepingService.getHandler());

            processRecord.setOperatorContent("分派给"+sysUser.getActualName()+"师傅");
            int insert2 = appHousekeepingServiceDao.insertHousekeepingProcessRecord(processRecord);
            if (insert2 <= 0){
                throw new RuntimeException("提交服务进程失败");
            }
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
        map.put("message","派单成功");
        map.put("status",true);
        return map;
    }

    @Override
    public int findJurisdictionByUserId(String roleIds) {
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
