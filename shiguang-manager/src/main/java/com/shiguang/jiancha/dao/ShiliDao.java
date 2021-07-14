package com.shiguang.jiancha.dao;

import com.shiguang.jiancha.domain.ShiliDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-09 10:22:52
 */
@Mapper
public interface ShiliDao {

	ShiliDO get(Long id);
	
	List<ShiliDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ShiliDO shili);
	
	int update(ShiliDO shili);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
