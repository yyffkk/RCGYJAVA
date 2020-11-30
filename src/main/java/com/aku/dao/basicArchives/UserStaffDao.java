package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.CpmDecorationStaff;
import com.aku.model.basicArchives.DecorationIdAndStaffId;
import com.aku.model.basicArchives.UserStaff;

import java.util.List;

public interface UserStaffDao {
    /**
     * 添加员工信息 【员工表】
     * @param userStaff 员工信息
     * @return 影响行数
     */
    int insert(UserStaff userStaff);

    /**
     * 根据装修id查询装修信息 【员工表，员工装修关联表】
     * @param id 装修主键id
     * @return 员工信息集合
     */
    List<UserStaff> findByDecorationId(Integer id);

    /**
     * 根据装修id和员工id删除员工装修关联信息 【员工装修关联表】
     * @param decorationIdAndStaffId 装修id和员工id
     * @return 影响行数
     */
    int deleteByDecorationIdAndStaffId(DecorationIdAndStaffId decorationIdAndStaffId);

    /**
     * 根据id删除员工信息 【员工表】
     * @param id 员工主键id
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 添加员工装修关联信息 【员工装修关联表】
     * @param cpmDecorationStaff 员工装修关联表信息
     * @return 影响行数
     */
    int insertDecorationIdAndStaffId(CpmDecorationStaff cpmDecorationStaff);

    /**
     * 根据员工id查询员工信息 【员工表】
     * @param staffId 员工id
     * @return 员工信息集合
     */
    List<UserStaff> findByStaffId(Integer staffId);
}
