package com.shiguang.jiancha.dao;

import com.shiguang.jiancha.domain.TryresultsDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 试戴镜结果表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-13 09:26:46
 */
@Mapper
public interface TryresultsDao {

	TryresultsDO get(Long id);
	
	List<TryresultsDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TryresultsDO tryresults);
	
	int update(TryresultsDO tryresults);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
