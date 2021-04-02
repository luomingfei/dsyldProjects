package com.d.api.common.annotation;

import java.lang.annotation.*;

/**
 * @author dsccc
 *
 * 注入当前登录用户信息
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginUser {

    boolean fullUser() default false;

}
