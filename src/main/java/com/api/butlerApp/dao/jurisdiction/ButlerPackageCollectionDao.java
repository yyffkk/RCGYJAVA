package com.api.butlerApp.dao.jurisdiction;

import com.api.vo.operationManagement.VoFBIPackageCollection;
import com.api.vo.operationManagement.VoPackageCollection;

import java.util.List;

public interface ButlerPackageCollectionDao {
    /**
     * 查询所有的包裹代收信息
     * @param collectionStatus 代收状态，1.未领取，2.已领取
     * @return 包裹代收信息
     */
    List<VoPackageCollection> list(Integer collectionStatus);

    /**
     * 根据包裹代收主键id查询 包裹代收信息
     * @param packageCollectionId 包裹代收主键id
     * @return 包裹代收信息
     */
    VoFBIPackageCollection findById(Integer packageCollectionId);

    /**
     * 根据收件人手机号查询收件人主键id
     * @param addresseeTel 收件人手机号
     * @return 收件人主键id
     */
    Integer findResidentIdByTel(String addresseeTel);
}
