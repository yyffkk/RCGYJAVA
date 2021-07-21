package com.api.common;

import com.api.common.dao.GetSysUserIdsDao;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;

/**
 * 根据权限id 查询 对应拥有该权限的物业用户主键id
 */
@Component
public class GetSysUserIds {
    @Resource
    GetSysUserIdsDao getSysUserIdsDao;

    //解决公共类无法调用Dao层数据，数据为null
    //静态初始化当前类
    private static GetSysUserIds getSysUserIds;
    //在方法上加上注解@PostConstruct,这样方法就会在bean初始化之后被spring容器执行
    @PostConstruct
    public void init(){
        //声明的静态类=this
        getSysUserIds=this;
    }

    public HashSet<Integer> FindSysUserIdsByJurisdictionId(Integer jurisdictionId){

        HashSet<Integer> hashSet = new HashSet<>();

        //根据权限主键id查询角色主键id集合
        List<Integer> roleIds = getSysUserIds.getSysUserIdsDao.findRoleIdsByJurisdictionId(jurisdictionId);
        for (Integer roleId : roleIds) {
            //根据角色主键id查询用户主键id集合（通过角色关联来查询用户）
            List<Integer> userIds = getSysUserIds.getSysUserIdsDao.findUserIdsByRoleId(roleId);
            hashSet.addAll(userIds);
        }


        //根据权限主键id查询用户主键id集合(通过身份关联来查询用户)
        List<Integer> userIds = getSysUserIds.getSysUserIdsDao.findUserIdsByJurisdictionId(jurisdictionId);
        hashSet.addAll(userIds);
        return hashSet;
    }
}
