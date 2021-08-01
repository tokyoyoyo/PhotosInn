package com.zjj.photosinn;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @projectName: PhotosInn
 * @className: MySpringBootServletInitializer
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/23 22:34
 * @version: 1.0
 */



public class MySpringBootServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PhotosInnApplication.class);
    }
}

