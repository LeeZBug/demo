package com.lizhejie.demo.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {

    @RequestMapping("doLogin")
    public String doLogin(String username, String password) {
        if ("zhang".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001);
            SaTokenInfo tokeninfo = StpUtil.getTokenInfo();
            return tokeninfo.getTokenValue();
        }
        return "登录失败";
    }

    @RequestMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录:" + StpUtil.isLogin();
    }

    @RequestMapping("checklogin")
    public String checklogin() {
        StpUtil.checkLogin();
        return "111";
    }
}

