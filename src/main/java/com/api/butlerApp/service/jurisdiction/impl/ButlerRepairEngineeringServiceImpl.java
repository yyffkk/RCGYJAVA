package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerRepairDao;
import com.api.butlerApp.dao.jurisdiction.ButlerRepairEngineeringDao;
import com.api.butlerApp.service.jurisdiction.ButlerRepairEngineeringService;
import com.api.model.businessManagement.SysOrganization;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.ButlerRepairEngineering;
import com.api.model.butlerApp.ButlerRepairEngineeringSearch;
import com.api.model.butlerApp.ButlerReportRepairEngineeringProcessRecord;
import com.api.util.IdWorker;
import com.api.util.UploadUtil;
import com.api.vo.butlerApp.ButlerRepairEngineeringFBIVo;
import com.api.vo.butlerApp.ButlerRepairEngineeringVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ButlerRepairEngineeringServiceImpl implements ButlerRepairEngineeringService {
    @Resource
    ButlerRepairEngineeringDao butlerRepairEngineeringDao;
    @Resource
    ButlerRepairDao butlerRepairDao;
    private static Map<String,Object> map = null;

    @Override
    public List<ButlerRepairEngineeringVo> list(ButlerRepairEngineeringSearch butlerRepairEngineeringSearch, int type) {
        List<ButlerRepairEngineeringVo> list = new ArrayList<>();
        switch (type){
            case 1:
                //工程派单-维修公司
                list = butlerRepairEngineeringDao.list1(butlerRepairEngineeringSearch);
                break;
            case 2:
                //工程派单-维修人员
                list = butlerRepairEngineeringDao.list2(butlerRepairEngineeringSearch);
                break;
            case 3:
                //工程接单-维修人员
                list = butlerRepairEngineeringDao.list3(butlerRepairEngineeringSearch);
                break;
            case 4:
                //无任何权限
                break;
            default:
                //系统错误
                break;
        }

        if (list != null && list.size() > 0){
            UploadUtil uploadUtil = new UploadUtil();
            for (ButlerRepairEngineeringVo butlerRepairEngineeringVo : list) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysReportRepairEngineering", butlerRepairEngineeringVo.getId(), "engineeringMaintenanceImg");
                butlerRepairEngineeringVo.setImgUrls(imgByDate);
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

            //添加处理进程记录
            ButlerReportRepairEngineeringProcessRecord engineeringProcessRecord = new ButlerReportRepairEngineeringProcessRecord();
            engineeringProcessRecord.setRepairEngineeringId(butlerRepairEngineering.getId());//填入工程维修主键id
            engineeringProcessRecord.setOperationDate(new Date());//填入操作时间(数据创建时间)
            engineeringProcessRecord.setOperationType(1);//填入操作类型，1.提交工程维修
            engineeringProcessRecord.setOperator(butlerRepairEngineering.getCreateId());//操作人（取自住户表或物业表）
            engineeringProcessRecord.setOperatorType(3);//填入操作人类型，3.操作人（物业）
            engineeringProcessRecord.setOperatorContent("等待物业分配");//填入操作内容


            //添加工程维修报修进程处理进程记录
            int insert2 = butlerRepairEngineeringDao.insertProcessRecord(engineeringProcessRecord);
            if (insert2 <= 0){
                throw new RuntimeException("添加处理进程记录失败");
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

    @Override
    public int findJurisdictionByUserId(String roleIds) {
        String[] split = roleIds.split(",");
        if (split.length >0){
            for (String s : split) {
                int roleId = Integer.parseInt(s);
                //根据角色id查询权限id集合
                List<Integer> jurisdictionIds = butlerRepairDao.findJIdsByRoleId(roleId);
                if (jurisdictionIds != null && jurisdictionIds.size()>0){
                    //69.工程派单-维修公司
                    if (jurisdictionIds.contains(69)){
                        return 1;
                    }
                    //70.工程派单-维修人员
                    if (jurisdictionIds.contains(70)){
                        return 2;
                    }
                    //71.工程接单-维修人员
                    if (jurisdictionIds.contains(71)){
                        return 3;
                    }
                }
            }
        }
        return 4;
    }

    @Override
    public Map<String, Object> findById(Integer repairEngineeringId) {
        map = new HashMap<>();

        ButlerRepairEngineeringFBIVo engineeringFBIVo = butlerRepairEngineeringDao.findById(repairEngineeringId);
        map.put("message","请求成功");
        map.put("data",engineeringFBIVo);
        map.put("status",true);

        return map;
    }

    @Override
    public Map<String, Object> findProcessRecordById(Integer repairEngineeringId) {
        map = new HashMap<>();

        List<ButlerReportRepairEngineeringProcessRecord> repairEngineeringProcessRecordList = butlerRepairEngineeringDao.findProcessRecordById(repairEngineeringId);

        map.put("message","请求成功");
        map.put("data",repairEngineeringProcessRecordList);
        map.put("status",true);

        return map;
    }

    @Override
    public Map<String, Object> findRepairOrganization() {
        map = new HashMap<>();

        List<SysOrganization> sysOrganizationList = butlerRepairEngineeringDao.findRepairOrganization();

        map.put("message","请求成功");
        map.put("data",sysOrganizationList);
        map.put("status",true);

        return map;
    }

    @Override
    public Map<String, Object> maintenanceCompanySendSingle(ButlerRepairEngineering butlerRepairEngineering, int type) {
        map = new HashMap<>();

        if (type != 1){
            map.put("message","派单(维修公司)权限不足");
            map.put("status",false);
            return map;
        }

        butlerRepairEngineering.setStatus(2);//填入状态，2.待派单（维修人员）

        int update = butlerRepairEngineeringDao.maintenanceCompanySendSingle(butlerRepairEngineering);
        if (update >0){
            map.put("message","派单成功");
            map.put("status",true);
        }else {
            map.put("message","派单失败");
            map.put("status",false);
        }

        return map;
    }

    @Override
    public Map<String, Object> findSysUserByOrganizationId(Integer repairOrganizationId) {
        map = new HashMap<>();

        List<SysUser> sysUserList = butlerRepairEngineeringDao.findSysUserByOrganizationId(repairOrganizationId);

        map.put("message","请求成功");
        map.put("data",sysUserList);
        map.put("status",true);

        return map;
    }
}
