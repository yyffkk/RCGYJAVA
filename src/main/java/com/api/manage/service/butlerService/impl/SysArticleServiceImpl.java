package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.BorrowDao;
import com.api.manage.dao.butlerService.SysArticleDao;
import com.api.manage.dao.resources.ResourcesImgDao;
import com.api.manage.service.butlerService.BorrowService;
import com.api.model.butlerService.Article;
import com.api.model.butlerService.ArticleDetail;
import com.api.model.butlerService.SearchArticle;
import com.api.model.butlerService.SearchArticleDetail;
import com.api.model.resources.ResourcesImg;
import com.api.model.businessManagement.SysUser;
import com.api.manage.service.butlerService.SysArticleService;
import com.api.util.UploadUtil;
import com.api.vo.butlerService.VoArticle;
import com.api.vo.butlerService.VoArticleDetail;
import com.api.vo.butlerService.VoFindByIdArticle;
import com.api.vo.butlerService.VoFindByIdArticleDetail;
import com.api.vo.resources.VoResourcesImg;
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
public class SysArticleServiceImpl implements SysArticleService {
    private static Map<String,Object> map = null;
    @Resource
    SysArticleDao sysArticleDao;
    @Resource
    ResourcesImgDao resourcesImgDao;
    @Resource
    BorrowDao borrowDao;

    @Override
    public List<VoArticle> list(SearchArticle searchArticle) {
        List<VoArticle> list = sysArticleDao.list(searchArticle);
        if (list != null && list.size()>0){
            for (VoArticle voArticle : list) {
                //根据物品id查询物品借取数
                int num = borrowDao.countBorrowNum(voArticle.getId());
                //库存 = 数量 - 借取数
                voArticle.setStock(voArticle.getQuantity() - num);
            }
        }
        return list;
    }

    @Override
    public List<VoResourcesImg> findImgById(Integer id) {
        ResourcesImg resourcesImg = new ResourcesImg();
        //填入表名称
        resourcesImg.setTableName("sysArticle");
        //填入数据所属id
        resourcesImg.setDateId(id);
        //填入类型名称
        resourcesImg.setTypeName("articleImg");
        //查询照片资源集合
        List<VoResourcesImg> imgByDate = resourcesImgDao.findImgByDate(resourcesImg);
        return imgByDate;
    }

    @Override
    public List<VoArticleDetail> listDetail(SearchArticleDetail searchArticleDetail) {
        return sysArticleDao.listDetail(searchArticleDetail);
    }

    @Override
    public Map<String, Object> insert(Article article) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            //填入创建人
            article.setCreateId(sysUser.getId());
            //填入创建时间
            article.setCreateDate(new Date());
            //添加物品信息
            int insert = sysArticleDao.insert(article);
            if (insert <= 0){
                throw new RuntimeException("添加物品信息失败");
            }

            //上传文件
            UploadUtil uploadUtil = new UploadUtil();
            //添加照片信息进入数据库
            uploadUtil.saveUrlToDB(article.getFileUrls(),"sysArticle",article.getId(),"articleImg","600",30,20);


