package com.api.util.createCode;

import java.io.File;
import java.util.Date;
import java.util.List;

public class FileEveryDaySerialNumber extends EveryDaySerialNumber {
    private File file = null;
    private final static String FIELD_SEPARATOR = ",";

    /**
     *
     * @param width 携带的单号的位数
     * @param filename 下一次单号保存文件地址
     */
    public FileEveryDaySerialNumber(int width, String filename) {
        super(width);
        file = new File(filename);
    }
    @Override
    protected int getOrUpdateNumber(Date current, int start) {
        String date = format(current);
        int num = start;
        if (file.exists()) {
            List<String> list = FileUtil.readList(file);
            String[] data = list.get(0).split(FIELD_SEPARATOR);
            if (date.equals(data[0])) {
                num = Integer.parseInt(data[1]);
            }
        }
        FileUtil.rewrite(file, date + FIELD_SEPARATOR + (num + 1));
        return num;
    }
}
