package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.CpmResidentEstate;
import com.aku.model.basicArchives.UserResident;
import com.aku.vo.basicArchives.VoUserTenant;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserTenantDao {
    /**
     * 查询所有租户信息（包含条件搜索）【住户表-租户，房产表，住户房产关联表，车辆表】
     * @param userTenant 搜索条件（租户名称，租户手机号）
     * @return 租户信息
     */
    List<VoUserTenant> list(UserResident userTenant);

    /**
     * 添加住户房产关联信息 【住户房产关联表】
     * @param cpmResidentEstate 住户房产关联表信息
     * @return 影响行数
     */
    int insertResidentEstate(CpmResidentEstate cpmResidentEstate);
}
