package com.api.butlerApp.service.butler;

import com.api.model.butlerApp.ButlerInterviewSearch;
import com.api.model.operationManagement.Interview;
import com.api.vo.butlerApp.ButlerInterviewVo;

import java.util.List;
import java.util.Map;

public interface ButlerInterviewService {
    List<ButlerInterviewVo> list(ButlerInterviewSearch butlerInterviewSearch);

    Map<String, Object> feedBack(Interview interview, Integer id);
}
