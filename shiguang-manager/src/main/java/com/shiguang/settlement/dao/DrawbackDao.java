package com.shiguang.settlement.dao;


import java.util.List;
import java.util.Map;

import com.shiguang.member.domain.MemberDO;
import com.shiguang.settlement.domain.DrawbackDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-08-24 16:40:11
 */
@Mapper
public interface DrawbackDao {

	DrawbackDO get(Long id);
	
	List<DrawbackDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DrawbackDO drawback);
	
	int update(DrawbackDO drawback);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	List<MemberDO> memberList(Map<String,Object> map);

	int memberCount(Map<String,Object> map);

	List<MemberDO> memberJcList(Map<String,Object> map);

	int memberJcCount(Map<String,Object> map);
}
