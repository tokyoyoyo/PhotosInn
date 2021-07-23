package com.zjj.photosinn.controller;

import com.zjj.photosinn.beans.Photo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestPart;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PageController {

    @GetMapping(value = {"/","/home"})
    public String home(HttpSession session, Model model){
        return "home";
    }

//    @GetMapping("/result")
//    public String result(){
//        return "result";
//    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }

    @GetMapping("/about")
    public String aboutPage(){
        return "about";
    }

}
