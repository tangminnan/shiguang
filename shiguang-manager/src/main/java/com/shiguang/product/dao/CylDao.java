package com.shiguang.product.dao;

import com.shiguang.product.domain.CylDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 柱镜表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 17:26:17
 */
@Mapper
public interface CylDao {

	CylDO get(Integer id);
	
	List<CylDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(CylDO cyl);
	
	int update(CylDO cyl);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
