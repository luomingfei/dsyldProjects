package com.d.api.common.exception;

/**
 * @author dsscccc
 * @Description
 *
 * 参数验证异常
 *
 * @date 2020/11/2 22:24
 */
public class ValidatorException extends RuntimeException {

    public ValidatorException(String message) {
        super(message);
    }

}

