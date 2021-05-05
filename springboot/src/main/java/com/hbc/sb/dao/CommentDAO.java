package com.hbc.sb.dao;

import com.hbc.sb.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CommentDAO extends JpaSpecificationExecutor<Comment>, JpaRepository<Comment,Integer> {

    /**
     * 根据workid查询全部的评论
     */
    List<Comment> getAllByCworkid(int workid);
}
