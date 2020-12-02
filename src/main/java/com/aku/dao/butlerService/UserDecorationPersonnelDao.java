package com.aku.dao.butlerService;

import com.aku.model.butlerService.UserDecorationPersonnel;
import com.aku.vo.butlerService.VoUserDecorationPersonnel;

public interface UserDecorationPersonnelDao {
    int insertDecorationPersonnel(UserDecorationPersonnel userDecorationPersonnel);

    int deleteDecorationPersonnel(int id);

    VoUserDecorationPersonnel findByIdDecorationPersonnel(Integer id);

    int updateDecorationPersonnel(UserDecorationPersonnel userDecorationPersonnel);
}
