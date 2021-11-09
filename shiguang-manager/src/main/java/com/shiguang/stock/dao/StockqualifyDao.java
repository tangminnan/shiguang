package com.shiguang.stock.dao;

import com.shiguang.stock.domain.StockqualifyDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 合格仓表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-11-09 09:23:30
 */
@Mapper
public interface StockqualifyDao {

	StockqualifyDO get(Long id);
	
	List<StockqualifyDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(StockqualifyDO stockqualify);
	
	int update(StockqualifyDO stockqualify);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
