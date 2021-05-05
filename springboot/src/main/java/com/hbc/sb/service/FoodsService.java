package com.hbc.sb.service;

import com.hbc.sb.dao.FoodsDAO;
import com.hbc.sb.pojo.Foods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FoodsService {
    @Autowired
    FoodsDAO foodsDAO;

    /**
     * 查询
     */
    public List<Foods> findfoodsall(){return foodsDAO.findAll();}

    /**
     * 存
     */
    public  void  savefoods(Foods foods){foodsDAO.save(foods);}

    /**
     * 删
     */
    public void deletefoods(int foodsid){foodsDAO.deleteById(foodsid);}

    /**
     *  根据ID查询
     */
    public Foods getfoodsbyid(int foodsid){return foodsDAO.findAllByFoodsid(foodsid);}


    /**
     * 后台推荐
     * @return
     */
    public List<Foods> getgoodfoods(){return foodsDAO.findgoodfoods();}

    /**
     * 前台推荐
     */
    public  List<Map<String,String>> getgoodfoodsqt(){return  foodsDAO.findgoodfoodsqt();}


    /**
     * 前台列表
     */
    public    List<Map<String,String>> getgoodslistqt(){return  foodsDAO.findgoodslistqt();}





}
