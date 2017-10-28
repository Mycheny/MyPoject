package com.ldjh.controller;

import com.ldjh.common.GenericController;
import com.ldjh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController extends GenericController {
    private static final Logger logger=LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUsers",method = RequestMethod.GET)
    public ModelAndView getUsers(@RequestParam Integer id){
        ModelAndView modelAndView =new ModelAndView();
        List<User> users=userService.getUsers(id);
        modelAndView.addObject("users",users);
        modelAndView.setViewName("user");
        logger.info("成功查询用户列表");
        return modelAndView;
    }

    //返回json格式数据，形式1
    @RequestMapping(value = "/json1",method = RequestMethod.GET)
    @ResponseBody
    public List getUsers2(@RequestParam Integer id, HttpServletRequest request, HttpServletResponse response) {
        //调用service方法得到用户列表
        List<User> users = userService.getUsers(id);
        logger.info("===============================成功查询用户列表！");
        return users;
    }
    //返回json格式数据，形式2（自定义了返回的格式）
    @RequestMapping(value = "/json2",method = RequestMethod.GET)
    public void getUsers3(@RequestParam Integer id, HttpServletRequest request, HttpServletResponse response) {
        //调用service方法得到用户列表
        List<User> users = userService.getUsers(id);
        logger.info("===============================成功查询用户列表！");
        renderSuccessString(response, users);
    }


}
