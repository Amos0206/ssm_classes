package com.ahzc.stu.config;

import com.ahzc.stu.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/11 15:20
 * @desc
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Autowired
    LoginInterceptor loginInterceptor;

    @Bean
    public CommonsMultipartResolver getCommonsMultipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(10485760L);
        return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/index")
                .excludePathPatterns("/login")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/lib/**");
    }
}
