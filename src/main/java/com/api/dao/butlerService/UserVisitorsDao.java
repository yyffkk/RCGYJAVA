package com.api.dao.butlerService;

import com.api.model.butlerService.SearchUserVisitors;
import com.api.model.butlerService.UserVisitors;
import com.api.vo.butlerService.VoFindByIdVisitors;
import com.api.vo.butlerService.VoUserVisitors;
import com.api.vo.butlerService.VoUserVisitorsDetail;

import java.util.List;

public interface UserVisitorsDao {
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

    /**
     * 更新访客管理信息
     * @param userVisitors 新访客管理信息
     * @return 影响行数
     */
    int update(UserVisitors userVisitors);

    /**
     * 根据访客信息主键id删除访客信息
     * @param id 访客信息主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 根据访客管理信息主键id查询访客出入记录
     * @param id 访客管理信息主键id
     * @return 访客出入记录集合
     */
    List<VoUserVisitorsDetail> listDetail(Integer id);

    /**
     * 查询今日家庭申报访客通行数量
     * @return 今日家庭申报访客通行数量
     */
    Integer countVisitorsNew();
}
