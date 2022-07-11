package com.api.app.service.jcook.impl;

import com.api.app.service.jcook.AppJcookAddressService;
import com.api.mapper.jcook.JcookAddressMapper;
import com.api.mapper.jcook.JcookCityMapper;
import com.api.model.jcook.appDto.DelAddressDTO;
import com.api.model.jcook.appDto.JcookAddressDTO;
import com.api.model.jcook.appDto.SettingDefaultAddressDTO;
import com.api.model.jcook.entity.JcookAddress;
import com.api.model.jcook.entity.JcookCity;
import com.api.model.jcook.appDto.JcookCityAll;
import com.api.util.PropertyUtils;
import com.api.vo.jcook.appAddress.CityVo;
import com.api.vo.jcook.appAddress.MyAddressVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppJcookAddressServiceImpl implements AppJcookAddressService {
    private static StringBuilder stringBuilder = null;
    private static Map<String,Object> map = null;
    @Resource
    JcookAddressMapper jcookAddressMapper;
    @Resource
    JcookCityMapper jcookCityMapper;

    @Override
    public Map<String, Object> insert(JcookAddressDTO jcookAddressDTO) {
        map = new HashMap<>();
        JcookAddress jcookAddress = new JcookAddress();
        //DTO 转 DO
        PropertyUtils.copyProperties(jcookAddressDTO,jcookAddress);
        int insert = jcookAddressMapper.insert(jcookAddress);
        if (insert >0){
            map.put("message","请求成功");
            map.put("status",true);
        }else {
            map.put("message","请求失败");
            map.put("status",false);
        }

        return map;
    }

    @Override
    public Map<String, Object> myAddress(Integer id) {
        map = new HashMap<>();
        QueryWrapper<JcookAddress> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("resident_id",id);
        List<JcookAddress> jcookAddresses = jcookAddressMapper.selectList(queryWrapper);
        ArrayList<MyAddressVo> myAddressVoList = new ArrayList<>();
        if (jcookAddresses != null && jcookAddresses.size()>0){
            for (JcookAddress jcookAddress : jcookAddresses) {
                MyAddressVo myAddressVo = new MyAddressVo();
                PropertyUtils.copyProperties(jcookAddress,myAddressVo);
                StringBuilder locationName = findCityAddressDetails(true, jcookAddress.getLocation());
                myAddressVo.setLocationName(locationName.toString());
                myAddressVoList.add(myAddressVo);
            }
        }

        map.put("message","请求成功");
        map.put("data",myAddressVoList);
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> update(JcookAddressDTO jcookAddressDTO) {
        map = new HashMap<>();

        if (jcookAddressDTO.getIsDefault() != null && jcookAddressDTO.getIsDefault() == 1){
            //当更新时设置默认地址为是
            //先全部置于否
            JcookAddress jcookAddress2 = new JcookAddress();
            jcookAddress2.setIsDefault(0);//0.否
            QueryWrapper<JcookAddress> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("resident_id",jcookAddressDTO.getResidentId());//填入用户主键id
            jcookAddressMapper.update(jcookAddress2, queryWrapper2);
        }

        //再更新对应的信息
        JcookAddress jcookAddress = new JcookAddress();
        //DTO 转 DO
        PropertyUtils.copyProperties(jcookAddressDTO,jcookAddress);
        QueryWrapper<JcookAddress> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",jcookAddressDTO.getId());
        queryWrapper.eq("resident_id",jcookAddressDTO.getResidentId());
        int update = jcookAddressMapper.update(jcookAddress,queryWrapper);
        if (update >0){
            map.put("message","修改成功");
            map.put("status",true);
        }else {
            map.put("message","修改失败");
            map.put("status",false);
        }

        return map;
    }

    @Override
    public Map<String, Object> delete(DelAddressDTO delAddressDTO) {
        map = new HashMap<>();
        QueryWrapper<JcookAddress> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",delAddressDTO.getAddressId());
        queryWrapper.eq("resident_id",delAddressDTO.getResidentId());
        int delete = jcookAddressMapper.delete(queryWrapper);
        if (delete >0){
            map.put("message","删除成功");
            map.put("status",true);
        }else {
            map.put("message","删除失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> settingDefaultAddress(SettingDefaultAddressDTO settingDefaultAddressDTO) {
        map = new HashMap<>();
        JcookAddress jcookAddress = new JcookAddress();
        //先全部置于否
        jcookAddress.setIsDefault(0);//0.否
        QueryWrapper<JcookAddress> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("resident_id",settingDefaultAddressDTO.getResidentId());//填入用户主键id
        jcookAddressMapper.update(jcookAddress, queryWrapper);
        //再将对应的设为默认地址
        jcookAddress.setIsDefault(1);//1.是
        QueryWrapper<JcookAddress> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("id",settingDefaultAddressDTO.getAddressId());//填入地址主键id
        queryWrapper2.eq("resident_id",settingDefaultAddressDTO.getResidentId());//填入用户主键id
        int update = jcookAddressMapper.update(jcookAddress, queryWrapper2);
        if (update >0){
            map.put("message","设置成功");
            map.put("status",true);
        }else {
            map.put("message","设置失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> findByParentId(Integer parentId) {
        map = new HashMap<>();
        //搜索条件
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("parent_id",parentId);
        //数据查询
        List<JcookCity> jcookCityList = jcookCityMapper.selectByMap(map1);
        //DO转VO
        ArrayList<CityVo> cityVoList = new ArrayList<>();
        if (jcookCityList != null && jcookCityList.size()>0){
            for (JcookCity jcookCity : jcookCityList) {
                CityVo cityVo = new CityVo();
                PropertyUtils.copyProperties(jcookCity,cityVo);
                cityVoList.add(cityVo);
            }
        }

        map.put("message","请求成功");
        map.put("data",cityVoList);
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findAllCityInfo() {
        map = new HashMap<>();


        List<JcookCityAll> jcookCityAlls = findAllCityRe(1);

        map.put("message","请求成功");
        map.put("data",jcookCityAlls);
        map.put("status",true);
        return map;
    }

    /**
     * 递归查询全部的城市信息
     * @param parentId 城市信息父类主键id
     * @return 城市信息
     */
    private List<JcookCityAll> findAllCityRe(int parentId) {
        ArrayList<JcookCityAll> jcookCityAlls = new ArrayList<>();
        QueryWrapper<JcookCity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",parentId);
        List<JcookCity> jcookCityList = jcookCityMapper.selectList(queryWrapper);
        if (jcookCityList != null && jcookCityList.size()>0){
            for (JcookCity jcookCity : jcookCityList) {
                JcookCityAll jcookCityAll = new JcookCityAll();
                jcookCityAll.setId(jcookCity.getId());//填入主键id
                jcookCityAll.setName(jcookCity.getName());//填入名称
                List<JcookCityAll> allCityRe = findAllCityRe(jcookCityAll.getId());
                jcookCityAll.setCityList(allCityRe);//填入子城市集合
                jcookCityAlls.add(jcookCityAll);
            }
        }
        return jcookCityAlls;
    }

    /**
     * 查询城市地址
     * @param isCreate 是否需要创建了StringBuild对象
     * @param cityAddress 城市地址主键Id
     * @return 城市地址StringBuild对象
     */
    private StringBuilder findCityAddressDetails(boolean isCreate,Integer cityAddress) {
        if (isCreate){
            //创建StringBuild对象
            stringBuilder = new StringBuilder();
        }
        JcookCity jcookCity = jcookCityMapper.selectById(cityAddress);
        if (jcookCity.getParentId() != 0){
            findCityAddressDetails(false,jcookCity.getParentId());//后续循环不需要创建StringBuild对象
            stringBuilder.append(jcookCity.getName()).append(" ");//拼接公司省县市地址
        }

        return stringBuilder;
    }
}
