package com.api.butlerApp.service.butler;

import com.api.model.butlerApp.ButlerInterviewSearch;
import com.api.vo.butlerApp.ButlerInterviewVo;

import java.util.List;

public interface ButlerInterviewService {
    List<ButlerInterviewVo> list(ButlerInterviewSearch butlerInterviewSearch);
}
