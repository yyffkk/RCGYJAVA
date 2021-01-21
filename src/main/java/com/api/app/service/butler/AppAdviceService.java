package com.api.app.service.butler;

import com.api.model.app.SearchAppAdvice;
import com.api.model.app.UserIdAndAdviceId;
import com.api.model.butlerService.SysAdvice;
import com.api.vo.app.AppAdviceVo;

import java.util.List;
import java.util.Map;

public interface AppAdviceService {
    List<AppAdviceVo> list(SearchAppAdvice searchAppAdvice);

    Map<String, Object> insert(SysAdvice sysAdvice);

    Map<String, Object> findAdviceDetailByAdviceId(UserIdAndAdviceId userIdAndAdviceId);
}
