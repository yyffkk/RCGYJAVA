package com.api.app.dao.my;

import com.api.model.basicArchives.UserResident;
import com.api.vo.my.MyHouseVo;

import java.util.List;

public interface MyHouseDao {
    /**
     * 查询所有的房屋审核信息
     * @param id 用户主键id
     * @return 我的房屋Vo list 回显
     */
    List<MyHouseVo> list(Integer id);

    /**
     * 根据用户主键id 改变当前用户的住户类型,名称，证件类型，证件号码
     * @param userResident 住户信息表
     * @return 影响行数
     */
    int updateBaseInfoById(UserResident userResident);

    /**
     * 根据用户主键id 查询该用户的未审核记录数量
     * @param residentId 用户主键Id
     * @return 未审核记录数量
     */
    int countNotReviewed(Integer residentId);

    /**
     * 假删除审核信息
     * @param id 审核主键id
     * @return 影响行数
     */
    int falseDelete(int id);
}
