package com.atguigu.controller;

import com.atguigu.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *@ClassName UserController
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/27 16:09
 *@Version 1.0
 */
@Controller
public class UserController{

    /**
     * 使用RESTFul模拟用户资源的增删改删
     * /user    GET         查询所有用户信息
     * /user/1    GET         根据用户id查询用户信息
     * /user    POST         添加用户信息
     * /user/1    DELETE         删除用户信息
     * /user    PUT         修改用户信息
     */

    @RequestMapping(value = "/user",
        method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有用户信息");
        return "success";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserById(){

        System.out.println("根据id查询用户信息");
        return "success";
    }

/*    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String insertUser(String username,String password ){

        System.out.println("添加用户信息" + username  + "," + password);
        return "success";
    }*/


    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String insertUser(User user){

        System.out.println("添加用户信息" + user.getUserName()  + "," + user.getPassWord());
        System.out.println("添加成功");
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String update(String username,String password ){
        System.out.println("修改用户信息" + username  + "," + password);
        return "success";
    }
}

