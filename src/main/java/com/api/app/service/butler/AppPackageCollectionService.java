package com.api.app.service.butler;

import com.api.model.app.SearchAppPackageCollection;
import com.api.vo.app.AppConfirmCollection;
import com.api.vo.operationManagement.VoPackageCollection;

import java.util.List;
import java.util.Map;

public interface AppPackageCollectionService {
    List<VoPackageCollection> list(SearchAppPackageCollection searchAppPackageCollection);

    Map<String, Object> confirmCollection(AppConfirmCollection appConfirmCollection);
}
