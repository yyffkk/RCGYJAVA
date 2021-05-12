package com.api.app.dao.butler;

import com.api.model.app.SearchAppPackageCollection;
import com.api.vo.app.AppConfirmCollection;
import com.api.vo.operationManagement.VoPackageCollection;

import java.util.List;

public interface AppPackageCollectionDao {
    /**
     * 查询所有的快递包裹（包含条件搜索）
     * @param searchAppPackageCollection 搜索条件
     * @return 快递包裹
     */
    List<VoPackageCollection> list(SearchAppPackageCollection searchAppPackageCollection);

    /**
     * 根据包裹主键ID查询收件人手机号
     * @param packageCollectionId 包裹主键ID
     * @return 收件人手机号
     */
    String findAddresseeTelByPackageId(Integer packageCollectionId);


    /**
     * 确认领取包裹
     * @param appConfirmCollection app 包裹代收确认领取 条件
     * @return 影响行数
     */
    int confirmCollection(AppConfirmCollection appConfirmCollection);
}
