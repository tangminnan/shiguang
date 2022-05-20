package com.shiguang.call.dao;


import java.util.List;
import java.util.Map;

import com.shiguang.call.domain.YxDO;
import com.shiguang.call.domain.YxLineDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 隐形呼叫
 * @author wjl
 * @email bushuo@163.com
 * @date 2022-05-17 10:29:34
 */
@Mapper
public interface YxDao {

	YxDO get(Long id);
	
	List<YxDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(YxDO yx);
	
	int update(YxDO yx);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	List<YxLineDO> yxlinelist(Map<String,Object> map);

	int yxlinecount(Map<String,Object> map);

	int yxlinesave(YxLineDO yxLineDO);

	YxLineDO getYxLine(Long id);
}
