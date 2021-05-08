package com.api.manage.service.shoppingCenter.impl;

import com.api.manage.dao.shoppingCenter.SupplierDao;
import com.api.manage.service.shoppingCenter.SupplierService;
import com.api.model.businessManagement.SysUser;
import com.api.model.shoppingCenter.Supplier;
import com.api.model.shoppingCenter.SupplierSearch;
import com.api.util.IdWorker;
import com.api.util.UploadUtil;
import com.api.vo.resources.VoResourcesImg;
import com.api.vo.shoppingCenter.SupplierFBIVo;
import com.api.vo.shoppingCenter.SupplierVo;
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
public class SupplierServiceImpl implements SupplierService {
    private static Map<String,Object> map = null;
    @Resource
    SupplierDao supplierDao;

    @Override
    public List<SupplierVo> list(SupplierSearch supplierSearch) {
        return supplierDao.list(supplierSearch);
    }

    @Override
    @Transactional
    public Map<String, Object> insert(Supplier supplier) {
        map = new HashMap<>();
        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            supplier.setCreateId(sysUser.getId());
            supplier.setCreateDate(new Date());
            supplier.setIsDelete(1); //填写默认是否删除，1.非删
            supplier.setCode(String.valueOf(new IdWorker(1, 1, 1).nextId()));

            int insert = supplierDao.insert(supplier);
            if (insert <0){
                throw new RuntimeException("添加失败");
            }

            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(supplier.getImgUrls(),"shopSupplier",supplier.getId(),"supplierImg","600",20,30);
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
        map.put("message","添加成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findById(Integer id) {
        map = new HashMap<>();
        SupplierFBIVo supplierFBIVo = supplierDao.findById(id);
        if (supplierFBIVo != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("shopSupplier", supplierFBIVo.getId(), "supplierImg");
            supplierFBIVo.setImgList(imgByDate);
        }
        map.put("data",supplierFBIVo);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> update(Supplier supplier) {
        map = new HashMap<>();
        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            supplier.setModifyId(sysUser.getId());
            supplier.setModifyDate(new Date());

            int update = supplierDao.update(supplier);
            if (update <0){
                throw new RuntimeException("修改失败");
            }

            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.delete("shopSupplier",supplier.getId(),"supplierImg");
            uploadUtil.saveUrlToDB(supplier.getImgUrls(),"shopSupplier",supplier.getId(),"supplierImg","600",20,30);

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
        map.put("message","修改成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            UploadUtil uploadUtil = new UploadUtil();
            for (int id : ids) {

                //假删除商品信息
                int update = supplierDao.delete(id);
                if (update < 0){
                    throw new RuntimeException("删除失败");
                }
                uploadUtil.delete("shopSupplier",id,"supplierImg");
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
