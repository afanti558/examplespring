package com.ioc.web;

import com.ioc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/table")
public class tableController {

    @RequestMapping("/tableindex")
    public ModelAndView tableIndex(HttpServletRequest request,HttpServletResponse response,
                                   ModelMap modelMap) {

        User user1 = new User(1,"小红",new Date());
        User user2 = new User(2,"小李",new Date());
        User user3 = new User(3,"小王",new Date());

        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        modelMap.put("list",userList);

        return new ModelAndView("table/table");
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public String delete(HttpServletRequest request,HttpServletResponse response,
                                   @RequestParam(value = "userId",defaultValue = "0") String userId) {
        System.out.println("编号为" + userId + "的用户被删除了");
        return "{code:OK,msg:good}";

    }
}
