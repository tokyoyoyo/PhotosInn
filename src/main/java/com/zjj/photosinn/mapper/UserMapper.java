package com.zjj.photosinn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjj.photosinn.beans.Photo;
import com.zjj.photosinn.beans.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @projectName: PhotosInn
 * @className: UserMapper
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/22 9:04
 * @version: 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select password from user where name=#{name}")
    String getPasswordByName(String name);
}
