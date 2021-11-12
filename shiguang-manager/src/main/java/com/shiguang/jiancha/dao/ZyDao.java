package com.shiguang.jiancha.dao;

import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.ZyDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 框架中用表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 11:50:32
 */
@Mapper
public interface ZyDao {

	ZyDO get(Long zyId);
	
	List<ZyDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ZyDO zy);
	int saveZY(ResultDO result);
	//    是否有保存这个验光号数据
	List<ResultDO> haveYanguangNum(Map<String, Object> map);
	int update(ResultDO result);
	int remove(Long zy_id);
	int upremove(ZyDO zyDO);
	int updatezy(ZyDO zyDO);
	int batchRemove(Long[] zyIds);

	ZyDO chufangall(@Param("ptometryNumber") String ptometryNumber, @Param("status") String status);
}
