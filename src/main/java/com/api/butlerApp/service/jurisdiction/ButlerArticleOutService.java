package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerArticleOutNoRelease;
import com.api.model.butlerApp.ButlerArticleOutRelease;
import com.api.model.butlerApp.ButlerArticleOutSearch;
import com.api.vo.butlerApp.ButlerArticleOutVo;

import java.util.List;
import java.util.Map;

public interface ButlerArticleOutService {
    List<ButlerArticleOutVo> list(ButlerArticleOutSearch articleOutSearch);

    Map<String, Object> findById(Integer articleOutId, String roleId);

    Map<String, Object> release(ButlerArticleOutRelease articleOutRelease, Integer id, String roleId);

    Map<String, Object> noRelease(ButlerArticleOutNoRelease articleOutNoRelease, Integer id, String roleId);
}
