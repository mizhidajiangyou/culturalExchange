package com.hbc.sb.controller;

import com.hbc.sb.pojo.Comment;
import com.hbc.sb.pojo.Foods;
import com.hbc.sb.result.Result;
import com.hbc.sb.result.ResultFactory;
import com.hbc.sb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    /**
     * findall
     */
    @GetMapping("/api/commentall")
    public List<Comment> getallcomment(){return commentService.getallcomment();}

    /**
     * save
     */
    @PostMapping("/api/savecomment")
    @ResponseBody
    public Result savecomment(@RequestBody Comment comment){
        commentService.savecomment(comment);
        String message="保存成功";
        return  ResultFactory.buildSuccessResult(message);
    }

    /**
     * delete
     */
    @PostMapping("/api/deletecomment")
    @ResponseBody
    public Result deletecomment(@RequestBody Comment comment){
        commentService.deletecomment(comment.getCommentid());
        String message="delete成功";
        return  ResultFactory.buildSuccessResult(message);
    }

    /**
     *get by workid
     */
    @GetMapping("/api/getbyworkid")
    public  List<Comment> getbyworkid(int workid){return commentService.getallbyworkid(workid);}





}
