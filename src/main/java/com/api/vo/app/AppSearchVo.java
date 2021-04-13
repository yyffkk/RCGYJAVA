package com.api.vo.app;

import java.util.List;

/**
 * 首页全局搜索，搜索信息
 */
public class AppSearchVo {
    /**
     * 社区活动信息集合
     */
    private List<AppActivityVo> activityVoList;
    /**
     * 帖子活动信息集合
     */
    private List<AppGambitVo> gambitVoList;

    @Override
    public String toString() {
        return "AppSearchVo{" +
                "activityVoList=" + activityVoList +
                ", gambitVoList=" + gambitVoList +
                '}';
    }

    public List<AppActivityVo> getActivityVoList() {
        return activityVoList;
    }

    public void setActivityVoList(List<AppActivityVo> activityVoList) {
        this.activityVoList = activityVoList;
    }

    public List<AppGambitVo> getGambitVoList() {
        return gambitVoList;
    }

    public void setGambitVoList(List<AppGambitVo> gambitVoList) {
        this.gambitVoList = gambitVoList;
    }

    public AppSearchVo() {
    }

    public AppSearchVo(List<AppActivityVo> activityVoList, List<AppGambitVo> gambitVoList) {
        this.activityVoList = activityVoList;
        this.gambitVoList = gambitVoList;
    }
}