            //获取传入的物品明细信息
            List<ArticleDetail> articleDetailList = article.getArticleDetailList();
            if (articleDetailList != null && articleDetailList.size()>0){
                for (ArticleDetail articleDetail : articleDetailList) {
                    //填入物品id
                    articleDetail.setArticleId(article.getId());
                    //如果物品明细名称没填，则系统自动填，与物品总类名称相同
                    if (articleDetail.getName() == null){
                        articleDetail.setName(article.getName());
                    }
                    //填入物品状态
                    articleDetail.setStatus(1);
                    //填入创建人
                    articleDetail.setCreateId(sysUser.getId());
                    //填入创建时间
                    articleDetail.setCreateDate(new Date());
                    //添加物品明细信息
                    int insert2 = sysArticleDao.insertDetail(articleDetail);
                    if (insert2 <= 0){
                        throw new RuntimeException("添加物品明细信息失败");
                    }

                    //上传物品明细照片
                    uploadUtil.saveUrlToDB(articleDetail.getFileUrls(),"sysArticleDetail",articleDetail.getId(),"sysArticleDetailImg","600",30,20);
                }
            }
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
        map.put("message","添加物品信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public VoFindByIdArticle findById(Integer id) {
        UploadUtil uploadUtil = new UploadUtil();
        //根据物品主键id查询物品信息
        VoFindByIdArticle voFindByIdArticle = sysArticleDao.findById(id);
        //根据物品主键id查询物品明细信息
        List<VoFindByIdArticleDetail> articleDetail = sysArticleDao.findDetailById(id);
        if (articleDetail != null && articleDetail.size()>0){
            for (VoFindByIdArticleDetail voFindByIdArticleDetail : articleDetail) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysArticleDetail", voFindByIdArticleDetail.getId(), "sysArticleDetailImg");
                voFindByIdArticleDetail.setImgUrl(imgByDate);
            }
        }
        //填入物品明细信息
        voFindByIdArticle.setVoFindByIdArticleDetailList(articleDetail);
        //查询照片信息
        List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysArticle", id, "articleImg");
        //填入照片信息
        voFindByIdArticle.setImgUrl(imgByDate);
        return voFindByIdArticle;
    }

    @Override
    @Transactional
    public Map<String, Object> update(Article article) {
        map = new HashMap<>();
        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();
            //填入修改人
            article.setModifyId(sysUser.getId());
            //填入修改时间
            article.setModifyDate(new Date());
            //更新物品信息
            int update = sysArticleDao.update(article);
            if (update <= 0){
                throw new RuntimeException("更新物品信息失败");
            }

            //更新照片信息
            UploadUtil uploadUtil = new UploadUtil();
            //先删除照片信息
            uploadUtil.delete("sysArticle",article.getId(),"articleImg");
            //再添加照片信息
            uploadUtil.saveUrlToDB(article.getFileUrls(),"sysArticle",article.getId(),"articleImg","600",30,20);

            //更新物品明细信息(无删除)
            //获取传入的物品明细信息
            List<ArticleDetail> articleDetailList = article.getArticleDetailList();
            if (articleDetailList != null && articleDetailList.size()>0){
                for (ArticleDetail articleDetail : articleDetailList) {
                    //先删除照片信息
                    uploadUtil.delete("sysArticleDetail",articleDetail.getId(),"sysArticleDetail");

                    //如果物品明细名称没填，则系统自动填，与物品总类名称相同
                    if (articleDetail.getName() == null){
                        articleDetail.setName(article.getName());
                    }
                    //根据id来决定是添加还是更新物品明细信息
                    if (articleDetail.getId() != null){
                        //更新物品明细信息
                        //填入修改人id
                        articleDetail.setModifyId(sysUser.getId());
                        //填入修改时间
                        articleDetail.setModifyDate(new Date());
                        //更新物品明细信息
                        int update2 = sysArticleDao.updateDetail(articleDetail);
                        if (update2 <= 0){
                            throw new RuntimeException("修改物品明细信息失败");
                        }
                    }else {
                        //添加物品明细信息
                        //填入物品id
                        articleDetail.setArticleId(article.getId());
                        //填入物品状态
                        articleDetail.setStatus(1);
                        //填入创建人
                        articleDetail.setCreateId(sysUser.getId());
                        //填入创建时间
                        articleDetail.setCreateDate(new Date());
                        //添加物品明细信息
                        int insert2 = sysArticleDao.insertDetail(articleDetail);
                        if (insert2 <= 0){
                            throw new RuntimeException("添加物品明细信息失败");
                        }
                    }
                    //再添加照片信息
                    uploadUtil.saveUrlToDB(articleDetail.getFileUrls(),"sysArticleDetail",articleDetail.getId(),"sysArticleDetailImg","600",30,20);

                }
            }
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
        map.put("message","更新物品信息成功");
        map.put("status",true);
        return map;
    }
}
