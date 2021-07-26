package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SearchAttendanceTeam;
import com.api.model.operationManagement.SysAttendanceTeam;
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
}
