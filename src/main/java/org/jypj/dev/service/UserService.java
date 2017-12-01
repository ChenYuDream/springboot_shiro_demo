package org.jypj.dev.service;

import org.jypj.dev.base.BaseService;
import org.jypj.dev.entity.User;

/**
 * @author yu_chen
 * @create 2017-12-01 17:13
 **/
public interface UserService extends BaseService<User> {

    /**
     * 根据用户名查找用户详细信息
     *
     * @param userName
     * @return
     */
    User findUserByUserName(String userName);
}
