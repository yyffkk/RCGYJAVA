package com.api.dao.basicArchives;

import com.api.model.basicArchives.SearchUserCar;
import com.api.model.basicArchives.UserCar;
import com.api.vo.basicArchives.VoUserCar;
import com.api.vo.basicArchives.VoUserCarFindById;

import java.util.List;

public interface UserCarDao {
    /**
     * 查询所有车辆信息（包含条件搜索）【车辆表，车位表】
     * @param searchUserCar 搜索条件
     * @return 车辆信息集合
     */
    List<VoUserCar> list(SearchUserCar searchUserCar);

    /**
     * 添加车辆信息 【车辆表】
     * @param userCar 车辆信息
     * @return 影响行数
     */
    int insert(UserCar userCar);

    /**
     * 根据id查询车辆信息 【车辆表，车位表】
     * @param id 车辆主键id
     * @return 车辆信息
     */
    VoUserCarFindById findById(Integer id);

    /**
     * 更新车辆信息 【车辆表】
     * @param userCar 新车辆信息
     * @return 影响行数
     */
    int update(UserCar userCar);

    /**
     * 删除车辆信息 【车辆表】
     * @param id 车辆主键id
     * @return 影响行数
     */
    int delete(Integer id);
}
