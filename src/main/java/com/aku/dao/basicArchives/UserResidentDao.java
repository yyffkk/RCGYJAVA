package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.CpmResidentEstate;
import com.aku.model.basicArchives.UserResident;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserResidentDao {
    List<UserResident> list(UserResident userResident);

    int insert(UserResident userResident);

    int insertResidentEstate(CpmResidentEstate cpmResidentEstate);

    UserResident findByBuildingUnitEstateId(Integer buildingUnitEstateId);

    int update(UserResident userResident);

    UserResident findById(Integer id);

}
