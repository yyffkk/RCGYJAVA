package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.CpmBuildingUnit;
import com.aku.vo.basicArchives.VoCpmBuildingUnit;
import com.aku.vo.basicArchives.VoFindAll;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CpmBuildingUnitDao {
    /**
     * 查询楼栋单元信息（包含条件搜索）【楼栋单元表】
     * @param voCpmBuildingUnit 楼栋单元信息
     * @return 楼栋单元信息集合
     */
    List<VoCpmBuildingUnit> list(VoCpmBuildingUnit voCpmBuildingUnit);

    /**
     * 添加楼栋单元信息 【楼栋单元表】
     * @param cpmBuildingUnit 楼栋单元信息
     * @return 影响行数
     */
    int insert(CpmBuildingUnit cpmBuildingUnit);

    /**
     * 根据id查询楼栋单元信息 【楼栋单元表】
     * @param id 楼栋主键id
     * @return 楼栋单元信息
     */
    CpmBuildingUnit findById(Integer id);

    /**
     * 更新楼栋单元信息 【楼栋单元表】
     * @param cpmBuildingUnit 新楼栋单元信息
     * @return 影响行数
     */
    int update(CpmBuildingUnit cpmBuildingUnit);

    /**
     * 删除楼栋单元信息 【楼栋单元表】
     * @param id 楼栋单元主键id
     * @return 影响行数
     */
    int delete(Integer id);

    /**
     * 查询所有的楼栋单元信息 【楼栋单元表】
     * @return 楼栋单元信息集合 id as value,no as label
     */
    List<VoFindAll> findAll();

    /**
     * 根据楼栋id查询楼栋单元信息 【楼栋单元表】
     * @param id 楼栋主键id
     * @return 楼栋单元信息集合 id as value,no as label
     */
    List<VoFindAll> findByBuildingId(Integer id);

    /**
     * 根据单元号查询楼栋单元信息 【楼栋单元表】
     * @param no 楼栋单元号
     * @return 楼栋单元信息集合 id as value,no as label
     */
    CpmBuildingUnit findByNo(Integer no);
}
