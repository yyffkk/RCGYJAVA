package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysGreenAreaDao;
import com.api.manage.service.operationManagement.SysGreenAreaService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.SearchGreenArea;
import com.api.model.operationManagement.SysGreenArea;
import com.api.vo.operationManagement.VoGreenArea;
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
public class SysGreenAreaServiceImpl implements SysGreenAreaService {
    private static Map<String,Object> map = null;
    @Resource
    SysGreenAreaDao sysGreenAreaDao;

    @Override
    public List<VoGreenArea> list(SearchGreenArea searchGreenArea) {
        return sysGreenAreaDao.list(searchGreenArea);
    }

    @Override
    public Map<String, Object> insert(SysGreenArea sysGreenArea) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysGreenArea.setCreateId(sysUser.getId());
        sysGreenArea.setCreateDate(new Date());


        int insert = sysGreenAreaDao.insert(sysGreenArea);
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
    public Map<String, Object> findById(Integer id) {
        map = new HashMap<>();
        VoGreenArea voGreenArea = sysGreenAreaDao.findById(id);

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",voGreenArea);
        return map;
    }

    @Override
    public Map<String, Object> update(SysGreenArea sysGreenArea) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysGreenArea.setModifyId(sysUser.getId());
        sysGreenArea.setModifyDate(new Date());

        int update = sysGreenAreaDao.update(sysGreenArea);
        if (update >0){
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
                //根据绿化区域主键id查询绿化任务数量
                int count = sysGreenAreaDao.countTaskByAreaId(id);
                if (count >0){
                    throw new RuntimeException("该区域已被使用，不可删除");
                }

                int delete = sysGreenAreaDao.delete(id);
                if (delete <=0){
                    throw new RuntimeException("删除失败");
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
