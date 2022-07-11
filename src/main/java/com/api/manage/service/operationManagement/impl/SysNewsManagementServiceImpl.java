package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysNewsCategoryManagementDao;
import com.api.manage.dao.operationManagement.SysNewsManagementDao;
import com.api.manage.service.operationManagement.SysNewsCategoryManagementService;
import com.api.manage.service.operationManagement.SysNewsManagementService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.SearchNewsManagement;
import com.api.model.operationManagement.SettingNewsRotation;
import com.api.model.operationManagement.SysNewsManagement;
import com.api.util.IdWorker;
import com.api.util.UploadUtil;
import com.api.vo.operationManagement.VoFBINewsManagement;
import com.api.vo.operationManagement.VoNewsManagement;
import com.api.vo.resources.VoResourcesImg;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SysNewsManagementServiceImpl implements SysNewsManagementService {
    private static Map<String,Object> map = null;
    @Resource
    SysNewsManagementDao sysNewsManagementDao;
    @Resource
    SysNewsCategoryManagementDao sysNewsCategoryManagementDao;

    @Override
    public List<VoNewsManagement> list(SearchNewsManagement searchNewsManagement) {
        return sysNewsManagementDao.list(searchNewsManagement);
    }

    @Override
    @Transactional
    public Map<String, Object> insert(SysNewsManagement sysNewsManagement) {
        map = new HashMap<>();
        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            sysNewsManagement.setCode(String.valueOf(new IdWorker(1,1,1).nextId()));
            sysNewsManagement.setCreateId(sysUser.getId());
            sysNewsManagement.setCreateDate(new Date());
            sysNewsManagement.setIsRotation(0);//默认不轮播

            int insert = sysNewsManagementDao.insert(sysNewsManagement);
            if (insert <=0){
                throw new RuntimeException("添加失败");
            }
            //添加照片
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(sysNewsManagement.getImgUrls(),"sysNews",sysNewsManagement.getId(),"newsImg","600",20,30);

            //对资讯分类的资讯数量进行累加
            int update = sysNewsCategoryManagementDao.incNum(sysNewsManagement.getNewsCategoryId());
            if (update <= 0){
                throw new RuntimeException("累加失败");
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
        map.put("message","添加成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findById(Integer newsId) {
        map = new HashMap<>();
        VoFBINewsManagement voFBINewsManagement = sysNewsManagementDao.findById(newsId);
        if (voFBINewsManagement != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysNews", voFBINewsManagement.getId(), "newsImg");
            voFBINewsManagement.setImgList(imgByDate);
        }
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",voFBINewsManagement);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> update(SysNewsManagement sysNewsManagement) {
        map = new HashMap<>();
        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            sysNewsManagement.setModifyId(sysUser.getId());
            sysNewsManagement.setModifyDate(new Date());

            int update = sysNewsManagementDao.update(sysNewsManagement);
            if (update <= 0){
                throw new RuntimeException("修改失败");
            }

            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.delete("sysNews",sysNewsManagement.getId(),"newsImg");
            uploadUtil.saveUrlToDB(sysNewsManagement.getImgUrls(),"sysNews",sysNewsManagement.getId(),"newsImg","600",20,30);
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
                VoFBINewsManagement byId = sysNewsManagementDao.findById(id);
                if (byId == null){
                    throw new RuntimeException("删除资讯失败,资讯不存在");
                }

                //对资讯分类的资讯数量进行累减
                int update = sysNewsCategoryManagementDao.decNum(byId.getNewsCategoryId());
                if (update <= 0){
                    throw new RuntimeException("累减失败");
                }

                int delete = sysNewsManagementDao.delete(id);
                if (delete <=0 ){
                    throw new RuntimeException("删除资讯失败");
                }
                uploadUtil.delete("sysNews",id,"newsImg");
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
        map.put("message","删除资讯成功");
        map.put("status",true);
        return map;
    }

    @Override
    public int updateMedical() {
        int num = 0;//更新条数
        //爬取医药网列表页面
        Document doc = null;
        try {
            doc = Jsoup.connect("http://news.pharmnet.com.cn/").get();

            Element body = doc.body();
            Elements select = body.select(".jkjy dd ul li a");
            //创建map存储器
            HashMap<String, Object> map = new HashMap<>();
            for (Element element : select) {
                String href = element.attr("href");
                String text = element.text();
                //存进map中
                map.put(text,href);
            }

            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String mapKey = entry.getKey();
                Object mapValue = entry.getValue();
                log.info("标题：URl路径 ==》"+mapKey+":"+mapValue);

                //比对数据库是否拥有相同标题信息
                int count = sysNewsManagementDao.countByTitle(mapKey);
                if (count >0){
                    log.info("数据已存在，标题为："+mapKey);
                    //跳过当前循环,不添加该数据
                    continue;
                }

                //爬取医药网详情页
                Document doc2 = Jsoup.connect(String.valueOf(mapValue)).get();
                Element body2 = doc2.body();
                Elements select2 = body2.select(".maintext");
                String text = select2.text();
                if (text.length()>10000){
                    text = text.substring(0,10000);
                }
                log.info("文章内容："+text);

                //处理并保存数据到数据库
                SysNewsManagement sysNewsManagement = new SysNewsManagement();
                sysNewsManagement.setCode(String.valueOf(new IdWorker(1,1,1).nextId()));
                sysNewsManagement.setTitle(mapKey);
                sysNewsManagement.setContent(text);
                sysNewsManagement.setNewsCategoryId(18);//18.医药网
                sysNewsManagement.setCreateId(-1);//-1:外部发布
                sysNewsManagement.setCreateDate(new Date());

                //对资讯分类的资讯数量进行累加
                int update = sysNewsCategoryManagementDao.incNum(sysNewsManagement.getNewsCategoryId());
                if (update <= 0){
                    log.info("累加失败");
                    continue;
                }
                //保存数据到数据库
                sysNewsManagementDao.insert(sysNewsManagement);

                log.info("资讯分类的资讯数量累加成功");
                log.info("数据已保存到数据库，标题为："+mapKey);
                num = num + 1;//累加更新条数
            }
            log.info("信息爬取成功");

        } catch (IOException e) {
            log.info("网站请求异常");
        }
        return num;
    }

    @Override
    public int updateEducation() {
        int num = 0;//更新条数
        //爬取医药网列表页面
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.chsi.com.cn/jyzx").get();

            Element body = doc.body();
            Elements select = body.select(".content-l .news-list .news-title a");
            //创建map存储器
            HashMap<String, Object> map = new HashMap<>();
            for (Element element : select) {
                String href = element.attr("href");
                String text = element.text();
                //存进map中
                map.put(text,href);
            }

            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String mapKey = entry.getKey();
                Object mapValue = entry.getValue();
                log.info("标题：URl路径 ==》"+mapKey+":"+mapValue);

                //比对数据库是否拥有相同标题信息
                int count = sysNewsManagementDao.countByTitle(mapKey);
                if (count >0){
                    log.info("数据已存在，标题为："+mapKey);
                    //跳过当前循环,不添加该数据
                    continue;
                }

                //爬取医药网详情页
                Document doc2 = Jsoup.connect("https://www.chsi.com.cn"+mapValue).get();
                Element body2 = doc2.body();
                Elements select2 = body2.select(".content-l");
                String text = select2.text();
                if (text.length()>10000){
                    text = text.substring(0,10000);
                }
                log.info("文章内容："+text);

                //处理并保存数据到数据库
                SysNewsManagement sysNewsManagement = new SysNewsManagement();
                sysNewsManagement.setCode(String.valueOf(new IdWorker(1,1,1).nextId()));
                sysNewsManagement.setTitle(mapKey);
                sysNewsManagement.setContent(text);
                sysNewsManagement.setNewsCategoryId(19);//19.学信网
                sysNewsManagement.setCreateId(-1);//-1:外部发布
                sysNewsManagement.setCreateDate(new Date());

                //对资讯分类的资讯数量进行累加
                int update = sysNewsCategoryManagementDao.incNum(sysNewsManagement.getNewsCategoryId());
                if (update <= 0){
                    log.info("累加失败");
                    continue;
                }
                //保存数据到数据库
                sysNewsManagementDao.insert(sysNewsManagement);

                log.info("资讯分类的资讯数量累加成功");
                log.info("数据已保存到数据库，标题为："+mapKey);
                num = num + 1;//累加更新条数
            }
            log.info("信息爬取成功");

        } catch (IOException e) {
            log.info("网站请求异常");
        }
        return num;
    }

    @Override
    public Map<String, Object> settingRotation(SettingNewsRotation settingNewsRotation) {
        map = new HashMap<>();

        if (settingNewsRotation.getIsRotation() == 1){
            //查询已经设置的轮播的数量
            int num = sysNewsManagementDao.findSettingRotation();
            if (num >= 4){
                map.put("message","设置数量已达到最大值");
                map.put("status",false);
                return map;
            }
        }

        int update = sysNewsManagementDao.settingRotation(settingNewsRotation);
        if (update >0 ){
            map.put("message","设置成功");
            map.put("status",true);
        }else {
            map.put("message","设置失败");
            map.put("status",false);
        }
        return map;
    }
}
