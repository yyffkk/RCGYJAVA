package com.api.app.controller.jcook;

import com.api.app.service.jcook.AppJcookAddressService;
import com.api.model.jcook.appDto.DelAddressDTO;
import com.api.model.jcook.appDto.JcookAddressDTO;
import com.api.model.jcook.appDto.SettingDefaultAddressDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 京库克商城（第三方对接）App端地址
 */
@RestController
@RequestMapping("app/user/jcookAddress")
public class AppJcookAddressController {
    @Resource
    AppJcookAddressService appJcookAddressService;


    /**
     * 添加收货地址
     * @param jcookAddressDTO 收货地址 DTO
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody JcookAddressDTO jcookAddressDTO, HttpServletRequest request){
        //从request获取用户id
        Integer residentId = Integer.valueOf(request.getParameter("id"));
        jcookAddressDTO.setResidentId(residentId);//填入用户主键id
        return appJcookAddressService.insert(jcookAddressDTO);
    }

    /**
     * 我的收货地址
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/myAddress")
    public Map<String,Object> myAddress(Integer id){
        return appJcookAddressService.myAddress(id);
    }

    /**
     * 修改收货地址
     * @param jcookAddressDTO 收货地址 DTO
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody JcookAddressDTO jcookAddressDTO, HttpServletRequest request){
        //从request获取用户id
        Integer residentId = Integer.valueOf(request.getParameter("id"));
        jcookAddressDTO.setResidentId(residentId);//填入用户主键id
        return appJcookAddressService.update(jcookAddressDTO);
    }

    /**
     * 删除收货地址
     * @param delAddressDTO 删除收货地址 DTO
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody DelAddressDTO delAddressDTO,HttpServletRequest request){
        //从request获取用户id
        Integer residentId = Integer.valueOf(request.getParameter("id"));
        delAddressDTO.setResidentId(residentId);
        return appJcookAddressService.delete(delAddressDTO);
    }


    /**
     * 设置默认地址
     * @param settingDefaultAddressDTO 设置默认地址DTO
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/settingDefaultAddress")
    public Map<String,Object> settingDefaultAddress(@RequestBody SettingDefaultAddressDTO settingDefaultAddressDTO,HttpServletRequest request){
        //从request获取用户id
        Integer residentId = Integer.valueOf(request.getParameter("id"));
        settingDefaultAddressDTO.setResidentId(residentId);
        return appJcookAddressService.settingDefaultAddress(settingDefaultAddressDTO);
    }

    /**
     * 根据父类主键id查询城市信息
     * @param parentId 父类主键id
     * @return 城市信息
     */
    @GetMapping("/findByParentId")
    public Map<String,Object> findByParentId(Integer parentId){
        return appJcookAddressService.findByParentId(parentId);
    }

    /**
     * 查询所有的城市信息
     * @return map
     */
    @GetMapping("/findAllCityInfo")
    public Map<String,Object> findAllCityInfo(){
        return appJcookAddressService.findAllCityInfo();
    }


}
