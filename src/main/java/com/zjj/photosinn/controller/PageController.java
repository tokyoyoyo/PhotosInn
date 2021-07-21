package com.zjj.photosinn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @GetMapping(value = {"/","/home"})
    public String common(HttpSession session, Model model){
        return "home";
    }
}
