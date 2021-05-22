package com.api.vo.businessManagement;

/**
 * 数据库Vo list 回显
 */
public class VoDataBase {
    /**
     * 数据库主键id
     */
    private Integer id;
    /**
     * 所属功能大类名称
     */
    private String functionType;
    /**
     * 功能名
     */
    private String functionName;
    /**
     * 字段名
     */
    private String fieldName;

    @Override
    public String toString() {
        return "VoDataBase{" +
                "id=" + id +
                ", functionType='" + functionType + '\'' +
                ", functionName='" + functionName + '\'' +
                ", fieldName='" + fieldName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFunctionType() {
        return functionType;
    }

    public void setFunctionType(String functionType) {
        this.functionType = functionType;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public VoDataBase() {
    }

    public VoDataBase(Integer id, String functionType, String functionName, String fieldName) {
        this.id = id;
        this.functionType = functionType;
        this.functionName = functionName;
        this.fieldName = fieldName;
    }
}
