package com.d.api.common.exception;

import com.d.api.common.model.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.nio.file.AccessDeniedException;
import java.sql.SQLException;

/**
 * 异常通用处理
 *
 * @author dsccc
 */
@ResponseBody
@Slf4j
public class DefaultExceptionAdvice {
    /**
     * IllegalArgumentException异常处理返回json
     * 返回状态码:400
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class})
    public R badRequestException(IllegalArgumentException e) {
        return defHandler("参数解析失败", e);
    }

    /**
     * AccessDeniedException异常处理返回json
     * 返回状态码:403
     */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({AccessDeniedException.class})
    public R badMethodExpressException(AccessDeniedException e) {
        return defHandler("没有权限请求当前方法", e);
    }

    /**
     * 返回状态码:405
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public R handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return defHandler("不支持当前请求方法", e);
    }

    /**
     * 返回状态码:415
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public R handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        return defHandler("不支持当前媒体类型", e);
    }

    /**
     * SQLException sql异常处理
     * 返回状态码:500
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({SQLException.class})
    public R handleSQLException(SQLException e) {
        return defHandler("服务运行SQLException异常", e);
    }

    /**
     * BusinessException 业务异常处理
     * 返回状态码:500
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BusinessException.class)
    public R handleException(BusinessException e) {
        return defHandler("业务异常", e);
    }

    /**
     * ValidatorException 参数验证失败
     * 返回状态码:500
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ValidatorException.class})
    public R ValidatorException(ValidatorException e) {
        return defHandler("参数验证失败", e);
    }

    /**
     * 所有异常统一处理
     * 返回状态码:500
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        return defHandler("未知异常", e);
    }

    private R defHandler(String msg, Exception e) {
        log.error(msg, e);
        return R.failed(msg+":"+e.getMessage());
    }
}
