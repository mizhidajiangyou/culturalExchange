package com.hbc.sb.service;
import com.hbc.sb.dao.NewsDAO;
import com.hbc.sb.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class NewsService {

    @Autowired
    NewsDAO newsDAO;



    /**
     * 全部资讯
     */
    public List<News> getallnews(){ return newsDAO.findAll(); }

    /**
     * 根据ID查询资讯

     */
    public  News getallbyid(int newsid){ return  newsDAO.findAllByNewsid(newsid); }

    /**
     * 增，改资讯

     */
    public void savanews(News news){ newsDAO.save(news); }

    /**
     * 删除资讯

     */
    public void deletenews(int newsid){ newsDAO.deleteById(newsid); }

    /**
     *图片上传接口，取随机
     */
    public String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "D:/workspace/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, getRandomString(10) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 根据标题模糊查找
     */
    public List<News> Searchbtnewstitle(String keywords){ return  newsDAO.findAllByNewstitleLike('%'+keywords+'%' ); }

    /**全部推荐新闻
     *
     */
    public List<News> getallgoodnews(){return newsDAO.findAllByNewsgood();}

    /**
     * 前台获取资讯
     */
    public  List<Map<String,String>> getnewsqt(){return  newsDAO.findnewsqt();}

    /**
     * 前台头条
     */
    public  List<News> gettoutiaoqt(){return newsDAO.findnewstoutiao();}

    /**
     *前台推荐上半
     */
    public List<Map<String,String>> getgoodnewstop(){return newsDAO.findnewstopqt();}

    /**
     *前台推荐下半
     */
    public List<Map<String,String>> getgoodnewsbottom(){return newsDAO.findnewsbottomqt();}

    /**
     *前台推荐轮播
     */
    public List<Map<String,String>> getgoodnewslunbo(){return newsDAO.findnewslunboqt();}



}



