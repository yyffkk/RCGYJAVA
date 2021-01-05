package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysDispatchListDao;
import com.api.manage.dao.butlerService.SysProcessRecordDao;
import com.api.manage.dao.butlerService.SysReportRepairDao;
import com.api.manage.dao.chargeManagement.SysHandleCompleteDetailDao;
import com.api.manage.dao.system.SysUserDao;
import com.api.model.butlerService.*;
import com.api.model.system.SysUser;
import com.api.manage.service.butlerService.SysDispatchListService;
import com.api.util.UploadUtil;
import com.api.vo.butlerService.*;
import com.api.vo.chargeManagement.VoHandleCompleteDetail;
import com.api.vo.resources.VoResourcesImg;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SysDispatchListServiceImpl implements SysDispatchListService {
    private static Map<String,Object> map = null;
    @Resource
    SysDispatchListDao sysDispatchListDao;
    @Resource
    SysReportRepairDao sysReportRepairDao;
    @Resource
    SysProcessRecordDao sysProcessRecordDao;
    @Resource
    SysUserDao sysUserDao;
    @Resource
    SysHandleCompleteDetailDao sysHandleCompleteDetailDao;

    @Override
    public List<VoDispatchList> list(SearchDispatchList searchDispatchList) {
        //初始化数组参数，长度为3，值都为null
        String[] split = {null,null,null};
        if (searchDispatchList.getRoomName()!=null){
            //用'-'截取字符串 获取数组
            String[] split2 = searchDispatchList.getRoomName().replace(" ", "").split("-");
            //如果数组长度超过3，超出部分不要
            for (int i =0;i<split2.length;i++) {
                //防止下标越界异常
                if (i<3){
                    split[i] = split2[i];
                }
            }
            //添加楼栋模糊查询信息,StringUtils.isNotBlank()【null，''】为true【' ','a',' a '】为false
            if (StringUtils.isNotBlank(split[0])){
                searchDispatchList.setEstateNo(Integer.valueOf(split[0]));
            }
            //添加单元模糊查询信息
            if (StringUtils.isNotBlank(split[1])) {
                searchDispatchList.setUnitNo(Integer.valueOf(split[1]));
            }
            //添加房产模糊查询信息
            if (StringUtils.isNotBlank(split[2])) {
                searchDispatchList.setRoomNumber(split[2]);
            }
        }
        List<VoDispatchList> list = null;
        if (searchDispatchList.getType() != null){
            if (searchDispatchList.getType() == 1){
                //当工单类型为1.报事报修时
                list = sysDispatchListDao.list(searchDispatchList);
                if (list != null && list.size()>0){
                    for (VoDispatchList voDispatchList : list) {
                        voDispatchList.setWorkOrderTypeName("报事报修");
                    }
                }
            }else {
                //其他情况未做，为空
            }
        }else {
            list = sysDispatchListDao.list(searchDispatchList);
        }

        return list;
    }

    @Override
    public Map<String, Object> falseDelete(Integer id) {
        map = new HashMap<>();
        int update = sysDispatchListDao.falseDelete(id);
        if (update > 0){
            map.put("message","工单删除成功");
            map.put("status",true);
        }else {
            map.put("message","工单删除失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> cancel(CancelWorkOrder cancelWorkOrder) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            int update = sysDispatchListDao.cancel(cancelWorkOrder);
            if (update <= 0){
                throw new RuntimeException("工单作废失败");
            }
            //添加处理进程记录
            ProcessRecord processRecord = new ProcessRecord();
            processRecord.setDispatchListId(cancelWorkOrder.getId());
            processRecord.setOperationDate(new Date());
            processRecord.setOperationType(8);
            processRecord.setOperator(sysUser.getId());
            processRecord.setOperatorType(3);
            processRecord.setOperatorContent(sysUser.getActualName()+"作废了此工单");
            int insert = sysProcessRecordDao.insert(processRecord);
            if (insert <= 0){
                throw new RuntimeException("添加处理进程记录失败");
            }
        } catch (RuntimeException e) {
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
        map.put("message","工单作废成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> revisit(RevisitWorkOrder revisitWorkOrder) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            revisitWorkOrder.setRevisitDate(new Date());
            //添加回访信息
            int update = sysDispatchListDao.revisit(revisitWorkOrder);
            if (update <= 0){
                throw new RuntimeException("添加回访信息失败");
            }
            //添加处理进程记录
            ProcessRecord processRecord = new ProcessRecord();
            processRecord.setDispatchListId(revisitWorkOrder.getId());
            processRecord.setOperationDate(new Date());
            processRecord.setOperationType(6);
            processRecord.setOperator(sysUser.getId());
            processRecord.setOperatorType(3);
            processRecord.setOperatorContent("已电话回访");
            int insert = sysProcessRecordDao.insert(processRecord);
            if (insert <= 0){
                throw new RuntimeException("添加处理进程记录失败");
            }
        } catch (RuntimeException e) {
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
        map.put("message","添加回访信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> rollback(Integer id) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            int status = sysDispatchListDao.findStatusById(id);
            if (status >2){
                throw new RuntimeException("此工单不可回退");
            }else {
                //回退工单
                int delete = sysDispatchListDao.rollback(id);
                if (delete <= 0){
                    throw new RuntimeException("此工单回退失败");
                }
                //改变工单状态(变为 1.待分配)
                UpdateDispatchStatus updateDispatchStatus = new UpdateDispatchStatus();
                //填入工单主键id
                updateDispatchStatus.setId(id);
                //填入工单状态
                updateDispatchStatus.setStatus(1);
                int update = sysDispatchListDao.updateStatus(updateDispatchStatus);
                if (update <= 0){
                    throw new RuntimeException("工单状态更改失败");
                }
                //添加处理进程记录
                ProcessRecord processRecord = new ProcessRecord();
                processRecord.setDispatchListId(id);
                processRecord.setOperationDate(new Date());
                processRecord.setOperationType(7);
                processRecord.setOperator(sysUser.getId());
                processRecord.setOperatorType(3);
                processRecord.setOperatorContent("该工单已被"+sysUser.getActualName()+"回退，分配信息已取消");
                int insert = sysProcessRecordDao.insert(processRecord);
                if (insert <= 0){
                    throw new RuntimeException("添加处理进程记录失败");
                }
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

        map.put("message","此工单回退成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> dispatch(SysDispatchListDetail sysDispatchListDetail) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            //填入创建人
            sysDispatchListDetail.setCreateId(sysUser.getId());
            //填入创建时间
            sysDispatchListDetail.setCreateDate(new Date());
            //生成订单号
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            sysDispatchListDetail.setCode(uuid);
            //添加派工单详情信息
            int insert = sysDispatchListDao.dispatch(sysDispatchListDetail);
            if (insert <= 0){
                throw new RuntimeException("派工失败");
            }
            //改变工单状态(变为 2.已分配未接单)
            UpdateDispatchStatus updateDispatchStatus = new UpdateDispatchStatus();
            //填入工单主键id
            updateDispatchStatus.setId(sysDispatchListDetail.getDispatchListId());
            //填入工单状态
            updateDispatchStatus.setStatus(2);
            int update = sysDispatchListDao.updateStatus(updateDispatchStatus);
            if (update <= 0){
                throw new RuntimeException("工单状态更改失败");
            }
            //添加处理进程记录
            ProcessRecord processRecord = new ProcessRecord();
            processRecord.setDispatchListId(sysDispatchListDetail.getDispatchListId());
            processRecord.setOperationDate(new Date());
            processRecord.setOperationType(2);
            processRecord.setOperator(sysUser.getId());
            processRecord.setOperatorType(3);
            //查询维修人信息
            SysUser byId = sysUserDao.findById(sysDispatchListDetail.getOperator());
            processRecord.setOperatorContent("报修单指派给"+byId.getActualName());
            int insert2 = sysProcessRecordDao.insert(processRecord);
            if (insert2 <= 0){
                throw new RuntimeException("添加处理进程记录失败");
            }
        } catch (RuntimeException e) {
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

        map.put("message","派工成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> repairWorkOrderDetail(Integer id) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        VoRepair voRepair = sysReportRepairDao.findRepairDetail(id);
        voRepair.setDispatchName(sysUser.getActualName());
        //传入照片资源信息
        UploadUtil uploadUtil = new UploadUtil();
        List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sys_report_repair", id, "repairImg");
        voRepair.setImgUrls(imgByDate);
        //传出报修详情
        map.put("voRepair",voRepair);
        //传出派工详情
        VoDispatch voDispatch = sysDispatchListDao.findDispatchDetail(id);
        map.put("voDispatch",voDispatch);
        //传出处理进程记录
        List<VoProcessRecord> voProcessRecordList = sysProcessRecordDao.findByDispatchListId(id);
        map.put("voProcessRecordList",voProcessRecordList);
        //传出处理完成情况
        VoHandleCompleteDetail voHandleCompleteDetail = sysHandleCompleteDetailDao.findByDispatchListId(id);
        map.put("voHandleCompleteDetail",voHandleCompleteDetail);
        //传出客户评价
        VoEvaluation voEvaluation = sysDispatchListDao.findEvaluationById(id);
        map.put("voEvaluation",voEvaluation);
        //传出回访信息
        VoRevisit voRevisit = sysDispatchListDao.findRevisitById(id);
        map.put("voRevisit",voRevisit);
        return map;
    }


}
