package com.shiguang.product.dao;

import com.shiguang.product.domain.SphDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 球镜表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 09:53:22
 */
@Mapper
public interface SphDao {

	SphDO get(Long sphId);
	
	List<SphDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SphDO sph);
	
	int update(SphDO sph);
	
	int remove(Long sph_id);
	
	int batchRemove(Long[] sphIds);
}
