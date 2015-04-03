package com.ioc.web;

import com.ioc.domain.LoginCommand;
import com.ioc.domain.User;
import com.ioc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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

    @RequestMapping(value = "/fileupload")
    public String upload(@RequestParam(value = "logo", required = false) MultipartFile file,
                         HttpServletRequest request, ModelMap model) {

        String path = request.getSession().getServletContext().getRealPath("/upload");

        String fileName = file.getOriginalFilename();
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("fileUrl", request.getContextPath()+"/"+fileName);

        return "login";
    }
}
