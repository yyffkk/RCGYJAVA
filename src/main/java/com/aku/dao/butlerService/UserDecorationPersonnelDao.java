package com.aku.dao.butlerService;

import com.aku.model.butlerService.UserDecorationPersonnel;
import com.aku.vo.butlerService.VoUserDecorationPersonnel;

import java.util.List;

public interface UserDecorationPersonnelDao {
    int insertDecorationPersonnel(UserDecorationPersonnel userDecorationPersonnel);

    int deleteDecorationPersonnel(int id);

    VoUserDecorationPersonnel findByIdDecorationPersonnel(Integer id);

    int updateDecorationPersonnel(UserDecorationPersonnel userDecorationPersonnel);

    int deletePersonnelByDecorationId(int id);

    List<UserDecorationPersonnel> findByDecorationId(int id);
}
