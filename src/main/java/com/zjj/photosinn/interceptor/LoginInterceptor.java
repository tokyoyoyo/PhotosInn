package com.zjj.photosinn.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @projectName: PhotosInn
 * @className: LoginInterceptor
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/22 11:30
 * @version: 1.0
 */

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("拦截了访问 {} 的请求",requestURI);

        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        if(user!=null){
            log.info("{} 成功登录",user);
            return true;
        }

        request.setAttribute("msg","请先登录");
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }
}
