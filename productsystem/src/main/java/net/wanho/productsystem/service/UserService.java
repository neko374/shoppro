package net.wanho.productsystem.service;

import net.wanho.productsystem.dao.UserDao;
import net.wanho.productsystem.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public ArrayList<User> find(){
        return userDao.select();
    }
    public void login(String phone,String pas,Integer status)throws Exception {
        User user = userDao.selectphone(phone);
        if (user == null){
            Exception e = new Exception("不存在");
            throw e;
        }
        if (!user.getPas().equals(pas)){
            Exception e = new Exception("密码错误");
            throw e;
        }
        if (user.getStatus() == 1) {
            Exception e = new Exception("账号停用");
            throw e;
        }
    }

    public void reg(String name,String phone,String pas,String qr,Integer status)throws Exception{
        if (!pas.equals(qr)){
            Exception e = new Exception("密码不一致");
            throw e;
        }
        User user = userDao.selectphone(phone);
        if (user!=null){
            Exception e = new Exception("已存在");
            throw e;
        }
        User users = new User(name,phone,pas,status);
        userDao.add(users);
    }

    public void statu(String phone,int status){
        if (status == 0){
            status = 1;
        }else if (status == 1){
            status = 0;
        }
        userDao.statu(phone,status);
    }

    public User search(String phone){
        return userDao.selectphone(phone);
    }
}