package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerRepairDao;
import com.api.butlerApp.service.jurisdiction.ButlerRepairService;
import com.api.model.butlerApp.ButlerRepairSearch;
import com.api.model.butlerApp.ButlerUserIdAndRepairId;
import com.api.util.UploadUtil;
import com.api.vo.app.IdAndName;
import com.api.vo.butlerApp.*;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ButlerRepairServiceImpl implements ButlerRepairService {
    @Resource
    ButlerRepairDao butlerRepairDao;
    private static Map<String,Object> map = null;

    @Override
    public List<ButlerRepairVo> list(ButlerRepairSearch butlerRepairSearch) {
        //查询用户所属权限,type:1.派单人 2.维修人 3.其他角色
        int type = findJurisdictionByUserId(butlerRepairSearch.getRoleId());
        List<ButlerRepairVo> butlerRepairVos = new ArrayList<>();
        switch (type){
            case 1:
                //派单人界面
                butlerRepairVos = butlerRepairDao.list1(butlerRepairSearch);
                break;
            case 2:
                //接单人界面
                butlerRepairVos = butlerRepairDao.list2(butlerRepairSearch);
                break;
            case 3:
                //其他人界面
                butlerRepairVos = butlerRepairDao.list3(butlerRepairSearch);
                break;
            default:
                //系统错误
                break;
        }
        if (butlerRepairVos != null && butlerRepairVos.size()>0){
            for (ButlerRepairVo butlerRepairVo : butlerRepairVos) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sys_report_repair", butlerRepairVo.getId(), "repairImg");
                butlerRepairVo.setImgUrls(imgByDate);
                butlerRepairVo.setType(type);
            }
        }
        return butlerRepairVos;
    }

    @Override
    public Map<String, Object> findById(Integer repairId, Integer id, String roleIds) {
        map = new HashMap<>();
        int type = findJurisdictionByUserId(roleIds);
        ButlerUserIdAndRepairId butlerUserIdAndRepairId = new ButlerUserIdAndRepairId();
        butlerUserIdAndRepairId.setId(id);
        butlerUserIdAndRepairId.setRepairId(repairId);
        ButlerRepairFindByIdVo butlerRepairFindByIdVo = null;
        ButlerDispatchTypeVo butlerDispatchTypeVo = null;

        switch (type){
            case 1:
                //派单人界面
                //根据用户主键id 和 报事报修主键id 查询报修详情
                butlerRepairFindByIdVo = butlerRepairDao.findById(butlerUserIdAndRepairId);
                //根据用户主键id 和 报事报修主键id 查询工单类型
                butlerDispatchTypeVo = butlerRepairDao.findDispatchTypeById(butlerUserIdAndRepairId);
                break;
            case 2:
                //接单人界面
                //根据用户主键id 和 报事报修主键id 查询报修详情
                butlerRepairFindByIdVo = butlerRepairDao.findById2(butlerUserIdAndRepairId);
                //根据用户主键id 和 报事报修主键id 查询工单类型
                butlerDispatchTypeVo = butlerRepairDao.findDispatchTypeById2(butlerUserIdAndRepairId);
                break;
            case 3:
                //其他人界面
                //根据用户主键id 和 报事报修主键id 查询报修详情
                butlerRepairFindByIdVo = butlerRepairDao.findById3(repairId);
                //根据用户主键id 和 报事报修主键id 查询工单类型
                butlerDispatchTypeVo = butlerRepairDao.findDispatchTypeById3(repairId);
                break;
            default:
                //系统错误
                break;
        }
        if (butlerRepairFindByIdVo != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sys_report_repair", butlerRepairFindByIdVo.getId(), "repairImg");
            butlerRepairFindByIdVo.setImgUrls(imgByDate);
        }
        map.put("repairDetail",butlerRepairFindByIdVo);
        map.put("dispatchType",butlerDispatchTypeVo);

        //根据报修id查询报修进程
        List<ButlerProcessRecordVo> butlerProcessRecordVo = butlerRepairDao.findProcessRecord(repairId);
        map.put("processRecord",butlerProcessRecordVo);
        //当前用户角色类型 type:1.派单人 2.维修人 3.其他角色
        map.put("type",type);
        return map;
    }

    @Override
    public Map<String, Object> findWorkOrderTimeLimit() {
        map = new HashMap<>();
        List<IdAndName> workOrderTimeLimit = butlerRepairDao.findWorkOrderTimeLimit();
        map.put("data",workOrderTimeLimit);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findWorkOrderTypeDetail(Integer workOrderTypeId) {
        map = new HashMap<>();
        List<IdAndName> workOrderTypeDetail = butlerRepairDao.findWorkOrderTypeDetail(workOrderTypeId);
        map.put("data",workOrderTypeDetail);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findRepairOrganization(int repairOrganizationId) {
        map = new HashMap<>();
        //根据父组织查询子组织信息
        List<ButlerRepairOrganizationVo> organization = butlerRepairDao.findRepairOrganization(repairOrganizationId);
        if (organization!= null && organization.size()>0){
            for (ButlerRepairOrganizationVo organizationVo : organization) {
                //根据组织id查询维修人信息
                List<ButlerRepairmanVo> butlerRepairmanVos = butlerRepairDao.findRepairman(organizationVo.getId());
                organizationVo.setRepairmanVos(butlerRepairmanVos);
            }
        }

        map.put("data",organization);
        map.put("message","请求成功");
        map.put("status",true);
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
                    //52.派单
                    if (jurisdictionIds.contains(52)){
                        return 1;
                    }
                    //53.接单
                    if (jurisdictionIds.contains(53)){
                        return 2;
                    }
                }
            }
        }
        return 3;
    }
}
