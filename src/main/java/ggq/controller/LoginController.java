package ggq.controller;

import com.alibaba.fastjson.JSON;
import ggq.mapper.UserTableMapper;
import ggq.model.UserLoginModel;
import ggq.model.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
@Controller
public class LoginController {
    //todo
    // 登陆以后需要返回
    // {"status":"ok","type":"account","currentAuthority":"user"}
    private static final String SALT = "ttt1111";

    @Autowired
    UserTableMapper userTableMapper;

    @RequestMapping(value = "/api/login/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody UserLoginModel model) {
        Md5PasswordEncoder md5 = new Md5PasswordEncoder();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("type", "account");
        map.put("currentAuthority", "user");

        String userName = model.getUserName();
        System.out.println(userName);
        UserTable userByUserName = userTableMapper.getUserByUserName(userName);
        if (userByUserName == null) {
            map.put("status", "error");
        } else {

            String password = model.getPassword();
            boolean passwordValid = md5.isPasswordValid(userByUserName.getUserPassword(), password, SALT);
            if (passwordValid) {
                map.put("status", "ok");
            } else {
                map.put("status", "error");
            }
        }
        return JSON.toJSONString(map);
    }
}
