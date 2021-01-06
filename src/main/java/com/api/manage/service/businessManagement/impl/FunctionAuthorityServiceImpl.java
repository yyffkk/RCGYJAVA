package com.api.manage.service.businessManagement.impl;

import com.api.manage.dao.businessManagement.FunctionAuthorityDao;
import com.api.manage.dao.businessManagement.SysUserDao;
import com.api.manage.dao.system.SysRoleDao;
import com.api.manage.service.businessManagement.FunctionAuthorityService;
import com.api.model.businessManagement.SearchFunctionAuthority;
import com.api.model.businessManagement.SysUser;
import com.api.vo.businessManagement.VoFunctionAuthority;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class FunctionAuthorityServiceImpl implements FunctionAuthorityService {
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
}
