package net.wanho.productsystem.controller;

import net.wanho.productsystem.pojo.Type;
import net.wanho.productsystem.service.TypeService;
import net.wanho.productsystem.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @ResponseBody
    @CrossOrigin("*")
    @RequestMapping("/typeList")
    public ArrayList<Type> tList () {
        ArrayList<Type> type = typeService.find();
        return type;
    }
    @ResponseBody
    @CrossOrigin("*")
    @RequestMapping("/typeAdd")
    public AjaxResult add (int no, String name){
        AjaxResult result = new AjaxResult();
        try {
            typeService.addT(no,name);
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
    @RequestMapping("/typeDel")
    public AjaxResult del (int no){
        AjaxResult result = new AjaxResult();
        try {
            typeService.removeType(no);
            result.setFlag(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg(e.getMessage());
        }
        return result;
    }
}
