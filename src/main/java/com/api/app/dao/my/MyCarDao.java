package com.api.app.dao.my;

import com.api.vo.my.MyCarVo;

import java.util.List;

public interface MyCarDao {
    /**
     * 查询所有的车辆
     * @param id 用户主键id
     * @return 所有的车辆
     */
    List<MyCarVo> list(Integer id);
}
