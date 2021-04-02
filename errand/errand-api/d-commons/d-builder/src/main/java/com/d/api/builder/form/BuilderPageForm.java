package com.d.api.builder.form;

import com.d.api.common.model.SuperPageQueryBean;
import lombok.Data;

import java.io.Serializable;

/**
 * @author dsscccc
 * @Description
 * @date 2020/12/8 17:24
 */
@Data
public class BuilderPageForm extends SuperPageQueryBean implements Serializable {

    private static final long serialVersionUID = 3434121571462273808L;

    private String tableName;

}
