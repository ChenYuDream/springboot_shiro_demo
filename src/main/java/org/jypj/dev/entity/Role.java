package org.jypj.dev.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yu_chen
 * @create 2017-12-01 16:59
 **/
@Data
@TableName("role")
public class Role {

    @TableId
    @TableField("rid")
    private Integer id;
    private String rname;
    private Set<User> users = new HashSet<>();
    private Set<Module> modules = new HashSet<>();
}
