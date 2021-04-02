package com.d.api.common.exception;

/**
 * @author dscccc
 *
 * 业务异常
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 4961376219423389949L;

    public BusinessException(String message) {
        super(message);
    }

}
