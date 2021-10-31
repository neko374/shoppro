package net.wanho.productsystem.dao;

import net.wanho.productsystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface UserDao {
    ArrayList<User> select();
    User selectphone(String phone);
    void add(User user);
    void statu(@Param("phone") String phone,@Param("status") int status);
}
