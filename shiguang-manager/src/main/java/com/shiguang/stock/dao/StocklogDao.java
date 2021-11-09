package com.shiguang.stock.dao;

import com.shiguang.stock.domain.StocklogDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * kucunlog

 * @author cln
 * @email bushuo@163.com
 * @date 2021-11-08 14:58:43
 */
@Mapper
public interface StocklogDao {

	StocklogDO get(Long id);
	
	List<StocklogDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(StocklogDO stocklog);
	
	int update(StocklogDO stocklog);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
