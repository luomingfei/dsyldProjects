package com.d.api.common.oss.result;

import lombok.Data;

/**
 *
 *
 * @author dd dscccl@163.com
 * @since 1.0.0 2020-12-13
 */
@Data
public class UploadPicResult {

    private static final long serialVersionUID = 8207956349411006854L;

    /**
     * 资源路径
     */
    private String url;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 排序
     */
    private Integer sort;

}
