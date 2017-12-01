package org.jypj.dev.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户
 *
 * @author yu_chen
 * @create 2017-12-01 16:58
 **/
@Data
@TableName("user")
public class User {

    private Integer uid;
    private String username;
    private String password;
    private Set<Role> roles = new HashSet<>();
}
