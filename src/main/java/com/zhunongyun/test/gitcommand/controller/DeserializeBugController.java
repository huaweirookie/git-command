package com.zhunongyun.test.gitcommand.controller;

import com.zhunongyun.test.gitcommand.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DeserializeBugController
 * @Description TODO
 * @Author 悠娜的奶爸
 * @Date 2019-02-28 21:25
 * @Version 1.0
 **/
@RestController
@RequestMapping("deserialize")
public class DeserializeBugController {

    @PostMapping("test")
    public String deserializeTest(@RequestBody User user){
        return null;
    }
}
