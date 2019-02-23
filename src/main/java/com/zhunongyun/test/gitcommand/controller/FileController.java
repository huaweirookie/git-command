package com.zhunongyun.test.gitcommand.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @ClassName FileController
 * @Description TODO
 * @Author 悠娜的奶爸
 * @Date 2019-02-23 15:12
 * @Version 1.0
 **/
@RestController
@RequestMapping("file")
public class FileController {

    private final static String FILE_PATH = "/Users/oscar/Documents/code_test/";

    /**
     * 文件下载
     *
     * @param fileName
     * @param response
     * @return
     */
    @GetMapping("download/{fileName}")
    public void downloadFile(@PathVariable("fileName") String fileName, HttpServletResponse response) {
        this.commonDownloadFile(fileName, response);
    }

    /**
     * 文件下载
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("downloadTest")
    public void downloadFileTest(HttpServletRequest request, HttpServletResponse response) {
        this.commonDownloadFile(request.getParameter("fileName"), response);
    }

    private void commonDownloadFile (String fileName, HttpServletResponse response){
        File file = new File(FILE_PATH, fileName);

        // 如果文件名存在，则进行下载
        if (file.exists()) {

            FileInputStream fis = null;
            BufferedInputStream bis = null;

            try {
                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

                // 实现文件下载
                byte[] buffer = new byte[1024];


                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                System.out.println("Download the song successfully!");
            } catch (Exception e) {
                System.out.println("Download the song failed!");
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
