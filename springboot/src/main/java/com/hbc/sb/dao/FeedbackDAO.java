package com.hbc.sb.dao;


import com.hbc.sb.pojo.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Map;


public interface FeedbackDAO extends JpaRepository<Feedback,Integer>,JpaSpecificationExecutor<Feedback> {

    /**
     * IP查询
     */
    Feedback findAllByFeedbackid(int feedbackid);


}
