package com.api.butlerApp.service.jurisdiction;

import com.api.vo.operationManagement.VoPackageCollection;

import java.util.List;
import java.util.Map;

public interface ButlerPackageCollectionService {
    List<VoPackageCollection> list(Integer collectionStatus);

    Map<String, Object> remind(Integer packageCollectionId, Integer id);

}
