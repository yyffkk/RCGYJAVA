package com.api.vo.butlerService;

import com.api.vo.resources.VoResourcesImg;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * 投票候选人信息 findById 回显
 */
public class VoFindByIdVoteCandidate {
    /**
     * 投票候选人主键id
     */
    private Integer id;
    /**
     * 投票管理主键id
     */
    private Integer voteId;
    /**
     * 选项名称
     */
    private String name;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 照片信息集合
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "VoFindByIdVoteCandidate{" +
                "id=" + id +
                ", voteId=" + voteId +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", imgUrls=" + imgUrls +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public VoFindByIdVoteCandidate() {
    }

    public VoFindByIdVoteCandidate(Integer id, Integer voteId, String name, String tel, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.voteId = voteId;
        this.name = name;
        this.tel = tel;
        this.imgUrls = imgUrls;
    }
}
