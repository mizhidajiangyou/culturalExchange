package com.hbc.sb.dao;

import com.hbc.sb.pojo.Foods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Map;


public interface FoodsDAO extends JpaRepository<Foods,Integer>,JpaSpecificationExecutor<Foods>{

    /**
     *ip查询
     */
    Foods findAllByFoodsid(int foodsid);

    /**
     * 后台推荐
     */
    @Query(value = "select * from foods where foodsgood>0",nativeQuery = true)
    List<Foods> findgoodfoods();

    /**
     * 前台推荐
     */
    @Query(value = "select foodsid,foodsname,foodsimg2 from foods where foodsgood>0 order by foodsltime desc limit 5",nativeQuery = true)
    List<Map<String,String>> findgoodfoodsqt();

    /**
     * 前台列表
     */
    @Query(value = "select foodsid,foodsname,foodsimg1 from foods ",nativeQuery = true)
    List<Map<String,String>> findgoodslistqt();


}

