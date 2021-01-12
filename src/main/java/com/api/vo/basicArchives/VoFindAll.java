package com.api.vo.basicArchives;

public class VoFindAll {
    /**
     * 房产id
     */
    private Integer value;
    /**
     * 房产name
     */
    private String label;

    @Override
    public String toString() {
        return "VoFindAll{" +
                "value=" + value +
                ", label='" + label + '\'' +
                '}';
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public VoFindAll() {
    }

    public VoFindAll(Integer value, String label) {
        this.value = value;
        this.label = label;
    }
}
