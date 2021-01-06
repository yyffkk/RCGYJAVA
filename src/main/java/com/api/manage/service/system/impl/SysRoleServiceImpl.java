package com.api.manage.service.system.impl;

import com.api.manage.dao.system.SysRoleDao;
import com.api.model.system.SysRole;
import com.api.manage.service.system.SysRoleService;
import com.api.vo.system.VoRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色service实现
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    SysRoleDao sysRoleDao;

    /**
     * 角色ID查找角色信息
     * @param id 角色ID
     * @return 角色信息
     */
    @Override
    public SysRole findById(Integer id) {
        return sysRoleDao.findById(id);
    }
    /**
     * 根据组织ID查找角色信息
     * @param organizationId 组织ID
     * @return 角色信息
     */
    @Override
    public SysRole findByOrganizationId(Integer organizationId) {
        return sysRoleDao.findByOrganizationId(organizationId);
    }

    /**
     * 根据身份ID查找角色信息
     * @param positionId 身份ID
     * @return 角色信息
     */
    @Override
    public SysRole findByIdentityId(Integer positionId) {
        return sysRoleDao.findByIdentityId(positionId);
    }

    @Override
    public List<VoRole> roleList() {
        //递归查询下级，最高级为0
        List<VoRole> voRoleList = findRoleList(0);
        return voRoleList;
    }

    private List<VoRole> findRoleList(Integer parentId) {
        List<VoRole> voRoleList = sysRoleDao.roleList(parentId);
        if (voRoleList != null && voRoleList.size()>0){
            for (VoRole voRole : voRoleList) {
                //递归查询下级，并填入集合中
                List<VoRole> roleList = findRoleList(voRole.getId());
                voRole.setVoRoleList(roleList);
            }
        }
        return voRoleList;
    }
}
