package com.d.api.builder.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.d.api.builder.form.BuilderPageForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * MySQL代码生成器
 *
 * @author dsccc
 */
@Mapper
public interface BuilderDao {

    Page<Map<String, Object>> queryList(IPage page, @Param("builderPageForm") BuilderPageForm builderPageForm);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);
	

}
