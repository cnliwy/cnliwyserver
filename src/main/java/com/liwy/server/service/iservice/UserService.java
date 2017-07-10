package com.liwy.server.service.iservice;

import com.liwy.server.entity.User;

import java.util.List;

/**
 * Created by admin on 2017/7/8.
 */
public interface UserService {
    public List<User> getAllUser();
    public void saveUser(User user);
    public User findUser(String username,String password);
    public List<User> findUser(String hql);
}
