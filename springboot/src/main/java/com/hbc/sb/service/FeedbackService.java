package com.hbc.sb.service;

import com.hbc.sb.dao.FeedbackDAO;
import com.hbc.sb.pojo.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    FeedbackDAO feedbackDAO;

    /**
     * 查询
     */
    public List<Feedback> findfeedbackall(){return feedbackDAO.findAll();}

    /**
     * 存
     */
    public  void  savefeedback(Feedback feedback){feedbackDAO.save(feedback);}

    /**
     * 删
     */
    public void deletefeedback(int feedbackid){feedbackDAO.deleteById(feedbackid);}

    /**
     *  根据ID查询
     */
    public Feedback getfeedbackbyid(int feedbackid){return feedbackDAO.findAllByFeedbackid(feedbackid);}
}
