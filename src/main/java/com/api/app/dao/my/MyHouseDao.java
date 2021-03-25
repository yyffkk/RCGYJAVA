package com.api.app.dao.my;

import com.api.model.basicArchives.ResidentIdAndEstateId;
import com.api.model.basicArchives.UserResident;
import com.api.vo.my.MyHouseEstateInfoVo;
import com.api.vo.my.MyHouseFBIVo;
import com.api.vo.my.MyHouseResidentInfoVo;
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

    /**
     * 再次认证回显数据,根据房产审核表主键id查询房产审核信息
     * @param estateExamineId 房产审核表主键id
     * @return 房产审核信息
     */
    MyHouseFBIVo findById(Integer estateExamineId);

    /**
     * 根据房产审核表主键id查询审核状态
     * @param id 房产审核表主键id
     * @return 审核状态
     */
    int findStatusById(int id);

    /**
     * 根据房产审核表主键id查询住户id
     * @param id 房产审核表主键id
     * @return 住户id
     */
    int findResidentIdById(int id);

    /**
     * 根据房产审核表主键id查询审核房产id
     * @param id 房产审核表主键id
     * @return 审核房产id
     */
    int findEstateIdById(int id);

    /**
     * 根据住户id查询app当前选中的房产id
     * @param residentId 住户id
     * @return app当前选中的房产id
     */
    Integer findNowEstateIdByResidentId(Integer residentId);

    /**
     * 根据用户主键id查询数据库存在的关联的房房产id
     * @param residentId 用户主键id
     * @return 数据库存在的关联的房房产id集合
     */
    List<Integer> findDBEstaIdByResidentId(Integer residentId);

    /**
     * 根据用户主键id和房产id查询房产信息
     * @param residentIdAndEstateId 用户主键id和房产id
     * @return 房产信息
     */
    MyHouseEstateInfoVo findEstateInfoByResidentId(ResidentIdAndEstateId residentIdAndEstateId);

    /**
     * 根据用户主键id查询审核成功并且没有删除的房产id集合
     * @param residentId 用户主键id
     * @return 审核成功并且没有删除的房产id集合
     */
    List<Integer> countSuccessReviewed(Integer residentId);

    /**
     * 根据用户主键id查询数据库住户信息
     * @param residentId 用户主键id
     * @return 数据库住户信息
     */
    MyHouseResidentInfoVo findSBResidentInfoByResidentId(Integer residentId);
}
