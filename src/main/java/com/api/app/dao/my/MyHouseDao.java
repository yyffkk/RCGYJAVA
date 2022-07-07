package com.api.app.dao.my;

import com.api.model.app.AppUserIdAndExamineId;
import com.api.model.app.SearchAppLeaseRent;
import com.api.model.basicArchives.ResidentIdAndEstateId;
import com.api.model.basicArchives.UserResident;
import com.api.model.butlerService.SysLease;
import com.api.model.butlerService.SysLeaseContract;
import com.api.model.my.SearchSysLease;
import com.api.vo.app.AppLeaseInfoVo;
import com.api.vo.app.AppLeaseRentVo;
import com.api.vo.app.AppLeaseVo;
import com.api.vo.butlerService.VoLease;
import com.api.vo.my.*;

import java.util.List;

public interface MyHouseDao {
    /**
     * 查询用户所有拥有的房屋信息
     * @param id 用户主键id
     * @return 拥有的房屋信息
     */
    List<MyHouseListVo> houseList(Integer id);

    /**
     * 查询所有的房屋审核信息
     * @param id 用户主键id
     * @return 我的房屋Vo list 回显
     */
    List<MyHouseExamineVo> examineList(Integer id);

    /**
     * 根据用户主键id 查询该用户的审核中记录数量
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
     * TODO 此查询改为2个查询 查业主关联的房产id select cre.building_unit_estate_id from cpm_resident_estate as cre,user_resident as ur where cre.resident_id = ur.id and resident_id = #{residentId} and ur.type = 3
     * TODO  查租户关联的房产id select cre.building_unit_estate_id from cpm_resident_estate as cre,user_resident as ur where cre.resident_id = ur.id and resident_id = #{residentId} and ur.type = 1
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

    /**
     * 根据用户主键id修改当前选中的房产审核id
     * @param appUserIdAndExamineId app 用户主键id 和 房产审核主键id
     * @return 影响行数
     */
    int updateEstateExamineId(AppUserIdAndExamineId appUserIdAndExamineId);

    /**
     * 根据手机号
     * @param tel 手机号
     * @return 租赁管理信息集合
     */
    List<SysLease> findLeaseByTel(String tel);

    /**
     * 更新用户信息
     * @param userResident 住户信息表
     * @return 影响行数
     */
    int updateUserResidentInfo(UserResident userResident);

    /**
     * 根据手机号查询认证回显信息
     * @param tel 手机号
     * @return 认证回显信息
     */
    AppLeaseInfoVo findLeaseInfoByTel(String tel);

    /**
     * 查询所有的租赁信息
     * @param searchSysLease 租赁管理 搜索条件
     * @return 租赁信息
     */
    List<AppLeaseVo> leaseList(SearchSysLease searchSysLease);

    /**
     * 根据租赁主键id查询租赁信息
     * @param leaseId 租赁主键id
     * @return 租赁信息
     */
    VoLease leaseFindById(Integer leaseId);

    /**
     * 提交个人租赁信息
     * @param sysLease 租赁管理model
     * @return 影响行数
     */
    int submitPersonalLeaseInfo(SysLease sysLease);

    /**
     * 查询当前开启的合同模版
     * @return 合同模版
     */
    SysLeaseContract findEnableLeaseContract();

    /**
     * 根据租赁主键id 修改租赁状态
     * @param sysLease 租赁管理model
     * @return 影响行数
     */
    int updateStatusById(SysLease sysLease);

    /**
     * 提交终止申请
     * @param sysLease 租赁管理model
     * @return 影响行数
     */
    int submitTerminateApplication(SysLease sysLease);

    /**
     * 根据租赁主键id查询租赁信息
     * @param id 租赁主键id
     * @return 租赁信息
     */
    SysLease findLeaseById(Integer id);

    /**
     * 查询所有的缴费查询（包含搜索条件）
     * @param searchAppLeaseRent app 租赁租金账单 搜索条件
     * @return 缴费查询
     */
    List<AppLeaseRentVo> findLeaseRentList(SearchAppLeaseRent searchAppLeaseRent);
}
