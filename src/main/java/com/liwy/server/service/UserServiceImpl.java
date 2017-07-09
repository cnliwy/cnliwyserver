package com.liwy.server.service;

import com.liwy.server.dao.UserDao;
import com.liwy.server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2017/7/8.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    public List<User> getAllUser() {
        return userDao.find("from User");
    }

    public void saveUser(User user) {
        Serializable serializable = userDao.save(user);
    }

    public User findUser(String username,String password) {
        User user = userDao.get("from User where username='" + username + "' and password='"+password + "'");
        return user;
    }

    public List<User> findUser(String hql) {
        List<User> users = userDao.find(hql);
        return users;
    }
}
