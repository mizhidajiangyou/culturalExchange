package com.hbc.sb.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@Table(name = "feedback")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})

public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedbackid")
    int feedbackid;

    int feedbacklike;
    String feedbackauthor;
    int feedbackgood;
    String feedbacktitle;
    String feedbackall;
    String feedbackbackauthor;
    String feedbackbackall;
    String feedbackftime;
    String feedbackltime;

    public int getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(int feedbackid) {
        this.feedbackid = feedbackid;
    }

    public int getFeedbacklike() {
        return feedbacklike;
    }

    public void setFeedbacklike(int feedbacklike) {
        this.feedbacklike = feedbacklike;
    }

    public String getFeedbackauthor() {
        return feedbackauthor;
    }

    public void setFeedbackauthor(String feedbackauthor) {
        this.feedbackauthor = feedbackauthor;
    }

    public int getFeedbackgood() {
        return feedbackgood;
    }

    public void setFeedbackgood(int feedbackgood) {
        this.feedbackgood = feedbackgood;
    }

    public String getFeedbacktitle() {
        return feedbacktitle;
    }

    public void setFeedbacktitle(String feedbacktitle) {
        this.feedbacktitle = feedbacktitle;
    }

    public String getFeedbackall() {
        return feedbackall;
    }

    public void setFeedbackall(String feedbackall) {
        this.feedbackall = feedbackall;
    }

    public String getFeedbackbackauthor() {
        return feedbackbackauthor;
    }

    public void setFeedbackbackauthor(String feedbackbackauthor) {
        this.feedbackbackauthor = feedbackbackauthor;
    }

    public String getFeedbackbackall() {
        return feedbackbackall;
    }

    public void setFeedbackbackall(String feedbackbackall) {
        this.feedbackbackall = feedbackbackall;
    }

    public String getFeedbackftime() {
        return feedbackftime;
    }

    public void setFeedbackftime(String feedbackftitme) {
        this.feedbackftime = feedbackftitme;
    }

    public String getFeedbackltime() {
        return feedbackltime;
    }

    public void setFeedbackltime(String feedbackltime) {
        this.feedbackltime = feedbackltime;
    }
}
