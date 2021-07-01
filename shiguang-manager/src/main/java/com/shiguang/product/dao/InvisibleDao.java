package com.shiguang.product.dao;

import com.shiguang.product.domain.InvisibleDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 隐形类别表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 09:53:22
 */
@Mapper
public interface InvisibleDao {

	InvisibleDO get(Long invisibleId);
	
	List<InvisibleDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(InvisibleDO invisible);
	
	int update(InvisibleDO invisible);
	
	int remove(Long invisible_id);
	
	int batchRemove(Long[] invisibleIds);
}
