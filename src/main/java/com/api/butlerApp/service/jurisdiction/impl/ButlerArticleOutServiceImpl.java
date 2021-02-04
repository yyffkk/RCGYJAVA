package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerArticleOutDao;
import com.api.butlerApp.dao.jurisdiction.ButlerRepairDao;
import com.api.butlerApp.service.jurisdiction.ButlerArticleOutService;
import com.api.model.butlerApp.ButlerArticleOutNoRelease;
import com.api.model.butlerApp.ButlerArticleOutRelease;
import com.api.model.butlerApp.ButlerArticleOutSearch;
import com.api.util.UploadUtil;
import com.api.vo.butlerApp.ButlerAOFindByIdVo;
import com.api.vo.butlerApp.ButlerArticleOutVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ButlerArticleOutServiceImpl implements ButlerArticleOutService {
    @Resource
    ButlerArticleOutDao butlerArticleOutDao;
    @Resource
    ButlerRepairDao butlerRepairDao;
    private static Map<String,Object> map = null;

    @Override
    public List<ButlerArticleOutVo> list(ButlerArticleOutSearch articleOutSearch) {
        return butlerArticleOutDao.list(articleOutSearch);
    }

    @Override
    public Map<String, Object> findById(Integer articleOutId, String roleId) {
        map = new HashMap<>();
        //查询用户所属权限,type:1.保安角色 3.其他角色
        int type = findJurisdictionByUserId(roleId);
        //根据物品出户主键id查询出户详情
        ButlerAOFindByIdVo findByIdVo = butlerArticleOutDao.findById(articleOutId);
        if (findByIdVo != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("userArticleOut", articleOutId, "goodsImg");
            findByIdVo.setImgUrls(imgByDate);
        }
        map.put("type",type);
        map.put("data",findByIdVo);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> release(ButlerArticleOutRelease articleOutRelease, Integer id, String roleId) {
        map = new HashMap<>();
        //查询用户所属权限,type:1.保安角色 3.其他角色
        int type = findJurisdictionByUserId(roleId);
        if (type != 1){
            map.put("message","您没有该权限");
            map.put("status",false);
            return map;
        }

        articleOutRelease.setStatus(2);
        articleOutRelease.setActualTime(new Date());
        articleOutRelease.setReviewId(id);
        articleOutRelease.setReviewDate(new Date());
        int update = butlerArticleOutDao.release(articleOutRelease);
        if (update >0){
            map.put("message","放行成功");
            map.put("status",true);
        }else {
            map.put("message","放行失败");
            map.put("status",false);
        }

        return map;
    }

    @Override
    public Map<String, Object> noRelease(ButlerArticleOutNoRelease articleOutNoRelease, Integer id, String roleId) {
        map = new HashMap<>();
        //查询用户所属权限,type:1.保安角色 3.其他角色
        int type = findJurisdictionByUserId(roleId);
        if (type != 1){
            map.put("message","您没有该权限");
            map.put("status",false);
            return map;
        }

        articleOutNoRelease.setStatus(2);
        articleOutNoRelease.setReviewId(id);
        articleOutNoRelease.setReviewDate(new Date());
        int update = butlerArticleOutDao.noRelease(articleOutNoRelease);
        if (update >0){
            map.put("message","操作成功");
            map.put("status",true);
        }else {
            map.put("message","操作失败");
            map.put("status",false);
        }
        return map;
    }


    private int findJurisdictionByUserId(String roleIds) {
        String[] split = roleIds.split(",");
        if (split.length >0){
            for (String s : split) {
                int roleId = Integer.parseInt(s);
                //根据角色id查询权限id集合
                List<Integer> jurisdictionIds = butlerRepairDao.findJIdsByRoleId(roleId);
                if (jurisdictionIds != null && jurisdictionIds.size()>0){
                    //55.放行
                    if (jurisdictionIds.contains(55)){
                        return 1;
                    }
                }
            }
        }
        return 3;
    }
}
