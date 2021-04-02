package com.d.api.business.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.d.api.common.model.R;
import com.d.api.common.model.SuperController;
import com.d.api.business.entity.NoticeEntity;
import com.d.api.business.form.notice.NoticeAddForm;
import com.d.api.business.form.notice.NoticeQueryForm;
import com.d.api.business.form.notice.NoticeUpdateForm;
import com.d.api.business.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * 公告
 *
 * @author dd dscccl@163.com
 * @since 1.0.0 2021-03-22
 */
@Api(tags = "公告")
@RestController
@RequestMapping("notice")
public class NoticeController extends SuperController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @ApiOperation(value = "列表分页", httpMethod = "GET")
    @ApiImplicitParam(name = "noticeQueryForm", value = "公告信息", paramType = "query", dataType = "NoticeQueryForm")
    @GetMapping("page1")
    public R<IPage<NoticeEntity>> page1(NoticeQueryForm noticeQueryForm) {
        IPage<NoticeEntity> page = noticeService.page(noticeQueryForm.makePaging());
        return R.succeed(page);
    }

    @ApiOperation(value = "列表分页", httpMethod = "GET")
    @ApiImplicitParam(name = "noticeQueryForm", value = "公告信息", paramType = "query", dataType = "NoticeQueryForm")
    @GetMapping("page2")
    public R<IPage<NoticeEntity>> page2(NoticeQueryForm noticeQueryForm) {
        NoticeEntity noticeEntity = new NoticeEntity();
        BeanUtils.copyProperties(noticeQueryForm, noticeEntity);
        IPage<NoticeEntity> page = noticeService.page(noticeQueryForm.makePaging(),noticeEntity);
        return R.succeed(page);
    }

    @ApiOperation(value = "信息详情", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "信息", paramType = "path", dataType = "Long")
    @GetMapping("{id}")
    public R<NoticeEntity> getInfo(@PathVariable("id") Long id) {
        NoticeEntity noticeEntity = noticeService.getById(id);
        return R.succeed(noticeEntity);
    }

    @ApiOperation(value = "新增信息",httpMethod = "POST")
    @ApiImplicitParam(name = "noticeAddForm", value = "信息", paramType = "body", dataType = "NoticeAddForm")
    @PostMapping
    public R add(@Valid @RequestBody NoticeAddForm noticeAddForm, BindingResult bindingResult){
        super.paramsValidate(noticeAddForm, bindingResult);
        NoticeEntity noticeEntity = new NoticeEntity();
        BeanUtils.copyProperties(noticeAddForm,noticeEntity);
        noticeService.save(noticeEntity);
        return R.succeed("OK");
    }

    @ApiOperation(value = "修改信息",httpMethod = "PUT")
    @ApiImplicitParam(name = "noticeUpdateForm", value = "信息", paramType = "body", dataType = "NoticeUpdateForm")
    @PutMapping
    public R update(@Valid @RequestBody NoticeUpdateForm noticeUpdateForm, BindingResult bindingResult){
        super.paramsValidate(noticeUpdateForm, bindingResult);
        NoticeEntity noticeEntity = new NoticeEntity();
        BeanUtils.copyProperties(noticeUpdateForm,noticeEntity);
        noticeService.updateById(noticeEntity);
        return R.succeed("OK");
    }

    @ApiOperation(value = "删除信息", httpMethod = "DELETE")
    @ApiImplicitParam(name = "ids", value = "ids", paramType = "query", dataType = "array")
    @DeleteMapping
    public R save(@RequestBody List<Long> ids) {
        noticeService.removeByIds(ids);
        return R.succeed("");
    }

}