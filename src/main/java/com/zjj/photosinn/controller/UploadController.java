package com.zjj.photosinn.controller;

import com.zjj.photosinn.beans.Photo;
import com.zjj.photosinn.service.PhotoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @projectName: PhotosInn
 * @className: UploadController
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/21 11:23
 * @version: 1.0
 */

@Slf4j
@Controller
public class UploadController {

    @PostMapping("/upload")
    public String upload(@RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("游客上传了:photos={}",photos.length);

        if(photos.length > 0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File(
                            System.getProperty("user.dir")+
                                    "\\src\\main\\resources\\static\\Photos\\visitor\\"+
                                    originalFilename));

                    Photo p = new Photo();
                    p.setName(originalFilename);
                    p.setDate(new Date());
                    p.setOwner("游客");
                    p.setPath("Photos/visitor");
                    p.setSize(photo.getSize());




                }
            }
        }
        return "home";
    }
}
