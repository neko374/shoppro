package net.wanho.productsystem.dao;

import net.wanho.productsystem.pojo.Shops;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface ShopsDao {
    ArrayList<Shops> select();
    Shops selectByNo(int no);
    void add(Shops shops);
    void del(int no);
    Shops addno(int no);
    void delete(String no);
}
