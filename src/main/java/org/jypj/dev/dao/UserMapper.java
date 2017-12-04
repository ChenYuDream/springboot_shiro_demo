package org.jypj.dev.dao;

import org.apache.ibatis.annotations.Param;
import org.jypj.dev.base.BaseMapper;
import org.jypj.dev.entity.User;

/**
 * 用户Dao
 *
 * @author yu_chen
 * @create 2017-12-01 17:07
 **/
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名查询用户
     *
     * @param userName 用户名
     * @return User
     */
    User findByUserName(@Param("username") String userName);
}
