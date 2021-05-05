package com.hbc.sb.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*import com.sun.javafx.beans.IDProperty;
import javax.annotation.processing.Generated;*/
import javax.persistence.*;

@Entity    //声明实体类
@Table(name = "user")  //配置实体类和表的映射关系
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
/*@Entity 表示这是一个实体类
@Table(name=“user”) 表示对应的表名是 user

为了简化对数据库的操作，我们使用了 Java Persistence API（JPA），对于 @JsonIgnoreProperties({ “handler”,“hibernateLazyInitializer” })，解释起来比较复杂，下面的话看不懂可以忽略：

因为是做前后端分离，而前后端数据交互用的是 json 格式。 那么 User 对象就会被转换为 json 数据。 而本项目使用 jpa 来做实体类的持久化，jpa 默认会使用 hibernate, 在 jpa 工作过程中，
就会创造代理类来继承 User ，并添加 handler 和 hibernateLazyInitializer 这两个无须 json 化的属性，所以这里需要用 JsonIgnoreProperties 把这两个属性忽略掉。
*/

public class User {
    @Id  //声明主键配置
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自增
    @Column(name = "userid")  //配置属性和字段的映射关系
    int id;

    String username;

    String userpassword;

    int userpower;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public int getUserpower() {
        return userpower;
    }

    public void setUserpower(int userpower) {
        this.userpower = userpower;
    }
}




