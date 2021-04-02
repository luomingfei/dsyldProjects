package com.d.api.business.form.notice;

import com.d.api.common.model.SuperPageQueryBean;
import lombok.Data;

import java.io.Serializable;

/**
 * @className: NoticeQueryForm
 * @description: TODO 类描述
 * @author: dssccc
 * @date: 2021/3/22  13:45
 **/
@Data
public class NoticeQueryForm extends SuperPageQueryBean implements Serializable {

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
