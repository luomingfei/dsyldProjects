package com.d.api.business.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.d.api.common.model.SuperServiceImpl;
import com.d.api.business.mapper.NoticeMapper;
import com.d.api.business.entity.NoticeEntity;
import com.d.api.business.service.NoticeService;
import org.springframework.stereotype.Service;

/**
 * 公告
 *
 * @author dd dscccl@163.com
 * @since 1.0.0 2021-03-22
 */
@Service
public class NoticeServiceImpl extends SuperServiceImpl<NoticeMapper, NoticeEntity> implements NoticeService {

    @Override
    public IPage<NoticeEntity> page(Page<NoticeEntity> page, NoticeEntity noticeEntity) {
        return this.baseMapper.getPageList(page,noticeEntity);
    }


}