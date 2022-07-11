package com.api.model.businessManagement;

/**
 * 数据库恢复 model
 */
public class SysDbRecovery {
    /**
     * 数据库备份的脚本路径
     */
    String filepath;
    /**
     * IP地址
     */
    String ip;
    /**
     * 数据库名称
     */
    String database;
    /**
     * 用户名
     */
    String userName;
    /**
     * 密码
     */
    String password;

    @Override
    public String toString() {
        return "SysDbRecovery{" +
                "filepath='" + filepath + '\'' +
                ", ip='" + ip + '\'' +
                ", database='" + database + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SysDbRecovery() {
    }

    public SysDbRecovery(String filepath, String ip, String database, String userName, String password) {
        this.filepath = filepath;
        this.ip = ip;
        this.database = database;
        this.userName = userName;
        this.password = password;
    }
}
