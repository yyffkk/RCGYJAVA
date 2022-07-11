package com.api.manage.service.businessManagement.impl;

import com.api.manage.dao.businessManagement.SysIdentityDao;
import com.api.manage.service.businessManagement.SysIdentityService;
import com.api.model.system.SysIdentity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class SysIdentityServiceImpl implements SysIdentityService {
    private static Map<String,Object> map = null;
    @Resource
    SysIdentityDao sysIdentityDao;

    @Override
    public Map<String, Object> listAll() {
        map = new HashMap<>();

        List<SysIdentity> sysIdentityList = sysIdentityDao.listAll();

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sysIdentityList);

        return map;
    }

    @Override
    public Map<String, Object> insert(SysIdentity sysIdentity) {
        map = new HashMap<>();

        sysIdentity.setCode(UUID.randomUUID().toString().replace("-",""));

        int insert = sysIdentityDao.insert(sysIdentity);
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

        SysIdentity sysIdentity = sysIdentityDao.findById(id);
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sysIdentity);


        return map;
    }

    @Override
    public Map<String, Object> update(SysIdentity sysIdentity) {
        map = new HashMap<>();

        int update = sysIdentityDao.update(sysIdentity);
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

                //根据身份主键id查询是否有角色拥有该身份
                int count = sysIdentityDao.findUserByPositionId(id);
                if (count >0){
                    throw new RuntimeException("该岗位存在用户，不可删除");
                }

                //删除身份信息
                int delete = sysIdentityDao.delete(id);
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
