package com.hbc.sb.controller;

import com.hbc.sb.pojo.Feedback;
import com.hbc.sb.result.Result;
import com.hbc.sb.result.ResultFactory;
import com.hbc.sb.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeedbackController {
    
    @Autowired
    FeedbackService feedbackService;

    /**
     * 查
     */
    @GetMapping("/api/feedbackall")
    public List<Feedback> feedbacklistall(){ return feedbackService.findfeedbackall();}

    /**
     * 存
     */
    @PostMapping("/api/savefeedback")
    @ResponseBody
    public Result savefeedback(@RequestBody Feedback requestfeedback) {
        feedbackService.savefeedback(requestfeedback);
        String message="保存成功";
        return  ResultFactory.buildSuccessResult(message);
    }


    /**
     *删
     */
    @PostMapping("/api/deletefeedback")
    @ResponseBody
    public Result deletework(@RequestBody Feedback requestfeedback){
        feedbackService.deletefeedback(requestfeedback.getFeedbackid());
        String message="删除成功";
        return  ResultFactory.buildSuccessResult(message);

    }

    /**
     *根据ID查询
     */
    @GetMapping("/api/getfeedbackbyid")
    public Feedback getfeedbackbyid(int feedbackid){return feedbackService.getfeedbackbyid(feedbackid);}
    
}
