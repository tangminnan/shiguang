package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.ProvincesDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 省份信息表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-15 17:18:59
 */
@Mapper
public interface ProvincesDao {

	ProvincesDO get(Integer id);
	
	List<ProvincesDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ProvincesDO provinces);
	
	int update(ProvincesDO provinces);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
