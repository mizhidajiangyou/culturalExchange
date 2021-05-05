package com.hbc.sb.dao;

import  com.hbc.sb.pojo.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Map;

/**
 * JpaRepository<实体类类型，主键类型>：用来完成基本CRUD操作
 * JpaSpecificationExecutor<实体类类型>：用于复杂查询（分页等查询操作）
 */
/**
 * 使用sql查询
 * nativeQuery = true:使用sql查询
 * nativeQuery = false:使用jpql查询，默认就是false
 */
//@Service
public interface NewsDAO extends JpaRepository<News,Integer> , JpaSpecificationExecutor<News>{

    /**
     * 根据id查找
     */
    News findAllByNewsid(int newsid);

    /**
     * 全部推荐新闻
     */
    @Query(value = "select * from news where newsgood>0",nativeQuery = true)
    List<News> findAllByNewsgood();

    /**
     * 前台仅获取id标题简介图
     */
    @Query(value = "select newsid,newstitle,newsjj,newsimg1 from news ",nativeQuery = true)
    List<Map<String,String>> findnewsqt();

    /**
     * 模糊查询

     */
    List<News> findAllByNewstitleLike(String keywords);

    /**
     * 头条

     */
    @Query(value = "select * from news where newsgood=99  order by newsltime desc limit 1  ",nativeQuery = true)
    List<News> findnewstoutiao();

    /**
     *前台推荐上半
     */
    @Query(value = "select newsid,newstitle from news where newsgood=2  order by newsltime desc limit 4  ",nativeQuery = true)
    List<Map<String,String>> findnewstopqt();

    /**
     *前台推荐下半
     */
    @Query(value = "select newsid,newstitle from news where newsgood=3  order by newsltime desc limit 4  ",nativeQuery = true)
    List<Map<String,String>> findnewsbottomqt();

    /**
     *前台推荐轮播
     */
    @Query(value = "select newsid,newstitle,newsimg2 from news where newsgood=4  order by newsltime desc limit 4  ",nativeQuery = true)
    List<Map<String,String>> findnewslunboqt();




}
