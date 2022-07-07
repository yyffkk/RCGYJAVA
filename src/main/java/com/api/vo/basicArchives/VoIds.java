package com.api.vo.basicArchives;

import java.util.Arrays;

/**
 * 批量删除id
 */
public class VoIds {
    int[] ids;

    @Override
    public String toString() {
        return "VoIds{" +
                "ids=" + Arrays.toString(ids) +
                '}';
    }

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }

    public VoIds() {
    }

    public VoIds(int[] ids) {
        this.ids = ids;
    }
}
