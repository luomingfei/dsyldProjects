package com.d.api.db.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author dsccc
 * 自动填充
 */
@Component
public class InitMetaObjectHandler implements MetaObjectHandler {

    private final static String CREATE_TIME = "createTime";
    private final static String UPDATE_TIME = "updateTime";
    private final static String DELETE_FLAG = "deleteFlag";
    private static final Long DELETE_FLAG_FALSE = new Long("0");

    @Override
    public void insertFill(MetaObject metaObject) {
        LocalDateTime now = LocalDateTime.now();
        setFieldValByName(CREATE_TIME, now, metaObject);
        setFieldValByName(UPDATE_TIME, now, metaObject);
        setFieldValByName(DELETE_FLAG, DELETE_FLAG_FALSE, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName(UPDATE_TIME, LocalDateTime.now(), metaObject);
    }

}
