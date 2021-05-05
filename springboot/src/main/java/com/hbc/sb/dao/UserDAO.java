package com.hbc.sb.dao;

import com.hbc.sb.pojo.User;
import com.hbc.sb.pojo.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*public interface UserDAO {
}*/

public interface UserDAO extends JpaRepository<User,Integer> , JpaSpecificationExecutor<User> {
    User findByUsername(String username);

    User getByUsernameAndUserpassword(String username,String userpassword);


    /**
     * 仅获取权限防止密码泄露
     */
    @Query(value = "select userpower from  user  where username=?1  ",nativeQuery = true)
    int finduserpower(String username);



}


//这里关键的地方在于方法的名字。由于使用了 JPA，无需手动构建 SQL 语句，而只需要按照规范提供方法的名字即可实现对数据npm库的增删改查。
//如 findByUsername，就是通过 username 字段查询到对应的行，并返回给 User 类。
//这里我们构建了两个方法，一个是通过用户名查询，一个是通过用户名及密码查询。
