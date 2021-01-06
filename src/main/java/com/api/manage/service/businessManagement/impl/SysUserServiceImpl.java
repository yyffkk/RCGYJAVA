package com.api.manage.service.businessManagement.impl;

import com.api.manage.dao.businessManagement.SysOrganizationDao;
import com.api.manage.dao.businessManagement.SysUserDao;
import com.api.manage.service.businessManagement.SysUserService;
import com.api.model.businessManagement.SearchUser;
import com.api.model.businessManagement.SysUser;
import com.api.vo.businessManagement.VoFindByIdUser;
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

    @Override
    public List<VoUser> list(SearchUser searchUser) {
        return sysUserDao.list(searchUser);
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
        return null;
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
