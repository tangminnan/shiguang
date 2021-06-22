package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.TypeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 抛弃型分类表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-21 15:08:08
 */
@Mapper
public interface TypeDao {

	TypeDO get(Integer typeId);
	
	List<TypeDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TypeDO type);
	
	int update(TypeDO type);
	
	int remove(Integer type_id);
	
	int batchRemove(Integer[] typeIds);
}
