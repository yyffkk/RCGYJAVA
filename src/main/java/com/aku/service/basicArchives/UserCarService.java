package com.aku.service.basicArchives;

import com.aku.model.basicArchives.SearchUserCar;
import com.aku.model.basicArchives.UserCar;
import com.aku.vo.basicArchives.VoUserCar;
import com.aku.vo.basicArchives.VoUserCarFindById;

import java.util.List;
import java.util.Map;

public interface UserCarService {
    List<VoUserCar> list(SearchUserCar searchUserCar);

    Map<String, Object> insert(UserCar userCar);

    VoUserCarFindById findById(Integer id);

    Map<String, Object> update(UserCar userCar);

    Map<String, Object> delete(int[] id);
}
