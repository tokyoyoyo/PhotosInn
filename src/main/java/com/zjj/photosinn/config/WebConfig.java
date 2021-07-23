package com.zjj.photosinn.config;

import com.zjj.photosinn.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @projectName: PhotosInn
 * @className: WebConfig
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/22 12:47
 * @version: 1.0
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/home",
                        "/login","/about","/register","/upload","/favicon.ico",
                        "/static","/visitor/**");
    }
}
