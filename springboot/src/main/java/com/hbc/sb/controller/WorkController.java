package com.hbc.sb.controller;


import com.hbc.sb.pojo.News;
import com.hbc.sb.pojo.Work;
import com.hbc.sb.result.Result;
import com.hbc.sb.result.ResultFactory;
import com.hbc.sb.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkController {
    @Autowired
    WorkService workService;

    /**
     *全部工作信息
     */
    @GetMapping("/api/workall")
    public List<Work> worklistall()  {return workService.getallwork();}

    /**
     * 保存工作
     */
    @PostMapping("/api/savework")
    @ResponseBody
    public Result savework(@RequestBody Work requestwork) {
        if (null == requestwork) {
            String message = "保存工作失败";
            return ResultFactory.buildFailResult(message);
        } else {
            workService.savework(requestwork);
            String message = "保存工作成功";
            return ResultFactory.buildSuccessResult(message);

        }
    }


    /**
     *删
     */
    @PostMapping("/api/deletework")
    @ResponseBody
    public Result deletework(@RequestBody Work requestwork){
        workService.deletework(requestwork.getWorkid());
        String message="删除成功";
        return  ResultFactory.buildSuccessResult(message);

    }


    /**
     * 根据标题模糊查询
     */
    @GetMapping("/api/worksearch")
    public  List<Work> worksearch(@RequestParam("keywords") String keywords){
        if("".equals(keywords)){
            return  workService.getallwork();
        }
        else {
            return  workService.worksearch(keywords);
        }
    }

}
