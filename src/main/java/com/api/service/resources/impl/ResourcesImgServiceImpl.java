package com.api.service.resources.impl;

import com.api.dao.resources.ResourcesImgDao;
import com.api.model.resources.ResourcesImg;
import com.api.service.resources.ResourcesImgService;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResourcesImgServiceImpl implements ResourcesImgService {
    @Resource
    ResourcesImgDao resourcesImgDao;

    @Override
    public List<VoResourcesImg> findImgByDate(ResourcesImg resourcesImg) {
        return resourcesImgDao.findImgByDate(resourcesImg);
    }
}
