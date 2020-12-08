package com.api.service.butlerService;

import com.api.model.butlerService.SearchUserArticleOut;
import com.api.vo.butlerService.VoUserArticleOut;

import java.util.List;
import java.util.Map;

public interface UserArticleOutService {
    List<VoUserArticleOut> list(SearchUserArticleOut searchUserArticleOut);

    Map<String, Object> delete(int[] ids);

    Map<String, Object> applicationRejection(Integer id);

    Map<String,Object> countArticleOutNow();

    Map<String, Object> countPerformed();
}
