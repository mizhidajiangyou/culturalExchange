package com.hbc.sb.controller;

import com.hbc.sb.pojo.News;
import com.hbc.sb.result.Result;
import com.hbc.sb.pojo.User;
import com.hbc.sb.result.ResultFactory;
import  com.hbc.sb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

/*import javax.servlet.http.HttpSession;*/
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin           //支持跨域合作
    @PostMapping(value = "/api/login")
    @ResponseBody          /*该注解用于读取Request请求的body部分数据，使用系统默认配置的HttpMessageConverter进行解析，然后把相应的数据绑定
    到要返回的对象上；
            2) 再把HttpMessageConverter返回的对象数据绑定到 controller中方法的参数上*/
    public Result login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);  //htmlEscape 属性作用理解为：是否转义字符， 默认为 true ，若要设置不对特殊字符进行转移，需设置为 false 。
        User user = userService.get(username, requestUser.getUserpassword());
        if (null == user) {
            String message = "账号或密码错误";
            return ResultFactory.buildFailResult(message);
        } else {
            String message = "成功";
            return ResultFactory.buildSuccessResult(message);
        }
    }

    @PostMapping("/api/getuserpower")
    @ResponseBody
    public int getuserpower(@RequestBody User rUser){
        String username=rUser.getUsername();
        username=HtmlUtils.htmlEscape(username);
        return userService.getuserpower(username);
    }





   /* public User getuser*/


}

/*public class LoginController {

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword())) {
            String message = "账号密码错误";
            System.out.println("FBI warning");
            return new Result(400);
        } else {
            return new Result(200);
        }
    }
}*/

/*登录控制器是我们功能的核心部分，尽管它十分简单。逻具体的实现，就是通过 UserService 提供的 get 方法查询数据库，
如果返回的对象为空，则验证失败，否则就验证成功。*/



