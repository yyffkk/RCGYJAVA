package com.api.app.service.butler;

import com.api.model.app.SearchAppAdvice;
import com.api.vo.app.AppAdviceVo;

import java.util.List;

public interface AppAdviceService {
    List<AppAdviceVo> list(SearchAppAdvice searchAppAdvice);
}
