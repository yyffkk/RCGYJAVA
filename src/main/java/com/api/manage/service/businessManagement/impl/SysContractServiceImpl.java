package com.api.manage.service.businessManagement.impl;

import com.api.manage.dao.businessManagement.SysContractDao;
import com.api.manage.service.businessManagement.SysContractService;
import com.api.model.businessManagement.SearchContract;
import com.api.model.businessManagement.SysContract;
import com.api.model.businessManagement.SysUser;
import com.api.util.UploadUtil;
import com.api.vo.businessManagement.VoContract;
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
public class SysContractServiceImpl implements SysContractService {
    private static Map<String,Object> map = null;
    @Resource
    SysContractDao sysContractDao;

    @Override
    public List<VoContract> list(SearchContract searchContract) {
        return sysContractDao.list(searchContract);
    }

    @Override
    public Map<String, Object> insert(SysContract sysContract) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysContract.setCreateId(sysUser.getId());
        sysContract.setCreateDate(new Date());

        int insert = sysContractDao.insert(sysContract);
        if (insert >0){
            map.put("message","添加成功");
            map.put("status",true);
        }else {
            map.put("message","添加失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();

        try {
            UploadUtil uploadUtil = new UploadUtil();
            for (int id : ids) {
                //根据合同管理主键id查询合同信息
                VoContract voContract = sysContractDao.findById(id);
                //删除doc文件信息
                uploadUtil.deleteDoc(voContract.getFileDocUrl());
                //在删除合同记录
                int delete = sysContractDao.delete(id);
                if (delete <= 0){
                    throw new RuntimeException("删除失败");
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
        map.put("message","删除成功");
        map.put("status",true);
        return map;
    }
}
