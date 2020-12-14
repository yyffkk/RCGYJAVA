package com.api.service.butlerService;

import com.api.model.butlerService.Article;
import com.api.model.butlerService.SearchArticle;
import com.api.model.butlerService.SearchArticleDetail;
import com.api.vo.butlerService.VoArticle;
import com.api.vo.butlerService.VoArticleDetail;
import com.api.vo.butlerService.VoFindByIdArticle;
import com.api.vo.resources.VoResourcesImg;

import java.util.List;
import java.util.Map;

public interface SysArticleService {
    List<VoArticle> list(SearchArticle searchArticle);

    List<VoResourcesImg> findImgById(Integer id);

    List<VoArticleDetail> listDetail(SearchArticleDetail searchArticleDetail);

    Map<String, Object> insert(Article article);

    VoFindByIdArticle findById(Integer id);

    Map<String, Object> update(Article article);
}
