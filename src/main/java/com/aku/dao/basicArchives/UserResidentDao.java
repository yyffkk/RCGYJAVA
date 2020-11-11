package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.UserResident;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface UserResidentDao {
    List<UserResident> list(UserResident userResident);

    int insert(UserResident userResident);
}
