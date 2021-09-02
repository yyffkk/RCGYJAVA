package com.api.manage.dao.businessManagement;

import com.api.model.businessManagement.SearchDataBase;
import com.api.model.businessManagement.SysDataBase;
import com.api.vo.businessManagement.VoDataBase;

import java.util.List;

public interface SysDataBaseDao {
    /**
     * 查询所有的数据库信息
     * @param searchDataBase 数据库搜索条件
     * @return 数据库信息
     */
    List<VoDataBase> list(SearchDataBase searchDataBase);

    /**
     * 添加数据库信息
     * @param sysDataBase 数据库model信息
     * @return 影响行数
     */
    int insert(SysDataBase sysDataBase);

    /**
     * 根据数据库信息主键id删除数据库信息
     * @param id 数据库信息主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 修改数据库信息
     * @param sysDataBase 数据库model信息
     * @return 影响行数
     */
    int update(SysDataBase sysDataBase);
}
