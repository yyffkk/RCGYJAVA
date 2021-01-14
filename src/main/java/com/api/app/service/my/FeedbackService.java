package com.api.app.service.my;

import com.api.model.butlerService.SysAdvice;

import java.util.Map;

public interface FeedbackService {
    Map<String, Object> submit(SysAdvice sysAdvice);
}
