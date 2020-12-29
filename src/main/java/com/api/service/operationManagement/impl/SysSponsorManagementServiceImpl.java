package com.api.service.operationManagement.impl;

import com.api.dao.operationManagement.SysActivityManagementDao;
import com.api.dao.operationManagement.SysSponsorManagementDao;
import com.api.model.operationManagement.SearchSponsorManagement;
import com.api.model.operationManagement.SponsorManagement;
import com.api.model.system.SysUser;
import com.api.service.operationManagement.SysSponsorManagementService;
import com.api.util.UploadUtil;
import com.api.vo.operationManagement.VoSponsorManagement;
import com.api.vo.resources.VoResourcesImg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysSponsorManagementServiceImpl implements SysSponsorManagementService {
    private static Map<String,Object> map = null;
    @Value("${prop.upload-sponsor}")
    private String UPLOAD_SPONSOR;
    @Resource
    SysSponsorManagementDao sysSponsorManagementDao;
    @Resource
    SysActivityManagementDao sysActivityManagementDao;

    @Override
    public List<VoSponsorManagement> list(SearchSponsorManagement searchSponsorManagement) {
        List<VoSponsorManagement> list = sysSponsorManagementDao.list(searchSponsorManagement);
        UploadUtil uploadUtil = new UploadUtil();
        if (list != null && list.size()>0){
            for (VoSponsorManagement voSponsorManagement : list) {
                //查询照片资源信息
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysSponsorManagement", voSponsorManagement.getId(), "businessLicenseImg");
                //填入营业执照，照片资源
                voSponsorManagement.setImgUrls(imgByDate);
                //根据主键id查询主办次数
                int count = sysActivityManagementDao.countBySponsorId(voSponsorManagement.getId());
                //填入主办次数
                voSponsorManagement.setNum(count);
            }
        }
        return list;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(SponsorManagement sponsorManagement) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            //填入创建人
            sponsorManagement.setCreateId(sysUser.getId());
            //填入创建时间
            sponsorManagement.setCreateDate(new Date());
            //填入是否删除，0.删除，1.非删
            sponsorManagement.setIsDelete(1);
            //添加主办方信息
            int insert = sysSponsorManagementDao.insert(sponsorManagement);
            if (insert <= 0){
                throw new RuntimeException("添加主办方信息失败");
            }
            //添加照片资源
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.upload(sponsorManagement.getFile(),UPLOAD_SPONSOR,"sysSponsorManagement",sponsorManagement.getId(),"businessLicenseImg","600",30,20);
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

        map.put("message","添加主办方信息成功");
        map.put("status",true);
        return map;
    }
}
