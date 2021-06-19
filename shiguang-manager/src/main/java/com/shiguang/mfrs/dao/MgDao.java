package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.MgDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 制造商商品类别表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-17 17:52:47
 */
@Mapper
public interface MgDao {

	MgDO get(Integer id);
	
	List<MgDO> list(Map<String,Object> map);
	List<MgDO> mglist(Map<String,Object> map);

	int count(Map<String,Object> map);
	
	int save(MgDO mg);
	
	int update(MgDO mg);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
