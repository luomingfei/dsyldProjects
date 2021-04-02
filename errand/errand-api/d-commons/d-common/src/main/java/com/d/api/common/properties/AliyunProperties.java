package com.d.api.common.properties;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.d.api.common.constants.PropertiesConstants;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dsscccc
 * @Description
 * @date 2020/12/13 20:15
 */
@Data
@Configuration
@ConfigurationProperties(prefix = PropertiesConstants.ALIYUN, ignoreInvalidFields = true)
public class AliyunProperties {

    private String accessKeyId = "1";

    private String accessKeySecret = "1";

    @NestedConfigurationProperty
    private OssModel oss = new OssModel();

    @NestedConfigurationProperty
    private SmsModel sms = new SmsModel();

    @Bean
    public OSS ossClient() {
        return new OSSClientBuilder().build(oss.getEndpoint(), accessKeyId, accessKeySecret);
    }

}
