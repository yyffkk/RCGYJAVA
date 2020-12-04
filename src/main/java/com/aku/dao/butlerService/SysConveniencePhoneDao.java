package com.aku.dao.butlerService;

import com.aku.model.butlerService.SearchConveniencePhone;
import com.aku.model.butlerService.SysConveniencePhone;
import com.aku.model.butlerService.SysConveniencePhoneReminder;
import com.aku.vo.butlerService.VoConveniencePhone;

import java.util.List;

public interface SysConveniencePhoneDao {
    /**
     * 查询便民电话信息（包含条件搜索）
     * @param searchConveniencePhone 搜索条件
     * @return 便民电话信息集合
     */
    List<VoConveniencePhone> list(SearchConveniencePhone searchConveniencePhone);

    /**
     * 添加便民电话信息
     * @param sysConveniencePhone 便民电话信息
     * @return 影响行数
     */
    int insert(SysConveniencePhone sysConveniencePhone);

    /**
     * 根据主键id查询提醒间隔和内容
     * @param i 定时检查主键id
     * @return 定时检查信息
     */
    SysConveniencePhoneReminder findRemindById(int i);

    /**
     * 根据便民电话主键id查询便民电话信息
     * @param id 便民电话主键id
     * @return 便民电话信息
     */
    VoConveniencePhone findById(Integer id);

    /**
     * 更新便民电话信息
     * @param sysConveniencePhone 新便民电话信息
     * @return 影响行数
     */
    int update(SysConveniencePhone sysConveniencePhone);

    /**
     * 更新定时检查信息
     * @param sysConveniencePhoneReminder 定时检查信息
     * @return 影响行数
     */
    int updateReminder(SysConveniencePhoneReminder sysConveniencePhoneReminder);
}
