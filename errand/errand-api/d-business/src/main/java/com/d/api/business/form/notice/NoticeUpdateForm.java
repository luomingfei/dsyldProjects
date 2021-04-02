package com.d.api.business.form.notice;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @className: NoticeQueryForm
 * @description: TODO 类描述
 * @author: dssccc
 * @date: 2021/3/22  13:45
 **/
@Data
public class NoticeUpdateForm implements Serializable {

    private static final long serialVersionUID = 1113148164741638688L;

    @ApiModelProperty(value = "主键")
    @NotNull(message="主键不能为空")
    private Long id;
    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空")
    private String title;
    /**
     * 内容
     */
    @NotBlank(message = "内容不能为空")
    private String content;
    /**
     * 是否显示 0-否 1-是
     */
    @NotNull(message = "不能为空")
    private Integer isDisplay;

}
