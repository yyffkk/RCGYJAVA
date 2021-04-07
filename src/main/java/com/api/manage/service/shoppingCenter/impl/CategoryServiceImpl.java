package com.api.manage.service.shoppingCenter.impl;

import com.api.manage.dao.shoppingCenter.CategoryDao;
import com.api.manage.service.shoppingCenter.CategoryService;
import com.api.model.businessManagement.SysUser;
import com.api.model.shoppingCenter.Category;
import com.api.vo.shoppingCenter.CategoryVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static Map<String,Object> map = null;
    @Resource
    CategoryDao categoryDao;


    @Override
    public Map<String, Object> list(Integer parentId) {
        map = new HashMap<>();
        List<CategoryVo> categoryVoList = categoryDao.list(parentId);
        map.put("data",categoryVoList);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> insert(Category category) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        category.setCreateId(sysUser.getId());
        category.setCreateDate(new Date());
        int insert = categoryDao.insert(category);
        if (insert >0){
            map.put("message","添加成功");
            map.put("status",true);
        }else {
            map.put("message","添加失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> update(Category category) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        category.setModifyId(sysUser.getId());
        category.setModifyDate(new Date());
        int update = categoryDao.update(category);
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
    @Transactional
    public Map<String, Object> delete(Integer categoryId) {
        map = new HashMap<>();
        try {
            //根据商品分类全路径字段判断该类目存不存在商品信息

            //存在则不能删除，不存在则删除


            //删除子类目
            categoryDao.deleteSon(categoryId);

            int delete = categoryDao.delete(categoryId);
            if (delete < 0){
                throw new RuntimeException("删除失败");
            }
        } catch (Exception e) {
            //获取抛出的信息
            String message = e.getMessage();
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message",message);
            map.put("status",false);
            return map;
        }
        map.put("message","删除成功");
        map.put("status",true);
        return map;
    }
}
