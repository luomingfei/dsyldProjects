package com.d.api.builder.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.d.api.builder.form.BuilderPageForm;
import com.d.api.builder.service.BuilderService;
import com.d.api.common.model.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 代码生成器
 * 
 * @author dsccc
 */
@Api(tags = "代码生成器")
@Controller
@RequestMapping("/builder")
public class BuilderController {
	private final BuilderService sysGeneratorService;

	public BuilderController(BuilderService sysGeneratorService) {
		this.sysGeneratorService = sysGeneratorService;
	}

	/**
	 * 列表
	 */
	@RequestMapping("/page")
	@ResponseBody
	@ApiOperation(value = "表信息分页", httpMethod = "GET")
	public R list(BuilderPageForm builderPageForm){
		Page<Map<String, Object>> iPage = sysGeneratorService.queryList(builderPageForm.makePaging(),builderPageForm);
		return R.succeed(iPage);
	}
	
	/**
	 * 生成代码
	 */
	@RequestMapping("/code")
	@ApiOperation(value = "生成代码", httpMethod = "GET")
	public void code(String tables, HttpServletResponse response) throws IOException{
		byte[] data = sysGeneratorService.generatorCode(tables.split(","));
		
		response.reset();  
        response.setHeader("Content-Disposition", "attachment; filename=\"d.zip\"");
        response.addHeader("Content-Length", "" + data.length);  
        response.setContentType("application/octet-stream; charset=UTF-8");  
  
        IOUtils.write(data, response.getOutputStream());  
	}

}
