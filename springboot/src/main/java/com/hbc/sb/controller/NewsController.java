package com.hbc.sb.controller;
import com.hbc.sb.result.Result;
import com.hbc.sb.pojo.News;
import com.hbc.sb.result.ResultFactory;
import  com.hbc.sb.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;


@RestController
public class NewsController {
    @Autowired
    NewsService newsService;

    /**
     * 全部新闻
     */
    @CrossOrigin
    @GetMapping("/api/newsall")
    public  List<News> allnewslist() throws Exception{
        return newsService.getallnews();
    }

    /**
     * 根据ID查询新闻
     */
    @CrossOrigin
    @GetMapping("/api/findnewsforid")
    public News newfindforid( /*News requestnews*//* @RequestParam("newsid")*/ int newsid) {
        return newsService.getallbyid(newsid);
    }

    /**
     * 添加资讯接口(改也是这个接口)
     */
    @CrossOrigin
    @PostMapping("/api/addnews")
    @ResponseBody
    public Result addnews(@RequestBody News requestnews) {
        if(null==requestnews) {
            String message = "添加资讯失败";
            return ResultFactory.buildFailResult(message);
        }
        else{
            newsService.savanews(requestnews);
            String message = "添加资讯成功";
            return ResultFactory.buildSuccessResult(message);

        }


    }

    /**
     * 删除新闻
     */
    @CrossOrigin
    @PostMapping("/api/deletenews")
    @ResponseBody
    public Result deletenews(@RequestBody News requestnews) {

        if(null==requestnews){
            String message = "删除失败";
            return ResultFactory.buildFailResult(message);
        }
        else{
            newsService.deletenews(requestnews.getNewsid());
            String message = "删除成功";
            return ResultFactory.buildSuccessResult(message);
        }


    }

    /**
     * 上传图片接口
     */
    @CrossOrigin        //图片接口
    @PostMapping("api/covers")
    public String coversUpload(MultipartFile file) throws Exception {
        return newsService.coversUpload(file);
    }

    /**
     * 根据标题模糊查询
     */
    @CrossOrigin
    @GetMapping("/api/newssearch")
    public  List<News> newssearch(@RequestParam("keywords") String keywords){
        if("".equals(keywords)){
            return  newsService.getallnews();
        }
        else {
            return  newsService.Searchbtnewstitle(keywords);
        }
    }

    /**
     * 全部的推荐资讯
     */
    @CrossOrigin
    @GetMapping("/api/newsgoodall")
    public  List<News> thegoodnews() throws Exception{
        return newsService.getallgoodnews();
    }

    /**
     * 前台新闻获取
     */
    @CrossOrigin
    @GetMapping("/api/newsqt")
    public  List<Map<String,String>> newstitleall() throws Exception{
        return newsService.getnewsqt();
    }

    /**
     *  首页头条
     */
    @CrossOrigin
    @GetMapping("/api/newstoutiao")
    public  List<News> qtgoodnews() throws Exception{
        return newsService.gettoutiaoqt();
    }

    /**
     * 首页上部推荐
     */
    @CrossOrigin
    @GetMapping("/api/newstopqt")
    public  List<Map<String,String>> newstopqt() throws Exception{
        return newsService.getgoodnewstop();
    }

    /**
     * 首页下部推荐
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @GetMapping("/api/newsbottomqt")
    public  List<Map<String,String>> newbottomqt() throws Exception{
        return newsService.getgoodnewsbottom();
    }

    /**
     * 首页资讯轮播
     */
    @CrossOrigin
    @GetMapping("/api/newslunboqt")
    public  List<Map<String,String>> newlunboqt() throws Exception{
        return newsService.getgoodnewslunbo();
    }









}
