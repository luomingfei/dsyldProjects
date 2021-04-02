package com.d.api.common.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author dsccc
 * @date 2020年11月3日
 * @param <T> 实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SuperEntity<T extends Model<?>> extends Model<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "delete_flag", fill = FieldFill.INSERT)
    private LocalDateTime deleteFlag;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }

}