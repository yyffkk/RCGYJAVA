package com.api.manage.service.resources;

import com.api.model.resources.ResourcesImg;
import com.api.vo.resources.VoResourcesImg;

import java.util.List;

public interface ResourcesImgService {
    List<VoResourcesImg> findImgByDate(ResourcesImg resourcesImg);
}
