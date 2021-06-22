package com.shiguang.mfrs.service;

import com.shiguang.mfrs.domain.LensDO;

import java.util.List;
import java.util.Map;

/**
 * 材料分类表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-21 15:08:08
 */
public interface LensService {
	
	LensDO get(Integer lensId);
	
	List<LensDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LensDO lens);
	
	int update(LensDO lens);
	
	int remove(Integer lensId);
	
	int batchRemove(Integer[] lensIds);
}
