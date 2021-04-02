package com.d.api.common.properties;


import com.d.api.common.constants.PropertiesConstants;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author dssccc
 */
@Data
@Configuration
@ConfigurationProperties(prefix = PropertiesConstants.WX_MINIAPP, ignoreInvalidFields = true)
public class WxMiniAppProperties {

    /**
     * 设置微信小程序的appid
     */
    private String appid = "1";

    /**
     * 设置微信小程序的Secret
     */
    private String secret = "1";

    /**
     * 设置微信小程序消息服务器配置的token
     */
    private String token = "1";

    /**
     * 设置微信小程序消息服务器配置的EncodingAESKey
     */
    private String aesKey = "1";

    /**
     * 消息格式，XML或者JSON
     */
    private String msgDataFormat = "1";

}
