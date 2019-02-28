package com.zhunongyun.test.gitcommand.common;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zhunongyun.test.gitcommand.entity.User;

public class TestFastJson {

    public static void main(String[] args) {
//        ParserConfig.getGlobalInstance().addAccept("com.taobao.pac.client.sdk.dataobject.");
//        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);

        Map<String, Object> map = new HashMap<>(16);
        map.put("key1", "One");
        map.put("key2", "Two");
        String mapJson = JSON.toJSONString(map);
        System.out.println(mapJson);

        User user1 = new User();
        user1.setUserName("xiaoming");
        user1.setSex("male");
        System.out.println("obj name:" + user1.getClass().getName());

        //序列化
        String serializedStr = JSON.toJSONString(user1);
        System.out.println("serializedStr=" + serializedStr);

        String serializedStr1 = JSON.toJSONString(user1, SerializerFeature.WriteClassName);
        System.out.println("serializedStr1=" + serializedStr1);

        //通过parse方法进行反序列化
        User user2 = (User) JSON.parse(serializedStr1);
        System.out.println(user2.getUserName());

        //通过parseObject方法进行反序列化  通过这种方法返回的是一个JSONObject
        Object obj = JSON.parseObject(serializedStr1);
        System.out.println(obj);
        System.out.println("obj name:" + obj.getClass().getName() + "\n");

        //通过这种方式返回的是一个相应的类对象
        Object obj1 = JSON.parseObject(serializedStr1, Object.class);
        System.out.println(obj1);
        System.out.println("obj1 name:" + obj1.getClass().getName());

    }
}