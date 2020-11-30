package com.aku.service.resources;

import com.aku.model.resources.ResourcesImg;
import com.aku.vo.resources.VoResourcesImg;

import java.util.List;

public interface ResourcesImgService {
    List<VoResourcesImg> findGoodsImgByDateId(ResourcesImg resourcesImg);
}
