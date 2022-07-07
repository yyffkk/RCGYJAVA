package com.api.model.test;

import java.io.Serializable;
import java.util.Date;

public class River implements Serializable {
    private String riverName;
    private String zhanName;
    private Date date;
    //水位
    private String waterLevel;
    //流量
    private String traffic;
    private String shuiShi;
    //警戒流量
    private String alertTraffic;
    //保证流量
    private String ensureTraffic;
    public River() {
        super();
    }
    public String getRiverName() {
        return riverName;
    }
    public void setRiverName(String riverName) {
        this.riverName = riverName;
    }
    public String getZhanName() {
        return zhanName;
    }
    public void setZhanName(String zhanName) {
        this.zhanName = zhanName;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getWaterLevel() {
        return waterLevel;
    }
    public void setWaterLevel(String waterLevel) {
        this.waterLevel = waterLevel;
    }
    public String getTraffic() {
        return traffic;
    }
    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }
    public String getShuiShi() {
        return shuiShi;
    }
    public void setShuiShi(String shuiShi) {
        this.shuiShi = shuiShi;
    }
    public String getAlertTraffic() {
        return alertTraffic;
    }
    public void setAlertTraffic(String alertTraffic) {
        this.alertTraffic = alertTraffic;
    }
    public String getEnsureTraffic() {
        return ensureTraffic;
    }
    public void setEnsureTraffic(String ensureTraffic) {
        this.ensureTraffic = ensureTraffic;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((alertTraffic == null) ? 0 : alertTraffic.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result
                + ((ensureTraffic == null) ? 0 : ensureTraffic.hashCode());
        result = prime * result
                + ((riverName == null) ? 0 : riverName.hashCode());
        result = prime * result + ((shuiShi == null) ? 0 : shuiShi.hashCode());
        result = prime * result + ((traffic == null) ? 0 : traffic.hashCode());
        result = prime * result
                + ((waterLevel == null) ? 0 : waterLevel.hashCode());
        result = prime * result
                + ((zhanName == null) ? 0 : zhanName.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        River other = (River) obj;
        if (alertTraffic == null) {
            if (other.alertTraffic != null)
                return false;
        } else if (!alertTraffic.equals(other.alertTraffic))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (ensureTraffic == null) {
            if (other.ensureTraffic != null)
                return false;
        } else if (!ensureTraffic.equals(other.ensureTraffic))
            return false;
        if (riverName == null) {
            if (other.riverName != null)
                return false;
        } else if (!riverName.equals(other.riverName))
            return false;
        if (shuiShi == null) {
            if (other.shuiShi != null)
                return false;
        } else if (!shuiShi.equals(other.shuiShi))
            return false;
        if (traffic == null) {
            if (other.traffic != null)
                return false;
        } else if (!traffic.equals(other.traffic))
            return false;
        if (waterLevel == null) {
            if (other.waterLevel != null)
                return false;
        } else if (!waterLevel.equals(other.waterLevel))
            return false;
        if (zhanName == null) {
            if (other.zhanName != null)
                return false;
        } else if (!zhanName.equals(other.zhanName))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "River [riverName=" + riverName + ", zhanName=" + zhanName
                + ", date=" + date + ", waterLevel=" + waterLevel
                + ", traffic=" + traffic + ", shuiShi=" + shuiShi
                + ", alertTraffic=" + alertTraffic + ", ensureTraffic="
                + ensureTraffic + "]";
    }

}
