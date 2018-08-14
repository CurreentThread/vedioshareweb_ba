package com.vsw.common.util;

public class GlobalExcetion extends Exception {

    private Integer errCode;

    private String errMsg;

    public GlobalExcetion(Integer errCode,String errMsg) {
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    @Override
    public String toString() {
        return "GlobalException[errMsg=" + this.errMsg + "]errCode=" + this.errMsg + "]";
    }
}
