package org.jypj.dev.service.impl;

import org.jypj.dev.base.BaseServiceImpl;
import org.jypj.dev.dao.UserMapper;
import org.jypj.dev.entity.User;
import org.jypj.dev.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yu_chen
 * @create 2017-12-01 17:13
 **/
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findUserByUserName(String userName) {


        return userMapper.findByUserName(userName);
    }
}
