package net.wanho.productsystem.controller;

import net.wanho.productsystem.pojo.Shops;
import net.wanho.productsystem.service.ShopsService;
import net.wanho.productsystem.service.UserService;
import net.wanho.productsystem.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.transform.Result;
import java.util.ArrayList;

@Controller
@RequestMapping("/shops")
public class ShopsController {
    @Autowired
    private ShopsService shopsService;
    @ResponseBody
    @CrossOrigin("*")
    @RequestMapping("/shopsList")
    public ArrayList<Shops> sList () {
        ArrayList<Shops> shops = shopsService.find();
        return shops;
    }
    @ResponseBody
    @CrossOrigin("*")
    @RequestMapping("/shopsAdd")
    public AjaxResult add (int no,String name, int price, String address){
        AjaxResult result = new AjaxResult();
        try {
            shopsService.addS(no,name,price,address);
            result.setFlag(true);
            result.setMsg("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setFlag(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }
    @ResponseBody
    @CrossOrigin("*")
    @RequestMapping("/shopsDel")
    public AjaxResult del (@RequestParam int no){
        AjaxResult result = new AjaxResult();
        try {
            shopsService.removeShops(no);
            result.setFlag(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg(e.getMessage());
        }
        return result;
    }
    @ResponseBody
    @CrossOrigin("*")
    @RequestMapping("/delete")
    public AjaxResult delete(String delShops){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            shopsService.delete(delShops);
            ajaxResult.setFlag(true);
            ajaxResult.setMsg("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setMsg(e.getMessage());
        }
        return ajaxResult;
    }
    @ResponseBody
    @CrossOrigin("*")
    @RequestMapping("/delChoose")
    public void delChoose(@RequestParam(value = "arr[]") String[] arr){
        shopsService.delChoose(arr);
    }
}
