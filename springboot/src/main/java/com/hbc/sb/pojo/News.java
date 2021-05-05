package com.hbc.sb.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*import com.sun.javafx.beans.IDProperty;
import javax.annotation.processing.Generated;*/
import javax.persistence.*;
@Entity
@Table(name = "news")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "newsid")
    int newsid;


    String newstitle;
    String newsimg1;
    String newsimg2;
    String newsjj; //简介
    String newsall; //详情
    String newskeyword; //关键词
    String newsother; //其他
    int newsgood;   //推荐
    String newsftime;//最初时间
    String newsltime;//最后时间

    public int getNewsid() {
        return newsid;
    }

    public void setNewsid(int newsid) {
        this.newsid = newsid;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    public String getNewsimg1() {
        return newsimg1;
    }

    public void setNewsimg1(String newsimg1) {
        this.newsimg1 = newsimg1;
    }

    public String getNewsimg2() {
        return newsimg2;
    }

    public void setNewsimg2(String newsimg2) {
        this.newsimg2 = newsimg2;
    }

    public String getNewsjj() {
        return newsjj;
    }

    public void setNewsjj(String newsjj) {
        this.newsjj = newsjj;
    }

    public String getNewsall() {
        return newsall;
    }

    public void setNewsall(String newsall) {
        this.newsall = newsall;
    }

    public String getNewskeyword() {
        return newskeyword;
    }

    public void setNewskeyword(String newskeyword) {
        this.newskeyword = newskeyword;
    }

    public String getNewsother() {
        return newsother;
    }

    public void setNewsother(String newsother) {
        this.newsother = newsother;
    }

    public String getNewsftime() {
        return newsftime;
    }

    public void setNewsftime(String newsftime) {
        this.newsftime = newsftime;
    }

    public String getNewsltime() {
        return newsltime;
    }

    public void setNewsltime(String newsltime) {
        this.newsltime = newsltime;
    }

    public int getNewsgood() {
        return newsgood;
    }

    public void setNewsgood(int newsgood) {
        this.newsgood = newsgood;
    }
}
