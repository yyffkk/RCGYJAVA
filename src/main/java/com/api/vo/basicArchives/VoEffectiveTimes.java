package com.api.vo.basicArchives;

import java.util.Date;

/**
 * 房产有效时间
 */
public class VoEffectiveTimes {
    /**
     * 有效时间开始
     */
    private Date effectiveTimeStart;
    /**
     * 有效时间结束
     */
    private Date effectiveTimeEnd;

    @Override
    public String toString() {
        return "VoEffectiveTimes{" +
                "effectiveTimeStart=" + effectiveTimeStart +
                ", effectiveTimeEnd=" + effectiveTimeEnd +
                '}';
    }

    public Date getEffectiveTimeStart() {
        return effectiveTimeStart;
    }

    public void setEffectiveTimeStart(Date effectiveTimeStart) {
        this.effectiveTimeStart = effectiveTimeStart;
    }

    public Date getEffectiveTimeEnd() {
        return effectiveTimeEnd;
    }

    public void setEffectiveTimeEnd(Date effectiveTimeEnd) {
        this.effectiveTimeEnd = effectiveTimeEnd;
    }

    public VoEffectiveTimes() {
    }

    public VoEffectiveTimes(Date effectiveTimeStart, Date effectiveTimeEnd) {
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
    }
}
