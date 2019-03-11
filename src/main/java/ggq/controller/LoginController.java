package ggq.controller;

import ggq.model.UserLoginModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class LoginController {
    //todo
    // 登陆以后需要返回
    // {"status":"ok","type":"account","currentAuthority":"user"}

    @RequestMapping(value = "/api/login/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(UserLoginModel model){
        return "{\"status\":\"ok\",\"type\":\"account\",\"currentAuthority\":\"user\"}";
    }
}
