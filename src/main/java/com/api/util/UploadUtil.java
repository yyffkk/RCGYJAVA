package com.api.util;

import com.api.dao.resources.ResourcesImgDao;
import com.api.model.resources.ResourcesImg;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 上传文件(照片)工具类
 */
@Component
public class UploadUtil {
    @Resource
    ResourcesImgDao resourcesImgDao;
    @Value("${prop.upload}")
    private String UPLOAD;

    //解决工具类无法调用Dao层数据，数据为null
    //静态初始化当前类
    private static UploadUtil uploadUtil;
    //在方法上加上注解@PostConstruct,这样方法就会在bean初始化之后被spring容器执行
    @PostConstruct
    public void init(){
        //声明的静态类=this
        uploadUtil=this;
    }
    //service层或其他注入bean的调用 模版
    //int count = uploadUtil.resourcesImgDao.countByData(resourcesImg);

    //属性同理 private String UPLOAD;
    //uploadUtil.UPLOAD 的形式来调用


    /**
     * 文件上传并将路径存入数据库
     * @param file 上传文件
     * @param path 上传路径
     * @param tableName 表名称
     * @param id 数据所属id
     * @param typeName 类型名称
     * @param imgSize 图片大小
     * @param imgLongs 长（像素）
     * @param imgParagraph 宽（像素）
     *
     *                     // 服务器的真实路径
     * 		String realPath = request.getSession().getServletContext().getRealPath("/");
     */
    public void upload(MultipartFile file,String path,String tableName,int id,String typeName,
                        String imgSize,int imgLongs,int imgParagraph){
        //如果文件为空，则直接退出该方法，不上传
        if (file == null){
            return;
        }
        if (file.getSize() > 1024 * 1024 * 10) {
            throw new RuntimeException("文件大小不能大于10M");
        }
        //获取文件后缀
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1, file.getOriginalFilename().length());
        if (!"jpg,jpeg,gif,png".toUpperCase().contains(suffix.toUpperCase())) {
            throw new RuntimeException("请选择jpg,jpeg,gif,png格式的图片");
        }
        //加上前置路径
        String savePath = uploadUtil.UPLOAD + path;
        //获取保存路径
        File savePathFile = new File(savePath);
        if (!savePathFile.exists()) {
            //若不存在该目录，则创建目录
            savePathFile.mkdir();
        }
        //通过UUID生成唯一文件名
        String filename = UUID.randomUUID().toString().replaceAll("-","") + "." + suffix;
        try {
            //将文件保存指定目录
            file.transferTo(new File(savePath + filename));
            //保存后，将文件路径存入数据库
            ResourcesImg resourcesImg = new ResourcesImg();
            //填入表名称
            resourcesImg.setTableName(tableName);
            //填入数据所属id
            resourcesImg.setDateId(id);
            //填入类型名称
            resourcesImg.setTypeName(typeName);
            //填入图片路径
            resourcesImg.setUrl(savePath + filename);
            resourcesImg.setSize(imgSize);
            resourcesImg.setLongs(imgLongs);
            resourcesImg.setParagraph(imgParagraph);
            //查询该表，该类型名称的照片数量
            int count = uploadUtil.resourcesImgDao.countByData(resourcesImg);
            if (count > 0){
                resourcesImg.setSort(count+1);
            }else {
                resourcesImg.setSort(1);
            }
            //添加该照片数据到数据库中
            int insert2 = uploadUtil.resourcesImgDao.insert(resourcesImg);
            if (insert2 <= 0){
                throw new RuntimeException("添加照片数据失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("保存文件异常");
        }
    }


    /**
     * 删除上传文件并删除对应数据库资源文件数据
     * @param tableName 表名称
     * @param id 数据所属id
     * @param typeName 类型名称
     */
    public void delete(String tableName, int id, String typeName){
        ResourcesImg resourcesImg = new ResourcesImg();
        //填入表名称
        resourcesImg.setTableName(tableName);
        //填入数据所属id
        resourcesImg.setDateId(id);
        //填入类型名称
        resourcesImg.setTypeName(typeName);
        //根据条件查询图片资源信息
        List<VoResourcesImg> imgByDate = uploadUtil.resourcesImgDao.findImgByDate(resourcesImg);
        if (imgByDate != null && imgByDate.size()>0){
            for (VoResourcesImg voResourcesImg : imgByDate) {
                //加上前置路径
                String savePath = uploadUtil.UPLOAD + voResourcesImg.getUrl();
                //获取保存路径
                File savePathFile = new File(savePath);
                //删除对应文件
                boolean delete = savePathFile.delete();
                if (!delete){
                    throw new RuntimeException("文件删除失败");
                }
            }
            //删除数据库数据
            int delete = uploadUtil.resourcesImgDao.deleteImgByDate(resourcesImg);
            if (delete <= 0){
                throw new RuntimeException("数据库资源删除失败");
            }
        }
    }


    /**
     * 根据条件查询照片信息集合
     * @param tableName 表名称
     * @param dateId 数据所属id
     * @param typeName 类型名称
     * @return 照片信息集合
     */
    public List<VoResourcesImg> findImgByDate(String tableName,Integer dateId,String typeName){
        ResourcesImg resourcesImg = new ResourcesImg();
        //填入表名称
        resourcesImg.setTableName(tableName);
        //填入数据所属id
        resourcesImg.setDateId(dateId);
        //填入类型名称
        resourcesImg.setTypeName(typeName);
        //根据条件查询照片信息集合
        return uploadUtil.resourcesImgDao.findImgByDate(resourcesImg);
    }


    /**
     * 上传doc，docx文件
     * @param file doc,docx文件
     * @param path 上传路径
     * @return 上传路径+文件名
     */
    public String uploadDoc(MultipartFile file,String path){
        //如果文件为空，则返回""
        if (file == null){
            return "";
        }
        if (file.getSize() > 1024 * 1024 * 10) {
            throw new RuntimeException("文件大小不能大于10M");
        }
        //获取文件后缀
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1, file.getOriginalFilename().length());
        if (!"doc,docx".toUpperCase().contains(suffix.toUpperCase())) {
            throw new RuntimeException("请选择doc,docx格式的文件");
        }
        //加上前置路径
        String savePath = uploadUtil.UPLOAD + path;
        //获取保存路径
        File savePathFile = new File(savePath);
        if (!savePathFile.exists()) {
            //若不存在该目录，则创建目录
            savePathFile.mkdir();
        }
        //通过UUID生成唯一文件名
        String filename = UUID.randomUUID().toString().replaceAll("-","") + "." + suffix;
        //将文件保存指定目录
        try {
            file.transferTo(new File(savePath + filename));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("保存文件异常");
        }
        return path+filename;
    }

    public void deleteDoc(String path){
        //如果路径为""，则返回，不进行删除操作
        if (path.trim().equals("")){
            return;
        }
        //加上前置路径
        String savePath = uploadUtil.UPLOAD + path;
        //获取保存路径
        File savePathFile = new File(savePath);
        //删除对应文件
        boolean delete = savePathFile.delete();
        if (!delete){
            throw new RuntimeException("文件删除失败");
        }
    }
}

