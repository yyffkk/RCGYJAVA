package com.api.butlerApp.service.jurisdiction.impl;

import com.api.app.dao.butler.DecorationApplicationDao;
import com.api.butlerApp.dao.jurisdiction.ButlerDecorationDao;
import com.api.butlerApp.dao.jurisdiction.ButlerRepairDao;
import com.api.butlerApp.service.jurisdiction.ButlerDecorationService;
import com.api.model.butlerApp.*;
import com.api.vo.app.AppTrackRecordDetailVo;
import com.api.vo.app.AppTrackRecordVo;
import com.api.vo.butlerApp.ButlerChecksContentVo;
import com.api.vo.butlerApp.ButlerDecorationFBIVo;
import com.api.vo.butlerApp.ButlerDecorationVo;
import com.api.vo.butlerApp.ButlerTrackInspectionFBIVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ButlerDecorationServiceImpl implements ButlerDecorationService {
    @Resource
    DecorationApplicationDao decorationApplicationDao;
    @Resource
    ButlerDecorationDao butlerDecorationDao;
    @Resource
    ButlerRepairDao butlerRepairDao;
    private static Map<String,Object> map = null;


    @Override
    public List<ButlerDecorationVo> list(ButlerDecorationSearch decorationSearch) {
        int type = findJurisdictionByUserId(decorationSearch.getRoleId());
        List<ButlerDecorationVo> butlerDecorationVos = butlerDecorationDao.list(decorationSearch);
        List<ButlerDecorationVo> butlerDecorationVos2 = new ArrayList<>();
        if (butlerDecorationVos != null && butlerDecorationVos.size()>0){
            for (ButlerDecorationVo decorationVo : butlerDecorationVos) {
                if (decorationVo.getTracker() != null){
                    if (decorationVo.getStatus()<5){
                        //2.已指派（待执行）【装修状态为<5】
                        decorationVo.setOperationStatus(2);
                    }else {
                        //3.已完成【装修状态为>=5】
                        decorationVo.setOperationStatus(3);
                    }
                    butlerDecorationVos2.add(decorationVo);
                }else {
                    //1.待指派【当检查跟踪人为null且装修状态为>1】查询出来的数据默认装修状态>1，所以不用判断
                    decorationVo.setOperationStatus(1);
                    if (type == 1){
                        //当为待指派 时，显示待指派状态
                        butlerDecorationVos2.add(decorationVo);
                    }
                }
            }
        }
        return butlerDecorationVos2;
    }

    @Override
    public Map<String, Object> findById(Integer decorationId, String roleId) {
        map = new HashMap<>();
        int type = findJurisdictionByUserId(roleId);
        //根据装修主键id查询装修信息
        ButlerDecorationFBIVo decorationFBIVo = butlerDecorationDao.findById(decorationId);
        ButlerTrackInspectionFBIVo trackInspectionFBIVo = null;
        List<ButlerChecksContentVo> checksContentVos = null;
        List<AppTrackRecordVo> trackRecordVos = null;
        //判断是否已有跟踪人员
        if (decorationFBIVo.getTracker() != null){
            //如果type不为跟踪执行（跟踪人）），则显示检查周期信息
            if (type != 2){
                //根据装修主键id查询检查周期信息
                trackInspectionFBIVo = butlerDecorationDao.findInspectionById(decorationId);
                //查询跟踪检查内容信息（关联表）
                checksContentVos = butlerDecorationDao.findTrackChecksContent(decorationId);
            }

            //查询执行信息(调用app的 查询跟踪检查记录Dao接口)
            trackRecordVos = decorationApplicationDao.findTrackRecord(decorationId);
            if (trackRecordVos != null && trackRecordVos.size()>0){
                for (AppTrackRecordVo trackRecordVo : trackRecordVos) {
                    //查询跟踪检查记录明细
                    List<AppTrackRecordDetailVo> trackRecordDetailVos = decorationApplicationDao.findTrackRecordDetail(trackRecordVo.getId());
                    trackRecordVo.setRecordDetailVoList(trackRecordDetailVos);
                }
            }
        }else {
            //如果type为1.装修派工（管家），则显示检查周期信息
            if (type == 1) {
                //查询检查内容信息（标准表）
                checksContentVos = butlerDecorationDao.findChecksContent();
            }
        }

        //装修信息
        map.put("decorationFBIVo",decorationFBIVo);
        //跟踪检查周期信息
        map.put("trackInspectionFBIVo",trackInspectionFBIVo);
        //跟踪检查内容信息
        map.put("checksContentVos",checksContentVos);
        //查询执行信息(调用app的 查询跟踪检查记录Dao接口)
        map.put("trackRecordVos",trackRecordVos);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> appoint(ButlerTrackInspectionCycle trackInspectionCycle, Integer id, String roleId) {
        map = new HashMap<>();
        try {
            //根据装修主键id查询是否有指派的人
            int count = butlerDecorationDao.countInspectionCycle(trackInspectionCycle.getDecorationId());
            if (count >0){
                throw new RuntimeException("已有指派人");
            }
            //查询权限信息
            int type = findJurisdictionByUserId(roleId);
            if (type != 1){
                throw new RuntimeException("当前用户没有该权限");
            }
            //修改装修表 跟踪人id
            int update = butlerDecorationDao.updateTrackerById(trackInspectionCycle);
            if (update <= 0){
                throw new RuntimeException("修改装修表失败");
            }
            //填入创建人
            trackInspectionCycle.setCreateId(id);
            //填入创建时间
            trackInspectionCycle.setCreateDate(new Date());
            //填入开始时间
            trackInspectionCycle.setStartDate(new Date());
            //填入下一次检查日期
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(calendar.DATE,trackInspectionCycle.getInspectionCycle());
            Date date = calendar.getTime();
            trackInspectionCycle.setInspectionDateNext(date);
            //添加 装修跟踪检查周期表信息
            int insert = butlerDecorationDao.insertInspectionCycle(trackInspectionCycle);
            if (insert <= 0){
                throw new RuntimeException("添加装修跟踪检查周期表失败");
            }
            //添加 装修跟踪检查内容表（关联表）信息
            List<ButlerTrackChecksContent> checksContentList = trackInspectionCycle.getTrackChecksContentList();
            if (checksContentList != null && checksContentList.size()>0){
                for (ButlerTrackChecksContent checksContent : checksContentList) {
                    checksContent.setDecorationId(trackInspectionCycle.getDecorationId());
                    int insert2 = butlerDecorationDao.insertTrackChecksContent(checksContent);
                    if (insert2 <= 0){
                        throw new RuntimeException("添加装修跟踪检查内容表（关联表）信息失败");
                    }
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

        map.put("message","指派成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findTrackChecksDetail(Integer decorationId) {
        map = new HashMap<>();
        List<ButlerChecksContentVo> trackChecksContent = butlerDecorationDao.findTrackChecksContent(decorationId);
        map.put("trackChecksContent",trackChecksContent);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> submitTrackExecution(ButlerTrackRecord butlerTrackRecord, Integer id, String roleId) {
        map = new HashMap<>();
        try {
            //查询权限信息
            int type = findJurisdictionByUserId(roleId);
            if (type != 2){
                throw new RuntimeException("当前用户没有该权限");
            }

            //填入跟踪检查时间
            butlerTrackRecord.setTrackDate(new Date());
            //填入创建人
            butlerTrackRecord.setCreateId(id);
            //填入创建时间
            butlerTrackRecord.setCreateDate(new Date());
            //添加装修跟踪记录
            int insert = butlerDecorationDao.insertTrackRecord(butlerTrackRecord);
            if (insert <= 0){
                throw new RuntimeException("添加装修跟踪记录失败");
            }

            List<ButlerTrackRecordDetail> trackRecordDetails = butlerTrackRecord.getTrackRecordDetails();
            if (trackRecordDetails != null && trackRecordDetails.size() > 0){
                for (ButlerTrackRecordDetail trackRecordDetail : trackRecordDetails) {
                    //填入装修跟踪记录主键id
                    trackRecordDetail.setDecorationTrackRecordId(butlerTrackRecord.getId());
                    //填入创建人
                    trackRecordDetail.setCreateId(id);
                    //填入创建时间
                    trackRecordDetail.setCreateDate(new Date());
                    //添加装修跟踪记录明细
                    int insert2 = butlerDecorationDao.insertTrackRecordDetail(trackRecordDetail);
                    if (insert2 <= 0){
                        throw new RuntimeException("添加装修跟踪记录明细失败");
                    }
                }
            }

            //如果是完工检查提交，则更新装修表的【最后一次完工检查是否合格】字段
            if (butlerTrackRecord.getType() == 2){
                int update = butlerDecorationDao.updateIsQualified(butlerTrackRecord);
                if (update <= 0){
                    throw new RuntimeException("更新最后一次完工检查提交失败");
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
        map.put("message","提交成功");
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
                    if (jurisdictionIds.contains(59)){
                        //59.装修派工（管家）
                        return 1;
                    }else if (jurisdictionIds.contains(60)){
                        //60.跟踪执行（跟踪人）
                        return 2;
                    }
                }
            }
        }
        return 3;
    }
}
