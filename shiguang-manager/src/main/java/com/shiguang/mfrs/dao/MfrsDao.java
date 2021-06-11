package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.MfrsDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 制造商维护表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-10 11:33:55
 */
@Mapper
public interface MfrsDao {

	MfrsDO get(Integer mfrsid);
	
	List<MfrsDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(MfrsDO mfrs);
	
	int update(MfrsDO mfrs);
	
	int remove(Integer mfrsid);
	
	int batchRemove(Integer[] mfrsids);
}
