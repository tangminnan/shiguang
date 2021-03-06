package com.shiguang.line.service;


import com.shiguang.line.domain.LineDO;

import java.util.List;
import java.util.Map;

/**
 * ๆ้ๅ่กจ
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-15 14:09:10
 */
public interface LineService {
	
	LineDO get(Long id);
	
	List<LineDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(LineDO line);
	
	int update(LineDO line);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	int updateByMember(LineDO lineDO);

	List<LineDO> lineList(Map<String,Object> map);

	int removeMember(LineDO lineDO);

	Map<String,Object> callList(Map<String,Object> map);

	List<LineDO> newList(Map<String, Object> map);

	List<LineDO> oldList(Map<String, Object> map);

}
