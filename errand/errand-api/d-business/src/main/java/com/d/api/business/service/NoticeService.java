package com.d.api.business.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.d.api.common.model.SuperService;
import com.d.api.business.entity.NoticeEntity;

/**
 * 公告
 *
 * @author dd dscccl@163.com
 * @since 1.0.0 2021-03-22
 */
public interface NoticeService extends SuperService<NoticeEntity> {

    /**
     *
     * @param page 1
     * @param noticeEntity 1
     * @return 1
     */
    IPage<NoticeEntity> page(Page<NoticeEntity> page, NoticeEntity noticeEntity);

}