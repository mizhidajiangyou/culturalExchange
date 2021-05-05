package com.hbc.sb.dao;

import com.hbc.sb.pojo.News;
import  com.hbc.sb.pojo.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Map;

public interface WorkDAO extends JpaRepository<Work,Integer>,JpaSpecificationExecutor<Work>{

    /**
     * 重写findall
     */
    @Query(value = "select * from work   order by workltime desc  ",nativeQuery = true)
   List<Work> findAll();

    /**
     * 模糊查询
     */
   List<Work> findAllByWorktitleLikeOrWorkcategoryLikeOrWorkstateLike(String worktitle, String workcategory, String workstate);

}
