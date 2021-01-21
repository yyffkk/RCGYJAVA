package com.api.app.dao.butler;

import com.api.model.app.SearchAppAdvice;
import com.api.vo.app.AppAdviceVo;

import java.util.List;

public interface AppAdviceDao {
    List<AppAdviceVo> list(SearchAppAdvice searchAppAdvice);
}
