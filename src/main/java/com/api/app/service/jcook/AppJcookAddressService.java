package com.api.app.service.jcook;

import com.api.model.jcook.dto.DelAddressDTO;
import com.api.model.jcook.dto.JcookAddressDTO;
import com.api.model.jcook.dto.SettingDefaultAddressDTO;

import java.util.Map;

public interface AppJcookAddressService {
    /**
     * 添加收货地址
     * @param jcookAddressDTO 收货地址 DTO
     * @return map
     */
    Map<String, Object> insert(JcookAddressDTO jcookAddressDTO);

    /**
     * 我的收货地址
     * @param id 用户主键id
     * @return map
     */
    Map<String, Object> myAddress(Integer id);

    /**
     * 修改收货地址
     * @param jcookAddressDTO 收货地址 DTO
     * @return map
     */
    Map<String, Object> update(JcookAddressDTO jcookAddressDTO);

    /**
     * 删除收货地址
     * @param delAddressDTO 删除收货地址 DTO
     * @return map
     */
    Map<String, Object> delete(DelAddressDTO delAddressDTO);

    /**
     * 设置默认地址
     * @param settingDefaultAddressDTO 设置默认地址DTO
     * @return map
     */
    Map<String, Object> settingDefaultAddress(SettingDefaultAddressDTO settingDefaultAddressDTO);
}
