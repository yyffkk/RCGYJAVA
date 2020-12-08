package com.api.service.basicArchives;

import com.api.model.basicArchives.SearchUserCar;
import com.api.model.basicArchives.UserCar;
import com.api.vo.basicArchives.VoUserCar;
import com.api.vo.basicArchives.VoUserCarFindById;

import java.util.List;
import java.util.Map;

public interface UserCarService {
    List<VoUserCar> list(SearchUserCar searchUserCar);

    Map<String, Object> insert(UserCar userCar);

    VoUserCarFindById findById(Integer id);

    Map<String, Object> update(UserCar userCar);

    Map<String, Object> delete(int[] id);
}
