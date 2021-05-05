package com.hbc.sb.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@Table(name = "comment")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentid")
    int commentid;

    String commentauthor;
    String commentftime;
    String commentltime;
    String commentall;
    int cworkid;
    int backid;

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public String getCommentauthor() {
        return commentauthor;
    }

    public void setCommentauthor(String commentauthor) {
        this.commentauthor = commentauthor;
    }

    public String getCommentftime() {
        return commentftime;
    }

    public void setCommentftime(String commentftime) {
        this.commentftime = commentftime;
    }

    public String getCommentltime() {
        return commentltime;
    }

    public void setCommentltime(String commentltime) {
        this.commentltime = commentltime;
    }

    public String getCommentall() {
        return commentall;
    }

    public void setCommentall(String commentall) {
        this.commentall = commentall;
    }

    public int getcworkid() {
        return cworkid;
    }

    public void setcworkid(int c_workid) {
        this.cworkid = c_workid;
    }

    public int getBackid() {
        return backid;
    }

    public void setBackid(int backid) {
        this.backid = backid;
    }
}
