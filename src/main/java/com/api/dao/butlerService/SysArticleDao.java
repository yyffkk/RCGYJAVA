package com.api.dao.butlerService;

import com.api.model.butlerService.Article;
import com.api.model.butlerService.ArticleDetail;
import com.api.model.butlerService.SearchArticle;
import com.api.model.butlerService.SearchArticleDetail;
import com.api.model.resources.ResourcesImg;
import com.api.vo.butlerService.VoArticle;
import com.api.vo.butlerService.VoArticleDetail;
import com.api.vo.butlerService.VoFindByIdArticle;
import com.api.vo.butlerService.VoFindByIdArticleDetail;

import java.util.List;

public interface SysArticleDao {
    /**
     * 查询所有的物品管理信息 （包含条件搜索）[全部]
     * @param searchArticle 搜索条件
     * @return 物品管理信息集合
     */
    List<VoArticle> list(SearchArticle searchArticle);

    /**
     * 查询所有的物品明细管理信息 （包含条件搜索）[1.正常，2.破损]
     * @param searchArticleDetail 搜索条件
     * @return 物品明细管理信息集合
     */
    List<VoArticleDetail> listDetail(SearchArticleDetail searchArticleDetail);

    /**
     * 添加物品信息
     * @param article 物品信息
     * @return 影响行数
     */
    int insert(Article article);

    /**
     * 添加物品明细信息
     * @param articleDetail 物品信明细息
     * @return 影响行数
     */
    int insertDetail(ArticleDetail articleDetail);

    /**
     * 根据物品主键id查询物品信息
     * @param id 物品主键id
     * @return 物品信息
     */
    VoFindByIdArticle findById(Integer id);

    /**
     * 根据物品主键id查询物品明细信息
     * @param id 物品主键id
     * @return 物品明细信息
     */
    List<VoFindByIdArticleDetail> findDetailById(Integer id);

    /**
     * 更新物品信息
     * @param article 新物品信息
     * @return 影响行数
     */
    int update(Article article);

    /**
     * 根据物品主键id删除物品明细信息
     * @param id 物品主键id
     * @return 影响行数
     */
    int deleteDetail(Integer id);
}
