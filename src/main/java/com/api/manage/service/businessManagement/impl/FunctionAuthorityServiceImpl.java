package com.api.manage.service.businessManagement.impl;

import com.api.manage.dao.businessManagement.FunctionAuthorityDao;
import com.api.manage.dao.businessManagement.SysUserDao;
import com.api.manage.dao.system.SysRoleDao;
import com.api.manage.service.businessManagement.FunctionAuthorityService;
import com.api.model.businessManagement.*;
import com.api.vo.businessManagement.VoFunctionAuthority;
import com.api.vo.businessManagement.VoListJurisdiction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FunctionAuthorityServiceImpl implements FunctionAuthorityService {
    private static Map<String,Object> map = null;
    @Resource
    FunctionAuthorityDao functionAuthorityDao;
    @Resource
    SysRoleDao sysRoleDao;
    @Resource
    SysUserDao sysUserDao;

    @Override
    public List<VoFunctionAuthority> list(SearchFunctionAuthority searchFunctionAuthority) {
        List<VoFunctionAuthority> list = functionAuthorityDao.list(searchFunctionAuthority);
        if (list != null && list.size()>0){
            for (VoFunctionAuthority voFunctionAuthority : list) {
                //查询角色信息
                String roleId = voFunctionAuthority.getRoleId();
                if (roleId != null){
                    String roleName = "";
                    String[] split = roleId.split(",");
                    for (int i = 0; i < split.length; i++) {
                        String name = sysRoleDao.findNameByRoleId(Integer.valueOf(split[i]));
                        if (i == 0){
                            roleName += name;
                        }else {
                            roleName += ","+name;
                        }
                    }
                    voFunctionAuthority.setRoleName(roleName);
                }
            }
        }
        return list;
    }

    @Override
    public List<Integer> findRoleNameByUserId(Integer id) {
        ArrayList<Integer> objects = new ArrayList<>();
        String roleNameByUserId = sysUserDao.findRoleNameByUserId(id);
        if (roleNameByUserId != null){
            String[] split = roleNameByUserId.split(",");
            for (String s : split) {
                objects.add(Integer.valueOf(s));
            }
        }
        return objects;
    }

    @Override
    public Map<String, Object> updateRole(UserIdAndRoleId userIdAndRoleId) {
        map = new HashMap<>();
        //给员工修改角色配置
        int update = sysUserDao.updateRole(userIdAndRoleId);
        if (update >0){
            map.put("message","修改员工角色配置成功");
            map.put("status",true);
        }else {
            map.put("message","修改员工角色配置失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public List<VoListJurisdiction> listJurisdiction(RoleIdAndParentId searchListJurisdiction) {
        //填入上级权限id，最高级为0
        searchListJurisdiction.setParentId(0);
        //递归查询当前角色的所有权限信息
        List<VoListJurisdiction> listJurisdiction = findListJurisdiction(searchListJurisdiction);
        return listJurisdiction;
    }

    @Override
    @Transactional
    public Map<String, Object> updateJurisdiction(RoleIdAndJurisdictionIdList roleIdAndJurisdictionIdList) {
        map = new HashMap<>();
        try {
            //先删除该角色的所有权限
            functionAuthorityDao.deleteJurisdictionByRoleId(roleIdAndJurisdictionIdList.getRoleId());
            //再添加权限
            if (roleIdAndJurisdictionIdList.getJurisdictionIdList().length>0){
                for (Integer jurisdictionId : roleIdAndJurisdictionIdList.getJurisdictionIdList()) {
                    RoleIdAndJurisdictionId roleIdAndJurisdictionId = new RoleIdAndJurisdictionId();
                    //填入角色id
                    roleIdAndJurisdictionId.setRoleId(roleIdAndJurisdictionIdList.getRoleId());
                    //填入权限id
                    roleIdAndJurisdictionId.setJurisdictionId(jurisdictionId);
                    //添加权限
                    int insert = functionAuthorityDao.insertJurisdiction(roleIdAndJurisdictionId);
                    if (insert <=0){
                        throw new RuntimeException("保存失败");
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
        map.put("message","保存成功");
        map.put("status",true);
        return map;
    }

    //递归查询当前角色的所有权限信息
    public List<VoListJurisdiction> findListJurisdiction(RoleIdAndParentId searchListJurisdiction){
        List<VoListJurisdiction> voListJurisdictionList = functionAuthorityDao.listJurisdiction(searchListJurisdiction);
        if (voListJurisdictionList != null && voListJurisdictionList.size() >0){
            for (VoListJurisdiction voListJurisdiction : voListJurisdictionList) {
                //填入上级权限id
                searchListJurisdiction.setParentId(voListJurisdiction.getId());
                //递归查询下级权限信息，并填入集合中
                List<VoListJurisdiction> listJurisdiction = findListJurisdiction(searchListJurisdiction);
                voListJurisdiction.setVoListJurisdictionList(listJurisdiction);
                voListJurisdiction.setRoleId(searchListJurisdiction.getRoleId());
            }
        }
        return voListJurisdictionList;
    }
}
