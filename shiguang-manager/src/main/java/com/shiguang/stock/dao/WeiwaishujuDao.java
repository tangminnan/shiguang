package com.shiguang.stock.dao;

import com.shiguang.stock.domain.WeiwaishujuDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-18 18:14:35
 */
@Mapper
public interface WeiwaishujuDao {

	WeiwaishujuDO get(Long id);
	
	List<WeiwaishujuDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(WeiwaishujuDO weiwaishuju);
	
	int update(WeiwaishujuDO weiwaishuju);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	//得到委外数据
	List<WeiwaishujuDO> getWeiwaiShuju(Map<String, Object> map);
}
