package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.CpmBuilding;
import com.aku.vo.basicArchives.VoFindAll;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CpmBuildingDao {
    /**
     * 查询楼栋信息（包含条件搜索）【楼栋表】
     * @param cpmBuilding 楼栋信息
     * @return 楼栋信息集合
     */
    List<CpmBuilding> list(CpmBuilding cpmBuilding);

    /**
     * 添加楼栋信息 【楼栋表】
     * @param cpmBuilding 楼栋信息
     * @return 影响行数
     */
    int insert(CpmBuilding cpmBuilding);

    /**
     * 根据id查询楼栋信息 【楼栋表】
     * @param id 楼栋主键id
     * @return 楼栋信息
     */
    CpmBuilding findById(Integer id);

    /**
     * 更新楼栋信息 【楼栋表】
     * @param cpmBuilding 楼栋信息
     * @return 影响行数
     */
    int update(CpmBuilding cpmBuilding);

    /**
     * 根据id删除楼栋信息 【楼栋表】
     * @param id 楼栋主键ID
     * @return 影响行数
     */
    int delete(Integer id);

    /**
     * 查询所有的楼栋信息 【楼栋表】
     * @return 楼栋信息 id as value,name as label
     */
    List<VoFindAll> findAll();

    /**
     * 根据楼栋编号查询楼栋信息
     * @param no 楼栋编号 【楼栋表】
     * @return 楼栋信息
     */
    CpmBuilding findByNo(Integer no);

    /**
     * 根据楼栋名称查询楼栋信息
     * @param name 楼栋名称 【楼栋表】
     * @return 楼栋表
     */
    CpmBuilding findByName(String name);
}
