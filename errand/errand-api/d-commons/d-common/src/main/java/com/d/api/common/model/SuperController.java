package com.d.api.common.model;

import com.d.api.common.exception.ValidatorException;
import com.d.api.common.utils.TrimUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * @author dsscccc
 * @Description
 *
 * 父类Controller 参数效验 以及方便后面实现一些公共的方法
 * @date 2020/11/3 10:11
 */
@Slf4j
public abstract class SuperController {

    protected String getErrorMessage(BindingResult bindingResult) {
        String msg = "";
        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            msg += "{" + error.getField() + "}" + error.getDefaultMessage() + ",";
        }
        msg = msg.endsWith(",") ? msg.substring(0, msg.length() - 1) : msg;
        return msg;
    }

    protected void paramsValidate(Object form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidatorException(getErrorMessage(bindingResult));
        }

        try {
            TrimUtils.beanAttributeValueTrim(form);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException();
        }

    }

}
