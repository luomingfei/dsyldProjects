package com.d.api.common.model;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * 分页父类
 */
@Data
public class SuperPageQueryBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String currentPage = "1";
    private String pageSize = "10";
    private String sort = "";
    private String order = "asc";

    public Page makePaging() {
        Page paging = new Page();
        if (!StringUtils.isEmpty(currentPage)) {
            paging.setCurrent(Integer.valueOf(currentPage));
        }
        if (!StringUtils.isEmpty(pageSize)) {
            paging.setSize(Integer.valueOf(pageSize));
        }
        if (!StringUtils.isEmpty(sort)) {
            if (!StringUtils.isEmpty(order)) {
                if (order.equalsIgnoreCase("true") || order.equalsIgnoreCase("asc")) {
                    paging.setAsc(sort);
                } else {
                    paging.setDesc(sort);
                }
            } else {
                paging.setAsc(sort);
            }
        }
        return paging;
    }

}
