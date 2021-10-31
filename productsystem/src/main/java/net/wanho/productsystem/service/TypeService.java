package net.wanho.productsystem.service;

import net.wanho.productsystem.dao.ShopsDao;
import net.wanho.productsystem.dao.TypeDao;
import net.wanho.productsystem.pojo.Shops;
import net.wanho.productsystem.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TypeService {
    @Autowired
    private TypeDao typeDao;
    public ArrayList<Type> find(){
        return typeDao.select();
    }

    public void addT(int no,String name)throws Exception{
        Type type = typeDao.selectByNo(no);
        if (type != null){
            Exception e = new Exception("已存在");
            throw e;
        }
        Type type1 = new Type(no,name);
        typeDao.add(type1);
    }

    public void removeType(int no) throws Exception {
        Type type = typeDao.selectByNo(no);
        if (type == null){
            Exception e = new Exception("不存在");
            throw e;
        }
        typeDao.del(no);
    }
}
