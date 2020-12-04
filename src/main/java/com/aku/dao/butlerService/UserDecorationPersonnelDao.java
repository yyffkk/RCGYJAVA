package com.aku.dao.butlerService;

import com.aku.model.butlerService.UserDecorationPersonnel;
import com.aku.vo.butlerService.VoUserDecorationPersonnel;

import java.util.List;

public interface UserDecorationPersonnelDao {
    /**
     * 添加装修人员信息
     * @param userDecorationPersonnel 装修人员信息
     * @return 影响行数
     */
    int insertDecorationPersonnel(UserDecorationPersonnel userDecorationPersonnel);

    /**
     * 根据装修人员主键id数组删除装修人员信息
     * @param id 装修人员主键id
     * @return 影响行数
     */
    int deleteDecorationPersonnel(int id);

    /**
     * 根据装修人员主键id查询装修人员信息
     * @param id 装修人员主键id
     * @return 装修人员信息集合
     */
    VoUserDecorationPersonnel findByIdDecorationPersonnel(Integer id);

    /**
     * 修改装修人员信息
     * @param userDecorationPersonnel 新装修人员信息
     * @return 影响行数
     */
    int updateDecorationPersonnel(UserDecorationPersonnel userDecorationPersonnel);

    /**
     * 根据装修信息主键id删除装修人员信息
     * @param id 装修信息主键id
     * @return 影响行数
     */
    int deletePersonnelByDecorationId(int id);

    /**
     * 根据装修信息主键id查询装修人员信息
     * @param id 装修信息主键id
     * @return 装修人员信息集合
     */
    List<UserDecorationPersonnel> findByDecorationId(int id);
}
