package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.PushRelieveAlert;
import com.api.vo.operationManagement.VoButlerOneButtonAlarm;
import com.api.vo.operationManagement.VoFireAlarm;
import com.api.vo.operationManagement.VoOneButtonAlarm;
import com.api.vo.operationManagement.VoPlanAlarm;

import java.util.List;

public interface SysAlarmDao {
    /**
     * 查询所有的火灾报警记录
     * @return 火灾报警记录
     */
    List<VoFireAlarm> fireAlarmList();

    /**
     * 查询业主端的一键报警记录
     * @return 一键报警记录
     */
    List<VoOneButtonAlarm> oneButtonAlarmList();

    /**
     * 查询管家端的一键报警记录
     * @return 管家端的一键报警记录
     */
    List<VoButlerOneButtonAlarm> butlerOneButtonAlarmList();

    /**
     * 查询预案的报警记录
     * @return map
     */
    List<VoPlanAlarm> planAlarmList();

    /**
     * 根据预案主键id修改预案状态
     * @param pushRelieveAlert 推送灾情解除通知model
     * @return 影响行数
     */
    int updatePlanAlarmStatusById(PushRelieveAlert pushRelieveAlert);
}
