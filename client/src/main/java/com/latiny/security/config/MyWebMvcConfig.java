package com.latiny.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author Latiny
 * @version 1.0
 * @description: MyWebMvcConfig
 * @date 2019/12/10 12:43
 */
@Configuration
public class MyWebMvcConfig extends WebMvcConfigurationSupport {

    /**
     * 配置静态资源
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
