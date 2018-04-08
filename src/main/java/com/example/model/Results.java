package com.example.model;

public class Results {
    private  String errorMessage; //返回错误信息
    private  String flag;  //预期

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Results{" +
                "errorMessage='" + errorMessage + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
