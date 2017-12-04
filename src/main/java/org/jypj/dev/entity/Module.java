package org.jypj.dev.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yu_chen
 * @create 2017-12-01 17:00
 **/
@Data
@TableName("module")
public class Module {

    @TableId
    @TableField("mid")
    private Integer id;
    private String mname;
    private Set<Role> roles = new HashSet<>();
}
