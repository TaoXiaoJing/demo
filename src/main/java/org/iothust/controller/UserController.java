package org.iothust.controller;

import org.iothust.dao.entity.User;
import org.iothust.dao.mapper.UserMapper;
import org.iothust.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Create by weilong on 2018/06/03.
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    @ResponseBody
    @PostMapping("/add")
    public int addUser(User user) {
        return userService.addUser(user);
    }

    @ResponseBody
    @GetMapping("/all")
    public Object findAllUser(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return userService.findAllUser(pageNum, pageSize);
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView,String username,String password){
        System.out.println("姓名是："+username+",密码是："+password);
        User user = userService.getUserByUserName(username,password);

        if (user!=null){
            System.out.println("登录成功！");
            modelAndView.setViewName("index");
        }else{
            System.out.println("登录失败！");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/index1")
    public User index1(String username,String password){
        System.out.println("姓名是："+username+",密码是："+password);
        User user = userService.getUserByUserName(username,password);
        return user;
    }

}
