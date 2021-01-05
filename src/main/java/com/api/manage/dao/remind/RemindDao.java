package com.api.manage.dao.remind;

import com.api.model.remind.SysMessage;
import com.api.model.remind.SysSending;

/**
 * 提醒发送Dao层
 */
public interface RemindDao {
    /**
     * 添加提醒 消息列表 并返回主键id
     * @param sysMessage 消息列表信息
     * @return 影响行数
     */
    int insertMessage(SysMessage sysMessage);

    /**
     * 添加消息接收列表
     * @param sysSending 消息接收列表信息
     * @return 影响行数
     */
    int insertSending(SysSending sysSending);
}
