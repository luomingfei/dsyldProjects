package com.d.api.business.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 公告
 *
 * @author dd dscccl@163.com
 * @since 1.0.0 2021-03-22
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("errand_notice")
public class NoticeEntity { //extends SuperEntity
	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;
    /**
     * 标题
     */
	private String title;
    /**
     * 内容
     */
	private String content;
    /**
     * 是否显示 0-否 1-是
     */
	private Integer isDisplay;
}