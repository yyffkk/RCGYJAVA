package com.api.manage.service.businessManagement.impl;

import com.api.manage.service.businessManagement.SysDBManageService;
import com.api.model.businessManagement.SysBackupAndRecoveryConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;


@Service
@Slf4j
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
        stringBuilder.append(" --result-file=").append(savePath+fileName).append(" --default-character-set=utf8 ")
                .append(databaseName);

        System.out.println(stringBuilder.toString());
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


        //创建数据库
//        String stmt1 = "mysqladmin -h "+ip+" -u "+userName+" -p"+password+" create "+database;

        //拼接命令行的命令
        // mysql -u用户名 -p密码 -hIP地址 -P端口号 --default-character-set=utf8  -B 数据库名 < 文件地址+文件名称
        //mysql -uroot -proot -h192.268.1.123 -P3306 --default-character-set=utf8  -B testdb < ./conf_sql/recover_db/conf.sql
        StringBuilder cmd = new StringBuilder();
        cmd.append("mysql")
                .append(" -u").append(userName)
                .append(" -p").append(password)
                .append(" -h").append(ip)
                .append(" -P").append("3306")
                .append(" --default-character-set=utf8 ")
                .append(" -B ").append(database)
                .append(" < ").append(filepath);
        try {
            Process process = Runtime.getRuntime().exec(getCommand(cmd.toString()));
            if (process.waitFor() == 0) {// 0 表示线程正常终止
                log.info("数据已从 " + filepath + " 导入到数据库中");
                return true;
            }
        } catch (IOException | InterruptedException e) {
            log.error("Mysql数据导入数据库发生异常" + e.getMessage());
        }
        return false;


    }

    private static String[] getCommand(String command) {
        String os = System.getProperty("os.name");
        String shell = "/bin/bash";
        String c = "-c";
        if (os.toLowerCase().startsWith("win")) {
            shell = "cmd";
            c = "/c";
        }
        String[] cmd = {shell, c, command};
        log.info("...数据库备份过程中,执行的sql恢复命令为：" + Arrays.toString(cmd));
        return cmd;
    }
}
