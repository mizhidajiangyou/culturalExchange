package com.hbc.sb.service;

import com.hbc.sb.dao.WorkDAO;
import com.hbc.sb.pojo.News;
import com.hbc.sb.pojo.Work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WorkService {

    @Autowired
    WorkDAO workDAO;

       /**
     * 查询全部work
     */
    public List<Work> getallwork(){return workDAO.findAll();}

    /**
     * 增加工作
     * @return
     */
    public void savework(Work work){  workDAO.save(work);}

    /**
     * 删除
     */
    public void  deletework(int workid){ workDAO.deleteById(workid);}

    /**
     * 模糊查询

     */
    public  List<Work> worksearch(String keywords){return workDAO.findAllByWorktitleLikeOrWorkcategoryLikeOrWorkstateLike('%'+keywords+'%' ,'%'+keywords+'%','%'+keywords+'%');}



}
