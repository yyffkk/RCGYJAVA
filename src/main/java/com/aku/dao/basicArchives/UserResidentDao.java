package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.CpmResidentEstate;
import com.aku.model.basicArchives.UserResident;
import com.aku.model.basicArchives.UserResidentRelatives;
import com.aku.vo.basicArchives.VoRelatives;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserResidentDao {
    List<UserResident> list(UserResident userResident);

    int insert(UserResident userResident);

    int insertResidentRelatives(UserResidentRelatives userResidentRelatives);

    int insertRelatives(VoRelatives voRelatives);

    int insertResidentEstate(CpmResidentEstate cpmResidentEstate);

    UserResident findByBuildingUnitEstateId(Integer buildingUnitEstateId);

    int update(UserResident userResident);

    UserResident findById(Integer id);


    List<VoRelatives> findRelativesById(Integer id);

    int deleteRelativesId(int id);

    int updateResidentRelatives(UserResidentRelatives userResidentRelatives);

    int delete();
}
