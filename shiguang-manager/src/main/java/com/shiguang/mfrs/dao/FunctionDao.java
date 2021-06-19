package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.FunctionDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 镜片功能表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-17 10:40:35
 */
@Mapper
public interface FunctionDao {

	FunctionDO get(Integer id);
	
	List<FunctionDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(FunctionDO function);
	
	int update(FunctionDO function);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
