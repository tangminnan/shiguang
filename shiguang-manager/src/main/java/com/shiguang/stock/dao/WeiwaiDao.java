package com.shiguang.stock.dao;

import com.shiguang.stock.domain.WeiwaiDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 委外表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-09-14 16:17:31
 */
@Mapper
public interface WeiwaiDao {

	WeiwaiDO get(Long id);
	
	List<WeiwaiDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(WeiwaiDO weiwai);
	
	int update(WeiwaiDO weiwai);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	List<WeiwaiDO> weiwailist(Map<String, Object> map);
	int countList(Map<String, Object> map);

}
