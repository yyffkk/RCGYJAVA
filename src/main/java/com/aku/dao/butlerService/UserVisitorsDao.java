package com.aku.dao.butlerService;

import com.aku.model.butlerService.SearchUserVisitors;
import com.aku.model.butlerService.UserVisitors;
import com.aku.vo.butlerService.VoFindByIdVisitors;
import com.aku.vo.butlerService.VoUserVisitors;
import com.aku.vo.butlerService.VoUserVisitorsDetail;

import java.util.List;
import java.util.Map;

public interface UserVisitorsDao {
    List<VoUserVisitors> list(SearchUserVisitors searchUserVisitors);

    VoFindByIdVisitors findById(Integer id);

    int update(UserVisitors userVisitors);

    int delete(int id);

    List<VoUserVisitorsDetail> listDetail(Integer id);
}
