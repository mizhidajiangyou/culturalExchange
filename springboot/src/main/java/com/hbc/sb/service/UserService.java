package com.hbc.sb.service;

import com.hbc.sb.dao.UserDAO;
import  com.hbc.sb.pojo.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean isExist(String username) {
        User user = getByName(username);
        return null!=user;
    }
    //exists()
    //public boolean exists()测试此抽象路径名表示的文件或目录是否存在.
    //返回:当且仅当此抽象路径名表示的文件或目录存在时,返回true;否则返回false;
    //抛出:SecurityException如果存在安全管理器,且其SecurityManager.checkRead(java.lang.String)方法拒绝对文件或目录进行写访问.

    public User getByName(String username) {
        return userDAO.findByUsername(username);
    }

    public User get(String username, String userpassword){
        return userDAO.getByUsernameAndUserpassword(username, userpassword);
    }

    public int getuserpower(String username){return userDAO.finduserpower(username);}
}

//这里实际上是对 UserDAO 进行了二次封装，一般来讲，我们在 DAO 中只定义基础的增删改查操作，而具体的操作，需要由 Service 来完成。
//当然，由于我们做的操作原本就比较简单，所以这里看起来只是简单地重命名了一下，比如把 “通过用户名及密码查询并获得对象” 这种方法命名为 get。

