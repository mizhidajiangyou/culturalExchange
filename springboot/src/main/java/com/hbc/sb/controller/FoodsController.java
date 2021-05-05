package com.hbc.sb.controller;

import com.hbc.sb.pojo.Foods;
import com.hbc.sb.pojo.Work;
import com.hbc.sb.service.FoodsService;
import com.hbc.sb.result.Result;
import com.hbc.sb.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class FoodsController {
    @Autowired
    FoodsService foodsService;

    /**
     * 查
     */
    @GetMapping("/api/foodsall")
    public List<Foods> foodslistall(){ return foodsService.findfoodsall();}

    /**
     * 存
     */
    @PostMapping("/api/savefoods")
    @ResponseBody
    public Result savefoods(@RequestBody Foods requestfoods) {
        foodsService.savefoods(requestfoods);
        String message="保存成功";
        return  ResultFactory.buildSuccessResult(message);
    }


    /**
     *删
     */
    @PostMapping("/api/deletefoods")
    @ResponseBody
    public Result deletework(@RequestBody Foods requestfoods){
        foodsService.deletefoods(requestfoods.getFoodsid());
        String message="删除成功";
        return  ResultFactory.buildSuccessResult(message);

    }

    /**
     *根据ID查询
     */
    @GetMapping("/api/getfoodsbyid")
    public Foods getfoodsbyid(int foodsid){return foodsService.getfoodsbyid(foodsid);}

    /**
     * 后台推荐
     * @return
     */
    @GetMapping("/api/getgoodfoods")
    public List<Foods> getgoodfoods(){return foodsService.getgoodfoods();}

    /**
     * 前台推荐
     */
    @GetMapping("/api/getgoodfoodsqt")
    public  List<Map<String,String>> getgoodfoodsqt(){return  foodsService.getgoodfoodsqt();}

    /**
     * 前台列表
     *///这里foods打成goods了懒得改了
    @GetMapping("/api/getgoodslistqt")
    public    List<Map<String,String>> getgoodslistqt(){return  foodsService.getgoodslistqt();}


}
