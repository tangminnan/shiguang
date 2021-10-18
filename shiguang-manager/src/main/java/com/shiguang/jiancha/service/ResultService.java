package com.shiguang.jiancha.service;

import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.TryresultsDO;

import java.util.List;
import java.util.Map;

/**
 * 检查结论表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-16 15:03:42
 */
public interface ResultService {
	
	ResultDO get(Long id);
	
	List<ResultDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ResultDO result);
	//    是否有保存这个验光号数据
	List<ResultDO> haveYanguangNum(Map<String, Object> map);
	int update(ResultDO result);
	int remove(Long id);
	int upremove(ResultDO resultDO );
	
	int batchRemove(Long[] ids);

	List<ResultDO> shujulist(Map<String, Object> map);
	int shujulistcount(Map<String, Object> map);
	//所有处方
	ResultDO getChufangAll(Map<String, Object> map);

}
