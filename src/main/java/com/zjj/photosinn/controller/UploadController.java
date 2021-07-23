package com.zjj.photosinn.controller;

import com.zjj.photosinn.beans.Photo;
import com.zjj.photosinn.mapper.PhotoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

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

//    final private String localIp =new Util().getLocalIP();
//    本机IP

    @Value("${web.upload-path}")
    private String uploadPath;
//    文件上传路径

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
//    指定日期格式

    @Autowired
    PhotoMapper photoMapper;



    @PostMapping("/upload")
    public String visitorUpload(@RequestPart("photos") MultipartFile[] photos,
                                HttpServletRequest request,
                         Model model) throws IOException {

        log.info("游客上传了:photos={}",photos.length);

//        Map<Photo,String> map = new HashMap<>();
        List<Photo> list = new ArrayList<>();
//        图片实例列表
        String date = sdf.format(new Date());
        String path = "visitor/"+date;

        File folder = new File(uploadPath + path);
        //创建绝对路径

        if(!folder.isDirectory()){
           if(!folder.mkdirs()){
               log.warn("创建失败");
           }
        }
        //如果不存在该文件夹，创建

        if(photos.length > 0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    String fileName = DigestUtils.md5DigestAsHex(photo.getOriginalFilename().getBytes());
                    fileName = fileName.substring(0,13).toUpperCase(Locale.ROOT)+".jpg";
                    //MD5编码,文件重命名

                    try {
                        photo.transferTo(new File(folder,fileName));

                    }catch (IOException e){
                        log.info("写入文件失败 ："+e);
                        throw e;
                    }

                    Photo p = new Photo();
//                    构造图片实例
                    String url = request.getScheme() + "://" + request.getServerName()
                            + ":" + request.getServerPort() +"/" +path + fileName;
//                    保存url
                    p.setName(fileName);
                    p.setDate(sdf.format(new Date()));
                    p.setOwner("游客");
                    p.setPath(path);

//                    将图片信息插入数据库
                    photoMapper.insert(p);

                    p.setPath(url);

//                    map.put(p,url);
                    list.add(p);
                    //  将实例放入list,传到前端
                }
            }
        }
//        model.addAttribute("map",map);
        model.addAttribute("list",list);

        return "home";
    }

}

