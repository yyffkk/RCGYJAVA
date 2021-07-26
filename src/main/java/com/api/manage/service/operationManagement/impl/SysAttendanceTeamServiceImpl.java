package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysAttendanceTeamDao;
import com.api.manage.service.operationManagement.SysAttendanceTeamService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.SearchAttendanceTeam;
import com.api.model.operationManagement.SysAttendanceTeam;
import com.api.vo.operationManagement.VoAttendanceTeam;
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
public class SysAttendanceTeamServiceImpl implements SysAttendanceTeamService {
    private static Map<String,Object> map = null;
    @Resource
    SysAttendanceTeamDao sysAttendanceTeamDao;

    @Override
    public List<VoAttendanceTeam> list(SearchAttendanceTeam searchAttendanceTeam) {
        List<VoAttendanceTeam> list = sysAttendanceTeamDao.list(searchAttendanceTeam);
        if (list != null && list.size()>0){
            for (VoAttendanceTeam voAttendanceTeam : list) {
                //初始化小组成员名称
                String teamMembers = "";

                //将小组成员id 字符串转数组【逗号分隔】
                String[] split = voAttendanceTeam.getTeamMembers().split(",");
                for (int i = 0; i < split.length; i++) {
                    //根据小组成员主键id查询小组成员名称
                    String name = sysAttendanceTeamDao.findUserNameById(split[i]);
                    if (i == 0){
                        teamMembers = teamMembers + name;
                    }else {
                        teamMembers = teamMembers + "," + name;
                    }
                }

                //传出小组成员名称
                voAttendanceTeam.setTeamMembersName(teamMembers);
            }
        }
        return list;
    }

    @Override
    public Map<String, Object> insert(SysAttendanceTeam sysAttendanceTeam) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysAttendanceTeam.setCreateId(sysUser.getId());
        sysAttendanceTeam.setCreateDate(new Date());

        int insert = sysAttendanceTeamDao.insert(sysAttendanceTeam);
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
    public Map<String, Object> update(SysAttendanceTeam sysAttendanceTeam) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysAttendanceTeam.setModifyId(sysUser.getId());
        sysAttendanceTeam.setModifyDate(new Date());

        int insert = sysAttendanceTeamDao.update(sysAttendanceTeam);
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
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();

        try {
            for (int id : ids) {
                int delete = sysAttendanceTeamDao.delete(id);
                if (delete <= 0){
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
