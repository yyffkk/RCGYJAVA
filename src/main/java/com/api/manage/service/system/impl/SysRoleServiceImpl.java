package com.api.manage.service.system.impl;

import com.api.manage.dao.system.SysRoleDao;
import com.api.model.businessManagement.SysUser;
import com.api.model.system.SysRole;
import com.api.manage.service.system.SysRoleService;
import com.api.util.IdWorker;
import com.api.vo.businessManagement.VoRoleFBI;
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
    public Map<String, Object> insertRole(SysRole sysRole) {
        map = new HashMap<>();
        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            sysRole.setActionId((int) new IdWorker(1, 1, 1).nextId());
            sysRole.setCreateId(sysUser.getId());
            sysRole.setCreateDate(new Date());

//        if(sysRole.getName() == null){
//            return null;
//        }
            int insert = sysRoleDao.insertRole(sysRole);
            if (insert > 0) {
                map.put("message", "添加成功");
                map.put("status", true);
            } else {
                map.put("message", "添加失败");
                map.put("status", false);
            }
            return map;
        }catch (Exception e){
            //获取抛出的信息
            String message = e.getMessage();
            e.printStackTrace();
            map.put("message","请填写完整信息");
            map.put("status",false);
            //设置手动回滚
            return map;
//            TransactionAspectSupport.currentTransactionStatus()
//                    .setRollbackOnly();


        }
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
    @Transactional(rollbackFor = Exception.class)//TODO 回滚注解不生效，直接报没添加回滚错误
    public Map<String, Object> deleteRole(SysRole sysRole) {
        map = new HashMap<>();
        try {
            //判断是否有员工所属
            int count = sysRoleDao.countUserByRoleId(sysRole.getId());
            if (count >0 ){
                throw new RuntimeException("此角色存在绑定员工，不可删除");
            }

            //根据角色主键id删除角色权限关联表信息
            sysRoleDao.deleteRoleJurisdictionByRoleId(sysRole.getId());

            //删除角色信息
            int delete = sysRoleDao.deleteRole(sysRole.getId());
            if (delete <= 0){
                throw new RuntimeException("删除失败，角色不存在");
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
        map.put("message","删除角色成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findByRoleId(Integer roleId) {
        map = new HashMap<>();
        VoRoleFBI voRoleFBI = sysRoleDao.findByRoleId(roleId);
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",voRoleFBI);
        return map;
    }
}
