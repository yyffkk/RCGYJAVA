package com.aku.service.butlerService;

import com.aku.model.butlerService.SearchUserArticleOut;
import com.aku.vo.butlerService.VoUserArticleOut;

import java.util.List;

public interface UserArticleOutService {
    List<VoUserArticleOut> list(SearchUserArticleOut searchUserArticleOut);
}
