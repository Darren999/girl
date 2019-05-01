package com.imooc.enums;

public enum ResultEnum {

    UNKNWON_ERROR(-1,"未知错误"),
    PRIMARY_SCHOOL(-10,"你还在上小学吧"),
    MIDDLE_SCHOOL(-16,"你还在上初中吧"),
    SUCESS(0,"成功"),
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
