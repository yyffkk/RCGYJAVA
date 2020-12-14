package com.api.controller.butlerService;

import com.api.model.butlerService.Article;
import com.api.model.butlerService.SearchArticle;
import com.api.model.butlerService.SearchArticleDetail;
import com.api.service.butlerService.SysArticleService;
import com.api.vo.butlerService.VoArticle;
import com.api.vo.butlerService.VoArticleDetail;
import com.api.vo.butlerService.VoFindByIdArticle;
import com.api.vo.resources.VoResourcesImg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 物品管理表
 */
@RestController
@RequestMapping("article")
public class SysArticleController {
    @Resource
    SysArticleService sysArticleService;

    /**
     * 查询所有的物品管理信息 （包含条件搜索）[全部]
     * @param searchArticle 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchArticle searchArticle){
        PageHelper.startPage(searchArticle.getPageNum(),searchArticle.getSize());
        List<VoArticle> voArticleList = sysArticleService.list(searchArticle);
        PageInfo<VoArticle> pageInfo = new PageInfo<>(voArticleList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询所有的物品明细管理信息 （包含条件搜索）[1.正常，2.破损]
     * @param searchArticleDetail 搜索条件
     * @return map
     */
    @GetMapping("/listDetail")
    public Map<String,Object> listDetail(SearchArticleDetail searchArticleDetail){
        PageHelper.startPage(searchArticleDetail.getPageNum(),searchArticleDetail.getSize());
        List<VoArticleDetail> voArticleDetailList = sysArticleService.listDetail(searchArticleDetail);
        PageInfo<VoArticleDetail> pageInfo = new PageInfo<>(voArticleDetailList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据物品主键id查询物品照片信息
     * @param id 物品主键id
     * @return 物品照片信息集合
     */
    @GetMapping("/findImgById")
    public List<VoResourcesImg> findImgById(Integer id){
        return sysArticleService.findImgById(id);
    }


    /**
     * 添加物品信息
     * @param article 物品信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody Article article){
        return sysArticleService.insert(article);
    }

    /**
     * 根据物品主键id查询物品信息
     * @param id 物品主键id
     * @return 物品信息
     */
    @GetMapping("/findById")
    public VoFindByIdArticle findById(Integer id){
        return sysArticleService.findById(id);
    }

    /**
     * 更新物品信息
     * @param article 新物品信息
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody Article article){
        return sysArticleService.update(article);
    }

//    /**
//     * 打印二维码
//     * @return
//     */
//    @GetMapping("/getQRCode")
//    public Map<String,Object> getQRCode(){
//        return sysArticleService.getQRCode();
//    }



}
