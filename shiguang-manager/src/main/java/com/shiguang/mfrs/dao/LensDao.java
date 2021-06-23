package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.LensDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 材料分类表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-21 15:08:08
 */
@Mapper
public interface LensDao {

	LensDO get(Integer lensId);
	
	List<LensDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(LensDO lens);
	
	int update(LensDO lens);
	
	int remove(Integer lens_id);
	
	int batchRemove(Integer[] lensIds);
}
