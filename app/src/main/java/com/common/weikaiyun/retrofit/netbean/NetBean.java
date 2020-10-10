package com.common.weikaiyun.retrofit.netbean;

public class NetBean<T> {
    private int errorCode;
    private String errorMsg;
    private T data;

    public boolean isOk() {
        return errorCode == 0;
    }

    public T getData() {
        return data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
