package com.aku.service.butlerService;

import com.aku.model.butlerService.SearchUserArticleOut;
import com.aku.vo.butlerService.VoUserArticleOut;

import java.util.List;
import java.util.Map;

public interface UserArticleOutService {
    List<VoUserArticleOut> list(SearchUserArticleOut searchUserArticleOut);

    Map<String, Object> delete(int[] ids);

    Map<String, Object> applicationRejection(Integer id);

    Map<String,Object> countArticleOutNow();

    Map<String, Object> countPerformed();
}
