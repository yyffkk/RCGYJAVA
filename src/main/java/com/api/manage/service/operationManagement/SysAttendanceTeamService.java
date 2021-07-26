package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SearchAttendanceTeam;
import com.api.model.operationManagement.SysAttendanceTeam;
import com.api.vo.operationManagement.VoAttendanceTeam;

import java.util.List;
import java.util.Map;

public interface SysAttendanceTeamService {
    List<VoAttendanceTeam> list(SearchAttendanceTeam searchAttendanceTeam);

    Map<String, Object> insert(SysAttendanceTeam sysAttendanceTeam);

    Map<String, Object> update(SysAttendanceTeam sysAttendanceTeam);
}
