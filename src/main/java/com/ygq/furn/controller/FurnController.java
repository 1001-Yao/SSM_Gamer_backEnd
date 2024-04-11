package com.ygq.furn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ygq.furn.bean.Furn;
import com.ygq.furn.bean.Msg;
import com.ygq.furn.service.FurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FurnController {
    //注入配置
    @Autowired(required = false)
    FurnService furnService;
    /**
     *  响应客户端
     *  *@RequestBody：使用 SpringMVC 的@RequestBody 将容户端提交的json 数据，封装成 JavaBean
     *  *@ResponseBody：服务器返回的数据格式是按照json 来返回的(底层是按照http协议进行协商)
     */
    @PostMapping("/save")
    @ResponseBody
    public Msg save(@Validated @RequestBody Furn furn, Errors errors) {//将前端发送的 json 数据,转成 JavaBean 数据
        Map<String, Object> map = new HashMap<>();
        List<FieldError> fieldErrors = errors.getFieldErrors();
        for (FieldError e : fieldErrors) {
            map.put(e.getField(), e.getDefaultMessage());
        }
        if(map.isEmpty()) {
            furnService.save(furn);
            return Msg.success();
        } else {
            return Msg.fail().add("errorMsg", map);
        }
    }

    @RequestMapping("/furns")
    @ResponseBody
    public Msg listFurns(){
        List<Furn> furnsList = furnService.findAll();
        return Msg.success().add("furnsList",furnsList);
    }

    @PutMapping("/update")
    @ResponseBody
    public Msg update(@RequestBody Furn furn){
        furnService.upDate(furn);
        return Msg.success();
    }

    @DeleteMapping("/del/{id}")
    @ResponseBody
    public Msg del(@PathVariable Integer id) {
        System.out.println("del id= " + id);
        furnService.deleteById(id);
        return Msg.success();
    }


    @ResponseBody
    @RequestMapping("/furnsByPage")
    public Msg listFurnsByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "5") Integer pageSize)
    {
//查询前，需要调用 PageHelper.startPage()
        PageHelper.startPage(pageNum, pageSize);
//在 PageHelper.startPage() 后调用 findAll 就是分页查询(物理分页有 limit)
        List<Furn> furnList = furnService.findAll();
//分页查询完之后，可以使用 pageInfo 来包装查询后的结果，
//1. 只需要将 pageInfo 交给页面就行
//2. pageInfo 封装了详细的分页信息，包括查询出来的数据 .比如总共有多少页，当前是第几页等
//3. 看源码 PageInfo(List<T> list, int navigatePages)
        PageInfo pageInfo = new PageInfo(furnList, pageSize);
        return Msg.success().add("pageInfo", pageInfo);
    }

    @ResponseBody
    @RequestMapping("/furnsBySearchPage")
    public Msg listFurnsByConditionPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                        @RequestParam(defaultValue = "5") Integer pageSize,
                                        @RequestParam(defaultValue = "") String search) {
        PageHelper.startPage(pageNum, pageSize);
        List<Furn> furnList = furnService.findByCondition(search);
        PageInfo pageInfo = new PageInfo(furnList, pageSize);
        return Msg.success().add("pageInfo", pageInfo);
    }

}
