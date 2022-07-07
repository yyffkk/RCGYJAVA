package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysMaterialDao;
import com.api.manage.service.operationManagement.SysMaterialService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.SearchMaterial;
import com.api.model.operationManagement.SysMaterial;
import com.api.vo.operationManagement.VoMaterial;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysMaterialServiceImpl implements SysMaterialService {
    private static Map<String,Object> map = null;
    @Resource
    SysMaterialDao sysMaterialDao;


    @Override
    public List<VoMaterial> list(SearchMaterial searchMaterial) {
        return sysMaterialDao.list(searchMaterial);
    }

    @Override
    public Map<String, Object> insert(SysMaterial sysMaterial) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysMaterial.setCreateId(sysUser.getId());
        sysMaterial.setCreateDate(new Date());
        sysMaterial.setStock(0);//填入默认库存0
        sysMaterial.setIsDelete(1);//默认填入1.非删

        int insert = sysMaterialDao.insert(sysMaterial);
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
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();

        try {
            for (int id : ids) {
                int update = sysMaterialDao.delete(id);
                if (update <= 0){
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

    @Override
    public Map<String, Object> update(SysMaterial sysMaterial) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysMaterial.setModifyId(sysUser.getId());
        sysMaterial.setModifyDate(new Date());

        int insert = sysMaterialDao.update(sysMaterial);
        if (insert >0){
            map.put("message","修改成功");
            map.put("status",true);
        }else {
            map.put("message","修改失败");
            map.put("status",false);
        }
        return map;
    }
}
