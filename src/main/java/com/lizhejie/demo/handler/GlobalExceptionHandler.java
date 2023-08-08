package com.lizhejie.demo.handler;


import com.lizhejie.demo.model.base.BaseResult;
import com.lizhejie.demo.model.base.enums.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 专门处理页面传参错误的 全局异常处理器, 如有其它异常需要捕获，请另写
     *
     * @param e 异常
     * @return 返回值
     */
    @ExceptionHandler(BindException.class)
    public BaseResult<String> handleException(BindException e) {
        FieldError fieldError = e.getFieldError();
        log.error(fieldError.getDefaultMessage());
        return BaseResult.success(ResponseCode.PARAM_VALIDE_ERROR.getCode(), fieldError.getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResult<String> handleException(Exception e) {
        return BaseResult.success(ResponseCode.FAIL.getCode(), e.getMessage());
    }
}
