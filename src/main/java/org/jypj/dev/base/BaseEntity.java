package org.jypj.dev.base;

import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 公共的entity
 *
 * @author yu_chen
 * @create 2017-12-01 17:15
 **/
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -7011380914185428110L;

    /**
     * 主键ID
     */
    @TableId
    private String id;
}
