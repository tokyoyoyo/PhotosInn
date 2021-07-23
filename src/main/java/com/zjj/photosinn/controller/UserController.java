package com.zjj.photosinn.controller;

import com.zjj.photosinn.beans.User;
import com.zjj.photosinn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @projectName: PhotosInn
 * @className: UserController
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/22 8:45
 * @version: 1.0
 */
@Controller
public class UserController {

    @Autowired
    UserMapper userMapper;

    @PostMapping("/register")
    public String userRegister(@RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password,
                             @RequestParam("password_confirmation")String password_confirmation,
                             Model model){

        if(StringUtils.hasLength(name)
        && StringUtils.hasLength(email)
        && !password.isEmpty()
        && password.equals(password_confirmation)){
            userMapper.insert(new User(name,email,password));

            return "login";
        }else {
            String msg ="信息缺失或两次密码不一致";
            model.addAttribute("msg",msg);

            return "register";
        }

    }

    @PostMapping("/login")
    public String userLogin(User user, HttpSession session, Model model){
        if(user.getName()==null || user.getPassword()==null){
            model.addAttribute("msg","必须填写用户名");
            return "login";
        }
        String pw = userMapper.getPasswordByName(user.getName());

        if(user.getPassword().equals(pw)){
            model.addAttribute("user",user.getName());
            return "main";
        }else if(pw ==null) {
            model.addAttribute("msg","先给老子注册");
            return "register";
        }else{
            model.addAttribute("msg","密码错误");
            return "login";
        }

    }
}
