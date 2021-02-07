package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.*;
import com.api.vo.butlerApp.ButlerArticleDetailVo;
import com.api.vo.butlerApp.ButlerArticleVo;
import com.api.vo.butlerApp.ButlerTypeAndBorrowListVo;

import java.util.List;
import java.util.Map;


public interface ButlerBorrowService {
    ButlerTypeAndBorrowListVo list(ButlerBorrowSearch butlerBorrowSearch);

    Map<String, Object> checkItems(Integer articleBorrowId, String roleId);

    Map<String, Object> submitCheck(ButlerSubmitCheck butlerSubmitCheck, String roleId);

    List<ButlerArticleVo> articleList();

    Map<String, Object> insertArticle(ButlerArticle butlerArticle, String roleId);

    List<ButlerArticleDetailVo> articleDetailList(Integer articleId);

    Map<String, Object> findById(Integer articleDetailId);

    Map<String, Object> updateArticleDetail(ButlerArticleDetail butlerArticleDetail, String roleId);

    Map<String, Object> remind(ButlerBorrowRemind butlerBorrowRemind, Integer id, String roleId);
}
