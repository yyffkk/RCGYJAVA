package com.api.model.butlerApp;

/**
 * 管家app 钥匙主键id 和 借取人主键id
 */
public class ButlerKeyIdAndBorrowerId {
    /**
     * 钥匙主键id
     */
    private Integer keyId;
    /**
     * 借取人主键id
     */
    private Integer borrowerId;

    @Override
    public String toString() {
        return "ButlerKeyIdAndBorrowerId{" +
                "keyId=" + keyId +
                ", borrowerId=" + borrowerId +
                '}';
    }

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public Integer getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Integer borrowerId) {
        this.borrowerId = borrowerId;
    }

    public ButlerKeyIdAndBorrowerId() {
    }

    public ButlerKeyIdAndBorrowerId(Integer keyId, Integer borrowerId) {
        this.keyId = keyId;
        this.borrowerId = borrowerId;
    }
}
