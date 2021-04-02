package com.d.api.common.properties;

import lombok.Data;

/**
 * @className: DysmsModel
 * @description: 短信配置
 * @author: dssccc
 * @date: 2021/3/10  23:53
 **/
@Data
public class SmsModel {

    private String signName = "";

    private String loginTemplateCode = "";

}
