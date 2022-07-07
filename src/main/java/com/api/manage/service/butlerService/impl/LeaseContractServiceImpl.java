package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.LeaseContractDao;
import com.api.manage.service.butlerService.LeaseContractService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.SearchLeaseContract;
import com.api.model.butlerService.SysLeaseContract;
import com.api.util.UploadUtil;
import com.api.vo.butlerService.VoLeaseContract;
import com.api.vo.resources.VoResourcesImg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LeaseContractServiceImpl implements LeaseContractService {
    private static Map<String,Object> map = null;
    @Resource
    LeaseContractDao leaseContractDao;


    @Override
    public List<VoLeaseContract> list(SearchLeaseContract searchLeaseContract) {
        List<VoLeaseContract> list = leaseContractDao.list(searchLeaseContract);
        if (list != null && list.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (VoLeaseContract voLeaseContract : list) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysLeaseContract", voLeaseContract.getId(), "leaseContractPdf");
                voLeaseContract.setImgUrls(imgByDate);
            }
        }
        return list;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(SysLeaseContract sysLeaseContract) {
        map = new HashMap<>();
        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            sysLeaseContract.setCreateId(sysUser.getId());
            sysLeaseContract.setCreateDate(new Date());
            sysLeaseContract.setStatus(2);//2.停用

            int insert = leaseContractDao.insert(sysLeaseContract);
            if (insert <= 0){
                throw new RuntimeException("添加失败");
            }
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(sysLeaseContract.getFileUrls(),"sysLeaseContract",sysLeaseContract.getId(),"leaseContractPdf","600",30,20);
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
    @Transactional
    public Map<String, Object> enable(Integer id) {
        map = new HashMap<>();
        String msg = "";
        try {
            VoLeaseContract voLeaseContract = leaseContractDao.findById(id);
            if (voLeaseContract == null){
                throw new RuntimeException("该模版不存在");
            }

            if (voLeaseContract.getStatus() == 1){//1.启用
                //停用该模版
                msg = "停用";

                SysLeaseContract sysLeaseContract = new SysLeaseContract();
                sysLeaseContract.setId(id);
                sysLeaseContract.setStatus(2);//2.停用

                int update = leaseContractDao.updateStatus(sysLeaseContract);
                if (update <= 0){
                    throw new RuntimeException(msg+"失败");
                }else {
                    map.put("message",msg+"成功");
                }
            }else if (voLeaseContract.getStatus() == 2){//2.停用
                //启用该模版
                msg = "启用";

                //先关闭所有模版
                int update = leaseContractDao.disEnableAll();
                if (update <= 0){
                    throw new RuntimeException(msg+"失败,无法关闭所有模版");
                }
                //再开启该模版
                SysLeaseContract sysLeaseContract = new SysLeaseContract();
                sysLeaseContract.setId(id);
                sysLeaseContract.setStatus(1);//1.启用

                int update2 = leaseContractDao.updateStatus(sysLeaseContract);
                if (update2 <= 0){
                    throw new RuntimeException(msg+"失败");
                }
            }else {
                throw new RuntimeException("该模版状态数据有误");
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
        map.put("message",msg+"成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                VoLeaseContract byId = leaseContractDao.findById(id);
                if (byId.getStatus() == 1){
                    throw new RuntimeException("模版名称为：【"+byId.getName()+"】的模版已启用,不可删除");
                }

                int delete = leaseContractDao.delete(id);
                if (delete <= 0){
                    throw new RuntimeException("模版删除失败");
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
        map.put("message","删除成功");
        map.put("status",true);
        return map;
    }
}
