package com.api.butlerApp.service.jurisdiction;

import com.api.vo.operationManagement.VoPackageCollection;

import java.util.List;

public interface ButlerPackageCollectionService {
    List<VoPackageCollection> list(Integer collectionStatus);
}
