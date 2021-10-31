package net.wanho.productsystem.dao;

import net.wanho.productsystem.pojo.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface TypeDao {
    ArrayList<Type> select();
    Type selectByNo(int no);
    void add(Type type);
    void del(int no);
}
