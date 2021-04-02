package com.d.api.business.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.d.api.common.model.SuperMapper;
import com.d.api.business.entity.NoticeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 公告
 *
 * @author dd dscccl@163.com
 * @since 1.0.0 2021-03-22
 */
@Mapper
public interface NoticeMapper extends SuperMapper<NoticeEntity> {


    IPage<NoticeEntity> getPageList(Page<NoticeEntity> page, @Param("noticeEntity") NoticeEntity noticeEntity);

	
}