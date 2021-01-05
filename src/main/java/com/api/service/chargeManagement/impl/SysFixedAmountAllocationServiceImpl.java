package com.api.service.chargeManagement.impl;

import com.api.dao.chargeManagement.SysFixedAmountAllocationDao;
import com.api.model.chargeManagement.*;
import com.api.model.system.SysUser;
import com.api.service.chargeManagement.SysFixedAmountAllocationService;
import com.api.util.UploadUtil;
import com.api.vo.chargeManagement.VoFindByIdFAA;
import com.api.vo.chargeManagement.VoFixedAmountAllocation;
import com.api.vo.chargeManagement.VoFixedAmountAllocationResult;
import com.api.vo.resources.VoResourcesImg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@Service
public class SysFixedAmountAllocationServiceImpl implements SysFixedAmountAllocationService {
    private static Map<String,Object> map = null;
    @Value("${prop.upload-voucher}")
    private String UPLOAD_VOUCHER;
    @Resource
    SysFixedAmountAllocationDao sysFixedAmountAllocationDao;

    @Override
    public List<VoFixedAmountAllocation> list(SearchFixedAmountAllocation searchFixedAmountAllocation) {
        return sysFixedAmountAllocationDao.list(searchFixedAmountAllocation);
    }

    @Override
    public Map<String, Object> insert(SysFixedAmountAllocation sysFixedAmountAllocation) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入创建人
        sysFixedAmountAllocation.setCreateId(sysUser.getId());
        //填入创建时间
        sysFixedAmountAllocation.setCreateDate(new Date());
        //状态，初始为1.未分摊
        sysFixedAmountAllocation.setStatus(1);
        //是否删除，0.删除，1.非删
        sysFixedAmountAllocation.setIsDelete(1);
        //添加固定金额分摊信息
        int insert = sysFixedAmountAllocationDao.insert(sysFixedAmountAllocation);
        if (insert > 0){
            map.put("message","添加固定金额分摊信息成功");
            map.put("status",true);
        }else {
            map.put("message","添加固定金额分摊信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public VoFindByIdFAA findById(Integer id) {
        return sysFixedAmountAllocationDao.findById(id);
    }

    @Override
    public Map<String, Object> update(SysFixedAmountAllocation sysFixedAmountAllocation) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入修改人
        sysFixedAmountAllocation.setModifyId(sysUser.getId());
        //填入修改时间
        sysFixedAmountAllocation.setModifyDate(new Date());
        int update = sysFixedAmountAllocationDao.update(sysFixedAmountAllocation);
        if (update >0){
            map.put("message","修改固定金额分摊信息成功");
            map.put("status",true);
        }else {
            map.put("message","修改固定金额分摊信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> falseDelete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                //假删除固定金额分摊信息
                int update = sysFixedAmountAllocationDao.falseDelete(id);
                if (update <= 0){
                    throw new RuntimeException("删除固定金额分摊信息失败");
                }
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
        map.put("message","删除固定金额分摊信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public List<VoFixedAmountAllocationResult> listResult(SearchFixedAmountAllocationResult searchFixedAmountAllocationResult) {
        List<VoFixedAmountAllocationResult> voFixedAmountAllocationResultList = sysFixedAmountAllocationDao.listResult(searchFixedAmountAllocationResult);
        if (voFixedAmountAllocationResultList != null && voFixedAmountAllocationResultList.size()>0){
            for (VoFixedAmountAllocationResult voFixedAmountAllocationResult : voFixedAmountAllocationResultList) {
                UploadUtil uploadUtil = new UploadUtil();
                //查询缴费凭证照片资源信息
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysFixedAmountAllocationResult", voFixedAmountAllocationResult.getId(), "voucherImg");
                //传入照片资源信息
                voFixedAmountAllocationResult.setImgUrls(imgByDate);
            }
        }
        return voFixedAmountAllocationResultList;
    }

    @Override
    @Transactional
    public Map<String, Object> share(Integer id) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        FixedAmountAllocationResult fixedAmountAllocationResult = new FixedAmountAllocationResult();

        try {
            //填入创建人
            fixedAmountAllocationResult.setCreateId(sysUser.getId());
            //填入创建时间
            fixedAmountAllocationResult.setCreateDate(new Date());
            //填入固定金额分摊id
            fixedAmountAllocationResult.setFixedAmountAllocationId(id);
            //填入状态，初始为1.未缴纳
            fixedAmountAllocationResult.setStatus(1);
            //根据主键id 查询 固定金额分摊信息
            VoFindByIdFAA byId = sysFixedAmountAllocationDao.findById(id);
            List<EstateIdAndConstructionArea> idsAndArea = new ArrayList<>();

            //判断是否已分摊
            if (byId.getStatus() ==2){
                throw new RuntimeException("此项目已分摊");
            }

            //根据分摊范围和分摊对象，查询分摊的房产id集合
            if (byId.getShareRange() == 1){
                //所有房间（查询有业主的房间）
                idsAndArea = sysFixedAmountAllocationDao.findAllRoomByHave();
            }else if (byId.getShareRange() == 2){
                String shareObjects = byId.getShareObjects();
                String[] split = shareObjects.split(",");
                for (int i = 0; i < split.length; i++) {
                    //指定楼栋（查询有业主的房间）
                    idsAndArea.addAll(sysFixedAmountAllocationDao.findBuildingRoomByHave(split[i]));
                }
            }else if (byId.getShareRange() == 3){
                String shareObjects = byId.getShareObjects();
                String[] split = shareObjects.split(",");
                for (int i = 0; i < split.length; i++) {
                    //指定房间（查询有业主的房间）
                    idsAndArea.add(sysFixedAmountAllocationDao.findRoomByHave(split[i]));
                }
            }else {
                throw new RuntimeException("分摊范围有误");
            }

            if (idsAndArea == null || idsAndArea.size() <= 0){
                throw new RuntimeException("没有指定房间或房间没有业主");
            }

            //填入分摊金额
            if (byId.getShareType() == 1){
                //按户分摊
                fixedAmountAllocationResult.setSharePrice(byId.getTotalPrice().divide(BigDecimal.valueOf(idsAndArea.size()),2,BigDecimal.ROUND_CEILING));
            }else if (byId.getShareType() == 2){
                //计算出总面积
                BigDecimal totalArea = BigDecimal.ZERO;
                for (EstateIdAndConstructionArea estateIdAndConstructionArea : idsAndArea) {
                    totalArea.add(estateIdAndConstructionArea.getConstructionArea());
                }
                //按面积分摊
                fixedAmountAllocationResult.setSharePrice(byId.getTotalPrice().divide(totalArea,2,BigDecimal.ROUND_CEILING));
            }

            //遍历房产id集合
            for (EstateIdAndConstructionArea estateIdAndConstructionArea : idsAndArea) {
                //填入房产id
                fixedAmountAllocationResult.setEstateId(estateIdAndConstructionArea.getId());
                //添加分摊信息
                int insert = sysFixedAmountAllocationDao.share(fixedAmountAllocationResult);
                if (insert <= 0){
                    throw new RuntimeException("添加分摊信息失败");
                }
            }

            //修改固定金额分摊的相关状态信息
            SysFixedAmountAllocation sysFixedAmountAllocation = new SysFixedAmountAllocation();
            //填入主键id
            sysFixedAmountAllocation.setId(id);
            //填入状态，2.已分摊
            sysFixedAmountAllocation.setStatus(2);
            //填入分摊时间（点击分摊按钮的时间）
            sysFixedAmountAllocation.setShareDate(new Date());
            //分摊操作人
            sysFixedAmountAllocation.setShareOperator(sysUser.getId());
            //修改固定金额分摊的相关状态信息
            int update = sysFixedAmountAllocationDao.updateStatus(sysFixedAmountAllocation);
            if (update <= 0){
                throw new RuntimeException("修改固定金额分摊状态失败");
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
        map.put("message","分摊信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> payment(FixedPayment fixedPayment) {
        map = new HashMap<>();

        if (fixedPayment.getFile() == null){
            //填入缴纳状态 2.已缴纳但无凭证
            fixedPayment.setStatus(2);
        }else {
            //填入缴纳状态 3.已缴纳有凭证
            fixedPayment.setStatus(3);
        }


        try {
            //上传缴纳凭证
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.upload(fixedPayment.getFile(),UPLOAD_VOUCHER,"sysFixedAmountAllocationResult",fixedPayment.getId(),"voucherImg","600",30,20);
        } catch (Exception e) {
            e.printStackTrace();
            //填入缴纳状态 2.已缴纳但无凭证
            fixedPayment.setStatus(2);
        }

        //改变固定金额分摊结果状态
        int update = sysFixedAmountAllocationDao.updateResultStatus(fixedPayment);
        if (update >0){
            map.put("message","缴纳成功");
            map.put("status",true);
        }else {
            map.put("message","缴纳失败");
            map.put("status",false);
        }

        return map;
    }
}
