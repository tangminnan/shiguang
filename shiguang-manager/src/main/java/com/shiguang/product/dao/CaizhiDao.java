package com.shiguang.product.dao;

import com.shiguang.product.domain.CaizhiDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 材质表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 09:53:22
 */
@Mapper
public interface CaizhiDao {

	CaizhiDO get(Long caizhiId);
	
	List<CaizhiDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(CaizhiDO caizhi);
	
	int update(CaizhiDO caizhi);
	
	int remove(Long caizhi_id);
	
	int batchRemove(Long[] caizhiIds);
}
