package com.shiguang.jiancha.dao;

import com.shiguang.jiancha.domain.ResultDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 检查结论表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-12 17:47:08
 */
@Mapper
public interface ResultDao {

	ResultDO get(Long id);
	
	List<ResultDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ResultDO result);
	
	int update(ResultDO result);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
