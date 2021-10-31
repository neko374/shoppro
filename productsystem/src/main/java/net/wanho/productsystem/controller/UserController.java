package net.wanho.productsystem.controller;

import net.wanho.productsystem.pojo.Shops;
import net.wanho.productsystem.pojo.User;
import net.wanho.productsystem.service.UserService;
import net.wanho.productsystem.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @ResponseBody
    @CrossOrigin("*")
    @RequestMapping("/login")
    public AjaxResult login(String phone, String pas, Integer status){
        AjaxResult result = new AjaxResult();
        try {
            userService.login(phone,pas,status);
            result.setFlag(true);
            result.setMsg("登录成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setFlag(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }
    @ResponseBody
    @CrossOrigin("*")
    @RequestMapping("/reg")
    public AjaxResult reg(String name,String phone,String pas,String qr,Integer status){
        AjaxResult result = new AjaxResult();
        try {
            userService.reg(name,phone,pas,qr,status);
            result.setFlag(true);
            result.setMsg("注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setFlag(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }
    @ResponseBody
    @CrossOrigin("*")
    @RequestMapping("/userList")
    public ArrayList<User> userList () {
        ArrayList<User> user = userService.find();
        return user;
    }
    @ResponseBody
    @CrossOrigin("*")
    @RequestMapping("/statu")
    public void statu(String phone,int status){
        userService.statu(phone,status);
    }
    @ResponseBody
    @CrossOrigin("*")
    @RequestMapping("/search")
    public User search(String phone){
        User user = userService.search(phone);
        return user;
    }
}