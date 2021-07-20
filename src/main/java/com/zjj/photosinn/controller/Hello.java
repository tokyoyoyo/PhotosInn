package com.zjj.photosinn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: PhotosInn
 * @className: Hello
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/20 17:11
 * @version: 1.0
 */

@RestController
public class Hello {

    @GetMapping("/h")
    public String hello(){
        return "hello";
    }
}
