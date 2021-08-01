package com.zjj.photosinn.controller;


import com.zjj.photosinn.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PageController {

    @GetMapping(value = {"/","/home"})
    public String home(HttpSession session, Model model){
        if (session.getAttribute("user") != null){
            User user = (User) session.getAttribute("user");
            model.addAttribute("user",user.getName());
            return "main";
        }else {
            return "home";
        }
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

    @GetMapping("/main")
    public String mainPage(HttpSession session, Model model){
        if (session.getAttribute("user") != null){
            User user = (User) session.getAttribute("user");
            model.addAttribute("user",user.getName());
            return "main";
        }else {
            return "home";
        }
    }

}
