package org.jypj.dev.base;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * 公共service实现
 * @author yu_chen
 * @create 2017-12-01 17:21
 **/
public class BaseServiceImpl<M extends BaseDao<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {

}
