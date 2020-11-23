package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.SearchUserCar;
import com.aku.model.basicArchives.UserCar;
import com.aku.vo.basicArchives.VoUserCar;
import com.aku.vo.basicArchives.VoUserCarFindById;

import java.util.List;

public interface UserCarDao {
    List<VoUserCar> list(SearchUserCar searchUserCar);

    int insert(UserCar userCar);

    VoUserCarFindById findById(Integer id);

    int update(UserCar userCar);

    int delete(Integer id);
}
