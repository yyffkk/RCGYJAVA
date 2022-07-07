package com.api.app.dao.butler;

import com.api.model.app.AppActivityRegistration;
import com.api.vo.app.AppActivityDetailVo;
import com.api.vo.app.AppActivityRegistrationVo;
import com.api.vo.app.AppActivityVo;

import java.util.List;

public interface AppActivityDao {
    /**
     * 查询所有的活动信息
     * @return 活动信息集合
     */
    List<AppActivityVo> list();

    /**
     * 查询用户是否有报名信息
     * @param appActivityRegistration app社区活动报名人信息
     * @return app社区活动报名人信息集合
     */
    List<AppActivityRegistration> findRegistrationByIds(AppActivityRegistration appActivityRegistration);

    /**
     * 根据社区活动主键id查询相关报名人信息
     * @param activityId 社区活动主键id
     * @return 相关报名人信息id数组
     */
    List<Integer> findResidentIdById(Integer activityId);

    /**
     * 根据社区活动主键id查询社区活动详情
     * @param activityId 社区活动主键id
     * @return 社区活动详情
     */
    AppActivityDetailVo findById(Integer activityId);

    /**
     * 查询报名人数
     * @param activityId 社区活动主键id
     * @return 报名人数
     */
    int countRegistrationNum(Integer activityId);

    /**
     * 添加活动报名管理信息
     * @param appActivityRegistration app社区活动报名人信息
     * @return 影响行数
     */
    int insertRegistration(AppActivityRegistration appActivityRegistration);

    /**
     * 查看参与人数
     * @param activityId 活动id
     * @return 参与人数集合
     */
    List<AppActivityRegistrationVo> participantsList(Integer activityId);
}
