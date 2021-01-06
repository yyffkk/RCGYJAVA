package com.api.manage.service.businessManagement.impl;

import com.api.manage.dao.businessManagement.SysOrganizationDao;
import com.api.model.businessManagement.SysOrganization;
import com.api.manage.service.businessManagement.SysOrganizationService;
import com.api.model.businessManagement.SysUser;
import com.api.vo.businessManagement.VoFindByIdOrganization;
import com.api.vo.businessManagement.VoOrganization;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 组织service实现
 */
@Service
public class SysOrganizationServiceImpl implements SysOrganizationService {
    private static Map<String,Object> map = null;
    @Resource
    SysOrganizationDao sysOrganizationDao;

    @Override
    public VoFindByIdOrganization findById(Integer id) {
        return sysOrganizationDao.findById(id);
    }

    @Override
    public List<VoOrganization> list() {
        //递归查询下级，最高级为0
        List<VoOrganization> list = findList(0);
        return list;
    }

    @Override
    public Map<String, Object> insert(SysOrganization sysOrganization) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //传入状态,初始为 1.正常
        sysOrganization.setStatus(1);
        //填入创建人
        sysOrganization.setCreateId(sysUser.getId());
        //填入创建日期
        sysOrganization.setCreateDate(new Date());
        int insert = sysOrganizationDao.insert(sysOrganization);
        if (insert > 0){
            map.put("message","添加部门成功");
            map.put("status",true);
        }else {
            map.put("message","添加部门失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> update(SysOrganization sysOrganization) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入创建人
        sysOrganization.setModifyId(sysUser.getId());
        //填入创建日期
        sysOrganization.setModifyDate(new Date());
        int update = sysOrganizationDao.update(sysOrganization);
        if (update > 0){
            map.put("message","修改部门成功");
            map.put("status",true);
        }else {
            map.put("message","修改部门失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> delete(Integer id) {
        map = new HashMap<>();
        //先查询该部门是否有人存在
        int i = sysOrganizationDao.countNum(id);
        if (i > 0){
            map.put("message","请先转移内部人员，再删除");
            map.put("status",false);
            return map;
        }

        //删除没有人员存在的部门
        int delete = sysOrganizationDao.delete(id);
        if (delete >0){
            map.put("message","删除组织成功");
            map.put("status",true);
        }else {
            map.put("message","删除组织失败");
            map.put("status",false);
        }

        return map;
    }

    @Override
    public Map<String, Object> stop(Integer id) {
        map = new HashMap<>();
        int update = sysOrganizationDao.stop(id);
        if (update > 0){
            map.put("message","停用组织成功");
            map.put("status",true);
        }else {
            map.put("message","停用组织失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> recovery(Integer id) {
        map = new HashMap<>();
        int update = sysOrganizationDao.recovery(id);
        if (update > 0){
            map.put("message","恢复组织成功");
            map.put("status",true);
        }else {
            map.put("message","恢复组织失败");
            map.put("status",false);
        }
        return map;
    }

    private List<VoOrganization> findList(Integer parentId) {
        List<VoOrganization> list = sysOrganizationDao.list(parentId);
        if (list != null && list.size()>0){
            for (VoOrganization voOrganization : list) {
                //查询各组织，各部门人数,并填入
                int count = sysOrganizationDao.countNum(voOrganization.getId());
                voOrganization.setCountNum(count);
                //递归查询下级，并填入集合中
                List<VoOrganization> list2 = findList(voOrganization.getId());
                voOrganization.setOrganizationList(list2);
            }
        }
        return list;
    }
}
