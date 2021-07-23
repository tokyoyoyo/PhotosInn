package com.zjj.photosinn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class PhotosInnApplicationTests {

    @Value("${web.upload-path}")
    private String uploadPath;
//    文件上传路径

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
    //    指定日期格式
    @Test
    void contextLoads() {
        String format = sdf.format(new Date());
        File folder = new File(uploadPath + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
    }

}
