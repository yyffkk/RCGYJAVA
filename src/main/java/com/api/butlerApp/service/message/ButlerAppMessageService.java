package com.api.butlerApp.service.message;

import com.api.vo.butlerApp.ButlerCommentMessageVo;
import com.api.vo.butlerApp.ButlerSysMessageVo;

import java.util.List;
import java.util.Map;

public interface ButlerAppMessageService {
    Map<String, Object> messageCenter(Integer id);

    List<ButlerSysMessageVo> sysMessageList(Integer id);

    List<ButlerCommentMessageVo> sysCommentMessageList(Integer id);

    Map<String, Object> findRepairByRepairId(Integer repairId);

    Map<String, Object> findCommentByDispatchId(Integer dispatchId);
}
