package com.api.manage.service.resources.impl;

import com.api.manage.dao.resources.ResourcesImgDao;
import com.api.model.resources.ResourcesImg;
import com.api.manage.service.resources.ResourcesImgService;
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
