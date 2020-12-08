package com.api.model.butlerService;

/**
 * 装修门禁卡关联信息表
 */
public class UserDecorationAccessCard {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 装修信息id
     */
    private Integer decorationId;
    /**
     * 门禁卡id
     */
    private Integer accessCardId;
    /**
     * 是否归还，0归还，1未归还
     */
    private Integer idReturn;

    @Override
    public String toString() {
        return "UserDecorationAccessCard{" +
                "id=" + id +
                ", decorationId=" + decorationId +
                ", accessCardId=" + accessCardId +
                ", idReturn=" + idReturn +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDecorationId() {
        return decorationId;
    }

    public void setDecorationId(Integer decorationId) {
        this.decorationId = decorationId;
    }

    public Integer getAccessCardId() {
        return accessCardId;
    }

    public void setAccessCardId(Integer accessCardId) {
        this.accessCardId = accessCardId;
    }

    public Integer getIdReturn() {
        return idReturn;
    }

    public void setIdReturn(Integer idReturn) {
        this.idReturn = idReturn;
    }

    public UserDecorationAccessCard() {
    }

    public UserDecorationAccessCard(Integer id, Integer decorationId, Integer accessCardId, Integer idReturn) {
        this.id = id;
        this.decorationId = decorationId;
        this.accessCardId = accessCardId;
        this.idReturn = idReturn;
    }
}
