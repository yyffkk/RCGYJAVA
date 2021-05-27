package com.api.manage.service.businessManagement.impl;

import com.api.manage.dao.businessManagement.SysOrganizationDao;
import com.api.manage.dao.businessManagement.SysUserDao;
import com.api.manage.dao.system.SysRoleDao;
import com.api.manage.service.businessManagement.SysUserService;
import com.api.model.businessManagement.SearchUser;
import com.api.model.businessManagement.SysUser;
import com.api.vo.businessManagement.VoFindByIdUser;
import com.api.vo.businessManagement.VoFunctionAuthority;
import com.api.vo.businessManagement.VoUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysUserServiceImpl implements SysUserService {
    private static Map<String,Object> map = null;
    @Resource
    SysUserDao sysUserDao;
    @Resource
    SysOrganizationDao sysOrganizationDao;
    @Resource
    SysRoleDao sysRoleDao;

    @Override
    public List<VoUser> list(SearchUser searchUser) {
        List<VoUser> list = sysUserDao.list(searchUser);
        if (list != null && list.size()>0){
            for (VoUser voUser : list) {
                //查询角色信息
                String roleId = voUser.getRoleId();
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
                    voUser.setRoleName(roleName);
                }
            }
        }
        return list;
    }

    @Override
    public Map<String, Object> insert(SysUser sysUser) {
        map = new HashMap<>();

        //查询电话是否已存在
        SysUser byTel = sysUserDao.findByTel(sysUser.getTel());
        if (byTel != null){
            map.put("message","手机号已存在");
            map.put("status",false);
            return map;
        }

        //查询身份证是否已存在
        SysUser byIdCard = sysUserDao.findByIdCard(sysUser.getTel());
        if (byIdCard != null){
            map.put("message","身份证号已存在");
            map.put("status",false);
            return map;
        }

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser2 = (SysUser) subject.getPrincipal();

        //填入创建人
        sysUser.setCreateId(sysUser2.getId());
        //填入创建时间
        sysUser.setCreateDate(new Date());
        //填入用户状态，初始为1.正常
        sysUser.setStatus(1);
        //填入是否删除,初始为1.非删
        sysUser.setIsDelete(1);
        //填入组织ID 全路径
        String idPath = findOrganizationIdPath(sysUser.getOrganizationId());
        sysUser.setOrganizationIdPath(idPath);
        //填入用户名（与手机号一致）
        sysUser.setUserName(sysUser.getTel());

        //添加员工信息
        int insert = sysUserDao.insert(sysUser);
        if (insert >0 ){
            map.put("message","新建员工成功");
            map.put("status",true);
        }else {
            map.put("message","新建员工失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public VoFindByIdUser findById(Integer id) {
        return sysUserDao.findById(id);
    }

    @Override
    public Map<String, Object> update(SysUser sysUser) {
        map = new HashMap<>();

        //根据主键id查询员工信息
        VoFindByIdUser byId = sysUserDao.findById(sysUser.getId());

        //判断手机号是否有修改
        if (!byId.getTel().equals(sysUser.getTel())){
            //查询电话是否已存在
            SysUser byTel = sysUserDao.findByTel(sysUser.getTel());
            if (byTel != null){
                map.put("message","手机号已存在");
                map.put("status",false);
                return map;
            }
        }

        //判断身份证是否有修改
        if (!byId.getIdCard().equals(sysUser.getIdCard())){
            //查询身份证是否已存在
            SysUser byIdCard = sysUserDao.findByIdCard(sysUser.getTel());
            if (byIdCard != null){
                map.put("message","身份证号已存在");
                map.put("status",false);
                return map;
            }
        }

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser2 = (SysUser) subject.getPrincipal();

        //填入修改人
        sysUser.setModifyId(sysUser2.getId());
        //填入修改时间
        sysUser.setModifyDate(new Date());
        //填入组织ID 全路径
        String idPath = findOrganizationIdPath(sysUser.getOrganizationId());
        sysUser.setOrganizationIdPath(idPath);
        //填入用户名（与手机号一致）
        sysUser.setUserName(sysUser.getTel());

        //修改员工信息
        int update = sysUserDao.update(sysUser);
        if (update >0 ){
            map.put("message","修改员工成功");
            map.put("status",true);
        }else {
            map.put("message","修改员工失败");
            map.put("status",false);
        }


        return map;
    }

    @Override
    public Map<String, Object> falseDelete(Integer id) {
        map = new HashMap<>();
        //假删除员工信息
        int update = sysUserDao.falseDelete(id);
        if (update >0){
            map.put("message","删除员工成功");
            map.put("status",true);
        }else {
            map.put("message","删除员工失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> disableLogins(Integer id) {
        map = new HashMap<>();

        //根据用户主键id查询用户状态
        Integer status = sysUserDao.findStatusById(id);
        if (status == 2 || status == 4){
            map.put("message","当前已禁止登录");
            map.put("status",false);
            return map;
        }

        int update = sysUserDao.disableLogins(id);
        if (update > 0){
            map.put("message","禁止登录成功");
            map.put("status",true);
        }else {
            map.put("message","禁止登录失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> allowLogins(Integer id) {
        map = new HashMap<>();

        //根据用户主键id查询用户状态
        Integer status = sysUserDao.findStatusById(id);
        if (status == 1 || status == 3){
            map.put("message","当前已允许登录");
            map.put("status",false);
            return map;
        }

        int update = sysUserDao.allowLogins(id);
        if (update > 0){
            map.put("message","允许登录成功");
            map.put("status",true);
        }else {
            map.put("message","允许登录失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> stop(Integer id) {
        map = new HashMap<>();

        //根据用户主键id查询用户状态
        Integer status = sysUserDao.findStatusById(id);
        if (status == 3 || status == 4){
            map.put("message","当前已停用");
            map.put("status",false);
            return map;
        }

        int update = sysUserDao.stop(id);
        if (update > 0){
            map.put("message","停用成功");
            map.put("status",true);
        }else {
            map.put("message","停用失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> recovery(Integer id) {
        map = new HashMap<>();

        //根据用户主键id查询用户状态
        Integer status = sysUserDao.findStatusById(id);
        if (status == 1 || status == 2){
            map.put("message","当前已恢复");
            map.put("status",false);
            return map;
        }

        int update = sysUserDao.recovery(id);
        if (update > 0){
            map.put("message","恢复成功");
            map.put("status",true);
        }else {
            map.put("message","恢复失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> resetPWD(SysUser sysUser) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser2 = (SysUser) subject.getPrincipal();

        //填入修改人
        sysUser.setModifyId(sysUser2.getId());
        //填入修改时间
        sysUser.setModifyDate(new Date());
        int update = sysUserDao.resetPWD(sysUser);
        if (update > 0){
            map.put("message","重置密码成功");
            map.put("status",true);
        }else {
            map.put("message","重置密码失败");
            map.put("status",false);
        }
        return map;
    }

    //查询组织ID  全路径 用':'分割
    private String findOrganizationIdPath(Integer organizationId) {
        String idPath = "";
        if (organizationId != 0){
            //根据组织主键id 查询上级id
            int parentId = sysOrganizationDao.findParentIdById(organizationId);
            //递归查询
            String organizationIdPath = findOrganizationIdPath(parentId);
            //拼接上级组织主键id
            idPath += organizationIdPath;
        }
        //拼接组织id（传进来的组织主键id 最后拼接）
        idPath += organizationId+":";
        return idPath;
    }
}
