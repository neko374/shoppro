package net.wanho.productsystem.service;

import net.wanho.productsystem.dao.ShopsDao;
import net.wanho.productsystem.dao.UserDao;
import net.wanho.productsystem.pojo.Shops;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ShopsService {
    @Autowired
    private ShopsDao shopsDao;
    public ArrayList<Shops> find(){
        return shopsDao.select();
    }

    public void addS(int no,String name,int price,String address)throws Exception{
        Shops shops = shopsDao.selectByNo(no);
        if (shops != null){
            Exception e = new Exception("已存在");
            throw e;
        }
        Shops shop = new Shops(no,name,price,address);
        shopsDao.add(shop);
    }

    public void removeShops(int no) throws Exception {
        Shops shops = shopsDao.selectByNo(no);
        if (shops == null){
            Exception e = new Exception("不存在");
            throw e;
        }
        shopsDao.del(no);
    }
    public void delete(String delShops)throws Exception{
        String[] arr = delShops.split(",");
        for (int i = 0;i< arr.length;i++){
            Shops shops = shopsDao.addno(Integer.parseInt(arr[i]));
            if (shops==null){
                Exception e = new Exception("不存在");
                throw e;
            }
            shopsDao.del(Integer.parseInt(arr[i]));
        }
    }
    public void delChoose(String[] arr){
        for (int i = 0; i <arr.length; i++) {
            shopsDao.delete(arr[i]);
        }
    }
}
