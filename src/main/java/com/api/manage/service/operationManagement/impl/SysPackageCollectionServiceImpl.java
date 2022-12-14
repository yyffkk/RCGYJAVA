package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysPackageCollectionDao;
import com.api.manage.service.operationManagement.SysPackageCollectionService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.SearchPackageCollection;
import com.api.model.operationManagement.SysPackageCollection;
import com.api.vo.operationManagement.VoFBIPackageCollection;
import com.api.vo.operationManagement.VoPackageCollection;
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
public class SysPackageCollectionServiceImpl implements SysPackageCollectionService {
    private static Map<String,Object> map = null;
    @Resource
    SysPackageCollectionDao sysPackageCollectionDao;

    @Override
    public List<VoPackageCollection> list(SearchPackageCollection searchPackageCollection) {
        return sysPackageCollectionDao.list(searchPackageCollection);
    }

    @Override
    public Map<String, Object> insert(SysPackageCollection sysPackageCollection) {
        map = new HashMap<>();

        //根据手机号查询是否注册
        int count = sysPackageCollectionDao.countByTel(sysPackageCollection.getAddresseeTel());
        if (count <=0){
            map.put("message","收件人手机号未注册，添加失败");
            map.put("status",false);
            return map;
        }

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysPackageCollection.setCreateId(sysUser.getId());
        sysPackageCollection.setCreateDate(new Date());
        sysPackageCollection.setStatus(1); //默认填写状态,1.未领取

        int insert = sysPackageCollectionDao.insert(sysPackageCollection);
        if (insert >0) {
            map.put("message","添加成功");
            map.put("status",true);
        }else {
            map.put("message","添加失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> findById(Integer id) {
        map = new HashMap<>();
        VoFBIPackageCollection voFBIPackageCollection = sysPackageCollectionDao.findById(id);
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",voFBIPackageCollection);
        return map;
    }

    @Override
    public Map<String, Object> update(SysPackageCollection sysPackageCollection) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysPackageCollection.setModifyId(sysUser.getId());
        sysPackageCollection.setModifyDate(new Date());

        int update = sysPackageCollectionDao.update(sysPackageCollection);
        if (update >0) {
            map.put("message","修改成功");
            map.put("status",true);
        }else {
            map.put("message","修改失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                int delete = sysPackageCollectionDao.delete(id);
                if (delete <=0){
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
