package org.jypj.dev.service.impl;

import org.jypj.dev.base.BaseServiceImpl;
import org.jypj.dev.dao.UserDao;
import org.jypj.dev.entity.User;
import org.jypj.dev.service.UserService;

/**
 * @author yu_chen
 * @create 2017-12-01 17:13
 **/
public class UserServiceImpl extends BaseServiceImpl<UserDao, User> implements UserService {


    @Override
    public User findUserByUserName(String userName) {
        return null;
    }
}
