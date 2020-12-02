package com.aku.dao.butlerService;

import com.aku.model.butlerService.SearchUserArticleOut;
import com.aku.model.butlerService.UserArticleOut;
import com.aku.vo.butlerService.VoUserArticleOut;

import java.util.List;
import java.util.Map;

public interface UserArticleOutDao {
    List<VoUserArticleOut> list(SearchUserArticleOut searchUserArticleOut);

    int delete(int id);

    int applicationRejection(UserArticleOut userArticleOut);
}
