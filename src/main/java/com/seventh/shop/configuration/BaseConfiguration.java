package com.seventh.shop.configuration;

import com.seventh.shop.interceptor.AccessInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author gfc
 * 2018年11月23日 上午 10:26
 */
@SpringBootConfiguration
public class BaseConfiguration extends WebMvcConfigurationSupport {
    @Autowired
    private AccessInterceptor accessInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessInterceptor).addPathPatterns("/**");
    }
}
