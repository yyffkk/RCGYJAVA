package com.api.app.service.butler;

import com.api.model.app.SearchAppNews;
import com.api.vo.app.AppNewsVo;

import java.util.List;
import java.util.Map;

public interface AppNewsService {
    Map<String, Object> categoryList();

    List<AppNewsVo> newsList(SearchAppNews searchAppNews);

    Map<String, Object> findNewsByNewsId(Integer newsId);

    Map<String, Object> findNewsRotation();

    List<AppNewsVo> findHotNews();

    Map<String, Object> addViews(Integer newsId);
}
