package com.d.api.tool.miniapp.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import com.d.api.common.properties.WxMiniAppProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: WxMiniAppConfiguration
 * @description: 微信小程序配置
 * @author: dssccc
 * @date: 2021/3/27  17:39
 **/
@Configuration
public class WxMiniAppConfiguration {

    private final WxMiniAppProperties wxMiniAppProperties;

    public WxMiniAppConfiguration(WxMiniAppProperties wxMiniAppProperties) {
        this.wxMiniAppProperties = wxMiniAppProperties;
    }

    @Bean
    public WxMaConfig wxMaConfig() {
        WxMaDefaultConfigImpl config = new WxMaDefaultConfigImpl();
        config.setSecret(this.wxMiniAppProperties.getSecret());
        config.setAppid(this.wxMiniAppProperties.getAppid());
        config.setToken(this.wxMiniAppProperties.getToken());
        config.setAesKey(this.wxMiniAppProperties.getAesKey());
        config.setMsgDataFormat(this.wxMiniAppProperties.getAesKey());
        return config;
    }

    @Bean
    public WxMaService wxMaService(WxMaConfig config) {
        WxMaServiceImpl service = new WxMaServiceImpl();
        service.setWxMaConfig(config);
        return service;
    }

}
