package com.shiguang.product.dao;

import com.shiguang.product.domain.CylDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 柱镜表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 09:53:22
 */
@Mapper
public interface CylDao {

	CylDO get(Long cylId);
	
	List<CylDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(CylDO cyl);
	
	int update(CylDO cyl);
	
	int remove(Long cyl_id);
	
	int batchRemove(Long[] cylIds);
}
