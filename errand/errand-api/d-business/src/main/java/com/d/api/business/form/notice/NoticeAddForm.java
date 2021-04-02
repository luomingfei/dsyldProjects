package com.d.api.business.form.notice;

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
public class NoticeAddForm implements Serializable {

    private static final long serialVersionUID = -6961330611210087023L;

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
