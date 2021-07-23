package com.zjj.photosinn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjj.photosinn.beans.Photo;
import com.zjj.photosinn.mapper.PhotoMapper;
import com.zjj.photosinn.service.PhotoService;
import org.springframework.stereotype.Service;

/**
 * @projectName: PhotosInn
 * @className: PhotoServiceImpl
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/21 15:53
 * @version: 1.0
 */

@Service
public class PhotoServiceImpl extends ServiceImpl<PhotoMapper,Photo> implements PhotoService {
}
