package com.hbc.sb.service;

import com.hbc.sb.dao.CommentDAO;
import com.hbc.sb.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentDAO commentDAO;

    /**
     * findall
     */
    public List<Comment> getallcomment(){return commentDAO.findAll();}

    /**
     * save
     */
    public void savecomment(Comment comment){commentDAO.save(comment);}

    /**
     * delete
     */
    public  void deletecomment(int commentid){commentDAO.deleteById(commentid);}

    /**
     * getbyworkid
     */
    public List<Comment> getallbyworkid(int workid){return commentDAO.getAllByCworkid(workid);}

}
