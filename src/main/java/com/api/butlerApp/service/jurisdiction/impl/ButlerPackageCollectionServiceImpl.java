package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerPackageCollectionDao;
import com.api.butlerApp.service.jurisdiction.ButlerPackageCollectionService;
import com.api.vo.operationManagement.VoPackageCollection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ButlerPackageCollectionServiceImpl implements ButlerPackageCollectionService {
    @Resource
    ButlerPackageCollectionDao butlerPackageCollectionDao;

    @Override
    public List<VoPackageCollection> list(Integer collectionStatus) {
        return butlerPackageCollectionDao.list(collectionStatus);
    }
}
