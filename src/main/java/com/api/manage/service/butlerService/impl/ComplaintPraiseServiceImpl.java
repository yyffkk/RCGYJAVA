package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.basicArchives.UserResidentDao;
import com.api.manage.dao.butlerService.ComplaintPraiseDao;
import com.api.manage.dao.butlerService.SysProhibitedKeywordsDao;
import com.api.manage.dao.butlerService.UserAdviceDao;
import com.api.manage.dao.resources.ResourcesImgDao;
import com.api.manage.dao.system.SysLoginDao;
import com.api.model.basicArchives.UserResident;
import com.api.model.butlerService.SearchProhibitedKeywords;
import com.api.model.butlerService.SearchUserAdvice;
import com.api.model.butlerService.SysAdvice;
import com.api.model.resources.ResourcesImg;
import com.api.model.businessManagement.SysUser;
import com.api.manage.service.butlerService.ComplaintPraiseService;
import com.api.util.UploadUtil;
import com.api.vo.butlerService.VoFindByIdAdvice;
import com.api.vo.butlerService.VoProhibitedKeywords;
import com.api.vo.butlerService.VoUserAdvice;
import com.api.vo.butlerService.VoUserAdviceDetail;
import com.api.vo.resources.VoResourcesImg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

@Service
public class ComplaintPraiseServiceImpl implements ComplaintPraiseService {
    private static Map<String,Object> map = null;
    @Value("${prop.upload-advice}")
    private String UPLOAD_ADVICE;
    @Resource
    ComplaintPraiseDao complaintPraiseDao;
    @Resource
    UserAdviceDao userAdviceDao;
    @Resource
    ResourcesImgDao resourcesImgDao;
    @Resource
    UserResidentDao userResidentDao;
    @Resource
    SysLoginDao sysLoginDao;
    @Resource
    SysProhibitedKeywordsDao sysProhibitedKeywordsDao;

    @Override
    public List<VoUserAdvice> list(SearchUserAdvice searchUserAdvice) {
        return complaintPraiseDao.list(searchUserAdvice);
    }

