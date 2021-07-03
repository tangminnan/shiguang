package com.shiguang.jiancha.service;

import com.shiguang.jiancha.domain.SubjectiveDO;

import java.util.List;
import java.util.Map;

/**
 * 主观验光表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-03 17:10:26
 */
public interface SubjectiveService {
	
	SubjectiveDO get(Long id);
	
	List<SubjectiveDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SubjectiveDO subjective);
	
	int update(SubjectiveDO subjective);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
