package com.aku.dao.resources;

import com.aku.model.resources.ResourcesImg;
import com.aku.vo.resources.VoResourcesImg;

import java.util.List;

public interface ResourcesImgDao {
    List<VoResourcesImg> findGoodsImgByDateId(ResourcesImg resourcesImg);
}
