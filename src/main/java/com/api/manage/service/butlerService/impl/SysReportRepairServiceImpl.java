package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysDispatchListDao;
import com.api.manage.dao.butlerService.SysProcessRecordDao;
import com.api.manage.dao.butlerService.SysReportRepairDao;
import com.api.model.butlerService.DispatchList;
import com.api.model.butlerService.ProcessRecord;
import com.api.model.butlerService.ReportRepair;
import com.api.model.butlerService.SearchReportRepair;
import com.api.model.businessManagement.SysUser;
import com.api.manage.service.butlerService.SysReportRepairService;
import com.api.util.UploadUtil;
import com.api.util.createCode.FileEveryDaySerialNumber;
import com.api.vo.butlerService.VoFindByIdRepair;
import com.api.vo.butlerService.VoRepair;
import com.api.vo.butlerService.VoReportRepair;
import com.api.vo.resources.VoResourcesImg;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SysReportRepairServiceImpl implements SysReportRepairService {
    @Value("${res.dispatchCodeDatUrl}")
    private String DISPATCH_CODE_DAT_URL;
    private static Map<String,Object> map = null;
    @Resource
    SysReportRepairDao sysReportRepairDao;
    @Resource
    SysDispatchListDao sysDispatchListDao;
    @Resource
    SysProcessRecordDao sysProcessRecordDao;

    @Override
    public List<VoReportRepair> list(SearchReportRepair searchReportRepair) {
        //初始化数组参数，长度为3，值都为null
        String[] split = {null,null,null};
        if (searchReportRepair.getRoomName()!=null){
            //用'-'截取字符串 获取数组
            String[] split2 = searchReportRepair.getRoomName().replace(" ", "").split("-");
            //如果数组长度超过3，超出部分不要
            for (int i =0;i<split2.length;i++) {
                //防止下标越界异常
                if (i<3){
                    split[i] = split2[i];
                }
            }
            //添加楼栋模糊查询信息,StringUtils.isNotBlank()【null，''】为true【' ','a',' a '】为false
            if (StringUtils.isNotBlank(split[0])){
                searchReportRepair.setEstateNo(Integer.valueOf(split[0]));
            }
            //添加单元模糊查询信息
            if (StringUtils.isNotBlank(split[1])) {
                searchReportRepair.setUnitNo(Integer.valueOf(split[1]));
            }
            //添加房产模糊查询信息
            if (StringUtils.isNotBlank(split[2])) {
                searchReportRepair.setRoomNumber(split[2]);
            }
        }
        List<VoReportRepair> list = sysReportRepairDao.list(searchReportRepair);
        return list;
    }

    @Override
    public VoRepair findRepairDetail(Integer id) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        VoRepair repairDetail = sysReportRepairDao.findRepairDetail(id);
        //传入照片资源信息
        UploadUtil uploadUtil = new UploadUtil();
        List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysReportRepair", repairDetail.getId(), "repairImg");
        repairDetail.setImgUrls(imgByDate);
        repairDetail.setDispatchName(sysUser.getActualName());
        return repairDetail;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(ReportRepair reportRepair) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            //生成单号(3位单号)
            String code = new FileEveryDaySerialNumber(3, DISPATCH_CODE_DAT_URL).getSerialNumber();
//            String code = UUID.randomUUID().toString().replaceAll("-", "");
            //先创建报修工单
            DispatchList dispatchList = new DispatchList();
            //填入工单号（根据日期+单号生成）
            dispatchList.setCode(code);
            //填入工单类型（取自工单类型管理）
            dispatchList.setWorkOrderType(1);
            //填入状态（1.待分配，2.已分配未接单，3.已分配处理中，4.已处理，5.已确认已完成，6.已关闭，7.已作废）
            dispatchList.setStatus(1);
            //填入创建人
            dispatchList.setCreateId(sysUser.getId());
            //填入创建时间
            dispatchList.setCreateDate(new Date());
            //填入 是否删除，0删除，1非删（用户端删除）
            dispatchList.setUserDelete(1);
            //填入 是否删除，0删除，1非删（系统端删除）
            dispatchList.setSysDelete(1);
            //添加工单信息
            int insert = sysDispatchListDao.insert(dispatchList);
            if (insert <= 0){
                throw new RuntimeException("添加工单信息失败");
            }
            //添加报事报修信息
            //根据报修人查询房产id（取第一个）
            int estateId = sysReportRepairDao.findEstateIdByRepairman(reportRepair.getRepairman());
            reportRepair.setBuildingUnitEstateId(estateId);
            //填入创建人
            reportRepair.setCreateId(sysUser.getId());
            //填入创建时间
            reportRepair.setCreateDate(new Date());
            //填入单号
            reportRepair.setCode(code);
            //填入工单主键id
            reportRepair.setDispatchListId(dispatchList.getId());
            //填入报修来源，1.业主来电
            reportRepair.setFroms(1);
            //添加报事报修信息
            int insert2 = sysReportRepairDao.insert(reportRepair);
            if (insert2 <= 0){
                throw new RuntimeException("添加报事报修信息失败");
            }
            //将上传路径传入数据库
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(reportRepair.getFileUrls(),"sysReportRepair",reportRepair.getId(),"repairImg","600",30,20);

            //添加处理进程记录
            ProcessRecord processRecord = new ProcessRecord();
            //填入派工单id
            processRecord.setDispatchListId(dispatchList.getId());
            //填入操作时间（数据创建时间）
            processRecord.setOperationDate(new Date());
            //填入操作类型（1.提交报修，2.派单，3.开始处理，4.处理完成，5.确认，6.回访，7.回退，8.作废，9.取消）
            processRecord.setOperationType(1);
            //填入操作人（取自住户表或物业表）
            processRecord.setOperator(sysUser.getId());
            //填入操作人类型（1.住户，2.管家（物业）,3.操作人（物业））
            processRecord.setOperatorType(2);
            //填入操作内容
            processRecord.setOperatorContent("您的工单正在等待分配");
            int insert3 = sysProcessRecordDao.insert(processRecord);
            if (insert3 <= 0){
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
        map.put("message","添加工单信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public VoFindByIdRepair findById(Integer id) {
        VoFindByIdRepair byId = sysReportRepairDao.findById(id);
        if (byId != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysReportRepair", byId.getId(), "repairImg");
            byId.setImgUrls(imgByDate);
        }
        return byId;
    }

    @Override
    @Transactional
    public Map<String, Object> update(ReportRepair reportRepair) {
        map = new HashMap<>();
        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();
            //填入创建人
            reportRepair.setModifyId(sysUser.getId());
            //填入创建时间
            reportRepair.setModifyDate(new Date());
            //修改报事报修信息
            //根据报修人查询房产id（取第一个）
            int estateId = sysReportRepairDao.findEstateIdByRepairman(reportRepair.getRepairman());
            reportRepair.setBuildingUnitEstateId(estateId);

            int update = sysReportRepairDao.update(reportRepair);
            if (update <= 0){
                throw new RuntimeException("修改报事报修信息失败");
            }
            UploadUtil uploadUtil = new UploadUtil();
            //先根据报事报修主键数据id 删除数据库的照片资源
            uploadUtil.delete("sysReportRepair",reportRepair.getId(),"repairImg");
            //再添加照片资源到数据库
            uploadUtil.saveUrlToDB(reportRepair.getFileUrls(),"sysReportRepair",reportRepair.getId(),"repairImg","600",30,20);
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
        map.put("message","修改报事报修信息成功");
        map.put("status",true);
        return map;
    }

}
