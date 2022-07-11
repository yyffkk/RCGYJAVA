package com.api.model.businessManagement;

/**
 * 数据库备份与还原
 */
public class SysBackupAndRecoveryConfig {
    private String port;
    private String username;
    private String host;
    private String Charset;
    private String password;
    private String database;

    @Override
    public String toString() {
        return "SysBackupAndRecoveryConfig{" +
                "port='" + port + '\'' +
                ", username='" + username + '\'' +
                ", host='" + host + '\'' +
                ", Charset='" + Charset + '\'' +
                ", password='" + password + '\'' +
                ", database='" + database + '\'' +
                '}';
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getCharset() {
        return Charset;
    }

    public void setCharset(String charset) {
        Charset = charset;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public SysBackupAndRecoveryConfig() {
    }

    public SysBackupAndRecoveryConfig(String port, String username, String host, String charset, String password, String database) {
        this.port = port;
        this.username = username;
        this.host = host;
        Charset = charset;
        this.password = password;
        this.database = database;
    }
}
