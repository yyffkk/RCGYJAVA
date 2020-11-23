package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.*;
import com.aku.vo.basicArchives.VoRelatives;
import com.aku.vo.basicArchives.VoUserResident;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserResidentDao {
    List<VoUserResident> list(UserResident userResident);

    int insert(UserResident userResident);

    int insertResidentRelatives(UserResidentRelatives userResidentRelatives);

    int insertRelatives(VoRelatives voRelatives);

    int insertResidentEstate(CpmResidentEstate cpmResidentEstate);

    List<UserResident> findByBuildingUnitEstateId(Integer buildingUnitEstateId);

    int update(UserResident userResident);

    UserResident findById(Integer id);


    List<VoRelatives> findRelativesById(Integer id);

    int deleteRelativesId(int id);

    int updateResidentRelatives(UserResidentRelatives userResidentRelatives);

    int delete(Integer id);

    int deleteByResidentIdAndEstateId(ResidentIdAndEstateId residentIdAndEstateId);

    int deleteByResidentIdAndRelativesId(ResidentIdAndRelativesId residentIdAndRelativesId);
}
