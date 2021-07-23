package com.api.util;

import com.api.manage.dao.butlerService.SysProhibitedKeywordsDao;
import com.api.model.butlerService.SearchProhibitedKeywords;
import com.api.vo.butlerService.VoProhibitedKeywords;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * 替换关键字工具类
 */
@Component
public class ReplaceKeywordsUtil {

    @Resource
    SysProhibitedKeywordsDao sysProhibitedKeywordsDao;

    //解决工具类无法调用Dao层数据，数据为null
    //静态初始化当前类
    private static ReplaceKeywordsUtil replaceKeywordsUtil;
    //在方法上加上注解@PostConstruct,这样方法就会在bean初始化之后被spring容器执行
    @PostConstruct
    public void init(){
        //声明的静态类=this
        replaceKeywordsUtil=this;
    }

    //替换违禁关键字[目前空格无法解决]（后续优化成DFA算法）
    public String replaceProhibitedKeywords(String content){
        List<VoProhibitedKeywords> list = replaceKeywordsUtil.sysProhibitedKeywordsDao.list(new SearchProhibitedKeywords());
        if (list != null){
            for (VoProhibitedKeywords voProhibitedKeywords : list) {
                //替换违禁关键字
                if (content.contains(voProhibitedKeywords.getKeywords())){
                    content = content.replaceAll(voProhibitedKeywords.getKeywords(), voProhibitedKeywords.getReplaces());
                }
            }
        }
        return content;
    }
}
