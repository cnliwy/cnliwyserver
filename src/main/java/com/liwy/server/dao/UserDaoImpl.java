package com.liwy.server.dao;

import com.liwy.server.dao.base.BaseDaoImpl;
import com.liwy.server.dao.idao.UserDao;
import com.liwy.server.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2017/7/8.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

}
