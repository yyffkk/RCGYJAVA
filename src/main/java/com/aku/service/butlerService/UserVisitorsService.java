package com.aku.service.butlerService;

import com.aku.model.butlerService.SearchUserVisitors;
import com.aku.model.butlerService.UserVisitors;
import com.aku.vo.butlerService.VoFindByIdVisitors;
import com.aku.vo.butlerService.VoUserVisitors;

import java.util.List;
import java.util.Map;

public interface UserVisitorsService {
    /**
     * 查询所有的访客管理信息 （包含条件搜索）
     * @param searchUserVisitors 搜索条件
     * @return 访客管理信息集合
     */
    List<VoUserVisitors> list(SearchUserVisitors searchUserVisitors);

    /**
     * 根据访客管理主键id查询访客管理信息
     * @param id 访客管理主键id
     * @return 访客管理信息
     */
    VoFindByIdVisitors findById(Integer id);

    Map<String, Object> update(UserVisitors visitors);

    Map<String, Object> cancel(int[] ids);

    Map<String, Object> delete(int[] ids);

    Map<String, Object> listDetail(Integer id);

    Map<String, Object> countVisitorsNew();
}
