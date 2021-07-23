package com.zjj.photosinn.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @projectName: PhotosInn
 * @className: User
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/21 11:26
 * @version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
