package com.shiguang.stock.dao;

import com.shiguang.stock.domain.WeiwaiDO;
import com.shiguang.stock.domain.WeiwaikcDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-09-30 01:34:01
 */
@Mapper
public interface WeiwaikcDao {

	WeiwaikcDO get(Long id);
	
	List<WeiwaikcDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(WeiwaikcDO weiwaikc);
	
	int update(WeiwaikcDO weiwaikc);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	//确认收货
	int updateStatus(WeiwaikcDO weiwaikcDO);
}
