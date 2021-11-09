package com.shiguang.stock.dao;

import com.shiguang.stock.domain.StockunqualifyDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 不合格仓表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-11-09 09:23:30
 */
@Mapper
public interface StockunqualifyDao {

	StockunqualifyDO get(Long id);
	
	List<StockunqualifyDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(StockunqualifyDO stockunqualify);
	
	int update(StockunqualifyDO stockunqualify);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
