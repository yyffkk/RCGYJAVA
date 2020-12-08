package com.api.controller.butlerService;

import com.api.model.butlerService.QRCodeContent;
import com.api.model.butlerService.SearchUserDecoration;
import com.api.model.butlerService.UserDecorationPersonnel;
import com.api.model.resources.ResourcesImg;
import com.api.service.butlerService.UserDecorationService;
import com.api.service.resources.ResourcesImgService;
import com.api.util.QRCodeUtil;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.*;
import com.api.vo.resources.VoResourcesImg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userDecoration")
public class UserDecorationController {
    @Resource
    UserDecorationService userDecorationService;
    @Resource
    ResourcesImgService resourcesImgService;

    /**
     * 查询装修信息（包含条件搜索）
     * @param searchUserDecoration 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchUserDecoration searchUserDecoration){
        PageHelper.startPage(searchUserDecoration.getPageNum(),searchUserDecoration.getSize());
        List<VoUserDecoration> voUserDecorationList =userDecorationService.list(searchUserDecoration);
        PageInfo<VoUserDecoration> pageInfo = new PageInfo<>(voUserDecorationList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 生成二维码
     * @param qrCodeContent 二维码参数
     * @return map （二维码路径）
     */
    @PostMapping("/createQRCode")
    public Map<String,Object> insert(@RequestBody QRCodeContent qrCodeContent){
        Map<String,Object> map = new HashMap<>();
        try {
            //二维码内容
            //https://mobile.baidu.com/item?docid=27624327&source=s1001
            String text = "http://www.baidu.com?qrCodeContent="+qrCodeContent;
            //不含Logo，不指定二维码图片名
            //content:内容  logoPath:LOGO地址   destPath：存放目录  needCompress：是否压缩LOGO
            //QRCodeUtil.encode(text, null, "e:\\", true);
            //含Logo，不指定二维码图片名
            //content:内容  logoPath:LOGO地址   destPath：存放目录  needCompress：是否压缩LOGO
            //QRCodeUtil.encode(text, "e:\\csdn.jpg", "e:\\", true);
            //含Logo，指定二维码图片名
            //content:内容  logoPath:LOGO地址   destPath：存放目录  fileName：二维码文件名  needCompress：是否压缩LOGO
            QRCodeUtil.encode(text, "src/main/resources/static/img/logo/QRCode.png", "src/main/resources/static/img/QRCode", "qrcode", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("imgUrl","二维码生成失败");
            return map;
        }
        map.put("imgUrl","/img/QRCode/qrcode.jpg");
        return map;
    }

    /**
     * 装修人员情况list
     * @param id 装修主键id
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/decorationPersonnelList")
    public Map<String,Object> decorationPersonnelList(Integer id,Integer pageNum,Integer size){
        PageHelper.startPage(pageNum,size);
        List<VoUserDecorationPersonnel> voUserDecorationPersonnelList = userDecorationService.decorationPersonnelList(id);
        PageInfo<VoUserDecorationPersonnel> pageInfo = new PageInfo<>(voUserDecorationPersonnelList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 显示所有门禁卡信息
     * @param id 装修主键id
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/userAccessCardList")
    public Map<String,Object> userAccessCardList(Integer id,Integer pageNum,Integer size){
        PageHelper.startPage(pageNum,size);
        List<VoUserAccessCard> voUserAccessCardList = userDecorationService.userAccessCardList(id);
        PageInfo<VoUserAccessCard> pageInfo = new PageInfo<>(voUserAccessCardList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询所有跟踪检查记录（跟踪人在sys_user里，sys_role里的主键id是2）
     * @param id 装修主键id
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/decorationTrackRecordList")
    public Map<String,Object> decorationTrackRecordList(Integer id,Integer pageNum,Integer size){
        PageHelper.startPage(pageNum,size);
        List<VoUserDecorationTrackRecord> voUserDecorationTrackRecordList = userDecorationService.decorationTrackRecordList(id);
        PageInfo<VoUserDecorationTrackRecord> pageInfo = new PageInfo<>(voUserDecorationTrackRecordList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询所有完工检查记录（检查人在sys_user里，sys_role里的主键id是3）
     * @param id 装修主键id
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/decorationFinishRecordList")
    public Map<String,Object> decorationFinishRecordList(Integer id,Integer pageNum,Integer size){
        PageHelper.startPage(pageNum,size);
        List<VoUserDecorationTrackRecord> voUserDecorationTrackRecordList = userDecorationService.decorationFinishRecordList(id);
        PageInfo<VoUserDecorationTrackRecord> pageInfo = new PageInfo<>(voUserDecorationTrackRecordList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 新增装修人员
     * @param userDecorationPersonnel 装修人员表信息
     * @return map
     */
    @PostMapping("/insertDecorationPersonnel")
    public Map<String,Object> insertDecorationPersonnel(@RequestBody UserDecorationPersonnel userDecorationPersonnel){
        return userDecorationService.insertDecorationPersonnel(userDecorationPersonnel);
    }


    /**
     * 批量删除装修人员信息
     * @param ids 装修人员主键id数组
     * @return map
     */
    @PostMapping("/deleteDecorationPersonnel")
    public Map<String,Object> deleteDecorationPersonnel(@RequestBody VoIds ids){
        return userDecorationService.deleteDecorationPersonnel(ids.getIds());
    }

    /**
     * 根据装修人员主键id查询装修人员信息
     * @param id 装修人员主键id
     * @return map
     */
    @GetMapping("/findByIdDecorationPersonnel")
    public Map<String,Object> findByIdDecorationPersonnel(Integer id){
        return userDecorationService.findByIdDecorationPersonnel(id);
    }

    /**
     * 修改装修人员信息
     * @param userDecorationPersonnel 新装修人员信息
     * @return map
     */
    @PostMapping("/updateDecorationPersonnel")
    public Map<String,Object> updateDecorationPersonnel(@RequestBody UserDecorationPersonnel userDecorationPersonnel){
        return userDecorationService.updateDecorationPersonnel(userDecorationPersonnel);
    }

    /**
     * 根据跟踪检查记录id查询装修跟踪检查记录结果照片
     * @param id 跟踪检查记录id
     * @return map
     */
    @GetMapping("/findTrackImg")
    public Map<String,Object> findTrackImg(Integer id){
        Map<String,Object> map = new HashMap<>();
        ResourcesImg resourcesImg = new ResourcesImg();
        //填入数据所属id
        resourcesImg.setDateId(id);
        //填入所属表名称
        resourcesImg.setTableName("userDecorationTrackRecord");
        //填入资源类型名称
        resourcesImg.setTypeName("trackImg");
        List<VoResourcesImg> resourcesImgList = resourcesImgService.findImgByDate(resourcesImg);
        map.put("resourcesImgList",resourcesImgList);
        return map;
    }

    /**
     * 根据完工检查记录id查询装修完工检查记录结果照片
     * @param id 完工检查记录id
     * @return map
     */
    @GetMapping("/findCheckImg")
    public Map<String,Object> findCheckImg(Integer id){
        Map<String,Object> map = new HashMap<>();
        ResourcesImg resourcesImg = new ResourcesImg();
        //填入数据所属id
        resourcesImg.setDateId(id);
        //填入所属表名称
        resourcesImg.setTableName("userDecorationTrackRecord");
        //填入资源类型名称
        resourcesImg.setTypeName("checkImg");
        List<VoResourcesImg> resourcesImgList = resourcesImgService.findImgByDate(resourcesImg);
        map.put("resourcesImgList",resourcesImgList);
        return map;
    }

    /**
     * 批量删除装修信息
     * @param ids 装修信息主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return userDecorationService.delete(ids.getIds());
    }

    /**
     * 批量作废装修信息
     * @param ids 装修信息主键id数组
     * @return map
     */
    @PostMapping("/invalid")
    public Map<String,Object> invalid(@RequestBody VoIds ids){
        return userDecorationService.invalid(ids.getIds());
    }

    /**
     * 查询今日预计发起装修数量
     * @return map
     */
    @GetMapping("/countDecorationNow")
    public Map<String,Object> countDecorationNow(){
        return userDecorationService.countDecorationNow();
    }

    /**
     * 查询未执行的家庭装修数量
     * @return map
     */
    @GetMapping("/countPerformed")
    public Map<String,Object> countPerformed(){
        return userDecorationService.countPerformed();
    }


}
