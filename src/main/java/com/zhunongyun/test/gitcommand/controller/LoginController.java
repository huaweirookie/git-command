package com.zhunongyun.test.gitcommand.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author 悠娜的奶爸
 * @Date 2019-01-30 11:19
 * @Version 1.0
 **/
@RestController
@RequestMapping("login")
public class LoginController {

    /**
     * 登录接口
     * @param object
     * @return
     */
    @PostMapping
    public Object login(Object object) {
        return object;
    }
}