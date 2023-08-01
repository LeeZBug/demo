package com.lizhejie.demo.model.base;

import com.lizhejie.demo.model.base.enums.ResponseCode;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BaseResult<T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

    public BaseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResult() {
    }

    public static <T> BaseResult<T> success(ResponseCode code) {
        return new BaseResult<T>(code.getCode(), code.getMsg(),null);
    }
    public static <T> BaseResult<T> success(ResponseCode code,T data) {
        return new BaseResult<T>(code.getCode(), code.getMsg(),data);
    }
    public static <T> BaseResult<T> success(Integer code, String msg) {
        return new BaseResult<T>(code, msg, null);
    }
    public static <T> BaseResult success(T data) {
        return new BaseResult(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(),data);
    }
}