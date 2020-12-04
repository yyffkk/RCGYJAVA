package com.aku.service.resources.impl;

import com.aku.dao.resources.ResourcesImgDao;
import com.aku.model.resources.ResourcesImg;
import com.aku.service.resources.ResourcesImgService;
import com.aku.vo.resources.VoResourcesImg;
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
