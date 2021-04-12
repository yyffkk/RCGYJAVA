package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 物品归还信息
 */
public class AppArticleBorrowReturnVo {
    /**
     * 物品明细主键id
     */
    private Integer id;
    /**
     * 物品明细名称
     */
    private String name;
    /**
     * 物品单号
     */
    private String code;
    /**
     * 借出时间
     */
    private Date beginDate;
    /**
     * 借用时长
     */
    private Long borrowTime;
    /**
     * 物品明细照片资源
     */
    private List<VoResourcesImg> imgList;

    @Override
    public String toString() {
        return "AppArticleBorrowReturnVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", beginDate=" + beginDate +
                ", borrowTime=" + borrowTime +
                ", imgList=" + imgList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Long getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Long borrowTime) {
        this.borrowTime = borrowTime;
    }

    public List<VoResourcesImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<VoResourcesImg> imgList) {
        this.imgList = imgList;
    }

    public AppArticleBorrowReturnVo() {
    }

    public AppArticleBorrowReturnVo(Integer id, String name, String code, Date beginDate, Long borrowTime, List<VoResourcesImg> imgList) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.beginDate = beginDate;
        this.borrowTime = borrowTime;
        this.imgList = imgList;
    }
}
