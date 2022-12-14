package com.api.manage.dao.basicArchives;

import com.api.model.basicArchives.CpmBuildingUnitEstate;
import com.api.model.basicArchives.ResidentIdAndEstateId;
import com.api.model.basicArchives.SearchCpmBuildingUnitEstate;
import com.api.vo.basicArchives.VoCpmBuildingUnitEstate;
import com.api.vo.basicArchives.VoEffectiveTimes;
import com.api.vo.basicArchives.VoFindAll;
import com.api.vo.basicArchives.VoTenantCpmBuildingUnitEstate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CpmBuildingUnitEstateDao {
    /**
     * 查询房产信息（包含条件搜索）【楼栋表，单元表，房产表】
     * @param searchCpmBuildingUnitEstate 房产信息搜索条件
     * @return 房产信息集合
     */
    List<VoCpmBuildingUnitEstate> list(SearchCpmBuildingUnitEstate searchCpmBuildingUnitEstate);

    /**
     * 添加房产信息 【房产表】
     * @param cpmBuildingUnitEstate 房产信息
     * @return 影响行数
     */
    int insert(CpmBuildingUnitEstate cpmBuildingUnitEstate);

    /**
     * 根据id查询房产信息
     * @param id 房产主键id
     * @return 房产信息
     */
    CpmBuildingUnitEstate findById(Integer id);

    /**
     * 更新房产信息
     * @param cpmBuildingUnitEstate 新房产信息
     * @return 影响行数
     */
    int update(CpmBuildingUnitEstate cpmBuildingUnitEstate);

    /**
     * 删除房产信息
     * @param id 房产主键id
     * @return 影响行数
     */
    int delete(Integer id);

    /**
     * 根据业主id查询房产信息 【住户表-业主，房产表，住户房产关联表】
     * @param id 业主主键id
     * @return 房产信息
     */
    List<CpmBuildingUnitEstate> findByResidentId(Integer id);

    /**
     * 查询所有房产信息 【房产表】
     * @return 房产信息 id as value,room_number as label
     */
    List<VoFindAll> findAll();

    /**
     * 根据租客id查询房产信息 【住户表-租客，房产表，住户房产关联表】
     * @param id 租客主键id
     * @return 房产信息
     */
    List<VoTenantCpmBuildingUnitEstate> findByTenantId(Integer id);

    /**
     * 根据楼栋单元Id查询房产信息 【房产表】
     * @param id 楼栋单元id
     * @return 房产信息 id as value,room_number as label
     */
    List<VoFindAll> findByBuildingUnitId(Integer id);

    /**
     * 根据房间号查询房产信息 【房产表】
     * @param roomNumber 房间号
     * @return 房产信息
     */
    CpmBuildingUnitEstate findByRoomNumber(String roomNumber);

    /**
     * 根据房产id查询业主id,
     * @param buildingUnitEstateId 房产id
     * @return 业主id集合
     */
    List<Integer> findResidentIdByEstateId(Integer buildingUnitEstateId);

    /**
     * 根据楼栋id查询对应的楼栋单元房产id和name
     * @param buildingId 楼栋id
     * @return 楼栋单元房产id和name
     */
    List<VoFindAll> findByBuildingId(Integer buildingId);

    /**
     * 根据房产主键id查询房产有效开始时间，有效结束时间（此属性只有租客有用）
     * @param residentIdAndEstateId 房产id 和 业主id
     * @return 房产有效时间
     */
    VoEffectiveTimes findTimeByEstateId(ResidentIdAndEstateId residentIdAndEstateId);

    /**
     * 根据拜访房产id查询设备号
     * @param estateId 拜访房产id
     * @return 设备号
     */
    String findDeviceNumberByEstateId(Integer estateId);

    /**
     * 根据楼栋单元主键id查询绑定的房屋数量
     * @param id 楼栋单元主键id
     * @return 绑定的房屋数量
     */
    int countByBuildingUnitId(int id);

    /**
     * 根据楼栋id查询对应的单元id和单元号
     * @param buildingId 楼栋id
     * @return 单元id和单元号
     */
    List<VoFindAll> findUnitByBuildingId(Integer buildingId);

    /**
     * 根据单元id查询对应的房产id和单元号
     * @param unitId 单元id
     * @return 房产id和单元号
     */
    List<VoFindAll> findEstateIdByUnitId(Integer unitId);
}
