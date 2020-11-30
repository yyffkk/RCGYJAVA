package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.*;
import com.aku.vo.basicArchives.VoFindAll;
import com.aku.vo.basicArchives.VoRelatives;
import com.aku.vo.basicArchives.VoUserResident;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserResidentDao {
    /**
     * 查询业主信息list，包含条件搜索 【住户表】
     * @param userResident 搜索条件
     * @return 业主信息显示 listVo
     */
    List<VoUserResident> list(UserResident userResident);

    /**
     * 添加住户信息 【住户表】
     * @param userResident 住户信息
     * @return 影响行数
     */
    int insert(UserResident userResident);

    /**
     * 添加住户亲属关联 【住户亲属关联表】
     * @param userResidentRelatives 业主亲属关联表信息model
     * @return 影响行数
     */
    int insertResidentRelatives(UserResidentRelatives userResidentRelatives);

    /**
     * 添加亲属信息 【住户表-亲属】
     * @param voRelatives 亲属信息
     * @return 影响行数
     */
    int insertRelatives(VoRelatives voRelatives);

    /**
     * 添加业主房产关联 【业主房产关联表】
     * @param cpmResidentEstate 住户房产关联表信息model
     * @return 影响行数
     */
    int insertResidentEstate(CpmResidentEstate cpmResidentEstate);

    /**
     * 根据房产id查询业主信息【业主表-业主，业主房产关联表】
     * @param buildingUnitEstateId 房产id
     * @return 业主信息集合
     */
    List<UserResident> findByBuildingUnitEstateId(Integer buildingUnitEstateId);

    /**
     * 更新住户信息 【住户表】
     * @param userResident 新住户信息
     * @return 影响行数
     */
    int update(UserResident userResident);

    /**
     * 根据住户id查询住户信息 【住户表】
     * @param id 住户主键id
     * @return 住户信息
     */
    UserResident findById(Integer id);


    /**
     * 根据住户ID查询亲属信息 【住户表-业主或租户，住户亲属关联表，住户表-亲属】
     * @param id 住户主键id
     * @return 亲属信息集合
     */
    List<VoRelatives> findRelativesById(Integer id);

    /**
     * 根据住户id和亲属id修改业主亲属关联中的身份信息 【住户亲属关联表】
     * @param userResidentRelatives 住户亲属关联表信息model
     * @return 影响行数
     */
    int updateResidentRelatives(UserResidentRelatives userResidentRelatives);

    /**
     * 根据id删除住户表信息 【住户表】
     * @param id 住户主键id
     * @return 影响行数
     */
    int delete(Integer id);

    /**
     * 根据住户id和房产id删除业主房产关联表信息 【住户房产关联表】
     * @param residentIdAndEstateId 住户id和房产id
     * @return 影响行数
     */
    int deleteByResidentIdAndEstateId(ResidentIdAndEstateId residentIdAndEstateId);

    /**
     * 根据住户id和亲属id删除业主亲属关联表信息 【住户亲属关联表】
     * @param residentIdAndRelativesId 住户id和亲属id
     * @return 影响行数
     */
    int deleteByResidentIdAndRelativesId(ResidentIdAndRelativesId residentIdAndRelativesId);

    /**
     * 查询所有的业主信息
     * @return 业主信息的id as value,name as label
     */
    List<VoFindAll> findResidentAll();

    /**
     * 查询所有的住户信息
     * @return 住户信息的id as value,name as label
     */
    List<VoFindAll> findAll();

    /**
     * 根据业主手机号和证件号码查询业主信息 【住户表-业主】
     * @param userResident 业主信息
     * @return 住户信息
     */
    UserResident findByTelAndIdNumber(UserResident userResident);

    /**
     * 根据业主手机号查询业主信息 【住户表-业主】
     * @param tel 业主手机号
     * @return 住户信息
     */
    UserResident findByTel(String tel);

    /**
     * 根据业主证件号码查询业主信息 【住户表-业主】
     * @param idNumber 业主证件号码
     * @return 住户信息
     */
    UserResident findByIdNumber(String idNumber);

    /**
     * 根据住户id和房产id查询住户房产关联表 【住户房产关联表】
     * @param residentIdAndEstateId 住户id和房产id
     * @return 住户房产关联表信息
     */
    CpmResidentEstate findByEstateIdAndResidentId(ResidentIdAndEstateId residentIdAndEstateId);
}
