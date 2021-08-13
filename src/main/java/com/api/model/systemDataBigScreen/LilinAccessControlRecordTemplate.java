package com.api.model.systemDataBigScreen;

/**
 * 立林门禁记录请求模版
 */
public class LilinAccessControlRecordTemplate {
    /**
     * 小蜜蜂系统授权分配的clientId
     */
    private String clientId;
    /**
     * 立林门禁记录数据
     */
    private LilinAccessControlRecordType data;
    /**
     * 唯一随机数。用于防止网络重放攻击。用户在不同请求中要使用不同的随机数值，生成规则为uuid，（注意：该值五分钟内有且仅能使用一次，再次使用报错）
     */
    private String nonce;
    /**
     * 签名结果串。
     */
    private String signature;
    /**
     * 签名算法版本。当前为1.0。
     */
    private String signatureVersion;
    /**
     * 请求的时间戳，精确到毫秒。 且距离当前时间不能超过5分钟
     */
    private String timestamp;
    /**
     * 	API版本号，每个接口可以存在多个版本。当前为1.0
     */
    private String version;

    @Override
    public String toString() {
        return "LilinAccessControlRecordTemplate{" +
                "clientId='" + clientId + '\'' +
                ", data=" + data +
                ", nonce='" + nonce + '\'' +
                ", signature='" + signature + '\'' +
                ", signatureVersion='" + signatureVersion + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", version='" + version + '\'' +
                '}';
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LilinAccessControlRecordType getData() {
        return data;
    }

    public void setData(LilinAccessControlRecordType data) {
        this.data = data;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSignatureVersion() {
        return signatureVersion;
    }

    public void setSignatureVersion(String signatureVersion) {
        this.signatureVersion = signatureVersion;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public LilinAccessControlRecordTemplate() {
    }

    public LilinAccessControlRecordTemplate(String clientId, LilinAccessControlRecordType data, String nonce, String signature, String signatureVersion, String timestamp, String version) {
        this.clientId = clientId;
        this.data = data;
        this.nonce = nonce;
        this.signature = signature;
        this.signatureVersion = signatureVersion;
        this.timestamp = timestamp;
        this.version = version;
    }
}
