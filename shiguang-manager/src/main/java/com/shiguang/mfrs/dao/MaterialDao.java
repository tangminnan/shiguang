package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.MaterialDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 镜架材质表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-10 15:41:15
 */
@Mapper
public interface MaterialDao {

	MaterialDO get(Integer materialid);
	
	List<MaterialDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(MaterialDO material);
	
	int update(MaterialDO material);
	
	int remove(Integer materialid);
	
	int batchRemove(Integer[] materialids);
}
