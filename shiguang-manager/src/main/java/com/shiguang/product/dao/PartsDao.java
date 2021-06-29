package com.shiguang.product.dao;

import com.shiguang.product.domain.PartsDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 配件表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 18:06:25
 */
@Mapper
public interface PartsDao {

	PartsDO get(Long id);
	
	List<PartsDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(PartsDO parts);
	
	int update(PartsDO parts);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
