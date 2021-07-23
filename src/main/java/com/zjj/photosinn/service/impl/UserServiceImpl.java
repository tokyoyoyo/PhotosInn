package com.zjj.photosinn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjj.photosinn.beans.User;
import com.zjj.photosinn.mapper.UserMapper;
import com.zjj.photosinn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName: PhotosInn
 * @className: UserServiceImpl
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/22 9:05
 * @version: 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    public String getPasswordByName(String name){
        return userMapper.getPasswordByName(name);
    }

}
