package com.zhunongyun.test.gitcommand.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import org.springframework.core.io.ClassPathResource;

import java.io.*;

public class App {
    public static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(filePath);
        String line; // 用来保存每行读取的内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(classPathResource.getInputStream()));
        // 读取第一行
        line = reader.readLine();
        // 如果 line 为空说明读完了
        while (line != null) {
            // 将读到的内容添加到 buffer 中
            buffer.append(line);
            // 添加换行符
            buffer.append("\n");
            // 读取下一行
            line = reader.readLine();
        }
        reader.close();
    }

    public static void main(String[] args) throws IOException {
//        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        StringBuffer stringBuffer = new StringBuffer();
        App.readToBuffer(stringBuffer, "demo.json");
        Object obj = JSON.parseObject(stringBuffer.toString());
    }
}