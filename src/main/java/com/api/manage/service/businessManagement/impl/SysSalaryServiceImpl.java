package com.api.manage.service.businessManagement.impl;

import com.api.manage.dao.businessManagement.SysSalaryDao;
import com.api.manage.service.businessManagement.SysSalaryService;
import com.api.model.businessManagement.SearchSalary;
import com.api.model.businessManagement.SysSalary;
import com.api.model.businessManagement.SysUser;
import com.api.vo.businessManagement.VoSalary;
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
public class SysSalaryServiceImpl implements SysSalaryService {
    private static Map<String,Object> map = null;
    @Resource
    SysSalaryDao sysSalaryDao;

    @Override
    public List<VoSalary> list(SearchSalary searchSalary) {
        return sysSalaryDao.list(searchSalary);
    }

    @Override
    public Map<String, Object> insert(SysSalary sysSalary) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysSalary.setCreateId(sysUser.getId());
        sysSalary.setCreateDate(new Date());

        int insert = sysSalaryDao.insert(sysSalary);
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
            for (int id : ids) {
                int delete = sysSalaryDao.delete(id);
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

    @Override
    public Map<String, Object> update(SysSalary sysSalary) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysSalary.setModifyId(sysUser.getId());
        sysSalary.setModifyDate(new Date());

        int update = sysSalaryDao.update(sysSalary);
        if (update >0){
            map.put("message","修改成功");
            map.put("status",true);
        }else {
            map.put("message","修改失败");
            map.put("status",false);
        }
        return map;
    }
}
