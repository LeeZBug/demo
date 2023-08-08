package com.lizhejie.demo.model.base.enums;


public enum ResponseCode {

    SUCCESS(200, "操作成功"),
    FAIL(500, "操作失败"),
    PARAM_VALIDE_ERROR(555, "参数校验失败");

    private final Integer code;
    private final  String msg;

    ResponseCode(Integer code, String msg) {
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
