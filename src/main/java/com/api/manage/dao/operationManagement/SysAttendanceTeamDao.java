package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SearchAttendanceTeam;
import com.api.model.operationManagement.SysAttendanceTeam;
import com.api.vo.operationManagement.SysAttendancePeople;
import com.api.vo.operationManagement.VoAttendanceTeam;

import java.util.List;

public interface SysAttendanceTeamDao {
    /**
     * 查询所有的考勤小组信息(包含条件搜索)
     * @param searchAttendanceTeam 考勤小组管理 搜索条件
     * @return map
     */
    List<VoAttendanceTeam> list(SearchAttendanceTeam searchAttendanceTeam);

    /**
     * 添加考勤小组
     * @param sysAttendanceTeam 考勤小组管理model
     * @return 影响行数
     */
    int insert(SysAttendanceTeam sysAttendanceTeam);

    /**
     * 根据小组成员主键id查询小组成员名称
     * @param s 小组成员主键id
     * @return 小组成员名称
     */
    String findUserNameById(String s);

    /**
     * 修改考勤小组
     * @param sysAttendanceTeam 考勤小组管理model
     * @return 影响行数
     */
    int update(SysAttendanceTeam sysAttendanceTeam);

    /**
     * 根据考勤小组主键id删除考勤小组信息
     * @param id 考勤小组主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 根据考勤小组主键id查询考勤小组信息
     * @param teamId 考勤小组主键id
     * @return 考勤小组信息
     */
    SysAttendanceTeam findById(Integer teamId);

    /**
     * 根据考勤人员主键id查询是否存在开启的排班计划
     * @param s 考勤人员主键id
     * @return 存在数量
     */
    int countPlanByUserId(String s);

    /**
     * 根据小组主键id查询小组成员
     * @param teamMembers 小组成员
     * @return 小组成员信息集合
     */
    List<SysAttendancePeople> findPeopleById(String teamMembers);
}
