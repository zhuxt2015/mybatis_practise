package com.zhuxt.mybatis.dao;

import com.zhuxt.mybatis.entity.User;

import java.util.List;

/**
 * Created by zhuxt on 17/2/28.
 */
public interface UserDao {

    void save(User user);

    User getById(int id);

    List<User> list();

}
