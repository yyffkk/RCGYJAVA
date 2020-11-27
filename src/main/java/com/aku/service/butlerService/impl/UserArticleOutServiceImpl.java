package com.aku.service.butlerService.impl;

import com.aku.dao.butlerService.UserArticleOutDao;
import com.aku.model.butlerService.SearchUserArticleOut;
import com.aku.service.butlerService.UserArticleOutService;
import com.aku.vo.basicArchives.VoDecoration;
import com.aku.vo.butlerService.VoUserArticleOut;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserArticleOutServiceImpl implements UserArticleOutService {
    @Resource
    UserArticleOutDao userArticleOutDao;

    @Override
    public List<VoUserArticleOut> list(SearchUserArticleOut searchUserArticleOut) {
        //初始化数组参数，长度为3，值都为null
        String[] split = {null,null,null};
        if (searchUserArticleOut.getRoomName()!=null){
            //去掉所有空格，以"-"截取字符串成数组
            String[] split2 = searchUserArticleOut.getRoomName().replace(" ", "").split("-");
            //如果数组长度超过3，超出部分不要
            for (int i =0;i<split2.length;i++) {
                //防止下标越界异常
                if (i<3){
                    split[i] = split2[i];
                }
            }
            //添加楼栋模糊查询信息,StringUtils.isNotBlank()【null，''】为true【' ','a',' a '】为false
            if (StringUtils.isNotBlank(split[0])){
                searchUserArticleOut.setBuildingNo(Integer.valueOf(split[0]));
            }
            //添加单元模糊查询信息
            if (StringUtils.isNotBlank(split[1])) {
                searchUserArticleOut.setUnitNo(Integer.valueOf(split[1]));
            }
            //添加房产模糊查询信息
            if (StringUtils.isNotBlank(split[2])) {
                searchUserArticleOut.setRoomNumber(split[2]);
            }
        }
        List<VoUserArticleOut> list = userArticleOutDao.list(searchUserArticleOut);
        //处理显示的roomName信息
        for (VoUserArticleOut voUserArticleOut : list) {
            voUserArticleOut.setRoomName(voUserArticleOut.getBuildingNo()+"-"+voUserArticleOut.getUnitNo()+"-"+voUserArticleOut.getRoomNumber());
        }
        return list;
    }
}
