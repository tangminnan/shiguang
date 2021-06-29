package com.shiguang.product.dao;

import com.shiguang.product.domain.MbDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 制造商品牌关联表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-28 13:49:46
 */
@Mapper
public interface MbDao {

	MbDO get(Integer id);
	
	List<MbDO> list(Map<String,Object> map);

	int count(Map<String,Object> map);
	
	int save(MbDO mb);
	
	int update(MbDO mb);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
