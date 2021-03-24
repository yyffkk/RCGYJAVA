package com.api.app.dao.my;

import com.api.model.my.MyParkingSpace;
import com.api.vo.my.MyParkingSpaceVo;

import java.util.List;

public interface MyParkingSpaceDao {
    /**
     * 查询所有的车位审核信息
     * @param id 用户主键id
     * @return 车位审核信息
     */
    List<MyParkingSpaceVo> list(Integer id);

    /**
     * 判断该用户是否已有待审核记录存在
     * @param residentId 用户主键id
     * @return 待审核记录数
     */
    int countNotReviewed(Integer residentId);

    /**
     * 添加审核车位表信息
     * @param myParkingSpace 我的车位审核model
     * @return 影响行数
     */
    int insertParkingSpaceExamine(MyParkingSpace myParkingSpace);

    /**
     * 根据车位审核表主键id查询审核状态
     * @param id 车位审核表主键id
     * @return 审核状态
     */
    int findStatusById(int id);

    /**
     * 假删除审核信息
     * @param id 车位审核表主键id
     * @return 影响行数
     */
    int falseDelete(int id);
}
