package com.api.model.businessManagement;

/**
 * 数据库备份 model
 */
public class SysDbBackUp {
    /**
     * ip地址，可以是本机也可以是远程
     */
    String hostIP;
    /**
     * 数据库的用户名
     */
    String userName;
    /**
     * 数据库的密码
     */
    String password;
    /**
     * 备份的路径
     */
    String savePath;
    /**
     * 备份的文件名
     */
    String fileName;
    /**
     * 需要备份的数据库的名称
     */
    String databaseName;

    @Override
    public String toString() {
        return "SysDbBackUp{" +
                "hostIP='" + hostIP + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", savePath='" + savePath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", databaseName='" + databaseName + '\'' +
                '}';
    }

    public String getHostIP() {
        return hostIP;
    }

    public void setHostIP(String hostIP) {
        this.hostIP = hostIP;
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

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public SysDbBackUp() {
    }

    public SysDbBackUp(String hostIP, String userName, String password, String savePath, String fileName, String databaseName) {
        this.hostIP = hostIP;
        this.userName = userName;
        this.password = password;
        this.savePath = savePath;
        this.fileName = fileName;
        this.databaseName = databaseName;
    }
}