    @Override
    public Map<String, Object> findById(Integer id) {
        map = new HashMap<>();
        //根据咨询建议主键id查询咨询建议信息
        VoFindByIdAdvice voFindByIdAdvice = userAdviceDao.findById(id);
        ResourcesImg resourcesImg = new ResourcesImg();
        //填入表名称 sysAdvice
        resourcesImg.setTableName("sysAdvice");
        //填入数据所属id
        resourcesImg.setDateId(id);
        //填入类型名称 投诉表扬照片：complaintPraiseImg
        resourcesImg.setTypeName("complaintPraiseImg");
        //根据咨询建议主键id查询照片信息集合
        List<VoResourcesImg> imgByDate = resourcesImgDao.findImgByDate(resourcesImg);
        if (imgByDate != null && imgByDate.size()>0){
            //填入照片信息集合
            voFindByIdAdvice.setImgUrl(imgByDate);
        }
        //根据咨询建议主键id查询反馈信息集合
        List<VoUserAdviceDetail> voUserAdviceDetailList = userAdviceDao.findByAdviceIdDetail(id);
        if (voUserAdviceDetailList != null && voUserAdviceDetailList.size()>0){
            for (VoUserAdviceDetail voUserAdviceDetail : voUserAdviceDetailList) {
                //如果创建人类型为住户 1.住户 跟住户关联查询创建人姓名
                if (voUserAdviceDetail.getCreateUserType() ==1 ){
                    //根据反馈信息中的反馈人id 关联住户查询反馈人姓名
                    UserResident byId = userResidentDao.findById(voUserAdviceDetail.getCreateId());
                    voUserAdviceDetail.setCreateName(byId.getName());
                }
                //如果创建人类型为物业 3.物业 跟物业关联查询创建人姓名
                if (voUserAdviceDetail.getCreateUserType() == 3){
                    //根据反馈信息中的反馈人id 关联物业查询反馈人真实姓名
                    SysUser byId = sysLoginDao.findById(voUserAdviceDetail.getCreateId());
                    voUserAdviceDetail.setCreateName(byId.getActualName());
                }

            }
            //填入反馈信息集合
            voFindByIdAdvice.setVoUserAdviceDetailList(voUserAdviceDetailList);
        }
        map.put("voFindByIdAdvice",voFindByIdAdvice);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> insertAdvice(SysAdvice sysAdvice, HttpServletRequest request) {
        map = new HashMap<>();
        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            //替换违禁关键字
            String content = replaceProhibitedKeywords(sysAdvice.getContent());
            sysAdvice.setContent(content);


            //填入初始点击数
            sysAdvice.setHits(0);
            //填入发布人id
            sysAdvice.setCreateId(sysUser.getId());
            //填入发布时间
            sysAdvice.setCreateDate(new Date());
            //填入发布人类型 1.住户
            sysAdvice.setCreateUserType(1);
            //填入是否删除 1.非删 0.删除
            sysAdvice.setIsDelete(1);
            //填入状态（1.未反馈，2.反馈中，3.已反馈）
            sysAdvice.setStatus(1);
            int insert =  userAdviceDao.insertAdvice(sysAdvice);
            if (insert<=0){
                throw new RuntimeException("新增投诉表扬失败");
            }

            UploadUtil uploadUtil = new UploadUtil();
            //上传文件到数据库
            uploadUtil.saveUrlToDB(sysAdvice.getFileUrls(),"sysAdvice",sysAdvice.getId(),"complaintPraiseImg","600",30,20);
        } catch (RuntimeException e) {
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


        map.put("message","新增投诉表扬成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> countComplaintNew() {
        map = new HashMap<>();
        Integer integer = complaintPraiseDao.countComplaintNew();
        map.put("countComplaintNew",integer);
        return map;
    }

    @Override
    public Map<String, Object> countPraiseNew() {
        map = new HashMap<>();
        Integer integer = complaintPraiseDao.countPraiseNew();
        map.put("countPraiseNew",integer);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                //根据咨询建议主键id删除反馈信息
                int delete1 = userAdviceDao.deleteDetail(id);
                if (delete1<=0){
                    throw new RuntimeException("批量删除反馈信息失败");
                }
                //根据咨询建议主键id删除资源照片信息
                ResourcesImg resourcesImg = new ResourcesImg();
                //填入表名称 sysAdvice
                resourcesImg.setTableName("sysAdvice");
                //填入数据所属id
                resourcesImg.setDateId(id);
                //填入类型名称 投诉建议照片：complaintPraiseImg
                resourcesImg.setTypeName("complaintPraiseImg");
                //根据条件删除照片信息
                int delete3 = resourcesImgDao.deleteImgByDate(resourcesImg);
                if (delete3<=0){
                    throw new RuntimeException("批量删除投诉建议照片失败");
                }
                //根据咨询建议主键id删除咨询建议信息
                int delete = userAdviceDao.delete(id);
                if (delete<=0){
                    throw new RuntimeException("批量删除投诉建议信息失败");
                }
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
        map.put("message","批量删除投诉建议信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> falseDelete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                int update = userAdviceDao.falseDelete(id);
                if (update <= 0){
                    throw new RuntimeException("批量删除投诉表扬信息失败");
                }
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
        map.put("message","批量删除投诉表扬信息成功，进入回收站");
        map.put("status",true);
        return map;
    }

    //替换违禁关键字[目前空格无法解决]（后续优化成DFA算法）
    public String replaceProhibitedKeywords(String content){
        List<VoProhibitedKeywords> list = sysProhibitedKeywordsDao.list(new SearchProhibitedKeywords());
        if (list != null){
            for (VoProhibitedKeywords voProhibitedKeywords : list) {
                //替换违禁关键字
                if (content.contains(voProhibitedKeywords.getKeywords())){
                    content.replace(voProhibitedKeywords.getKeywords(), voProhibitedKeywords.getReplaces());
                }
            }
        }
        return content;
    }
}
