package com.vsw.modal.constant;

public enum SoltEnum {

    SUBSCRIBE("订阅"),
    DELETE("删除"),
    ADD("添加"),
    UPDATE("修改"),
    CANCEL("取消"),
    REMOVE("移除"),
    COLLECT("收藏"),
    WATCH("观看");


    private String describe;

    private SoltEnum(String describe) {
        this.describe = describe;
    }

    public String getDescribe() {
        return describe;
    }

    @Override
    public String toString() {
        return "SoltEnum{" +
                "describe='" + describe + '\'' +
                '}';
    }
}
