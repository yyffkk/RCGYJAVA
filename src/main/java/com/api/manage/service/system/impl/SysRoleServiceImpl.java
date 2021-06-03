package com.api.manage.service.system.impl;

import com.api.manage.dao.system.SysRoleDao;
import com.api.model.businessManagement.SysUser;
import com.api.model.businessManagement.UserIdAndParentId;
import com.api.model.system.SysRole;
import com.api.manage.service.system.SysRoleService;
import com.api.util.IdWorker;
import com.api.vo.system.VoCheckRole;
import com.api.vo.system.VoRole;
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

/**
 * 角色service实现
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    private static Map<String,Object> map = null;
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
    public List<SysRole> findByOrganizationId(Integer organizationId) {
        return sysRoleDao.findByOrganizationId(organizationId);
    }

    /**
     * 根据身份ID查找角色信息
     * @param positionId 身份ID
     * @return 角色信息
     */
    @Override
    public List<SysRole> findByIdentityId(Integer positionId) {
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

    @Override
    public List<VoCheckRole> roleCheckList(Integer id) {
        UserIdAndParentId userIdAndParentId = new UserIdAndParentId();
        userIdAndParentId.setUserId(id);
        userIdAndParentId.setParentId(0);

        //TODO 查询当前用户的所有角色信息（带选择字段）
//        List<VoCheckRole> roleCheckList = findRoleCheckList(userIdAndParentId);
        List<VoCheckRole> roleCheckList = null;
        return roleCheckList;
    }

    @Override
    public Map<String, Object> insertRole(SysRole sysRole) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysRole.setActionId((int) new IdWorker(1,1,1).nextId());
        sysRole.setCreateId(sysUser.getId());
        sysRole.setCreateDate(new Date());

        int insert = sysRoleDao.insertRole(sysRole);
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
    public Map<String, Object> updateRole(SysRole sysRole) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysRole.setModifyId(sysUser.getId());
        sysRole.setModifyDate(new Date());

        int insert = sysRoleDao.updateRole(sysRole);
        if (insert >0){
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
    public Map<String, Object> deleteRole(SysRole sysRole) {
        map = new HashMap<>();
        try {
            //判断是否有员工所属

            //删除角色信息

            //删除角色对应的权限信息
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
        map.put("message","删除角色成功");
        map.put("status",true);
        return map;
    }

//    private List<VoCheckRole> findRoleCheckList(UserIdAndParentId userIdAndParentId) {
//        List<VoCheckRole> voCheckRoleList = sysRoleDao.roleCheckList(userIdAndParentId);
//        if (voCheckRoleList != null && voCheckRoleList.size()>0){
//            for (VoCheckRole voCheckRole : voCheckRoleList) {
//                //填入上级权限id
//                userIdAndParentId.setParentId(voCheckRole.getParentId());
//                //递归查询下级，并填入集合中
//                List<VoCheckRole> roleList = findRoleCheckList(userIdAndParentId);
//                voCheckRole.setVoRoleList(roleList);
//            }
//        }
//        return voCheckRoleList;
//    }
}
