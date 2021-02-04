package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerArticleOutSearch;
import com.api.vo.butlerApp.ButlerArticleOutVo;

import java.util.List;
import java.util.Map;

public interface ButlerArticleOutService {
    List<ButlerArticleOutVo> list(ButlerArticleOutSearch articleOutSearch);

    Map<String, Object> findById(Integer articleOutId, String roleId);
}
