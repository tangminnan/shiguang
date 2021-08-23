package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.CitiesDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 行政区域地州市信息表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-08-20 17:25:32
 */
@Mapper
public interface CitiesDao {

	CitiesDO get(Integer id);
	
	List<CitiesDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(CitiesDO cities);
	
	int update(CitiesDO cities);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
