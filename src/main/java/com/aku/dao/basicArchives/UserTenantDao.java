package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.CpmResidentEstate;
import com.aku.model.basicArchives.UserResident;
import com.aku.vo.basicArchives.VoUserTenant;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserTenantDao {
    List<VoUserTenant> list(UserResident userTenant);

    int insertResidentEstate(CpmResidentEstate cpmResidentEstate);
}
