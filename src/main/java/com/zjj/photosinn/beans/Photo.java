package com.zjj.photosinn.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.Date;

/**
 * @projectName: PhotosInn
 * @className: Photo
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/21 11:26
 * @version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Photo {

    @TableId(value = "uuid",type = IdType.AUTO)
    private Integer uuid;
    private String owner;
    private String date;
    private String path;
    private String name;
}
