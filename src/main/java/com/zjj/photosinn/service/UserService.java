package com.zjj.photosinn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjj.photosinn.beans.Photo;
import com.zjj.photosinn.beans.User;

/**
 * @projectName: PhotosInn
 * @className: UserService
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/22 9:05
 * @version: 1.0
 */

public interface UserService extends IService<User> {

    String getPasswordByName(String name);
}
