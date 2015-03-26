package com.baobaotao.web;

import com.baobaotao.domain.LoginCommand;
import com.baobaotao.domain.User;
import com.baobaotao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by xiaofan on 2015/3/25.
 */
@Controller
public class webController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index.html")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand){
        boolean isValidUser = userService.hasMatch(loginCommand.getUserName(),loginCommand.getPassword());
        if(!isValidUser){
            return new ModelAndView("login","error","用户名或者密码错误");
        }else {
            User user = userService.findUserByUserName(loginCommand.getUserName());
            user.setLastVisit(new Date());
            user.setLastIp(request.getRemoteAddr());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user",user);
            return new ModelAndView("main");
        }
    }
}
