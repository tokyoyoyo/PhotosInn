package com.zjj.photosinn.beans;

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
    String uuid;
    String owner;
    Date date;
    String path;
    String name;
    Long size;
}
