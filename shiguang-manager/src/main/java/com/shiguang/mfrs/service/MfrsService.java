package com.shiguang.mfrs.service;

import com.shiguang.mfrs.domain.MfrsDO;

import java.util.List;
import java.util.Map;

/**
 * 制造商维护表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 11:19:50
 */
public interface MfrsService {
	
	MfrsDO get(Integer mfrsid);
	
	List<MfrsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MfrsDO mfrs);
	
	int update(MfrsDO mfrs);
	
	int remove(Integer mfrsid);
	
	int batchRemove(Integer[] mfrsids);
}