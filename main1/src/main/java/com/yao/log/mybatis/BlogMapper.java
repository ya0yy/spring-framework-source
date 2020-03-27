package com.yao.log.mybatis;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 2020-03-26 01:22
 *
 * @author yaoyy
 */
public interface BlogMapper {

	@Select("select * from spring_log")
	List<Map<String, String>> selectList();
}
