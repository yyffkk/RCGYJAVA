package com.api.manage.service.businessManagement.impl;

import com.api.manage.service.businessManagement.SysDBManageService;
import com.api.model.businessManagement.SysBackupAndRecoveryConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Map;


@Service
public class SysDBManageServiceImpl implements SysDBManageService {

    /**
     * @param hostIP ip地址，可以是本机也可以是远程
     * @param userName 数据库的用户名
     * @param password 数据库的密码
     * @param savePath 备份的路径
     * @param fileName 备份的文件名
     * @param databaseName 需要备份的数据库的名称
     * @return
     */
    @Override
    public boolean dbBackUp(String hostIP, String userName, String password, String savePath, String fileName,
                            String databaseName) {
        fileName +=".sql";
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {// 如果目录不存在
            saveFile.mkdirs();// 创建文件夹
        }
        if (!savePath.endsWith(File.separator)) {
            savePath = savePath + File.separator;
        }

        //拼接命令行的命令
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mysqldump").append(" --opt").append(" -h").append(hostIP);
        stringBuilder.append(" --user=").append(userName).append(" --password=").append(password)
                .append(" --lock-all-tables=true");
        stringBuilder.append(" --result-file=").append(savePath + fileName).append(" --default-character-set=utf8 ")
                .append(databaseName);
        try {
            //调用外部执行exe文件的javaAPI
            Process process = Runtime.getRuntime().exec(stringBuilder.toString());
            if (process.waitFor() == 0) {// 0 表示线程正常终止。
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @param filepath 数据库备份的脚本路径
     * @param ip IP地址
     * @param database 数据库名称
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    @Override
    public boolean dbRecovery(String filepath,String ip,String database, String userName,String password) {


        String stmt1 = "mysqladmin -h "+ip+" -u "+userName+" -p"+password+" create "+database;

        String stmt2 = "mysql -h "+ip+" -u "+userName+" -p "+password+" "+database+" < " + filepath;

        String[] cmd = { "cmd", "/c", stmt2 };

        try {
            Runtime.getRuntime().exec(stmt1);
            Runtime.getRuntime().exec(cmd);
            System.out.println("数据已从 " + filepath + " 导入到数据库中");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

//    /**
//     *解析数据库连接语句获取想要的数据
//     *
//     */
//    public void setBackupInfo()
//    {
//        SysBackupAndRecoveryConfig sysBackupAndRecoveryConfig = new SysBackupAndRecoveryConfig();
//        String sqlPath=sqlUrl;
//        String[] split = sqlPath.split(":");
//        sysBackupAndRecoveryConfig.setHost(split[2].substring(2));
//        String[] splits= split[3].split("/");
//        sysBackupAndRecoveryConfig.setPort(splits[0]);
//        sysBackupAndRecoveryConfig.setCharset(splits[1].split("\\?")[1].split("&")[0].split("=")[1]);
//        sysBackupAndRecoveryConfig.setDatabase(splits[1].split("\\?")[0]);
//        sysBackupAndRecoveryConfig.setUsername( userName);
//        sysBackupAndRecoveryConfig.setPassword(passWord);
//    }
}
