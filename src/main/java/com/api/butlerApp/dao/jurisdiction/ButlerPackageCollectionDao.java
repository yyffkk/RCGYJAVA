package com.api.butlerApp.dao.jurisdiction;

import com.api.vo.operationManagement.VoPackageCollection;

import java.util.List;

public interface ButlerPackageCollectionDao {
    /**
     * 查询所有的包裹代收信息
     * @param collectionStatus 代收状态，1.未领取，2.已领取
     * @return 包裹代收信息
     */
    List<VoPackageCollection> list(Integer collectionStatus);
}
