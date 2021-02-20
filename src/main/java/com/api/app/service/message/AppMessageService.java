package com.api.app.service.message;

import com.api.vo.app.AppCommentMessageVo;
import com.api.vo.app.AppSysMessageVo;

import java.util.List;
import java.util.Map;

public interface AppMessageService {
    Map<String, Object> messageCenter(Integer id);

    List<AppSysMessageVo> sysMessageList(Integer id);

    List<AppCommentMessageVo> sysCommentMessageList(Integer id);

    Map<String, Object> sysMessageDetail(Integer sysMessageId, Integer id);

    Map<String, Object> readMessage(Integer sysMessageId, Integer id);

    Map<String, Object> allRead(Integer id);

    Map<String, Object> falseDelete(int[] ids, Integer id);

}
