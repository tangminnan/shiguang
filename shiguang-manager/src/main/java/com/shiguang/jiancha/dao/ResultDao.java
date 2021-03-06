package com.shiguang.jiancha.dao;

import com.shiguang.jiancha.domain.ResultDO;

import java.util.List;
import java.util.Map;

import com.shiguang.jiancha.domain.ResultDetailDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 检查结论表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-16 15:03:42
 */
@Mapper
public interface ResultDao {

	ResultDO get(Long id);
	
	List<ResultDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ResultDO result);
	List<ResultDO> haveYanguangNum(Map<String, Object> map);
	int update(ResultDO result);
	int remove(Long id);
	int upremove(ResultDO resultDO );
	
	int batchRemove(Long[] ids);

	List<ResultDO> shujulist(Map<String, Object> map);
	int shujulistcount(Map<String, Object> map);
	ResultDO getChufangAll(Map<String, Object> map);
	ResultDetailDO getresult(Map<String, Object> map);
}
