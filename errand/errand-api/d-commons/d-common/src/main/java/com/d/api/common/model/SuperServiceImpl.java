package com.d.api.common.model;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author dsscccc
 * @Description
 *
 * Service父类 方便后面实现一些公共的方法
 * @date 2020/11/3 10:12
 */
public class SuperServiceImpl <M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements SuperService<T> {
}
