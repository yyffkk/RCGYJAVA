package com.api.app.dao.my;

import com.api.model.my.MyParkingSpace;
import com.api.vo.my.MyParkingSpaceVo;

import java.util.List;

public interface MyParkingSpaceDao {
    /**
     * 查询所有的车位审核信息
     * @param id 用户主键id
     * @return 车位审核信息
     */
    List<MyParkingSpaceVo> list(Integer id);

}
