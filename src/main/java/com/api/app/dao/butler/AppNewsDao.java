package com.api.app.dao.butler;

import com.api.model.app.SearchAppNews;
import com.api.vo.app.AppNewsRotationVo;
import com.api.vo.app.AppNewsVo;
import com.api.vo.app.AppNewsVoFBI;
import com.api.vo.app.IdAndName;

import java.util.List;

public interface AppNewsDao {
    /**
     * 查询所有的资讯分类(【全部】是app页面默认显示的值)
     * @return 资讯信息
     */
    List<IdAndName> findAllCategory();

    /**
     * 根据资讯分类主键id查询资讯信息
     * @param searchAppNews app 公共资讯 搜素条件
     * @return 资讯信息
     */
    List<AppNewsVo> newsList(SearchAppNews searchAppNews);

    /**
     * 根据资讯主键id 查询资讯信息详情
     * @param newsId 资讯主键id
     * @return 资讯信息详情
     */
    AppNewsVoFBI findNewsByNewsId(Integer newsId);

    /**
     * 查询资讯轮播图信息
     * @return
     */
    List<AppNewsRotationVo> findNewsRotation();
}
