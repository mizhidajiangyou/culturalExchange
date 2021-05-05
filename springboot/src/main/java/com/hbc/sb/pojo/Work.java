package com.hbc.sb.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
@Entity
@Table(name = "work")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workid")
    int workid;


    String worktitle;
    String workauthor;
    String workall;
    String workcategory;
    String workstate;
    String workaq;
    String workftime;
    String workltime;


    public int getWorkid() {
        return workid;
    }

    public void setWorkid(int workid) {
        this.workid = workid;
    }

    public String getWorktitle() {
        return worktitle;
    }

    public void setWorktitle(String worktitle) {
        this.worktitle = worktitle;
    }

    public String getWorkauthor() {
        return workauthor;
    }

    public void setWorkauthor(String workauthor) {
        this.workauthor = workauthor;
    }

    public String getWorkall() {
        return workall;
    }

    public void setWorkall(String workall) {
        this.workall = workall;
    }

    public String getWorkcategory() {
        return workcategory;
    }

    public void setWorkcategory(String workcategory) {
        this.workcategory = workcategory;
    }

    public String getWorkstate() {
        return workstate;
    }

    public void setWorkstate(String workstate) {
        this.workstate = workstate;
    }

    public String getWorkaq() {
        return workaq;
    }

    public void setWorkaq(String workaq) {
        this.workaq = workaq;
    }

    public String getWorkftime() {
        return workftime;
    }

    public void setWorkftime(String workftime) {
        this.workftime = workftime;
    }

    public String getWorkltime() {
        return workltime;
    }

    public void setWorkltime(String workltime) {
        this.workltime = workltime;
    }
}
