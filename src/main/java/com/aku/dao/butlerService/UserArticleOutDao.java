package com.aku.dao.butlerService;

import com.aku.model.butlerService.SearchUserArticleOut;
import com.aku.vo.butlerService.VoUserArticleOut;

import java.util.List;

public interface UserArticleOutDao {
    List<VoUserArticleOut> list(SearchUserArticleOut searchUserArticleOut);
}
