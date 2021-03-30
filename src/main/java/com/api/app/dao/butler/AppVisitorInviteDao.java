package com.api.app.dao.butler;

import com.api.model.app.AppUserVisitorsInvite;
import com.api.model.app.AppUserVisitorsInviteSubmit;
import com.api.model.app.AppUserVisitorsUrl;

import java.util.Date;

public interface AppVisitorInviteDao {
    /**
     * 添加新版访客信息
     * @param visitorsInvite app 访客邀请填写信息 model
     * @return 影响行数
     */
    int insertUserVisitorsNew(AppUserVisitorsInvite visitorsInvite);

    /**
     * 添加分享连接信息
     * @param visitorsUrl app 分享连接信息
     * @return 影响行数
     */
    int insertUserVisitorsUrl(AppUserVisitorsUrl visitorsUrl);

    /**
     * 查询分享连接的有效截止时间
     * @param code 分享连接编号
     * @return 有效截止时间
     */
    Date findEffectiveDateByCode(String code);

    /**
     * 根据分享连接编号查询访客信息
     * @param code 分享连接编号
     * @return 访客信息
     */
    AppUserVisitorsInvite findByUrlCode(String code);

    /**
     * 修改新版访客信息
     * @param visitorsInviteSubmit 访客邀请提交信息(H5提交model)
     * @return 影响行数
     */
    int updateUserVisitorsNew(AppUserVisitorsInviteSubmit visitorsInviteSubmit);

    /**
     * 根据分享连接编号查询新版访客邀请主键id
     * @param code 分享连接编号
     * @return 新版访客邀请主键id
     */
    Integer findVisitIdByCode(String code);

    /**
     * 根据分享连接编号查询该连接是否已被使用
     * @param code 分享连接编号
     * @return 该连接是否已被使用
     */
    int findIsUseByCode(String code);

    /**
     * 根据分享连接编号将该连接修改为1.已使用
     * @param code 分享连接编号
     * @return 影响行数
     */
    int updateIsUseByCode(String code);
}
