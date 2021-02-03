package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerRepairDao;
import com.api.butlerApp.service.jurisdiction.ButlerRepairService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.ButlerRepairSearch;
import com.api.model.butlerApp.ButlerUserIdAndRepairId;
import com.api.model.butlerService.ProcessRecord;
import com.api.model.butlerService.SysDispatchListDetail;
import com.api.model.butlerService.UpdateDispatchStatus;
import com.api.util.UploadUtil;
import com.api.vo.app.IdAndName;
import com.api.vo.butlerApp.*;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ButlerRepairServiceImpl implements ButlerRepairService {
    @Resource
    ButlerRepairDao butlerRepairDao;
    private static Map<String,Object> map = null;

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

    @Override
    public Map<String, Object> findById(Integer repairId, Integer id, String roleIds) {
        map = new HashMap<>();
        int type = findJurisdictionByUserId(roleIds);
        ButlerUserIdAndRepairId butlerUserIdAndRepairId = new ButlerUserIdAndRepairId();
        butlerUserIdAndRepairId.setId(id);
        butlerUserIdAndRepairId.setRepairId(repairId);
        ButlerRepairFindByIdVo butlerRepairFindByIdVo = null;
        ButlerDispatchTypeVo butlerDispatchTypeVo = null;

        switch (type){
            case 1:
                //派单人界面
                //根据用户主键id 和 报事报修主键id 查询报修详情
                butlerRepairFindByIdVo = butlerRepairDao.findById(butlerUserIdAndRepairId);
                //根据用户主键id 和 报事报修主键id 查询工单类型
                butlerDispatchTypeVo = butlerRepairDao.findDispatchTypeById(butlerUserIdAndRepairId);
                break;
            case 2:
                //接单人界面
                //根据用户主键id 和 报事报修主键id 查询报修详情
                butlerRepairFindByIdVo = butlerRepairDao.findById2(butlerUserIdAndRepairId);
                //根据用户主键id 和 报事报修主键id 查询工单类型
                butlerDispatchTypeVo = butlerRepairDao.findDispatchTypeById2(butlerUserIdAndRepairId);
                break;
            case 3:
                //其他人界面
                //根据用户主键id 和 报事报修主键id 查询报修详情
                butlerRepairFindByIdVo = butlerRepairDao.findById3(repairId);
                //根据用户主键id 和 报事报修主键id 查询工单类型
                butlerDispatchTypeVo = butlerRepairDao.findDispatchTypeById3(repairId);
                break;
            default:
                //系统错误
                break;
        }
        if (butlerRepairFindByIdVo != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sys_report_repair", butlerRepairFindByIdVo.getId(), "repairImg");
            butlerRepairFindByIdVo.setImgUrls(imgByDate);
        }
        map.put("repairDetail",butlerRepairFindByIdVo);
        map.put("dispatchType",butlerDispatchTypeVo);

        //根据报修id查询报修进程
        List<ButlerProcessRecordVo> butlerProcessRecordVo = butlerRepairDao.findProcessRecord(repairId);
        map.put("processRecord",butlerProcessRecordVo);
        //当前用户角色类型 type:1.派单人 2.维修人 3.其他角色
        map.put("type",type);
        return map;
    }

    @Override
    public Map<String, Object> findWorkOrderTimeLimit() {
        map = new HashMap<>();
        List<IdAndName> workOrderTimeLimit = butlerRepairDao.findWorkOrderTimeLimit();
        map.put("data",workOrderTimeLimit);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findWorkOrderTypeDetail(Integer workOrderTypeId) {
        map = new HashMap<>();
        List<IdAndName> workOrderTypeDetail = butlerRepairDao.findWorkOrderTypeDetail(workOrderTypeId);
        map.put("data",workOrderTypeDetail);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findRepairOrganization(int repairOrganizationId) {
        map = new HashMap<>();
        //根据父组织查询子组织信息
        List<ButlerRepairOrganizationVo> organization = butlerRepairDao.findRepairOrganization(repairOrganizationId);
        if (organization!= null && organization.size()>0){
            for (ButlerRepairOrganizationVo organizationVo : organization) {
                //根据组织id查询维修人信息
                List<ButlerRepairmanVo> butlerRepairmanVos = butlerRepairDao.findRepairman(organizationVo.getId());
                organizationVo.setRepairmanVos(butlerRepairmanVos);
            }
        }

        map.put("data",organization);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> dispatch(SysDispatchListDetail sysDispatchListDetail, String roleId) {
        map = new HashMap<>();

        try {
            //判断该用户是否有派单权限,type 1.派单 2.接单 3.其他
            int type = findJurisdictionByUserId(roleId);
            if (type != 1){
                throw new RuntimeException("此用户无派单权限");
            }
            //判断维修人是否有接单权限
            SysUser sysUserById = butlerRepairDao.findSysUserById(sysDispatchListDetail.getOperator());
            int type2 = findJurisdictionByUserId(sysUserById.getRoleId());
            if (type2 != 2){
                throw new RuntimeException("此维修人无接单权限");
            }

            //根据派工单主键id查询派工单状态
            int status = butlerRepairDao.findStatusByDispatchId(sysDispatchListDetail.getDispatchListId());
            //1.待分配
            if (status != 1){
                throw new RuntimeException("此订单当前不可分配");
            }

            //生成订单号
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            sysDispatchListDetail.setCode(uuid);
            //填入创建时间
            sysDispatchListDetail.setCreateDate(new Date());
            //填入派工时间
            sysDispatchListDetail.setDispatchDate(new Date());
            //添加派工单详情信息
            int insert = butlerRepairDao.dispatch(sysDispatchListDetail);
            if (insert <= 0){
                throw new RuntimeException("派工失败");
            }
            //改变工单状态(变为 2.已分配未接单)
            UpdateDispatchStatus updateDispatchStatus = new UpdateDispatchStatus();
            //填入工单主键id
            updateDispatchStatus.setId(sysDispatchListDetail.getDispatchListId());
            //填入工单状态
            updateDispatchStatus.setStatus(2);
            int update = butlerRepairDao.updateStatus(updateDispatchStatus);
            if (update <= 0){
                throw new RuntimeException("工单状态更改失败");
            }
            //添加处理进程记录
            ProcessRecord processRecord = new ProcessRecord();
            processRecord.setDispatchListId(sysDispatchListDetail.getDispatchListId());
            processRecord.setOperationDate(new Date());
            processRecord.setOperationType(2);
            processRecord.setOperator(sysDispatchListDetail.getCreateId());
            processRecord.setOperatorType(3);
            //查询维修人信息
            SysUser byId = butlerRepairDao.findSysUserById(sysDispatchListDetail.getOperator());
            processRecord.setOperatorContent("报修单指派给"+byId.getActualName());
            //添加处理进程记录
            int insert2 = butlerRepairDao.insertProcessRecord(processRecord);
            if (insert2 <= 0){
                throw new RuntimeException("添加处理进程记录失败");
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
    @Transactional
    public Map<String, Object> reassignment(Integer dispatchListId, Integer operator, String roleId, Integer id) {
        map = new HashMap<>();

        try {
            //判断该用户是否有派单权限,type 1.派单 2.接单 3.其他
            int type = findJurisdictionByUserId(roleId);
            if (type != 1){
                throw new RuntimeException("此用户无改派权限");
            }
            //判断维修人是否有接单权限
            SysUser sysUserById = butlerRepairDao.findSysUserById(operator);
            int type2 = findJurisdictionByUserId(sysUserById.getRoleId());
            if (type2 != 2){
                throw new RuntimeException("此维修人无接单权限");
            }

            //根据派工单主键id查询派工单状态
            int status = butlerRepairDao.findStatusByDispatchId(dispatchListId);
            //1.待分配
            if (status != 2){
                throw new RuntimeException("此订单当前不可改派");
            }
            SysDispatchListDetail sysDispatchListDetail = new SysDispatchListDetail();
            sysDispatchListDetail.setDispatchListId(dispatchListId);
            sysDispatchListDetail.setOperator(operator);
            sysDispatchListDetail.setModifyId(id);
            sysDispatchListDetail.setModifyDate(new Date());
            int update = butlerRepairDao.updateDispatchListDetail(sysDispatchListDetail);
            if (update <= 0){
                throw new RuntimeException("改派失败");
            }
            //添加处理进程记录
            ProcessRecord processRecord = new ProcessRecord();
            processRecord.setDispatchListId(dispatchListId);
            processRecord.setOperationDate(new Date());
            processRecord.setOperationType(10);
            processRecord.setOperator(id);
            processRecord.setOperatorType(3);
            //查询维修人信息
            SysUser byId = butlerRepairDao.findSysUserById(operator);
            processRecord.setOperatorContent("报修单改派给"+byId.getActualName());
            //添加处理进程记录
            int insert2 = butlerRepairDao.insertProcessRecord(processRecord);
            if (insert2 <= 0){
                throw new RuntimeException("添加处理进程记录失败");
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
        map.put("message","改派成功");
        map.put("status",true);
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
