package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.CpmDecorationStaff;
import com.aku.model.basicArchives.DecorationIdAndStaffId;
import com.aku.model.basicArchives.UserStaff;

import java.util.List;

public interface UserStaffDao {
    int insert(UserStaff userStaff);

    List<UserStaff> findByDecorationId(Integer id);

    int deleteByDecorationIdAndStaffId(DecorationIdAndStaffId decorationIdAndStaffId);

    int deleteById(Integer id);

    int insertDecorationIdAndStaffId(CpmDecorationStaff cpmDecorationStaff);

    List<UserStaff> findByStaffId(Integer staffId);
}
