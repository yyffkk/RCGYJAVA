package com.api.manage.dao.basicArchives;

import com.api.model.basicArchives.CpmParkingSpace;
import com.api.vo.basicArchives.VoCpmParkingSpace;
import com.api.vo.basicArchives.VoParkingSpace;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CpmParkingSpaceDao {
    /**
     * 查询车位信息（包含条件搜索）【车位表，住户表-业主（拥有者），住户表-业主，租客（使用者）】
     * @param voCpmParkingSpace 搜索条件
     * @return 车位信息集合
     */
    List<VoParkingSpace> list(VoCpmParkingSpace voCpmParkingSpace);

    /**
     * 添加车位信息 【车位表】
     * @param cpmParkingSpace 车位信息
     * @return 影响行数
     */
    int insert(CpmParkingSpace cpmParkingSpace);

    /**
     * 根据ID查询车位信息 【车位表】
     * @param id 车位主键ID
     * @return 车位信息
     */
    CpmParkingSpace findById(Integer id);

    /**
     * 更新车位信息 【车位表】
     * @param cpmParkingSpace 新车位信息
     * @return 影响行数
     */
    int update(CpmParkingSpace cpmParkingSpace);

    /**
     * 删除车位信息 【车位表】
     * @param id 车位主键id
     * @return 影响行数
     */
    int delete(Integer id);

    /**
     * 根据拥有者id 【车位表，住户表-业主（拥有者）】
     * @param id 拥有者id
     * @return 车位信息集合
     */
    List<CpmParkingSpace>  findByResidentId(Integer id);

    /**
     * 根据使用者id 【车位表，住户表-业主，租户（使用者）】
     * @param tenantId 使用者id
     * @return 车位信息集合
     */
    List<CpmParkingSpace> findByUserId(Integer tenantId);

    /**
     * 根据车位编号查询车位信息 【车位表】
     * @param code 车位编号
     * @return 车位信息集合
     */
    CpmParkingSpace findByCode(String code);
}
