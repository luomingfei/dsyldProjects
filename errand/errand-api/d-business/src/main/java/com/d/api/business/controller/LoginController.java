package com.d.api.business.controller;

import com.d.api.common.model.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: LoginController
 * @description: TODO 类描述
 * @author: dssccc
 * @date: 2021/3/27  18:03
 **/
@Api(tags = "登录")
@RestController
@RequestMapping("login")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "登录", httpMethod = "GET")
    @ApiImplicitParam(name = "code", value = "code", paramType = "path", dataType = "Long")
    @GetMapping("{code}")
    public R miniAppLogin(@PathVariable("code") Long code) {
        return R.succeed("");
    }

}
